
package BusinessLogic.Services;

import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPAttributeSet;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import java.io.UnsupportedEncodingException;

public class LDAPOperationsService {
    
    private final LDAPConnection lc = new LDAPConnection();
    private final String organizationName = "Medicamentos";
    private final String ldapHost = "192.168.0.50";
    private final String dn = "cn=admin,dc=arqsoft,dc=com";
    
    /**
     * Log into LDAP server.
     * 
     * @param username
     * @param password
     * @return 0: successful. 1: Wrong username or password. 2: Connection failed.
     */
    public int login(String username, String password) {
        int status;
        if (makeConnection()) {
            if (validatePassword(username, password))
                status = 0;
            else
                status = 1;
        } else {
            status = 2;
        }
        try {
            lc.disconnect();
        } catch (LDAPException ex) {
            System.out.println("Error al desconectarse del servidor LDAP");
        }        
        return status;
    }
    
    private Boolean makeConnection() {        
        String password = "arqsoft2015";
        int ldapPort = LDAPConnection.DEFAULT_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;
        
        try {
            lc.connect(ldapHost, ldapPort);
            System.out.println("Successfully connected to LDAP server.");
            lc.bind(ldapVersion, dn, password.getBytes("UTF8"));
            System.out.println("Successfully authenticated as administrator.");
            return true;
        } catch (LDAPException | UnsupportedEncodingException ex) {
            System.out.println("Connection to LDAP server was unsuccessful.");
            return false;
        }
    }
    
    private Boolean validatePassword(String username, String password) {
        String udn = "cn=" + username + ",ou=" + organizationName + ",dc=arqsoft,dc=com";
        
        try {
            lc.bind(udn, password);
            System.out.println("Successfully authenticated as [" + username + "] in the organization [" + organizationName + "].");
            return true;
        } catch (LDAPException ex) {
            System.out.println("Authentication as [" + username + "] in the organization [" + organizationName + "] was unsuccessful.");
            return false;
        }
    }
    
    /**
     * Adds user entry to the organization.
     *  
     * @param username
     * @param password
     * @param name
     * @param lastName
     * @return 0: successful. 1: Invalid username or password. 2: Connection failed.
     */
    public int createAccount(String username, String password, String name, String lastName) {
        String uid = name.substring(0, 1).toLowerCase() + lastName.toLowerCase();
        LDAPAttributeSet attributeSet = new LDAPAttributeSet();
        attributeSet.add(new LDAPAttribute("cn", username));
        attributeSet.add(new LDAPAttribute("givenname", name));
        attributeSet.add(new LDAPAttribute("sn", lastName));
        attributeSet.add(new LDAPAttribute("userpassword", password));
        attributeSet.add(new LDAPAttribute("objectclass", "inetOrgPerson"));
        attributeSet.add(new LDAPAttribute("objectclass", "posixAccount"));        
//        attributeSet.add(new LDAPAttribute("objectclass", "top"));
//        attributeSet.add(new LDAPAttribute("gidnumber", "500"));
//        attributeSet.add(new LDAPAttribute("homedirectory", "/home/users/" + uid));
        attributeSet.add(new LDAPAttribute("uid", uid));        
        LDAPEntry newEntry = new LDAPEntry("cn=" + username + ",ou=" + organizationName + ",dc=arqsoft,dc=com", attributeSet);
        
        int status;
        if (makeConnection()) {
            try {
                lc.add(newEntry);
                status = 0;
                System.out.println("Successfully added user [" + username + "] to LDAP server.");
            } catch (LDAPException ex) {
                status = 1;
                System.out.println("Addition of user [" + username + "] to LDAP server was unsuccessful.");
                ex.printStackTrace();
            }
        } else {
            status = 2;
        }
        try {
            lc.disconnect();
        } catch (LDAPException ex) {
            System.out.println("Error al desconectarse del servidor LDAP");
        }        
        return status;
    }
    
}
