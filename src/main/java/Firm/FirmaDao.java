package Firm;

import com.HibernateUtil;
import com.Model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class FirmaDao {
    public boolean saveFactureIntoDataBase(Firma firma){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(firma);
            transaction.commit();
        } catch (SecurityException se){
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        }
        return true;
    }

    public List<Firma> getAllFacturyFromDataBase(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try(Session session = sessionFactory.openSession()){
            Query<Firma> query = session.createQuery("from Firma fm", Firma.class);
            List<Firma> firmas = query.list();
            return firmas;
        }
        catch (SecurityException se){
            // todo: logger
            System.err.println("nie udało się pobrać z bazy");
        }
        return new ArrayList<>();
    }
}
