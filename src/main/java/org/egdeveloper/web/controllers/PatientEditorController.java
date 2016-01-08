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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("doctorInfo")
public class PatientEditorController {

    @Autowired
    @Qualifier("patientService")
    private IPatientService patientService;

    @RequestMapping(value = "/editPatientInfo", method = RequestMethod.GET)
    public String getPatientInfoEditor(@ModelAttribute("doctor") Doctor doctor, ModelMap modelMap){
        modelMap.addAttribute("doctorInfo", doctor);
        modelMap.addAttribute("patientInfo", new Patient());
        return "/patient_page/patient_edit_page";
    }
    @RequestMapping(value = "/editPatientInfo", method = RequestMethod.POST)
    public String editPatientInfo(@ModelAttribute("doctorInfo") Doctor doctor,
                                  @ModelAttribute("patientInfo") @Valid Patient patient,
                                  BindingResult bindingResult, ModelMap modelMap, SessionStatus status)
    {
        if(bindingResult.hasErrors()) {
            return "/patient_page/patient_edit_page";
        }
        patientService.addPatient(doctor, patient);
        status.setComplete();
        return "redirect:/logged";
    }
}
