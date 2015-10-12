package Presentation.Beans;

import BusinessLogic.Controllers.DrugsController;
import DataAccess.Entities.Bill;
import DataAccess.Entities.Customer;
import DataAccess.Entities.Drug;
import DataAccess.Entities.Purchase;
import DataAccess.Entities.PurchaseItem;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class DrugList extends ActionSupport implements SessionAware {
    
    private Purchase purchase;
    private Customer customer;
    private List<Drug> drugs;
    private List<Integer> itemIdToAdd;
    private DrugsController drugsController;
    
    private Map<String, Object> userSession;
    
    private final String USERNAME = "username";
    private final String PURCHASE = "purchase";
    
    private static int counter = 0; // delete when no further tests are required
    
    public String index() {
        //if(counter++ == 0) setTestData();
        drugs = drugsController.findAllDrugs();
        return SUCCESS;
    }
    
    public String addItemToCart() {
        customer = (Customer) userSession.get(USERNAME);
        purchase = (Purchase) userSession.get(PURCHASE);        
        long id = itemIdToAdd.get(0);
        Drug drugToAdd = drugsController.findDrugById(id);
        long price = (long) (customer.isEpsCustomer() ? drugToAdd.getPrice() : drugToAdd.getPrice() * 0.9);
        PurchaseItem itemToAdd = new PurchaseItem(1, price, drugToAdd);
        purchase.getPurchaseItems().add(itemToAdd);
        userSession.put(PURCHASE, purchase);
        return SUCCESS;
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
     * @return the drugs
     */
    public List<Drug> getDrugs() {
        return drugs;
    }

    /**
     * @param drugs the drugs to set
     */
    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
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

    /**
     * @return the itemIdToAdd
     */
    public List<Integer> getItemIdToAdd() {
        return itemIdToAdd;
    }

    /**
     * @param itemIdToAdd the itemIdToAdd to set
     */
    public void setItemIdToAdd(List<Integer> itemIdToAdd) {
        this.itemIdToAdd = itemIdToAdd;
    }
    
}
