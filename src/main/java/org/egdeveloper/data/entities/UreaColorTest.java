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
    private double duv;

    @Column(name = "ClSalt")
    @NotNull
    @DisplayName("Хлорид")
    @StatVariable
    private double clSalt;

    @Column(name = "NO2Salt")
    @NotNull
    @DisplayName("Нитрит")
    @StatVariable
    private double no2Salt;

    @Column(name = "NO3Salt")
    @NotNull
    @DisplayName("Нитрат")
    @StatVariable
    private double no3Salt;

    @Column(name = "SO3Salt")
    @NotNull
    @DisplayName("Сульфат")
    @StatVariable
    private double so3Salt;

    @Column(name = "PO3Salt")
    @NotNull
    @DisplayName("Фосфат")
    @StatVariable
    private double po3Salt;

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

    @DisplayName("Диурез")
    @StatVariable
    //@JsonProperty("duv")
    public double getDuv() {
        return duv;
    }

    //@JsonProperty("duv")
    public void setDuv(double duv) {
        this.duv = duv;
    }

    @DisplayName("Хлорид")
    @StatVariable
    //@JsonProperty("clSalt")
    public double getClSalt() {
        return clSalt;
    }

    //@JsonProperty("clSalt")
    public void setClSalt(double clSalt) {
        this.clSalt = clSalt;
    }

    @DisplayName("Нитрит")
    @StatVariable
    //@JsonProperty("no2Salt")
    public double getNo2Salt() {
        return no2Salt;
    }

    //@JsonProperty("no2Salt")
    public void setNo2Salt(double no2Salt) {
        this.no2Salt = no2Salt;
    }

    @DisplayName("Нитрат")
    @StatVariable
    //@JsonProperty("no3Salt")
    public double getNo3Salt() {
        return no3Salt;
    }

    //@JsonProperty("no3Salt")
    public void setNo3Salt(double no3Salt) {
        this.no3Salt = no3Salt;
    }

    @DisplayName("Сульфат")
    @StatVariable
    //@JsonProperty("so3Salt")
    public double getSo3Salt() {
        return so3Salt;
    }

    //@JsonProperty("so3Salt")
    public void setSo3Salt(double so3Salt) {
        this.so3Salt = so3Salt;
    }

    @DisplayName("Фосфат")
    @StatVariable
    //@JsonProperty("po3Salt")
    public double getPo3Salt() {
        return po3Salt;
    }

    //@JsonProperty("po3Salt")
    public void setPo3Salt(double po3Salt) {
        this.po3Salt = po3Salt;
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

}
