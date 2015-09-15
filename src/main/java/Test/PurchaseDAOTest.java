package Test;

import DataAccess.DAO.PurchaseDAO;
import DataAccess.Entities.Purchase;

public class PurchaseDAOTest {

    public static void main(String... args) {

        Purchase purchase = new Purchase(5000l);
        System.out.println("Starting PurchaseDAOTest");
        PurchaseDAO purchaseDAO = new PurchaseDAO();
        boolean success = purchaseDAO.save(purchase);
        assert (success == true);
        System.out.println("End");

    }

}
