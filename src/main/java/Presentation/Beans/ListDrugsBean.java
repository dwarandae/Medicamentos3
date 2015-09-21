package Presentation.Beans;

import BusinessLogic.Controllers.DrugsController;
import DataAccess.Entities.Drug;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

public class ListDrugsBean extends ActionSupport {
    
    DrugsController drugsController = new DrugsController();
    
    List<Drug> drugs;
    
    public String index() {
        drugs = drugsController.findAllDrugs();
        return SUCCESS;
    }

    public DrugsController getDrugsController() {
        return drugsController;
    }

    public void setDrugsController(DrugsController drugsController) {
        this.drugsController = drugsController;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
    
}
