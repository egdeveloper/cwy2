package org.egdeveloper.service;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.data.entities.MedicalTest;
import org.egdeveloper.data.entities.Patient;
import java.util.List;


public interface IPatientService {
    void addPatient(Doctor doctor, Patient patient);
    void editPatientInfo(Patient patient);
    List<Patient> getPatients();
    Patient getPatientById(Integer id);
    boolean checkPatientExist(Patient patient);
    void removePatient(Integer patientId);
    void removePatientAndUpdateDoctor(Doctor doctor, Integer patientID);
    void addMedicalTest(Integer patientID, MedicalTest medicalTest);
    <T> List<T> retrieveMedicalTestsByType(Class<T> medicalTestClass);
    List<MedicalTest> retrieveAllMedicalTests();
}
