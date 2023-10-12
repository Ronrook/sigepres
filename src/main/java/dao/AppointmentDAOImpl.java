package dao;

import entities.Appointment;
import entities.User;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO{

    @Override
    public Appointment findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return  session.find(Appointment.class, id);
        } catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Appointment> getAppointmentsBetweenDates(LocalDate startDate, LocalDate endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // Consulta HQL
            String hql = "FROM Appointment WHERE appointmentDatetime BETWEEN :startDate AND :endDate";
            Query query = session.createQuery(hql, Appointment.class);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);

            return query.getResultList();
        } catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return Collections.emptyList();
    }

    public List<Appointment> getAppointmentsByCustomerAndDates(Integer customerId, LocalDate startDate, LocalDate endDate){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // Consulta HQL
            String hql = "FROM Appointment WHERE customer.userId = :customerId AND appointmentDatetime BETWEEN :startDate AND :endDate";
            Query query = session.createQuery(hql, Appointment.class);
            query.setParameter("customerId", customerId);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            return query.getResultList();
        } catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return Collections.emptyList();
    }

    @Override
    public List<Appointment> getAppointmentsByEmployeeAndDates(Integer employeeId, LocalDate startDate, LocalDate endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // Consulta HQL
            String hql = "FROM Appointment WHERE employee.userId = :employeeId AND appointmentDatetime BETWEEN :startDate AND :endDate";
            Query query = session.createQuery(hql, Appointment.class);
            query.setParameter("employeeId", employeeId);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            return query.getResultList();
        } catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return Collections.emptyList();
    }

    public List<Appointment> getAppointmentsByCustomer(Integer customerId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // Consulta HQL
            String hql = "FROM Appointment WHERE customer.userId = :customerId";
            Query query = session.createQuery(hql, Appointment.class);
            query.setParameter("customerId", customerId);
            return query.getResultList();
        } catch (PersistenceException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return Collections.emptyList();
    }

    @Override
    public Appointment create(Appointment appointment) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            // Guardar la entidad en la base de datos
            session.persist(appointment);
            // Confirmar la transacción
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return appointment;
    }

    @Override
    public Appointment update(Appointment appointment) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            // Actualizamos la entidad en la base de datos
            session.merge(appointment);
            // Confirmar la transacción
            session.getTransaction().commit();
        }catch (PersistenceException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return appointment;
    }

    @Override
    public boolean deleteById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // Iniciar una transacción
            session.beginTransaction();
            Appointment appointment = this.findById(id);
            // Remover la entidad en la base de datos
            session.remove(appointment);
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
