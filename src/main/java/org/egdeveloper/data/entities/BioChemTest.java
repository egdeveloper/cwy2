package org.egdeveloper.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.egdeveloper.attributes.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table
@MedTest
@EntityID("bioChemTest")
@DisplayName("Биохимический анализ крови")
public class BioChemTest extends MedicalTest {


    public BioChemTest(){
        super();
    }

    @Column(name = "commonProtein", nullable = false)
    @DisplayName("Общий белок")
    @IndicatorNorm(minCritical = 56.0, min = 76.0, max = 77.0, maxCritical = 97.0)
    @StatVariable
    private double commonProtein;

    @Column(name = "urea", nullable = false)
    @DisplayName("Мочевина")
    @IndicatorNorm(minCritical = 1.2, min = 2.2, max = 7.8, maxCritical = 8.8)
    @StatVariable
    private double urea;

    @Column(name = "creatinine", nullable = false)
    @DisplayName("Креатинин")
    @IndicatorNorm(minCritical = 43.0, min = 63.0, max = 105.0, maxCritical = 125.0)
    @StatVariable
    private double creatinine;

    @Column(name = "commonBiliRuby", nullable = false)
    @DisplayName("Общий билирубин")
    @IndicatorNorm(minCritical = 1.5, min = 2.5, max = 18.0, maxCritical = 24.0)
    @StatVariable
    private double commonBiliRuby;

