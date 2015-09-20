package DataAccess.DAO.Imp;

import DataAccess.Entities.Bill;
import java.util.Date;

public class BillDAOTest {
    
    public static void main(String... args) {
        
        Bill bill = new Bill(new Date(),"credit card");
        BillDAO billDAO = new BillDAO();
        System.out.println("Starting AdministratorDAOTest");
        boolean success = billDAO.save(bill);
        assert(success == true);
        System.out.println("End");    
        
    }
    
}
