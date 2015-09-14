package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//TO-DO: refactor later to an interface and a generic
public class AccountDAO {
    
    private static SessionFactory sessionFactory;
    
    public AccountDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    //Warning: this method should not be called: you should not create an "Account"
    //instead of that, create Customer or Administrator Account.
    public void save(Account account) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.saveOrUpdate(account);
        trans.commit();
    }
    
}
