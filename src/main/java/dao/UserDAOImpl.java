package dao;


import entities.User;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List findAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Consulta HQL
            Query query = session.createQuery("from User", User.class);
            // Obtener y retornar resultado de consulta
            return query.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            // Cerrar session
            session.close();
        }
        return Collections.emptyList();
    }

    @Override
    public User findById(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Obtener y retornar resultado de consulta
            return  session.find(User.class, id);
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            // Cerrar Session
            session.close();
        }
        return null;
    }

    @Override
    public User findByDni(String dniNumber) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Consulta HQL con Position Parameters
            Query query = session.createQuery("from User where dniNumber = ?1", User.class);
            query.setParameter(1, dniNumber);

            // Obtener y retornar resultado de consulta
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            // Cerrar Session
            session.close();
        }
        return null;
    }


    @Override
    public User create(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            // Guardar el usuario en la base de datos
            session.persist(user);
            // Confirmar la transacción
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            // Cerrar Session
            session.close();
        }
        return user;
    }

    @Override
    public User update(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            // Actualizamos la entidad en la base de datos
            session.merge(user);
            // Confirmar la transacción
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return user;
    }


    @Override
    public boolean deleteById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            // Remover la entidad en la base de datos
            User user = this.findById(id);
            session.remove(user);
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
