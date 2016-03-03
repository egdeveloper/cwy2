package org.egdeveloper.web.restcontrollers;

import org.egdeveloper.service.IDoctorService;
import org.egdeveloper.service.IPatientService;
import org.egdeveloper.service.IStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@RestController
public class StatisticsController {

    @Autowired
    @Qualifier("statService")
    IStatService statService;

    @Autowired
    @Qualifier("doctorService")
    IDoctorService doctorService;

    @Autowired
    @Qualifier("patientService")
    IPatientService patientService;

    @RequestMapping(value = "beforeTreatmentStat", method = RequestMethod.GET)
    public @ResponseBody Map<Object, Object> beforeTreatmentStat(){
        return statService.beforeTreatmentStat();
    }

    @RequestMapping(value = "/indicatorsDynamics/{pid}", method = RequestMethod.GET)
    public @ResponseBody Map<Object, Object> indicatorsDynamics(@PathVariable("pid") Integer pid) throws IllegalAccessException, InvocationTargetException{
        return statService.indicatorsDynamics(pid);
    }
}
