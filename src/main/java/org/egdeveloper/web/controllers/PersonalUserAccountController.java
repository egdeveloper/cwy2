package org.egdeveloper.web.controllers;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.data.entities.Patient;
import org.egdeveloper.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes("doctor")
public class PersonalUserAccountController {

    @Autowired
    @Qualifier("patientService")
    private IPatientService patientService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainDoctorPage(@ModelAttribute("doctorAccount") Doctor doctor, BindingResult bindingResult, ModelMap modelMap, HttpSession session){
        session.setAttribute("doctor", doctor);
        return "/doctor_page/main_doctor_page";
    }

    @RequestMapping(value = "/personalPage", method = RequestMethod.GET)
    public String personalPage(ModelMap modelMap, HttpSession session){
        Doctor doctor = (Doctor)session.getAttribute("doctor");
        modelMap.addAttribute("doctorInfo", doctor);
        return "doctor_page/personal_page";
    }

    @RequestMapping(value = "/patientInfoEditor", method = RequestMethod.GET)
    public String getPatientInfoEditor(RedirectAttributes attributes, HttpSession session){
        Doctor doctor = (Doctor)session.getAttribute("doctor");
        attributes.addFlashAttribute("doctor", doctor);
        return "redirect:/editPatientInfo";
    }

    @RequestMapping(value = "/patients/{patientId}", method = RequestMethod.GET)
    public String getPatientPersonalPage(@PathVariable("patientId") Integer patientId, RedirectAttributes redirectAttributes){
        Patient patient = patientService.getPatientById(patientId);
        if(patient != null) {
            redirectAttributes.addFlashAttribute("patient", patient);
            return "redirect:/personalPatientPage";
        }
        else
            return "redirect:/main";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
