package org.egdeveloper.web.controllers;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.data.entities.Patient;
import org.egdeveloper.service.IDoctorService;
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
public class MainController {

    @Autowired
    @Qualifier("patientService")
    private IPatientService patientService;

    @Autowired
    @Qualifier("doctorService")
    private IDoctorService doctorService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainDoctorPage(@ModelAttribute("doctor") Doctor doctor, BindingResult bindingResult, ModelMap modelMap, HttpSession session){
        return "DoctorPages/MainDoctorPage";
    }

    @RequestMapping(value = "/personalPage", method = RequestMethod.GET)
    public String personalPage(ModelMap modelMap, HttpSession session){
        return "DoctorPages/PersonalPage";
    }

    @RequestMapping(value = "/updatePersonalDoctorInfo", method = RequestMethod.POST)
    public String updatePersonalDoctorInfo(@ModelAttribute("doctor") Doctor doctor, BindingResult bindingResult){
        if(!bindingResult.hasErrors())
            doctorService.updateDoctorInfo(doctor);
        return "redirect:/personalPage";
    }

    @RequestMapping(value = "/patientInfoEditor", method = RequestMethod.GET)
    public String getPatientInfoEditor(RedirectAttributes attributes, HttpSession session){
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

    @RequestMapping(value = "/beforeTreatmentStatVisualization", method = RequestMethod.GET)
    public String beforeTreatmentStatVisualization(){
        return "StatisticsPages/StatBeforeTreatmentPage";
    }
}
