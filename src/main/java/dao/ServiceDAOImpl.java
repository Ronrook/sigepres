package dao;

import entities.Service;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO {
    @Override
    public List findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // Consulta HQL
            Query query = session.createQuery("from Service", Service.class);
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
    public Service findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.find(Service.class, id);
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Service create(Service service) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // Iniciar una transacción
            session.beginTransaction();
            // Guardar el servicio en la base de datos
            session.persist(service);
            // Confirmar la transacción
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return service;
    }

    @Override
    public Service update(Service service) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(service);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return service;
    }

    @Override
    public boolean deleteById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Service service = this.findById(id);
            session.remove(service);
            session.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}
