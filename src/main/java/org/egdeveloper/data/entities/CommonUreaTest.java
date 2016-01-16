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


@Entity
@Table
public class CommonUreaTest implements Serializable, IMedicalTest{

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

    @Column(name = "amount")
    @NotNull
    private double amount;

    @Column(name = "PH")
    @NotNull
    private double PH;

    @Column(name = "WBCells")
    @NotNull
    private double WBCells;

    @Column(name = "RBCells")
    @NotNull
    private double RBCells;

    @Column(name = "color")
    @NotNull
    private String color;

    @Column(name = "transparency")
    @NotNull
    private String transparency;

    @Column(name = "protein")
    @NotNull
    private String protein;

    @Column(name = "glucose")
    @NotNull
    private String glucose;

    @Column(name = "ketoneBodies")
    @NotNull
    private String ketoneBodies;

    @Column(name = "bloodReaction")
    @NotNull
    private String bloodReaction;

    @Column(name = "biliRuby")
    @NotNull
    private String biliRuby;

    @Column(name = "mucus")
    @NotNull
    private String mucus;

    @Column(name = "bacteria")
    @NotNull
    private String bacteria;

    @Column(name = "salt")
    @NotNull
    private String salt;

    @Column(name = "ureaBilins")
    @NotNull
    private String ureaBilins;

    @Column(name = "cylinder")
    @NotNull
    private String cylinder;

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPH() {
        return PH;
    }

    public void setPH(double PH) {
        this.PH = PH;
    }

    public double getWBCells() {
        return WBCells;
    }

    public void setWBCells(double WBCells) {
        this.WBCells = WBCells;
    }

    public double getRBCells() {
        return RBCells;
    }

    public void setRBCells(double RBCells) {
        this.RBCells = RBCells;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransparency() {
        return transparency;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }

    public String getKetoneBodies() {
        return ketoneBodies;
    }

    public void setKetoneBodies(String ketoneBodies) {
        this.ketoneBodies = ketoneBodies;
    }

    public String getBloodReaction() {
        return bloodReaction;
    }

    public void setBloodReaction(String bloodReaction) {
        this.bloodReaction = bloodReaction;
    }

    public String getBiliRuby() {
        return biliRuby;
    }

    public void setBiliRuby(String biliRuby) {
        this.biliRuby = biliRuby;
    }

    public String getMucus() {
        return mucus;
    }

    public void setMucus(String mucus) {
        this.mucus = mucus;
    }

    public String getBacteria() {
        return bacteria;
    }

    public void setBacteria(String bacteria) {
        this.bacteria = bacteria;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUreaBilins() {
        return ureaBilins;
    }

    public void setUreaBilins(String ureaBilins) {
        this.ureaBilins = ureaBilins;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
