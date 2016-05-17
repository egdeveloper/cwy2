package org.egdeveloper.web.controllers;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.service.security.IUserAuthService;
import org.egdeveloper.web.form.Login;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class HomeController {

    @Autowired
    @Qualifier("userAuthService")
    private IUserAuthService userAuthService;

    @Autowired
    @Qualifier("signupValidator")
    private Validator validator;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.addAttribute("loginAuth", new Login());
        modelMap.addAttribute("signupData", new Signup());
        return "HomePages/IndexPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logIn(@ModelAttribute("loginAuth") @Valid Login loginAuth, BindingResult bindingResult, ModelMap modelMap, RedirectAttributes attributes){
        if(!bindingResult.hasErrors()) {
            Doctor doctor = userAuthService.authUser(loginAuth);
            if(doctor != null) {
                attributes.addFlashAttribute("doctor", doctor);
                return "redirect:/main";
            }
        }
        modelMap.addAttribute("loginError", "Вы не правильно ввели логин или пароль!");
        return "redirect:/";
    }

    @RequestMapping(value = "/about2", method = RequestMethod.GET)
    public String about(ModelMap modelMap){
        return "HomePages/About2Page";
    }

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help(ModelMap modelMap){
        return "Home/HelpPage";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewDoctor(@ModelAttribute("signupData") @Valid Signup signup, BindingResult bindingResult, ModelMap modelMap){
        validator.validate(signup, bindingResult);
        if(bindingResult.hasErrors()){
            return "redirect:/";
        }
        else {
            userAuthService.registerNewUserAccount(signup);
            return "redirect:/";
        }
    }
}
