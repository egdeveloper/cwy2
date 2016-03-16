package org.egdeveloper.service;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.data.entities.Patient;
import java.util.List;


public interface IPatientService {
    void addPatient(Doctor doctor, Patient patient);
    void editPatientInfo(Patient patient);
    List<Patient> getPatients();
    Patient getPatientById(Integer id);
    boolean checkPatientExist(Patient patient);
    void removePatient(Integer id);
}
