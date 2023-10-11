package dao;

import entities.MedicalHistory;
import entities.User;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class MedicalHistoryDAOImpl implements MedicalHistoryDAO{


    @Override
    public List<MedicalHistory> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Consulta HQL
            Query query = session.createQuery("from MedicalHistory", MedicalHistory.class);
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
    public MedicalHistory findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return  session.find(MedicalHistory.class, id);
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public MedicalHistory findByDni(String dniNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Consulta HQL con Position Parameters
            String hql = "SELECT mh FROM MedicalHistory mh " +
                    "JOIN mh.customer c " +
                    "JOIN c.user u " +
                    "WHERE u.dniNumber = :dniNumber";
            Query query = session.createQuery(hql, MedicalHistory.class);
            query.setParameter("dniNumber", dniNumber);
            return (MedicalHistory) query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }


    @Override
    public MedicalHistory create(MedicalHistory medicalHistory) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            // Iniciar una transacción
            session.beginTransaction();
            // Guardar la entidad en la base de datos
            session.persist(medicalHistory);
            // Confirmar la transacción
            session.getTransaction().commit();

        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return medicalHistory;
    }

    @Override
    public MedicalHistory update(MedicalHistory medicalHistory) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            // Actualizamos la entidad en la base de datos
            session.merge(medicalHistory);
            // Confirmar la transacción
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return medicalHistory;
    }

    @Override
    public boolean deleteById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            MedicalHistory medicalHistory = this.findById(id);
            session.remove(medicalHistory);
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
