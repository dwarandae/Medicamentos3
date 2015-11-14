package Presentation.Beans;

import BusinessLogic.Controllers.BillController;
import BusinessLogic.Controllers.CustomerController;
import DataAccess.Entities.Bill;
import DataAccess.Entities.Customer;
import DataAccess.Entities.Purchase;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class BillBean extends ActionSupport implements SessionAware {
    
    private Purchase purchase;
    private Bill bill;
    private Customer customer;
    private BillController billController;
    private CustomerController customerController;
    
    private Map<String, Object> userSession;
    
    private final String USERNAME = "username";
    private final String PURCHASE = "purchase";
    
    public String index() {
        purchase = (Purchase) userSession.get(PURCHASE);
        String username = (String) userSession.get(USERNAME);
        customer = customerController.findCustomerByUsername(username);
        bill = purchase.getBill();
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }

    /**
     * @return the bill
     */
    public Bill getBill() {
        return bill;
    }

    /**
     * @param bill the bill to set
     */
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    /**
     * @return the billController
     */
    public BillController getBillController() {
        return billController;
    }

    /**
     * @param billController the billController to set
     */
    public void setBillController(BillController billController) {
        this.billController = billController;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the purchase
     */
    public Purchase getPurchase() {
        return purchase;
    }

    /**
     * @param purchase the purchase to set
     */
    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    /**
     * @return the customerController
     */
    public CustomerController getCustomerController() {
        return customerController;
    }

    /**
     * @param customerController the customerController to set
     */
    public void setCustomerController(CustomerController customerController) {
        this.customerController = customerController;
    }
    
}
