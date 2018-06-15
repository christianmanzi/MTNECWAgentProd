/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mtnecwagent.models.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manzi
 */
@XmlRootElement(name="COMMAND")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentConfirmationRequest2PaymentGateway { 
    @XmlElement(name="paymentSPId")
    private Integer paymentSPId;
    @XmlElement(name="paymentSPtransactionId")
    private String paymentSPtransactionId;
    @XmlElement(name="paymentSPaccountId")
    private String paymentSPaccountId;
    @XmlElement(name="paymentSPmerchantId")
    private String paymentSPmerchantId;
    @XmlElement(name="accountRef")
    private String accountRef;
    @XmlElement(name="paymentRef")
    private String paymentRef;
    @XmlElement(name="amount")
    private Integer amount;
    
    @XmlElement(name="agentId")
    private Integer agentId;
   
    
    
    /**
     * @return the accountRef
     */
    public String getAccountRef() {
        return accountRef;
    }
    
    /**
     * @param accountRef the accountRef to set
     */
    public void setAccountRef(String accountRef) {
        this.accountRef = accountRef;
    }
    
    /**
     * @return the paymentRef
     */
    public String getPaymentRef() {
        return paymentRef;
    }
    
    /**
     * @param paymentRef the paymentRef to set
     */
    public void setPaymentRef(String paymentRef) {
        this.paymentRef = paymentRef;
    }
    
    /**
     * @return the amount
     */
    public Integer getAmount() {
        return amount;
    }
    
    /**
     * @param amount the amount to set
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
   
    
    
    
       
   
    /**
     * @return the merchantId
     */
    public String getPaymentSPMerchantId() {
        return getPaymentSPmerchantId();
    }

    /**
     * @param paymentSPmerchantId the merchantId to set
     */
    public void setPaymentSPMerchantId(String paymentSPmerchantId) {
        this.setPaymentSPmerchantId(paymentSPmerchantId);
    }

    /**
     * @return the paymentSPtransactionId
     */
    public String getPaymentSPtransactionId() {
        return paymentSPtransactionId;
    }

    /**
     * @param paymentSPtransactionId the paymentSPtransactionId to set
     */
    public void setPaymentSPtransactionId(String paymentSPtransactionId) {
        this.paymentSPtransactionId = paymentSPtransactionId;
    }

    /**
     * @return the paymentSPId
     */
    public Integer getPaymentSPId() {
        return paymentSPId;
    }

    /**
     * @param paymentSPId the paymentSPId to set
     */
    public void setPaymentSPId(Integer paymentSPId) {
        this.paymentSPId = paymentSPId;
    }

    /**
     * @return the paymentSPaccountId
     */
    public String getPaymentSPaccountId() {
        return paymentSPaccountId;
    }

    /**
     * @param paymentSPaccountId the paymentSPaccountId to set
     */
    public void setPaymentSPaccountId(String paymentSPaccountId) {
        this.paymentSPaccountId = paymentSPaccountId;
    }

    /**
     * @return the paymentSPmerchantId
     */
    public String getPaymentSPmerchantId() {
        return paymentSPmerchantId;
    }

    /**
     * @param paymentSPmerchantId the paymentSPmerchantId to set
     */
    public void setPaymentSPmerchantId(String paymentSPmerchantId) {
        this.paymentSPmerchantId = paymentSPmerchantId;
    }

    /**
     * @return the agentId
     */
    public Integer getAgentId() {
        return agentId;
    }

    /**
     * @param agentId the agentId to set
     */
    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    
    
}
