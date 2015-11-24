package Presentation.Beans;

import BusinessLogic.Controllers.AuthController;
import BusinessLogic.Controllers.DrugsController;
import BusinessLogic.Controllers.SessionController;
import BusinessLogic.Services.LDAPOperationsService;
import DataAccess.Entities.Account;
import DataAccess.Entities.Administrator;
import DataAccess.Entities.Customer;
import DataAccess.Entities.Drug;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

public class SignInBean extends ActionSupport implements SessionAware {

    private Customer customer;
    private Administrator administrator;
    private Account account;
    private List<Drug> drugs;
    private AuthController authController;
    private SessionController sessionController;
    private DrugsController drugsController;
    private Map<String, Object> sessionMap;
    
    // LDAP authentication
    private final boolean useLDAP = true;

    private final String NOT_FOUND = "notFound";
    private final String ADMIN = "admin";
    private final String CUSTOMER = "customer";
    private final String PASS = "password";

    public String index() {
        return SUCCESS;
    }

    //This is ugly :S
    //Terrible workaround because roles by inheritance model is not useful...
    public String signIn() {
        String role;

        if (!validateData(account)) {
            System.out.println("Datos erróneos");
            return INPUT;
        }
        
        Account found = authController.findAccount(account);
        if (found == null) {
            System.out.println("No se encontró la cuenta en la BD local.");
            addFieldError("username", "Username no existe en la BD local.");
            return NOT_FOUND;
        }

        // If LDAP authentication is used, then the account MUST exist on the
        // local DB. Otherwise, only the local DB will be used instead for
        // password validation.
        if (useLDAP) {
            int ldapResponse = authController.ldapLogin(account.getUsername(), account.getPassword());
            if (ldapResponse == 1) {
                System.out.println("La cuenta o contraseña no coincide (LDAP).");
                addFieldError("username", "Cuenta o contraseña incorrecta (LDAP).");
                return INPUT;
            } else if (ldapResponse == 2) {
                System.out.println("Conexión con el servidor LDAP fallida.");
                addFieldError("username", "Conexión con el servidor LDAP fallida.");
                return INPUT;
            }
        } else if (!validatePassword(found)) {
            System.out.println("Contraseña no coincide con la BD local.");
            return PASS;
        }

        if (found instanceof Customer) {
            System.out.println("Cuenta cliente");
            role = CUSTOMER;
        } else {
            role = ADMIN;
            System.out.println("Cuenta admin");

        }
        sessionController.attachSession(sessionMap, role, account);
        return role;
    }

    public boolean validateData(Account account) {
        boolean valid = true;
        if (StringUtils.isBlank(account.getUsername())) {
            addFieldError("username", "Nombre de usuario en blanco");
            valid = false;
        }
        if (StringUtils.isBlank(account.getPassword())) {
            addFieldError("password", "Contraseña en blanco");
        }
        return valid;
    }

    public boolean validatePassword(Account account) {
        return this.account.getPassword().equals(account.getPassword());
    }

    public String indexAdmin() {
        return SUCCESS;
    }

    public String indexCustomer() {
        drugs = drugsController.findAllDrugs();
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public AuthController getAuthController() {
        return authController;
    }

    public void setAuthController(AuthController authController) {
        this.authController = authController;
    }

    public SessionController getSessionController() {
        return sessionController;
    }

    public void setSessionController(SessionController sessionController) {
        this.sessionController = sessionController;
    }

    public DrugsController getDrugsController() {
        return drugsController;
    }

    public void setDrugsController(DrugsController drugsController) {
        this.drugsController = drugsController;
    }

}
