/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controllers;


import DataAccess.DAO.AdministratorDAO;
import DataAccess.DAO.CustomerDAO;
import DataAccess.Entities.Administrator;
import DataAccess.Entities.Customer;

/**
 *
 * @author cegard
 */
public class LoginController {
    
    
    private CustomerDAO customerDAO;
    private AdministratorDAO adminDAO;
    
    public String login(String userName, String password, String customerURL, 
            String adminURL){
        customerDAO = new CustomerDAO();
        adminDAO = new AdministratorDAO();
        String appropiatedURL = "";
        Customer customer = customerDAO.getCustomerByUsername(userName);
        Administrator admin = adminDAO.getAdministratorByUsername(userName);
        
        if (customer != null){
            if (customer.getPassword() == password){
                appropiatedURL = customerURL;
            }
            else{
                appropiatedURL = "";
            }
        }
        else if (admin != null){
            if (admin.getPassword() == password){
                appropiatedURL = adminURL;
            } 
            else {
                appropiatedURL = "";
            }
        }
        
        return appropiatedURL;
    }
}
