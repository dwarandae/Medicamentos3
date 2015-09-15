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
    
    public int createCustomerAccount(String name, String lastName, String username, String password, String email, String customerId, boolean epsCustomer) {
        Customer customer = new Customer(name, lastName, username, password, email, customerId, epsCustomer);
        
        CustomerDAO customerDAO = new CustomerDAO();
        // TODO: waiting for modified CustomerDAO then delete the next two lines and uncomment the rest.
        customerDAO.save(customer);
        return 0;
        /*Customer customerToSave = customerDAO.save(customer);
        
        if (customerToSave != null) {
            return 3;
        } else if (customerDAO.findByEmail(email)) {
            return 2;
        } else if (customerDAO.findByUsername(username)) {
            return 1;
        } else {
            return 0;
        }*/
    }
    
}
