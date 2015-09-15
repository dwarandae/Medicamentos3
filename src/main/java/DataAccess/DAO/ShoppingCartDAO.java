package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.ShoppingCart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ShoppingCartDAO {
    
    private static SessionFactory sessionFactory;
    private static Transaction trans;
    
    public ShoppingCartDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    //This method should not be called, the purchase item is created and saved in the customer's creation
    public boolean save(ShoppingCart shoppingCart) {
        
        boolean success = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(shoppingCart);
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
