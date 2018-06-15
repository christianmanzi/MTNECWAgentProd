/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mtnecwagent.models.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="COMMAND")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgentPaymentRequestResponse implements Serializable {
    
    @Column(name = "status_code", nullable = false)
    @XmlElement(name="STATUSCODE")
    private String statuscode;
    
    
    @Column(name = "status_desc", nullable = false)
    @XmlElement(name="DESCR")
    private String statusdesc;
    
    @Column(name = "transactionId", nullable = false)
    @XmlElement(name="TRANSID")
    private String transactionId;
    
    @Column(name = "sp_transaction_id", nullable = false)
    @XmlElement(name="SPTRANSID")
    private String spTransactionId;
    
    @Column(name = "this_response_status_code", nullable = false)
    private int thisResponseStatusCode;
    
    
    
    
    
    /**
     * @return the statuscode
     */
    public String getStatuscode() {
        return statuscode;
    }
    
    /**
     * @param statuscode the statuscode to set
     */
    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }
    
    /**
     * @return the statusdesc
     */
    public String getStatusdesc() {
        return statusdesc;
    }
    
    /**
     * @param statusdesc the statusdesc to set
     */
    public void setStatusdesc(String statusdesc) {
        this.statusdesc = statusdesc;
    }

    /**
     * @return the transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return the spTransactionId
     */
    public String getSpTransactionId() {
        return spTransactionId;
    }

    /**
     * @param spTransactionId the spTransactionId to set
     */
    public void setSpTransactionId(String spTransactionId) {
        this.spTransactionId = spTransactionId;
    }

    /**
     * @return the thisResponseStatusCode
     */
    public int getThisResponseStatusCode() {
        return thisResponseStatusCode;
    }

    /**
     * @param thisResponseStatusCode the thisResponseStatusCode to set
     */
    public void setThisResponseStatusCode(int thisResponseStatusCode) {
        this.thisResponseStatusCode = thisResponseStatusCode;
    }
    
    
}
