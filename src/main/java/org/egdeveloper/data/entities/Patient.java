package org.egdeveloper.data.entities;
import org.egdeveloper.data.entities.custom_types.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Patient")
public class Patient implements Serializable{

    //Fields

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 255)
    @NotEmpty
    @Column(name = "fullName", nullable = false)
    private String fullName;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @NotNull
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @NotNull
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

    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "rh", nullable = false)
    private Rh rh;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "bloodGroup", nullable = false)
    private BloodGroup bloodGroup;

    @NotEmpty
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
    private String post;

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

    @OneToMany
    private Set<BioChemTest> bioChemTests = new HashSet<BioChemTest>();

    @OneToMany
    private Set<CommonBloodTest> commonBloodTests = new HashSet<CommonBloodTest>();

    @OneToMany
    private Set<CommonUreaTest> commonUreaTests = new HashSet<CommonUreaTest>();

    @OneToMany
    private Set<DailyExcreationTest> dailyExcreationTests = new HashSet<DailyExcreationTest>();

    @OneToMany
    private Set<TitrationTest> titrationTests = new HashSet<TitrationTest>();

    @OneToMany
    private Set<UreaColorTest> ureaColorTests = new HashSet<UreaColorTest>();

    @OneToMany
    private Set<UreaStoneTest> ureaStoneTests = new HashSet<UreaStoneTest>();

    @ManyToMany
    private Set<Doctor> doctor = new HashSet<Doctor>();

    //Getters and setters


}
