package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@MedTest
@EntityID("stoneInVivoTest")
@DisplayName("Камень IN VIVO")
public class StoneInVivoTest extends MedicalTest {

    public StoneInVivoTest(){
        super();
    }

    @Indicator
    @Column(name = "size", nullable = true)
    @DisplayName("Размер")
    @StatVariable
    private Double size;

    @Indicator
    @Column(name = "density", nullable = true)
    @DisplayName("Плотность")
    @StatVariable
    private Double density;

    @Indicator
    @Column(name = "location", nullable = false)
    @DisplayName("Локализация")
    private String location;

    @Indicator
    @Column(name = "addInfo", nullable = false)
    @DisplayName("Дополнительная информация о камне")
    private String addInfo;

    @Indicator
    @DisplayName("Размер")
    @StatVariable
    public Double getSize() {
        return size;
    }

    @Indicator
    public void setSize(Double size) {
        this.size = size;
    }

    @Indicator
    @DisplayName("Плотность")
    @StatVariable
    public Double getDensity() {
        return density;
    }

    @Indicator
    public void setDensity(Double density) {
        this.density = density;
    }

    @Indicator
    @DisplayName("Локализация")
    public String getLocation() {
        return location;
    }

    @Indicator
    public void setLocation(String location) {
        this.location = location;
    }

    @Indicator
    public String getAddInfo() {
        return addInfo;
    }

    @Indicator
    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }
}
