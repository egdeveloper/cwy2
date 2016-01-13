package org.egdeveloper.data.entities;
import org.egdeveloper.data.entities.custom_types.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.joda.time.LocalDate;

@Entity
@Table(name = "Patient")
public class Patient implements Serializable{

    //Fields

    @Id
    @Column(name = "patient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 255)
    @NotEmpty(message = "Введите ФИО пациента")
    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @NotNull
    //@NotEmpty(message = "Введите дату рождения")
    //@Temporal(TemporalType.DATE)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @NotNull
    @NotEmpty(message = "Введите номер карты")
    @Column(name = "cardNumber", nullable = false)
    private String cardNumber;

    @NotNull
    @Column(name = "passport", nullable = false)
    private String passport;

    @NotNull
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @NotNull
    @Column(name = "country", nullable = false)
    private String country;

    @NotNull
    @Column(name = "postIndex", nullable = false)
    private String postIndex;

    @NotNull
    @Column(name = "region", nullable = false)
    private String region;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email", nullable = false)
    private String email;

    //@NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "rh", nullable = false)
    private Rh rh;

    //@NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "bloodGroup", nullable = false)
    private BloodGroup bloodGroup;

    //@NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "disability", nullable = false)
    private Disability disability;

    @NotNull
    @Column(name = "TIN", nullable = false)
    private String TIN;

    @NotNull
    @Column(name = "OMICard", nullable = false)
    private String OMICard;

    @NotNull
    @Column(name = "jobPlace", nullable = false)
    private String jobPlace;

    @NotNull
    @Column(name = "occupation", nullable = false)
    private String occupation;

    @NotNull
    @Column(name = "post", nullable = false)
    private String jobPost;

    @NotNull
    @Column(name = "jobConditions", nullable = false)
    private String jobConditions;

    @NotNull
    @Column(name = "complaints", nullable = false)
    private String complaints;

    @NotNull
    @Column(name = "premedication", nullable = false)
    private String premedication;

    @NotNull
    @Column(name = "associatedDisease", nullable = false)
    private String associatedDisease;

    @NotNull
    @Column(name = "preMedicalSupplies", nullable = false)
    private String preMedicalSupplies;

    @NotNull
    @Column(name = "badHabits", nullable = false)
    private String badHabits;

    @NotNull
    @Column(name = "preUreaStoneDescription", nullable = false)
    private String preUreaStoneDescription;

    @NotNull
    @Column(name = "diseaseDuration", nullable = false)
    private String diseaseDuration;


    @OneToMany(fetch = FetchType.LAZY)
    private Set<BioChemTest> bioChemTests = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<CommonBloodTest> commonBloodTests = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<CommonUreaTest> commonUreaTests = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<DailyExcreationTest> dailyExcreationTests = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<TitrationTest> titrationTests = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<UreaColorTest> ureaColorTests = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<UreaStoneTest> ureaStoneTests = new HashSet<>();


    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getTIN() {
        return TIN;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    public String getOMICard() {
        return OMICard;
    }

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

    public Set<BioChemTest> getBioChemTests() {
        return bioChemTests;
    }

    public void setBioChemTests(Set<BioChemTest> bioChemTests) {
        this.bioChemTests = bioChemTests;
    }

    public Set<CommonBloodTest> getCommonBloodTests() {
        return commonBloodTests;
    }

    public void setCommonBloodTests(Set<CommonBloodTest> commonBloodTests) {
        this.commonBloodTests = commonBloodTests;
    }

    public Set<CommonUreaTest> getCommonUreaTests() {
        return commonUreaTests;
    }

    public void setCommonUreaTests(Set<CommonUreaTest> commonUreaTests) {
        this.commonUreaTests = commonUreaTests;
    }

    public Set<DailyExcreationTest> getDailyExcreationTests() {
        return dailyExcreationTests;
    }

    public void setDailyExcreationTests(Set<DailyExcreationTest> dailyExcreationTests) {
        this.dailyExcreationTests = dailyExcreationTests;
    }

    public Set<TitrationTest> getTitrationTests() {
        return titrationTests;
    }

    public void setTitrationTests(Set<TitrationTest> titrationTests) {
        this.titrationTests = titrationTests;
    }

    public Set<UreaColorTest> getUreaColorTests() {
        return ureaColorTests;
    }

    public void setUreaColorTests(Set<UreaColorTest> ureaColorTests) {
        this.ureaColorTests = ureaColorTests;
    }

    public Set<UreaStoneTest> getUreaStoneTests() {
        return ureaStoneTests;
    }

    public void setUreaStoneTests(Set<UreaStoneTest> ureaStoneTests) {
        this.ureaStoneTests = ureaStoneTests;
    }
}
