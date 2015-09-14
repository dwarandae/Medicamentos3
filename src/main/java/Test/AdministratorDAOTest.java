package Test;

import DataAccess.DAO.AdministratorDAO;
import DataAccess.Entities.Administrator;

public class AdministratorDAOTest {
    
    public static void main(String... args) {

        Administrator administrator = new Administrator("name", "lastName", "userName", "password", "email");
        System.out.println("En main");
        AdministratorDAO administratorDAO = new AdministratorDAO();
        administratorDAO.save(administrator);
        System.out.println("Fin");

    }
    
}
