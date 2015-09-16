package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.Account;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//TO-DO: refactor later to an interface and a generic
public class AccountDAO {
    
    private static SessionFactory sessionFactory;
    private static Transaction trans;
    
    public AccountDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    //Warning: this method should not be called: you should not create an "Account"
    //instead of that, create Customer or Administrator Account.
    public boolean save(Account account) {
        
        boolean success = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(account);
            trans.commit();
            success = true;
        }
        catch (Exception e) {
            if(trans != null)
                trans.rollback();
        }
       
        return success;
        
    }
    
    public Account getAccountByUsername(String username) {
        
        List<Account> accounts = null;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            accounts = session.createQuery("from Account where username = :username").setParameter("username", username).list();
            trans.commit();
        }
        catch (Exception e) {
            if(trans != null)
                trans.rollback();
        }
        
        if(accounts.isEmpty())
            return null;  //BD exception safe!, if the connection fails...
        else
            return accounts.iterator().next();
     
    }
    
}
