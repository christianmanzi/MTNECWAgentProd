/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.models.models;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Manzi
 * 
 */

 // <ns3:requestPaymentCompleted xmlns:ns3="http://www.csapi.org/schema/momopayment/local/v1_0">
////         <ns3:ProcessingNumber>2713500010003</ns3:ProcessingNumber>
////         <ns3:MOMTransactionID>2713500010002</ns3:MOMTransactionID>
////         <ns3:StatusCode>01</ns3:StatusCode>
////         <ns3:StatusDesc>This is a respone Message!</ns3:StatusDesc>
////         <ns3:ThirdPartyAcctRef>http://www.qwe.com</ns3:ThirdPartyAcctRef>
////      </ns3:requestPaymentCompleted>

@XmlRootElement(name = "requestPaymentCompleted")

@XmlAccessorType(XmlAccessType.FIELD)
public class RequestPaymentCompleted implements Serializable{
   
    @XmlElement(name = "ProcessingNumber")
    private String ProcessingNumber;
    
    @XmlElement(name = "MOMTransactionID")
    private String MOMTransactionID;
    
   
    @XmlElement(name = "StatusCode")
    private String StatusCode;
    
    
    @XmlElement(name = "StatusDesc")
    private String StatusDesc;
    
    
    @XmlElement(name = "ThirdPartyAcctRef")
    private String ThirdPartyAcctRef;
    
    public RequestPaymentCompleted() {
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
     * @return the MOMTransactionID
     */
    public String getMOMTransactionID() {
        return MOMTransactionID;
    }

    /**
     * @param MOMTransactionID the MOMTransactionID to set
     */
    public void setMOMTransactionID(String MOMTransactionID) {
        this.MOMTransactionID = MOMTransactionID;
    }

    /**
     * @return the StatusCode
     */
    public String getStatusCode() {
        return StatusCode;
    }

    /**
     * @param StatusCode the StatusCode to set
     */
    public void setStatusCode(String StatusCode) {
        this.StatusCode = StatusCode;
    }

    /**
     * @return the StatusDesc
     */
    public String getStatusDesc() {
        return StatusDesc;
    }

    /**
     * @param StatusDesc the StatusDesc to set
     */
    public void setStatusDesc(String StatusDesc) {
        this.StatusDesc = StatusDesc;
    }

    /**
     * @return the ThirdPartyAcctRef
     */
    public String getThirdPartyAcctRef() {
        return ThirdPartyAcctRef;
    }

    /**
     * @param ThirdPartyAcctRef the ThirdPartyAcctRef to set
     */
    public void setThirdPartyAcctRef(String ThirdPartyAcctRef) {
        this.ThirdPartyAcctRef = ThirdPartyAcctRef;
    }

     @Override
    public int hashCode() {
        int hash = 0;
        hash += (!ThirdPartyAcctRef.isEmpty() ? ThirdPartyAcctRef.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestPaymentCompleted)) {
            return false;
        }
        RequestPaymentCompleted other = (RequestPaymentCompleted) object;
        return !((this.ThirdPartyAcctRef.isEmpty() && !other.ThirdPartyAcctRef.isEmpty()) || (!this.ThirdPartyAcctRef.isEmpty() && !this.ThirdPartyAcctRef.equals(other.ThirdPartyAcctRef))); 
    }

    @Override
    public String toString() {
        return "entities.mmRequestPaymentCompleted[ ThirdPartyAcctRef=" + ThirdPartyAcctRef + " ]";
    }
  
    
    
}

