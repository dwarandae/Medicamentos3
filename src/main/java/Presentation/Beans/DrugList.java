package Presentation.Beans;

import BusinessLogic.Controllers.CustomerController;
import BusinessLogic.Controllers.DrugsController;
import DataAccess.Entities.Customer;
import DataAccess.Entities.Drug;
import DataAccess.Entities.Purchase;
import DataAccess.Entities.PurchaseItem;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class DrugList extends ActionSupport implements SessionAware {
    
    private Purchase purchase;
    private Customer customer;
    private List<Drug> drugs;
    private long itemIdToAdd;
    private DrugsController drugsController;
    private CustomerController customerController;
    
    private Map<String, Object> userSession;
    
    private final String USERNAME = "username";
    private final String PURCHASE = "purchase";
    
    public String index() {
        // No stock means that the drug is not available atm or won't be
        drugs = new ArrayList<>();
        for (Drug drug : drugsController.findAllDrugs())
            if (drug.getInventoryItem().getAmount() > 0)
                drugs.add(drug);
        return SUCCESS;
    }
    
    public String addItemToCart() {
        customer = customerController.findCustomerByUsername((String) userSession.get(USERNAME));
        purchase = (Purchase) userSession.get(PURCHASE);
        if (purchase == null) {
            purchase = new Purchase();
            purchase.setPurchaseItems(new ArrayList<PurchaseItem>());
        }
        Drug drugToAdd = drugsController.findDrugById(itemIdToAdd);
        long price = (long) (customer.isEpsCustomer() ? drugToAdd.getPrice() : drugToAdd.getPrice() * 0.9);
        PurchaseItem itemToAdd = new PurchaseItem(1, price, drugToAdd);
        itemToAdd.setPurchaseItemId(drugToAdd.getDrugId());
        if (!purchase.getPurchaseItems().contains(itemToAdd))
            purchase.getPurchaseItems().add(itemToAdd);
        userSession.put(PURCHASE, purchase);
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
    public long getItemIdToAdd() {
        return itemIdToAdd;
    }

    /**
     * @param itemIdToAdd the itemIdToAdd to set
     */
    public void setItemIdToAdd(long itemIdToAdd) {
        this.itemIdToAdd = itemIdToAdd;
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
