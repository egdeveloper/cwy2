package org.egdeveloper.data.entities;
import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.EntityID;
import org.egdeveloper.attributes.MedTest;
import org.egdeveloper.attributes.StatVariable;
import javax.persistence.*;

@Entity
@Table
@MedTest
@EntityID("stoneInVivoTest")
@DisplayName("Камень IN VIVO")
public class StoneInVivoTest extends MedicalTest {

    public StoneInVivoTest(){
        super();
    }

    @Column(name = "size", nullable = false)
    @DisplayName("Размер")
    @StatVariable
    private double size;

    @Column(name = "density", nullable = false)
    @DisplayName("Плотность")
    @StatVariable
    private double density;

    @Column(name = "location", nullable = false)
    @DisplayName("Локализация")
    private String location;

    @Column(name = "addInfo", nullable = false)
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

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }
}
