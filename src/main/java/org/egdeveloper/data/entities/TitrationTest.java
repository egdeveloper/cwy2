package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.EntityID;
import org.egdeveloper.attributes.MedTest;
import org.egdeveloper.attributes.StatVariable;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;


@Entity
@Table
@MedTest
@EntityID("titrationTest")
@DisplayName("Титриметрия")
public class TitrationTest implements Serializable, IMedicalTest{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "testDate")
    @DisplayName("Дата проведения анализа")
    private LocalDate testDate;

    @NotNull
    @Column(name = "description")
    @DisplayName("Дополнительная информация")
    private String description;

    @Column(name = "oxalate")
    @NotNull
    @DisplayName("Оксалат")
    @StatVariable
    private double oxalate;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Patient patient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DisplayName("Оксалат")
    @StatVariable
    public double getOxalate() {
        return oxalate;
    }

    public void setOxalate(double oxalate) {
        this.oxalate = oxalate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
