package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.*;

import javax.persistence.*;


@Entity
@Table
@MedTest
@EntityID("commonBloodTest")
@DisplayName("Общий анализ крови")
public class CommonBloodTest extends MedicalTest {


    public CommonBloodTest(){
        super();
    }

    @Column(name = "hemoglobin", nullable = false)
    @DisplayName("Гемоглобин")
    @IndicatorNorm(minCritical = 110.0, min = 120.0, max = 140.0, maxCritical = 150.0)
    @StatVariable
    private double hemoglobin;

    @Column(name = "RBCells", nullable = false)
    @DisplayName("Эритроциты")
    @IndicatorNorm(minCritical = 3.2, min = 3.7, max = 4.7, maxCritical = 5.2)
    @StatVariable
    private double rbCells;

    @Column(name = "colorIndex", nullable = false)
    @DisplayName("Цветовой показатель")
    @IndicatorNorm(minCritical = 0.75, min = 0.85, max = 0.95, maxCritical = 1.25)
    @StatVariable
    private double colorIndex;

    @Column(name = "IMRBCells", nullable = false)
    @DisplayName("Ретикулоциты")
    @IndicatorNorm(minCritical = 0.1, min = 0.2, max = 1.2, maxCritical = 1.3)
    @StatVariable
    private double imrbCells;

    @Column(name = "platelets", nullable = false)
    @DisplayName("Тромбоциты")
    @IndicatorNorm(minCritical = 160.0, min = 180.0, max = 300.0, maxCritical = 340.0)
    @StatVariable
    private double platelets;

    @Column(name = "ESR", nullable = false)
    @DisplayName("СОЭ")
    @IndicatorNorm(minCritical = 1.0, min = 3.0, max = 12.0, maxCritical = 18.0)
    @StatVariable
    private double esr;

    @Column(name = "WBCells", nullable = false)
    @DisplayName("Лейкоциты")
    @IndicatorNorm(minCritical = 3.0, min = 5.0, max = 7.0, maxCritical = 11.0)
    @StatVariable
    private double wbCells;

    @Column(name = "bandCells", nullable = false)
    @DisplayName("Палочкоядерные")
    @IndicatorNorm(minCritical = 0.5, min = 1.5, max = 5.0, maxCritical = 7.0)
    @StatVariable
    private double bandCells;

    @Column(name = "segmentCells", nullable = false)
    @DisplayName("Сегментоядерные")
    @IndicatorNorm(minCritical = 37.0, min = 57.0, max = 62.0, maxCritical = 82.0)
    @StatVariable
    private double segmentCells;

    @Column(name = "eosinCells", nullable = false)
    @DisplayName("Эозинофилы")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 4.0, maxCritical = 6.0)
    @StatVariable
    private double eosinCells;

    @Column(name = "basophil", nullable = false)
    @DisplayName("Базофилы")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 0.9, maxCritical = 1.1)
    @StatVariable
    private double basophil;

    @Column(name = "NKCells", nullable = false)
    @DisplayName("Лимфоциты")
    @IndicatorNorm(minCritical = 13.0, min = 23.0, max = 35.0, maxCritical = 45.0)
    @StatVariable
    private double nkCells;

    @Column(name = "monoCells", nullable = false)
    @DisplayName("Моноциты")
    @IndicatorNorm(minCritical = 1.0, min = 3.0, max = 7.0, maxCritical = 11.0)
    @StatVariable
    private double monoCells;

    @DisplayName("Гемоглобин")
    @StatVariable
    public double getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(double hemoglobin) {
        this.hemoglobin = hemoglobin;
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

    @DisplayName("Цветовой показатель")
    @StatVariable
    public double getColorIndex() {
        return colorIndex;
    }

    public void setColorIndex(double colorIndex) {
        this.colorIndex = colorIndex;
    }

    @DisplayName("Ретикулоциты")
    @StatVariable
    //@JsonProperty("imrbCells")
    public double getImrbCells() {
        return imrbCells;
    }

    //@JsonProperty("imrbCells")
    public void setImrbCells(double IMRBCells) {
        this.imrbCells = imrbCells;
    }

    @DisplayName("Тромбоциты")
    @StatVariable
    public double getPlatelets() {
        return platelets;
    }

    public void setPlatelets(double platelets) {
        this.platelets = platelets;
    }

    @DisplayName("СОЭ")
    @StatVariable
    //@JsonProperty("esr")
    public double getEsr() {
        return esr;
    }

    //@JsonProperty("esr")
    public void setEsr(double esr) {
        this.esr = esr;
    }

    @DisplayName("Лейкоциты")
    @StatVariable
    //@JsonProperty("wbCells")
    public double getWbCells() {
        return wbCells;
    }

    //@JsonProperty("wbCells")
    public void setWbCells(double wbCells) {
        this.wbCells = wbCells;
    }

    @DisplayName("Палочкоядерные")
    @StatVariable
    public double getBandCells() {
        return bandCells;
    }

    public void setBandCells(double bandCells) {
        this.bandCells = bandCells;
    }

    @DisplayName("Сегментоядерные")
    @StatVariable
    public double getSegmentCells() {
        return segmentCells;
    }

    public void setSegmentCells(double segmentCells) {
        this.segmentCells = segmentCells;
    }

    @DisplayName("Эозинофилы")
    @StatVariable
    public double getEosinCells() {
        return eosinCells;
    }

    public void setEosinCells(double eosinCells) {
        this.eosinCells = eosinCells;
    }

    @DisplayName("Базофилы")
    @StatVariable
    public double getBasophil() {
        return basophil;
    }

    public void setBasophil(double basophil) {
        this.basophil = basophil;
    }

    @DisplayName("Лимфоциты")
    @StatVariable
    //@JsonProperty("nkCells")
    public double getNkCells() {
        return nkCells;
    }

    //@JsonProperty("nkCells")
    public void setNkCells(double nkCells) {
        this.nkCells = nkCells;
    }

    @DisplayName("Моноциты")
    @StatVariable
    public double getMonoCells() {
        return monoCells;
    }

    public void setMonoCells(double monoCells) {
        this.monoCells = monoCells;
    }

}
