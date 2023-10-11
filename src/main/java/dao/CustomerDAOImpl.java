package dao;

import entities.Customer;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public List<Customer> findAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            // Consulta HQL
            Query query = session.createQuery("from Customer", Customer.class);
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
    public Customer findById(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return session.find(Customer.class, id);
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Customer create(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.persist(customer);
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.merge(customer);
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return customer;
    }

    @Override
    public boolean deleteById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Customer customer = this.findById(id);
            session.remove(customer);
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
