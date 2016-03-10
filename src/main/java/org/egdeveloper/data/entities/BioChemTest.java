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
@EntityID("bioChemTest")
@DisplayName("Биохимический анализ крови")
public class BioChemTest extends MedicalTest {


    public BioChemTest(){}


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
    private double TAG;

    @Column(name = "HDL")
    @NotNull
    @DisplayName("Липопр. выс. кон.")
    @StatVariable
    private double HDL;

    @Column(name = "LDL")
    @NotNull
    @DisplayName("Липопр. низ. кон.")
    @StatVariable
    private double LDL;

    @Column(name = "cholesterolRatio")
    @NotNull
    @DisplayName("Коэф. атер.")
    @StatVariable
    private double cholesterolRatio;

    @Column(name = "ALT")
    @NotNull
    @DisplayName("Аланинаминотрасфераза")
    @StatVariable
    private double ALT;

    @Column(name = "AST")
    @NotNull
    @DisplayName("Аспартатаминотрансфераза")
    @StatVariable
    private double AST;

    @Column(name = "ALKP")
    @NotNull
    @DisplayName("Щелочная фосфотаза")
    @StatVariable
    private double ALKP;

    @Column(name = "CK")
    @NotNull
    @DisplayName("Креатинфосфокиназа")
    @StatVariable
    private double CK;

    @Column(name = "CKMB")
    @NotNull
    @DisplayName("Креатинфосфокиназа МВ")
    @StatVariable
    private double CKMB;

    @Column(name = "LDH")
    @NotNull
    @DisplayName("Лактатдкгидрогеназа")
    @StatVariable
    private double LDH;

    @Column(name = "GGT")
    @NotNull
    @DisplayName("ГГТ")
    @StatVariable
    private double GGT;

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
    private double CRP;

    @Column(name = "RF")
    @NotNull
    @DisplayName("Ревматоидный фактор")
    @StatVariable
    private double RF;

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

    @OneToOne
    @PrimaryKeyJoinColumn
    private Patient patient;

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
    public double getTAG() {
        return TAG;
    }

    public void setTAG(double TAG) {
        this.TAG = TAG;
    }

    @DisplayName("Липопр. выс. кон.")
    @StatVariable
    public double getHDL() {
        return HDL;
    }

    public void setHDL(double HDL) {
        this.HDL = HDL;
    }

    @DisplayName("Липопр. низ. кон.")
    @StatVariable
    public double getLDL() {
        return LDL;
    }

    public void setLDL(double LDL) {
        this.LDL = LDL;
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
    public double getALT() {
        return ALT;
    }

    public void setALT(double ALT) {
        this.ALT = ALT;
    }

    @DisplayName("Аспартатаминотрансфераза")
    @StatVariable
    public double getAST() {
        return AST;
    }

    public void setAST(double AST) {
        this.AST = AST;
    }

    @DisplayName("Щелочная фосфотаза")
    @StatVariable
    public double getALKP() {
        return ALKP;
    }

    public void setALKP(double ALKP) {
        this.ALKP = ALKP;
    }

    @DisplayName("Креатинфосфокиназа")
    @StatVariable
    public double getCK() {
        return CK;
    }

    public void setCK(double CK) {
        this.CK = CK;
    }

    @DisplayName("Креатинфосфокиназа МВ")
    @StatVariable
    public double getCKMB() {
        return CKMB;
    }

    public void setCKMB(double CKMB) {
        this.CKMB = CKMB;
    }

    @DisplayName("Лактатдкгидрогеназа")
    @StatVariable
    public double getLDH() {
        return LDH;
    }

    public void setLDH(double LDH) {
        this.LDH = LDH;
    }

    @DisplayName("ГГТ")
    @StatVariable
    public double getGGT() {
        return GGT;
    }

    public void setGGT(double GGT) {
        this.GGT = GGT;
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
    public double getCRP() {
        return CRP;
    }

    public void setCRP(double CRP) {
        this.CRP = CRP;
    }

    @DisplayName("Ревматоидный фактор")
    @StatVariable
    public double getRF() {
        return RF;
    }

    public void setRF(double RF) {
        this.RF = RF;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
