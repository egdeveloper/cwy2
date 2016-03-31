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
    private double ph;

    @Column(name = "WBCells")
    @NotNull
    @DisplayName("Лейкоциты")
    @StatVariable
    private double wbCells;

    @Column(name = "RBCells")
    @NotNull
    @DisplayName("Эритроциты")
    @StatVariable
    private double rbCells;

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    //@JsonProperty("ph")
    public double getPh() {
        return ph;
    }

    //@JsonProperty("ph")
    public void setPh(double PH) {
        this.ph = ph;
    }

    @DisplayName("Лейкоциты")
    @StatVariable
    //@JsonProperty("wbCells")
    public double getWbCells() {
        return wbCells;
    }

    //@JsonProperty("wbCells")
    public void setWbCells(double WBCells) {
        this.wbCells = wbCells;
    }

    @DisplayName("Эритроциты")
    @StatVariable
    //@JsonProperty("rbCells")
    public double getRbCells() {
        return rbCells;
    }

    //@JsonProperty("rbCells")
    public void setRbCells(double rbCells) {
        this.rbCells = rbCells;
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

}
