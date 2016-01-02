package org.egdeveloper.data.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by egdeveloper on 02.01.16.
 */

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

}
