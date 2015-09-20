package DataAccess.DAO.Imp;

import DataAccess.DAO.IAccountDAO;
import DataAccess.Entities.Account;
import java.util.List;
import org.hibernate.Session;

public class AccountDAO extends GenericDAO<Account> implements IAccountDAO{
    
    @Override
    public Account get(long id) {
        Session session = getSession();
        Account account = session.get(Account.class, id);
        return account;
    }
   
    @Override
    public List<Account> getAll() {
        Session session = getSession();
        List<Account> accounts = session.createQuery("FROM Account").list();
        return accounts;
    }
    
    @Override
    public Account getAccountByUsername(String username) {
        Session session = getSession();
        Account account;
        account = (Account)session.createQuery("FROM Account WHERE username = :username").setParameter("username", username).uniqueResult();
        return account;
    }
    
}
