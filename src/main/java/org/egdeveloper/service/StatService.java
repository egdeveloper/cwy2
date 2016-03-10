package org.egdeveloper.service;

import org.apache.commons.math3.stat.Frequency;
import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.EntityID;
import org.egdeveloper.attributes.MedTest;
import org.egdeveloper.attributes.StatVariable;
import org.egdeveloper.data.entities.*;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.*;

@Service("statService")
@Transactional
public class StatService implements IStatService {

    private Map<Class, Pair<Method, Method[]>> indGetters = new HashMap<Class, Pair<Method, Method[]>>();

    public StatService(){
        Method[] testGetters = getMethodsAnnotatedBy(Patient.class, MedTest.class);
        for(Method testGetter : testGetters){
            Class testClazz = innerGenericType(testGetter);
            indGetters.put(testClazz, new Pair<>(testGetter, indicatorsGetters(testClazz)));
        }
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
        Map<Object, Object> indicatorsStat = new HashMap();

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

    private Map<Comparable<?>, Long> frequency2Map (Frequency frequency){
        Map<Comparable<?>, Long> map = new HashMap<>();
        Iterator<Map.Entry<Comparable<?>, Long>> it = frequency.entrySetIterator();
        while(it.hasNext()){
            Map.Entry<Comparable<?>, Long> entry = it.next();
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
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
