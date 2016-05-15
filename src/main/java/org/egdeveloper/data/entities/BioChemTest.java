package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table
@MedTest
@EntityID("bioChemTest")
@DisplayName("Биохимический анализ крови")
public class BioChemTest extends MedicalTest {


    public BioChemTest(){
        super();
    }

    @Indicator
    @Column(name = "commonProtein", nullable = true)
    @DisplayName("Общий белок")
    @IndicatorNorm(minCritical = 56.0, min = 76.0, max = 77.0, maxCritical = 97.0)
    @StatVariable
    private Double commonProtein;

    @Indicator
    @Column(name = "urea", nullable = true)
    @DisplayName("Мочевина")
    @IndicatorNorm(minCritical = 1.2, min = 2.2, max = 7.8, maxCritical = 8.8)
    @StatVariable
    private Double urea;

    @Indicator
    @Column(name = "creatinine", nullable = true)
    @DisplayName("Креатинин")
    @IndicatorNorm(minCritical = 43.0, min = 63.0, max = 105.0, maxCritical = 125.0)
    @StatVariable
    private Double creatinine;

    @Indicator
    @Column(name = "commonBiliRuby", nullable = true)
    @DisplayName("Общий билирубин")
    @IndicatorNorm(minCritical = 1.5, min = 2.5, max = 18.0, maxCritical = 24.0)
    @StatVariable
    private Double commonBiliRuby;

