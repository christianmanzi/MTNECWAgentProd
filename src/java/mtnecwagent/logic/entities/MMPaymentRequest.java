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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author manzi
 */
@Entity
@Table(name = "mmPaymentsRequests")
public class MMPaymentRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProcessingNumber",length = 100, nullable = false)
    @XmlElement(name = "ProcessingNumber")
    private String ProcessingNumber;  
    
    @Size(max = 50)
    @Column(name = "spId", length = 50)
    @XmlElement(name = "spId")
    private String spId;
    
    @Size(max = 50)
    @Column(name = "requestTimeStamp", length = 50)
    @XmlElement(name = "requestTimeStamp")
    private String requestTimeStamp;
    
    @Size(max = 100)
    @Column(name = "spPassword", length = 100)
    @XmlElement(name = "spPassword")
    private String spPassword;

    @Size(max = 50)
    @Column(name = "serviceId", length = 50)
    @XmlElement(name = "serviceId")
    private String serviceId;

    @Size(max = 10)
    @Column(name = "DueAmount", length = 10)
    @XmlElement(name = "DueAmount")
    private String DueAmount;
     
     @Size(max = 50)
    @Column(name = "MSISDNNum", length = 50)
    @XmlElement(name = "MSISDNNum")
    private String MSISDNNum;
         
      @Size(max = 50)
    @Column(name = "AcctRef", length = 50)
    @XmlElement(name = "AcctRef")
    private String AcctRef;
     
     @Size(max = 50)
    @Column(name = "AcctBalance", length = 50)
    @XmlElement(name = "AcctBalance")
    private String AcctBalance;
     
     @Size(max = 50)
    @Column(name = "MinDueAmount", length = 50)
    @XmlElement(name = "MinDueAmount")
    private String MinDueAmount;
    
      @Size(max = 255)
    @Column(name = "Narration", length = 255)
    @XmlElement(name = "Narration")
    private String Narration;
     
     @Size(max = 50)
    @Column(name = "PrefLang", length = 50)
    @XmlElement(name = "PrefLang")
    private String PrefLang;
     
      @Size(max = 50)
    @Column(name = "OpCoID", length = 50)
    @XmlElement(name = "OpCoID")
    private String OpCoID;



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getProcessingNumber() != null ? getProcessingNumber().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MMPaymentRequest)) {
            return false;
        }
        MMPaymentRequest other = (MMPaymentRequest) object;
        if ((this.getProcessingNumber() == null && other.getProcessingNumber() != null) || (this.getProcessingNumber() != null && !this.ProcessingNumber.equals(other.ProcessingNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mtnecwagent.logic.entities.MMPaymentRequest[ ProcessingNumber=" + getProcessingNumber() + " ]";
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
     * @return the spId
     */
    public String getSpId() {
        return spId;
    }

    /**
     * @param spId the spId to set
     */
    public void setSpId(String spId) {
        this.spId = spId;
    }

    /**
     * @return the requestTimeStamp
     */
    public String getRequestTimeStamp() {
        return requestTimeStamp;
    }

    /**
     * @param requestTimeStamp the requestTimeStamp to set
     */
    public void setRequestTimeStamp(String requestTimeStamp) {
        this.requestTimeStamp = requestTimeStamp;
    }

    /**
     * @return the spPassword
     */
    public String getSpPassword() {
        return spPassword;
    }

    /**
     * @param spPassword the spPassword to set
     */
    public void setSpPassword(String spPassword) {
        this.spPassword = spPassword;
    }

    /**
     * @return the serviceId
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId the serviceId to set
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return the DueAmount
     */
    public String getDueAmount() {
        return DueAmount;
    }

    /**
     * @param DueAmount the DueAmount to set
     */
    public void setDueAmount(String DueAmount) {
        this.DueAmount = DueAmount;
    }

    /**
     * @return the MSISDNNum
     */
    public String getMSISDNNum() {
        return MSISDNNum;
    }

    /**
     * @param MSISDNNum the MSISDNNum to set
     */
    public void setMSISDNNum(String MSISDNNum) {
        this.MSISDNNum = MSISDNNum;
    }

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
     * @return the AcctBalance
     */
    public String getAcctBalance() {
        return AcctBalance;
    }

    /**
     * @param AcctBalance the AcctBalance to set
     */
    public void setAcctBalance(String AcctBalance) {
        this.AcctBalance = AcctBalance;
    }

    /**
     * @return the MinDueAmount
     */
    public String getMinDueAmount() {
        return MinDueAmount;
    }

    /**
     * @param MinDueAmount the MinDueAmount to set
     */
    public void setMinDueAmount(String MinDueAmount) {
        this.MinDueAmount = MinDueAmount;
    }

    /**
     * @return the Narration
     */
    public String getNarration() {
        return Narration;
    }

    /**
     * @param Narration the Narration to set
     */
    public void setNarration(String Narration) {
        this.Narration = Narration;
    }

    /**
     * @return the PrefLang
     */
    public String getPrefLang() {
        return PrefLang;
    }

    /**
     * @param PrefLang the PrefLang to set
     */
    public void setPrefLang(String PrefLang) {
        this.PrefLang = PrefLang;
    }

    /**
     * @return the OpCoID
     */
    public String getOpCoID() {
        return OpCoID;
    }

    /**
     * @param OpCoID the OpCoID to set
     */
    public void setOpCoID(String OpCoID) {
        this.OpCoID = OpCoID;
    }
    
}
