package Presentation.Beans;

import BusinessLogic.Controllers.DrugsController;
import DataAccess.Entities.Drug;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

public class AddDrugBean extends ActionSupport {
    
    private Drug drugToAdd;
    private DrugsController drugsController;
    
    public String index() {
        drugToAdd = new Drug();
        return SUCCESS;
    }
    
    public String doAddDrug() {
        if (!validateData(drugToAdd))
            return INPUT;
        if (drugsController.saveDrug(drugToAdd))
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

    /**
     * @return the drugToAdd
     */
    public Drug getDrugToAdd() {
        return drugToAdd;
    }

    /**
     * @param drugToAdd the drugToAdd to set
     */
    public void setDrugToAdd(Drug drugToAdd) {
        this.drugToAdd = drugToAdd;
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