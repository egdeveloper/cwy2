package org.egdeveloper.service.security;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.web.form.Login;
import org.egdeveloper.web.form.Signup;

public interface IUserAuthService {
    void registerNewUserAccount(Signup newUserAccount);
    Doctor authUser(Login login);
}
