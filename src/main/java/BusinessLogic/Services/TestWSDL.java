
package BusinessLogic.Services;

import BusinessLogic.Controllers.DrugsController;
import DataAccess.Entities.Drug;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author oscar
 */
@WebService(serviceName = "TestWSDL")
public class TestWSDL {
    
    @WebMethod(operationName = "testTransaction")
    public Drug testTransaction(Long drugId) {
        DrugsController drugsController = new DrugsController();
        Drug drug = drugsController.findDrugById(drugId);
        System.out.println(drug);
        return drug;
    }
    
}
