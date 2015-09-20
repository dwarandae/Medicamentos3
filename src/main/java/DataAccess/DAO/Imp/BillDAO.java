package DataAccess.DAO.Imp;

import DataAccess.DAO.IBillDAO;
import DataAccess.Entities.Bill;
import java.util.List;
import org.hibernate.Session;


public class BillDAO extends GenericDAO<Bill> implements IBillDAO {
    
    @Override
    public Bill get(long id) {
        Session session = getSession();
        Bill bill = session.get(Bill.class, id);
        return bill;
    }
   
    @Override
    public List<Bill> getAll() {
        Session session = getSession();
        List<Bill> bills = session.createQuery("FROM Bill").list();
        return bills;
    }
  
}
