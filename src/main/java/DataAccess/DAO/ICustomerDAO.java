package DataAccess.DAO;

import DataAccess.Entities.Customer;
import java.util.List;

public interface ICustomerDAO extends IGenericDAO<Customer> {
    
    public Customer get(long id);
    public Customer getByUsername(String username);
    public Customer getByEmail(String email);
    public List<Customer> getAll();
    
}
