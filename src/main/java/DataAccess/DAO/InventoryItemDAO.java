package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.InventoryItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class InventoryItemDAO {
    
    private static SessionFactory sessionFactory;
    
    public InventoryItemDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    //This method should not be called, an Inventory Item is save with a Drug!
    public void save(InventoryItem inventoryItem) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.saveOrUpdate(inventoryItem);
        trans.commit();
    }
    
}