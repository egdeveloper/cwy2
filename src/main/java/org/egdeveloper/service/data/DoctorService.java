package org.egdeveloper.service.data;

import org.egdeveloper.data.dao.IDoctorDAO;
import org.egdeveloper.data.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("doctorService")
@Transactional
public class DoctorService implements IDoctorService{

    @Autowired
    @Qualifier("doctorDAO")
    private IDoctorDAO doctorDAO;

    @Transactional
    public void addDoctor(Doctor doctor){
        doctorDAO.addDoctor(doctor);
    }

    @Override
    public void updateDoctorInfo(Doctor doctor) {
        doctorDAO.updateDoctorInfo(doctor);
    }

    @Transactional
    public List<Doctor> getDoctors(){
        return doctorDAO.getDoctors();
    }

    @Override
    public Doctor getDoctorByID(Integer doctorID) {
        return doctorDAO.getDoctorById(doctorID);
    }

    @Transactional
    public void removeDoctor(Integer id){
        doctorDAO.removeDoctor(id);
    }

    @Transactional
    public Doctor getDoctorByLogin(String login){
        return doctorDAO.getDoctorByLogin(login);
    }
}
