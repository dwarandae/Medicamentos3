package Presentation.Beans;

import BusinessLogic.Controllers.DrugsController;
import DataAccess.Entities.Drug;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

public class AdminDrugListBean extends ActionSupport implements SessionAware {
    
    private long drugIdToModify;
    private long drugIdToDelete = -1L;
    private List<Drug> drugs;
    private DrugsController drugsController;
    
    private Map<String, Object> userSession;
    
    private final String DRUG_ID_TO_MODIFY = "drugIdToModify";
    
    public String index() {
        drugs = drugsController.findAllDrugs();
        return SUCCESS;
    }
    
    public String modifyDrug() {
        if (drugIdToDelete == -1) {
            userSession.put(DRUG_ID_TO_MODIFY, drugIdToModify);
            return SUCCESS;
        } else {
            drugsController.deleteDrug(drugIdToDelete);
            drugIdToDelete = -1L;
            return INPUT;
        }        
    }

    /**
     * @return the drugIdToModify
     */
    public long getDrugIdToModify() {
        return drugIdToModify;
    }

    /**
     * @param drugIdToModify the drugIdToModify to set
     */
    public void setDrugIdToModify(long drugIdToModify) {
        this.drugIdToModify = drugIdToModify;
    }

    /**
     * @return the drugs
     */
    public List<Drug> getDrugs() {
        return drugs;
    }

    /**
     * @param drugs the drugs to set
     */
    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    /**
     * @return the drugsController
     */
    public DrugsController getDrugsController() {
        return drugsController;
    }

    /**
     * @param drugsController the drugsController to set
     */
    public void setDrugsController(DrugsController drugsController) {
        this.drugsController = drugsController;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the drugIdToDelete
     */
    public long getDrugIdToDelete() {
        return drugIdToDelete;
    }

    /**
     * @param drugIdToDelete the drugIdToDelete to set
     */
    public void setDrugIdToDelete(long drugIdToDelete) {
        this.drugIdToDelete = drugIdToDelete;
    }
    
}