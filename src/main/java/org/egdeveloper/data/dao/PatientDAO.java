package org.egdeveloper.data.dao;

import org.egdeveloper.data.entities.*;
import org.hibernate.Query;
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
    public Patient getPatientById(Integer id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient where id = :id");
        query.setParameter("id", id);
        return (Patient)query.uniqueResult();
    }

    @Override
    public void editPatientInfo(Patient patient) {
        sessionFactory.getCurrentSession().update(patient);
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
        if(test instanceof BioChemTest){
            patient.getBioChemTests().add((BioChemTest) test);
        }
        else if(test instanceof CommonBloodTest){
            patient.getCommonBloodTests().add((CommonBloodTest) test);
        }
        else if(test instanceof CommonUreaTest){
            patient.getCommonUreaTests().add((CommonUreaTest) test);
        }
        else if(test instanceof DailyExcreationTest){
            patient.getDailyExcreationTests().add((DailyExcreationTest) test);
        }
        else if(test instanceof TitrationTest){
            patient.getTitrationTests().add((TitrationTest) test);
        }
        else if(test instanceof UreaColorTest){
            patient.getUreaColorTests().add((UreaColorTest) test);
        }
        else if(test instanceof UreaStoneTest){
            patient.getUreaStoneTests().add((UreaStoneTest) test);
        }
        sessionFactory.getCurrentSession().update(patient);
    }
}
