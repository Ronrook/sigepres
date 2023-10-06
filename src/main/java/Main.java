import dao.UserDAO;
import dao.UserDAOImpl;
import entities.User;

public class Main {
    public static void main(String[] args) {

        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.findByDni("178635799");

        System.out.println(user.getFirstName());
    }
}
