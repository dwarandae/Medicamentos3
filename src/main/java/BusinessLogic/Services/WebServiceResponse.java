package BusinessLogic.Services;

import java.util.ArrayList;
import java.util.List;

public class WebServiceResponse {
    
    private boolean success = true;
    private String statusMessage = "Transacción exitosa.";
    private List<PurchaseInfo> purchasesData = new ArrayList<>();

    /**
     * @return the success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * @param success the success to set
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * @return the statusMessage
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * @param statusMessage the statusMessage to set
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    /**
     * @return the purchasesData
     */
    public List<PurchaseInfo> getPurchasesData() {
        return purchasesData;
    }

    /**
     * @param purchasesData the purchasesData to set
     */
    public void setPurchasesData(List<PurchaseInfo> purchasesData) {
        this.purchasesData = purchasesData;
    }
    
}