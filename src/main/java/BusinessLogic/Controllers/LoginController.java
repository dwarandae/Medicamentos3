/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controllers;

import DataAccess.DAO.AdministratorDAO;
import DataAccess.DAO.CustomerDAO;

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
        
        if (customerDAO.getCustomerByUsername(userName) != null){
            appropiatedURL = customerURL;
        }
        else if (adminDAO.getAdministratorByUsername(userName) != null){
            appropiatedURL = adminURL;
        }
        
        return appropiatedURL;
    }
}
