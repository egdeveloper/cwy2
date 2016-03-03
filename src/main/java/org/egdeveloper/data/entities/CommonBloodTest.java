package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.EntityID;
import org.egdeveloper.attributes.MedTest;
import org.egdeveloper.attributes.StatVariable;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;


@Entity
@Table
@MedTest
@EntityID("commonBloodTest")
@DisplayName("Общий анализ крови")
public class CommonBloodTest implements Serializable, IMedicalTest{


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "testDate")
    @DisplayName("Дата проведения анализа")
    private LocalDate testDate;

    @NotNull
    @Column(name = "description")
    @DisplayName("Дополнительная информация")
    private String description;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
    public double getRBCells() {
        return RBCells;
    }

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
    public double getIMRBCells() {
        return IMRBCells;
    }

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
    public double getESR() {
        return ESR;
    }

    public void setESR(double ESR) {
        this.ESR = ESR;
    }

    @DisplayName("Лейкоциты")
    @StatVariable
    public double getWBCells() {
        return WBCells;
    }

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
    public double getNKCells() {
        return NKCells;
    }

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
