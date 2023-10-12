package dao;

import entities.Note;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class NoteDAOImpl implements NoteDAO{

    @Override
    public List<Note> findAll() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try{
            // Consulta HQL
            Query query = session.createQuery("from Note", Note.class);
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
    public Note findById(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return session.find(Note.class, id);
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Note create(Note note) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            // Guardar la entidad en la base de datos
            session.persist(note);
            // Confirmar la transacción
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return note;
    }

    @Override
    public Note update(Note note) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            // Actualizamos la entidad en la base de datos
            session.merge(note);
            // Confirmar la transacción
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return note;
    }

    @Override
    public boolean deleteById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            Note note = this.findById(id);
            // Remover la entidad en la base de datos
            session.remove(note);
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
