package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table
@MedTest
@EntityID("dailyExcreationTest")
@DisplayName("Суточная экскреция")
public class DailyExcreationTest extends MedicalTest {

    public DailyExcreationTest(){
        super();
    }

    @Column(name = "creatinine", nullable = false)
    @DisplayName("Креатинин")
    @IndicatorNorm(minCritical = 3.9, min = 4.9, max = 15.6, maxCritical = 19.6)
    @StatVariable
    private double creatinine;

    @Column(name = "urea", nullable = false)
    @DisplayName("Мочевина")
    @IndicatorNorm(minCritical = 303.0, min = 363.0, max = 522.8, maxCritical = 642.8)
    @StatVariable
    private double urea;

    @Column(name = "ureaAcid", nullable = false)
    @DisplayName("Мочевая кислота")
    @IndicatorNorm(minCritical = 1.42, min = 1.62, max = 3.30, maxCritical = 3.9)
    @StatVariable
    private double ureaAcid;

    @Column(name = "calcium", nullable = false)
    @DisplayName("Кальций")
    @IndicatorNorm(minCritical = 2.3, min = 2.7, max = 6.8, maxCritical = 8.2)
    @StatVariable
    private double calcium;

    @Column(name = "potassium", nullable = false)
    @DisplayName("Калий")
    @IndicatorNorm(minCritical = 27.0, min = 33.0, max = 90.0, maxCritical = 110.0)
    @StatVariable
    private double potassium;

    @Column(name = "magnesium", nullable = false)
    @DisplayName("Магний")
    @IndicatorNorm(minCritical = 0.45, min = 0.55, max = 3.7, maxCritical = 4.7)
    @StatVariable
    private double magnesium;

    @Column(name = "sodium", nullable = false)
    @DisplayName("Натрий")
    @IndicatorNorm(minCritical = 120.0, min = 140.0, max = 230.0, maxCritical = 290.0)
    @StatVariable
    private double sodium;

    @Column(name = "phosphorOxide", nullable = false)
    @DisplayName("Оксид Фосфора")
    @IndicatorNorm(minCritical = 11.4, min = 14.4, max = 35.0, maxCritical = 45.0)
    @StatVariable
    private double phosphorOxide;

    @Column(name = "chlorine", nullable = false)
    @DisplayName("Хлор")
    @IndicatorNorm(minCritical = 99.0, min = 121.0, max = 225.0, maxCritical = 275.0)
    @StatVariable
    private double chlorine;

    @DisplayName("Креатинин")
    @StatVariable
    public double getCreatinine() {
        return creatinine;
    }

    public void setCreatinine(double creatinine) {
        this.creatinine = creatinine;
    }

    @DisplayName("Мочевина")
    @StatVariable
    public double getUrea() {
        return urea;
    }

    public void setUrea(double urea) {
        this.urea = urea;
    }

    @DisplayName("Мочевая кислота")
    @StatVariable
    public double getUreaAcid() {
        return ureaAcid;
    }

    public void setUreaAcid(double ureaAcid) {
        this.ureaAcid = ureaAcid;
    }

    @DisplayName("Кальций")
    @StatVariable
    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    @DisplayName("Калий")
    @StatVariable
    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    @DisplayName("Магний")
    @StatVariable
    public double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(double magnesium) {
        this.magnesium = magnesium;
    }

    @DisplayName("Натрий")
    @StatVariable
    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    @DisplayName("Оксид Фосфора")
    @StatVariable
    public double getPhosphorOxide() {
        return phosphorOxide;
    }

    public void setPhosphorOxide(double phosphorOxide) {
        this.phosphorOxide = phosphorOxide;
    }

    @DisplayName("Хлор")
    @StatVariable
    public double getChlorine() {
        return chlorine;
    }

    public void setChlorine(double chlorine) {
        this.chlorine = chlorine;
    }

}
