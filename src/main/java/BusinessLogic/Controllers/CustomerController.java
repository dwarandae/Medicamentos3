package BusinessLogic.Controllers;

import BusinessLogic.Services.CustomerService;
import BusinessLogic.Services.LDAPOperationsService;
import DataAccess.Entities.Customer;

public class CustomerController {
    
    private CustomerService customerService;
    private LDAPOperationsService ldapOperationsService;
    
    public boolean saveCustomer(Customer customer) {
        return customerService.saveCustomer(customer);
    }
    
    public Customer findCustomerByUsername(String username) {
        return customerService.findCustomerByUsername(username);
    }
    
    public boolean isUsernameInvalid(String username) {
        return customerService.isUsernameInUse(username);
    }
    
    public boolean isEmailInvalid(String email) {
        return customerService.isEmailInUse(email);
    }
    
    public int createLDAPUser(String username, String password, String name, String lastName) {
        return ldapOperationsService.createAccount(username, password, name, lastName);
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }   

    /**
     * @return the ldapOperationsService
     */
    public LDAPOperationsService getLdapOperationsService() {
        return ldapOperationsService;
    }

    /**
     * @param ldapOperationsService the ldapOperationsService to set
     */
    public void setLdapOperationsService(LDAPOperationsService ldapOperationsService) {
        this.ldapOperationsService = ldapOperationsService;
    }
    
}
