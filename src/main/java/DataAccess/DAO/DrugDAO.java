package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.Drug;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DrugDAO {
    
    private static SessionFactory sessionFactory;
    
    public DrugDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    public void save(Drug drug) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.saveOrUpdate(drug);
        trans.commit();
    }
    
    public Drug get(long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        Drug drug = (Drug)session.get(Drug.class, id);
        return drug;
        
    }
    
}
