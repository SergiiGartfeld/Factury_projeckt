package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FacturaDao {
    public boolean saveFactureIntoDataBase(Model model){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(model);
            transaction.commit();
        } catch (SecurityException se){
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        }
        return true;
    }

    public List<Model> getAllFacturyFromDataBase(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()){
            Query<Model> query = session.createQuery("from Model st", Model.class);
            List<Model> models = query.list();
            return models;
        }
        catch (SecurityException se){
            // todo: logger
            System.err.println("nie udało się pobrać z bazy");
        }
        return new ArrayList<>();
    }
}
