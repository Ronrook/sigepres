package dao;

import entities.PurchaseHistory;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class PurchaseHistoryDAOImlp implements PurchaseHistoryDAO{

    @Override
    public List<PurchaseHistory> findAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            // Consulta HQL
            Query query = session.createQuery("from PurchaseHistory", PurchaseHistory.class);
            return query.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return Collections.emptyList();
    }

    @Override
    public PurchaseHistory findById(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return session.find(PurchaseHistory.class, id);
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public PurchaseHistory create(PurchaseHistory purchaseHistory) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            // Guardar la entidad en la base de datos
            session.persist(purchaseHistory);
            // Confirmar la transacción
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return purchaseHistory;
    }

    @Override
    public PurchaseHistory update(PurchaseHistory purchaseHistory) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            // Actualizamos la entidad en la base de datos
            session.merge(purchaseHistory);
            // Confirmar la transacción
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return purchaseHistory;
    }

    @Override
    public boolean deleteById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            PurchaseHistory purchaseHistory = this.findById(id);
            // Remover la entidad en la base de datos
            session.remove(purchaseHistory);
            // Confirmar la transacción
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }finally{
            session.close();
        }
        return true;
    }
}
