package Presentation.Beans;

import BusinessLogic.Controllers.ListDrugsController;
import DataAccess.Entities.Drug;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

//TO-DO: deprecated??
@Named(value = "listDrugsBean")
@ManagedBean
@SessionScoped
public class ListDrugsBean implements Serializable {
    
    ListDrugsController listDrugsController = new ListDrugsController();
    
    List<Drug> drugs;
    
    public List<Drug> getAllDrugs() {
        return listDrugsController.getAllDrugs();
    }

    public ListDrugsController getListDrugsController() {
        return listDrugsController;
    }

    public void setListDrugsController(ListDrugsController listDrugsController) {
        this.listDrugsController = listDrugsController;
    }

    public List<Drug> getDrugs() {
        drugs = listDrugsController.getAllDrugs();
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
    
}
