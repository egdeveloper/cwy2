package org.egdeveloper.data.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table
public class BioChemTest implements Serializable{


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "commonProtein")
    private double commonProtein;

    @Column(name = "urea")
    private double urea;

    @Column(name = "creatinine")
    private double creatinine;

    @Column(name = "commonBiliRuby")
    private double commonBiliRuby;

    @Column(name = "linkedBiliRuby")
    private double linkedBiliRuby;

    @Column(name = "cholesterol")
    private double cholesterol;

    @Column(name = "TAG")
    private double TAG;

    @Column(name = "HDL")
    private double HDL;

    @Column(name = "LDL")
    private double LDL;

    @Column(name = "cholesterolRatio")
    private double cholesterolRatio;

    @Column(name = "ALT")
    private double ALT;

    @Column(name = "AST")
    private double AST;

    @Column(name = "ALKP")
    private double ALKP;

    @Column(name = "CK")
    private double CK;

    @Column(name = "CKMB")
    private double CKMB;

    @Column(name = "LDH")
    private double LDH;

    @Column(name = "GGT")
    private double GGT;

    @Column(name = "amylase")
    private double amylase;

    @Column(name = "pancrAmylase")
    private double pancrAmylase;

    @Column(name = "glucose")
    private double glucose;

    @Column(name = "ureaAcid")
    private double ureaAcid;

    @Column(name = "CRP")
    private double CRP;

    @Column(name = "RF")
    private double RF;

    @Column(name = "potassium")
    private double potassium;

    @Column(name = "sodium")
    private double sodium;

    @Column(name = "chlorine")
    private double chlorine;

    @Column(name = "commonCalcium")
    private double commonCalcium;

    @Column(name = "ionCalcium")
    private double ionCalcium;

    @Column(name = "phosphor")
    private double phosphor;

    @Column(name = "ferrum")
    private double ferrum;

    @Column(name = "ferritin")
    private double ferritin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCommonProtein() {
        return commonProtein;
    }

    public void setCommonProtein(double commonProtein) {
        this.commonProtein = commonProtein;
    }

    public double getUrea() {
        return urea;
    }

    public void setUrea(double urea) {
        this.urea = urea;
    }

    public double getCreatinine() {
        return creatinine;
    }

    public void setCreatinine(double creatinine) {
        this.creatinine = creatinine;
    }

    public double getCommonBiliRuby() {
        return commonBiliRuby;
    }

    public void setCommonBiliRuby(double commonBiliRuby) {
        this.commonBiliRuby = commonBiliRuby;
    }

    public double getLinkedBiliRuby() {
        return linkedBiliRuby;
    }

    public void setLinkedBiliRuby(double linkedBiliRuby) {
        this.linkedBiliRuby = linkedBiliRuby;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getTAG() {
        return TAG;
    }

    public void setTAG(double TAG) {
        this.TAG = TAG;
    }

    public double getHDL() {
        return HDL;
    }

    public void setHDL(double HDL) {
        this.HDL = HDL;
    }

    public double getLDL() {
        return LDL;
    }

    public void setLDL(double LDL) {
        this.LDL = LDL;
    }

    public double getCholesterolRatio() {
        return cholesterolRatio;
    }

    public void setCholesterolRatio(double cholesterolRatio) {
        this.cholesterolRatio = cholesterolRatio;
    }

    public double getALT() {
        return ALT;
    }

    public void setALT(double ALT) {
        this.ALT = ALT;
    }

    public double getAST() {
        return AST;
    }

    public void setAST(double AST) {
        this.AST = AST;
    }

    public double getALKP() {
        return ALKP;
    }

    public void setALKP(double ALKP) {
        this.ALKP = ALKP;
    }

    public double getCK() {
        return CK;
    }

    public void setCK(double CK) {
        this.CK = CK;
    }

    public double getCKMB() {
        return CKMB;
    }

    public void setCKMB(double CKMB) {
        this.CKMB = CKMB;
    }

    public double getLDH() {
        return LDH;
    }

    public void setLDH(double LDH) {
        this.LDH = LDH;
    }

    public double getGGT() {
        return GGT;
    }

    public void setGGT(double GGT) {
        this.GGT = GGT;
    }

    public double getAmylase() {
        return amylase;
    }

    public void setAmylase(double amylase) {
        this.amylase = amylase;
    }

    public double getPancrAmylase() {
        return pancrAmylase;
    }

    public void setPancrAmylase(double pancrAmylase) {
        this.pancrAmylase = pancrAmylase;
    }

    public double getGlucose() {
        return glucose;
    }

    public void setGlucose(double glucose) {
        this.glucose = glucose;
    }

    public double getUreaAcid() {
        return ureaAcid;
    }

    public void setUreaAcid(double ureaAcid) {
        this.ureaAcid = ureaAcid;
    }

    public double getCRP() {
        return CRP;
    }

    public void setCRP(double CRP) {
        this.CRP = CRP;
    }

    public double getRF() {
        return RF;
    }

    public void setRF(double RF) {
        this.RF = RF;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getChlorine() {
        return chlorine;
    }

    public void setChlorine(double chlorine) {
        this.chlorine = chlorine;
    }

    public double getCommonCalcium() {
        return commonCalcium;
    }

    public void setCommonCalcium(double commonCalcium) {
        this.commonCalcium = commonCalcium;
    }

    public double getIonCalcium() {
        return ionCalcium;
    }

    public void setIonCalcium(double ionCalcium) {
        this.ionCalcium = ionCalcium;
    }

    public double getPhosphor() {
        return phosphor;
    }

    public void setPhosphor(double phosphor) {
        this.phosphor = phosphor;
    }

    public double getFerrum() {
        return ferrum;
    }

    public void setFerrum(double ferrum) {
        this.ferrum = ferrum;
    }

    public double getFerritin() {
        return ferritin;
    }

    public void setFerritin(double ferritin) {
        this.ferritin = ferritin;
    }
}
