package org.egdeveloper.service;

import org.egdeveloper.data.dao.DoctorDAO;
import org.egdeveloper.data.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by egdeveloper on 18.11.15.
 */
@Service("doctorService")
@Transactional
public class DoctorService {

    @Autowired
    DoctorDAO doctorDAO;

    @Transactional
    public void addDoctor(Doctor doctor){
        doctorDAO.addDoctor(doctor);
    }

    @Transactional
    public List<Doctor> getDoctors(){
        return doctorDAO.getDoctors();
    }

    @Transactional
    public void removeDoctor(Integer id){
        doctorDAO.removeDoctor(id);
    }

    @Transactional
    public Doctor getDoctorByLoginAndPassword(String login, String password){
        return doctorDAO.getDoctorByLoginAndPassword(login, password);
    }
}
