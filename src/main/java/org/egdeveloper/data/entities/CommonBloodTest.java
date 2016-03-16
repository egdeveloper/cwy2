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
    private double RBCells;

    @Column(name = "colorIndex")
    @NotNull
    @DisplayName("Цветовой показатель")
    @StatVariable
    private double colorIndex;

    @Column(name = "IMRBCells")
    @NotNull
    @DisplayName("Ретикулоциты")
    @StatVariable
    private double IMRBCells;

    @Column(name = "platelets")
    @NotNull
    @DisplayName("Тромбоциты")
    @StatVariable
    private double platelets;

    @Column(name = "ESR")
    @NotNull
    @DisplayName("СОЭ")
    @StatVariable
    private double ESR;

    @Column(name = "WBCells")
    @NotNull
    @DisplayName("Лейкоциты")
    @StatVariable
    private double WBCells;

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
    private double NKCells;

    @Column(name = "monoCells")
    @NotNull
    @DisplayName("Моноциты")
    @StatVariable
    private double monoCells;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Patient patient;

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
    @JsonProperty("RBCells")
    public double getRBCells() {
        return RBCells;
    }

    @JsonProperty("RBCells")
    public void setRBCells(double RBCells) {
        this.RBCells = RBCells;
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
    @JsonProperty("IMRBCells")
    public double getIMRBCells() {
        return IMRBCells;
    }

    @JsonProperty("IMRBCells")
    public void setIMRBCells(double IMRBCells) {
        this.IMRBCells = IMRBCells;
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
    @JsonProperty("ESR")
    public double getESR() {
        return ESR;
    }

    @JsonProperty("ESR")
    public void setESR(double ESR) {
        this.ESR = ESR;
    }

    @DisplayName("Лейкоциты")
    @StatVariable
    @JsonProperty("WBCells")
    public double getWBCells() {
        return WBCells;
    }

    @JsonProperty("WBCells")
    public void setWBCells(double WBCells) {
        this.WBCells = WBCells;
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
    @JsonProperty("NKCells")
    public double getNKCells() {
        return NKCells;
    }

    @JsonProperty("NKCells")
    public void setNKCells(double NKCells) {
        this.NKCells = NKCells;
    }

    @DisplayName("Моноциты")
    @StatVariable
    public double getMonoCells() {
        return monoCells;
    }

    public void setMonoCells(double monoCells) {
        this.monoCells = monoCells;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
