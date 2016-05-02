package org.egdeveloper.web.restcontrollers;

import org.egdeveloper.data.entities.custom_types.TreatmentNumber;
import org.egdeveloper.service.data.IDoctorService;
import org.egdeveloper.service.data.IPatientService;
import org.egdeveloper.service.statistics.IStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

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

    @RequestMapping(value = "/beforeTreatmentStat", method = RequestMethod.GET)
    public @ResponseBody Map<Object, Object> beforeTreatmentStat(){
        return statService.beforeTreatmentStat();
    }

    @RequestMapping(value = "/indicatorsDynamics/{pid}", method = RequestMethod.GET)
    public @ResponseBody Map<Object, Object> indicatorsDynamics(@PathVariable("pid") Integer pid) throws IllegalAccessException, InvocationTargetException{
        return statService.indicatorsDynamics(pid);
    }

    @RequestMapping(value = "/indicatorDeviations/{treatmentNumber}", method = RequestMethod.GET)
    public @ResponseBody Map<Object, Object> indicatorDeviations(@PathVariable("treatmentNumber") String treatmentNumber) throws IllegalAccessException{
        return statService.indicatorDeviations(TreatmentNumber.valueOf(treatmentNumber));
    }

    @RequestMapping(value = "/indicatorDeviationsForStoneType/{testType}/{treatmentNumber}", method = RequestMethod.GET)
    public @ResponseBody Map<Object, Object> indicatorDeviationsForStoneType(@PathVariable("testType") String testType,
                                                                             @PathVariable("treatmentNumber") String treatmentNumber) throws ClassNotFoundException, IllegalAccessException
    {

        Class testClazz = Class.forName("org.egdeveloper.data.entities." + testType.substring(0, 1).toUpperCase() + testType.substring(1));
        return statService.indicatorDeviationsForStoneTypesStat(testClazz, TreatmentNumber.valueOf(treatmentNumber));
    }

}
