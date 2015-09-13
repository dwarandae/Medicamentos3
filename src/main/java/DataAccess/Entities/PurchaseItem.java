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
@Table(name = "purchase_item")
public class PurchaseItem implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "purchase_item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchaseItemId;
    
    @Column(name = "purchase_item_amount")
    private int amount;
    
    @Column(name = "purchase_price")
    private long price;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Drug drug;

    public PurchaseItem() {
    }

    public PurchaseItem(int amount, long price, Drug drug) {
        this.amount = amount;
        this.price = price;
        this.drug = drug;
    }

    public Long getPurchaseItemId() {
        return purchaseItemId;
    }

    public void setPurchaseItemId(Long purchaseItemId) {
        this.purchaseItemId = purchaseItemId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.purchaseItemId);
        hash = 79 * hash + this.amount;
        hash = 79 * hash + (int) (this.price ^ (this.price >>> 32));
        hash = 79 * hash + Objects.hashCode(this.drug);
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
        final PurchaseItem other = (PurchaseItem) obj;
        if (!Objects.equals(this.purchaseItemId, other.purchaseItemId)) {
            return false;
        }
        if (this.amount != other.amount) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (!Objects.equals(this.drug, other.drug)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PurchaseItem{" + "purchaseItemId=" + purchaseItemId + ", amount=" + amount + ", price=" + price + ", drug=" + drug + '}';
    }
   
}
