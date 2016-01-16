package org.egdeveloper.data.dao;

import org.egdeveloper.data.entities.Doctor;
import org.egdeveloper.data.entities.IMedicalTest;
import org.egdeveloper.data.entities.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Repository("patientDAO")
public class PatientDAO implements IPatientDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPatient(Doctor doctor, Patient patient){
        Session session = sessionFactory.getCurrentSession();
        session.save(patient);
        Set<Patient> patients = doctor.getPatients();
        patients.add(patient);
        doctor.setPatients(patients);
        session.saveOrUpdate(doctor);
    }

    @Override
    public List<Patient> getPatients(){
        return sessionFactory.getCurrentSession().createQuery("from Patient").list();
    }

    @Override
    public void editPatientInfo(Patient patient) {
        sessionFactory.getCurrentSession().saveOrUpdate(patient);
    }

    @Override
    public void removePatient(Integer id){
        Patient patient = (Patient)sessionFactory.getCurrentSession().load(Patient.class, id);
        if(patient != null){
            sessionFactory.getCurrentSession().delete(patient);
        }
    }

    @Override
    public void addMedicalTest(Patient patient, IMedicalTest test) {

    }
}
