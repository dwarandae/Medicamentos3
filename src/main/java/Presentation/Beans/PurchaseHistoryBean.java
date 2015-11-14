package Presentation.Beans;

import BusinessLogic.Controllers.CustomerController;
import DataAccess.Entities.Customer;
import DataAccess.Entities.Purchase;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class PurchaseHistoryBean extends ActionSupport implements SessionAware {
    
    private Customer customer;
    private Purchase purchase;
    private List<Purchase> purchases;
    private CustomerController customerController;
    
    private Map<String, Object> userSession;
    
    private final String USERNAME = "username";    
    private final String EMPTY = "empty";
    
    public String index() {
        String username = (String) userSession.get(USERNAME);
        customer = customerController.findCustomerByUsername(username);
        setPurchases(customer.getPurchases());
        
        if (customer.getPurchases() == null || customer.getPurchases().isEmpty())
            return EMPTY;
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
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

    /**
     * @return the purchases
     */
    public List<Purchase> getPurchases() {
        return purchases;
    }

    /**
     * @param purchases the purchases to set
     */
    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
    
}
