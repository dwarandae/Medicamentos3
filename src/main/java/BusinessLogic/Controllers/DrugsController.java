package BusinessLogic.Controllers;

import BusinessLogic.Services.DrugService;
import DataAccess.Entities.Drug;
import java.util.List;

public class DrugsController {
    
    DrugService drugService;    
    
    public List<Drug> findAllDrugs() {
        return drugService.getAllDrugs();
    }

    public DrugService getDrugService() {
        return drugService;
    }

    public void setDrugService(DrugService drugService) {
        this.drugService = drugService;
    }  
    
}
