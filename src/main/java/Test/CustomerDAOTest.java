package Test;

import DataAccess.DAO.CustomerDAO;
import DataAccess.Entities.Customer;

public class CustomerDAOTest {
    
    public static void main(String... args) {

        Customer customer = new Customer("name", "lastName", "userName", "password", "email", "doc", true);
        System.out.println("En main");
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.save(customer);
        System.out.println("Fin");

    }
    
}
