package BusinessLogic.Controllers;

import BusinessLogic.Services.AdministratorService;
import BusinessLogic.Services.CustomerService;
import DataAccess.Entities.Account;

public class AuthController {
    
    CustomerService customerService;
    AdministratorService administratorService;
    
    //Si no es un administrador debe ser un cliente, si no es un cliente debe ser un administrador, si no es 
    //ninguno de los dos, retorna null (no encontrado). Bajo la restricción de un único nombre de usuario, pero puede tener problemas por la herencia...
    //Ugly.
    public Account findAccount(Account account){
        Account found;
        found= administratorService.findAdministratorByUsername(account.getUsername());
        if(found!=null)
            return found;
        found = customerService.findCustomerByUsername(account.getUsername());
        return found;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public AdministratorService getAdministratorService() {
        return administratorService;
    }

    public void setAdministratorService(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }
    
}
