package org.egdeveloper.data.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.egdeveloper.converters.deserializers.DoctorDeserializer;
import org.egdeveloper.converters.serializers.DoctorSerializer;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@JsonSerialize(using = DoctorSerializer.class)
@JsonDeserialize(using = DoctorDeserializer.class)
@Entity
@Table(name = "Doctor")
@XmlRootElement(name = "doctor")
public class Doctor extends Person implements Serializable{

    public Doctor(){}

    @NotEmpty(message = "Введите логин!")
    @Column(name = "login", nullable = false)
    @XmlElement
    private String login;

    @NotEmpty(message = "Введите пароль!")
    @Size(min = 6, max = 255, message = "Пароль должен состоять не менее из 6 символов")
    @Column(name = "password", nullable = false)
    @XmlElement
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @XmlElement(name = "patients")
    private List<Patient> patients = new ArrayList<>();

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

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
