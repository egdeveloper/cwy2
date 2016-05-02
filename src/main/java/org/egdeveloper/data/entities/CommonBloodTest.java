package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table
@MedTest
@EntityID("commonBloodTest")
@DisplayName("Общий анализ крови")
public class CommonBloodTest extends MedicalTest {


    public CommonBloodTest(){
        super();
    }

    @Indicator
    @Column(name = "hemoglobin", nullable = true)
    @DisplayName("Гемоглобин")
    @IndicatorNorm(minCritical = 110.0, min = 120.0, max = 140.0, maxCritical = 150.0)
    @StatVariable
    private Double hemoglobin;

    @Indicator
    @Column(name = "RBCells", nullable = true)
    @DisplayName("Эритроциты")
    @IndicatorNorm(minCritical = 3.2, min = 3.7, max = 4.7, maxCritical = 5.2)
    @StatVariable
    private Double rbCells;

    @Indicator
    @Column(name = "colorIndex", nullable = true)
    @DisplayName("Цветовой показатель")
    @IndicatorNorm(minCritical = 0.75, min = 0.85, max = 0.95, maxCritical = 1.25)
    @StatVariable
    private Double colorIndex;

    @Indicator
    @Column(name = "IMRBCells", nullable = true)
    @DisplayName("Ретикулоциты")
    @IndicatorNorm(minCritical = 0.1, min = 0.2, max = 1.2, maxCritical = 1.3)
    @StatVariable
    private Double imrbCells;

    @Indicator
    @Column(name = "platelets", nullable = true)
    @DisplayName("Тромбоциты")
    @IndicatorNorm(minCritical = 160.0, min = 180.0, max = 300.0, maxCritical = 340.0)
    @StatVariable
    private Double platelets;

    @Indicator
    @Column(name = "ESR", nullable = true)
    @DisplayName("СОЭ")
    @IndicatorNorm(minCritical = 1.0, min = 3.0, max = 12.0, maxCritical = 18.0)
    @StatVariable
    private Double esr;

    @Indicator
    @Column(name = "WBCells", nullable = true)
    @DisplayName("Лейкоциты")
    @IndicatorNorm(minCritical = 3.0, min = 5.0, max = 7.0, maxCritical = 11.0)
    @StatVariable
    private Double wbCells;

    @Indicator
    @Column(name = "bandCells", nullable = true)
    @DisplayName("Палочкоядерные")
    @IndicatorNorm(minCritical = 0.5, min = 1.5, max = 5.0, maxCritical = 7.0)
    @StatVariable
    private Double bandCells;

    @Indicator
    @Column(name = "segmentCells", nullable = true)
    @DisplayName("Сегментоядерные")
    @IndicatorNorm(minCritical = 37.0, min = 57.0, max = 62.0, maxCritical = 82.0)
    @StatVariable
    private Double segmentCells;

    @Indicator
    @Column(name = "eosinCells", nullable = true)
    @DisplayName("Эозинофилы")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 4.0, maxCritical = 6.0)
    @StatVariable
    private Double eosinCells;

    @Indicator
    @Column(name = "basophil", nullable = true)
    @DisplayName("Базофилы")
    @IndicatorNorm(minCritical = 0.0, min = 0.0, max = 0.9, maxCritical = 1.1)
    @StatVariable
    private Double basophil;

    @Indicator
    @Column(name = "NKCells", nullable = true)
    @DisplayName("Лимфоциты")
    @IndicatorNorm(minCritical = 13.0, min = 23.0, max = 35.0, maxCritical = 45.0)
    @StatVariable
    private Double nkCells;

    @Indicator
    @Column(name = "monoCells", nullable = true)
    @DisplayName("Моноциты")
    @IndicatorNorm(minCritical = 1.0, min = 3.0, max = 7.0, maxCritical = 11.0)
    @StatVariable
    private Double monoCells;

    @Indicator
    @DisplayName("Гемоглобин")
    @StatVariable
    public Double getHemoglobin() {
        return hemoglobin;
    }

    @Indicator
    public void setHemoglobin(Double hemoglobin) {
        this.hemoglobin = hemoglobin;
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
    @DisplayName("Цветовой показатель")
    @StatVariable
    public Double getColorIndex() {
        return colorIndex;
    }

    @Indicator
    public void setColorIndex(Double colorIndex) {
        this.colorIndex = colorIndex;
    }

    @Indicator
    @DisplayName("Ретикулоциты")
    @StatVariable
    public Double getImrbCells() {
        return imrbCells;
    }

    @Indicator
    public void setImrbCells(Double IMRBCells) {
        this.imrbCells = imrbCells;
    }

    @Indicator
    @DisplayName("Тромбоциты")
    @StatVariable
    public Double getPlatelets() {
        return platelets;
    }

    @Indicator
    public void setPlatelets(Double platelets) {
        this.platelets = platelets;
    }

    @Indicator
    @DisplayName("СОЭ")
    @StatVariable
    public Double getEsr() {
        return esr;
    }

    @Indicator
    public void setEsr(Double esr) {
        this.esr = esr;
    }

    @Indicator
    @DisplayName("Лейкоциты")
    @StatVariable
    public Double getWbCells() {
        return wbCells;
    }

    @Indicator
    public void setWbCells(Double wbCells) {
        this.wbCells = wbCells;
    }

    @Indicator
    @DisplayName("Палочкоядерные")
    @StatVariable
    public Double getBandCells() {
        return bandCells;
    }

    @Indicator
    public void setBandCells(Double bandCells) {
        this.bandCells = bandCells;
    }

    @Indicator
    @DisplayName("Сегментоядерные")
    @StatVariable
    public Double getSegmentCells() {
        return segmentCells;
    }

    @Indicator
    public void setSegmentCells(Double segmentCells) {
        this.segmentCells = segmentCells;
    }

    @Indicator
    @DisplayName("Эозинофилы")
    @StatVariable
    public Double getEosinCells() {
        return eosinCells;
    }

    @Indicator
    public void setEosinCells(Double eosinCells) {
        this.eosinCells = eosinCells;
    }

    @Indicator
    @DisplayName("Базофилы")
    @StatVariable
    public Double getBasophil() {
        return basophil;
    }

    @Indicator
    public void setBasophil(Double basophil) {
        this.basophil = basophil;
    }

    @Indicator
    @DisplayName("Лимфоциты")
    @StatVariable
    public Double getNkCells() {
        return nkCells;
    }

    @Indicator
    public void setNkCells(Double nkCells) {
        this.nkCells = nkCells;
    }

    @Indicator
    @DisplayName("Моноциты")
    @StatVariable
    public Double getMonoCells() {
        return monoCells;
    }

    @Indicator
    public void setMonoCells(Double monoCells) {
        this.monoCells = monoCells;
    }

}
