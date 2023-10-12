
import Service.CustomerService;
import Service.MedicalHistoryService;
import dao.CustomerDAOImpl;
import dao.MedicalHistoryDAO;
import dao.MedicalHistoryDAOImpl;
import entities.Appointment;
import entities.MedicalHistory;
import entities.Note;
import entities.PurchaseHistory;

import java.util.List;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {

        // Variable para instanciar los logs
         final Logger logger = Logger.getLogger(Main.class.getName());

        MedicalHistoryDAO medicalHistoryDAO = new MedicalHistoryDAOImpl();

        MedicalHistory mh = medicalHistoryDAO.findByDni("54567890");

        String fullName = mh.getCustomer().getUser().getFirstName() + " " + mh.getCustomer().getUser().getLastName();
        logger.info(fullName);

        MedicalHistoryService medicalHistoryService = new MedicalHistoryService();

        List<Note> notes = medicalHistoryService.getAllNotesForMedicalHistory("54567890");

        for (Note note : notes) {
            logger.info(note.getObservations());
        }

        CustomerService customerService = new CustomerService(new CustomerDAOImpl());
        
        List<PurchaseHistory> purchaseHistories = customerService.getPurchaseHistory(6);
        
        for (PurchaseHistory purchaseHistory : purchaseHistories) {
            logger.info("purchaseHistory.getPurchaseAmount() = " + purchaseHistory.getPurchaseAmount());
        }
        
        List<Appointment> appointments = customerService.getAppointments(6);
        
        for (Appointment appointment : appointments) {
            logger.info("appointment customer = " + appointment.getCustomer().getUser().getFirstName());
        }
        
    }
}
