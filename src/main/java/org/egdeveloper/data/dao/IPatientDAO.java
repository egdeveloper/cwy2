package org.egdeveloper.data.dao;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.data.entities.MedicalTest;
import org.egdeveloper.data.entities.Patient;
import java.util.List;

/**
 * Common interface of DAO for manipulating with patient data
 * @author Yarnykh Roman egdeveloper@mail.ru
 * @version 1.0
 * @since 05.01.2016 (5th January 2016)
 * @see org.egdeveloper.data.dao.PatientDAO
 */
public interface IPatientDAO {

    /**
     * Add new patient record in local database
     * @param doctor doctor's infor
     * @param patient patient record
     */
    void addPatient(Doctor doctor, Patient patient);

    /**
     * List of all existing patient records
     * @return list of patient records
     */
    List<Patient> getPatients();

    /**
     * Get unique patient record
     * @param id unique patient id
     * @return Patient instance
     */
    Patient getPatientById(Integer id);

    /**
     * Remove existing patient record
     * @param id id of existing patient record
     */
    void removePatient(Integer id);

    /**
     * Get patient entry from doctor record, delete it and update doctor record
     * @param doctor doctor record
     * @param patientId patientID
     */
    void removePatientAndUpdateDoctor(Doctor doctor, Integer patientId);


    /**
     * Edit patient info
     * @param patient patient record
     */
    void editPatientInfo(Patient patient);

    boolean checkPatientExist(Patient patient);


    /**
     * Add medicatl service to existing patient record
     * @param patientID patient id
     * @param test service instance
     */
    void addMedicalTest(Integer patientID, MedicalTest test);
}
