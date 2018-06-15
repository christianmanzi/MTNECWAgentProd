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
@XmlRootElement(name = "COMMAND")
@XmlAccessorType(XmlAccessType.FIELD)
public class MmCenterSubResponse {

    @XmlElement(name = "AGENTID")
    private String agentId;

    @XmlElement(name = "AGENTTXNID")
    private String agentTransactionId;

    @XmlElement(name = "ERRORCODE")
    private String errorCode;

    @XmlElement(name = "ERRORDESC")
    private String errorDesc;

    @XmlElement(name = "STATUS")
    private String status;

    @XmlElement(name = "CONTENT")
    private String content;

    public MmCenterSubResponse() {
    }
    
    public MmCenterSubResponse(String agentId, String agentTransactionId, String errorCode, String errorDesc, String status, String content) {
        this.agentId = agentId;
        this.agentTransactionId = agentTransactionId;
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.status = status;
        this.content = content;
    }
    
    

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentTransactionId() {
        return agentTransactionId;
    }

    public void setAgentTransactionId(String agentTransactionId) {
        this.agentTransactionId = agentTransactionId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    

}
