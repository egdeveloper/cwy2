package org.egdeveloper.data.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class UreaColorTest implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "duv")
    private double duv;

    @Column(name = "clSalt")
    private double clSalt;

    @Column(name = "no2Salt")
    private double no2Salt;

    @Column(name = "no3Salt")
    private double no3Salt;

    @Column(name = "so3Salt")
    private double so3Salt;

    @Column(name = "po3Salt")
    private double po3Salt;

    @Column(name = "citrate")
    private double citrate;

    @Column(name = "isoCitrate")
    private double isoCitrate;

    @Column(name = "ureaAcid")
    private double ureaAcid;
}
