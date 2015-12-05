package org.egdeveloper.data.entities;
import org.egdeveloper.data.entities.custom_types.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PATIENT")
public class Patient implements Serializable{

    //Fields

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Size(max = 255)
    @NotEmpty
    @Column(name = "FULL_NAME", nullable = false)
    private String FullName;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER", nullable = false)
    private Gender Gender;

    @NotNull
    @Column(name = "BIRTHDATE", nullable = false)
    private LocalDate Birthdate;

    @NotNull
    @Column(name = "CARD_NUMBER", nullable = false)
    private String CardNumber;

    @NotNull
    @Column(name = "PASSPORT", nullable = false)
    private String Passport;

    @NotNull
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String PhoneNumber;

    @NotNull
    @Column(name = "COUNTRY", nullable = false)
    private String Country;

    @NotNull
    @Column(name = "POST_INDEX", nullable = false)
    private String PostIndex;

    @NotNull
    @Column(name = "REGION", nullable = false)
    private String Region;

    @NotNull
    @Column(name = "CITY", nullable = false)
    private String City;

    @NotNull
    @Column(name = "ADDRESS", nullable = false)
    private String Address;

    @Column(name = "EMAIL", nullable = false)
    private String Email;

    //private byte[] Photo;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "RH", nullable = false)
    private Rh Rh;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "BLOOD_GROUP", nullable = false)
    private BloodGroup BloodGroup;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "DISABILITY", nullable = false)
    private Disability Disability;

    @NotNull
    @Column(name = "TIN", nullable = false)
    private String TIN;

    @NotNull
    @Column(name = "OMI_CARD", nullable = false)
    private String OMICard;

    @NotNull
    @Column(name = "JOB_PLACE", nullable = false)
    private String JobPlace;

    @NotNull
    @Column(name = "OCCUPATION", nullable = false)
    private String Occupation;

    @NotNull
    @Column(name = "POST", nullable = false)
    private String Post;

    @NotNull
    @Column(name = "JON_CONDITIONS", nullable = false)
    private String JobConditions;

    @NotNull
    @Column(name = "COMPLAINTS", nullable = false)
    private String Complaints;

    @NotNull
    @Column(name = "PREMEDICATION", nullable = false)
    private String Premedication;

    @NotNull
    @Column(name = "ASSOCIATED_DISEASE", nullable = false)
    private String AssociatedDisease;

    @NotNull
    @Column(name = "PREMEDICAL_SUPPLIES", nullable = false)
    private String PreMedicalSupplies;

    @NotNull
    @Column(name = "BAD_HABITS", nullable = false)
    private String BadHabits;

    @NotNull
    @Column(name = "PRE_UREA_STONE_DESCRIPTION", nullable = false)
    private String PreUreaStoneDescription;

    @NotNull
    @Column(name = "DISEASE_DURATION", nullable = false)
    private String DiseaseDuration;

    //Getters and setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Gender getGender() {
        return Gender;
    }

    public void setGender(Gender gender) {
        Gender = gender;
    }

    public LocalDate getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        Birthdate = birthdate;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public String getPassport() {
        return Passport;
    }

    public void setPassport(String passport) {
        Passport = passport;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPostIndex() {
        return PostIndex;
    }

    public void setPostIndex(String postIndex) {
        PostIndex = postIndex;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    /*
    public byte[] getPhoto() {
        return Photo;
    }

    public void setPhoto(byte[] photo) {
        Photo = photo;
    }
    */

    public Rh getRh() {
        return Rh;
    }

    public void setRh(Rh rh) {
        Rh = rh;
    }

    public BloodGroup getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        BloodGroup = bloodGroup;
    }

    public Disability getDisability() {
        return Disability;
    }

    public void setDisability(Disability disability) {
        Disability = disability;
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
        return JobPlace;
    }

    public void setJobPlace(String jobPlace) {
        JobPlace = jobPlace;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public String getJobConditions() {
        return JobConditions;
    }

    public void setJobConditions(String jobConditions) {
        JobConditions = jobConditions;
    }

    public String getComplaints() {
        return Complaints;
    }

    public void setComplaints(String complaints) {
        Complaints = complaints;
    }

    public String getPremedication() {
        return Premedication;
    }

    public void setPremedication(String premedication) {
        Premedication = premedication;
    }

    public String getAssociatedDisease() {
        return AssociatedDisease;
    }

    public void setAssociatedDisease(String associatedDisease) {
        AssociatedDisease = associatedDisease;
    }

    public String getPreMedicalSupplies() {
        return PreMedicalSupplies;
    }

    public void setPreMedicalSupplies(String preMedicalSupplies) {
        PreMedicalSupplies = preMedicalSupplies;
    }

    public String getBadHabits() {
        return BadHabits;
    }

    public void setBadHabits(String badHabits) {
        BadHabits = badHabits;
    }

    public String getPreUreaStoneDescription() {
        return PreUreaStoneDescription;
    }

    public void setPreUreaStoneDescription(String preUreaStoneDescription) {
        PreUreaStoneDescription = preUreaStoneDescription;
    }

    public String getDiseaseDuration() {
        return DiseaseDuration;
    }

    public void setDiseaseDuration(String diseaseDuration) {
        DiseaseDuration = diseaseDuration;
    }

}
