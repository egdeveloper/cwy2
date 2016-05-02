package org.egdeveloper.helpers;

import org.egdeveloper.attributes.Indicator;
import org.egdeveloper.data.entities.MedicalTest;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Developer: Roman Yarnykh (egdeveloper@mail.ru)
 * Creation-Date: 30.04.2016
 * Project: LaksmiMed
 * Package: org.egdeveloper.helpers
 */

@Component("entityInfoGetterHelper")
public class EntityInfoGetterHelper {

    private Map<Class<? extends MedicalTest>, List<Field>> indicatorsMap = new HashMap<>();

    private Reflections reflections = new Reflections("org.egdeveloper.data.entities");

    {
        Set<Class<? extends MedicalTest>> testClazzes = reflections.getSubTypesOf(MedicalTest.class);
        for (Class<? extends MedicalTest> testClazz : testClazzes) {
            List<Field> indicators = new ArrayList<>();
            for (Field field : testClazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Indicator.class)) {
                    field.setAccessible(true);
                    indicators.add(field);
                }
            }
            indicatorsMap.put(testClazz, indicators);
        }
    }

    public List<Field> getAllIndicators(Class<? extends MedicalTest> medicalTestClazz){
        return indicatorsMap.get(medicalTestClazz);
    }
}
