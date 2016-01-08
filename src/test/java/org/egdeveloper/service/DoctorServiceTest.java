package org.egdeveloper.service;

import org.egdeveloper.data.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

public class DoctorServiceTest {

    private SessionFactory factory;
    private Session session;

    @Before
    public void before(){
        Configuration config = new Configuration();
        config.addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(BioChemTest.class)
                .addAnnotatedClass(CommonBloodTest.class)
                .addAnnotatedClass(CommonUreaTest.class)
                .addAnnotatedClass(DailyExcreationTest.class)
                .addAnnotatedClass(TitrationTest.class)
                .addAnnotatedClass(UreaColorTest.class)
                .addAnnotatedClass(UreaStoneTest.class);
        config.setProperty("hibernate.dialect",
                "org.hibernate.dialect.H2Dialect");
        config.setProperty("hibernate.connection.driver_class",
                "org.h2.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:h2:mem");
        config.setProperty("hibernate.hbm2ddl.auto", "create");
        config.configure();
        ServiceRegistryBuilder builder = new ServiceRegistryBuilder();
        ServiceRegistry registry = builder.buildServiceRegistry();
        builder.applySettings(config.getProperties());
        factory = config.buildSessionFactory(registry);
        session = factory.openSession();
    }

    @Test
    public void testAddDoctor() throws Exception {

    }

    @Test
    public void testGetDoctors() throws Exception {

    }

    @Test
    public void testRemoveDoctor() throws Exception {

    }

    @Test
    public void testGetDoctorByLoginAndPassword() throws Exception {

    }

    @After
    public void after(){
        session.close();
        factory.close();
    }
}