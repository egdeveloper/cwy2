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
@EntityID("ureaColorTest")
@DisplayName("Хроматография")
public class UreaColorTest extends MedicalTest {

    public UreaColorTest(){
        super();
    }

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

    @DisplayName("Диурез")
    @StatVariable
    @JsonProperty("DUV")
    public double getDUV() {
        return DUV;
    }

    @JsonProperty("DUV")
    public void setDUV(double DUV) {
        this.DUV = DUV;
    }

    @DisplayName("Хлорид")
    @StatVariable
    @JsonProperty("ClSalt")
    public double getClSalt() {
        return ClSalt;
    }

    @JsonProperty("ClSalt")
    public void setClSalt(double clSalt) {
        ClSalt = clSalt;
    }

    @DisplayName("Нитрит")
    @StatVariable
    @JsonProperty("NO2Salt")
    public double getNO2Salt() {
        return NO2Salt;
    }

    @JsonProperty("NO2Salt")
    public void setNO2Salt(double NO2Salt) {
        this.NO2Salt = NO2Salt;
    }

    @DisplayName("Нитрат")
    @StatVariable
    @JsonProperty("NO3Salt")
    public double getNO3Salt() {
        return NO3Salt;
    }

    @JsonProperty("NO3Salt")
    public void setNO3Salt(double NO3Salt) {
        this.NO3Salt = NO3Salt;
    }

    @DisplayName("Сульфат")
    @StatVariable
    @JsonProperty("SO3Salt")
    public double getSO3Salt() {
        return SO3Salt;
    }

    @JsonProperty("SO3Salt")
    public void setSO3Salt(double SO3Salt) {
        this.SO3Salt = SO3Salt;
    }

    @DisplayName("Фосфат")
    @StatVariable
    @JsonProperty("PO3Salt")
    public double getPO3Salt() {
        return PO3Salt;
    }

    @JsonProperty("PO3Salt")
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
