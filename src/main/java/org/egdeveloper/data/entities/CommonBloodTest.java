package org.egdeveloper.data.entities;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by egdeveloper on 02.01.16.
 */

@Entity
@Table
public class CommonBloodTest implements Serializable{


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotEmpty
    //@Temporal(TemporalType.DATE)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "testDate")
    private LocalDate testDate;

    @NotNull
    @Column(name = "description")
    private String description;

    @Column(name = "hemoglobin")
    @NotNull
    private double hemoglobin;

    @Column(name = "RBCells")
    @NotNull
    private double RBCells;

    @Column(name = "colorIndex")
    @NotNull
    private double colorIndex;

    @Column(name = "IMRBCells")
    @NotNull
    private double IMRBCells;

    @Column(name = "platelets")
    @NotNull
    private double platelets;

    @Column(name = "ESR")
    @NotNull
    private double ESR;

    @Column(name = "WBCells")
    @NotNull
    private double WBCells;

    @Column(name = "bandCells")
    @NotNull
    private double bandCells;

    @Column(name = "segmentCells")
    @NotNull
    private double segmentCells;

    @Column(name = "eosinCells")
    @NotNull
    private double eosinCells;

    @Column(name = "basophil")
    @NotNull
    private double basophil;

    @Column(name = "NKCells")
    @NotNull
    private double NKCells;

    @Column(name = "monoCells")
    @NotNull
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

    public double getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(double hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public double getRBCells() {
        return RBCells;
    }

    public void setRBCells(double RBCells) {
        this.RBCells = RBCells;
    }

    public double getColorIndex() {
        return colorIndex;
    }

    public void setColorIndex(double colorIndex) {
        this.colorIndex = colorIndex;
    }

    public double getIMRBCells() {
        return IMRBCells;
    }

    public void setIMRBCells(double IMRBCells) {
        this.IMRBCells = IMRBCells;
    }

    public double getPlatelets() {
        return platelets;
    }

    public void setPlatelets(double platelets) {
        this.platelets = platelets;
    }

    public double getESR() {
        return ESR;
    }

    public void setESR(double ESR) {
        this.ESR = ESR;
    }

    public double getWBCells() {
        return WBCells;
    }

    public void setWBCells(double WBCells) {
        this.WBCells = WBCells;
    }

    public double getBandCells() {
        return bandCells;
    }

    public void setBandCells(double bandCells) {
        this.bandCells = bandCells;
    }

    public double getSegmentCells() {
        return segmentCells;
    }

    public void setSegmentCells(double segmentCells) {
        this.segmentCells = segmentCells;
    }

    public double getEosinCells() {
        return eosinCells;
    }

    public void setEosinCells(double eosinCells) {
        this.eosinCells = eosinCells;
    }

    public double getBasophil() {
        return basophil;
    }

    public void setBasophil(double basophil) {
        this.basophil = basophil;
    }

    public double getNKCells() {
        return NKCells;
    }

    public void setNKCells(double NKCells) {
        this.NKCells = NKCells;
    }

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
