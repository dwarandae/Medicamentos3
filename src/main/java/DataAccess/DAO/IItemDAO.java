package DataAccess.DAO;

import DataAccess.Entities.Item;
import java.util.List;

public interface IItemDAO extends IGenericDAO<Item>{
    
    public Item get(long id);
    public List<Item> getAll();
    
}
