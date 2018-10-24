package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    //TODO: put full method for custom query in here

    @Autowired
    EntityManager entityManager;


    @Transactional
    public List<Whisky> getAllWhiskyFromParticularYear(int year){
        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);

        try{

            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));
            results = cr.list();
        }

        catch (HibernateException ex){
            ex.printStackTrace();
        }

        finally {
            session.close();
        }

        return results;
    }

    @Transactional
    public  List<Whisky> getAllWhiskyFromRegion(String region){
        List <Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);

            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "d");
            cr.add(Restrictions.eq("d.region", region ));

            results = cr.list();
            return results;


        }

    @Transactional
    public  List<Whisky> getAllWhiskyByDistileryByAge(Long distilleryId, int age){
        List <Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);

        Criteria cr = session.createCriteria(Whisky.class);
        cr.createAlias("distillery", "d");
        cr.add(Restrictions.eq("d.id", distilleryId ));
        cr.add(Restrictions.eq("age", age));

        results = cr.list();
        return results;


    }


}


