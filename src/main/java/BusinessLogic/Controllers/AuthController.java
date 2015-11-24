package BusinessLogic.Controllers;

import BusinessLogic.Services.AdministratorService;
import BusinessLogic.Services.CustomerService;
import BusinessLogic.Services.LDAPOperationsService;
import DataAccess.Entities.Account;

public class AuthController {
    
    private CustomerService customerService;
    private AdministratorService administratorService;
    private LDAPOperationsService ldapOperationsService;
    
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
    
    /**
     * LDAP authentication. Permissions are bound to specific users on LDAP server.
     * 
     * @param username
     * @param password
     * @return 0: successful. 1: Wrong username or password. 2: Connection failed.
     */
    public int ldapLogin(String username, String password) {
        return ldapOperationsService.login(username, password);
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

    /**
     * @return the ldapOperationsService
     */
    public LDAPOperationsService getLdapOperationsService() {
        return ldapOperationsService;
    }

    /**
     * @param ldapOperationsService the ldapOperationsService to set
     */
    public void setLdapOperationsService(LDAPOperationsService ldapOperationsService) {
        this.ldapOperationsService = ldapOperationsService;
    }
    
}
