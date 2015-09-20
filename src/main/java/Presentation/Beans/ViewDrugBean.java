/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Beans;

import BusinessLogic.Controllers.ManageDrug;
import DataAccess.Entities.Drug;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author root
 */

@ManagedBean
@SessionScoped
public class ViewDrugBean implements Serializable {

    private Long drugId;
    private String brandName;
    private String genericName;
    private String chemicalName;
    private String pharmaceuticalCompany;
    private String dosage;
    private String classification;
    private String form;
    private String use;
    private String direction;
    private String warning;
    private boolean prescriptionDrug;
    private String sideEffect;
    private long price;
    /**
     * Creates a new instance of ViewMedicamentoBean
     */
    public ViewDrugBean() {
    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }

    public String getPharmaceuticalCompany() {
        return pharmaceuticalCompany;
    }

    public void setPharmaceuticalCompany(String pharmaceuticalCompany) {
        this.pharmaceuticalCompany = pharmaceuticalCompany;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public boolean isPrescriptionDrug() {
        return prescriptionDrug;
    }

    public void setPrescriptionDrug(boolean prescriptionDrug) {
        this.prescriptionDrug = prescriptionDrug;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    
    
    public String getMedicamento(int id){
        Drug med;
        ManageDrug manageDrug=new ManageDrug();
        med=manageDrug.getMedicamento(id);
        
        drugId=med.getDrugId();
        brandName=med.getBrandName();
        genericName=med.getGenericName();
        chemicalName=med.getChemicalName();
        pharmaceuticalCompany=med.getPharmaceuticalCompany();
        dosage=med.getDosage();
        classification=med.getClassification();
        form=med.getForm();
        use=med.getUse();
        direction=med.getDirection();
        warning=med.getWarning();
        prescriptionDrug=med.isPrescriptionDrug();
        sideEffect=med.getSideEffect();
        price=med.getPrice();
        
        return "viewDrug";
    }
    
}
