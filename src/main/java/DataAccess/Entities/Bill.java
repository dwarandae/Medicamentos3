package DataAccess.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "bill_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;

    @Column(name = "bill_date")
    private Date billDate;
    
    //This will change
    @Column(name = "bill_payment_method")
    private String paymentMethod;
    
    //TO-DO: ERROR?
    @OneToOne(mappedBy = "purchase")
    private Purchase purchase;

    public Bill() {
    }

    public Bill(Date billDate, String paymentMethod, Purchase purchase) {
        this.billDate = billDate;
        this.paymentMethod = paymentMethod;
        this.purchase = purchase;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.billId);
        hash = 97 * hash + Objects.hashCode(this.billDate);
        hash = 97 * hash + Objects.hashCode(this.paymentMethod);
        hash = 97 * hash + Objects.hashCode(this.purchase);
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
        final Bill other = (Bill) obj;
        if (!Objects.equals(this.billId, other.billId)) {
            return false;
        }
        if (!Objects.equals(this.billDate, other.billDate)) {
            return false;
        }
        if (!Objects.equals(this.paymentMethod, other.paymentMethod)) {
            return false;
        }
        if (!Objects.equals(this.purchase, other.purchase)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bill{" + "billId=" + billId + ", billDate=" + billDate + ", paymentMethod=" + paymentMethod + ", purchase=" + purchase + '}';
    }
    
    
}
