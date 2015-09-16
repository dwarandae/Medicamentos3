package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ItemDAO {
    
    private static SessionFactory sessionFactory;
    private static Transaction trans;
    
    public ItemDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    //This method should not be called, an Inventory Item is saved with a Drug!
    public boolean save(Item item) {
        
        boolean success = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(item);
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
