package DataAccess.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    //This will change... enum, maybe?
    @Column(name = "bill_payment_method")
    private String paymentMethod;
    
    public Bill() {
    }

    public Bill(Date billDate, String paymentMethod) {
        this.billDate = billDate;
        this.paymentMethod = paymentMethod;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.billId);
        hash = 97 * hash + Objects.hashCode(this.billDate);
        hash = 97 * hash + Objects.hashCode(this.paymentMethod);
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
        return true;
    }

    @Override
    public String toString() {
        return "Bill{" + "billId=" + billId + ", billDate=" + billDate + ", paymentMethod=" + paymentMethod + '}';
    }
   
}
