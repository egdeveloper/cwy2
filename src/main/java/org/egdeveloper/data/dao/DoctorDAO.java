package org.egdeveloper.data.dao;

import org.egdeveloper.data.entities.Doctor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("doctorDAO")
public class DoctorDAO implements IDoctorDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addDoctor(Doctor doctor){
        sessionFactory.getCurrentSession().save(doctor);
    }

    @Override
    public void updateDoctorInfo(Doctor doctor) {
        sessionFactory.getCurrentSession().update(doctor);
    }

    @Override
    public List<Doctor> getDoctors(){
        return sessionFactory.getCurrentSession().createQuery("from Doctor").list();
    }

    @Override
    public Doctor getDoctorByLoginAndPassword(String login, String password){
        Query query = sessionFactory.getCurrentSession().createQuery("from Doctor where login = :login and password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        List doctorList = query.list();
        if(doctorList == null || doctorList.size() <= 0)
            return null;
        else
            return (Doctor)doctorList.get(0);
    }

    @Override
    public Doctor getDoctorById(Integer id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Doctor where id = :id");
        query.setParameter("id", id);
        return (Doctor)query.uniqueResult();
    }

    @Override
    public void editDoctorInfo(Doctor doctor){
        Session session = sessionFactory.getCurrentSession();
        Doctor currentDoctorInfo = (Doctor)session.get(Doctor.class, doctor.getId());
        currentDoctorInfo.setFullName(doctor.getFullName());
        currentDoctorInfo.setLogin(doctor.getLogin());
        currentDoctorInfo.setPassword(doctor.getPassword());
        currentDoctorInfo.setPhoneNumber(doctor.getPhoneNumber());
        currentDoctorInfo.setEmail(doctor.getEmail());
        currentDoctorInfo.setJobPost(doctor.getJobPost());
        currentDoctorInfo.setJobPlace(doctor.getJobPlace());
        session.save(currentDoctorInfo);
    }

    @Override
    public void removeDoctor(Integer id){
        Doctor doctor = (Doctor)sessionFactory.getCurrentSession().load(Doctor.class, id);
        if(doctor != null){
            sessionFactory.getCurrentSession().delete(doctor);
        }
    }
}
