/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.logic.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aimable
 */
@Entity
@Table(name = "billPaymentAccount")
@XmlRootElement

public class BillPaymentAccount implements Serializable{ 
     private static final long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "accountId", length = 50)
    @XmlElement(name = "accountId")
    private String accountId;
    
    @Column(name = "due_amount", nullable = false)
    @XmlElement(name = "dueAmount")
    private Integer dueAmount;     
    
    
    @Column(name = "paid", length = 50)
    @XmlElement(name = "paid")
    private Integer paid;
    
    
    @Column(name = "processing_duration", length = 100)
    @XmlElement(name = "processingDuration")
    private Integer processingDuration;

    /**
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the dueAmount
     */
    public Integer getDueAmount() {
        return dueAmount;
    }

    /**
     * @param dueAmount the dueAmount to set
     */
    public void setDueAmount(Integer dueAmount) {
        this.dueAmount = dueAmount;
    }

    /**
     * @return the paid
     */
    public Integer getPaid() {
        return paid;
    }

    /**
     * @param paid the paid to set
     */
    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    /**
     * @return the processingDuration
     */
    public Integer getProcessingDuration() {
        return processingDuration;
    }

    /**
     * @param processingDuration the processingDuration to set
     */
    public void setProcessingDuration(Integer processingDuration) {
        this.processingDuration = processingDuration;
    }

    
    
}
