package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.Bill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BillDAO {
    
    private static SessionFactory sessionFactory;
    private static Transaction trans;
    
    public BillDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    //Warning: this method should not be called (at least directly :p)
    public boolean save(Bill bill) {
        
        boolean success = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(bill);
            trans.commit();
            success = true;
        }
        catch (Exception e) {
            if(trans != null)
                trans.rollback();
        }
       
        return success;
        
    }
}
