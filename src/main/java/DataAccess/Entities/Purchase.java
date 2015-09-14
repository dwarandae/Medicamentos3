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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase")
public class Purchase implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long purchaseId;
    
    @Column(name = "purchase_total_price")
    private Long totalPrice;
    
    //A purchase have one and only one bill
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "bill_id")
    private Bill bill;
            
    //A purchase have 1..* items
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<PurchaseItem> purchaseItems;

    public Purchase() {
    }

    public Purchase(Long totalPrice, Bill bill, List<PurchaseItem> purchaseItems) {
        this.totalPrice = totalPrice;
        this.bill = bill;
        this.purchaseItems = purchaseItems;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public List<PurchaseItem> getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(List<PurchaseItem> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.purchaseId);
        hash = 67 * hash + Objects.hashCode(this.totalPrice);
        hash = 67 * hash + Objects.hashCode(this.bill);
        hash = 67 * hash + Objects.hashCode(this.purchaseItems);
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
        final Purchase other = (Purchase) obj;
        if (!Objects.equals(this.purchaseId, other.purchaseId)) {
            return false;
        }
        if (!Objects.equals(this.totalPrice, other.totalPrice)) {
            return false;
        }
        if (!Objects.equals(this.bill, other.bill)) {
            return false;
        }
        if (!Objects.equals(this.purchaseItems, other.purchaseItems)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Purchase{" + "purchaseId=" + purchaseId + ", totalPrice=" + totalPrice + ", bill=" + bill + ", purchaseItems=" + purchaseItems + '}';
    }  
    
}
