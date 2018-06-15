/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mtnecwagent.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import mtnecwagent.logic.ConfirmThirdPartyPaymentAsync;
import mtnecwagent.logic.ECWPaymentRequestsManager;
import mtnecwagent.logic.entities.facades.MMPaymentRequestFacade;
import mtnecwagent.logic.entities.facades.MMRequestPaymentResponseFacade;
import mtnecwagent.models.client.debitmodels.DebitCompletedRequest;
import mtnecwagent.models.client.debitmodels.DebitErrorResponse;
import mtnecwagent.models.client.debitmodels.DebitErrorResponseArgumnent;
import mtnecwagent.models.client.gettransactionstatus.ECWTxStatusRequestModel;
import mtnecwagent.models.client.gettransactionstatus.ECWtxStatusResponse;
import mtnecwagent.models.coremodel.txstatusmodels.CoreTxStatusRequestModel;
import mtnecwagent.models.coremodel.txstatusmodels.CoreTxStatusResponseModel;
import mtnecwagent.models.localservices.RequestPaymentResponse;
import mtnecwagent.models.models.PaymentGatewayRequest;
import mtnecwagent.models.models.RequestPaymentCompleted;
import mtnecwagent.utilities.CommonLibrary;
import mtnecwagent.utilities.XMLstring2AgentBeans;

/**
 * REST Web Service
 *
 * @author manzi
 */
@Path("Payments")
public class ECWServices {
    
    @EJB
            ECWPaymentRequestsManager ECWPaymentRequestsManager;
    @EJB
            MMPaymentRequestFacade mmPaymentRequestejb;
    @EJB
            MMRequestPaymentResponseFacade mmRequestPaymentResponseFacade;
    
//
//    @EJB
//           RequestPaymentCompletedHandlerAsync requestPaymentCompletedHandlerAsync;
//
//
    
    
    /**
     * Creates a new instance of HSDPServices
     */
    public ECWServices() {
    }
    
    @POST
    @Path("testget")
    public String testget(String input){
        input=input.trim();
        DebitErrorResponse  debitResponse=(DebitErrorResponse)CommonLibrary.unmarshalling(input, DebitErrorResponse.class);
        
        DebitErrorResponseArgumnent argument=new DebitErrorResponseArgumnent();
        DebitErrorResponse errorResponse= new DebitErrorResponse();
        
        argument.setName("surname");
        argument.setValue("Manzi");
        List<DebitErrorResponseArgumnent> list=new ArrayList();
        list.add(argument);
        errorResponse.setArguments(list);
        errorResponse.setErrorcode("names");
        
        out.print(CommonLibrary.marshalling(errorResponse));
        
        
        String result=CommonLibrary.marshalling(debitResponse);
        
        return "Well received: "+result;
    }
    
    @POST
    @Path("requestStatus")
    @Consumes("application/json")
    @Produces("application/json")
    public CoreTxStatusResponseModel getTxStatusTest(CoreTxStatusRequestModel coreTxStatusRequest){
        ECWTxStatusRequestModel  ecwTxStatusRequest=new ECWTxStatusRequestModel();
        ecwTxStatusRequest.setPassword(coreTxStatusRequest.getPassword());
        ecwTxStatusRequest.setReferenceid(coreTxStatusRequest.getTransactionId());
        ecwTxStatusRequest.setUserName(coreTxStatusRequest.getUserName());
        
        ECWtxStatusResponse ecwtxStatusResponse= ECWPaymentRequestsManager.sendTransactionStatusRequestTest(ecwTxStatusRequest);
        
        CoreTxStatusResponseModel coreTxStatusResponse=new CoreTxStatusResponseModel();
        coreTxStatusResponse.setStatus(ecwtxStatusResponse.getStatus());
        coreTxStatusResponse.setPaymentSpTransactionid(ecwtxStatusResponse.getTransactionid());
        
        return coreTxStatusResponse;
    }
    
    
    private PaymentGatewayRequest pgRequest;
//
//    private static final Logger log = Logger.getLogger("Service");
//
//    /**
//     * this method receives input request from mmcenter and process the request
//     * by sending it to MTN Mobile money then return back the result
//     * to the original sender (mmcenter)
//     * @param stream
//     * @return
//     */
    @Path("/InitiatePaymentAsync")
    @POST
    @Consumes({"text/xml", "application/xml","application/octet-stream"})
    @Produces({"text/xml", "application/xml"})
    public RequestPaymentResponse processInitiatedPaymentAsync(InputStream stream) {
        try {
            String inputString=CommonLibrary.inputStream2String(stream);
            pgRequest= XMLstring2AgentBeans.transformPaymentGatewayRequestXML(inputString);
            RequestPaymentResponse requestPaymentResponse= ECWPaymentRequestsManager.sendPaymentRequest(pgRequest);
            
            return requestPaymentResponse;
        } catch (Exception ex) {
            String message="ERROR ON RECEPTION OF CENTER REQUEST: MESSAGE: "+ex.getMessage()+" | TRACE :";
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            message+=errors.toString();
            RequestPaymentResponse requestPaymentResponse= new RequestPaymentResponse();
            requestPaymentResponse.setResponderStatus(500); //agent is has an internal system error
            requestPaymentResponse.setRequestStatus("0");// request is Failed
            requestPaymentResponse.setRequestStatusDesc("Request Failed at agent level");
            return requestPaymentResponse;
        } finally {
            try {
                stream.close();
            } catch (IOException ex) {
                out.print("The IO error occurs when closing the stream"+ ex.getCause());
                return null;
            }
        }
    }
    
    @POST
    @Path("prod/{spAccount}/debitcompleted")
    @Consumes({"text/xml", "application/xml","application/octet-stream"})
    @Produces({"text/xml", "application/xml"})
    public String testProcessRequestPaymentCompletedAsync(InputStream inputStream,@PathParam("spAccount") String spAccount){
        try{
            ECWPaymentRequestsManager=new ECWPaymentRequestsManager();
            
            String inputString = CommonLibrary.inputStream2String(inputStream);
            inputString=inputString.replaceAll("\n", " ");
            out.print("MTN AGENT-TEST : Payment Completed Request received: "+inputString);
            
            DebitCompletedRequest DebitCompletedRequest=(DebitCompletedRequest)CommonLibrary.unmarshalling(inputString, DebitCompletedRequest.class);
            
            out.print("Debit Completed Request converted : "+CommonLibrary.marshalling(DebitCompletedRequest));
            
            RequestPaymentCompleted requestPaymentCompleted=new RequestPaymentCompleted();
            requestPaymentCompleted.setMOMTransactionID(DebitCompletedRequest.getTransactionid());
            requestPaymentCompleted.setProcessingNumber(DebitCompletedRequest.getExternaltransactionid());
            requestPaymentCompleted.setStatusCode(DebitCompletedRequest.getStatus());
            requestPaymentCompleted.setThirdPartyAcctRef(DebitCompletedRequest.getReceiverinfo().getFri());
            
            ConfirmThirdPartyPaymentAsync confirmThirdPartyPaymentAsync=new ConfirmThirdPartyPaymentAsync();
            String responseXML=confirmThirdPartyPaymentAsync.sendPaymentResponse2Center(requestPaymentCompleted);
//
return  responseXML;

        }catch(Exception ex){
            String message="an Error occured !!"+ex.getMessage();
            out.print("RESPONSE to ECW: "+message);
            return "message";
        }
    }
    
    
    
}
