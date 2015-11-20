package BusinessLogic.Services;

import DataAccess.Entities.Customer;
import DataAccess.Entities.Purchase;
import DataAccess.Entities.PurchaseItem;
import java.util.Date;
import java.util.Random;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService(serviceName = "TestWSDL")
public class TestWSDL extends SpringBeanAutowiringSupport {
    
    @Autowired
    private CustomerService customerService;
    
    @WebMethod(operationName = "testTransaction")
    public WebServiceResponse testTransaction(@WebParam(name = "customerId") Long customerId) {
        WebServiceResponse response = new WebServiceResponse();
        
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        Customer customer = customerService.findByCustomerId(customerId);
        if (customer == null) {
            response.setSuccess(false);
            response.setStatusMessage("No se pudo encontrar el cliente.");
            return response;
        }        
        System.out.println(customer);
        
        if (!customer.getPurchases().isEmpty())
            return response;
        
        // Solely for testing purposes
        boolean useTempData = true;
        if (useTempData) {
            Random random = new Random();
            int numPurchases = random.nextInt(21);
            for (int i = 0; i < numPurchases; i++) {
                long totalAmount = random.nextInt(5001);
                PurchaseInfo purchaseInfo = new PurchaseInfo(new Date(), totalAmount * 3500);
                purchaseInfo.setTotalAmount(totalAmount);
                response.getPurchasesData().add(purchaseInfo);
            }
        }
        
        for (Purchase purchase : customer.getPurchases()) {
            PurchaseInfo purchaseInfo = new PurchaseInfo(purchase.getBill().getBillDate(), purchase.getTotalPrice());
            long totalAmount = 0;
            for (PurchaseItem purchaseItem : purchase.getPurchaseItems())
                totalAmount += purchaseItem.getAmount();
            purchaseInfo.setTotalAmount(totalAmount);
            response.getPurchasesData().add(purchaseInfo);
        }
        
        return response;       
    }

    /**
     * @return the customerService
     */
    @WebMethod(exclude = true)
    public CustomerService getDrugService() {
        return customerService;
    }

    /**
     * @param customerService the customerService to set
     */
    @WebMethod(exclude = true)
    public void setDrugService(CustomerService customerService) {
        this.customerService = customerService;
    }
    
}