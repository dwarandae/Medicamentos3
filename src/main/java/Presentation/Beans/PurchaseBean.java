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
    private List<Integer> amounts; // Weak method for tracking amounts typed by user (item order may not match)
    private List<Integer> itemIdToDelete; // Use for checking which item to delete
    
    private Map<String, Object> userSession;
    
    private final String USERNAME = "username";
    private final String PURCHASE = "purchase";
    
    private final String EMPTY = "empty";
    private final String DELETE_ITEM = "deleteItem";
    
    private static int counter = 0; // delete when no further tests are required
    
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
        if (!itemIdToDelete.isEmpty()) {
            long id = (long) itemIdToDelete.get(0);
            PurchaseItem itemToDelete;
            for (PurchaseItem purchaseItem : purchase.getPurchaseItems()) {
                if (purchaseItem.getPurchaseItemId() == id) {
                    itemToDelete = purchaseItem;
                    purchase.getPurchaseItems().remove(itemToDelete);
                    userSession.put(PURCHASE, purchase);
                    return DELETE_ITEM;
                }
            }            
        }
        
        String username = (String) userSession.get(USERNAME);
        customer = billGenerationController.getCustomerByUsername(username);        
        
        // Stock availability check
        int i = 0, stock;
        Long totalPrice = 0L;
        for (PurchaseItem purchaseItem : purchase.getPurchaseItems()) {
            totalPrice += purchaseItem.getPrice() * amounts.get(i++);
            // Check for each item to purchase if there are enough to sell
            stock = billGenerationController.getDrugById(purchaseItem.getDrug().getDrugId()).getInventoryItem().getAmount();
            if (purchaseItem.getAmount() > stock) {
                addFieldError("itemAmount" + (i-1), "No se tiene inventario suficiente de " + purchaseItem.getDrug().getBrandName());
                return INPUT;
            }
        }
        
        // After checking items' availability, proceed to modify inventory
        i = 0;
        for (PurchaseItem purchaseItem : purchase.getPurchaseItems()) {
            Drug drugToModify = billGenerationController.getDrugById(purchaseItem.getDrug().getDrugId());
            stock = drugToModify.getInventoryItem().getAmount();
            drugToModify.getInventoryItem().setAmount(stock - amounts.get(i++));
            if (!billGenerationController.saveDrug(drugToModify))
                return ERROR;
        }
        
        // Create bill and save customer's purchase
        Bill bill = new Bill(new Date(), selectedPaymentMethod);
        purchase.setBill(bill);
        purchase.setTotalPrice(totalPrice);
        customer.getPurchases().add(purchase);
        if (billGenerationController.saveCustomer(customer))
            return SUCCESS;
        return ERROR;
    }
    
    public String testIndex() {
        if (counter++ == 0) setTestData();
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
    
    private void setTestData() {
        Bill testBill = new Bill(new Date(), "efectivo");
        List<PurchaseItem> testItems = new ArrayList<>();
        testItems.add(new PurchaseItem(10, 5000, new Drug("Dolex", "Acetaminofen", "yeah", "Genfar", "100 ml", "Hazardous", "Tablet", "Oral", "sth", "none", true, "none", 10000, 50)));
        testItems.add(new PurchaseItem(300, 25000, new Drug("Dolex Forte", "Acetaminofen", "yeah", "Genfar", "100 ml", "Hazardous", "Tablet", "Oral", "sth", "none", true, "none", 20000, 100)));
        testItems.get(0).setPurchaseItemId(1L);
        testItems.get(1).setPurchaseItemId(2L);
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
    public List<Integer> getItemIdToDelete() {
        return itemIdToDelete;
    }

    /**
     * @param itemIdToDelete the itemIdToDelete to set
     */
    public void setItemIdToDelete(List<Integer> itemIdToDelete) {
        this.itemIdToDelete = itemIdToDelete;
    }
    
}
