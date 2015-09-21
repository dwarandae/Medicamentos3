package BusinessLogic.Controllers;

import DataAccess.DAO.Imp.AdministratorDAO;
import DataAccess.DAO.Imp.CustomerDAO;
import DataAccess.Entities.Administrator;
import DataAccess.Entities.Customer;


public class LoginController {

    
    private CustomerDAO customerDAO;
    private AdministratorDAO adminDAO;
    
    
    public String login(String userName, String password){
        String type = "";
        customerDAO = new CustomerDAO();
        adminDAO = new AdministratorDAO();
        Customer customer = customerDAO.getByUsername(userName);
        Administrator admin = adminDAO.getAdministratorByUsername(userName);
        
        if(customer != null){
            if (customer.getPassword().equals(password)){
                type = "customer";
            }
        }
        else if (admin != null){
            if (admin.getPassword().equals(password)){
                type = "administrator";
            }
        }
        
        return type;
    }
}
