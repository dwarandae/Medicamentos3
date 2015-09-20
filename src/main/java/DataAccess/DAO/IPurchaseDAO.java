package DataAccess.DAO;

import DataAccess.Entities.Purchase;
import java.util.List;

public interface IPurchaseDAO extends IGenericDAO<Purchase> {
    
    public Purchase get(long id);
    public List<Purchase> getAll();
    
}
