package org.egdeveloper.web.controllers;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.data.entities.Patient;
import org.egdeveloper.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
public class PatientEditorController {

    @Autowired
    @Qualifier("patientService")
    private IPatientService patientService;

    private Doctor doctorInfo;

    @RequestMapping(value = "/editPatientInfo", method = RequestMethod.GET)
    public String getPatientInfoEditor(@ModelAttribute("doctorInfo") Doctor doctor, ModelMap modelMap){
        doctorInfo = doctor;
        modelMap.addAttribute("patientInfo", new Patient());
        return "/patient_page/patient_edit_page";
    }
    @RequestMapping(value = "/editPatientInfo", method = RequestMethod.POST)
    public String editPatientInfo(@ModelAttribute("patientInfo") @Valid Patient patient,
                                  BindingResult bindingResult, ModelMap modelMap)
    {
        if(bindingResult.hasErrors()) {
            return "/patient_page/patient_edit_page";
        }
        patient.setDoctor(doctorInfo);
        patientService.addPatient(patient);
        return "redirect:/logged";
    }
}
