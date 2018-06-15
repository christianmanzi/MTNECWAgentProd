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
public class PaymentConfirmationResponseFromPaymentGateway {
    @XmlElement(name="SPtransactionId")
    private String SPtransactionId;
    @XmlElement(name="statusId")
    private String statusId;
    @XmlElement(name="statusDesc")
    private String statusDesc;
    @XmlElement(name="balance")
    private Integer balance;

    /**
     * @return the SPtransactionId
     */
    public String getSPtransactionId() {
        return SPtransactionId;
    }

    /**
     * @param SPtransactionId the SPtransactionId to set
     */
    public void setSPtransactionId(String SPtransactionId) {
        this.SPtransactionId = SPtransactionId;
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
     * @return the balance
     */
    public Integer getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    /**
     * @return the statusId
     */
    public String getStatusId() {
        return statusId;
    }

    /**
     * @param statusId the statusId to set
     */
    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }
   
}
