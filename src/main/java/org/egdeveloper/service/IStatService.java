package org.egdeveloper.service;


import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface IStatService {
    Map<Object, Object> beforeTreatmentStat();
    Map<Object, Object> indicatorsDynamics(Integer patientId) throws IllegalAccessException, InvocationTargetException;
}
