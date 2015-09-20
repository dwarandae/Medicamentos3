package DataAccess.DAO.Imp;

import DataAccess.DAO.IPurchaseDAO;
import DataAccess.Entities.Purchase;
import java.util.List;
import org.hibernate.Session;

public class PurchaseDAO extends GenericDAO<Purchase> implements IPurchaseDAO {
    
    @Override
    public Purchase get(long id) {
        Session session = getSession();
        Purchase purchase = session.get(Purchase.class, id);
        return purchase;
    }
    
    @Override
    public List<Purchase> getAll() {
        Session session = getSession();
        List<Purchase> purchase = session.createQuery("FROM Purchase").list();
        return purchase;
    }
        
}
