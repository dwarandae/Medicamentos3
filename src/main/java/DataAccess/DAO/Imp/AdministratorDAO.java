package DataAccess.DAO.Imp;

import DataAccess.DAO.IAdministratorDAO;
import DataAccess.Entities.Administrator;
import java.util.List;
import org.hibernate.Session;

public class AdministratorDAO extends GenericDAO<Administrator> implements IAdministratorDAO {
    
    @Override
    public Administrator get(long id) {
        Session session = getSession();
        Administrator administrator = session.get(Administrator.class, id);
        return administrator;
    }
   
    @Override
    public List<Administrator> getAll() {
        Session session = getSession();
        List<Administrator> administrators = session.createQuery("FROM Administrator").list();
        return administrators;
    }
    
    @Override
    public Administrator getAdministratorByUsername(String username) {
        Session session = getSession();
        Administrator administrator;
        administrator = (Administrator)session.createQuery("FROM Account WHERE username = :username").setParameter("username", username).uniqueResult();
        return administrator;
    }
    
}
