package BusinessLogic.Services;

import DataAccess.DAO.IAdministratorDAO;
import DataAccess.Entities.Administrator;
import javax.transaction.Transactional;

public class AdministratorService {
    
    IAdministratorDAO administratorDAO;
    
    @Transactional
    public Administrator findAdministratorByUsername(String username) {
        return administratorDAO.getAdministratorByUsername(username);
    }

    public IAdministratorDAO getAdministratorDAO() {
        return administratorDAO;
    }

    public void setAdministratorDAO(IAdministratorDAO administratorDAO) {
        this.administratorDAO = administratorDAO;
    }
    
}
