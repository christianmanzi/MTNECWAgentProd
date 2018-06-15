/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mtnecwagent.logic;



import java.io.PrintWriter;
import java.io.StringWriter;
import static java.lang.System.out;
import java.util.Base64;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import mtnecwagent.models.client.debitmodels.DebitErrorResponse;
import mtnecwagent.models.client.debitmodels.DebitResponse;
import mtnecwagent.models.client.gettransactionstatus.ECWTxStatusRequestModel;
import mtnecwagent.models.client.gettransactionstatus.ECWtxStatusResponse;
import mtnecwagent.models.localservices.RequestPaymentResponse;
import mtnecwagent.models.models.AgentPaymentRequestResponse;
import mtnecwagent.models.models.PaymentGatewayRequest;
import mtnecwagent.models.models.RequestPaymentCompleted;
import mtnecwagent.utilities.CommonLibrary;
import static mtnecwagent.utilities.Configurations.getProdRequestPaymentUrl;
import static mtnecwagent.utilities.Configurations.getTransactionStatusUrl;
import mtnecwagent.utilities.SSLProcedures;

/**
 *
 * @author manzi
 */

@Stateless
public class ECWPaymentRequestsManager {
    
    
    public RequestPaymentResponse sendPaymentRequest(PaymentGatewayRequest pgRequest) {
        
        try {
            
            String stringUrl = getProdRequestPaymentUrl;
            
            String debitRequestXml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<ns0:debitrequest xmlns:ns0=\"http://www.ericsson.com/em/emm/financial/v1_0\">\n" +
                    "   <fromfri>FRI:"+pgRequest.getAccountIdAtSP()+"/MSISDN</fromfri>\n" +
                    "   <tofri>FRI:"+(String)pgRequest.getParameters().get("serviceId")+"/USER</tofri>\n" +
                    "   <amount>\n" +
                    "      <amount>"+pgRequest.getAmount().intValue()+"</amount>\n" +
                    "      <currency>RWF</currency>\n" +
                    "   </amount>\n" +
                    "   <externaltransactionid>"+pgRequest.getTransid()+"</externaltransactionid>\n" +
                    "   <frommessage>"+pgRequest.getDescr()+"</frommessage>\n" +
                    "   <tomessage>KVCS parking service :KVCS Parking fees/taxes payment RAC040H :: 100Rwf</tomessage>\n" +
                    "   <referenceid>"+pgRequest.getTransid()+"</referenceid>\n" +
                    "</ns0:debitrequest>";
            
//            MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
//            headers.add("Authorization","Basic a3Zjcy5zcDpLdmNzQDU2Nw==");
//            
            String basicAuth=pgRequest.getParameters().get("serviceId")+":"+pgRequest.getParameters().get("password");
            try{
                Base64.Encoder encoder= Base64.getEncoder();
                byte[] encoded=encoder.encode(basicAuth.getBytes());
                basicAuth="Basic "+new String(encoded, "UTF-8");
            }
            catch(Exception ex){
                
            }
                 MultivaluedMap<String,Object> headers=new MultivaluedHashMap();
            
            headers.add("Content-type", "text/xml");
            headers.add("Authorization",basicAuth);
            
            //Response response = target.request().header("Content-type", "text/xml").header("Signature", "43AD232FD45FF").post(Entity.entity(moMoMessage, MediaType.TEXT_XML));
            Response response=  SSLProcedures.postRequest(stringUrl, debitRequestXml,headers, MediaType.APPLICATION_ATOM_XML, "POST", "prod");
            
            
            // out.print("MTN AGENT-TEST:"+ Entity.entity(moMoMessage, MediaType.TEXT_XML).toString());
            String xmlStringResp;
            //="<?xml version=\"1.0\" encoding=\"UTF-8\"?><ns0:debitresponse xmlns:ns0=\"http://www.ericsson.com/em/emm/financial/v1_0\"><transactionid>1227736</transactionid><status>PENDING</status></ns0:debitresponse>";
            if(response==null)
                xmlStringResp="null response";
            else{
                // xmlStringResp="response status:"+response.getStatus()+" ";
                xmlStringResp = response.readEntity(String.class);
                
            }
            
            
            xmlStringResp=xmlStringResp.replaceAll("\n", " ");
            out.print("MTN AGENT-TEST   :Payment Request Response - "+ xmlStringResp);
            DebitResponse debitResponse =(DebitResponse)CommonLibrary.unmarshalling(xmlStringResp, DebitResponse.class);
            
            //testing line
            //   debitResponse.setTransactionid(CommonLibrary.generateRandomLong(8)+"");
            
            RequestPaymentResponse requestPaymentResponse=new RequestPaymentResponse();
            if(debitResponse!=null){
                out.print("Marshalled debit response object:"+CommonLibrary.marshalling(debitResponse));
              
                requestPaymentResponse.setSpTxReferenceTx(debitResponse.getTransactionid());
                requestPaymentResponse.setRequestStatus(debitResponse.getStatus());
                requestPaymentResponse.setRequestStatusDesc(debitResponse.getTransactionid());
                requestPaymentResponse.setResponderStatus(100);
            }
            else{
                
                DebitErrorResponse debitErrorResponse=(DebitErrorResponse)CommonLibrary.unmarshalling(xmlStringResp.trim(), DebitErrorResponse.class);
                if(debitErrorResponse!=null){
                    out.print("Marshalled debit error response object:"+CommonLibrary.marshalling(debitErrorResponse));
                    requestPaymentResponse.setRequestStatus(debitErrorResponse.getErrorcode());
                    requestPaymentResponse.setRequestStatusDesc(debitErrorResponse.getErrorcode());
                    requestPaymentResponse.setResponderStatus(100);
                }else{
                    requestPaymentResponse.setRequestStatus("FAILED");
                    requestPaymentResponse.setRequestStatusDesc("FAILED");
                    requestPaymentResponse.setResponderStatus(100);
                }
            }
            
            String resp2Center=CommonLibrary.marshalling(requestPaymentResponse);
            out.print("MTN AGENT-TEST RESPONSE TO Payment gateway: "+resp2Center.replaceAll("\n", " ") );
            
            
            return requestPaymentResponse;
            
        } catch (Exception ex) {
            String message="ERROR ON RECEPTION OF CENTER REQUEST: MESSAGE: "+ex.getMessage()+" | TRACE :";
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            message+=errors.toString();
            out.print("MTN AGENT-TEST Error on REception request processing: "+message);
            RequestPaymentResponse requestPaymentResponse= new RequestPaymentResponse();
            requestPaymentResponse.setResponderStatus(500); //agent is has an internal system erro
            requestPaymentResponse.setRequestStatus("0");// request is Failed
            requestPaymentResponse.setRequestStatusDesc("Request Failed at agent level; Error message: "+ex.getMessage());
            out.print("MTN AGENT-TEST, Response TO Payment gateway: "+ CommonLibrary.marshalling(requestPaymentResponse));
            return requestPaymentResponse;
        }
    }
    
   
    
