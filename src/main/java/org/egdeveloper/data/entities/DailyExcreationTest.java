package org.egdeveloper.data.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table
public class DailyExcreationTest implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "creatinine")
    private double creatinine;

    @Column(name = "urea")
    private double urea;

    @Column(name = "ureaAcid")
    private double ureaAcid;

    @Column(name = "calcium")
    private double calcium;

    @Column(name = "potassium")
    private double potassium;

    @Column(name = "magnesium")
    private double magnesium;

    @Column(name = "sodium")
    private double sodium;

    @Column(name = "phosphorOxide")
    private double phosphorOxide;

    @Column(name = "chlorine")
    private double chlorine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCreatinine() {
        return creatinine;
    }

    public void setCreatinine(double creatinine) {
        this.creatinine = creatinine;
    }

    public double getUrea() {
        return urea;
    }

    public void setUrea(double urea) {
        this.urea = urea;
    }

    public double getUreaAcid() {
        return ureaAcid;
    }

    public void setUreaAcid(double ureaAcid) {
        this.ureaAcid = ureaAcid;
    }

    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(double magnesium) {
        this.magnesium = magnesium;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getPhosphorOxide() {
        return phosphorOxide;
    }

    public void setPhosphorOxide(double phosphorOxide) {
        this.phosphorOxide = phosphorOxide;
    }

    public double getChlorine() {
        return chlorine;
    }

    public void setChlorine(double chlorine) {
        this.chlorine = chlorine;
    }

}
