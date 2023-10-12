package dao;

import entities.EntityType;
import jakarta.persistence.PersistenceException;
import org.hibernate.Session;
import util.HibernateUtil;

public class EntityTypeDAOImpl implements EntityTypeDAO{


    @Override
    public EntityType findById(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return session.find(EntityType.class, id);
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public EntityType create(EntityType entityType) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            // Guardar la entidad en la base de datos
            session.persist(entityType);
            // Confirmar la transacción
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return entityType;
    }

    @Override
    public EntityType update(EntityType entityType) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            // Actualizamos la entidad en la base de datos
            session.merge(entityType);
            // Confirmar la transacción
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return entityType;
    }

    @Override
    public boolean deleteById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            EntityType entityType = this.findById(id);
            // Remover la entidad en la base de datos
            session.remove(entityType);
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
