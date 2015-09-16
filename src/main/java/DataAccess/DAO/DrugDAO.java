package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.Drug;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DrugDAO {
    
    private static SessionFactory sessionFactory;
    private static Transaction trans;
    
    public DrugDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    public boolean save(Drug drug) {
        
        boolean success = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(drug);
            trans.commit();
            success = true;
        }
        catch (Exception e) {
            if(trans != null)
                trans.rollback();
        }
       
        return success;
        
    }
    
    public Drug get(long id) {
        
        Drug drug = null;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            drug = (Drug)session.get(Drug.class,id);
            trans.commit();
        }
        catch (Exception e) {
            if(trans != null)
                trans.rollback();
        }
        
        return drug;
        
    }
    
    public List<Drug> getAll() {
        
        List<Drug> drugs = null;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            drugs = session.createQuery("from Drug").list();
            trans.commit();
        }
        catch (Exception e) {
            if(trans != null)
                trans.rollback();
        }
        
        return drugs;
        
    }
    
}
