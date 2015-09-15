package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.Customer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerDAO {
    
    private static SessionFactory sessionFactory;
    private static Transaction trans;

    
    public CustomerDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    public boolean save(Customer customer) {
        
        boolean success = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(customer);
            trans.commit();
            success = true;
        }
        catch (Exception e) {
            if(trans != null)
                trans.rollback();
        }
       
        return success;
        
    }
    
    public boolean isEmailInUse(String email) {
        
        List<Customer> customers = null;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            customers = session.createQuery("from Customer where email = :email").setParameter("email", email).list();
            trans.commit();
        }
        catch (Exception e) {
            if(trans != null)
                trans.rollback();
        }
        
        if(customers == null)
            return true;  //BD exception safe!, if the connection fails...
        else
            return !customers.isEmpty();
        
    }
    
    public boolean isUsernameInUse(String username) {
        
        List<Customer> customers = null;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            customers = session.createQuery("from Customer where username = :username").setParameter("username", username).list();
            trans.commit();
        }
        catch (Exception e) {
            if(trans != null)
                trans.rollback();
        }
       
        if(customers == null)
            return true;  //BD exception safe!, if the connection fails...
        else
            return !customers.isEmpty();
        
    }
    
    public Customer getCustomerByUsername(String username) {
        
        List<Customer> customers = null;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            customers = session.createQuery("from Customer where username = :username").setParameter("username", username).list();
            trans.commit();
        }
        catch (Exception e) {
            if(trans != null)
                trans.rollback();
        }
        
        if(customers.isEmpty())
            return null;  //BD exception safe!, if the connection fails...
        else
            return customers.iterator().next();
     
    }
    
}
