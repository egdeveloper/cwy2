package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.MedTest;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@MedTest
@MappedSuperclass
public abstract class MedicalTest extends AbstractEntity implements Serializable, Comparable<MedicalTest>{

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


    /**
     * Retrieve defined test date
     * @return test date
     */
    public LocalDate getTestDate(){
        return this.testDate;
    }

    /**
     * Set test date
     * @param testDate test date
     */
    public void setTestDate(LocalDate testDate){
        this.testDate = testDate;
    }

    /**
     * Retrieve test description
     * @return description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * Set description
     * @param description description
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * Retrieve name (type) of current test
     * @return test name (type)
     */
    @Transient
    public String retrieveName(){
        return this.getClass().getAnnotation(DisplayName.class).value();
    }

    @Override
    @Transient
    public int compareTo(MedicalTest otherTest){
        if(this.getTestDate().isEqual(otherTest.getTestDate()))
            return 0;
        else
            return this.getTestDate().isBefore(otherTest.getTestDate()) ? -1 : 1;
    }
}
