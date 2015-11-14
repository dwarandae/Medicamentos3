package BusinessLogic.Services;

import DataAccess.DAO.IPurchaseDAO;
import DataAccess.DAO.IPurchaseItemDAO;
import DataAccess.Entities.Purchase;
import DataAccess.Entities.PurchaseItem;
import javax.transaction.Transactional;

public class PurchaseService {
    
    IPurchaseDAO purchaseDAO;
    IPurchaseItemDAO purchaseItemDAO;
    
    @Transactional
    public boolean savePurchase(Purchase purchase) {
        return purchaseDAO.save(purchase);
    }
    
    @Transactional
    public boolean savePurchaseItem(PurchaseItem purchaseItem) {
        return purchaseItemDAO.save(purchaseItem);
    }

    /**
     * @return the purchaseDAO
     */
    public IPurchaseDAO getPurchaseDAO() {
        return purchaseDAO;
    }

    /**
     * @param purchaseDAO the purchaseDAO to set
     */
    public void setPurchaseDAO(IPurchaseDAO purchaseDAO) {
        this.purchaseDAO = purchaseDAO;
    }

    /**
     * @return the purchaseItemDAO
     */
    public IPurchaseItemDAO getPurchaseItemDAO() {
        return purchaseItemDAO;
    }

    /**
     * @param purchaseItemDAO the purchaseItemDAO to set
     */
    public void setPurchaseItemDAO(IPurchaseItemDAO purchaseItemDAO) {
        this.purchaseItemDAO = purchaseItemDAO;
    }
    
}
