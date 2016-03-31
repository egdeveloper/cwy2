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
@EntityID("ureaStoneTest")
@DisplayName("Мочевой камень")
public class UreaStoneTest extends MedicalTest {

    public UreaStoneTest(){
        super();
    }

    @Column(name = "size")
    @NotNull
    @DisplayName("Размер")
    @StatVariable
    private double size;

    @Column(name = "density")
    @NotNull
    @DisplayName("Плотность")
    @StatVariable
    private double density;

    @Column(name = "location")
    @NotNull
    @DisplayName("Локализация")
    private String location;

    @Column(name = "form")
    @NotNull
    @DisplayName("Форма")
    private String form;

    @Column(name = "hardness")
    @NotNull
    @DisplayName("Жесткость")
    @StatVariable
    private double hardness;

    @Column(name = "addInfo")
    @NotNull
    @DisplayName("Дополнительная информация о камне")
    private String addInfo;

    @DisplayName("Размер")
    @StatVariable
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @DisplayName("Плотность")
    @StatVariable
    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    @DisplayName("Локализация")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @DisplayName("Форма")
    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @DisplayName("Жесткость")
    @StatVariable
    public double getHardness() {
        return hardness;
    }

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }
}
