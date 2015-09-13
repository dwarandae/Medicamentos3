package DataAccess.Entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    
    @Column(name = "item_amount")
    private int amount;
    
    //The price of the item is the prices of the drug! (is not static)
    @ManyToOne(fetch=FetchType.LAZY)
    private Drug drug;

    public Item() {
    }

    public Item(int amount, Drug drug) {
        this.amount = amount;
        this.drug = drug;
    }
    
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.itemId);
        hash = 97 * hash + this.amount;
        hash = 97 * hash + Objects.hashCode(this.drug);
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.itemId, other.itemId)) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        if (!Objects.equals(this.drug, other.drug)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "itemId=" + itemId + ", amount=" + amount + ", drug=" + drug + '}';
    }
    
}
