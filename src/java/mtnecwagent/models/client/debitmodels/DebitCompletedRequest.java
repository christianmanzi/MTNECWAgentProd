/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.models.client.debitmodels;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author manzi
 * 
 */

//SAMPLE
//<?xml version="1.0" encoding="UTF-8"?>
//<ns0:debitcompletedrequest xmlns:ns0="http://www.ericsson.com/em/emm/callback/v1_0">
//<transactionid>459560</transactionid>
//<externaltransactionid>0120136424262</externaltransactionid>
//<receiverinfo>
//<fri>FRI:xxx.bank/USER</fri>
//</receiverinfo>
//<status>SUCCESSFUL</status>
//</ns0:debitcompletedrequest>

//<?xml version="1.0" encoding="UTF-8"?>
//<ns0:debitcompletedrequest xmlns:ns0="http://www.ericsson.com/em/emm">
//<transactionid>1230169</transactionid>
//<externaltransactionid>1560031234252359178</externaltransactionid>
//<receiverinfo><fri>FRI:kvcs.sp/USER</fri></receiverinfo>
//<status>SUCCESSFUL</status>
//</ns0:debitcompletedrequest>

@XmlRootElement (
   name = "debitcompletedrequest", 
   namespace = "http://www.ericsson.com/em/emm" 
)

public class DebitCompletedRequest {
    private String transactionid;
    private String externaltransactionid;
    private ReceiverInfo receiverinfo;
    private String status;    

    /**
     * @return the transactionid
     */
    public String getTransactionid() {
        return transactionid;
    }

    /**
     * @param transactionid the transactionid to set
     */
    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    /**
     * @return the externaltransactionid
     */
    public String getExternaltransactionid() {
        return externaltransactionid;
    }

    /**
     * @param externaltransactionid the externaltransactionid to set
     */
    public void setExternaltransactionid(String externaltransactionid) {
        this.externaltransactionid = externaltransactionid;
    }

    /**
     * @return the receiverinfo
     */
    public ReceiverInfo getReceiverinfo() {
        return receiverinfo;
    }

    /**
     * @param receiverinfo the receiverinfo to set
     */
    public void setReceiverinfo(ReceiverInfo receiverinfo) {
        this.receiverinfo = receiverinfo;
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
}
