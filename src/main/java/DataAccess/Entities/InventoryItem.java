package DataAccess.Entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory_item")
public class InventoryItem implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "inventory_item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long inventoryItemId;
    
    @Column(name = "inventory_item_amount")
    private int amount;

    public InventoryItem() {
    }

    public InventoryItem(int amount) {
        this.amount = amount;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.inventoryItemId);
        hash = 37 * hash + this.amount;
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
        final InventoryItem other = (InventoryItem) obj;
        if (!Objects.equals(this.inventoryItemId, other.inventoryItemId)) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        return true;
    }  
    
}
