package Test;

import DataAccess.DAO.DrugDAO;
import DataAccess.Entities.Drug;
import DataAccess.Entities.InventoryItem;
import java.util.ArrayList;
import java.util.List;

//TO-DO: refactor to JUnit integration test!!
public class DrugDAOTest {
    
    public static void main(String... args) {

        Drug drug1 = new Drug("brand", "generic", "chemical", "company", "dosage", 
                             "class", "form", "use", "direc", "warnin", false,
                             "sideeff", 10000);
        System.out.println("Starting DrugDAOTest");
        System.out.println("Test 1: saving a drug without amount, amount = 0 by default");
        DrugDAO drugDAO = new DrugDAO();
        boolean success = drugDAO.save(drug1);
        assert(success == true);
        assert(drug1.getInventoryItem().getAmount() == 0); //This is ugly :S
        
        System.out.println("Test 2: saving a drug with amount = 5 in the inventory");
        Drug drug2 = new Drug("brand", "generic", "chemical", "company", "dosage", 
                        "class", "form", "use", "direc", "warnin", false,
                        "sideeff", 10000, 5);
        success = drugDAO.save(drug2);
        assert(success == true);
        assert(drug2.getInventoryItem().getAmount() == 5);
        
        System.out.println("Test 3: saving a drug with explicit inventory item (not usual)");
        Drug drug3 = new Drug("brand", "generic", "chemical", "company", "dosage", 
                        "class", "form", "use", "direc", "warnin", false,
                        "sideeff", 10000, new InventoryItem(3));
        success = drugDAO.save(drug3);
        assert(success == true);
        assert(drug3.getInventoryItem().getAmount() == 3);
        
        System.out.println("Test 4: get a drug with id = pk");
        Drug drug4 = new Drug("brandReturn", "generic", "chemical", "company", "dosage", 
                        "class", "form", "use", "direc", "warnin", false,
                        "sideeff", 10000);
        success = drugDAO.save(drug4);
        assert(success == true);
        long pk = drug4.getDrugId(); //Here Hibernate already set the Id for the drug saved.-
        Drug returnDrug = drugDAO.get(pk);
        //It works because we override equals() method in Drug class :P
        assert(drug4.equals(returnDrug));
        
        System.out.println("Test 5: get all the drugs");
        List<Drug> drugs = drugDAO.getAll();
        List<Drug> drugsCreated = new ArrayList<>();
        drugsCreated.add(drug1);
        drugsCreated.add(drug2);
        drugsCreated.add(drug3);
        drugsCreated.add(drug4);
        
        if(drugs.containsAll(drugsCreated))
            System.out.println("Test passed");
        else
            System.out.println("Test failed");
        
        System.out.println("End");    
        
    }
    
}
