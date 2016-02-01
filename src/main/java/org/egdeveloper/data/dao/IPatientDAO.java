package org.egdeveloper.data.dao;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.data.entities.IMedicalTest;
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
     * Edit patient info
     * @param patient patient record
     */
    void editPatientInfo(Patient patient);


    /**
     * Add medicatl test to existing patient record
     * @param patient patient record
     * @param test test instance
     */
    void addMedicalTest(Patient patient, IMedicalTest test);
}
