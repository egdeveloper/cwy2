package org.egdeveloper.service;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.web.form.Login;
import org.egdeveloper.web.form.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userAuthService")
public class UserAuthService implements IUserAuthService {

    @Autowired
    @Qualifier("doctorService")
    private IDoctorService doctorService;

    @Override
    public void registerNewUserAccount(Signup newUserAccount){
        doctorService.addDoctor(newUserAccount.getDoctorAccount());
    }

    @Override
    public Doctor authUser(Login login){
        return doctorService.getDoctorByLoginAndPassword(login.getLogin(), login.getPassword());
    }
}
