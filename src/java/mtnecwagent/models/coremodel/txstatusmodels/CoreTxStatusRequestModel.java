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
public class CoreTxStatusRequestModel {
    private String transactionId;
    private String paymentSpid;
    private String spCustomerAccountId;
    private String userName;
    private String password;
    private String merchantAccountId;

    /**
     * @return the transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return the paymentSpid
     */
    public String getPaymentSpid() {
        return paymentSpid;
    }

    /**
     * @param paymentSpid the paymentSpid to set
     */
    public void setPaymentSpid(String paymentSpid) {
        this.paymentSpid = paymentSpid;
    }

    /**
     * @return the spCustomerAccountId
     */
    public String getSpCustomerAccountId() {
        return spCustomerAccountId;
    }

    /**
     * @param spCustomerAccountId the spCustomerAccountId to set
     */
    public void setSpCustomerAccountId(String spCustomerAccountId) {
        this.spCustomerAccountId = spCustomerAccountId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the merchantAccountId
     */
    public String getMerchantAccountId() {
        return merchantAccountId;
    }

    /**
     * @param merchantAccountId the merchantAccountId to set
     */
    public void setMerchantAccountId(String merchantAccountId) {
        this.merchantAccountId = merchantAccountId;
    }
}
