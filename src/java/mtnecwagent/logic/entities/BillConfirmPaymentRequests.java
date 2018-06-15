/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.logic.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aimable
 */
@Entity
@Table(name = "billConfirmPaymentRequests")
@XmlRootElement

public class BillConfirmPaymentRequests implements Serializable{ 
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
    @Column(name = "ProcessingNumber", length = 50)
    @XmlElement(name = "ProcessingNumber")
    private String ProcessingNumber;
    
    @Column(name = "AcctRef", nullable = false)
    @XmlElement(name = "AcctRef")
    private String AcctRef;     
    
   
    @Column(name = "request_time", length = 50)
    @XmlElement(name = "requestTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestTime;
    
    
    @Column(name = "RequestAmount", length = 100)
    @XmlElement(name = "RequestAmount")
    private Integer RequestAmount;

    @Size(max = 50)
    @Column(name = "MOMAcctNum", length = 50)
    @XmlElement(name = "MOMAcctNum")
    private String MOMAcctNum;
   

    /**
     * @return the AcctRef
     */
    public String getAcctRef() {
        return AcctRef;
    }

    /**
     * @param AcctRef the AcctRef to set
     */
    public void setAcctRef(String AcctRef) {
        this.AcctRef = AcctRef;
    }

    /**
     * @return the ProcessingNumber
     */
    public String getProcessingNumber() {
        return ProcessingNumber;
    }

    /**
     * @param ProcessingNumber the ProcessingNumber to set
     */
    public void setProcessingNumber(String ProcessingNumber) {
        this.ProcessingNumber = ProcessingNumber;
    }

   

    /**
     * @return the RequestAmount
     */
    public Integer getRequestAmount() {
        return RequestAmount;
    }

    /**
     * @param RequestAmount the RequestAmount to set
     */
    public void setRequestAmount(Integer RequestAmount) {
        this.RequestAmount = RequestAmount;
    }

    /**
     * @return the MOMAcctNum
     */
    public String getMOMAcctNum() {
        return MOMAcctNum;
    }

    /**
     * @param MOMAcctNum the MOMAcctNum to set
     */
    public void setMOMAcctNum(String MOMAcctNum) {
        this.MOMAcctNum = MOMAcctNum;
    }

    /**
     * @return the requestTime
     */
    public Date getRequestTime() {
        return requestTime;
    }

    /**
     * @param requestTime the requestTime to set
     */
    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

}
