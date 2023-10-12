package Service;

import dao.CustomerDAO;
import entities.Appointment;
import entities.PurchaseHistory;

import java.util.List;

public class CustomerService {

    CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<PurchaseHistory> getPurchaseHistory(Integer id) {
        return customerDAO.findById(id).getPurchaseHistories();
    }

    public List<Appointment> getAppointments(Integer id) {
        return customerDAO.findById(id).getAppointments();
    }
}
