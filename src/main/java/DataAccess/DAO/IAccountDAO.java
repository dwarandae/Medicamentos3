package DataAccess.DAO;

import DataAccess.Entities.Account;
import java.util.List;

public interface IAccountDAO extends IGenericDAO<Account> {
    
    public Account get(long id);
    public List<Account> getAll();
    public Account getAccountByUsername(String username);
    
}
