package DataAccess.DAO;

import DataAccess.Entities.Administrator;
import java.util.List;

public interface IAdministratorDAO extends IGenericDAO<Administrator> {
    
    public Administrator get(long id);
    public List<Administrator> getAll();
    public Administrator getAdministratorByUsername(String username);
    
}
