package Presentation.Beans;

import BusinessLogic.Controllers.AuthController;
import BusinessLogic.Controllers.SessionController;
import DataAccess.Entities.Account;
import DataAccess.Entities.Administrator;
import DataAccess.Entities.Customer;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

public class SignInBean extends ActionSupport {
    
    Customer customer;
    Administrator administrator;
    Account account;
    AuthController authController;
    SessionController sessionController;
    
    private final String NOT_FOUND = "notFound";
    private final String ADMIN = "admin";
    private final String CUSTOMER = "customer";
    private final String PASS = "password";
    
    public String index() {
        return SUCCESS;
    }
    
    //This is ugly :S
    public String signIn() {
        if(!validateData(account))
            return INPUT;
        Account found = authController.findAccount(account);
        if(found == null)
            return NOT_FOUND;
        if(!validatePassword(found))
            return PASS;
        sessionController.attachSession(found);
        if(found instanceof Customer)
            return CUSTOMER;
        if(found instanceof Administrator)
            return ADMIN;
    }
    
    public boolean validateData(Account account) {
        boolean valid = true;
        if(StringUtils.isBlank(account.getUsername())){
            addFieldError("username", "Nombre de usuario en blanco");
            valid = false;
        }
        if(StringUtils.isBlank(account.getPassword())){
            addFieldError("password", "Contraseña en blanco");
        }
        return valid;
    }
    
    public boolean validatePassword(Account account) {
        return this.account.getPassword().equals(account.getPassword());
    }
    
}
