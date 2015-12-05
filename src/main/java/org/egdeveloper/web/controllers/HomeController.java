package org.egdeveloper.web.controllers;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class HomeController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.addAttribute("doctorAccount", new Doctor());
        return "home/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String logIn(@Valid Doctor doctor, BindingResult bindingResult, ModelMap modelMap){
        return "doctor_page/main_doctor_page";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(ModelMap modelMap){
        return "home/about";
    }

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help(ModelMap modelMap){
        return "home/help";
    }

    @RequestMapping(value = "/register_new_doctor", method = RequestMethod.GET)
    public ModelAndView registerNewDoctor(){
        return new ModelAndView("/registration/register", "doctorAccount", new Doctor());
    }
}
