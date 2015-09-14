/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Beans;

import BusinessLogic.Controllers.CustomerAccountCreation;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author omdej
 */
@Named(value = "createCustomerAccountBean")
@Dependent
@ManagedBean
@ViewScoped
public class CreateCustomerAccountBean {
    
    private String name;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private boolean epsCustomer;   

    /**
     * Attempt to create a customer account.
     */
    public void createCustomerAccount() {
        CustomerAccountCreation customerAccountCreation = new CustomerAccountCreation();
        customerAccountCreation.createCustomerAccount(name, lastName, username, password, email, epsCustomer);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the epsCustomer
     */
    public boolean isEpsCustomer() {
        return epsCustomer;
    }

    /**
     * @param epsCustomer the epsCustomer to set
     */
    public void setEpsCustomer(boolean epsCustomer) {
        this.epsCustomer = epsCustomer;
    }
    
}
