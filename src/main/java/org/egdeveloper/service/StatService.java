package org.egdeveloper.service;

import org.apache.commons.math3.stat.Frequency;
import org.egdeveloper.attributes.*;
import org.egdeveloper.data.entities.*;
import org.egdeveloper.data.entities.custom_types.StoneXRay;
import org.egdeveloper.data.entities.custom_types.TreatmentNumber;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    private Map<Class, Pair<Method, Method[]>> indGetters = new HashMap<>();
    private Map<Class, List<Field>> indFields = new HashMap<>();

    public StatService(){
        Method[] testGetters = getMethodsAnnotatedBy(Patient.class, MedTest.class);
        for(Method testGetter : testGetters){
            Class testClazz = innerGenericType(testGetter);
            indGetters.put(testClazz, new Pair<>(testGetter, indicatorsGetters(testClazz)));
        }
        indFields.put(BioChemTest.class, testIndicators(BioChemTest.class));
        indFields.put(CommonBloodTest.class, testIndicators(CommonBloodTest.class));
        indFields.put(CommonUreaTest.class, testIndicators(CommonUreaTest.class));
        indFields.put(DailyExcreationTest.class, testIndicators(DailyExcreationTest.class));
        indFields.put(StoneInVitroTest.class, testIndicators(StoneInVitroTest.class));
        indFields.put(StoneInVivoTest.class, testIndicators(StoneInVivoTest.class));
        indFields.put(TitrationTest.class, testIndicators(TitrationTest.class));
        indFields.put(UreaColorTest.class, testIndicators(UreaColorTest.class));
    }

    @Autowired
    @Qualifier("doctorService")
    IDoctorService doctorService;

    @Autowired
    @Qualifier("patientService")
    IPatientService patientService;

    @Override
    @Transactional
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
    @Transactional
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
        StoneXRay[] stoneXRays = StoneXRay.values();
        List<StoneInVitroTest> stoneTests = patientService.retrieveMedicalTestsByType(StoneInVitroTest.class);
        for(StoneXRay xRay : stoneXRays){
            List<Patient> patientsWithDefStone = stoneTests
                    .stream()
                    .parallel()
                    .filter(t -> t.getXray().equals(xRay) && t.getTreatmentNumber().equals(treatmentNumber))
                    .map(StoneInVitroTest::getPatient)
                    .collect(Collectors.toList());
        }
        */
        return indicatorDeviations;
    }

    @Override
    public Map<String, Map<String, Integer>> indicatorDeviations(TreatmentNumber treatmentNumber) throws IllegalAccessException {
        Map<String, Map<String, Integer>> deviations = new HashMap<>();
        for(Class testClazz : indFields.keySet()){
            deviations.put(((DisplayName)testClazz.getAnnotation(DisplayName.class)).value(), indicatorDeviations(testClazz, treatmentNumber));
        }
        return deviations;
    }

    @Override
    public <T extends MedicalTest> Map<String, Integer> indicatorDeviations(Class<T> testClass, TreatmentNumber treatmentNumber) throws IllegalAccessException{
        Map<String, Integer> deviations = new HashMap<>();
        List<T> tests = patientService.retrieveMedicalTestsByType(testClass)
                .stream()
                .parallel()
                .filter(t -> t.getTreatmentNumber().equals(treatmentNumber))
                .collect(Collectors.toList());
        deviations.put("volume", tests.size());
        List<Field> inds = indFields.get(testClass);
        for(T test : tests){
            for(Field indicator : inds){
                String indName = indicator.getAnnotation(DisplayName.class).value();
                if(!isWithinNormalRange(test, indicator)) {
                    int devCount = deviations.containsKey(indName) ? deviations.get(indName) : 0;
                    deviations.put(indName, devCount + 1);
                }
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
        double indicatorValue = indicatorField.getDouble(test);
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