    @Column(name = "linkedBiliRuby", nullable = false)
    @DisplayName("Связанный билирубин")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 2.9, maxCritical = 3.9)
    @StatVariable
    private double linkedBiliRuby;

    @Column(name = "cholesterol", nullable = false)
    @DisplayName("Холестерин")
    @IndicatorNorm(minCritical = 3.13, min = 4.13, max = 4.7, maxCritical = 5.7)
    @StatVariable
    private double cholesterol;

    @Column(name = "TAG", nullable = false)
    @DisplayName("Триглицериды")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 1.6, maxCritical = 1.8)
    @StatVariable
    private double tag;

    @Column(name = "HDL", nullable = false)
    @DisplayName("Липопр. выс. кон.")
    @IndicatorNorm(minCritical = 0.8, min = 1.0, max = 1.44, maxCritical = 1.64)
    @StatVariable
    private double hdl;

    @Column(name = "LDL", nullable = false)
    @DisplayName("Липопр. низ. кон.")
    @IndicatorNorm(minCritical = 1.0, min = 1.4, max = 4.2, maxCritical = 4.6)
    @StatVariable
    private double ldl;

    @Column(name = "cholesterolRatio", nullable = false)
    @DisplayName("Коэф. атер.")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 2.8, maxCritical = 3.2)
    @StatVariable
    private double cholesterolRatio;

    @Column(name = "ALT", nullable = false)
    @DisplayName("Аланинаминотрасфераза")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 37.0, maxCritical = 47.0)
    @StatVariable
    private double alt;

    @Column(name = "AST", nullable = false)
    @DisplayName("Аспартатаминотрансфераза")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 32.0, maxCritical = 42.0)
    @StatVariable
    private double ast;

    @Column(name = "ALKP", nullable = false)
    @DisplayName("Щелочная фосфотаза")
    @IndicatorNorm(minCritical = 70.0, min = 90.0, max = 276.0, maxCritical = 336.0)
    @StatVariable
    private double alkp;

    @Column(name = "CK", nullable = false)
    @DisplayName("Креатинфосфокиназа")
    @IndicatorNorm(minCritical = 14.0, min = 34.0, max = 170.0, maxCritical = 210.0)
    @StatVariable
    private double ck;

    @Column(name = "CKMB", nullable = false)
    @DisplayName("Креатинфосфокиназа МВ")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 22.0, maxCritical = 28.0)
    @StatVariable
    private double ckmb;

    @Column(name = "LDH", nullable = false)
    @DisplayName("Лактатдкгидрогеназа")
    @IndicatorNorm(minCritical = 195.0, min = 225.0, max = 420.0, maxCritical = 480.0)
    @StatVariable
    private double ldh;

    @Column(name = "GGT", nullable = false)
    @DisplayName("ГГТ")
    @IndicatorNorm(minCritical = 6.0, min = 16.0, max = 56.0, maxCritical = 66.0)
    @StatVariable
    private double ggt;

    @Column(name = "amylase", nullable = false)
    @DisplayName("Амилаза")
    @IndicatorNorm(minCritical = 23.0, min = 33.0, max = 90.0, maxCritical = 110.0)
    @StatVariable
    private double amylase;

    @Column(name = "pancrAmylase", nullable = false)
    @DisplayName("Пакриатическая амилаза")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 48.0, maxCritical = 58.0)
    @StatVariable
    private double pancrAmylase;

    @Column(name = "glucose", nullable = false)
    @DisplayName("Глюкоза")
    @IndicatorNorm(minCritical = 3.7, min = 4.7, max = 5.9, maxCritical = 6.9)
    @StatVariable
    private double glucose;

    @Column(name = "ureaAcid", nullable = false)
    @DisplayName("Мочевая кислота")
    @IndicatorNorm(minCritical = 150.0, min = 250.0, max = 370.0, maxCritical = 470.0)
    @StatVariable
    private double ureaAcid;

    @Column(name = "CRP", nullable = false)
    @DisplayName("С-реактивный белок")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 4.5, maxCritical = 5.5)
    @StatVariable
    private double crp;

    @Column(name = "RF", nullable = false)
    @DisplayName("Ревматоидный фактор")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 35.0, maxCritical = 45.0)
    @StatVariable
    private double rf;

    @Column(name = "potassium", nullable = false)
    @DisplayName("Калий")
    @IndicatorNorm(minCritical = 3.0, min = 4.0, max = 4.6, maxCritical = 5.6)
    @StatVariable
    private double potassium;

    @Column(name = "sodium", nullable = false)
    @DisplayName("Натрий")
    @IndicatorNorm(minCritical = 134.0, min = 138.0, max = 143.0, maxCritical = 147.0)
    @StatVariable
    private double sodium;

    @Column(name = "chlorine", nullable = false)
    @DisplayName("Хлор")
    @IndicatorNorm(minCritical = 96.0, min = 100.0, max = 105.0, maxCritical = 109.0)
    @StatVariable
    private double chlorine;

    @Column(name = "commonCalcium", nullable = false)
    @DisplayName("Общий кальций")
    @IndicatorNorm(minCritical = 1.92, min = 2.2, max = 2.5, maxCritical = 2.7)
    @StatVariable
    private double commonCalcium;

    @Column(name = "ionCalcium", nullable = false)
    @DisplayName("Ионизированный кальций")
    @IndicatorNorm(minCritical = 1.11, min = 1.21, max = 1.27, maxCritical = 1.37)
    @StatVariable
    private double ionCalcium;

    @Column(name = "phosphor", nullable = false)
    @DisplayName("Фосфор")
    @IndicatorNorm(minCritical = 0.71, min = 0.92, max = 1.52, maxCritical = 1.72)
    @StatVariable
    private double phosphor;

    @Column(name = "ferrum", nullable = false)
    @DisplayName("Железо")
    @IndicatorNorm(minCritical = 8.7, min = 12.7, max = 26.6, maxCritical = 30.6)
    @StatVariable
    private double ferrum;

    @Column(name = "ferritin", nullable = false)
    @DisplayName("Ферритин")
    @IndicatorNorm(minCritical = 26.5, min = 36.5, max = 211.7, maxCritical = 251.7)
    @StatVariable
    private double ferritin;

    @DisplayName("Общий белок")
    @StatVariable
    public double getCommonProtein() {
        return commonProtein;
    }

    public void setCommonProtein(double commonProtein) {
        this.commonProtein = commonProtein;
    }

    @DisplayName("Мочевина")
    @StatVariable
    public double getUrea() {
        return urea;
    }

    public void setUrea(double urea) {
        this.urea = urea;
    }

    @DisplayName("Креатинин")
    @StatVariable
    public double getCreatinine() {
        return creatinine;
    }

    public void setCreatinine(double creatinine) {
        this.creatinine = creatinine;
    }

    @DisplayName("Общий билирубин")
    @StatVariable
    public double getCommonBiliRuby() {
        return commonBiliRuby;
    }

    public void setCommonBiliRuby(double commonBiliRuby) {
        this.commonBiliRuby = commonBiliRuby;
    }

    @DisplayName("Связанный билирубин")
    @StatVariable
    public double getLinkedBiliRuby() {
        return linkedBiliRuby;
    }

    public void setLinkedBiliRuby(double linkedBiliRuby) {
        this.linkedBiliRuby = linkedBiliRuby;
    }

    @DisplayName("Холестерин")
    @StatVariable
    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }


    @DisplayName("Триглицериды")
    @StatVariable
    //@JsonProperty("tag")
    public double getTag() {
        return tag;
    }

    //@JsonProperty("tag")
    public void setTag(double tag) {
        this.tag = tag;
    }

    @DisplayName("Липопр. выс. кон.")
    @StatVariable
    //@JsonProperty("hdl")
    public double getHdl() {
        return hdl;
    }

    //@JsonProperty("hdl")
    public void setHdl(double hdl) {
        this.hdl = hdl;
    }

    @DisplayName("Липопр. низ. кон.")
    @StatVariable
    //@JsonProperty("ldl")
    public double getLdl() {
        return ldl;
    }

    //@JsonProperty("ldl")
    public void setLdl(double ldl) {
        this.ldl = ldl;
    }

    @DisplayName("Коэф. атер.")
    @StatVariable
    public double getCholesterolRatio() {
        return cholesterolRatio;
    }

    public void setCholesterolRatio(double cholesterolRatio) {
        this.cholesterolRatio = cholesterolRatio;
    }

    @DisplayName("Аланинаминотрасфераза")
    @StatVariable
    //@JsonProperty("alt")
    public double getAlt() {
        return alt;
    }

    //@JsonProperty("alt")
    public void setAlt(double alt) {
        this.alt = alt;
    }

    @DisplayName("Аспартатаминотрансфераза")
    @StatVariable
    //@JsonProperty("ast")
    public double getAst() {
        return ast;
    }

    //@JsonProperty("ast")
    public void setAst(double ast) {
        this.ast = ast;
    }

    @DisplayName("Щелочная фосфотаза")
    @StatVariable
    //@JsonProperty("alkp")
    public double getAlkp() {
        return alkp;
    }

    //@JsonProperty("alkp")
    public void setAlkp(double alkp) {
        this.alkp = alkp;
    }

    @DisplayName("Креатинфосфокиназа")
    @StatVariable
    //@JsonProperty("ck")
    public double getCk() {
        return ck;
    }

    //@JsonProperty("ck")
    public void setCk(double ck) {
        this.ck = ck;
    }

    @DisplayName("Креатинфосфокиназа МВ")
    @StatVariable
    //@JsonProperty("ckmb")
    public double getCkmb() {
        return ckmb;
    }

    //@JsonProperty("ckmb")
    public void setCkmb(double ckmb) {
        this.ckmb = ckmb;
    }

    @DisplayName("Лактатдкгидрогеназа")
    @StatVariable
    //@JsonProperty("ldh")
    public double getLdh() {
        return ldh;
    }

    //@JsonProperty("ldh")
    public void setLdh(double ldh) {
        this.ldh = ldh;
    }

    @DisplayName("ГГТ")
    @StatVariable
    //@JsonProperty("ggt")
    public double getGgt() {
        return ggt;
    }

    //@JsonProperty("ggt")
    public void setGgt(double ggt) {
        this.ggt = ggt;
    }

    @DisplayName("Амилаза")
    @StatVariable
    public double getAmylase() {
        return amylase;
    }

    public void setAmylase(double amylase) {
        this.amylase = amylase;
    }

    @DisplayName("Пакриатическая амилаза")
    @StatVariable
    public double getPancrAmylase() {
        return pancrAmylase;
    }

    public void setPancrAmylase(double pancrAmylase) {
        this.pancrAmylase = pancrAmylase;
    }

    @DisplayName("Глюкоза")
    @StatVariable
    public double getGlucose() {
        return glucose;
    }

    public void setGlucose(double glucose) {
        this.glucose = glucose;
    }

    @DisplayName("Мочевая кислота")
    @StatVariable
    public double getUreaAcid() {
        return ureaAcid;
    }

    public void setUreaAcid(double ureaAcid) {
        this.ureaAcid = ureaAcid;
    }

    @DisplayName("С-реактивный белок")
    @StatVariable
    //@JsonProperty("crp")
    public double getCrp() {
        return crp;
    }

    //@JsonProperty("crp")
    public void setCrp(double crp) {
        this.crp = crp;
    }

    @DisplayName("Ревматоидный фактор")
    @StatVariable
    //@JsonProperty("rf")
    public double getRf() {
        return rf;
    }

    //@JsonProperty("rf")
    public void setRf(double rf) {
        this.rf = rf;
    }

    @DisplayName("Калий")
    @StatVariable
    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    @DisplayName("Натрий")
    @StatVariable
    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    @DisplayName("Хлор")
    @StatVariable
    public double getChlorine() {
        return chlorine;
    }

    public void setChlorine(double chlorine) {
        this.chlorine = chlorine;
    }

    @DisplayName("Общий кальций")
    @StatVariable
    public double getCommonCalcium() {
        return commonCalcium;
    }

    public void setCommonCalcium(double commonCalcium) {
        this.commonCalcium = commonCalcium;
    }

    @DisplayName("Ионизированный кальций")
    @StatVariable
    public double getIonCalcium() {
        return ionCalcium;
    }

    public void setIonCalcium(double ionCalcium) {
        this.ionCalcium = ionCalcium;
    }

    @DisplayName("Фосфор")
    @StatVariable
    public double getPhosphor() {
        return phosphor;
    }

    public void setPhosphor(double phosphor) {
        this.phosphor = phosphor;
    }

    @DisplayName("Железо")
    @StatVariable
    public double getFerrum() {
        return ferrum;
    }

    public void setFerrum(double ferrum) {
        this.ferrum = ferrum;
    }

    @DisplayName("Ферритин")
    @StatVariable
    public double getFerritin() {
        return ferritin;
    }

    public void setFerritin(double ferritin) {
        this.ferritin = ferritin;
    }

}
