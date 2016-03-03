package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.MedTest;
import org.joda.time.LocalDate;

import javax.persistence.Transient;

@MedTest
public interface IMedicalTest {

    /**
     * Retrieve defined test date
     * @return test date
     */
    LocalDate getTestDate();

    /**
     * Set test date
     * @param testDate test date
     */
    void setTestDate(LocalDate testDate);

    /**
     * Retrieve test description
     * @return description
     */
    String getDescription();

    /**
     * Set description
     * @param description description
     */
    void setDescription(String description);

    /**
     * Retrieve name (type) of current test
     * @return test name (type)
     */
    @Transient
    default String retrieveName(){
        return this.getClass().getAnnotation(DisplayName.class).value();
    }
}
