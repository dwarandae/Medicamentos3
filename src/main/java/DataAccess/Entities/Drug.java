package DataAccess.Entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "drug")
public class Drug implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "drug_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long drugId;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "drug_brand_name")
    private String brandName;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "drug_generic_name")
    private String genericName;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "drug_chemical_name")
    private String chemicalName;
    
    //Maybe an enum...
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "drug_pharmaceutical_company")
    private String pharmaceuticalCompany;
    
    //Maybe an enum...
    //500 mg, 10u/d, etc.. pills,
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "drug_dosage")
    private String dosage;
    
    //Maybe an enum...
    //Antihistamine, etc...
    @Size(min = 1, max = 100)
    @Column(name = "drug_classification")
    private String classification;
    
    //Maybe an enum...
    //Syrup, tablet, pill
    @Size(min = 1, max = 100)
    @Column(name = "drug_form")
    private String form;
    
    //fever, rhinitis, etc... 
    @Size(min = 1, max = 200)
    @Column(name = "drug_use")
    private String use;
    
    //1 pill e/8 hours, etc, 
    @Size(min = 1, max = 200)
    @Column(name = "drug_direction")
    private String direction;
    
    @Size(min = 1, max = 200)
    @Column(name = "drug_warning")
    private String warning;
    
    @Column(name = "is_prescription_drug")
    private boolean prescriptionDrug;
    
    @Size(min = 1, max = 100)
    @Column(name = "drug_side_effect")
    private String sideEffect;
 
    @Column(name = "drug_price")
    private long price;
    
    //A Drug "is" an item in the inventory mapped as "contain" instead of "is a"
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "drug_inventory",
               joinColumns = @JoinColumn(name = "drug_id"),
               inverseJoinColumns = @JoinColumn(name = "inventory_item_id")
    )
    private InventoryItem inventoryItem;

    public Drug() {
    }
    
    public Drug(String brandName, String genericName, String chemicalName, String pharmaceuticalCompany, String dosage, String classification, String form, String use, String direction, String warning, boolean prescriptionDrug, String sideEffect, long price) {
        this.brandName = brandName;
        this.genericName = genericName;
        this.chemicalName = chemicalName;
        this.pharmaceuticalCompany = pharmaceuticalCompany;
        this.dosage = dosage;
        this.classification = classification;
        this.form = form;
        this.use = use;
        this.direction = direction;
        this.warning = warning;
        this.prescriptionDrug = prescriptionDrug;
        this.sideEffect = sideEffect;
        this.price = price;
        this.inventoryItem = new InventoryItem(0); /*Or a Factory?*/
    }
    
    public Drug(String brandName, String genericName, String chemicalName, String pharmaceuticalCompany, String dosage, String classification, String form, String use, String direction, String warning, boolean prescriptionDrug, String sideEffect, long price, InventoryItem inventoryItem) {
        this.brandName = brandName;
        this.genericName = genericName;
        this.chemicalName = chemicalName;
        this.pharmaceuticalCompany = pharmaceuticalCompany;
        this.dosage = dosage;
        this.classification = classification;
        this.form = form;
        this.use = use;
        this.direction = direction;
        this.warning = warning;
        this.prescriptionDrug = prescriptionDrug;
        this.sideEffect = sideEffect;
        this.price = price;
        this.inventoryItem = inventoryItem;
    }
    
    public Drug(String brandName, String genericName, String chemicalName, String pharmaceuticalCompany, String dosage, String classification, String form, String use, String direction, String warning, boolean prescriptionDrug, String sideEffect, long price, int amount) {
        this.brandName = brandName;
        this.genericName = genericName;
        this.chemicalName = chemicalName;
        this.pharmaceuticalCompany = pharmaceuticalCompany;
        this.dosage = dosage;
        this.classification = classification;
        this.form = form;
        this.use = use;
        this.direction = direction;
        this.warning = warning;
        this.prescriptionDrug = prescriptionDrug;
        this.sideEffect = sideEffect;
        this.price = price;
        this.inventoryItem = new InventoryItem(amount);
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

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.drugId);
        hash = 67 * hash + Objects.hashCode(this.brandName);
        hash = 67 * hash + Objects.hashCode(this.genericName);
        hash = 67 * hash + Objects.hashCode(this.chemicalName);
        hash = 67 * hash + Objects.hashCode(this.pharmaceuticalCompany);
        hash = 67 * hash + Objects.hashCode(this.dosage);
        hash = 67 * hash + Objects.hashCode(this.classification);
        hash = 67 * hash + Objects.hashCode(this.form);
        hash = 67 * hash + Objects.hashCode(this.use);
        hash = 67 * hash + Objects.hashCode(this.direction);
        hash = 67 * hash + Objects.hashCode(this.warning);
        hash = 67 * hash + (this.prescriptionDrug ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.sideEffect);
        hash = 67 * hash + (int) (this.price ^ (this.price >>> 32));
        hash = 67 * hash + Objects.hashCode(this.inventoryItem);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Drug other = (Drug) obj;
        if (!Objects.equals(this.drugId, other.drugId)) {
            return false;
        }
        if (!Objects.equals(this.brandName, other.brandName)) {
            return false;
        }
        if (!Objects.equals(this.genericName, other.genericName)) {
            return false;
        }
        if (!Objects.equals(this.chemicalName, other.chemicalName)) {
            return false;
        }
        if (!Objects.equals(this.pharmaceuticalCompany, other.pharmaceuticalCompany)) {
            return false;
        }
        if (!Objects.equals(this.dosage, other.dosage)) {
            return false;
        }
        if (!Objects.equals(this.classification, other.classification)) {
            return false;
        }
        if (!Objects.equals(this.form, other.form)) {
            return false;
        }
        if (!Objects.equals(this.use, other.use)) {
            return false;
        }
        if (!Objects.equals(this.direction, other.direction)) {
            return false;
        }
        if (!Objects.equals(this.warning, other.warning)) {
            return false;
        }
        if (this.prescriptionDrug != other.prescriptionDrug) {
            return false;
        }
        if (!Objects.equals(this.sideEffect, other.sideEffect)) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (!Objects.equals(this.inventoryItem, other.inventoryItem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Drug{" + "drugId=" + drugId + ", brandName=" + brandName + ", genericName=" + genericName + ", chemicalName=" + chemicalName + ", pharmaceuticalCompany=" + pharmaceuticalCompany + ", dosage=" + dosage + ", classification=" + classification + ", form=" + form + ", use=" + use + ", direction=" + direction + ", warning=" + warning + ", prescriptionDrug=" + prescriptionDrug + ", sideEffect=" + sideEffect + ", price=" + price + ", inventoryItem=" + inventoryItem + '}';
    }

}
