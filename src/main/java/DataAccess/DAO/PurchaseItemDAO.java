package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.PurchaseItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PurchaseItemDAO {
    
    private static SessionFactory sessionFactory;
    private static Transaction trans;
    
    public PurchaseItemDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    //This method should not be called, the purchase item is saved in the purchase's list
    public boolean save(PurchaseItem purchaseItem) {
        
        boolean success = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(purchaseItem);
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
