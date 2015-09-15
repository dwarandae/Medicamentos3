/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DataAccess.DAO.DrugDAO;
import DataAccess.DAO.ItemDAO;
import DataAccess.Entities.Drug;
import DataAccess.Entities.Item;

/**
 *
 * @author dwarandae
 */
public class ItemDAOTest {
    
    public static void main(String... args) {

        Drug drug = new Drug("brand", "generic", "chemical", "company", "dosage", 
                             "class", "form", "use", "direc", "warnin", false,
                             "sideeff", 10000, 5);
        System.out.println("Starting ItemDAOTest");
        DrugDAO drugDAO = new DrugDAO();
        drugDAO.save(drug);
        
        Item item = new Item(2, drug);
        ItemDAO itemDAO = new ItemDAO();
        boolean success = itemDAO.save(item);
        assert(success == true);
        System.out.println("End");

    }
    
}
