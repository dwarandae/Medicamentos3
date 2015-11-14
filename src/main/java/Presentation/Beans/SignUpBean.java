package Presentation.Beans;

import BusinessLogic.Controllers.CustomerController;
import DataAccess.Entities.Customer;
import com.opensymphony.xwork2.ActionSupport; 
import org.apache.commons.lang3.StringUtils;

public class SignUpBean extends ActionSupport {
    
    private Customer customer;
    private CustomerController customerController;
        
    public String index() {
        return SUCCESS;
    }
    
    public String create() {
        if(!validateData(customer))
            return INPUT;
        if(customerController.saveCustomer(customer))
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
            if(customerController.isUsernameInvalid(customer.getUsername())){
                addFieldError("username","Nombre de usuario ya existente");
                valid = false;
            }
            if(customerController.isEmailInvalid(customer.getEmail())){
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

    public CustomerController getCustomerController() {
        return customerController;
    }

    public void setCustomerController(CustomerController customerController) {
        this.customerController = customerController;
    }
    
}
