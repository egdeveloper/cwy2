package org.egdeveloper.service.statistics;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.math3.stat.Frequency;
import org.egdeveloper.attributes.*;
import org.egdeveloper.data.entities.*;
import org.egdeveloper.data.entities.customTypes.StoneXRay;
import org.egdeveloper.data.entities.customTypes.TreatmentNumber;
import org.egdeveloper.service.data.IDoctorService;
import org.egdeveloper.service.data.IPatientService;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collectors;

@Service("statService")
@Transactional
public class StatService implements IStatService {

    @Autowired
    @Qualifier("doctorService")
    IDoctorService doctorService;

    @Autowired
    @Qualifier("patientService")
    IPatientService patientService;

    private Map<Class, Pair<Method, Method[]>> indGetters = new HashMap<>();
    private Map<Class, List<Field>> indFields = new HashMap<>();
    private Map<String, Field> testsGetters = new HashMap<>();

    public StatService(){
        Method[] testGetters = getMethodsAnnotatedBy(Patient.class, MedTest.class);
        for(Method testGetter : testGetters){
            Class testClazz = innerGenericType(testGetter);
            indGetters.put(testClazz, new Pair<>(testGetter, indicatorsGetters(testClazz)));
        }
        for(Field testField : Arrays.asList(Patient.class.getDeclaredFields()).stream()
                .filter(f -> f.isAnnotationPresent(MedTest.class))
                .collect(Collectors.toList()))
        {
            testField.setAccessible(true);
            Class<? extends MedicalTest> testClazz = (Class<? extends MedicalTest>) (((ParameterizedType)testField.getGenericType())
                    .getActualTypeArguments()[0]);
            testsGetters.put(testClazz.getAnnotation(EntityID.class).value(), testField);
            indFields.put(testClazz, testIndicators(testClazz));
        }
    }

    @Override
    @Cacheable(cacheNames = "beforeTreatmentStatCache")
    public Map<Object, Object> beforeTreatmentStat() {
        List<Patient> patients = patientService.getPatients();
        Map<Object, Object> statData = new HashMap<>();
        Frequency ageStat = new Frequency();
        Frequency durationStat = new Frequency();
        Frequency genderStat = new Frequency();
        Frequency regionStat = new Frequency();
        Frequency badHabitsStat = new Frequency();
        LocalDate now = LocalDate.now();
        patients.forEach(p -> {
            //age statistics
            Years age = Years.yearsBetween(p.getBirthdate(), now);
            ageStat.addValue((age.getYears() / 10) * 10);
            //duration statistics
            durationStat.addValue(p.getDiseaseDuration());
            //gender statistics
            genderStat.addValue(p.getGender().gender2String());
            regionStat.addValue(p.getRegion().trim());
            badHabitsStat.addValue(p.getBadHabits().trim());
        });
        statData.put("volume", patients.size());
        statData.put("age", frequency2Map(ageStat));
        statData.put("duration", frequency2Map(durationStat));
        statData.put("gender", frequency2Map(genderStat));
        statData.put("region", frequency2Map(regionStat));
        statData.put("badHabits", frequency2Map(badHabitsStat));
        return statData;
    }

    @Override
    public Map<Object, Object> indicatorsDynamics(Integer patientId) throws IllegalAccessException, InvocationTargetException {
        Map<Object, Object> indicatorsStat = new HashMap<>();

        //Get patient by id
        Patient patient = patientService.getPatientById(patientId);

        for(Class testClass : indGetters.keySet()){
            Map<String, Map<LocalDate, Double>> indicators = new HashMap<>();
            Set<MedicalTest> tests = (Set<MedicalTest>)indGetters.get(testClass).getKey().invoke(patient);
            for(Method indGetter : indGetters.get(testClass).getValue()){
                Map<LocalDate, Double> indicatorSamples = new HashMap<>();
                for(MedicalTest test : tests){
                    indicatorSamples.put(test.getTestDate(), (Double) indGetter.invoke(test));
                }
                indicators.put(indGetter.getAnnotation(DisplayName.class).value(), indicatorSamples);
            }
            //indicatorsStat.put(((DisplayName)testClass.getAnnotation(DisplayName.class)).value(), indicators);
            indicatorsStat.put(((EntityID)testClass.getAnnotation(EntityID.class)).value(), indicators);
        }
        return indicatorsStat;
    }

    @Override
    public Map<Object, Object> indicatorDeviationsForStoneTypesStat(TreatmentNumber treatmentNumber) {
        Map<Object, Object> indicatorDeviations = new HashMap<>();
        /*
        List<Patient> patients = patientService.getPatients();
        for(StoneXRay stoneXRay : StoneXRay.values()){
            Map<Object, Object> stoneXRayStat = new HashMap<>();
            stoneXRayStat.put("stoneType", stoneXRay.stoneXray2String());

        }
        */
        return indicatorDeviations;
    }

