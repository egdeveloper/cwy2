package org.egdeveloper.data.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table
public class BioChemTest implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "commonProtein")
    private double commonProtein;

    @Column(name = "urea")
    private double urea;

    @Column(name = "creatinine")
    private double creatinine;

    @Column(name = "commonBiliRuby")
    private double commonBiliRuby;

    @Column(name = "linkedBiliRuby")
    private double linkedBiliRuby;

    @Column(name = "cholesterol")
    private double cholesterol;

    @Column(name = "tag")
    private double tag;

    @Column(name = "hdl")
    private double hdl;

    @Column(name = "ldl")
    private double ldl;

    @Column(name = "cholesterolRatio")
    private double cholesterolRatio;

    @Column(name = "alt")
    private double alt;

    @Column(name = "ast")
    private double ast;

    @Column(name = "alkp")
    private double alkp;

    @Column(name = "ck")
    private double ck;

    @Column(name = "ckmb")
    private double ckmb;

    @Column(name = "ldh")
    private double ldh;

    @Column(name = "ggt")
    private double ggt;

    @Column(name = "amylase")
    private double amylase;

    @Column(name = "pancrAmylase")
    private double pancrAmylase;

    @Column(name = "glucose")
    private double glucose;

    @Column(name = "ureaAcid")
    private double ureaAcid;

    @Column(name = "crp")
    private double crp;

    @Column(name = "rf")
    private double rf;

    @Column(name = "potassium")
    private double potassium;

    @Column(name = "sodium")
    private double sodium;

    @Column(name = "chlorine")
    private double chlorine;

    @Column(name = "commonCalcium")
    private double commonCalcium;

    @Column(name = "ionCalcium")
    private double ionCalcium;

    @Column(name = "phosphor")
    private double phosphor;

    @Column(name = "ferrum")
    private double ferrum;

    @Column(name = "ferritin")
    private double ferritin;
}
