package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.EntityID;
import org.egdeveloper.attributes.MedTest;
import org.egdeveloper.attributes.StatVariable;
import org.egdeveloper.data.entities.custom_types.StoneXRay;

import javax.persistence.*;

@Entity
@Table
@MedTest
@EntityID("stoneInVitroTest")
@DisplayName("Камень IN VITRO")
public class StoneInVitroTest extends MedicalTest {

    public StoneInVitroTest(){
        super();
    }

    @Column(name = "stoneType", nullable = false)
    @DisplayName("Вид камня")
    private String stoneType;

    @Column(name = "xray", nullable = false)
    @Enumerated(EnumType.STRING)
    @DisplayName("Рентгеноскопия")
    private StoneXRay xray;

    @Column(name = "hardness", nullable = false)
    @DisplayName("Твердость")
    private double hardness;

    @Column(name = "addInfo", nullable = false)
    @DisplayName("Дополнительная информация о камне")
    private String addInfo;

    public String getStoneType() {
        return stoneType;
    }

    public void setStoneType(String stoneType) {
        this.stoneType = stoneType;
    }

    public StoneXRay getXray() {
        return xray;
    }

    public void setXray(StoneXRay xray) {
        this.xray = xray;
    }

    @DisplayName("Твердость")
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