    public String sendPaymentResponse2Center(RequestPaymentCompleted RPC) {
        
        try {
            
            AgentPaymentRequestResponse agentPaymentRequestResponse = new AgentPaymentRequestResponse();
            
            agentPaymentRequestResponse.setStatuscode(RPC.getStatusCode());
            agentPaymentRequestResponse.setStatusdesc(RPC.getStatusDesc());
            agentPaymentRequestResponse.setTransactionId(RPC.getProcessingNumber());
            agentPaymentRequestResponse.setSpTransactionId(RPC.getMOMTransactionID());
            
            //out.print("VIOLATIONS agentPaymentRequestResponse: "+ agentPaymentRequestResponseEJB.create(agentPaymentRequestResponse));
            
            
            out.print("CENTER RESPONSE-"+"|Payment Gateway TRANSACTION_ID:"+agentPaymentRequestResponse.getTransactionId() +"| MOMO Transaction Id:"+agentPaymentRequestResponse.getSpTransactionId()+"|STATUS:"+agentPaymentRequestResponse.getStatuscode()+"|DESCRIPTION:"+agentPaymentRequestResponse.getStatusdesc());
            
            String stringUrl = "http://10.171.1.53:8080/PaymentGateway/payments/paymentResponse";
            
            String agentPaymentRequestResponseXML=CommonLibrary.marshalling(agentPaymentRequestResponse);
            out.print("RESPONSE TO PAYMENT GATEWAY: "+ agentPaymentRequestResponseXML);
            Response response = CommonLibrary.sendRESTRequest(stringUrl, agentPaymentRequestResponseXML, MediaType.TEXT_XML, "POST") ;
            
            
            String resp= response.readEntity(String.class);
            out.print("RESPONSE TO CENTER  HEADER:"  + response+ " | RESPONSE BODY: "+ resp );
            
            
            agentPaymentRequestResponse.setThisResponseStatusCode(response.getStatus());
//             out.print("VIOLATIONS agentPaymentRequestResponse: "+ centerRequestEJB.create(centerRequest));
return getPaymentCompletedStaticResponse();
        } catch (Exception ex) {
            out.print("MTN AGENT - PAYMENT COMPLETED (Send payment completed to Payment Gateway):"+ex.getMessage());
            return getPaymentCompletedStaticResponse();
        }
    }
    
