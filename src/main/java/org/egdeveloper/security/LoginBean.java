package org.egdeveloper.security;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by egdeveloper on 03.01.16.
 */
public class LoginBean {

    @NotNull
    @NotEmpty(message = "Введите логин!")
    private String login;

    @NotNull
    @NotEmpty(message = "Введите пароль!")
    private String password;

    public LoginBean(){}

    public LoginBean(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
