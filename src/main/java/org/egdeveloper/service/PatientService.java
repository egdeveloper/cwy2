package org.egdeveloper.service;

import org.egdeveloper.data.dao.PatientDAO;
import org.egdeveloper.data.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by egdeveloper on 16.11.15.
 */

@Service
@Scope("singleton")
public class PatientService {

    @Autowired
    private PatientDAO patientDAO;

    @Transactional
    public void addPatient(Patient patient){
        patientDAO.addPatient(patient);
    }

    @Transactional
    public List<Patient> getPatients(){
        return patientDAO.getPatients();
    }

    @Transactional
    public void removePatient(Integer id){
        patientDAO.removePatient(id);
    }
}
