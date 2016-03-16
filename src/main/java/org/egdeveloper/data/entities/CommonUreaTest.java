package org.egdeveloper.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.EntityID;
import org.egdeveloper.attributes.MedTest;
import org.egdeveloper.attributes.StatVariable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table
@MedTest
@EntityID("commonUreaTest")
@DisplayName("Общий анализ мочи")
public class CommonUreaTest extends MedicalTest {

    public CommonUreaTest(){
        super();
    }

    @Column(name = "amount")
    @NotNull
    @DisplayName("Количество мочи")
    private double amount;

    @Column(name = "PH")
    @NotNull
    @DisplayName("Ph")
    private double PH;

    @Column(name = "WBCells")
    @NotNull
    @DisplayName("Лейкоциты")
    @StatVariable
    private double WBCells;

    @Column(name = "RBCells")
    @NotNull
    @DisplayName("Эритроциты")
    @StatVariable
    private double RBCells;

    @Column(name = "color")
    @NotNull
    @DisplayName("Цвет")
    private String color;

    @Column(name = "transparency")
    @NotNull
    @DisplayName("Прозрачность")
    private String transparency;

    @Column(name = "protein")
    @NotNull
    @DisplayName("Белок")
    private String protein;

    @Column(name = "glucose")
    @NotNull
    @DisplayName("Глюкоза")
    private String glucose;

    @Column(name = "ketoneBodies")
    @NotNull
    @DisplayName("Кетоновые тела")
    private String ketoneBodies;

    @Column(name = "bloodReaction")
    @NotNull
    @DisplayName("Реакция на кровь")
    private String bloodReaction;

    @Column(name = "biliRuby")
    @NotNull
    @DisplayName("Билирубин")
    private String biliRuby;

    @Column(name = "mucus")
    @NotNull
    @DisplayName("Слизь")
    private String mucus;

    @Column(name = "bacteria")
    @NotNull
    @DisplayName("Бактерии")
    private String bacteria;

    @Column(name = "salt")
    @NotNull
    @DisplayName("Соли")
    private String salt;

    @Column(name = "ureaBilins")
    @NotNull
    @DisplayName("Уробилиноиды")
    private String ureaBilins;

    @Column(name = "cylinder")
    @NotNull
    @DisplayName("Цилиндры")
    private String cylinder;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Patient patient;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @JsonProperty("PH")
    public double getPH() {
        return PH;
    }

    @JsonProperty("PH")
    public void setPH(double PH) {
        this.PH = PH;
    }

    @DisplayName("Лейкоциты")
    @StatVariable
    @JsonProperty("WBCells")
    public double getWBCells() {
        return WBCells;
    }

    @JsonProperty("WBCells")
    public void setWBCells(double WBCells) {
        this.WBCells = WBCells;
    }

    @DisplayName("Эритроциты")
    @StatVariable
    @JsonProperty("RBCells")
    public double getRBCells() {
        return RBCells;
    }

    @JsonProperty("RBCells")
    public void setRBCells(double RBCells) {
        this.RBCells = RBCells;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransparency() {
        return transparency;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }

    public String getKetoneBodies() {
        return ketoneBodies;
    }

    public void setKetoneBodies(String ketoneBodies) {
        this.ketoneBodies = ketoneBodies;
    }

    public String getBloodReaction() {
        return bloodReaction;
    }

    public void setBloodReaction(String bloodReaction) {
        this.bloodReaction = bloodReaction;
    }

    public String getBiliRuby() {
        return biliRuby;
    }

    public void setBiliRuby(String biliRuby) {
        this.biliRuby = biliRuby;
    }

    public String getMucus() {
        return mucus;
    }

    public void setMucus(String mucus) {
        this.mucus = mucus;
    }

    public String getBacteria() {
        return bacteria;
    }

    public void setBacteria(String bacteria) {
        this.bacteria = bacteria;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUreaBilins() {
        return ureaBilins;
    }

    public void setUreaBilins(String ureaBilins) {
        this.ureaBilins = ureaBilins;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
