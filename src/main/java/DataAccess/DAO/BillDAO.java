package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.Bill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BillDAO {
    
    private static SessionFactory sessionFactory;
    
    public BillDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    //Warning: this method should not be called (at least directly :p)
    public void save(Bill bill) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.saveOrUpdate(bill);
        trans.commit();
    }
    
}
