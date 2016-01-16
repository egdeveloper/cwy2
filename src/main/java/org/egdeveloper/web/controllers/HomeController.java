package org.egdeveloper.web.controllers;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.service.IDoctorService;
import org.egdeveloper.web.form.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import org.egdeveloper.web.form.Login;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class HomeController {

    @Autowired
    @Qualifier("doctorService")
    private IDoctorService doctorService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.addAttribute("loginAuth", new Login());
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
        return "home/about";
    }

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help(ModelMap modelMap){
        return "home/help";
    }

    @RequestMapping(value = "/registerNewDoctor", method = RequestMethod.GET)
    public ModelAndView registerNewDoctor(){
        return new ModelAndView("registration/register", "signupData", new Signup());
    }
}
