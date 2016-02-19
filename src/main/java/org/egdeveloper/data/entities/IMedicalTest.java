package org.egdeveloper.data.entities;

import org.egdeveloper.attributes.MedTest;
import org.joda.time.LocalDate;

@MedTest
public interface IMedicalTest {
    LocalDate getTestDate();
    void setTestDate(LocalDate testDate);
    String getDescription();
    void setDescription(String description);
}
