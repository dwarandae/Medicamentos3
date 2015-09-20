/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Beans;

import BusinessLogic.Controllers.CustomerAccountCreation;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author omdej
 */
@Named(value = "createCustomerAccountBean")
@ManagedBean
@ViewScoped
public class CreateCustomerAccountBean {
    
    private String name;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String customerId;
    private boolean epsCustomer;
    private String statusMessage;

    /**
     * Attempt to create a customer account.
     */
    public void createCustomerAccount() {        
        if(name.length() > 20) {
            statusMessage = "El nombre no debe superar los 20 caracteres";
        } else if(lastName.length() > 20) {
            statusMessage = "El apellido no debe superar los 20 caracteres";
        } else if(username.length() > 20) {
            statusMessage = "El nombre de la cuenta no debe superar los 20 caracteres";
        } else if(password.length() > 20) {
            statusMessage = "La contraseña no debe superar los 20 caracteres";
        } else if (customerId.length() > 20) {
            statusMessage = "La identificación no debe superar los 20 caracteres";
        } else if(email.length() > 50) {
            statusMessage = "El correo electrónico no debe superar los 50 caracteres";
        } else {
            CustomerAccountCreation customerAccountCreation = new CustomerAccountCreation();
            int persistenceStatus = customerAccountCreation.createCustomerAccount(name, lastName, username, password, email, customerId, epsCustomer);
            if (persistenceStatus == 0) {
                statusMessage = "Cuenta creada exitosamente.";
            } else if (persistenceStatus == 1) {
                statusMessage = "El nombre de cuenta ingresado ya existe.";
            } else if (persistenceStatus == 2) {
                statusMessage = "El correo electrónico ingresado ya está asociado a otra cuenta.";
            } else {
                statusMessage = "Hubo un error en la creación de la cuenta.";
            }
        }        
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
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    /**
     * @return the statusMessage
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * @param statusMessage the statusMessage to set
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    
}