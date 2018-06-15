/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mtnecwagent.models.models;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author Manzi
 *
 */

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
/**
 *
 * @author manzi
 */
//<?xml version="1.0" encoding="utf-8" ?><soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
//    <soapenv:Header>
//        <ns1:NotifySOAPHeader xmlns:ns1="http://www.huawei.com.cn/schema/common/v2_1">
//            <ns1:traceUniqueID>504021502881606170930125728002</ns1:traceUniqueID>
//        </ns1:NotifySOAPHeader>
//    </soapenv:Header>
//    <soapenv:Body>
//        <ns2:processRequest xmlns:ns2="http://b2b.mobilemoney.mtn.zm_v1.0/">
//            <serviceId>101</serviceId>
//            <parameter>
//                <name>ProcessingNumber</name>
//                <value>265488</value>
//            </parameter>
//            <parameter>
//                <name>SenderID</name>
//                <value>MOM</value>
//            </parameter>
//            <parameter>
//                <name>AcctRef</name>
//                <value>1234567</value>
//            </parameter>
//            <parameter>
//                <name>RequestAmount</name>
//                <value>200</value>
//            </parameter>
//            <parameter>
//                <name>PaymentRef</name>
//                <value/>
//            </parameter>
//            <parameter>
//                <name>ThirdPartyTransactionID</name>
//                <value/>
//            </parameter>
//            <parameter>
//                <name>MOMAcctNum</name>
//                <value>250781603074</value>
//            </parameter>
//            <parameter>
//                <name>CustName</name>
//                <value>250781603074</value>
//            </parameter>
//            <parameter>
//                <name>StatusCode</name>
//                <value>01</value>
//            </parameter>
//            <parameter>
//                <name>TXNType</name>
//                <value/>
//            </parameter>
//            <parameter>
//                <name>OpCoID</name>
//                <value>25001</value>
//            </parameter>
//        </ns2:processRequest>
//    </soapenv:Body>
//</soapenv:Envelope>


public class ThirdPartyPaymentConfirmationRequest implements Serializable{
    
    private Map<String,Object> parameters;

    public ThirdPartyPaymentConfirmationRequest() {
    }
    
    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameter) {
        this.parameters = parameter;
    }
}


// @XmlElement(name = "serviceId")
//    private String serviceId;
//    
//    @XmlElement(name = "ProcessingNumber")
//    private String ProcessingNumber;    
//    
//    @XmlElement(name = "senderID")
//    private String senderID;
//    
//    
//    @XmlElement(name = "AcctRef")
//    private String AcctRef;
//    
//    
//    @XmlElement(name = "RequestAmount")
//    private String RequestAmount;
//    
//    @XmlElement(name = "PaymentRef")
//    private String PaymentRef;
//    
//    @XmlElement(name = "ThirdPartyTransactionID")
//    private String ThirdPartyTransactionID;
//    
//    @XmlElement(name = "MOMAcctNum")
//    private String MOMAcctNum;
//    
//    @XmlElement(name = "CustName")
//    private String CustName;
//    
//    @XmlElement(name = "StatusCode")
//    private String StatusCode;
//    
//    @XmlElement(name = "TXNType")
//    private String TXNType;
//    
//    @XmlElement(name = "OpCoID")
//    private String OpCoID;
