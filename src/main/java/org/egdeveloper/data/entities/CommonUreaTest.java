package org.egdeveloper.data.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table
public class CommonUreaTest implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "ph")
    private double ph;

    @Column(name = "wbCells")
    private double wbCells;

    @Column(name = "rbCells")
    private double rbCells;

    @Column(name = "color")
    private String color;

    @Column(name = "transparency")
    private String transparency;

    @Column(name = "protein")
    private String protein;

    @Column(name = "glucose")
    private String glucose;

    @Column(name = "ketoneBodies")
    private String ketoneBodies;

    @Column(name = "bloodReaction")
    private String bloodReaction;

    @Column(name = "biliRuby")
    private String biliRuby;

    @Column(name = "mucus")
    private String mucus;

    @Column(name = "bacteria")
    private String bacteria;

    @Column(name = "salt")
    private String salt;

    @Column(name = "ureaBilins")
    private String ureaBilins;

    @Column(name = "cylinder")
    private String cylinder;
}
