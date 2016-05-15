package org.egdeveloper.service.data;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.data.entities.MedicalTest;
import org.egdeveloper.data.entities.Patient;
import org.egdeveloper.data.entities.tempEntities.PatientDTO;

import java.util.List;


public interface IPatientService {
    void addPatient(Doctor doctor, Patient patient);
    void updatePatient(Patient patient);
    List<Patient> getPatients();
    List<PatientDTO> getPatientsForDoctor(Integer doctorID);
    Patient getPatientById(Integer id);
    boolean checkPatientExist(Patient patient);
    void removePatient(Integer patientId);
    void removePatientAndUpdateDoctor(Doctor doctor, Integer patientID);
    void addMedicalTest(Integer patientID, MedicalTest medicalTest);
    void addMedicalTest(Patient patient, MedicalTest medicalTest);
    <T extends MedicalTest> List<T> retrieveMedicalTestsByType(Class<T> medicalTestClass);
    <T extends MedicalTest> T getMedicalTestByID(Class<T> medicalTestClazz, int testID);
    List<MedicalTest> retrieveAllMedicalTests();
}
