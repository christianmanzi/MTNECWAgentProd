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
 * @author aimable
 */
@XmlRootElement(name="COMMAND")
@XmlAccessorType(XmlAccessType.FIELD)
public class RequestPaymentResponse {   
    
    @XmlElement(name="RESPONDERSTATUS")
    private Integer responderStatus;
    
    @XmlElement(name="REQUESTSTATUS")
    private String requestStatus;
    
    @XmlElement(name="REQUESTSTATUSDESC")
    private String requestStatusDesc;

    public RequestPaymentResponse() {
    }

   

    

    /**
     * @return the requestStatusDesc
     */
    public String getRequestStatusDesc() {
        return requestStatusDesc;
    }

    /**
     * @param requestStatusDesc the requestStatusDesc to set
     */
    public void setRequestStatusDesc(String requestStatusDesc) {
        this.requestStatusDesc = requestStatusDesc;
    }

    /**
     * @return the responderStatus
     */
    public Integer getResponderStatus() {
        return responderStatus;
    }

    /**
     * @param responderStatus the responderStatus to set
     */
    public void setResponderStatus(Integer responderStatus) {
        this.responderStatus = responderStatus;
    }

    /**
     * @return the requestStatus
     */
    public String getRequestStatus() {
        return requestStatus;
    }

    /**
     * @param requestStatus the requestStatus to set
     */
    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

   
}
