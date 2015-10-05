package BusinessLogic.Controllers;

import BusinessLogic.Services.CustomerService;
import DataAccess.Entities.Customer;

public class CustomerCreationController {
    
    CustomerService customerService;
    
    public boolean createCustomer(Customer customer) {
        return customerService.saveCustomer(customer);
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
