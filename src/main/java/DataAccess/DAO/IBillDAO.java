package DataAccess.DAO;

import DataAccess.Entities.Bill;
import java.util.List;

public interface IBillDAO extends IGenericDAO<Bill> {
    
    public Bill get(long id);
    public List<Bill> getAll();
    
}
