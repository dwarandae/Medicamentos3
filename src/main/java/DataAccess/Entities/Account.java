package DataAccess.Entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Account implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "account_name")
    private String name;
    
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "account_lastname")
    private String lastName;
    
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "account_username", unique = true)
    private String username;
    
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "account_password")
    private String password;
    
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "account_email", unique = true)
    private String email;

    public Account() {
    }

    public Account(String name, String lastName, String username, String password, String email) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.accountId);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.lastName);
        hash = 67 * hash + Objects.hashCode(this.username);
        hash = 67 * hash + Objects.hashCode(this.password);
        hash = 67 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.accountId, other.accountId)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Account{" + "accountId=" + accountId + ", name=" + name + ", lastName=" + lastName + ", username=" + username + ", password=" + password + ", email=" + email + '}';
    }
 
}
