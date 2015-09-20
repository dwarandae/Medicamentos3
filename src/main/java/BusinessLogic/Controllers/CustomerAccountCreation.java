/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controllers;

import DataAccess.DAO.Imp.CustomerDAO;
import DataAccess.Entities.Customer;

/**
 *
 * @author omdej
 */
public class CustomerAccountCreation {
    
    public int createCustomerAccount(String name, String lastName, String username, String password, String email, String customerId, boolean epsCustomer) {
        Customer customer = new Customer(name, lastName, username, password, email, customerId, epsCustomer);
        
        CustomerDAO customerDAO = new CustomerDAO();
        
        if (customerDAO.isUsernameInUse(username)) {
            return 1;
        } else if (customerDAO.isEmailInUse(email)) {
            return 2;
        } else if (!customerDAO.save(customer)) {
            return 3;
        } else {
            return 0;
        }
    }
    
}
