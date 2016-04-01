package org.egdeveloper.service;


import org.egdeveloper.data.entities.custom_types.TreatmentNumber;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface IStatService {
    Map<Object, Object> beforeTreatmentStat();
    Map<Object, Object> indicatorsDynamics(Integer patientId) throws IllegalAccessException, InvocationTargetException;
    Map<Object, Object> indicatorDeviationsForStoneTypesStat(TreatmentNumber treatmentNumber);
}
