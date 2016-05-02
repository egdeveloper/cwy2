package org.egdeveloper.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.egdeveloper.attributes.DisplayName;
import org.egdeveloper.attributes.EntityID;
import org.egdeveloper.attributes.MedTest;
import org.egdeveloper.converters.deserializers.CustomDateTimeDeserializer;
import org.egdeveloper.converters.deserializers.MedicalTestDeserializer;
import org.egdeveloper.converters.serializers.CustomDateTimeSerializer;
import org.egdeveloper.converters.serializers.MedicalTestSerializer;
import org.egdeveloper.data.entities.custom_types.Attachment;
import org.egdeveloper.data.entities.custom_types.PatientState;
import org.egdeveloper.data.entities.custom_types.TreatmentNumber;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonSerialize(using = MedicalTestSerializer.class)
@JsonDeserialize(using = MedicalTestDeserializer.class)
@MedTest
@MappedSuperclass
public abstract class MedicalTest extends AbstractEntity implements Serializable, Comparable<MedicalTest>{

    public MedicalTest(){
        attachment = new HashSet<>();
    }

    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "testDate", nullable = false)
    @DisplayName("Дата проведения анализа")
    private LocalDate testDate;

    @Column(name = "treatment", nullable = false)
    @DisplayName("Лечение")
    private String treatment;

    @Column(name = "treatmentNumber", nullable = false)
    @DisplayName("Стадия лечения")
    private TreatmentNumber treatmentNumber;

    @Column(name = "description", nullable = false)
    @DisplayName("Дополнительная информация")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "patientState")
    @DisplayName("Состояние пациента")
    private PatientState patientState;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "TestAttachments", joinColumns = @JoinColumn(name = "testID"))
    @Fetch(FetchMode.SELECT)
    private Set<Attachment> attachment;

    @ManyToOne(fetch = FetchType.EAGER)
    private Patient patient;

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
     * Get treatment
     * @return treatment
     */
    public String getTreatment() {
        return treatment;
    }

    /**
     * Set treatment
     * @param treatment treatment
     */
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    /**
     * Get number of treatment
     * @return treatment number
     */
    public TreatmentNumber getTreatmentNumber() {
        return treatmentNumber;
    }

    /**
     * Set treatment number
     * @param treatmentNumber treatment number
     */
    public void setTreatmentNumber(TreatmentNumber treatmentNumber) {
        this.treatmentNumber = treatmentNumber;
    }

    /**
     * Get patient state
     * @return patient state
     */
    public PatientState getPatientState(){
        return patientState;
    }

    /**
     * Set patient state
     * @param patientState patient state
     */
    public void setPatientState(PatientState patientState){
        this.patientState = patientState;
    }

    /**
     * Get test attachment
     * @return test attachment
     */
    @JsonProperty("attachments")
    public Set<Attachment> getAttachment(){
        return attachment;
    }

    /**
     * Set test attachment
     * @param attachment attachment
     */
    @JsonProperty("attachments")
    public void setAttachment(Set<Attachment> attachment){
        this.attachment = attachment;
    }

    /**
     * Get test owner
     * @return patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Set test owner
     * @param patient patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Retrieve name (type) of current test
     * @return test name (type)
     */
    @Transient
    public String retrieveName(){
        return this.getClass().getAnnotation(DisplayName.class).value();
    }

    @Transient
    public String retrieveEntityID(){
        return this.getClass().getAnnotation(EntityID.class).value();
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
