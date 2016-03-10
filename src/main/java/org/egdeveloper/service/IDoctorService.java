package org.egdeveloper.service;


import org.egdeveloper.data.entities.Doctor;

import java.util.List;

public interface IDoctorService {
    void addDoctor(Doctor doctor);
    void updateDoctorInfo(Doctor doctor);
    List<Doctor> getDoctors();
    Doctor getDoctorByID(Integer doctorId);
    void removeDoctor(Integer id);
    Doctor getDoctorByLoginAndPassword(String login, String password);
}
