package BusinessLogic.Services;

import DataAccess.Entities.Drug;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "TestWSDL")
public class TestWSDL {
    
    @WebMethod(operationName = "testTransaction")
    public Drug testTransaction(@WebParam(name = "drugId") Long drugId) {
        DrugService drugService = new DrugService();
        Drug drug = drugService.findDrugById(drugId);
        System.out.println(drug);
        return drug;
    }
    
}
