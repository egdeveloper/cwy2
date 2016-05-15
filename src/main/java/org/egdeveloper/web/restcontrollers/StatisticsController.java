package org.egdeveloper.web.restcontrollers;

import org.egdeveloper.attributes.IndicatorNorm;
import org.egdeveloper.data.entities.*;
import org.egdeveloper.data.entities.customTypes.PatientState;
import org.egdeveloper.data.entities.customTypes.StoneXRay;
import org.egdeveloper.data.entities.customTypes.TreatmentNumber;
import org.egdeveloper.helpers.EntityInfoGetterHelper;
import org.egdeveloper.service.data.IDoctorService;
import org.egdeveloper.service.data.IPatientService;
import org.egdeveloper.service.statistics.IStatService;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class StatisticsController {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd.MM.yyyy");

    @Autowired
    @Qualifier("statService")
    IStatService statService;

    @Autowired
    @Qualifier("doctorService")
    IDoctorService doctorService;

    @Autowired
    @Qualifier("patientService")
    IPatientService patientService;

    @Autowired
    @Qualifier("entityInfoGetterHelper")
    EntityInfoGetterHelper entityInfoGetterHelper;

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

    @RequestMapping(value = "/generateStatistics", method = RequestMethod.GET)
    public ResponseEntity<Object> generateStatistics() throws Exception
    {
        Random random = new Random();
        List<Class<? extends MedicalTest>> testTypes = entityInfoGetterHelper.getTestTypes();
        List<Patient> patients = patientService.getPatients();
        TreatmentNumber[] tperiods = TreatmentNumber.values();
        int year = 1998;
        for(TreatmentNumber tperiod : tperiods)
        {
            if(tperiod.equals(TreatmentNumber.III))
                break;
            for(Patient patient : patients)
            {
                for(Class<? extends MedicalTest> testType : testTypes)
                {
                    MedicalTest test = produceMedicalTest(testType);
                    test.setTestDate(LocalDate.parse("01.02." + year, dateTimeFormatter));
                    test.setTreatmentNumber(tperiod);
                    if(test instanceof StoneInVitroTest){
                        int choice = random.nextInt(3);
                        switch (choice)
                        {
                            case 0:
                                ((StoneInVitroTest)test).setXray(StoneXRay.OXALATES);
                                break;
                            case 1:
                                ((StoneInVitroTest)test).setXray(StoneXRay.PHOSPHATES);
                                break;
                            case 2:
                                ((StoneInVitroTest)test).setXray(StoneXRay.URATES);
                        }
                    }
                    for(Field indicator : entityInfoGetterHelper.getAllIndicators(testType))
                    {
                        if(indicator.getType().isAssignableFrom(Double.class)) {
                            if (indicator.isAnnotationPresent(IndicatorNorm.class)) {
                                IndicatorNorm norm = indicator.getAnnotation(IndicatorNorm.class);
                                double mean = (norm.minCritical() + norm.maxCritical()) * 0.5;
                                double std = (norm.maxCritical() - norm.maxCritical()) / (2 * Math.sqrt(2) * 0.45);
                                double ind_value = random.nextGaussian() * mean + std;
                                indicator.set(test, ind_value > 0 ? Math.round(ind_value * 100.0) / 100.0 : 0.0);
                            }
                            else
                                indicator.set(test, 0.0);
                        }
                    }
                    patientService.addMedicalTest(patient, test);
                }
            }
            year++;
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private MedicalTest produceMedicalTest(Class<? extends MedicalTest> testClazz) throws IllegalAccessException, InstantiationException
    {
        MedicalTest test = testClazz.newInstance();
        test.setTreatmentNumber(TreatmentNumber.NONE);
        test.setTreatment("");
        test.setTestDate(LocalDate.now());
        test.setDescription("");
        test.setPatientState(PatientState.FAIR);
        if(test instanceof CommonUreaTest)
        {
            ((CommonUreaTest)test).setGlucose("нет");
            ((CommonUreaTest)test).setColor("прозрачная");
            ((CommonUreaTest)test).setProtein("нет");
            ((CommonUreaTest)test).setTransparency("прозрачная");
            ((CommonUreaTest)test).setKetoneBodies("нет");
            ((CommonUreaTest)test).setBloodReaction("нет");
            ((CommonUreaTest)test).setBiliRuby("нет");
            ((CommonUreaTest)test).setMucus("нет");
            ((CommonUreaTest)test).setBacteria("нет");
            ((CommonUreaTest)test).setSalt("нет");
            ((CommonUreaTest)test).setUreaBilins("нет");
            ((CommonUreaTest)test).setCylinder("нет");
        }
        else if(test instanceof StoneInVitroTest)
        {
            ((StoneInVitroTest)test).setStoneType("нормальный");
            ((StoneInVitroTest)test).setXray(StoneXRay.OXALATES);
            ((StoneInVitroTest)test).setAddInfo("нет");
        }
        else if(test instanceof StoneInVivoTest)
        {
            ((StoneInVivoTest)test).setDensity(500.0);
            ((StoneInVivoTest)test).setSize(1.2);
            ((StoneInVivoTest)test).setLocation("в почках");
            ((StoneInVivoTest)test).setAddInfo("нет");
        }
        return test;
    }
}
