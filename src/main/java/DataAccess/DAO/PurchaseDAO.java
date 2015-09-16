package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.Purchase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PurchaseDAO {
    
    private static SessionFactory sessionFactory;
    private static Transaction trans;
    
    public PurchaseDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    //This method should not be called, the purchase is saved in the customer's list
    public boolean save(Purchase purchase) {
        
        boolean success = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(purchase);
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
