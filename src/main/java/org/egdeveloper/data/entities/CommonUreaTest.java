package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    @Indicator
    @Column(name = "amount", nullable = true)
    @DisplayName("Количество мочи")
    @IndicatorNorm(minCritical = 1008.0, min = 1018.0, max = 1025.0, maxCritical = 1035.0)
    @StatVariable
    private Double amount;

    @Indicator
    @Column(name = "PH", nullable = true)
    @DisplayName("Ph")
    @IndicatorNorm(minCritical = 3.5, min = 5.5, max = 7.0, maxCritical = 9.0)
    @StatVariable
    private Double ph;

    @Indicator
    @Column(name = "WBCells", nullable = true)
    @DisplayName("Лейкоциты")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 5.0, maxCritical = 7.0)
    @StatVariable
    private Double wbCells;

    @Indicator
    @Column(name = "RBCells", nullable = true)
    @DisplayName("Эритроциты")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 9.0, maxCritical = 11.0)
    @StatVariable
    private Double rbCells;

    @Indicator
    @Column(name = "color", nullable = true)
    @DisplayName("Цвет")
    private String color;

    @Indicator
    @Column(name = "transparency")
    @NotNull
    @DisplayName("Прозрачность")
    private String transparency;

    @Indicator
    @Column(name = "protein", nullable = false)
    @DisplayName("Белок")
    private String protein;

    @Indicator
    @Column(name = "glucose", nullable = false)
    @DisplayName("Глюкоза")
    private String glucose;

    @Indicator
    @Column(name = "ketoneBodies", nullable = false)
    @DisplayName("Кетоновые тела")
    private String ketoneBodies;

    @Indicator
    @Column(name = "bloodReaction", nullable = false)
    @DisplayName("Реакция на кровь")
    private String bloodReaction;

    @Indicator
    @Column(name = "biliRuby", nullable = false)
    @DisplayName("Билирубин")
    private String biliRuby;

    @Indicator
    @Column(name = "mucus", nullable = false)
    @DisplayName("Слизь")
    private String mucus;

    @Indicator
    @Column(name = "bacteria", nullable = false)
    @DisplayName("Бактерии")
    private String bacteria;

    @Indicator
    @Column(name = "salt", nullable = false)
    @DisplayName("Соли")
    private String salt;

    @Indicator
    @Column(name = "ureaBilins", nullable = false)
    @DisplayName("Уробилиноиды")
    private String ureaBilins;

    @Indicator
    @Column(name = "cylinder", nullable = false)
    @DisplayName("Цилиндры")
    private String cylinder;

    @Indicator
    public Double getAmount() {
        return amount;
    }

    @Indicator
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Indicator
    public Double getPh() {
        return ph;
    }

    @Indicator
    public void setPh(Double PH) {
        this.ph = ph;
    }

    @Indicator
    @DisplayName("Лейкоциты")
    @StatVariable
    public Double getWbCells() {
        return wbCells;
    }

    @Indicator
    public void setWbCells(Double WBCells) {
        this.wbCells = wbCells;
    }

    @Indicator
    @DisplayName("Эритроциты")
    @StatVariable
    public Double getRbCells() {
        return rbCells;
    }

    @Indicator
    public void setRbCells(Double rbCells) {
        this.rbCells = rbCells;
    }

    @Indicator
    public String getColor() {
        return color;
    }

    @Indicator
    public void setColor(String color) {
        this.color = color;
    }

    @Indicator
    public String getTransparency() {
        return transparency;
    }

    @Indicator
    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    @Indicator
    public String getProtein() {
        return protein;
    }

    @Indicator
    public void setProtein(String protein) {
        this.protein = protein;
    }

    @Indicator
    public String getGlucose() {
        return glucose;
    }

    @Indicator
    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }

    @Indicator
    public String getKetoneBodies() {
        return ketoneBodies;
    }

    @Indicator
    public void setKetoneBodies(String ketoneBodies) {
        this.ketoneBodies = ketoneBodies;
    }

    @Indicator
    public String getBloodReaction() {
        return bloodReaction;
    }

    @Indicator
    public void setBloodReaction(String bloodReaction) {
        this.bloodReaction = bloodReaction;
    }

    @Indicator
    public String getBiliRuby() {
        return biliRuby;
    }

    @Indicator
    public void setBiliRuby(String biliRuby) {
        this.biliRuby = biliRuby;
    }

    @Indicator
    public String getMucus() {
        return mucus;
    }

    @Indicator
    public void setMucus(String mucus) {
        this.mucus = mucus;
    }

    @Indicator
    public String getBacteria() {
        return bacteria;
    }

    @Indicator
    public void setBacteria(String bacteria) {
        this.bacteria = bacteria;
    }

    @Indicator
    public String getSalt() {
        return salt;
    }

    @Indicator
    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Indicator
    public String getUreaBilins() {
        return ureaBilins;
    }

    @Indicator
    public void setUreaBilins(String ureaBilins) {
        this.ureaBilins = ureaBilins;
    }

    @Indicator
    public String getCylinder() {
        return cylinder;
    }

    @Indicator
    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

}
