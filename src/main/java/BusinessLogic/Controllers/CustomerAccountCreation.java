/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controllers;

import DataAccess.DAO.CustomerDAO;
import DataAccess.Entities.Customer;

/**
 *
 * @author omdej
 */
public class CustomerAccountCreation {
    
    public boolean createCustomerAccount(String name, String lastName, String username, String password, String email, boolean epsCustomer) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setLastName(lastName);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setEmail(email);
        customer.setEpsCustomer(epsCustomer);
        
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customerToSave = customerDAO.save(customer);
        
        if (customerToSave != null) {
            return true;
        } else {
            return false;
        }
    }
    
}
