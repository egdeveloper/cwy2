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
@EntityID("bioChemTest")
@DisplayName("Биохимический анализ крови")
public class BioChemTest extends MedicalTest {


    public BioChemTest(){
        super();
    }


    @Column(name = "commonProtein")
    @NotNull
    @DisplayName("Общий белок")
    @StatVariable
    private double commonProtein;

    @Column(name = "urea")
    @NotNull
    @DisplayName("Мочевина")
    @StatVariable
    private double urea;

    @Column(name = "creatinine")
    @NotNull
    @DisplayName("Креатинин")
    @StatVariable
    private double creatinine;

    @Column(name = "commonBiliRuby")
    @NotNull
    @DisplayName("Общий билирубин")
    @StatVariable
    private double commonBiliRuby;

    @Column(name = "linkedBiliRuby")
    @NotNull
    @DisplayName("Связанный билирубин")
    @StatVariable
    private double linkedBiliRuby;

    @Column(name = "cholesterol")
    @NotNull
    @DisplayName("Холестерин")
    @StatVariable
    private double cholesterol;

    @Column(name = "TAG")
    @NotNull
    @DisplayName("Триглицериды")
    @StatVariable
    private double tag;

    @Column(name = "HDL")
    @NotNull
    @DisplayName("Липопр. выс. кон.")
    @StatVariable
    private double hdl;

    @Column(name = "LDL")
    @NotNull
    @DisplayName("Липопр. низ. кон.")
    @StatVariable
    private double ldl;

    @Column(name = "cholesterolRatio")
    @NotNull
    @DisplayName("Коэф. атер.")
    @StatVariable
    private double cholesterolRatio;

    @Column(name = "ALT")
    @NotNull
    @DisplayName("Аланинаминотрасфераза")
    @StatVariable
    private double alt;

    @Column(name = "AST")
    @NotNull
    @DisplayName("Аспартатаминотрансфераза")
    @StatVariable
    private double ast;

    @Column(name = "ALKP")
    @NotNull
    @DisplayName("Щелочная фосфотаза")
    @StatVariable
    private double alkp;

    @Column(name = "CK")
    @NotNull
    @DisplayName("Креатинфосфокиназа")
    @StatVariable
    private double ck;

    @Column(name = "CKMB")
    @NotNull
    @DisplayName("Креатинфосфокиназа МВ")
    @StatVariable
    private double ckmb;

    @Column(name = "LDH")
    @NotNull
    @DisplayName("Лактатдкгидрогеназа")
    @StatVariable
    private double ldh;

    @Column(name = "GGT")
    @NotNull
    @DisplayName("ГГТ")
    @StatVariable
    private double ggt;

    @Column(name = "amylase")
    @NotNull
    @DisplayName("Амилаза")
    @StatVariable
    private double amylase;

    @Column(name = "pancrAmylase")
    @NotNull
    @DisplayName("Пакриатическая амилаза")
    @StatVariable
    private double pancrAmylase;

    @Column(name = "glucose")
    @NotNull
    @DisplayName("Глюкоза")
    @StatVariable
    private double glucose;

    @Column(name = "ureaAcid")
    @NotNull
    @DisplayName("Мочевая кислота")
    @StatVariable
    private double ureaAcid;

    @Column(name = "CRP")
    @NotNull
    @DisplayName("С-реактивный белок")
    @StatVariable
    private double crp;

    @Column(name = "RF")
    @NotNull
    @DisplayName("Ревматоидный фактор")
    @StatVariable
    private double rf;

    @Column(name = "potassium")
    @NotNull
    @DisplayName("Калий")
    @StatVariable
    private double potassium;

    @Column(name = "sodium")
    @NotNull
    @DisplayName("Натрий")
    @StatVariable
    private double sodium;

    @Column(name = "chlorine")
    @NotNull
    @DisplayName("Хлор")
    @StatVariable
    private double chlorine;

    @Column(name = "commonCalcium")
    @NotNull
    @DisplayName("Общий кальций")
    @StatVariable
    private double commonCalcium;

    @Column(name = "ionCalcium")
    @NotNull
    @DisplayName("Ионизированный кальций")
    @StatVariable
    private double ionCalcium;

    @Column(name = "phosphor")
    @NotNull
    @DisplayName("Фосфор")
    @StatVariable
    private double phosphor;

    @Column(name = "ferrum")
    @NotNull
    @DisplayName("Железо")
    @StatVariable
    private double ferrum;

    @Column(name = "ferritin")
    @NotNull
    @DisplayName("Ферритин")
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
