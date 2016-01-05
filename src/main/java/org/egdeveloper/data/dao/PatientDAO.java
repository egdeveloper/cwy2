package org.egdeveloper.data.dao;

import org.egdeveloper.data.entities.Patient;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository("patientDAO")
public class PatientDAO implements IPatientDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void addPatient(Patient patient){
        sessionFactory.getCurrentSession().save(patient);
    }

    public List<Patient> getPatients(){
        return sessionFactory.getCurrentSession().createQuery("from PATIENT").list();
    }

    public void removePatient(Integer id){
        Patient patient = (Patient)sessionFactory.getCurrentSession().load(Patient.class, id);
        if(patient != null){
            sessionFactory.getCurrentSession().delete(patient);
        }
    }

}
