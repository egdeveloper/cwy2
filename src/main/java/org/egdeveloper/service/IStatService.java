package org.egdeveloper.service;


import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface IStatService {
    Map<String, Map<Comparable<?>, Long>> beforeTreatmentStat();
    Map<Object, Object> indicatorsDynamics(Integer patientId) throws IllegalAccessException, InvocationTargetException;
}
