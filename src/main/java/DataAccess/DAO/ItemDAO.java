package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ItemDAO {
    
    private static SessionFactory sessionFactory;
    
    public ItemDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    //This method should not be called, an Inventory Item is save with a Drug!
    public void save(Item item) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.saveOrUpdate(item);
        trans.commit();
    }
    
}
