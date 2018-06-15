/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.models.txstatusmodels;

/**
 *
 * @author manzi
 */
public class TransactionStatusRequest {
    private String userName;
    private String password;
    private String spCustomerAccountId;
    private String txReference;

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
     * @return the txReference
     */
    public String getTxReference() {
        return txReference;
    }

    /**
     * @param txReference the txReference to set
     */
    public void setTxReference(String txReference) {
        this.txReference = txReference;
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
}
