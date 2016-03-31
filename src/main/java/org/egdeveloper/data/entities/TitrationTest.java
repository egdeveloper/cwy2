package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.EntityID;
import org.egdeveloper.attributes.MedTest;
import org.egdeveloper.attributes.StatVariable;

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

    @Column(name = "oxalate")
    @NotNull
    @DisplayName("Оксалат")
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
