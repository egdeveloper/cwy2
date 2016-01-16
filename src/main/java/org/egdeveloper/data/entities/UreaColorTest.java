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
public class UreaColorTest implements Serializable, IMedicalTest{

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

    @Column(name = "DUV")
    @NotNull
    private double DUV;

    @Column(name = "ClSalt")
    @NotNull
    private double ClSalt;

    @Column(name = "NO2Salt")
    @NotNull
    private double NO2Salt;

    @Column(name = "NO3Salt")
    @NotNull
    private double NO3Salt;

    @Column(name = "SO3Salt")
    @NotNull
    private double SO3Salt;

    @Column(name = "PO3Salt")
    @NotNull
    private double PO3Salt;

    @Column(name = "citrate")
    @NotNull
    private double citrate;

    @Column(name = "isoCitrate")
    @NotNull
    private double isoCitrate;

    @Column(name = "ureaAcid")
    @NotNull
    private double ureaAcid;

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

    public double getDUV() {
        return DUV;
    }

    public void setDUV(double DUV) {
        this.DUV = DUV;
    }

    public double getClSalt() {
        return ClSalt;
    }

    public void setClSalt(double clSalt) {
        ClSalt = clSalt;
    }

    public double getNO2Salt() {
        return NO2Salt;
    }

    public void setNO2Salt(double NO2Salt) {
        this.NO2Salt = NO2Salt;
    }

    public double getNO3Salt() {
        return NO3Salt;
    }

    public void setNO3Salt(double NO3Salt) {
        this.NO3Salt = NO3Salt;
    }

    public double getSO3Salt() {
        return SO3Salt;
    }

    public void setSO3Salt(double SO3Salt) {
        this.SO3Salt = SO3Salt;
    }

    public double getPO3Salt() {
        return PO3Salt;
    }

    public void setPO3Salt(double PO3Salt) {
        this.PO3Salt = PO3Salt;
    }

    public double getCitrate() {
        return citrate;
    }

    public void setCitrate(double citrate) {
        this.citrate = citrate;
    }

    public double getIsoCitrate() {
        return isoCitrate;
    }

    public void setIsoCitrate(double isoCitrate) {
        this.isoCitrate = isoCitrate;
    }

    public double getUreaAcid() {
        return ureaAcid;
    }

    public void setUreaAcid(double ureaAcid) {
        this.ureaAcid = ureaAcid;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
