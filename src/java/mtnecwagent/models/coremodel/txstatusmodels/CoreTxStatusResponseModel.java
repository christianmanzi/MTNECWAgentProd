/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.models.coremodel.txstatusmodels;

/**
 *
 * @author manzi
 */
public class CoreTxStatusResponseModel { 
    private String paymentSpTransactionid;
    private String status;
    private String statusDesc;
    private String errorcode;
    private String errorDesc;

   
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
     * @return the statusDesc
     */
    public String getStatusDesc() {
        return statusDesc;
    }

    /**
     * @param statusDesc the statusDesc to set
     */
    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
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

    /**
     * @return the errorDesc
     */
    public String getErrorDesc() {
        return errorDesc;
    }

    /**
     * @param errorDesc the errorDesc to set
     */
    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    /**
     * @return the paymentSpTransactionid
     */
    public String getPaymentSpTransactionid() {
        return paymentSpTransactionid;
    }

    /**
     * @param paymentSpTransactionid the paymentSpTransactionid to set
     */
    public void setPaymentSpTransactionid(String paymentSpTransactionid) {
        this.paymentSpTransactionid = paymentSpTransactionid;
    }

   
}
