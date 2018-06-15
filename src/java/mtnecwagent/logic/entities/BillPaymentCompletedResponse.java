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
@Table(name = "billPaymentCompletedResponse")
@XmlRootElement

public class BillPaymentCompletedResponse implements Serializable{ 
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
    @Column(name = "providertransactionid", length = 50)
    @XmlElement(name = "providertransactionid")
    private String providertransactionid;
    
    @Column(name = "MoMtransactionid", nullable = false)
    @XmlElement(name = "MoMtransactionid")
    private String MoMtransactionid;     
    
     
    @Column(name = "request_time", length = 50)
    @XmlElement(name = "requestTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestTime;
    
    
    @Column(name = "newbalance", length = 100)
    @XmlElement(name = "newbalance")
    private Integer newbalance;

    @Size(max = 50)
    @Column(name = "status", length = 50)
    @XmlElement(name = "status")
    private String status;
    
    @Size(max = 100)
    @Column(name = "message", length = 100)
    @XmlElement(name = "message")
    private String message;

    /**
     * @return the providertransactionid
     */
    public String getProvidertransactionid() {
        return providertransactionid;
    }

    /**
     * @param providertransactionid the providertransactionid to set
     */
    public void setProvidertransactionid(String providertransactionid) {
        this.providertransactionid = providertransactionid;
    }

    /**
     * @return the MoMtransactionid
     */
    public String getMoMtransactionid() {
        return MoMtransactionid;
    }

    /**
     * @param MoMtransactionid the MoMtransactionid to set
     */
    public void setMoMtransactionid(String MoMtransactionid) {
        this.MoMtransactionid = MoMtransactionid;
    }

  

    /**
     * @return the newbalance
     */
    public Integer getNewbalance() {
        return newbalance;
    }

    /**
     * @param newbalance the newbalance to set
     */
    public void setNewbalance(Integer newbalance) {
        this.newbalance = newbalance;
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
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
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
