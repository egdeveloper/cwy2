package org.egdeveloper.web.controllers;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PersonalUserAccountController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/logged", method = RequestMethod.GET)
    public String mainDoctorPage(@ModelAttribute("doctorAccount") Doctor doctor, BindingResult bindingResult, ModelMap modelMap){
        modelMap.addAttribute("doctorAccount", doctor);
        return "doctorPage/MainDoctorPage";
    }
}
