package org.egdeveloper.service;

import org.egdeveloper.data.dao.IPatientDAO;
import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.data.entities.MedicalTest;
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
    public void addPatient(Doctor doctor, Patient patient){
        patientDAO.addPatient(doctor, patient);
    }

    @Transactional
    public void editPatientInfo(Patient patient){
        patientDAO.editPatientInfo(patient);
    }

    @Transactional
    public List<Patient> getPatients(){
        return patientDAO.getPatients();
    }

    @Transactional
    public Patient getPatientById(Integer id){
        return patientDAO.getPatientById(id);
    }

    @Override
    public boolean checkPatientExist(Patient patient) {
        return patientDAO.checkPatientExist(patient);
    }

    @Transactional
    public void removePatient(Integer id){
        patientDAO.removePatient(id);
    }

    @Override
    public void removePatientAndUpdateDoctor(Doctor doctor, Integer patientID) {
        patientDAO.removePatientAndUpdateDoctor(doctor, patientID);
    }

    @Override
    public void addMedicalTest(Integer patientID, MedicalTest medicalTest) {
        patientDAO.addMedicalTest(patientID, medicalTest);
    }

    @Override
    public <T> List<T> retrieveMedicalTestsByType(Class<T> medicalTestClass) {
        return patientDAO.retrieveMedicalTestsByType(medicalTestClass);
    }

    @Override
    public List<MedicalTest> retrieveAllMedicalTests() {
        return patientDAO.retrieveAllMedicalTests();
    }
}
