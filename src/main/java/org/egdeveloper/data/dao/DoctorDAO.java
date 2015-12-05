package org.egdeveloper.data.dao;

import org.egdeveloper.data.entities.Doctor;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by egdeveloper on 18.11.15.
 */

@Repository("doctorDAO")
public class DoctorDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addDoctor(Doctor doctor){
        sessionFactory.getCurrentSession().save(doctor);
    }

    public List<Doctor> getDoctors(){
        return sessionFactory.getCurrentSession().createQuery("from Doctor").list();
    }

    public void removeDoctor(Integer id){
        Doctor doctor = (Doctor)sessionFactory.getCurrentSession().load(Doctor.class, id);
        if(doctor != null){
            sessionFactory.getCurrentSession().delete(doctor);
        }
    }
    public Doctor getDoctorByLoginAndPassword(String login, String password){
        Query query = sessionFactory.getCurrentSession().createQuery("from Doctor where login = :login and password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        List doctorList = query.list();
        return doctorList != null ? null : (Doctor)doctorList.get(0);
    }
}
