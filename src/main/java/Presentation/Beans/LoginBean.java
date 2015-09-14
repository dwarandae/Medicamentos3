/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Beans;

import BusinessLogic.Controllers.LoginController;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author cegard
 */
@Named(value = "loginBean")
@Dependent
public class LoginBean {
    
    private String message;
    private String userName;
    private String password;
    private String redirectURL;
    private String customerURL;
    private String adminURL;
    
    
    public void signIn(){
        customerURL = "Hello Customer";
        adminURL = "Hello Admin";
        LoginController loginController = new LoginController();
        String result = loginController.login(userName, password, customerURL, adminURL);
        
        if (!result.equals("")){
            redirectURL = result;
        }
        
        else{
            message = "User doesn't exist, please check yor user name or password";
        }
    }
    
            
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
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
     * @return the redirectURL
     */
    public String getRedirectURL() {
        return redirectURL;
    }

    /**
     * @param redirectURL the redirectURL to set
     */
    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }
    
    
    
}
