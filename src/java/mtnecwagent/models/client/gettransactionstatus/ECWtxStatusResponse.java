/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.models.client.gettransactionstatus;

import javax.xml.bind.annotation.XmlRootElement;

/**
 
<?xml version="1.0" encoding="UTF-8"?>
<ns0:gettransactionstatusresponse xmlns:ns0="http://www.ericsson.com/em/emm">
    <transactionid>1220865</transactionid>
    <status>SUCCESSFUL</status>
</ns0:gettransactionstatusresponse>

 * 
 * @author manzi
 */


@XmlRootElement (
   name = "gettransactionstatusresponse", 
   namespace = "http://www.ericsson.com/em/emm" 
)
public class ECWtxStatusResponse {
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
