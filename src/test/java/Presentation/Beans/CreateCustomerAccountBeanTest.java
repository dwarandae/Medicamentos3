/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Beans;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omdej
 */
public class CreateCustomerAccountBeanTest {

    /**
     * Test of createCustomerAccount method, of class CreateCustomerAccountBean.
     * Also tests all classes that this method implies.
     */
    @Test
    public void testCreateCustomerAccount() {
        System.out.println("CreateCustomerAccountBean Unit Test");
        CreateCustomerAccountBean instance = new CreateCustomerAccountBean();
        instance.setUsername("something");
        instance.setPassword("something");
        instance.setName("something");
        instance.setLastName("something");
        instance.setEmail("something");
        instance.setCustomerId("something");
        instance.setEpsCustomer(true);
        
        try {
            instance.createCustomerAccount();
            if (!instance.getStatusMessage().equals("Cuenta creada exitosamente.")) fail("The customer instance could not be persisted.");
            
            instance.setUsername("sth");
            instance.createCustomerAccount();
            if (!instance.getStatusMessage().equals("El correo electrónico ingresado ya está asociado a otra cuenta.")) fail("The customer instance saving should've detected a duplicated email.");
            
            instance.setUsername("something");
            instance.setEmail("sth");
            instance.createCustomerAccount();
            if (!instance.getStatusMessage().equals("El nombre de cuenta ingresado ya existe.")) fail("The customer instance saving should've detected a duplicated username.");

            instance.setName("somethingsomethingsomething");
            instance.createCustomerAccount();
            if (!instance.getStatusMessage().equals("El nombre no debe superar los 20 caracteres")) fail("The customer instance name was not validated.");
        } catch (Exception e) {
            fail("The database must be cleaned up before testing.");
        }
        
    }
    
}
