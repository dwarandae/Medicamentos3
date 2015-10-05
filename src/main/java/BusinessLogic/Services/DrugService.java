package BusinessLogic.Services;

import DataAccess.DAO.IDrugDAO;
import DataAccess.Entities.Drug;
import java.util.List;
import javax.transaction.Transactional;

public class DrugService {
    
    IDrugDAO drugDAO;
    
    @Transactional
    public List<Drug> getAllDrugs() {
        return drugDAO.getAll();
    }

    public IDrugDAO getDrugDAO() {
        return drugDAO;
    }

    public void setDrugDAO(IDrugDAO drugDAO) {
        this.drugDAO = drugDAO;
    }
    
}
