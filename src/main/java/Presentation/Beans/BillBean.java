package Presentation.Beans;

import BusinessLogic.Controllers.BillGenerationController;
import DataAccess.Entities.Bill;
import DataAccess.Entities.Customer;
import DataAccess.Entities.Drug;
import DataAccess.Entities.Purchase;
import DataAccess.Entities.PurchaseItem;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class BillBean extends ActionSupport implements SessionAware {
    
    private Purchase purchase;
    private Bill bill;
    private Customer customer;
    private BillGenerationController billGenerationController;
    
    private Map<String, Object> userSession;
    
    private final String USERNAME = "username";
    private final String PURCHASE = "purchase";
    
    public String index() {
        purchase = (Purchase) userSession.get(PURCHASE);
        String username = (String) userSession.get(USERNAME);
        customer = billGenerationController.getCustomerByUsername(username);
        bill = purchase.getBill();
        return SUCCESS;
    }
    
    public String testIndex() {
        setTestData();
        purchase = (Purchase) userSession.get(PURCHASE);
        String username = (String) userSession.get(USERNAME);
        bill = purchase.getBill();
        System.out.println(username + "\n" + bill + "\n" + purchase.getTotalPrice());
        return SUCCESS;
    }
    
    private void setTestData() {
        Customer testCustomer = new Customer("name", "last-name", "cool uh?", "pwd", "email", "1234", true);
        Bill testBill = new Bill(new Date(), "efectivo");
        List<PurchaseItem> testItems = new ArrayList<>();
        Drug testDrug = new Drug("Dolex", "Acetaminofen", "yeah", "Genfar", "100 ml", "Hazardous", "Tablet", "Oral", "sth", "none", true, "none", 10000, 50);
        testItems.add(new PurchaseItem(10, 5000, testDrug));
        Purchase testPurchase = new Purchase(10000L*50, bill, testItems);
        userSession.put(USERNAME, testCustomer.getUsername());
        userSession.put(PURCHASE, testPurchase);
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
     * @return the billGenerationController
     */
    public BillGenerationController getBillGenerationController() {
        return billGenerationController;
    }

    /**
     * @param billGenerationController the billGenerationController to set
     */
    public void setBillGenerationController(BillGenerationController billGenerationController) {
        this.billGenerationController = billGenerationController;
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
    
}
