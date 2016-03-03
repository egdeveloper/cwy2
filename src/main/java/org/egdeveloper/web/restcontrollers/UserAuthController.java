package org.egdeveloper.web.restcontrollers;

import org.egdeveloper.service.IUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserAuthController {

    @Autowired
    @Qualifier("userAuthService")
    private IUserAuthService userAuthService;


    @RequestMapping(value = "/authUser", method = RequestMethod.POST)
    public Map authUser(){
        Map resultResponse = new HashMap<>();
        return resultResponse;
    }
}
