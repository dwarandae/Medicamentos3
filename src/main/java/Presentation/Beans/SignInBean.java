package Presentation.Beans;

import BusinessLogic.Controllers.LoginController;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

public class SignInBean extends ActionSupport{
    
    
    private String userName;
    private String password;
    private LoginController loginController;
    
    
    public String index() {
        return SUCCESS;
    }
    
    
    public String signIn(){
        loginController = new LoginController();
        String result = "";
        
        if (validateCamps()){
            result = loginController.login(userName, password);
        }
        return result;
    }
    
    
    public boolean validateCamps(){
        boolean userNameIsBlank = StringUtils.isBlank(userName);
        boolean passwordIsBlank = StringUtils.isBlank(password);
        
        if(userNameIsBlank){
            addFieldError("userName", "El campo nombre de usuario no puede estar vacío");
        }
        if (passwordIsBlank){
            addFieldError("password", "El campo contraseña no puede estar vacío");
        }
        
        return userNameIsBlank && passwordIsBlank;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the loginController
     */
    public LoginController getLoginController() {
        return loginController;
    }

    /**
     * @param loginController the loginController to set
     */
    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
