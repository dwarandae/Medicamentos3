package DataAccess.DAO.Imp;

import DataAccess.DAO.ICustomerDAO;
import DataAccess.Entities.Customer;
import java.util.List;
import org.hibernate.Session;

public class CustomerDAO extends GenericDAO<Customer> implements ICustomerDAO{
    
    @Override
    public Customer get(long id) {
        Session session = getSession();
        Customer customer = session.get(Customer.class, id);
        return customer;
    }
   
    @Override
    public Customer getByUsername(String username) {
        Session session = getSession();
        Customer customer = (Customer)session.createQuery("FROM Customer WHERE username = :username").setParameter("username", username).uniqueResult();
        return customer;
    }
    
    @Override
    public Customer getByEmail(String email) {
        Session session = getSession();
        Customer customer = (Customer)session.createQuery("FROM Customer WHERE email = :email").setParameter("email", email).uniqueResult();
        return customer;
    }
    
    @Override
    public Customer getByCustomerId(Long customerId) {
        Session session = getSession();
        Customer customer = (Customer) session.createQuery("FROM Customer WHERE customerId = :customerId").setParameter("customerId", customerId).uniqueResult();
        return customer;
    }
    
    @Override
    public List<Customer> getAll() {
        Session session = getSession();
        List<Customer> customers = session.createQuery("FROM Customer").list();
        return customers;
    }
    
}
