package org.egdeveloper.service.security;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.service.data.IDoctorService;
import org.egdeveloper.service.security.IUserAuthService;
import org.egdeveloper.web.form.Login;
import org.egdeveloper.web.form.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userAuthService")
public class UserAuthService implements IUserAuthService {

    @Autowired
    @Qualifier("doctorService")
    private IDoctorService doctorService;

    @Override
    public void registerNewUserAccount(Signup newUserAccount){
        newUserAccount.setPassword(BCrypt.hashpw(newUserAccount.getPassword(), BCrypt.gensalt()));
        doctorService.addDoctor(newUserAccount.getDoctorAccount());
    }

    @Override
    public Doctor authUser(Login login){
        Doctor doctor = doctorService.getDoctorByLogin(login.getLogin());
        if(doctor != null && BCrypt.checkpw(login.getPassword(), doctor.getPassword()))
            return doctor;
        return null;
    }
}
