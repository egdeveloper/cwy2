package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@MedTest
@EntityID("ureaColorTest")
@DisplayName("Хроматография")
public class UreaColorTest extends MedicalTest {

    public UreaColorTest(){
        super();
    }

    @Indicator
    @Column(name = "DUV", nullable = true)
    @DisplayName("Диурез")
    @IndicatorNorm(minCritical = 720, min = 880, max = 1350, maxCritical = 1650)
    @StatVariable
    private Double duv;

    @Indicator
    @Column(name = "ClSalt", nullable = true)
    @DisplayName("Хлорид")
    @IndicatorNorm(minCritical = 160, min = 200, max = 252, maxCritical = 312)
    @StatVariable
    private Double clSalt;

    @Indicator
    @Column(name = "NO2Salt", nullable = true)
    @DisplayName("Нитрит")
    @IndicatorNorm(minCritical = 0, min = 0, max = 0, maxCritical = 0.05)
    @StatVariable
    private Double no2Salt;

    @Indicator
    @Column(name = "NO3Salt", nullable = true)
    @DisplayName("Нитрат")
    @IndicatorNorm(minCritical = 0.7, min = 0.9, max = 2.06, maxCritical = 2.46)
    @StatVariable
    private Double no3Salt;

    @Indicator
    @Column(name = "SO3Salt", nullable = true)
    @DisplayName("Сульфат")
    @IndicatorNorm(minCritical = 23.6, min = 29.6, max = 38.0, maxCritical = 46.0)
    @StatVariable
    private Double so3Salt;

    @Indicator
    @Column(name = "PO3Salt", nullable = true)
    @DisplayName("Фосфат")
    @IndicatorNorm(minCritical = 9.5, min = 11.5, max = 62.0, maxCritical = 74.0)
    @StatVariable
    private Double po3Salt;

    @Indicator
    @Column(name = "citrate", nullable = true)
    @DisplayName("Цитрат")
    @IndicatorNorm(minCritical = 2.2, min = 2.6, max = 4.8, maxCritical = 5.8)
    @StatVariable
    private Double citrate;

    @Indicator
    @Column(name = "isoCitrate", nullable = true)
    @DisplayName("Изоцитрат")
    @IndicatorNorm(minCritical = 0.63, min = 0.77, max = 1.8, maxCritical = 2.2)
    @StatVariable
    private Double isoCitrate;

    @Indicator
    @Column(name = "ureaAcid", nullable = true)
    @DisplayName("Мочевая кислота")
    @IndicatorNorm(minCritical = 5.9, min = 7.1, max = 11.7, maxCritical = 14.3)
    @StatVariable
    private Double ureaAcid;

    @Indicator
    @DisplayName("Диурез")
    @IndicatorNorm(minCritical = 720, min = 880, max = 1350, maxCritical = 1650)
    @StatVariable
    public Double getDuv() {
        return duv;
    }

    @Indicator
    public void setDuv(Double duv) {
        this.duv = duv;
    }

    @Indicator
    @DisplayName("Хлорид")
    @StatVariable
    public Double getClSalt() {
        return clSalt;
    }

    @Indicator
    public void setClSalt(Double clSalt) {
        this.clSalt = clSalt;
    }

    @Indicator
    @DisplayName("Нитрит")
    @StatVariable
    public Double getNo2Salt() {
        return no2Salt;
    }

    @Indicator
    public void setNo2Salt(Double no2Salt) {
        this.no2Salt = no2Salt;
    }

    @Indicator
    @DisplayName("Нитрат")
    @StatVariable
    public Double getNo3Salt() {
        return no3Salt;
    }

    @Indicator
    public void setNo3Salt(Double no3Salt) {
        this.no3Salt = no3Salt;
    }

    @Indicator
    @DisplayName("Сульфат")
    @StatVariable
    public Double getSo3Salt() {
        return so3Salt;
    }

    @Indicator
    public void setSo3Salt(Double so3Salt) {
        this.so3Salt = so3Salt;
    }

    @Indicator
    @DisplayName("Фосфат")
    @StatVariable
    public Double getPo3Salt() {
        return po3Salt;
    }

    @Indicator
    public void setPo3Salt(Double po3Salt) {
        this.po3Salt = po3Salt;
    }

    @Indicator
    @DisplayName("Цитрат")
    @StatVariable
    public Double getCitrate() {
        return citrate;
    }

    @Indicator
    public void setCitrate(Double citrate) {
        this.citrate = citrate;
    }

    @Indicator
    @DisplayName("Изоцитрат")
    @StatVariable
    public Double getIsoCitrate() {
        return isoCitrate;
    }

    @Indicator
    public void setIsoCitrate(Double isoCitrate) {
        this.isoCitrate = isoCitrate;
    }

    @Indicator
    @DisplayName("Мочевая кислота")
    @StatVariable
    public Double getUreaAcid() {
        return ureaAcid;
    }

    @Indicator
    public void setUreaAcid(Double ureaAcid) {
        this.ureaAcid = ureaAcid;
    }

}
