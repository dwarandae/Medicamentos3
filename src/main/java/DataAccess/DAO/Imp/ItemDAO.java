package DataAccess.DAO.Imp;

import DataAccess.DAO.*;
import DataAccess.Entities.Item;
import java.util.List;
import org.hibernate.Session;

public class ItemDAO extends GenericDAO<Item> implements IItemDAO {
    
    @Override
    public Item get(long id) {
        Session session = getSession();
        Item item = session.get(Item.class, id);
        return item;
    }
    
    @Override
    public List<Item> getAll() {
        Session session = getSession();
        List<Item> items = session.createQuery("FROM Item").list();
        return items;
    }
    
}
