package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.DisplayName;
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
@DisplayName("Суточная экскреция")
public class DailyExcreationTest implements Serializable, IMedicalTest{

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

    @Column(name = "creatinine")
    @NotNull
    @DisplayName("Креатинин")
    @StatVariable
    private double creatinine;

    @Column(name = "urea")
    @NotNull
    @DisplayName("Мочевина")
    @StatVariable
    private double urea;

    @Column(name = "ureaAcid")
    @NotNull
    @DisplayName("Мочевая кислота")
    @StatVariable
    private double ureaAcid;

    @Column(name = "calcium")
    @NotNull
    @DisplayName("Кальций")
    @StatVariable
    private double calcium;

    @Column(name = "potassium")
    @NotNull
    @DisplayName("Калий")
    @StatVariable
    private double potassium;

    @Column(name = "magnesium")
    @NotNull
    @DisplayName("Магний")
    @StatVariable
    private double magnesium;

    @Column(name = "sodium")
    @NotNull
    @DisplayName("Натрий")
    @StatVariable
    private double sodium;

    @Column(name = "phosphorOxide")
    @NotNull
    @DisplayName("Оксид Фосфора")
    @StatVariable
    private double phosphorOxide;

    @Column(name = "chlorine")
    @NotNull
    @DisplayName("Хлор")
    @StatVariable
    private double chlorine;

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

    @DisplayName("Креатинин")
    @StatVariable
    public double getCreatinine() {
        return creatinine;
    }

    public void setCreatinine(double creatinine) {
        this.creatinine = creatinine;
    }

    @DisplayName("Мочевина")
    @StatVariable
    public double getUrea() {
        return urea;
    }

    public void setUrea(double urea) {
        this.urea = urea;
    }

    @DisplayName("Мочевая кислота")
    @StatVariable
    public double getUreaAcid() {
        return ureaAcid;
    }

    public void setUreaAcid(double ureaAcid) {
        this.ureaAcid = ureaAcid;
    }

    @DisplayName("Кальций")
    @StatVariable
    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    @DisplayName("Калий")
    @StatVariable
    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    @DisplayName("Магний")
    @StatVariable
    public double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(double magnesium) {
        this.magnesium = magnesium;
    }

    @DisplayName("Натрий")
    @StatVariable
    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    @DisplayName("Оксид Фосфора")
    @StatVariable
    public double getPhosphorOxide() {
        return phosphorOxide;
    }

    public void setPhosphorOxide(double phosphorOxide) {
        this.phosphorOxide = phosphorOxide;
    }

    @DisplayName("Хлор")
    @StatVariable
    public double getChlorine() {
        return chlorine;
    }

    public void setChlorine(double chlorine) {
        this.chlorine = chlorine;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
