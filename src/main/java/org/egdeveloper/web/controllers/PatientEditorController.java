package org.egdeveloper.web.controllers;

import org.egdeveloper.data.entities.*;
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

import javax.servlet.http.HttpSession;
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
    public String editPatientInfo(@ModelAttribute("patientInfo") @Valid Patient patient,
                                  BindingResult bindingResult, ModelMap modelMap, HttpSession session, SessionStatus sessionStatus)
    {
        Doctor doctor = (Doctor)session.getAttribute("doctorInfo");
        if(bindingResult.hasErrors()) {
            return "/patient_page/patient_edit_page";
        }
        patientService.addPatient(doctor, patient);
        sessionStatus.setComplete();
        return "redirect:/logged";
    }

    //get methods


    @RequestMapping(value = "/addBiochemTest", method = RequestMethod.GET)
    public String addBiochemTest(ModelMap modelMap)
    {
        modelMap.addAttribute("biochemTest", new BioChemTest());
        return "patient_page/biochem_test_page";
    }

    @RequestMapping(value = "/addCommonBloodTest", method = RequestMethod.GET)
    public String addCommonBloodTest(ModelMap modelMap)
    {
        modelMap.addAttribute("commonBloodTest", new CommonBloodTest());
        return "patient_page/common_blood_test_page";
    }

    @RequestMapping(value = "/addCommonUreaTest", method = RequestMethod.GET)
    public String addCommonUreaTest(ModelMap modelMap)
    {
        modelMap.addAttribute("commonUreaTest", new CommonUreaTest());
        return "patient_page/common_urea_test_page";
    }

    @RequestMapping(value = "addDailyExcreationTest", method = RequestMethod.GET)
    public String addDailyExcreationTest(ModelMap modelMap)
    {
        modelMap.addAttribute("dailyExcreationTest", new DailyExcreationTest());
        return "/patient_page/daily_excreation_test_page";
    }

    @RequestMapping(value = "addTitrationTest", method = RequestMethod.GET)
    public String addTitrationTest(ModelMap modelMap)
    {
        modelMap.addAttribute("titrationTest", new TitrationTest());
        return "patient_page/titration_test_page";
    }

    @RequestMapping(value = "addUreaColorTest", method = RequestMethod.GET)
    public String addUreaColorTest(ModelMap modelMap)
    {
        modelMap.addAttribute("ureaColorTest", new UreaColorTest());
        return "patient_page/urea_color_test_page";
    }

    @RequestMapping(value = "addUreaStoneTest", method = RequestMethod.GET)
    public String addUreaStoneTest(ModelMap modelMap)
    {
        modelMap.addAttribute("ureaStoneTest", new UreaStoneTest());
        return "/patient_page/urea_stone_test_page";
    }

    //post methods

    @RequestMapping(value = "/addBiochemTest", method = RequestMethod.POST)
    public String addBiochemTest(@ModelAttribute("biochemTest") @Valid BioChemTest test,
                                 BindingResult bindingResult,
                                 ModelMap modelMap)
    {
        return "redirect:/";
    }

    @RequestMapping(value = "/addCommonBloodTest", method = RequestMethod.POST)
    public String addCommonBloodTest(@ModelAttribute("commonBloodTest") @Valid CommonBloodTest test,
                                     BindingResult bindingResult,
                                     ModelMap modelMap)
    {
        return "redirect:/";
    }

    @RequestMapping(value = "/addCommonUreaTest", method = RequestMethod.POST)
    public String addCommonUreaTest(@ModelAttribute("commonUreaTest") @Valid CommonUreaTest test,
                                    BindingResult bindingResult,
                                    ModelMap modelMap)
    {
        return "redirect:/";
    }

    @RequestMapping(value = "addDailyExcreationTest", method = RequestMethod.POST)
    public String addDailyExcreationTest(@ModelAttribute("dailyExcreationTest") @Valid DailyExcreationTest test,
                                         BindingResult bindingResult,
                                         ModelMap modelMap)
    {
        return "redirect:/";
    }

    @RequestMapping(value = "addTitrationTest", method = RequestMethod.POST)
    public String addTitrationTest(@ModelAttribute("titrationTest") @Valid TitrationTest test,
                                   BindingResult bindingResult,
                                   ModelMap modelMap)
    {
        return "redirect:/";
    }

    @RequestMapping(value = "addUreaColorTest", method = RequestMethod.POST)
    public String addUreaColorTest(@ModelAttribute("ureaColorTest") @Valid UreaColorTest test,
                                   BindingResult bindingResult,
                                   ModelMap modelMap)
    {
        return "redirect:/";
    }

    @RequestMapping(value = "addUreaStoneTest", method = RequestMethod.POST)
    public String addUreaStoneTest(@ModelAttribute("ureaStoneTest") @Valid UreaStoneTest test,
                                   BindingResult bindingResult,
                                   ModelMap modelMap)
    {
        return "redirect:/";
    }
}
