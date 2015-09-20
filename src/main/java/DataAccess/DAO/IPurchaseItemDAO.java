package DataAccess.DAO;

import DataAccess.Entities.PurchaseItem;
import java.util.List;

public interface IPurchaseItemDAO extends IGenericDAO<PurchaseItem>{
    
    public PurchaseItem get(long id);
    public List<PurchaseItem> getAll();
    
}