    @Indicator
    @Column(name = "linkedBiliRuby", nullable = true)
    @DisplayName("Связанный билирубин")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 2.9, maxCritical = 3.9)
    @StatVariable
    private Double linkedBiliRuby;

    @Indicator
    @Column(name = "cholesterol", nullable = true)
    @DisplayName("Холестерин")
    @IndicatorNorm(minCritical = 3.13, min = 4.13, max = 4.7, maxCritical = 5.7)
    @StatVariable
    private Double cholesterol;

    @Indicator
    @Column(name = "TAG", nullable = true)
    @DisplayName("Триглицериды")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 1.6, maxCritical = 1.8)
    @StatVariable
    private Double tag;

    @Indicator
    @Column(name = "HDL", nullable = true)
    @DisplayName("Липопр. выс. кон.")
    @IndicatorNorm(minCritical = 0.8, min = 1.0, max = 1.44, maxCritical = 1.64)
    @StatVariable
    private Double hdl;

    @Indicator
    @Column(name = "LDL", nullable = true)
    @DisplayName("Липопр. низ. кон.")
    @IndicatorNorm(minCritical = 1.0, min = 1.4, max = 4.2, maxCritical = 4.6)
    @StatVariable
    private Double ldl;

    @Indicator
    @Column(name = "cholesterolRatio", nullable = true)
    @DisplayName("Коэф. атер.")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 2.8, maxCritical = 3.2)
    @StatVariable
    private Double cholesterolRatio;

    @Indicator
    @Column(name = "ALT", nullable = true)
    @DisplayName("Аланинаминотрасфераза")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 37.0, maxCritical = 47.0)
    @StatVariable
    private Double alt;

    @Indicator
    @Column(name = "AST", nullable = true)
    @DisplayName("Аспартатаминотрансфераза")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 32.0, maxCritical = 42.0)
    @StatVariable
    private Double ast;

    @Indicator
    @Column(name = "ALKP", nullable = true)
    @DisplayName("Щелочная фосфотаза")
    @IndicatorNorm(minCritical = 70.0, min = 90.0, max = 276.0, maxCritical = 336.0)
    @StatVariable
    private Double alkp;

    @Indicator
    @Column(name = "CK", nullable = true)
    @DisplayName("Креатинфосфокиназа")
    @IndicatorNorm(minCritical = 14.0, min = 34.0, max = 170.0, maxCritical = 210.0)
    @StatVariable
    private Double ck;

    @Indicator
    @Column(name = "CKMB", nullable = true)
    @DisplayName("Креатинфосфокиназа МВ")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 22.0, maxCritical = 28.0)
    @StatVariable
    private Double ckmb;

    @Indicator
    @Column(name = "LDH", nullable = true)
    @DisplayName("Лактатдкгидрогеназа")
    @IndicatorNorm(minCritical = 195.0, min = 225.0, max = 420.0, maxCritical = 480.0)
    @StatVariable
    private Double ldh;

    @Indicator
    @Column(name = "GGT", nullable = true)
    @DisplayName("ГГТ")
    @IndicatorNorm(minCritical = 6.0, min = 16.0, max = 56.0, maxCritical = 66.0)
    @StatVariable
    private Double ggt;

    @Indicator
    @Column(name = "amylase", nullable = true)
    @DisplayName("Амилаза")
    @IndicatorNorm(minCritical = 23.0, min = 33.0, max = 90.0, maxCritical = 110.0)
    @StatVariable
    private Double amylase;

    @Indicator
    @Column(name = "pancrAmylase", nullable = true)
    @DisplayName("Пакриатическая амилаза")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 48.0, maxCritical = 58.0)
    @StatVariable
    private Double pancrAmylase;

    @Indicator
    @Column(name = "glucose", nullable = true)
    @DisplayName("Глюкоза")
    @IndicatorNorm(minCritical = 3.7, min = 4.7, max = 5.9, maxCritical = 6.9)
    @StatVariable
    private Double glucose;

    @Indicator
    @Column(name = "ureaAcid", nullable = true)
    @DisplayName("Мочевая кислота")
    @IndicatorNorm(minCritical = 150.0, min = 250.0, max = 370.0, maxCritical = 470.0)
    @StatVariable
    private Double ureaAcid;

    @Indicator
    @Column(name = "CRP", nullable = true)
    @DisplayName("С-реактивный белок")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 4.5, maxCritical = 5.5)
    @StatVariable
    private Double crp;

    @Indicator
    @Column(name = "RF", nullable = true)
    @DisplayName("Ревматоидный фактор")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 35.0, maxCritical = 45.0)
    @StatVariable
    private Double rf;

    @Indicator
    @Column(name = "potassium", nullable = true)
    @DisplayName("Калий")
    @IndicatorNorm(minCritical = 3.0, min = 4.0, max = 4.6, maxCritical = 5.6)
    @StatVariable
    private Double potassium;

    @Indicator
    @Column(name = "sodium", nullable = true)
    @DisplayName("Натрий")
    @IndicatorNorm(minCritical = 134.0, min = 138.0, max = 143.0, maxCritical = 147.0)
    @StatVariable
    private Double sodium;

    @Indicator
    @Column(name = "chlorine", nullable = true)
    @DisplayName("Хлор")
    @IndicatorNorm(minCritical = 96.0, min = 100.0, max = 105.0, maxCritical = 109.0)
    @StatVariable
    private Double chlorine;

    @Indicator
    @Column(name = "commonCalcium", nullable = true)
    @DisplayName("Общий кальций")
    @IndicatorNorm(minCritical = 1.92, min = 2.2, max = 2.5, maxCritical = 2.7)
    @StatVariable
    private Double commonCalcium;

    @Indicator
    @Column(name = "ionCalcium", nullable = true)
    @DisplayName("Ионизированный кальций")
    @IndicatorNorm(minCritical = 1.11, min = 1.21, max = 1.27, maxCritical = 1.37)
    @StatVariable
    private Double ionCalcium;

    @Indicator
    @Column(name = "phosphor", nullable = true)
    @DisplayName("Фосфор")
    @IndicatorNorm(minCritical = 0.71, min = 0.92, max = 1.52, maxCritical = 1.72)
    @StatVariable
    private Double phosphor;

    @Indicator
    @Column(name = "ferrum", nullable = true)
    @DisplayName("Железо")
    @IndicatorNorm(minCritical = 8.7, min = 12.7, max = 26.6, maxCritical = 30.6)
    @StatVariable
    private Double ferrum;

    @Indicator
    @Column(name = "ferritin", nullable = true)
    @DisplayName("Ферритин")
    @IndicatorNorm(minCritical = 26.5, min = 36.5, max = 211.7, maxCritical = 251.7)
    @StatVariable
    private Double ferritin;

    @Indicator
    @DisplayName("Общий белок")
    @StatVariable
    public Double getCommonProtein() {
        return commonProtein;
    }

    @Indicator
    public void setCommonProtein(Double commonProtein) {
        this.commonProtein = commonProtein;
    }

    @Indicator
    @DisplayName("Мочевина")
    @StatVariable
    public Double getUrea() {
        return urea;
    }

    @Indicator
    public void setUrea(Double urea) {
        this.urea = urea;
    }

    @Indicator
    @DisplayName("Креатинин")
    @StatVariable
    public Double getCreatinine() {
        return creatinine;
    }

    @Indicator
    public void setCreatinine(Double creatinine) {
        this.creatinine = creatinine;
    }

    @Indicator
    @DisplayName("Общий билирубин")
    @StatVariable
    public Double getCommonBiliRuby() {
        return commonBiliRuby;
    }

    @Indicator
    public void setCommonBiliRuby(Double commonBiliRuby) {
        this.commonBiliRuby = commonBiliRuby;
    }

    @Indicator
    @DisplayName("Связанный билирубин")
    @StatVariable
    public Double getLinkedBiliRuby() {
        return linkedBiliRuby;
    }

    @Indicator
    public void setLinkedBiliRuby(Double linkedBiliRuby) {
        this.linkedBiliRuby = linkedBiliRuby;
    }

    @Indicator
    @DisplayName("Холестерин")
    @StatVariable
    public Double getCholesterol() {
        return cholesterol;
    }

    @Indicator
    public void setCholesterol(Double cholesterol) {
        this.cholesterol = cholesterol;
    }


    @Indicator
    @DisplayName("Триглицериды")
    @StatVariable
    public Double getTag() {
        return tag;
    }

    @Indicator
    public void setTag(Double tag) {
        this.tag = tag;
    }

    @Indicator
    @DisplayName("Липопр. выс. кон.")
    @StatVariable
    public Double getHdl() {
        return hdl;
    }

    @Indicator
    public void setHdl(Double hdl) {
        this.hdl = hdl;
    }

    @Indicator
    @DisplayName("Липопр. низ. кон.")
    @StatVariable
    public Double getLdl() {
        return ldl;
    }

    @Indicator
    public void setLdl(Double ldl) {
        this.ldl = ldl;
    }

    @Indicator
    @DisplayName("Коэф. атер.")
    @StatVariable
    public Double getCholesterolRatio() {
        return cholesterolRatio;
    }

    @Indicator
    public void setCholesterolRatio(Double cholesterolRatio) {
        this.cholesterolRatio = cholesterolRatio;
    }

    @Indicator
    @DisplayName("Аланинаминотрасфераза")
    @StatVariable
    public Double getAlt() {
        return alt;
    }

    @Indicator
    public void setAlt(Double alt) {
        this.alt = alt;
    }

    @Indicator
    @DisplayName("Аспартатаминотрансфераза")
    @StatVariable
    public Double getAst() {
        return ast;
    }

    @Indicator
    public void setAst(Double ast) {
        this.ast = ast;
    }

    @DisplayName("Щелочная фосфотаза")
    @StatVariable
    public Double getAlkp() {
        return alkp;
    }

    @Indicator
    public void setAlkp(Double alkp) {
        this.alkp = alkp;
    }

    @Indicator
    @DisplayName("Креатинфосфокиназа")
    @StatVariable
    public Double getCk() {
        return ck;
    }

    @Indicator
    public void setCk(Double ck) {
        this.ck = ck;
    }

    @Indicator
    @DisplayName("Креатинфосфокиназа МВ")
    @StatVariable
    public Double getCkmb() {
        return ckmb;
    }

    @Indicator
    public void setCkmb(Double ckmb) {
        this.ckmb = ckmb;
    }

    @Indicator
    @DisplayName("Лактатдкгидрогеназа")
    @StatVariable
    public Double getLdh() {
        return ldh;
    }

    @Indicator
    public void setLdh(Double ldh) {
        this.ldh = ldh;
    }

    @Indicator
    @DisplayName("ГГТ")
    @StatVariable
    public Double getGgt() {
        return ggt;
    }

    @Indicator
    public void setGgt(Double ggt) {
        this.ggt = ggt;
    }

    @Indicator
    @DisplayName("Амилаза")
    @StatVariable
    public Double getAmylase() {
        return amylase;
    }

    @Indicator
    public void setAmylase(Double amylase) {
        this.amylase = amylase;
    }

    @Indicator
    @DisplayName("Пакриатическая амилаза")
    @StatVariable
    public Double getPancrAmylase() {
        return pancrAmylase;
    }

    @Indicator
    public void setPancrAmylase(Double pancrAmylase) {
        this.pancrAmylase = pancrAmylase;
    }

    @Indicator
    @DisplayName("Глюкоза")
    @StatVariable
    public Double getGlucose() {
        return glucose;
    }

    @Indicator
    public void setGlucose(Double glucose) {
        this.glucose = glucose;
    }

    @Indicator
    @DisplayName("Мочевая кислота")
    @StatVariable
    public Double getUreaAcid() {
        return ureaAcid;
    }

    @Indicator
    public void setUreaAcid(Double ureaAcid) {
        this.ureaAcid = ureaAcid;
    }

    @Indicator
    @DisplayName("С-реактивный белок")
    @StatVariable
    public Double getCrp() {
        return crp;
    }

    @Indicator
    public void setCrp(Double crp) {
        this.crp = crp;
    }

    @Indicator
    @DisplayName("Ревматоидный фактор")
    @StatVariable
    public Double getRf() {
        return rf;
    }

    @Indicator
    public void setRf(Double rf) {
        this.rf = rf;
    }

    @Indicator
    @DisplayName("Калий")
    @StatVariable
    public Double getPotassium() {
        return potassium;
    }

    @Indicator
    public void setPotassium(Double potassium) {
        this.potassium = potassium;
    }

    @Indicator
    @DisplayName("Натрий")
    @StatVariable
    public Double getSodium() {
        return sodium;
    }

    @Indicator
    public void setSodium(Double sodium) {
        this.sodium = sodium;
    }

    @Indicator
    @DisplayName("Хлор")
    @StatVariable
    public Double getChlorine() {
        return chlorine;
    }

    @Indicator
    public void setChlorine(Double chlorine) {
        this.chlorine = chlorine;
    }

    @Indicator
    @DisplayName("Общий кальций")
    @StatVariable
    public Double getCommonCalcium() {
        return commonCalcium;
    }

    @Indicator
    public void setCommonCalcium(Double commonCalcium) {
        this.commonCalcium = commonCalcium;
    }

    @Indicator
    @DisplayName("Ионизированный кальций")
    @StatVariable
    public Double getIonCalcium() {
        return ionCalcium;
    }

    @Indicator
    public void setIonCalcium(Double ionCalcium) {
        this.ionCalcium = ionCalcium;
    }

    @Indicator
    @DisplayName("Фосфор")
    @StatVariable
    public Double getPhosphor() {
        return phosphor;
    }

    @Indicator
    public void setPhosphor(Double phosphor) {
        this.phosphor = phosphor;
    }

    @Indicator
    @DisplayName("Железо")
    @StatVariable
    public Double getFerrum() {
        return ferrum;
    }

    @Indicator
    public void setFerrum(Double ferrum) {
        this.ferrum = ferrum;
    }

    @Indicator
    @DisplayName("Ферритин")
    @StatVariable
    public Double getFerritin() {
        return ferritin;
    }

    @Indicator
    public void setFerritin(Double ferritin) {
        this.ferritin = ferritin;
    }

}