    //ECW team confirms that the response is a static response and does not really serve to nothing much
    //especially because whatever be the result, not further action will be performed other than
    //logging that the request was received
    public String getPaymentCompletedStaticResponse(){
        String resp="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<ns0:debitcompletedresponse xmlns:ns0=\"http://www.ericsson.com/em/emm\"/>";
        
        return resp;
    }
    
    public ECWtxStatusResponse sendTransactionStatusRequestTest(ECWTxStatusRequestModel statusRequest) {
        String respStr;
        try{
            
            String url=getTransactionStatusUrl;
            
            String txRequestBody="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<ns2:gettransactionstatusrequest xmlns:ns2=\"http://www.ericsson.com/em/emm\">\n" +
                    "   <referenceid>"+statusRequest.getReferenceid()+"</referenceid>\n" +
                    "</ns2:gettransactionstatusrequest> ";
            
            String basicAuth=statusRequest.getUserName()+":"+statusRequest.getPassword();
            try{
                Base64.Encoder encoder= Base64.getEncoder();
                byte[] encoded=encoder.encode(basicAuth.getBytes());
                basicAuth="Basic "+new String(encoded, "UTF-8");
            }
            catch(Exception ex){
                
            }
            
            out.print("MTNAGENTV2: Request URL: "+url);
            txRequestBody=txRequestBody.replace("\n", " ");
            out.print("MTNAGENTV2: Request Body"+txRequestBody.replace("\n", " "));
            
            MultivaluedMap<String,Object> headers=new MultivaluedHashMap();
            
            
            headers.add("Authorization", basicAuth);
            
            Response resp=SSLProcedures.postRequest(getTransactionStatusUrl, txRequestBody,headers, MediaType.TEXT_XML, "POST", "prod");
            respStr=resp.readEntity(String.class);
            out.print("MTN MoMo Agent: URL:"+getTransactionStatusUrl);
            out.print("MTN MoMo Agent:"+txRequestBody);
            out.print("MTN MoMo Agent: basicAuth:"+basicAuth);
            out.print("MTN MoMo Agent sendPaymentCompleteToMTN; Response: "+respStr.replaceAll("\n", " "));
            
            
        }
        catch (Exception ex){
            out.print("MTNAGENTV2: ERROR in CREATE MOMO REQUEST: MESSAGE +"+ ex.getMessage()+" | TRACE: "+ ex.getStackTrace().toString());
            return null;
        }
        
        ECWtxStatusResponse ecwtxStatusResponse =(ECWtxStatusResponse)CommonLibrary.unmarshalling(respStr, ECWtxStatusResponse.class);
        
        out.print("Chech status of  Marshalled debit"+ statusRequest.getReferenceid()+" bit response object:"+ecwtxStatusResponse);
        
       
        return ecwtxStatusResponse;
    }
    
    
    
}
