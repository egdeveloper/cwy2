package org.egdeveloper.web.controllers;

import org.egdeveloper.service.DoctorService;
import org.egdeveloper.web.form.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class RegisterDoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    @Qualifier("signupValidator")
    private Validator validator;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewDoctor(@ModelAttribute("signupData") @Valid Signup signup, BindingResult bindingResult, ModelMap modelMap){
        validator.validate(signup, bindingResult);
        if(bindingResult.hasErrors()){
            return "registration/register";
        }
        else {
            doctorService.addDoctor(signup.getDoctorAccount());
            return "redirect:/";
        }
    }
}
