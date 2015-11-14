package Presentation.Beans;

import BusinessLogic.Controllers.BillController;
import BusinessLogic.Controllers.CustomerController;
import BusinessLogic.Controllers.DrugsController;
import BusinessLogic.Controllers.PurchaseController;
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
    private BillController billController;
    private PurchaseController purchaseController;
    private CustomerController customerController;
    private DrugsController drugsController;
    private String selectedPaymentMethod;
    private List<String> paymentMethods = Arrays.asList("Efectivo", "Tarjeta");
    private List<Integer> amounts; // Weak method for tracking amounts typed by user (item order may not match)
    private long itemIdToDelete = -1L; // Use for checking which item to delete
    
    private Map<String, Object> userSession;
    
    private final String USERNAME = "username";
    private final String PURCHASE = "purchase";
    
    private final String EMPTY = "empty";
    private final String DELETE_ITEM = "deleteItem";
    
    public String index() {      
        purchase = (Purchase) userSession.get(PURCHASE);
        
        if (purchase == null || purchase.getPurchaseItems().isEmpty()) {
            return EMPTY;
        } else {
            amounts = new ArrayList<>();
            Long totalPrice = 0L;
            for (PurchaseItem purchaseItem : purchase.getPurchaseItems()) {
                totalPrice += purchaseItem.getPrice() * purchaseItem.getAmount();
                amounts.add(purchaseItem.getAmount());
            }
            purchase.setTotalPrice(totalPrice);
            return SUCCESS;
        }
    }
    
    public String doPurchase() {
        purchase = (Purchase) userSession.get(PURCHASE);
        
        // Delete an item from the shopping cart
        if (itemIdToDelete != -1L) {
            for (PurchaseItem purchaseItem : purchase.getPurchaseItems()) {
                if (purchaseItem.getPurchaseItemId() == itemIdToDelete) {
                    purchase.getPurchaseItems().remove(purchaseItem);
                    userSession.put(PURCHASE, purchase);
                    return DELETE_ITEM;
                }
            }            
        }
        
        String username = (String) userSession.get(USERNAME);
        customer = customerController.findCustomerByUsername(username);        
        
        // Stock availability check
        int i = 0, stock;
        Long totalPrice = 0L;
        for (PurchaseItem purchaseItem : purchase.getPurchaseItems()) {
            totalPrice += purchaseItem.getPrice() * amounts.get(i++);
            // Check for each item to purchase if there are enough to sell
            stock = drugsController.findDrugById(purchaseItem.getDrug().getDrugId()).getInventoryItem().getAmount();
            if (purchaseItem.getAmount() > stock) {
                addFieldError("itemAmount" + (i-1), "No se tiene inventario suficiente de " + purchaseItem.getDrug().getBrandName());
                return INPUT;
            }
        }
        
        // After checking items' availability, proceed to modify inventory
        i = 0;
        for (PurchaseItem purchaseItem : purchase.getPurchaseItems()) {
            Drug drugToModify = drugsController.findDrugById(purchaseItem.getDrug().getDrugId());
            stock = drugToModify.getInventoryItem().getAmount();
            drugToModify.getInventoryItem().setAmount(stock - amounts.get(i++));
            purchaseItem.setPurchaseItemId(null);
            if (!drugsController.saveDrug(drugToModify) || !purchaseController.savePurchaseItem(purchaseItem))
                return ERROR;
        }
        
        // Create bill and save customer's purchase
        Bill bill = new Bill(new Date(), selectedPaymentMethod);
        if (!billController.saveBill(bill))
            return ERROR;
        
        purchase.setBill(bill);
        purchase.setTotalPrice(totalPrice);
        if (!purchaseController.savePurchase(purchase))
            return ERROR;
        
        customer.getPurchases().add(purchase);
        if (!customerController.saveCustomer(customer))
            return ERROR;
        
        return SUCCESS;
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

    /**
     * @return the amounts
     */
    public List<Integer> getAmounts() {
        return amounts;
    }

    /**
     * @param amounts the amounts to set
     */
    public void setAmounts(List<Integer> amounts) {
        this.amounts = amounts;
    }

    /**
     * @return the itemIdToDelete
     */
    public long getItemIdToDelete() {
        return itemIdToDelete;
    }

    /**
     * @param itemIdToDelete the itemIdToDelete to set
     */
    public void setItemIdToDelete(long itemIdToDelete) {
        this.itemIdToDelete = itemIdToDelete;
    }

    /**
     * @return the purchaseController
     */
    public PurchaseController getPurchaseController() {
        return purchaseController;
    }

    /**
     * @param purchaseController the purchaseController to set
     */
    public void setPurchaseController(PurchaseController purchaseController) {
        this.purchaseController = purchaseController;
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
     * @return the drugsController
     */
    public DrugsController getDrugsController() {
        return drugsController;
    }

    /**
     * @param drugsController the drugsController to set
     */
    public void setDrugsController(DrugsController drugsController) {
        this.drugsController = drugsController;
    }
    
}
