package org.egdeveloper.service;

import org.egdeveloper.data.entities.Patient;
import java.util.List;


public interface IPatientService {
    void addPatient(Patient patient);
    List<Patient> getPatients();
    void removePatient(Integer id);
}
