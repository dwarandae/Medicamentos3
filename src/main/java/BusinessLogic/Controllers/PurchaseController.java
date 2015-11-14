package BusinessLogic.Controllers;

import BusinessLogic.Services.PurchaseService;
import DataAccess.Entities.Purchase;
import DataAccess.Entities.PurchaseItem;

public class PurchaseController {
    
    private PurchaseService purchaseService;
    
    public boolean savePurchase(Purchase purchase) {
        return getPurchaseService().savePurchase(purchase);
    }
    
    public boolean savePurchaseItem(PurchaseItem purchaseItem) {
        return purchaseService.savePurchaseItem(purchaseItem);
    }

    /**
     * @return the purchaseService
     */
    public PurchaseService getPurchaseService() {
        return purchaseService;
    }

    /**
     * @param purchaseService the purchaseService to set
     */
    public void setPurchaseService(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }
    
}
