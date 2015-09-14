package DataAccess.Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer extends Account implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "customer_id", unique = true)
    private String customerId;
    
    @NotNull
    @Column(name = "is_eps_customer")
    private boolean epsCustomer;
    
    //A Customer have a Shopping Cart (may be empty)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;
    
    //A Customer can have 0..* Purcharses (unidirectional)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Purchase> purchases;

    public Customer() {
    }

    public Customer(String name, String lastName, String username, String password, String email, String customerId, boolean epsCustomer) {
        super(name, lastName, username, password, email);
        this.customerId = customerId;
        this.epsCustomer = epsCustomer;
        shoppingCart = new ShoppingCart(); /*All customer is created with a empty shopping cart */
    }
   
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public boolean isEpsCustomer() {
        return epsCustomer;
    }

    public void setEpsCustomer(boolean epsCustomer) {
        this.epsCustomer = epsCustomer;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.customerId);
        hash = 67 * hash + (this.epsCustomer ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.shoppingCart);
        hash = 67 * hash + Objects.hashCode(this.purchases);
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.customerId, other.customerId)) {
            return false;
        }
        if (this.epsCustomer != other.epsCustomer) {
            return false;
        }
        if (!Objects.equals(this.shoppingCart, other.shoppingCart)) {
            return false;
        }
        if (!Objects.equals(this.purchases, other.purchases)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", epsCustomer=" + epsCustomer + ", shoppingCart=" + shoppingCart + ", purchases=" + purchases + '}';
    }
    
}
