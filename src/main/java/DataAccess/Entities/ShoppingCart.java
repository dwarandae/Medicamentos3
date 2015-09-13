package DataAccess.Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "shopping_cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shoppingCartId;
    
    //TO-DO: ERROR?
    @OneToOne(mappedBy = "shopping_cart")
    private Customer customer;
    
    //A ShoppingCart can have 0..* Items
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Item> items;

    public ShoppingCart() {
    }

    public ShoppingCart(List<Item> items) {
        this.items = items;
    }

    public ShoppingCart(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.shoppingCartId);
        hash = 29 * hash + Objects.hashCode(this.customer);
        hash = 29 * hash + Objects.hashCode(this.items);
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
        final ShoppingCart other = (ShoppingCart) obj;
        if (!Objects.equals(this.shoppingCartId, other.shoppingCartId)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.items, other.items)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "shoppingCartId=" + shoppingCartId + ", customer=" + customer + ", items=" + items + '}';
    }
    
}
