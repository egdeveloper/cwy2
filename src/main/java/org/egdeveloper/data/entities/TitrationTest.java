package org.egdeveloper.data.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by egdeveloper on 02.01.16.
 */

@Entity
@Table
public class TitrationTest implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "oxalate")
    private double oxalate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getOxalate() {
        return oxalate;
    }

    public void setOxalate(double oxalate) {
        this.oxalate = oxalate;
    }
}
