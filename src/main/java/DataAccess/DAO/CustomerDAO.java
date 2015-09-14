package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerDAO {
    
    private static SessionFactory sessionFactory;
    
    public CustomerDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    
    public void save(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.saveOrUpdate(customer);
        trans.commit();
    }
    
}
