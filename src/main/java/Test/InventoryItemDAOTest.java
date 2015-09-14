package Test;

import DataAccess.DAO.InventoryItemDAO;
import DataAccess.Entities.InventoryItem;

public class InventoryItemDAOTest {
    
    public static void main(String... args) {

        //An InventoryItem should not be created isolated, instead of this
        //you can create a Drug and pass it an Inventory Item as a argument
        //or the amount of drugs in the inventory of the drug.
        InventoryItem inventoryItem = new InventoryItem(666); 
        System.out.println("En main");
        InventoryItemDAO inventoryItemDAO = new InventoryItemDAO();
        inventoryItemDAO.save(inventoryItem);
        System.out.println("Fin");    
        
    }
    
}
