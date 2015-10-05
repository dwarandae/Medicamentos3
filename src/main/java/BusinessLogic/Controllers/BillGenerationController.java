package BusinessLogic.Controllers;

import BusinessLogic.Services.BillService;
import BusinessLogic.Services.CustomerService;
import DataAccess.Entities.Bill;
import DataAccess.Entities.Customer;

public class BillGenerationController {
    
    private BillService billService;
    private CustomerService customerService;
    
    public boolean createBill(Bill bill) {
        return getBillService().saveBill(bill);
    }
    
    public Customer getCustomerByUsername(String username) {
        return customerService.findCustomerByUsername(username);
    }

    /**
     * @return the billService
     */
    public BillService getBillService() {
        return billService;
    }

    /**
     * @param billService the billService to set
     */
    public void setBillService(BillService billService) {
        this.billService = billService;
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
