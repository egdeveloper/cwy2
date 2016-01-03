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

    @Column(name = "DUV")
    private double DUV;

    @Column(name = "ClSalt")
    private double ClSalt;

    @Column(name = "NO2Salt")
    private double NO2Salt;

    @Column(name = "NO3Salt")
    private double NO3Salt;

    @Column(name = "SO3Salt")
    private double SO3Salt;

    @Column(name = "PO3Salt")
    private double PO3Salt;

    @Column(name = "citrate")
    private double citrate;

    @Column(name = "isoCitrate")
    private double isoCitrate;

    @Column(name = "ureaAcid")
    private double ureaAcid;

    public double getIsoCitrate() {
        return isoCitrate;
    }

    public void setIsoCitrate(double isoCitrate) {
        this.isoCitrate = isoCitrate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDUV() {
        return DUV;
    }

    public void setDUV(double DUV) {
        this.DUV = DUV;
    }

    public double getClSalt() {
        return ClSalt;
    }

    public void setClSalt(double clSalt) {
        ClSalt = clSalt;
    }

    public double getNO2Salt() {
        return NO2Salt;
    }

    public void setNO2Salt(double NO2Salt) {
        this.NO2Salt = NO2Salt;
    }

    public double getNO3Salt() {
        return NO3Salt;
    }

    public void setNO3Salt(double NO3Salt) {
        this.NO3Salt = NO3Salt;
    }

    public double getSO3Salt() {
        return SO3Salt;
    }

    public void setSO3Salt(double SO3Salt) {
        this.SO3Salt = SO3Salt;
    }

    public double getPO3Salt() {
        return PO3Salt;
    }

    public void setPO3Salt(double PO3Salt) {
        this.PO3Salt = PO3Salt;
    }

    public double getCitrate() {
        return citrate;
    }

    public void setCitrate(double citrate) {
        this.citrate = citrate;
    }

    public double getUreaAcid() {
        return ureaAcid;
    }

    public void setUreaAcid(double ureaAcid) {
        this.ureaAcid = ureaAcid;
    }
}
