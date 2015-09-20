package BusinessLogic.Controllers;

import DataAccess.DAO.DrugDAO;
import DataAccess.Entities.Drug;
import java.util.List;

public class ListDrugsController {
    
    DrugDAO drugDAO;
            
    public ListDrugsController() {
        
        drugDAO = new DrugDAO();
        
    }        
    
    public List<Drug> getAllDrugs() {
        return drugDAO.getAll();
    }
    
}
