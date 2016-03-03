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
@EntityID("ureaColorTest")
@DisplayName("Хроматография")
public class UreaColorTest implements Serializable, IMedicalTest{

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

    @Column(name = "DUV")
    @NotNull
    @DisplayName("Диурез")
    @StatVariable
    private double DUV;

    @Column(name = "ClSalt")
    @NotNull
    @DisplayName("Хлорид")
    @StatVariable
    private double ClSalt;

    @Column(name = "NO2Salt")
    @NotNull
    @DisplayName("Нитрит")
    @StatVariable
    private double NO2Salt;

    @Column(name = "NO3Salt")
    @NotNull
    @DisplayName("Нитрат")
    @StatVariable
    private double NO3Salt;

    @Column(name = "SO3Salt")
    @NotNull
    @DisplayName("Сульфат")
    @StatVariable
    private double SO3Salt;

    @Column(name = "PO3Salt")
    @NotNull
    @DisplayName("Фосфат")
    @StatVariable
    private double PO3Salt;

    @Column(name = "citrate")
    @NotNull
    @DisplayName("Цитрат")
    @StatVariable
    private double citrate;

    @Column(name = "isoCitrate")
    @NotNull
    @DisplayName("Изоцитрат")
    @StatVariable
    private double isoCitrate;

    @Column(name = "ureaAcid")
    @NotNull
    @DisplayName("Мочевая кислота")
    @StatVariable
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

    @DisplayName("Диурез")
    @StatVariable
    public double getDUV() {
        return DUV;
    }

    public void setDUV(double DUV) {
        this.DUV = DUV;
    }

    @DisplayName("Хлорид")
    @StatVariable
    public double getClSalt() {
        return ClSalt;
    }

    public void setClSalt(double clSalt) {
        ClSalt = clSalt;
    }

    @DisplayName("Нитрит")
    @StatVariable
    public double getNO2Salt() {
        return NO2Salt;
    }

    public void setNO2Salt(double NO2Salt) {
        this.NO2Salt = NO2Salt;
    }

    @DisplayName("Нитрат")
    @StatVariable
    public double getNO3Salt() {
        return NO3Salt;
    }

    public void setNO3Salt(double NO3Salt) {
        this.NO3Salt = NO3Salt;
    }

    @DisplayName("Сульфат")
    @StatVariable
    public double getSO3Salt() {
        return SO3Salt;
    }

    public void setSO3Salt(double SO3Salt) {
        this.SO3Salt = SO3Salt;
    }

    @DisplayName("Фосфат")
    @StatVariable
    public double getPO3Salt() {
        return PO3Salt;
    }

    public void setPO3Salt(double PO3Salt) {
        this.PO3Salt = PO3Salt;
    }

    @DisplayName("Цитрат")
    @StatVariable
    public double getCitrate() {
        return citrate;
    }

    public void setCitrate(double citrate) {
        this.citrate = citrate;
    }

    @DisplayName("Изоцитрат")
    @StatVariable
    public double getIsoCitrate() {
        return isoCitrate;
    }

    public void setIsoCitrate(double isoCitrate) {
        this.isoCitrate = isoCitrate;
    }

    @DisplayName("Мочевая кислота")
    @StatVariable
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
