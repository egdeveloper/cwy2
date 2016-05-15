package org.egdeveloper.service.statistics;


import org.egdeveloper.data.entities.MedicalTest;
import org.egdeveloper.data.entities.customTypes.TreatmentNumber;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface IStatService {
    Map<Object, Object> beforeTreatmentStat();
    Map<Object, Object> indicatorsDynamics(Integer patientId) throws IllegalAccessException, InvocationTargetException;
    Map<Object, Object> indicatorDeviationsForStoneTypesStat(TreatmentNumber treatmentNumber);
    <T extends MedicalTest> Map<Object, Object> indicatorDeviationsForStoneTypesStat(Class<T> testClazz, TreatmentNumber treatmentNumber) throws IllegalAccessException;
    Map<Object, Object> indicatorDeviations(TreatmentNumber treatmentNumber) throws IllegalAccessException;
    <T extends MedicalTest> Map<String, Map<String, Integer>> indicatorDeviations(Class<T> testClass, TreatmentNumber treatmentNumber) throws IllegalAccessException;
    Map stoneComponentsStat(TreatmentNumber treatmentNumber);
}
