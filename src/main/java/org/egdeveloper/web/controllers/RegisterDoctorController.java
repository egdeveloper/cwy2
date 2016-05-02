package org.egdeveloper.web.controllers;

import org.egdeveloper.service.data.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;


@Controller
public class RegisterDoctorController {

    @Autowired
    @Qualifier("doctorService")
    private IDoctorService doctorService;

    @Autowired
    @Qualifier("signupValidator")
    private Validator validator;

    /*

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
    */
}
