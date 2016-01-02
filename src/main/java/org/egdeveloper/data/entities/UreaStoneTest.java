package org.egdeveloper.data.entities;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class UreaStoneTest implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "size")
    private double size;

    @Column(name = "density")
    private double density;

    @Column(name = "location")
    private String location;

    @Column(name = "form")
    private String form;

    @Column(name = "hardness")
    private double hardness;

    @Column(name = "addInfo")
    private String addInfo;
}
