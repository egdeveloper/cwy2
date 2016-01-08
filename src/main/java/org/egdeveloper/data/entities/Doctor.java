package org.egdeveloper.data.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Doctor")
public class Doctor implements Serializable{

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Введите свое ФИО!")
    @Column(name = "fullName", nullable = false)
    private String fullName;

    @NotEmpty(message = "Введите логин!")
    @Column(name = "login", nullable = false)
    private String login;

    @NotEmpty(message = "Введите пароль!")
    @Size(min = 6, max = 255, message = "Пароль должен состоять не менее из 6 символов")
    @Column(name = "password", nullable = false)
    private String password;

    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",
            message = "Введите email в правильном формате!"
    )
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "jobPlace", nullable = false)
    private String jobPlace;

    @Column(name = "jobPost", nullable = false)
    private String jobPost;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Patient> patients = new HashSet<>();

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

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
