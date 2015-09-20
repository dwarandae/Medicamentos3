package DataAccess.DAO.Imp;

import DataAccess.DAO.IPurchaseItemDAO;
import DataAccess.Entities.PurchaseItem;
import java.util.List;
import org.hibernate.Session;

public class PurchaseItemDAO extends GenericDAO<PurchaseItem> implements IPurchaseItemDAO{
    
    @Override
    public PurchaseItem get(long id) {
        Session session = getSession();
        PurchaseItem purchaseItem = session.get(PurchaseItem.class, id);
        return purchaseItem;
    }
    
    @Override
    public List<PurchaseItem> getAll() {
        Session session = getSession();
        List<PurchaseItem> purchaseItems = session.createQuery("FROM PurchaseItem").list();
        return purchaseItems;
    }
    
}
