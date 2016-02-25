package org.egdeveloper.web.controllers;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.service.IDoctorService;
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
import org.egdeveloper.web.form.Login;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class HomeController {

    @Autowired
    @Qualifier("doctorService")
    private IDoctorService doctorService;

    @Autowired
    @Qualifier("signupValidator")
    private Validator validator;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.addAttribute("loginAuth", new Login());
        modelMap.addAttribute("signupData", new Signup());
        return "home/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logIn(@ModelAttribute("loginAuth") @Valid Login loginAuth, BindingResult bindingResult, ModelMap modelMap, RedirectAttributes attributes){
        if(!bindingResult.hasErrors()) {
            Doctor doctor = doctorService.getDoctorByLoginAndPassword(loginAuth.getLogin(), loginAuth.getPassword());
            if(doctor != null) {
                attributes.addFlashAttribute("doctorAccount", doctor);
                return "redirect:/main";
            }
        }
        modelMap.addAttribute("loginError", "Вы не правильно ввели логин или пароль!");
        return "redirect:/";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(ModelMap modelMap){
        return "home/AboutPage";
    }

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help(ModelMap modelMap){
        return "home/HelpPage";
    }

    /*
    @RequestMapping(value = "/registerNewDoctor", method = RequestMethod.GET)
    public ModelAndView registerNewDoctor(){
        return new ModelAndView("registration/register", "signupData", new Signup());
    }
    */

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewDoctor(@ModelAttribute("signupData") @Valid Signup signup, BindingResult bindingResult, ModelMap modelMap){
        validator.validate(signup, bindingResult);
        if(bindingResult.hasErrors()){
            return "home/index";
        }
        else {
            doctorService.addDoctor(signup.getDoctorAccount());
            return "redirect:/";
        }
    }
}
