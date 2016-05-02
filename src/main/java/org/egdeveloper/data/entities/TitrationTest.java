package org.egdeveloper.data.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.egdeveloper.attributes.*;
import org.egdeveloper.converters.deserializers.MedicalTestDeserializer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@MedTest
@EntityID("titrationTest")
@DisplayName("Титриметрия")
@JsonDeserialize(using = MedicalTestDeserializer.class, as = TitrationTest.class)
public class TitrationTest extends MedicalTest {

    public TitrationTest(){
        super();
    }

    @Indicator
    @Column(name = "oxalate", nullable = true)
    @DisplayName("Оксалат")
    @IndicatorNorm(minCritical = 25, min = 35, max = 55, maxCritical = 65)
    @StatVariable
    private Double oxalate;

    @Indicator
    @DisplayName("Оксалат")
    @StatVariable
    public Double getOxalate() {
        return oxalate;
    }

    @Indicator
    public void setOxalate(Double oxalate) {
        this.oxalate = oxalate;
    }
}
