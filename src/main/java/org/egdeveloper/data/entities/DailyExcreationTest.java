package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table
@MedTest
@EntityID("dailyExcreationTest")
@DisplayName("Суточная экскреция")
public class DailyExcreationTest extends MedicalTest {

    public DailyExcreationTest(){
        super();
    }

    @Indicator
    @Column(name = "creatinine", nullable = true)
    @DisplayName("Креатинин")
    @IndicatorNorm(minCritical = 3.9, min = 4.9, max = 15.6, maxCritical = 19.6)
    @StatVariable
    private Double creatinine;

    @Indicator
    @Column(name = "urea", nullable = true)
    @DisplayName("Мочевина")
    @IndicatorNorm(minCritical = 303.0, min = 363.0, max = 522.8, maxCritical = 642.8)
    @StatVariable
    private Double urea;

    @Indicator
    @Column(name = "ureaAcid", nullable = true)
    @DisplayName("Мочевая кислота")
    @IndicatorNorm(minCritical = 1.42, min = 1.62, max = 3.30, maxCritical = 3.9)
    @StatVariable
    private Double ureaAcid;

    @Indicator
    @Column(name = "calcium", nullable = true)
    @DisplayName("Кальций")
    @IndicatorNorm(minCritical = 2.3, min = 2.7, max = 6.8, maxCritical = 8.2)
    @StatVariable
    private Double calcium;

    @Indicator
    @Column(name = "potassium", nullable = true)
    @DisplayName("Калий")
    @IndicatorNorm(minCritical = 27.0, min = 33.0, max = 90.0, maxCritical = 110.0)
    @StatVariable
    private Double potassium;

    @Indicator
    @Column(name = "magnesium", nullable = true)
    @DisplayName("Магний")
    @IndicatorNorm(minCritical = 0.45, min = 0.55, max = 3.7, maxCritical = 4.7)
    @StatVariable
    private Double magnesium;

    @Indicator
    @Column(name = "sodium", nullable = true)
    @DisplayName("Натрий")
    @IndicatorNorm(minCritical = 120.0, min = 140.0, max = 230.0, maxCritical = 290.0)
    @StatVariable
    private Double sodium;

    @Indicator
    @Column(name = "phosphorOxide", nullable = true)
    @DisplayName("Оксид Фосфора")
    @IndicatorNorm(minCritical = 11.4, min = 14.4, max = 35.0, maxCritical = 45.0)
    @StatVariable
    private Double phosphorOxide;

    @Indicator
    @Column(name = "chlorine", nullable = true)
    @DisplayName("Хлор")
    @IndicatorNorm(minCritical = 99.0, min = 121.0, max = 225.0, maxCritical = 275.0)
    @StatVariable
    private Double chlorine;

    @Indicator
    @DisplayName("Креатинин")
    @StatVariable
    public Double getCreatinine() {
        return creatinine;
    }

    @Indicator
    public void setCreatinine(Double creatinine) {
        this.creatinine = creatinine;
    }

    @Indicator
    @DisplayName("Мочевина")
    @StatVariable
    public Double getUrea() {
        return urea;
    }

    @Indicator
    public void setUrea(Double urea) {
        this.urea = urea;
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

    @Indicator
    @DisplayName("Кальций")
    @StatVariable
    public Double getCalcium() {
        return calcium;
    }

    @Indicator
    public void setCalcium(Double calcium) {
        this.calcium = calcium;
    }

    @Indicator
    @DisplayName("Калий")
    @StatVariable
    public Double getPotassium() {
        return potassium;
    }

    @Indicator
    public void setPotassium(Double potassium) {
        this.potassium = potassium;
    }

    @Indicator
    @DisplayName("Магний")
    @StatVariable
    public Double getMagnesium() {
        return magnesium;
    }

    @Indicator
    public void setMagnesium(Double magnesium) {
        this.magnesium = magnesium;
    }

    @Indicator
    @DisplayName("Натрий")
    @StatVariable
    public Double getSodium() {
        return sodium;
    }

    @Indicator
    public void setSodium(Double sodium) {
        this.sodium = sodium;
    }

    @Indicator
    @DisplayName("Оксид Фосфора")
    @StatVariable
    public Double getPhosphorOxide() {
        return phosphorOxide;
    }

    @Indicator
    public void setPhosphorOxide(Double phosphorOxide) {
        this.phosphorOxide = phosphorOxide;
    }

    @Indicator
    @DisplayName("Хлор")
    @StatVariable
    public Double getChlorine() {
        return chlorine;
    }

    @Indicator
    public void setChlorine(Double chlorine) {
        this.chlorine = chlorine;
    }

}
