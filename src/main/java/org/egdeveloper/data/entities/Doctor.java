package org.egdeveloper.data.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by egdeveloper on 18.11.15.
 */

@Entity
@Table(name = "DOCTOR")
public class Doctor implements Serializable{

    public Doctor(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String full_name) {
        this.fullName = full_name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(String job_place) {
        this.jobPlace = job_place;
    }

    public String getJobPost() {
        return jobPost;
    }

    public void setJobPost(String job_post) {
        this.jobPost = job_post;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Введите свое ФИО")
    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @NotEmpty(message = "Введите логин")
    @Column(name = "LOGIN", nullable = false)
    private String login;

    @NotEmpty(message = "Введите пароль")
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "JOB_PLACE", nullable = false)
    private String jobPlace;

    @Column(name = "JOB_POST", nullable = false)
    private String jobPost;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;
}
