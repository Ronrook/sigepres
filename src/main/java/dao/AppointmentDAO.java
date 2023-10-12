package dao;

import entities.Appointment;

import java.time.LocalDate;
import java.util.List;

/**
 * Data Access Object
 *
 * Métodos CRUD - Create Retrieve Update Delete
 */
public interface AppointmentDAO {


    /**
     * Busca un Appointment por su id
     * Utiliza métodos de Hibernate
     * @return Appointment
     */
    Appointment findById(Integer id);

    /**
     * Busca una lista de Appointments que estén entre las fechas startDate y endDate
     * Utiliza métodos de Hibernate
     * @return Appointments
     */
    List<Appointment> getAppointmentsBetweenDates(LocalDate startDate, LocalDate endDate);


    /**
     * Busca una lista de Appointments de un cliente  entre dos fechas
     * Utiliza métodos de Hibernate
     * @return Appointments
     */
    public List<Appointment> getAppointmentsByCustomerAndDates(Integer customerId, LocalDate startDate, LocalDate endDate);

    /**
     * Busca una lista de Appointment segun dos fechas
     * Utiliza métodos de Hibernate
     * @return Appointments
     */
    public List<Appointment> getAppointmentsByEmployeeAndDates(Integer employeeId, LocalDate startDate, LocalDate endDate);

    public List<Appointment> getAppointmentsByCustomer(Integer customerId);

    /**
     * Inserta un nuevo registro en la tabla appointments
     * @param appointment
     * @return
     */
    Appointment create(Appointment appointment);

    /**
     * Actualiza un registro existente en la tabla appointments
     * @param appointment
     * @return
     */
    Appointment update(Appointment appointment);

    /**
     * Borra un cita de la tabla appointments
     * @param id
     * @return
     */
    boolean deleteById(Integer id);
}
