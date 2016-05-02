package org.egdeveloper.data.dao;

import org.egdeveloper.data.entities.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository("patientDAO")
public class PatientDAO implements IPatientDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPatient(Doctor doctor, Patient patient){
        /*
        patient.setDoctor(doctor);
        Session session = sessionFactory.getCurrentSession();
        session.save(patient);
        List<Patient> patients = doctor.getPatients();
        patients.add(patient);
        doctor.setPatients(patients);
        session.saveOrUpdate(doctor);
        */
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            patient.setDoctor(doctor);
            session.save(patient);
            List<Patient> patients = doctor.getPatients();
            patients.add(patient);
            doctor.setPatients(patients);
            session.saveOrUpdate(doctor);
            tx.commit();
        }
        catch (Exception exception){
            if(tx != null)
                tx.rollback();
            throw new RuntimeException(exception);
        }
        finally {
            session.close();
        }
    }

    @Override
    public List<Patient> getPatients(){
        /*
        return sessionFactory.getCurrentSession().createQuery("from Patient").list();
        */
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List<Patient> patients = (List<Patient>) session.createQuery("from Patient").list();
            tx.commit();
            return patients;
        }
        catch (Exception exception){
            if(tx != null)
                tx.rollback();
            throw new RuntimeException(exception);
        }
        finally {
            session.close();
        }
    }

    @Override
    public Patient getPatientById(Integer id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient where id = :id");
        query.setParameter("id", id);
        return (Patient)query.uniqueResult();
    }

    @Override
    public void updatePatient(Patient patient) {
        sessionFactory.getCurrentSession().update(patient);
    }

    @Override
    public boolean checkPatientExist(Patient patient) {
        return !(patient == null || getPatientById(patient.getId()) == null);
    }

    @Override
    public void removePatient(Integer patientId){
        Patient patient = (Patient)sessionFactory.getCurrentSession().load(Patient.class, patientId);
        if(patient != null){
            Doctor doctor = patient.getDoctor();
            doctor.getPatients().remove(patient);
            sessionFactory.getCurrentSession().update(doctor);
            //patient.setDoctor(null);
            sessionFactory.getCurrentSession().delete(patient);
        }
    }

    @Override
    public void removePatientAndUpdateDoctor(Doctor doctor, Integer patientId) {
        Patient patient = (Patient)sessionFactory.getCurrentSession().load(Patient.class, patientId);
        if(patient != null){
            doctor.getPatients().remove(patient);
            sessionFactory.getCurrentSession().merge(doctor);
            patient.setDoctor(null);
            sessionFactory.getCurrentSession().delete(patient);
        }
    }

    @Override
    public void addMedicalTest(Integer patientID, MedicalTest test) {
        Patient patient = this.getPatientById(patientID);
        this.addMedicalTest(patient, test);
    }

    @Override
    public void addMedicalTest(Patient patient, MedicalTest test) {
        patient.addMedicalTest(test);
        test.setPatient(patient);
        sessionFactory.getCurrentSession().update(patient);
    }

    @Override
    public <T> List<T> retrieveMedicalTestsByType(Class<T> medicalTestClass){
        Query query = sessionFactory.getCurrentSession().createQuery("from " + medicalTestClass.getSimpleName());
        return (List<T>)query.list();
    }

    @Override
    public <T extends MedicalTest> T getMedicalTestByID(Class<T> medicalTestClazz, int testID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            T medicalTest = (T) session.get(medicalTestClazz, testID);
            tx.commit();
            return medicalTest;
        }
        catch (Exception exception){
            if(tx != null)
                tx.rollback();
            throw new RuntimeException(exception);
        }
        finally {
            session.close();
        }
    }


    @Override
    public List<MedicalTest> retrieveAllMedicalTests() {
        List<MedicalTest> medicalTests = new ArrayList<>();
        medicalTests.addAll(retrieveMedicalTestsByType(BioChemTest.class));
        medicalTests.addAll(retrieveMedicalTestsByType(CommonBloodTest.class));
        medicalTests.addAll(retrieveMedicalTestsByType(CommonUreaTest.class));
        medicalTests.addAll(retrieveMedicalTestsByType(DailyExcreationTest.class));
        medicalTests.addAll(retrieveMedicalTestsByType(StoneInVitroTest.class));
        medicalTests.addAll(retrieveMedicalTestsByType(StoneInVivoTest.class));
        medicalTests.addAll(retrieveMedicalTestsByType(TitrationTest.class));
        medicalTests.addAll(retrieveMedicalTestsByType(UreaColorTest.class));
        return medicalTests;
    }
}
