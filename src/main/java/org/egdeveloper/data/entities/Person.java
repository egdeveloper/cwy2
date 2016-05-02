package org.egdeveloper.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@MappedSuperclass
public abstract class Person extends AbstractEntity implements Serializable{

    @Size(max = 255)
    @JsonProperty("fullName")
    @NotEmpty(message = "Введите ФИО!")
    @Column(name = "fullName", nullable = false)
    protected String fullName;

    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",
            message = "Введите email в правильном формате!"
    )
    @Column(name = "email", nullable = false)
    protected String email;

    @Column(name = "jobPlace", nullable = false)
    protected String jobPlace;

    @Column(name = "jobPost", nullable = false)
    protected String jobPost;

    @Column(name = "phoneNumber", nullable = false)
    protected String phoneNumber;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace;
    }

    public String getJobPost() {
        return jobPost;
    }

    public void setJobPost(String jobPost) {
        this.jobPost = jobPost;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
