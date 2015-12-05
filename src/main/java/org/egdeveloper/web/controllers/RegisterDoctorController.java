package org.egdeveloper.web.controllers;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class RegisterDoctorController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewDoctor(@ModelAttribute("doctorAccount") @Valid Doctor doctor, BindingResult bindingResult, ModelMap modelMap){
        if(bindingResult.hasErrors()){
            return "/registration/register";
        }
        else {
            doctorService.addDoctor(doctor);
            return "/home/index";
        }
    }
}