    @Override
    public <T extends MedicalTest> Map<Object, Object> indicatorDeviationsForStoneTypesStat(Class<T> testClazz, TreatmentNumber treatmentNumber) throws IllegalAccessException{
        Map<Object, Object> indicatorDeviations = new HashMap<>();
        List<MedicalTest> tests = patientService.retrieveMedicalTestsByType((Class<MedicalTest>) testClazz)
                .stream()
                .filter(t -> t.getTreatmentNumber().equals(treatmentNumber))
                .collect(Collectors.toList());
        for(StoneXRay stoneXRay : StoneXRay.values()){
            List<MedicalTest> testWithDefStone = tests.stream()
                    .filter(t -> t.getPatient()
                            .getStoneInVitroTests()
                            .stream().filter(st -> st.getXray().equals(stoneXRay) && st.getTreatmentNumber().equals(treatmentNumber))
                            .findFirst().isPresent())
                    .collect(Collectors.toList());
            Map<String, Map<String, Integer>> indicatosStat = retrieveTestDeviations((Class<MedicalTest>)testClazz, testWithDefStone, treatmentNumber);
            Map<Object, Object> testStat = new HashMap<>();
            testStat.put("name", testClazz.getAnnotation(DisplayName.class).value());
            testStat.put("volume", indicatosStat.size());
            testStat.put("indicators", indicatosStat);
            Map<Object, Object> stoneStat = new HashMap<>();
            stoneStat.put("stoneType", stoneXRay.stoneXray2String());
            stoneStat.put(testClazz.getAnnotation(EntityID.class).value(), testStat);
            indicatorDeviations.put(stoneXRay.toString(), stoneStat);
        }
        return indicatorDeviations;
    }

    @Override
    public Map<Object, Object> indicatorDeviations(TreatmentNumber treatmentNumber) throws IllegalAccessException {
        Map<Object, Object> deviations = new HashMap<>();
        for(Class testClazz : indFields.keySet()){
            Map<Object, Object> test = new HashMap<>();
            test.put("name", ((DisplayName)testClazz.getAnnotation(DisplayName.class)).value());
            Map<String, Map<String, Integer>> indicators = indicatorDeviations(testClazz, treatmentNumber);
            test.put("volume", indicators.size());
            test.put("indicators", indicators);
            deviations.put(((EntityID)testClazz.getAnnotation(EntityID.class)).value(), test);
        }
        return deviations;
    }

    @Override
    public <T extends MedicalTest> Map<String, Map<String, Integer>> indicatorDeviations(Class<T> testClazz, TreatmentNumber treatmentNumber) throws IllegalAccessException{
        List<T> tests = patientService.retrieveMedicalTestsByType(testClazz);
        return retrieveTestDeviations(testClazz, tests, treatmentNumber);
    }

    // TODO: not implemented stoneComponentsStat()
    @Override
    public Map stoneComponentsStat(TreatmentNumber treatmentNumber) {
        throw new NotImplementedException("Not implemented method!");
    }

    //Utility functions

    private <T extends MedicalTest> Map<String, Map<String, Integer>> retrieveTestDeviations(Class<T> testClazz, List<T> tests, TreatmentNumber treatmentNumber) throws IllegalAccessException{
        Map<String, Map<String, Integer>> deviations = new HashMap<>();
        tests = tests.stream()
                .parallel()
                .filter(t -> t.getTreatmentNumber().equals(treatmentNumber))
                .collect(Collectors.toList());
        List<Field> inds = indFields.get(testClazz);
        for(T test : tests){
            for(Field indicator : inds){
                String indName = indicator.getAnnotation(DisplayName.class).value();
                if(!deviations.containsKey(indName)){
                    Map<String, Integer> indStat = new HashMap<>();
                    indStat.put("volume", 0);
                    indStat.put("deviations", 0);
                    deviations.put(indName, indStat);
                }
                Map<String, Integer> indStat = deviations.get(indName);
                int volumeCount = indStat.get("volume");
                if(indicator.get(test) != null)
                    volumeCount++;
                int deviationsCount = indStat.get("deviations");
                if(indicator.get(test) != null && !isWithinNormalRange(test, indicator)) {
                    deviationsCount++;
                }
                indStat.put("volume", volumeCount);
                indStat.put("deviations", deviationsCount);
                deviations.put(indName, indStat);
            }
        }
        return deviations;
    }

    private Map<Comparable<?>, Long> frequency2Map (Frequency frequency){
        Map<Comparable<?>, Long> map = new HashMap<>();
        Iterator<Map.Entry<Comparable<?>, Long>> it = frequency.entrySetIterator();
        while(it.hasNext()){
            Map.Entry<Comparable<?>, Long> entry = it.next();
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    private <T extends MedicalTest> List<Field> testIndicators(Class<T> testClass){
        List<Field> inds = new ArrayList<>();
        for(Field field : testClass.getDeclaredFields()){
            if(field.isAnnotationPresent(StatVariable.class)){
                field.setAccessible(true);
                inds.add(field);
            }
        }
        return inds;
    }

    private Method[] indicatorsGetters(Class test){
        return getMethodsAnnotatedBy(test, StatVariable.class);
    }

    private Class innerGenericType(Method method){
        return (Class) ((ParameterizedType)method.getGenericReturnType()).getActualTypeArguments()[0];
    }

    private Method[] getMethodsAnnotatedBy(final Class clazz, final Class<? extends Annotation> annotation){
        List<Method> methods = new ArrayList<>();
        for(Method m : clazz.getDeclaredMethods()){
            if(m.isAnnotationPresent(annotation))
                methods.add(m);
        }
        Method[] selMethods = new Method[methods.size()];
        methods.toArray(selMethods);
        return selMethods;
    }

    private boolean isWithinNormalRange(MedicalTest test, Field indicatorField) throws IllegalAccessException{
        Double indicatorValue = (Double)indicatorField.get(test);
        IndicatorNorm indicatorNorm = indicatorField.getAnnotation(IndicatorNorm.class);
        return indicatorValue >= indicatorNorm.min() && indicatorValue <= indicatorNorm.max();
    }

    private class Pair<K, V>{
        private K key_;
        private V value_;

        public Pair(K key, V value){
            key_ = key;
            value_ = value;
        }

        public K getKey() {
            return key_;
        }

        public void setKey(K key) {
            key_ = key;
        }

        public V getValue() {
            return value_;
        }

        public void setValue(V value){
            value_ = value;
        }
    }
}
