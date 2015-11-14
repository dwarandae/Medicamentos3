package Presentation.Beans;

import BusinessLogic.Controllers.DrugsController;
import DataAccess.Entities.Drug;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

public class ModifyDrugBean extends ActionSupport implements SessionAware {
    
    private Drug drugToModify;
    private DrugsController drugsController;
    
    private Map<String, Object> userSession;
    
    private final String DRUG_ID_TO_MODIFY = "drugIdToModify";
    
    public String index() {
        drugToModify = drugsController.findDrugById((long) userSession.get(DRUG_ID_TO_MODIFY));
        return SUCCESS;
    }
    
    /* In order to get all values, a hidden tag must be added for each attribute not showed
     * in the form. Otherwise, they will be set to null.
     */
    public String doModifyDrug() {
        if (!validateData(drugToModify))
            return INPUT;
        if (drugsController.updateDrug(drugToModify))
            return SUCCESS;
        else
            return ERROR;
    }
    
    private boolean validateData(Drug drug) {
        boolean valid = true;
        if (StringUtils.isBlank(drug.getBrandName())) {
            addFieldError("brandName","Nombre en blanco");
            valid = false;
        }
        if (StringUtils.isBlank(drug.getGenericName())) {
            addFieldError("genericName","Nombre genérico en blanco");
            valid = false;
        }
        if (StringUtils.isBlank(drug.getChemicalName())) {
            addFieldError("chemicalName","Componente activo en blanco");
            valid = false;
        }
        if (StringUtils.isBlank(drug.getPharmaceuticalCompany())) {
            addFieldError("pharmaceuticalCompany","Compañía farmacéutica en blanco");
            valid = false;
        }
        if (StringUtils.isBlank(drug.getDosage())) {
            addFieldError("dosage","Dosis en blanco");
            valid = false;
        }
        return valid;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        userSession = session;
    }

    /**
     * @return the drugToModify
     */
    public Drug getDrugToModify() {
        return drugToModify;
    }

    /**
     * @param drugToModify the drugToModify to set
     */
    public void setDrugToModify(Drug drugToModify) {
        this.drugToModify = drugToModify;
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
    
}
