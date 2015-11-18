package BusinessLogic.Services;

import java.util.Date;

public class PurchaseInfo {
    
    private Date purchaseDate;
    private long totalAmount;
    private long totalPrice;
    
    public PurchaseInfo(Date purchaseDate, long totalPrice) {
        this.purchaseDate = purchaseDate;
        this.totalPrice = totalPrice;        
    }

    /**
     * @return the purchaseDate
     */
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * @param purchaseDate the purchaseDate to set
     */
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * @return the itemAmount
     */
    public long getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the totalPrice
     */
    public long getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }
    
}
