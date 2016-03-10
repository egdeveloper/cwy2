package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.EntityID;
import org.egdeveloper.attributes.MedTest;
import org.egdeveloper.attributes.StatVariable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table
@MedTest
@EntityID("dailyExcreationTest")
@DisplayName("Суточная экскреция")
public class DailyExcreationTest extends MedicalTest {

    public DailyExcreationTest(){}

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
