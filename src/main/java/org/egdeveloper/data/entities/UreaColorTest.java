package org.egdeveloper.data.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.egdeveloper.attributes.*;

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

    @Column(name = "DUV", nullable = false)
    @DisplayName("Диурез")
    @IndicatorNorm(minCritical = 720, min = 880, max = 1350, maxCritical = 1650)
    @StatVariable
    private double duv;

    @Column(name = "ClSalt", nullable = false)
    @DisplayName("Хлорид")
    @IndicatorNorm(minCritical = 160, min = 200, max = 252, maxCritical = 312)
    @StatVariable
    private double clSalt;

    @Column(name = "NO2Salt", nullable = false)
    @DisplayName("Нитрит")
    @IndicatorNorm(minCritical = 0, min = 0, max = 0, maxCritical = 0.05)
    @StatVariable
    private double no2Salt;

    @Column(name = "NO3Salt", nullable = false)
    @DisplayName("Нитрат")
    @IndicatorNorm(minCritical = 0.7, min = 0.9, max = 2.06, maxCritical = 2.46)
    @StatVariable
    private double no3Salt;

    @Column(name = "SO3Salt", nullable = false)
    @DisplayName("Сульфат")
    @IndicatorNorm(minCritical = 23.6, min = 29.6, max = 38.0, maxCritical = 46.0)
    @StatVariable
    private double so3Salt;

    @Column(name = "PO3Salt", nullable = false)
    @DisplayName("Фосфат")
    @IndicatorNorm(minCritical = 9.5, min = 11.5, max = 62.0, maxCritical = 74.0)
    @StatVariable
    private double po3Salt;

    @Column(name = "citrate", nullable = false)
    @DisplayName("Цитрат")
    @IndicatorNorm(minCritical = 2.2, min = 2.6, max = 4.8, maxCritical = 5.8)
    @StatVariable
    private double citrate;

    @Column(name = "isoCitrate", nullable = false)
    @DisplayName("Изоцитрат")
    @IndicatorNorm(minCritical = 0.63, min = 0.77, max = 1.8, maxCritical = 2.2)
    @StatVariable
    private double isoCitrate;

    @Column(name = "ureaAcid", nullable = false)
    @DisplayName("Мочевая кислота")
    @IndicatorNorm(minCritical = 5.9, min = 7.1, max = 11.7, maxCritical = 14.3)
    @StatVariable
    private double ureaAcid;

    @DisplayName("Диурез")
    @IndicatorNorm(minCritical = 720, min = 880, max = 1350, maxCritical = 1650)
    @StatVariable
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
