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
 * @author aimable
 */
@XmlRootElement(name = "COMMAND")
@XmlAccessorType(XmlAccessType.FIELD)
public class MmCenterSubRequest implements Serializable {

    @XmlElement(name = "AGENTID")
    private String agentId;

    @XmlElement(name = "AGENTTXNID")
    private String agentTransactionId;

    @XmlElement(name = "SPID")
    private String serviceProviderId;

    @XmlElement(name = "AMOUNT")
    private String amount;

    @XmlElement(name = "CUSTID")
    private String customerId;

    @XmlElement(name = "REQTYPE")
    private String requestType;

    @XmlElement(name = "DESCR")
    private String description;

    public MmCenterSubRequest(String agentId, String agentTransactionId, String serviceProviderId, String amount, String customerId, String requestType, String description) {
        this.agentId = agentId;
        this.agentTransactionId = agentTransactionId;
        this.serviceProviderId = serviceProviderId;
        this.amount = amount;
        this.customerId = customerId;
        this.requestType = requestType;
        this.description = description;
    }

    public MmCenterSubRequest() {
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

    public String getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(String serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MmCenterRequest{" + "agentId=" + agentId + ", agentTransactionId=" + agentTransactionId + ", serviceProviderId=" + serviceProviderId + ", amount=" + amount + ", customerId=" + customerId + ", requestType=" + requestType + ", description=" + description + '}';
    }

}
