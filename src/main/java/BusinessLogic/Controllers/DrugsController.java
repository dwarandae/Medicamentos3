package BusinessLogic.Controllers;

import BusinessLogic.Services.DrugService;
import DataAccess.Entities.Drug;
import java.util.List;

public class DrugsController {
    
    DrugService drugService;
    
    // Actually, it doesn't delete the drug, just set its amount to -1,
    // because the entity is needed for other transactions such as purchase history.
    public boolean deleteDrug(long id) {
        Drug drugToDelete = drugService.findDrugById(id);
        drugToDelete.getInventoryItem().setAmount(-1);
        return drugService.saveDrug(drugToDelete);
    }
    
    public List<Drug> findAllDrugs() {
        return drugService.getAllDrugs();
    }
    
    public Drug findDrugById(Long id) {
        return drugService.findDrugById(id);
    }
    
    public boolean saveDrug(Drug drug) {
        return drugService.saveDrug(drug);
    }
    
    public boolean updateDrug(Drug drug) {
        return drugService.updateDrug(drug);
    }

    public DrugService getDrugService() {
        return drugService;
    }

    public void setDrugService(DrugService drugService) {
        this.drugService = drugService;
    }  
    
}
