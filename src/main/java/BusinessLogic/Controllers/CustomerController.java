package BusinessLogic.Controllers;

import BusinessLogic.Services.CustomerService;
import DataAccess.Entities.Customer;

public class CustomerController {
    
    CustomerService customerService;
    
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

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }   
    
}
