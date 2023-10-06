import dao.AppointmentDAO;

import dao.AppointmentDAOImpl;
import entities.Appointment;


import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

        //List<Appointment> appointments = appointmentDAO.getAppointmentsByEmployeeAndDates(2, LocalDate.of(2023, 7, 8), LocalDate.of(2023, 10, 8));

        List<Appointment> appointments = appointmentDAO.getAppointmentsByCustomerAndDates(8, LocalDate.of(2023, 7, 8), LocalDate.of(2023, 10, 8));

        for (Appointment appointment : appointments) {
            System.out.println(appointment.getAppointmentDatetime());
        }

    }
}
