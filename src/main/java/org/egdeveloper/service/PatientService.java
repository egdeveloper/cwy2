package org.egdeveloper.service;

import org.egdeveloper.data.dao.IPatientDAO;
import org.egdeveloper.data.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("patientService")
@Transactional
public class PatientService implements IPatientService{

    @Autowired
    @Qualifier("patientDAO")
    private IPatientDAO patientDAO;

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
