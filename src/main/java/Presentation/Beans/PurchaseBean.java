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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class PurchaseBean extends ActionSupport implements SessionAware {
    
    private Purchase purchase;
    private Customer customer;
    private BillGenerationController billGenerationController;
    private String selectedPaymentMethod;
    private List<String> paymentMethods = Arrays.asList("Efectivo", "Tarjeta");
    
    private Map<String, Object> userSession;
    
    private final String USERNAME = "username";
    private final String PURCHASE = "purchase";
    
    private final String EMPTY = "empty";
    
    public String index() {
        purchase = (Purchase) userSession.get(PURCHASE);
        
        if (purchase == null || purchase.getPurchaseItems().isEmpty()) {
            return EMPTY;
        } else {
            Long totalPrice = 0L;
            for (PurchaseItem purchaseItem : purchase.getPurchaseItems())
                totalPrice += purchaseItem.getPrice() * purchaseItem.getAmount();
            purchase.setTotalPrice(totalPrice);
            return SUCCESS;
        }
    }
    
    public String doPurchase() {
        String username = (String) userSession.get(USERNAME);
        System.out.println(username);
        customer = billGenerationController.getCustomerByUsername(username);
        Bill bill = new Bill(new Date(), selectedPaymentMethod);
        purchase.setBill(bill);
        customer.getPurchases().add(purchase);
        if (billGenerationController.saveCustomer(customer))
            return SUCCESS;
        return ERROR;
    }
    
    public String deleteItem() {
        return SUCCESS;
    }
    
    public String testIndex() {
        setTestData();
        purchase = (Purchase) userSession.get(PURCHASE);
        
        if (purchase == null || purchase.getPurchaseItems().isEmpty()) {
            return EMPTY;
        } else {
            String username = (String) userSession.get(USERNAME);
            System.out.println(username);
            customer = billGenerationController.getCustomerByUsername(username);
            Long totalPrice = 0L;
            for (PurchaseItem purchaseItem : purchase.getPurchaseItems())
                totalPrice += purchaseItem.getPrice() * purchaseItem.getAmount();
            purchase.setTotalPrice(totalPrice);
            return SUCCESS;
        }
    }
    
    private void setTestData() {
        Bill testBill = new Bill(new Date(), "efectivo");
        List<PurchaseItem> testItems = new ArrayList<>();
        testItems.add(new PurchaseItem(10, 5000, new Drug("Dolex", "Acetaminofen", "yeah", "Genfar", "100 ml", "Hazardous", "Tablet", "Oral", "sth", "none", true, "none", 10000, 50)));
        testItems.add(new PurchaseItem(300, 25000, new Drug("Dolex Forte", "Acetaminofen", "yeah", "Genfar", "100 ml", "Hazardous", "Tablet", "Oral", "sth", "none", true, "none", 20000, 100)));
        Purchase testPurchase = new Purchase(10*5000L, testBill, testItems);
        userSession.put(USERNAME, "el_brayan");
        userSession.put(PURCHASE, testPurchase);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
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
     * @return the selectedPaymentMethod
     */
    public String getSelectedPaymentMethod() {
        return selectedPaymentMethod;
    }

    /**
     * @param selectedPaymentMethod the selectedPaymentMethod to set
     */
    public void setSelectedPaymentMethod(String selectedPaymentMethod) {
        this.selectedPaymentMethod = selectedPaymentMethod;
    }

    /**
     * @return the paymentMethods
     */
    public List<String> getPaymentMethods() {
        return paymentMethods;
    }

    /**
     * @param paymentMethods the paymentMethods to set
     */
    public void setPaymentMethods(List<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
    
}
