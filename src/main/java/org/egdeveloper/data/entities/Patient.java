package org.egdeveloper.data.entities;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.egdeveloper.attributes.MedTest;
import org.egdeveloper.converters.CustomDateTimeDeserializer;
import org.egdeveloper.converters.CustomDateTimeSerializer;
import org.egdeveloper.data.entities.custom_types.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.joda.time.LocalDate;

@Entity
@Table(name = "Patient")
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public class Patient extends AbstractEntity implements Serializable{

    public Patient(){}

    //Fields

    @Size(max = 255)
    //@JsonProperty("fullName")
    @NotEmpty(message = "Введите ФИО пациента")
    @Column(name = "fullName", nullable = false)
    private String fullName;

    //@JsonProperty("gender")
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @NotNull
    //@JsonProperty("birthdate")
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    @JsonDeserialize(using = CustomDateTimeDeserializer.class)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @NotNull
    @NotEmpty(message = "Введите номер карты")
    //@JsonProperty("cardNumber")
    @Column(name = "cardNumber", nullable = false)
    private String cardNumber;

    @NotNull
    //@JsonProperty("passport")
    @Column(name = "passport", nullable = false)
    private String passport;

    @NotNull
    //@JsonProperty("phoneNumber")
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @NotNull
    //@JsonProperty("country")
    @Column(name = "country", nullable = false)
    private String country;

    @NotNull
    //@JsonProperty("postIndex")
    @Column(name = "postIndex", nullable = false)
    private String postIndex;

    @NotNull
    //@JsonProperty("region")
    @Column(name = "region", nullable = false)
    private String region;

    @NotNull
    //@JsonProperty("city")
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    //@JsonProperty("address")
    @Column(name = "address", nullable = false)
    private String address;

    //@JsonProperty("email")
    @Column(name = "email", nullable = false)
    private String email;

    //@JsonProperty("patientState")
    @Enumerated(EnumType.STRING)
    @Column(name = "patientState", nullable = false)
    private PatientState patientState;

    //@JsonProperty("rh")
    @Enumerated(EnumType.STRING)
    @Column(name = "rh", nullable = false)
    private Rh rh;

    //@JsonProperty("bloodGroup")
    @Enumerated(EnumType.STRING)
    @Column(name = "bloodGroup", nullable = false)
    private BloodGroup bloodGroup;

    //@JsonProperty("disability")
    @Enumerated(EnumType.STRING)
    @Column(name = "disability", nullable = false)
    private Disability disability;

    @NotNull
    //@JsonProperty("tin")
    @Column(name = "TIN", nullable = false)
    private String TIN;

    @NotNull
    //@JsonProperty("omiCard")
    @Column(name = "OMICard", nullable = false)
    private String OMICard;

    @NotNull
    //@JsonProperty("jobPlace")
    @Column(name = "jobPlace", nullable = false)
    private String jobPlace;

    @NotNull
    //@JsonProperty("occupation")
    @Column(name = "occupation", nullable = false)
    private String occupation;

    @NotNull
    @Column(name = "post", nullable = false)
    private String jobPost;

    @NotNull
    //@JsonProperty("jobConditions")
    @Column(name = "jobConditions", nullable = false)
    private String jobConditions;

    @NotNull
    //@JsonProperty("complaints")
    @Column(name = "complaints", nullable = false)
    private String complaints;

    @NotNull
    //@JsonProperty("premedication")
    @Column(name = "premedication", nullable = false)
    private String premedication;

    @NotNull
    //@JsonProperty("associatedDisease")
    @Column(name = "associatedDisease", nullable = false)
    private String associatedDisease;

    @NotNull
    //@JsonProperty("preMedicalSupplies")
    @Column(name = "preMedicalSupplies", nullable = false)
    private String preMedicalSupplies;

    @NotNull
    //@JsonProperty("badHabits")
    @Column(name = "badHabits", nullable = false)
    private String badHabits;

    @NotNull
    //@JsonProperty("preUreaStoneDescription")
    @Column(name = "preUreaStoneDescription", nullable = false)
    private String preUreaStoneDescription;

    @NotNull
    //@JsonProperty("diseaseDuration")
    @Column(name = "diseaseDuration", nullable = false)
    private String diseaseDuration;


    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MedTest
    private Set<BioChemTest> bioChemTests = new TreeSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MedTest
    private Set<CommonBloodTest> commonBloodTests = new TreeSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MedTest
    private Set<CommonUreaTest> commonUreaTests = new TreeSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MedTest
    private Set<DailyExcreationTest> dailyExcreationTests = new TreeSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MedTest
    private Set<TitrationTest> titrationTests = new TreeSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MedTest
    private Set<UreaColorTest> ureaColorTests = new TreeSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MedTest
    private Set<UreaStoneTest> ureaStoneTests = new TreeSet<>();


    //Getters and setters

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PatientState getPatientState(){
        return patientState;
    }

    public void setPatientState(PatientState patientState){
        this.patientState = patientState;
    }
    public Rh getRh() {
        return rh;
    }

    public void setRh(Rh rh) {
        this.rh = rh;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Disability getDisability() {
        return disability;
    }

    public void setDisability(Disability disability) {
        this.disability = disability;
    }

    //@JsonSerialize
    //@JsonProperty(value = "tin")
    public String getTIN() {
        return TIN;
    }

    //@JsonDeserialize
    //@JsonProperty(value = "tin")
    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    //@JsonSerialize
    //@JsonProperty(value = "omiCard")
    public String getOMICard() {
        return OMICard;
    }

    //@JsonDeserialize
    //@JsonProperty(value = "omiCard")
    public void setOMICard(String OMICard) {
        this.OMICard = OMICard;
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public String getJobPost() {
        return jobPost;
    }

    public void setJobPost(String jobPost) {
        this.jobPost = jobPost;
    }

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    public String getJobConditions() {
        return jobConditions;
    }

    public void setJobConditions(String jobConditions) {
        this.jobConditions = jobConditions;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getPremedication() {
        return premedication;
    }

    public void setPremedication(String premedication) {
        this.premedication = premedication;
    }

    public String getAssociatedDisease() {
        return associatedDisease;
    }

    public void setAssociatedDisease(String associatedDisease) {
        this.associatedDisease = associatedDisease;
    }

    public String getPreMedicalSupplies() {
        return preMedicalSupplies;
    }

    public void setPreMedicalSupplies(String preMedicalSupplies) {
        this.preMedicalSupplies = preMedicalSupplies;
    }

    public String getBadHabits() {
        return badHabits;
    }

    public void setBadHabits(String badHabits) {
        this.badHabits = badHabits;
    }

    public String getPreUreaStoneDescription() {
        return preUreaStoneDescription;
    }

    public void setPreUreaStoneDescription(String preUreaStoneDescription) {
        this.preUreaStoneDescription = preUreaStoneDescription;
    }

    public String getDiseaseDuration() {
        return diseaseDuration;
    }

    public void setDiseaseDuration(String diseaseDuration) {
        this.diseaseDuration = diseaseDuration;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @MedTest
    public Set<BioChemTest> getBioChemTests() {
        return bioChemTests;
    }

    public void setBioChemTests(Set<BioChemTest> bioChemTests) {
        this.bioChemTests = bioChemTests;
    }

    @MedTest
    public Set<CommonBloodTest> getCommonBloodTests() {
        return commonBloodTests;
    }

    public void setCommonBloodTests(Set<CommonBloodTest> commonBloodTests) {
        this.commonBloodTests = commonBloodTests;
    }

    @MedTest
    public Set<CommonUreaTest> getCommonUreaTests() {
        return commonUreaTests;
    }

    public void setCommonUreaTests(Set<CommonUreaTest> commonUreaTests) {
        this.commonUreaTests = commonUreaTests;
    }

    @MedTest
    public Set<DailyExcreationTest> getDailyExcreationTests() {
        return dailyExcreationTests;
    }

    public void setDailyExcreationTests(Set<DailyExcreationTest> dailyExcreationTests) {
        this.dailyExcreationTests = dailyExcreationTests;
    }

    @MedTest
    public Set<TitrationTest> getTitrationTests() {
        return titrationTests;
    }

    public void setTitrationTests(Set<TitrationTest> titrationTests) {
        this.titrationTests = titrationTests;
    }

    @MedTest
    public Set<UreaColorTest> getUreaColorTests() {
        return ureaColorTests;
    }

    public void setUreaColorTests(Set<UreaColorTest> ureaColorTests) {
        this.ureaColorTests = ureaColorTests;
    }

    @MedTest
    public Set<UreaStoneTest> getUreaStoneTests() {
        return ureaStoneTests;
    }

    public void setUreaStoneTests(Set<UreaStoneTest> ureaStoneTests) {
        this.ureaStoneTests = ureaStoneTests;
    }

    @Transient
    public Set<MedicalTest> retrieveAllPatientTests(){
        Set<MedicalTest> tests = new HashSet<>();
        tests.addAll(getBioChemTests());
        tests.addAll(getCommonBloodTests());
        tests.addAll(getCommonUreaTests());
        tests.addAll(getDailyExcreationTests());
        tests.addAll(getTitrationTests());
        tests.addAll(getUreaColorTests());
        tests.addAll(getUreaStoneTests());
        return tests;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;

        Patient patient = (Patient) o;

        if (fullName != null ? !fullName.equals(patient.fullName) : patient.fullName != null) return false;
        if (gender != patient.gender) return false;
        if (birthdate != null ? !birthdate.equals(patient.birthdate) : patient.birthdate != null) return false;
        if (cardNumber != null ? !cardNumber.equals(patient.cardNumber) : patient.cardNumber != null) return false;
        if (passport != null ? !passport.equals(patient.passport) : patient.passport != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(patient.phoneNumber) : patient.phoneNumber != null) return false;
        if (country != null ? !country.equals(patient.country) : patient.country != null) return false;
        if (postIndex != null ? !postIndex.equals(patient.postIndex) : patient.postIndex != null) return false;
        if (region != null ? !region.equals(patient.region) : patient.region != null) return false;
        if (city != null ? !city.equals(patient.city) : patient.city != null) return false;
        if (address != null ? !address.equals(patient.address) : patient.address != null) return false;
        if (email != null ? !email.equals(patient.email) : patient.email != null) return false;
        if (patientState != patient.patientState) return false;
        if (rh != patient.rh) return false;
        if (bloodGroup != patient.bloodGroup) return false;
        if (disability != patient.disability) return false;
        if (TIN != null ? !TIN.equals(patient.TIN) : patient.TIN != null) return false;
        if (OMICard != null ? !OMICard.equals(patient.OMICard) : patient.OMICard != null) return false;
        if (jobPlace != null ? !jobPlace.equals(patient.jobPlace) : patient.jobPlace != null) return false;
        if (occupation != null ? !occupation.equals(patient.occupation) : patient.occupation != null) return false;
        if (jobPost != null ? !jobPost.equals(patient.jobPost) : patient.jobPost != null) return false;
        if (jobConditions != null ? !jobConditions.equals(patient.jobConditions) : patient.jobConditions != null)
            return false;
        if (complaints != null ? !complaints.equals(patient.complaints) : patient.complaints != null) return false;
        if (premedication != null ? !premedication.equals(patient.premedication) : patient.premedication != null)
            return false;
        if (associatedDisease != null ? !associatedDisease.equals(patient.associatedDisease) : patient.associatedDisease != null)
            return false;
        if (preMedicalSupplies != null ? !preMedicalSupplies.equals(patient.preMedicalSupplies) : patient.preMedicalSupplies != null)
            return false;
        if (badHabits != null ? !badHabits.equals(patient.badHabits) : patient.badHabits != null) return false;
        if (preUreaStoneDescription != null ? !preUreaStoneDescription.equals(patient.preUreaStoneDescription) : patient.preUreaStoneDescription != null)
            return false;
        if (diseaseDuration != null ? !diseaseDuration.equals(patient.diseaseDuration) : patient.diseaseDuration != null)
            return false;
        if (bioChemTests != null ? !bioChemTests.equals(patient.bioChemTests) : patient.bioChemTests != null)
            return false;
        if (commonBloodTests != null ? !commonBloodTests.equals(patient.commonBloodTests) : patient.commonBloodTests != null)
            return false;
        if (commonUreaTests != null ? !commonUreaTests.equals(patient.commonUreaTests) : patient.commonUreaTests != null)
            return false;
        if (dailyExcreationTests != null ? !dailyExcreationTests.equals(patient.dailyExcreationTests) : patient.dailyExcreationTests != null)
            return false;
        if (titrationTests != null ? !titrationTests.equals(patient.titrationTests) : patient.titrationTests != null)
            return false;
        if (ureaColorTests != null ? !ureaColorTests.equals(patient.ureaColorTests) : patient.ureaColorTests != null)
            return false;
        return ureaStoneTests != null ? ureaStoneTests.equals(patient.ureaStoneTests) : patient.ureaStoneTests == null;

    }

    @Override
    public int hashCode() {
        int result = fullName != null ? fullName.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (postIndex != null ? postIndex.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (patientState != null ? patientState.hashCode() : 0);
        result = 31 * result + (rh != null ? rh.hashCode() : 0);
        result = 31 * result + (bloodGroup != null ? bloodGroup.hashCode() : 0);
        result = 31 * result + (disability != null ? disability.hashCode() : 0);
        result = 31 * result + (TIN != null ? TIN.hashCode() : 0);
        result = 31 * result + (OMICard != null ? OMICard.hashCode() : 0);
        result = 31 * result + (jobPlace != null ? jobPlace.hashCode() : 0);
        result = 31 * result + (occupation != null ? occupation.hashCode() : 0);
        result = 31 * result + (jobPost != null ? jobPost.hashCode() : 0);
        result = 31 * result + (jobConditions != null ? jobConditions.hashCode() : 0);
        result = 31 * result + (complaints != null ? complaints.hashCode() : 0);
        result = 31 * result + (premedication != null ? premedication.hashCode() : 0);
        result = 31 * result + (associatedDisease != null ? associatedDisease.hashCode() : 0);
        result = 31 * result + (preMedicalSupplies != null ? preMedicalSupplies.hashCode() : 0);
        result = 31 * result + (badHabits != null ? badHabits.hashCode() : 0);
        result = 31 * result + (preUreaStoneDescription != null ? preUreaStoneDescription.hashCode() : 0);
        result = 31 * result + (diseaseDuration != null ? diseaseDuration.hashCode() : 0);
        result = 31 * result + (bioChemTests != null ? bioChemTests.hashCode() : 0);
        result = 31 * result + (commonBloodTests != null ? commonBloodTests.hashCode() : 0);
        result = 31 * result + (commonUreaTests != null ? commonUreaTests.hashCode() : 0);
        result = 31 * result + (dailyExcreationTests != null ? dailyExcreationTests.hashCode() : 0);
        result = 31 * result + (titrationTests != null ? titrationTests.hashCode() : 0);
        result = 31 * result + (ureaColorTests != null ? ureaColorTests.hashCode() : 0);
        result = 31 * result + (ureaStoneTests != null ? ureaStoneTests.hashCode() : 0);
        return result;
    }
}
