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
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author manzi
 *
 * // * <?xml version="1.0" encoding="utf-8" ?>
 * //<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
 * //   <soapenv:Header>
 * //      <ns1:NotifySOAPHeader xmlns:ns1="http://www.huawei.com.cn/schema/common/v2_1">
 * //         <ns2:traceUniqueID xmlns:ns2="http://www.csapi.org/schema/momopayment/local/v1_0">504021503411410281818220013006</ns2:traceUniqueID>
 * //      </ns1:NotifySOAPHeader>
 * //   </soapenv:Header>
 * //   <soapenv:Body>
 * //      <ns3:requestPaymentCompleted xmlns:ns3="http://www.csapi.org/schema/momopayment/local/v1_0">
 * //         <ns3:ProcessingNumber>2713500010003</ns3:ProcessingNumber>
 * //         <ns3:MOMTransactionID>2713500010002</ns3:MOMTransactionID>
 * //         <ns3:StatusCode>01</ns3:StatusCode>
 * //         <ns3:StatusDesc>This is a respone Message!</ns3:StatusDesc>
 * //         <ns3:ThirdPartyAcctRef>http://www.qwe.com</ns3:ThirdPartyAcctRef>
 * //      </ns3:requestPaymentCompleted>
 * //   </soapenv:Body>
 * //</soapenv:Envelope>
 * 
 */
@Entity
@Table(name = "mmRequestPaymentResponses")
public class MMRequestPaymentResponse implements Serializable {
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
    @Column(name = "ProcessingNumber",length = 100, nullable = false)
    @XmlElement(name = "ProcessingNumber")
    private String ProcessingNumber;
    
    @Column(name = "firstResponseTime", nullable = false)
    @XmlElement(name = "firstResponseTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstResponseTime;
    
    @Column(name = "lastResponseTime", nullable = false)
    @XmlElement(name = "lastResponseTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastResponseTime;
    
    @Column(name = "MOMTransactionID")
    @XmlElement(name = "MOMTransactionID")
    private String MOMTransactionID;
    
    @Column(name = "lastStatusCode")
    @XmlElement(name = "lastStatusCode")
    private String lastStatusCode;
    
    @Column(name = "StatusCode")
    @XmlElement(name = "StatusCode")
    private String StatusCode;
    
    @Column(name = "StatusDesc")
    @XmlElement(name = "StatusDesc")
    private String StatusDesc;
    
    @Column(name = "ThirdPartyAcctRef")
    @XmlElement(name = "ThirdPartyAcctRef")
    private String ThirdPartyAcctRef;
    
    
    public MMRequestPaymentResponse () {
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (!ProcessingNumber.isEmpty() ? getProcessingNumber().hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MMRequestPaymentResponse)) {
            return false;
        }
        MMRequestPaymentResponse other = (MMRequestPaymentResponse) object;
        return !((!this.ProcessingNumber.isEmpty() && !other.ProcessingNumber.isEmpty()) || (!this.ProcessingNumber.isEmpty() && !this.ProcessingNumber.equals(other.ProcessingNumber)));
        
    }
    
    @Override
    public String toString() {
        return "com.oltranz.mmagent.beans.mmRequestPaymentCompleted[ id=" + getProcessingNumber() + " ]";
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
     * @return the lastStatusCode
     */
    public String getLastStatusCode() {
        return lastStatusCode;
    }
    
    /**
     * @param lastStatusCode the lastStatusCode to set
     */
    public void setLastStatusCode(String lastStatusCode) {
        this.lastStatusCode = lastStatusCode;
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

    /**
     * @return the firstResponseTime
     */
    public Date getFirstResponseTime() {
        return firstResponseTime;
    }

    /**
     * @param firstResponseTime the firstResponseTime to set
     */
    public void setFirstResponseTime(Date firstResponseTime) {
        this.firstResponseTime = firstResponseTime;
    }

    /**
     * @return the lastResponseTime
     */
    public Date getLastResponseTime() {
        return lastResponseTime;
    }

    /**
     * @param lastResponseTime the lastResponseTime to set
     */
    public void setLastResponseTime(Date lastResponseTime) {
        this.lastResponseTime = lastResponseTime;
    }
    
}
