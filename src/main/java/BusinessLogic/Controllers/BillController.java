package BusinessLogic.Controllers;

import BusinessLogic.Services.BillService;
import DataAccess.Entities.Bill;

public class BillController {
    
    private BillService billService;
    
    public boolean saveBill(Bill bill) {
        return billService.saveBill(bill);
    }

    /**
     * @return the billService
     */
    public BillService getBillService() {
        return billService;
    }

    /**
     * @param billService the billService to set
     */
    public void setBillService(BillService billService) {
        this.billService = billService;
    }
    
}
