package org.egdeveloper.data.dao;

import org.egdeveloper.data.entities.Patient;
import java.util.List;

public interface IPatientDAO {
    void addPatient(Patient patient);
    List<Patient> getPatients();
    void removePatient(Integer id);
}
