/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mtnecwagent.logic;


import java.io.StringReader;
import static java.lang.System.out;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import mtnecwagent.models.models.AgentPaymentRequestResponse;
import mtnecwagent.models.models.RequestPaymentCompleted;
import mtnecwagent.models.models.ThirdPartyPaymentConfirmationRequest;
import mtnecwagent.utilities.CommonLibrary;

/**
 *
 * @author Christian
 */
@Stateless
public class ConfirmThirdPartyPaymentAsync {
    
    
//    @EJB CenterResponseFacade centerResponseEJB;
//    @EJB mmRequestPaymentResponseFacade mmRPREJB;
//    @EJB mmRequestPaymentCompletedFacade mmRPCEJB;
    
    private static final Logger log = Logger.getLogger("ConfirmThirdPartyPaymentHandler");
    
    private String formaTime2yyyyMMddHHmmss(LocalDateTime theTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime currentDatetime = theTime;
        // format the current datetime in the format of yyyyMMddHHmmss
        return currentDatetime.format(formatter);
    }
    
    public String createResponse(String resultCode, String resultDesc){
        
        String resp="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<ns0:debitcompletedresponse xmlns:ns0=\"http://www.ericsson.com/em/emm\"/>";
        
        return resp;
    }
    
    public String sendPaymentResponse2Center(RequestPaymentCompleted RPC) throws Exception {
            
            AgentPaymentRequestResponse agentPaymentRequestResponse = new AgentPaymentRequestResponse();
            
            agentPaymentRequestResponse.setStatuscode(RPC.getStatusCode());
            agentPaymentRequestResponse.setStatusdesc(RPC.getStatusDesc());
            agentPaymentRequestResponse.setTransactionId(RPC.getProcessingNumber());
            agentPaymentRequestResponse.setSpTransactionId(RPC.getMOMTransactionID());
            
            //out.print("VIOLATIONS agentPaymentRequestResponse: "+ agentPaymentRequestResponseEJB.create(agentPaymentRequestResponse));
            
            
            out.print("CENTER RESPONSE-"+"|Payment Gateway TRANSACTION_ID:"+agentPaymentRequestResponse.getTransactionId() +"| MOMO Transaction Id:"+agentPaymentRequestResponse.getSpTransactionId()+"|STATUS:"+agentPaymentRequestResponse.getStatuscode()+"|DESCRIPTION:"+agentPaymentRequestResponse.getStatusdesc());
            
            String stringUrl = "http://paymentgwcenterhost:8080/PaymentGateway/payments/paymentResponse";
            
            String agentPaymentRequestResponseXML=CommonLibrary.marshalling(agentPaymentRequestResponse);
            out.print("RESPONSE TO PAYMENT GATEWAY: "+ agentPaymentRequestResponseXML);
            Response response = CommonLibrary.sendRESTRequest(stringUrl, agentPaymentRequestResponseXML, MediaType.TEXT_XML, "POST") ;
            
            
            String resp= response.readEntity(String.class);
            out.print("RESPONSE TO CENTER  HEADER:"  + response+ " | RESPONSE BODY: "+ resp );
    
        if(resp.equals("SUCCESS"))
            return createResponse("00000000", "Success");
        else
            throw new Exception(resp);
    }
    
    /**
     * this method is used to transform the Mobile Money response into
     * MmResponse object
     *
     * @param inputString
     * @return
     */
    //   <?xml version="1.0" encoding="utf-8" ?>
//<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
//   <soapenv:Header>
//      <ns1:NotifySOAPHeader xmlns:ns1="http://www.huawei.com.cn/schema/common/v2_1">
//         <ns2:traceUniqueID xmlns:ns2="http://www.csapi.org/schema/momopayment/local/v1_0">504021503411410281818220013006</ns2:traceUniqueID>
//      </ns1:NotifySOAPHeader>
//   </soapenv:Header>
//   <soapenv:Body>
//      <ns3:requestPaymentCompleted xmlns:ns3="http://www.csapi.org/schema/momopayment/local/v1_0">
//         <ns3:ProcessingNumber>2713500010003</ns3:ProcessingNumber>
//         <ns3:MOMTransactionID>2713500010002</ns3:MOMTransactionID>
//         <ns3:StatusCode>01</ns3:StatusCode>
//         <ns3:StatusDesc>This is a respone Message!</ns3:StatusDesc>
//         <ns3:ThirdPartyAcctRef>http://www.qwe.com</ns3:ThirdPartyAcctRef>
//      </ns3:requestPaymentCompleted>
//   </soapenv:Body>
//</soapenv:Envelope>
    /**
     * this method is used to transform the Mobile Money response into
     * MmResponse object
     *
     * @param xmlThirdPartyPaymentConfirmationRequest
     * @return
     */
    public ThirdPartyPaymentConfirmationRequest transformMmResponseXML(String xmlThirdPartyPaymentConfirmationRequest) {
        
        ThirdPartyPaymentConfirmationRequest thirdPartyPaymentConfirmationRequest = new ThirdPartyPaymentConfirmationRequest();
        try {
            
            Map<String, Object> parameters = new LinkedHashMap<>();
            String name = null;
            String value = null;
            // create stax to read xml document sent over the stream
            XMLInputFactory staxFactory = XMLInputFactory.newInstance();
            // don't go in process of validation
            staxFactory.setProperty(XMLInputFactory.IS_VALIDATING, false);
            // create XMLStream reader to read the send stream into XML that can be understood by JAXB
            XMLStreamReader xmlReader = staxFactory.createXMLStreamReader(new StringReader(xmlThirdPartyPaymentConfirmationRequest));
            xmlReader.nextTag(); // got to the next tag
            while (xmlReader.hasNext()) {  // while XMLReader has not reached the end of the document
                
                if (xmlReader.isStartElement()) { // returns true if the cursor reaches the start of the tag
                    String sName = xmlReader.getLocalName();
                    // get the content inside the tag value
                    if (xmlReader.getLocalName().equals("name")) {
                        name = xmlReader.getElementText();
                    }
                    // get the content inside the tag value
                    if (xmlReader.getLocalName().equals("value")) {
                        value = xmlReader.getElementText();
                    }
                    // if the content of value and name is not null
                    // then put them in parameters
                    if (value != null & name != null) {
                        parameters.put(name, value);
                    }
                }
                thirdPartyPaymentConfirmationRequest.setParameters(parameters);
                xmlReader.next();
            }
            out.print("The size of parameters is {0} " + thirdPartyPaymentConfirmationRequest.getParameters().size());
            xmlReader.close();
            return thirdPartyPaymentConfirmationRequest;
        } catch (IllegalArgumentException | XMLStreamException ex) {
            return thirdPartyPaymentConfirmationRequest;
        }
    }
    
    
}
