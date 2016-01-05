package org.egdeveloper.data.dao;

import org.egdeveloper.data.entities.Doctor;
import java.util.List;


public interface IDoctorDAO {
    void addDoctor(Doctor doctor);
    List<Doctor> getDoctors();
    void removeDoctor(Integer id);
    Doctor getDoctorByLoginAndPassword(String login, String password);
}
