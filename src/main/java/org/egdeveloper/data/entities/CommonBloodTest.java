package org.egdeveloper.data.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by egdeveloper on 02.01.16.
 */

@Entity
@Table
public class CommonBloodTest implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hemoglobin")
    private double hemoglobin;

    @Column(name = "rbCells")
    private double rbCells;

    @Column(name = "colorIndex")
    private double colorIndex;

    @Column(name = "imRBCells")
    private double imRBCells;

    @Column(name = "platelets")
    private double platelets;

    @Column(name = "esr")
    private double esr;

    @Column(name = "wbCells")
    private double wbCells;

    @Column(name = "bandCells")
    private double bandCells;

    @Column(name = "segmentCells")
    private double segmentCells;

    @Column(name = "eosinCells")
    private double eosinCells;

    @Column(name = "basophil")
    private double basophil;

    @Column(name = "nkCells")
    private double nkCells;

    @Column(name = "monoCells")
    private double monoCells;
}
