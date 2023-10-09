package dao;

import entities.Attachment;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class AttachmentDAOImpl implements AttachmentDAO{
    @Override
    public List<Attachment> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Query query = session.createQuery("from Attachment", Attachment.class);
            return query.getResultList();
        }catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return Collections.emptyList();
    }

    @Override
    public Attachment findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return session.find(Attachment.class, id);
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Attachment create(Attachment attachment) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.persist(attachment);
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return attachment;
    }

    @Override
    public Attachment update(Attachment attachment) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.merge(attachment);
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return attachment;
    }

    @Override
    public boolean deleteById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Attachment attachment = this.findById(id);
            session.remove(attachment);
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
