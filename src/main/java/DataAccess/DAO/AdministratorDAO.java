package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.Administrator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//TO-DO: refactor later to an interface and a generic
public class AdministratorDAO {
    
    private static SessionFactory sessionFactory;
    private static Transaction trans;

    public AdministratorDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    //Warning: this method should not be called in production.
    //The administrator users are created on BD!
    public boolean save(Administrator administrator) {
        
        boolean success = false;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            session.saveOrUpdate(administrator);
            trans.commit();
            success = true;
        }
        catch (Exception e) {
            if(trans != null)
                trans.rollback();
        }
        
        return success;
        
    }
    
    public Administrator getAdministratorByUsername(String username) {
        
        List<Administrator> administrators = null;
        
        try {
            Session session = sessionFactory.getCurrentSession();
            trans = session.beginTransaction();
            administrators = session.createQuery("from Administrator where username = :username").setParameter("username", username).list();
            trans.commit();
        }
        catch (Exception e) {
            if(trans != null)
                trans.rollback();
        }
        
        if(administrators.isEmpty())
            return null;  //BD exception safe!, if the connection fails...
        else
            return administrators.iterator().next();
     
    }
    
}
