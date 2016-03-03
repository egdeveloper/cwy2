package org.egdeveloper.data.dao;

import org.egdeveloper.data.entities.Doctor;

import java.util.List;


/** Common interface of DAO for manipulating with doctor's information data
 * @author Yarnykh Roman egdeveloper@mail.ru
 * @version 1.0
 * @since 05.01.2016 (5th January 2016)
 * @see org.egdeveloper.data.dao.DoctorDAO
 */
public interface IDoctorDAO {

    /**
     * Add new doctor's record in database
     * @param doctor new doctor's record
     */
    void addDoctor(Doctor doctor);

    /**
     * Update existing doctor's record in database
     * @param doctor existing doctor's entry
     */
    void updateDoctorInfo(Doctor doctor);

    /**
     * Get all doctor's records
     * @return list of existing doctor's records from local database
     */
    List<Doctor> getDoctors();

    /**
     * Get existing doctor's record by it's login and password
     * @param login login
     * @param password password
     * @return existing doctor's record
     */
    Doctor getDoctorByLoginAndPassword(String login, String password);

    /**
     * Get doctor's record from local database
     * @param id id of existing doctor's record
     * @return existing doctor's record
     */
    Doctor getDoctorById(Integer id);

    /**
     * Edit doctor's record in database
     * @param doctor edited doctor's record
     */
    void editDoctorInfo(Doctor doctor);

    /**
     * Remove existing doctor's record
     * @param id id of existing doctor's record
     */
    void removeDoctor(Integer id);
}
