package org.egdeveloper.service.data;

import org.egdeveloper.data.dao.IPatientDAO;
import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.data.entities.MedicalTest;
import org.egdeveloper.data.entities.Patient;
import org.egdeveloper.data.entities.tempEntities.PatientDTO;
import org.egdeveloper.service.data.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("patientService")
@Transactional
public class PatientService implements IPatientService {

    @Autowired
    @Qualifier("patientDAO")
    private IPatientDAO patientDAO;

    @Override
    public void addPatient(Doctor doctor, Patient patient){
        patientDAO.addPatient(doctor, patient);
    }

    @Override
    public void updatePatient(Patient patient){
        patientDAO.updatePatient(patient);
    }

    @Override
    public List<Patient> getPatients(){
        return patientDAO.getPatients();
    }

    @Override
    public List<PatientDTO> getPatientsForDoctor(Integer doctorID) {
        return patientDAO.getPatientsForDoctor(doctorID);
    }

    @Override
    public Patient getPatientById(Integer id){
        return patientDAO.getPatientById(id);
    }

    @Override
    public boolean checkPatientExist(Patient patient) {
        return patientDAO.checkPatientExist(patient);
    }

    @Override
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
    public void addMedicalTest(Patient patient, MedicalTest medicalTest) {
        patientDAO.addMedicalTest(patient, medicalTest);
    }

    @Override
    public <T extends MedicalTest> T getMedicalTestByID(Class<T> medicalTestClazz, int testID) {
        return patientDAO.getMedicalTestByID(medicalTestClazz, testID);
    }

    @Override
    public <T extends MedicalTest> List<T> retrieveMedicalTestsByType(Class<T> medicalTestClass) {
        return patientDAO.retrieveMedicalTestsByType(medicalTestClass);
    }

    @Override
    public List<MedicalTest> retrieveAllMedicalTests() {
        return patientDAO.retrieveAllMedicalTests();
    }
}
