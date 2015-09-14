package Test;

import DataAccess.DAO.BillDAO;
import DataAccess.Entities.Bill;
import java.util.Date;

public class BillDAOTest {
    
    public static void main(String... args) {
        
        Bill bill = new Bill(new Date(),"credit card");
        BillDAO billDAO = new BillDAO();
        System.out.println("En main");
        billDAO.save(bill);
        System.out.println("Fin");    
        
    }
    
}
