
import dao.MedicalHistoryDAO;
import dao.MedicalHistoryDAOImpl;
import entities.MedicalHistory;


public class Main {
    public static void main(String[] args) {

        MedicalHistoryDAO medicalHistoryDAO = new MedicalHistoryDAOImpl();

        MedicalHistory mh = medicalHistoryDAO.findByDni("54567890");

        String fullName = mh.getCustomer().getUser().getFirstName() + " " + mh.getCustomer().getUser().getLastName();
        System.out.println(fullName);

        MedicalHistory mh2 = medicalHistoryDAO.findByDni("7886385799");

        if (mh2 == null){
            System.out.println("es nulo");
        }
    }
}
