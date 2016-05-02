package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.*;
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

    @Indicator
    @Column(name = "stoneType", nullable = false)
    @DisplayName("Вид камня")
    private String stoneType;

    @Indicator
    @Column(name = "xray", nullable = false)
    @Enumerated(EnumType.STRING)
    @DisplayName("Рентгеноскопия")
    private StoneXRay xray;

    @Indicator
    @Column(name = "hardness", nullable = true)
    @DisplayName("Твердость")
    private Double hardness;

    @Indicator
    @Column(name = "addInfo", nullable = false)
    @DisplayName("Дополнительная информация о камне")
    private String addInfo;

    @Indicator
    public String getStoneType() {
        return stoneType;
    }

    @Indicator
    public void setStoneType(String stoneType) {
        this.stoneType = stoneType;
    }

    @Indicator
    public StoneXRay getXray() {
        return xray;
    }

    @Indicator
    public void setXray(StoneXRay xray) {
        this.xray = xray;
    }

    @Indicator
    @DisplayName("Твердость")
    @StatVariable
    public Double getHardness() {
        return hardness;
    }

    @Indicator
    public void setHardness(Double hardness) {
        this.hardness = hardness;
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
