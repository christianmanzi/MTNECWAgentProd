/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.models.txstatusmodels;

/**
 *
 * @author christian
 */
public class TransactionStatusResponse {
    private String transactionid;
    private String status;
    private String errorcode;

    /**
     * @return the transactionid
     */
    public String getTransactionid() {
        return transactionid;
    }

    /**
     * @param transactionid the transactionid to set
     */
    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the errorcode
     */
    public String getErrorcode() {
        return errorcode;
    }

    /**
     * @param errorcode the errorcode to set
     */
    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }
    
}
