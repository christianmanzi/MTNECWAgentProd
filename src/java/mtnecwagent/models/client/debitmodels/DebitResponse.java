package mtnecwagent.models.client.debitmodels;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *<?xml version="1.0" encoding="UTF-8"?>
<ns0:debitresponse xmlns:ns0="http://www.ericsson.com/em/emm/financial/v1_0">
<transactionid>459560</transactionid>
<status>PENDING</status>
</ns0:debitresponse>
 * 
 * 
 * @author manzi
 */
@XmlRootElement (
   name = "debitresponse", 
   namespace = "http://www.ericsson.com/em/emm/financial/v1_0" 
)

public class DebitResponse {
    private String transactionid;
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
