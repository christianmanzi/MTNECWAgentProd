/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.models.models;

import java.util.LinkedHashMap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aimable
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MMBalanceRequest {
// <element name="accountIdentifier" type="xsd:string"/>
//      <element name="serviceID" type="xsd:string"/>
//      <element name="localeLanguage" type="xsd:string"/>
//      <element name="localeCountry" type="xsd:string"/>
//      <element name="appVersion" type="xsd:string"/>
    @XmlElement(name = "accountIdentifier")
    private String accountIdentifier;
    
    @XmlElement(name = "serviceID")
    private String serviceID;
    
    @XmlElement(name="ns1:traceUniqueID")
    private String transactionId;

    @XmlElement(name = "parameter")
    private LinkedHashMap<String,String> parameters;

    /**
     * @return the accountIdentifier
     */
    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    /**
     * @param accountIdentifier the accountIdentifier to set
     */
    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    /**
     * @return the serviceID
     */
    public String getServiceID() {
        return serviceID;
    }

    /**
     * @param serviceID the serviceID to set
     */
    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
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
     * @return the parameters
     */
    public LinkedHashMap<String,String> getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(LinkedHashMap<String,String> parameters) {
        this.parameters = parameters;
    }

    
}
