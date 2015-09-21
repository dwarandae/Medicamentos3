package BusinessLogic.Services;

import DataAccess.DAO.IBillDAO;
import DataAccess.Entities.Bill;
import javax.transaction.Transactional;

public class BillService {
    
    private IBillDAO billDAO;
    
    @Transactional
    public boolean saveBill(Bill bill) {
        return billDAO.save(bill);
    }

    /**
     * @return the billDAO
     */
    public IBillDAO getBillDAO() {
        return billDAO;
    }

    /**
     * @param billDAO the billDAO to set
     */
    public void setBillDAO(IBillDAO billDAO) {
        this.billDAO = billDAO;
    }
    
}
