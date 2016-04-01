package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table
@MedTest
@EntityID("titrationTest")
@DisplayName("Титриметрия")
public class TitrationTest extends MedicalTest {

    public TitrationTest(){
        super();
    }

    @Column(name = "oxalate", nullable = false)
    @DisplayName("Оксалат")
    @IndicatorNorm(minCritical = 25, min = 35, max = 55, maxCritical = 65)
    @StatVariable
    private double oxalate;

    @DisplayName("Оксалат")
    @StatVariable
    public double getOxalate() {
        return oxalate;
    }

    public void setOxalate(double oxalate) {
        this.oxalate = oxalate;
    }
}
