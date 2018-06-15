package mtnecwagent.models.client.debitmodels;

import java.util.List;
import static javax.ws.rs.core.Response.status;
import javax.xml.bind.annotation.XmlAttribute;
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
*  <?xml version="1.0" encoding="UTF-8"?>
* <ns0:errorResponse xmlns:ns0="http://www.ericsson.com/lwac" errorcode="ACCOUNTHOLDER_WITH_FRI_NOT_FOUND">
* <arguments name="fri" value="FRI:250788312609/MSISDN"/>
* </ns0:errorResponse>
 * 
 * 
 * @author manzi
 */
@XmlRootElement (
   name = "errorResponse", 
   namespace = "http://www.ericsson.com/lwac" 
)
public class DebitErrorResponse {
    
    private String errorcode;
    private List<DebitErrorResponseArgumnent> arguments;

    /**
     * @return the errorcode
     */
    @XmlAttribute(name="errorcode")
    public String getErrorcode() {
        return errorcode;
    }

    /**
     * @param errorcode the errorcode to set
     */
    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    /**
     * @return the arguments
     */
    public List<DebitErrorResponseArgumnent> getArguments() {
        return arguments;
    }

    /**
     * @param arguments the arguments to set
     */
    public void setArguments(List<DebitErrorResponseArgumnent> arguments) {
        this.arguments = arguments;
    }

   

}
