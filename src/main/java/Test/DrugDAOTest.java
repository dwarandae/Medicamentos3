package Test;

import DataAccess.DAO.DrugDAO;
import DataAccess.Entities.Drug;
import DataAccess.Entities.InventoryItem;

public class DrugDAOTest {
    
    public static void main(String... args) {

        //Without amount in inventory
        Drug drug = new Drug("brand", "generic", "chemical", "company", "dosage", 
                             "class", "form", "use", "direc", "warnin", false,
                             "sideeff", 10000);
        System.out.println("En main");
        DrugDAO drugDAO = new DrugDAO();
        drugDAO.save(drug);
        //With amount in inventory
        drug = new Drug("brand", "generic", "chemical", "company", "dosage", 
                        "class", "form", "use", "direc", "warnin", false,
                        "sideeff", 10000, 5);
        System.out.println("En main");
        drugDAO.save(drug);
        //With inventory created
        drug = new Drug("brand", "generic", "chemical", "company", "dosage", 
                        "class", "form", "use", "direc", "warnin", false,
                        "sideeff", 10000, new InventoryItem(3));
        System.out.println("En main");
        drugDAO.save(drug);
        
        //Test get
        drug = new Drug("brandReturn", "generic", "chemical", "company", "dosage", 
                        "class", "form", "use", "direc", "warnin", false,
                        "sideeff", 10000);
        drugDAO.save(drug);
        long pk = drug.getDrugId(); //Here Hibernate already set the Id for the drug saved.-
        Drug returnDrug = drugDAO.get(pk);
        assert(drug.equals(returnDrug));
        System.out.println("Fin");    
        
    }
    
}
