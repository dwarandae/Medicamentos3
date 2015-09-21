package BusinessLogic.Services;

import DataAccess.DAO.ICustomerDAO;
import DataAccess.Entities.Customer;
import javax.transaction.Transactional;

public class CustomerService {

    ICustomerDAO customerDAO;

    @Transactional
    public boolean saveCustomer(Customer customer) {
        return customerDAO.save(customer);
    }

    @Transactional
    public boolean isUsernameInUse(String username) {
        return customerDAO.getByUsername(username) != null;
    }

    @Transactional
    public boolean isEmailInUse(String email) {
        return customerDAO.getByEmail(email) != null;
    }
    
    @Transactional
    public Customer findByUsername(String username) {
        return customerDAO.getByUsername(username);
    }

    public ICustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(ICustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

}
