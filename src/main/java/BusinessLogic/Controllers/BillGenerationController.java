package BusinessLogic.Controllers;

import BusinessLogic.Services.CustomerService;
import BusinessLogic.Services.DrugService;
import DataAccess.Entities.Customer;
import DataAccess.Entities.Drug;

public class BillGenerationController {
    
    private CustomerService customerService;
    private DrugService drugService;
    
    public Customer getCustomerByUsername(String username) {
        return customerService.findCustomerByUsername(username);
    }
    
    public boolean saveCustomer(Customer customer) {
        return customerService.saveCustomer(customer);
    }
    
    public Drug getDrugById(long id) {
        return drugService.findDrugById(id);
    }
    
    public boolean saveDrug(Drug drug) {
        return drugService.saveDrug(drug);
    }

    /**
     * @return the customerService
     */
    public CustomerService getCustomerService() {
        return customerService;
    }

    /**
     * @param customerService the customerService to set
     */
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    
}
