package DataAccess.DAO;

import DataAccess.DAO.Util.HibernateSession;
import DataAccess.Entities.Administrator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//TO-DO: refactor later to an interface and a generic
public class AdministratorDAO {
    
    private static SessionFactory sessionFactory;
    
    public AdministratorDAO() {
        sessionFactory = HibernateSession.getSessionFactory();
    }
    
    
    public void save(Administrator administrator) {
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.beginTransaction();
        session.saveOrUpdate(administrator);
        trans.commit();
    }
    
}
