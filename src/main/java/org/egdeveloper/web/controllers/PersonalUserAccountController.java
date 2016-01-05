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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class PersonalUserAccountController {

    @Autowired
    @Qualifier("patientService")
    private IPatientService patientService;

    private Doctor doctorInfo;

    @RequestMapping(value = "/logged", method = RequestMethod.GET)
    public String mainDoctorPage(@ModelAttribute("doctorAccount") Doctor doctor, BindingResult bindingResult, ModelMap modelMap){
        modelMap.addAttribute("doctorAccount", doctor);
        doctorInfo = doctor;
        return "/doctor_page/main_doctor_page";
    }

    @RequestMapping(value = "/patientInfoEditor", method = RequestMethod.GET)
    public String getPatientInfoEditor(RedirectAttributes attributes){
        attributes.addFlashAttribute("doctorInfo", doctorInfo);
        attributes.addFlashAttribute("patientInfo", new Patient());
        return "redirect:/editPatientInfo";
    }
}
