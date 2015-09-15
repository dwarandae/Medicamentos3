package Test;

import DataAccess.DAO.AdministratorDAO;
import DataAccess.Entities.Administrator;

public class AdministratorDAOTest {
    
    public static void main(String... args) {

        Administrator administrator1 = new Administrator("name", "lastName", "userName", "password", "email");
        System.out.println("Starting AdministratorDAOTest");
        AdministratorDAO administratorDAO = new AdministratorDAO();
        boolean success = administratorDAO.save(administrator1);
        assert(success == true);
        
        System.out.println("Testing getAdministratorByUsername()");
        Administrator administrator = administratorDAO.getAccountByUsername("userName");
        if(administrator.equals(administrator1))
            System.out.println("Test passed");
        else
            System.out.println("Test failed");
        
        administrator = administratorDAO.getAccountByUsername("userName1");
        if(administrator == null)
            System.out.println("Test passed");
        else
            System.out.println("Test failed");
        
        System.out.println("End");

    }
    
}
