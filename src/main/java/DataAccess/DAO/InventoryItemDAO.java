package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.InventoryItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//FIX-ME: generic plz!
public class InventoryItemDAO {
    
    private static SessionFactory sessionFactory;
    private static Transaction trans;

    public InventoryItemDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    public boolean save(InventoryItem inventoryItem) {
        
        boolean success = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(inventoryItem);
            trans.commit();
            success = true;
        }
        catch (Exception e) {
            if(trans != null)
                trans.rollback();
        }
       
        return success;
        
    }
    
}