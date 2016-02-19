package org.egdeveloper.data.entities;
import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.MedTest;
import org.egdeveloper.attributes.StatVariable;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table
@MedTest
@DisplayName("Мочевой камень")
public class UreaStoneTest implements Serializable, IMedicalTest{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "testDate")
    @DisplayName("Дата проведения анализа")
    private LocalDate testDate;

    @NotNull
    @Column(name = "description")
    @DisplayName("Дополнительная информация")
    private String description;

    @Column(name = "size")
    @NotNull
    @DisplayName("Размер")
    @StatVariable
    private double size;

    @Column(name = "density")
    @NotNull
    @DisplayName("Плотность")
    @StatVariable
    private double density;

    @Column(name = "location")
    @NotNull
    @DisplayName("Локализация")
    private String location;

    @Column(name = "form")
    @NotNull
    @DisplayName("Форма")
    private String form;

    @Column(name = "hardness")
    @NotNull
    @DisplayName("Жесткость")
    @StatVariable
    private double hardness;

    @Column(name = "addInfo")
    @NotNull
    @DisplayName("Дополнительная информация о камне")
    private String addInfo;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Patient patient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DisplayName("Размер")
    @StatVariable
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @DisplayName("Плотность")
    @StatVariable
    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    @DisplayName("Локализация")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @DisplayName("Форма")
    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    @DisplayName("Жесткость")
    @StatVariable
    public double getHardness() {
        return hardness;
    }

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    public String getAddInfo() {
        return addInfo;
    }

    public void setAddInfo(String addInfo) {
        this.addInfo = addInfo;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
