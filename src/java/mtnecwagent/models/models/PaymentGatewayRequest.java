/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.models.models;

import java.util.Map;

/**
 *
 * @author aimable
 */
public class PaymentGatewayRequest {
    
    private String transid;
    private Double amount;
    private String descr;
    private String accountIdAtSP;
    
    private Map<String,Object> parameters;

    public PaymentGatewayRequest() {
    }
    
    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameter) {
        this.parameters = parameter;
    }

    /**
     * @return the transid
     */
    public String getTransid() {
        return transid;
    }

    /**
     * @param transid the transid to set
     */
    public void setTransid(String transid) {
        this.transid = transid;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return the descr
     */
    public String getDescr() {
        return descr;
    }

    /**
     * @param descr the descr to set
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * @return the accountIdAtSP
     */
    public String getAccountIdAtSP() {
        return accountIdAtSP;
    }

    /**
     * @param accountIdAtSP the accountIdAtSP to set
     */
    public void setAccountIdAtSP(String accountIdAtSP) {
        this.accountIdAtSP = accountIdAtSP;
    }

}
