package Presentation.Beans;

import BusinessLogic.Controllers.DrugsController;
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
    
//    DrugsController listDrugsController = new DrugsController();
//    
//    List<Drug> drugs;
//    
//    public List<Drug> getAllDrugs() {
//        return listDrugsController.getAllDrugs();
//    }
//
//    public DrugsController getListDrugsController() {
//        return listDrugsController;
//    }
//
//    public void setListDrugsController(DrugsController listDrugsController) {
//        this.listDrugsController = listDrugsController;
//    }
//
//    public List<Drug> getDrugs() {
//        drugs = listDrugsController.getAllDrugs();
//        return drugs;
//    }
//
//    public void setDrugs(List<Drug> drugs) {
//        this.drugs = drugs;
//    }
    
}
