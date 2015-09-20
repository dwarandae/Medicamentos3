package DataAccess.DAO.Imp;

import DataAccess.DAO.IInventoryItemDAO;
import DataAccess.Entities.InventoryItem;
import java.util.List;
import org.hibernate.Session;

public class InventoryItemDAO extends GenericDAO<InventoryItem> implements IInventoryItemDAO {
    
    @Override
    public InventoryItem get(long id) {
        Session session = getSession();
        InventoryItem inventoryItem = session.get(InventoryItem.class, id);
        return inventoryItem;
    }
    
    @Override
    public List<InventoryItem> getAll() {
        Session session = getSession();
        List<InventoryItem> inventoryItems = session.createQuery("FROM InventoryItem").list();
        return inventoryItems;
    }
    
}