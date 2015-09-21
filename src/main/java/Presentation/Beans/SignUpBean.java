package Presentation.Beans;

import BusinessLogic.Controllers.CustomerCreationController;
import DataAccess.Entities.Customer;
import com.opensymphony.xwork2.ActionSupport; 
import org.apache.commons.lang3.StringUtils;

public class SignUpBean extends ActionSupport {
    
    private Customer customer;
    private CustomerCreationController customerCreationController;
        
    public String index() {
        return SUCCESS;
    }
    
    public String create() {
        if(!validateData(customer))
            return INPUT;
        if(customerCreationController.createCustomer(customer))
            return SUCCESS;
        else
            return ERROR;      
    }
    
    public boolean validateData(Customer customer) {
        boolean valid = true;
        if(StringUtils.isBlank(customer.getCustomerId())){
            addFieldError("customerId","Contraseña en blanco");
            valid = false;
        }
        if(StringUtils.isBlank(customer.getEmail())){
            addFieldError("email","Correo en blanco");
            valid = false;
        }
        if(StringUtils.isBlank(customer.getName())){
            addFieldError("name","Nombre en blanco");
            valid = false;
        }
        if(StringUtils.isBlank(customer.getLastName())){
            addFieldError("lastName","Apellidos en blanco");
            valid = false;
        }
        if(StringUtils.isBlank(customer.getPassword())){
            addFieldError("password","Contraseña en blanco");
            valid = false;
        }
        if(StringUtils.isBlank(customer.getUsername())){
            addFieldError("username","Usuario en blanco");
            valid = false;
        }
        if(valid) {
            if(customerCreationController.isUsernameInvalid(customer.getUsername())){
                addFieldError("username","Nombre de usuario ya existente");
                valid = false;
            }
            if(customerCreationController.isEmailInvalid(customer.getEmail())){
                addFieldError("email", "Correo ya existente");
                valid = false;
            }
        }
        return valid;   
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerCreationController getCustomerCreationController() {
        return customerCreationController;
    }

    public void setCustomerCreationController(CustomerCreationController customerCreationController) {
        this.customerCreationController = customerCreationController;
    }
    
}
