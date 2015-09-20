package DataAccess.DAO;

import DataAccess.Entities.InventoryItem;
import java.util.List;

public interface IInventoryItemDAO extends IGenericDAO<InventoryItem> {
    
    public InventoryItem get(long id);
    public List<InventoryItem> getAll();
    
}
