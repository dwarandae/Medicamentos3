/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controllers;

import DataAccess.Entities.Account;
import DataAccess.Entities.Administrator;
import DataAccess.Entities.Customer;

/**
 *
 * @author cegard
 */
public class LoginController {
    
    public String login(String userName, String password, String customerURL, 
            String administratorURL){
        Account account = null; // call getAccount
        Account accountResult = determineAccountType(account);
        String appropiatedURL = "";
        
        if (accountResult != null){
            
            if (accountResult instanceof Customer){
            appropiatedURL = customerURL;
            } 

            else if (accountResult instanceof Administrator) {
                appropiatedURL = administratorURL;
            }
        }
        
        return appropiatedURL;
    }
    
    public Account determineAccountType(Account account){
        
        if (account instanceof Customer){
            Customer customer = null; //call getCustomerByLoQueSea
            return customer;
        } else if (account instanceof Administrator){
            Administrator administrator = null; //call getAdministratorByLoQueSea
            return administrator;
        } else{
            return null;
        }
    }
}
