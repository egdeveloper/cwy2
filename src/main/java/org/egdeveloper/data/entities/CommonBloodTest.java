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
@EntityID("commonBloodTest")
@DisplayName("Общий анализ крови")
public class CommonBloodTest extends MedicalTest {


    public CommonBloodTest(){
        super();
    }

    @Column(name = "hemoglobin")
    @NotNull
    @DisplayName("Гемоглобин")
    @StatVariable
    private double hemoglobin;

    @Column(name = "RBCells")
    @NotNull
    @DisplayName("Эритроциты")
    @StatVariable
    private double rbCells;

    @Column(name = "colorIndex")
    @NotNull
    @DisplayName("Цветовой показатель")
    @StatVariable
    private double colorIndex;

    @Column(name = "IMRBCells")
    @NotNull
    @DisplayName("Ретикулоциты")
    @StatVariable
    private double imrbCells;

    @Column(name = "platelets")
    @NotNull
    @DisplayName("Тромбоциты")
    @StatVariable
    private double platelets;

    @Column(name = "ESR")
    @NotNull
    @DisplayName("СОЭ")
    @StatVariable
    private double esr;

    @Column(name = "WBCells")
    @NotNull
    @DisplayName("Лейкоциты")
    @StatVariable
    private double wbCells;

    @Column(name = "bandCells")
    @NotNull
    @DisplayName("Палочкоядерные")
    @StatVariable
    private double bandCells;

    @Column(name = "segmentCells")
    @NotNull
    @DisplayName("Сегментоядерные")
    @StatVariable
    private double segmentCells;

    @Column(name = "eosinCells")
    @NotNull
    @DisplayName("Эозинофилы")
    @StatVariable
    private double eosinCells;

    @Column(name = "basophil")
    @NotNull
    @DisplayName("Базофилы")
    @StatVariable
    private double basophil;

    @Column(name = "NKCells")
    @NotNull
    @DisplayName("Лимфоциты")
    @StatVariable
    private double nkCells;

    @Column(name = "monoCells")
    @NotNull
    @DisplayName("Моноциты")
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
