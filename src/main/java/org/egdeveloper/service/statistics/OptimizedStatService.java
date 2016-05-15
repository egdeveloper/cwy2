package org.egdeveloper.service.statistics;

import org.apache.commons.lang3.NotImplementedException;
import org.egdeveloper.data.entities.MedicalTest;
import org.egdeveloper.data.entities.customTypes.TreatmentNumber;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Developer: Roman Yarnykh (egdeveloper@mail.ru)
 * Creation-Date: 14.05.2016
 * Project: LaksmiMed
 * Package: org.egdeveloper.service.statistics
 */

@Service("optimizedStatService")
@Transactional
public class OptimizedStatService implements IStatService {

    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sessionFactory;

    // TODO: not implemented beforeTreatmentStat()
    @Override
    public Map<Object, Object> beforeTreatmentStat() {
        throw new NotImplementedException("Not implemented method!");
    }

    // TODO: not implemented indicatorsDynamics()
    @Override
    public Map<Object, Object> indicatorsDynamics(Integer patientId) throws IllegalAccessException, InvocationTargetException {
        throw new NotImplementedException("Not implemented method!");
    }

    // TODO: not implemented indicatorDeviationsForStoneTypesStat()
    @Override
    public Map<Object, Object> indicatorDeviationsForStoneTypesStat(TreatmentNumber treatmentNumber) {
        throw new NotImplementedException("Not implemented method!");
    }

    // TODO: not implemented indicatorDeviationsForStoneTypesStat()
    @Override
    public <T extends MedicalTest> Map<Object, Object> indicatorDeviationsForStoneTypesStat(Class<T> testClazz, TreatmentNumber treatmentNumber) throws IllegalAccessException {
        throw new NotImplementedException("Not implemented method!");
    }

    // TODO: not implemented indicatorDeviations()
    @Override
    public Map<Object, Object> indicatorDeviations(TreatmentNumber treatmentNumber) throws IllegalAccessException {
        throw new NotImplementedException("Not implemented method!");
    }

    // TODO: not implemented indicatorDeviations()
    @Override
    public <T extends MedicalTest> Map<String, Map<String, Integer>> indicatorDeviations(Class<T> testClass, TreatmentNumber treatmentNumber) throws IllegalAccessException {
        throw new NotImplementedException("Not implemented method!");
    }

    // TODO: not implemented stoneComponentsStat()
    @Override
    public Map stoneComponentsStat(TreatmentNumber treatmentNumber) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Query query = session.createSQLQuery("CALL collect_StCsDevsStat(:treatment_number)")
                    .setParameter("treatment_number", treatmentNumber.toString());
            Map stCsDevsStat_ = new HashMap<>();
            for(Object row_ : query.list()){

            }
            tx.commit();
            return stCsDevsStat_;
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
}
