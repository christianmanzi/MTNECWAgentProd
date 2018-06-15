/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mtnecwagent.utilities;


import java.io.IOException;
import java.io.StringReader;
import static java.lang.System.out;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mtnecwagent.models.models.Parameter;
import mtnecwagent.models.models.PaymentGatewayRequest;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author manzi
 */
public class XMLstring2AgentBeans {
    /**
     * this method is used to transform the Mobile Money response into
     * MmResponse object
     *
     * @param xmlRequest
     * @return
     */
    public static PaymentGatewayRequest transformPaymentGatewayRequestXML(String xmlRequest) {
        out.print("MTN AGENT: xmlRequest: "+xmlRequest);
        PaymentGatewayRequest pgRequest = new PaymentGatewayRequest();
        Map<String, Object> parameters = new LinkedHashMap<>();
        try {
            Document d;
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xmlRequest));
            d = db.parse(is);
            NodeList nodes;
            
            nodes = d.getElementsByTagName("transId");
            if(nodes!=null){
                out.print("MTN AGENT: node with transId: "+CommonLibrary.nodeToString(nodes.item(0)));
                out.print("MTN AGENT: nodes size:"+nodes.getLength()+ " | nodes text: "+nodes.item(0).getTextContent());
                pgRequest.setTransid(nodes.item(0).getTextContent().trim());
            }
            nodes = d.getElementsByTagName("descr");
            if(nodes!=null){
                out.print("MTN AGENT: node with descr: "+CommonLibrary.nodeToString(nodes.item(0)));
               // out.print("MTN AGENT: parameterxml:"+CommonLibrary.nodeToString(nodes.item(0)));
              pgRequest.setDescr(nodes.item(0).getTextContent().trim());
            }
            nodes = d.getElementsByTagName("amount");
            if(nodes!=null){
                out.print("MTN AGENT: node with amount: "+CommonLibrary.nodeToString(nodes.item(0)));
               // out.print("MTN AGENT: parameterxml:"+CommonLibrary.nodeToString(nodes.item(0)));
               pgRequest.setAmount(Double.parseDouble(nodes.item(0).getTextContent().trim()));
            }
            nodes = d.getElementsByTagName("customerIdAtSP");
            if(nodes!=null){
                out.print("MTN AGENT: node with customerIdAtSP: "+CommonLibrary.nodeToString(nodes.item(0)));
              //  out.print("MTN AGENT: parameterxml:"+CommonLibrary.nodeToString(nodes.item(0)));
              pgRequest.setAccountIdAtSP(nodes.item(0).getTextContent().trim());
            }
            
            nodes = d.getElementsByTagName("Parameter");
            
            if(nodes!=null){
                out.print("MTN AGENT: number of parameters:"+nodes.getLength());
                String parameterXML;
                Parameter parameter;
                for(int i=0;i<nodes.getLength();i++){
                    parameterXML=CommonLibrary.nodeToString(nodes.item(i));
                    parameter=(Parameter)CommonLibrary.unmarshalling(parameterXML, Parameter.class);
                    out.print("MTN AGENT: parameterxml:"+parameterXML);
                    out.print("MTN AGENT: paramter ="+parameter.toString());
                    if (parameter.getValue() != null & parameter.getName() != null) {
                        parameters.put(parameter.getName(),parameter.getValue());
                    }
                }
                pgRequest.setParameters(parameters);
                out.print("MTN AGENT: payment Gateway Request list of parameters count  ="+pgRequest.getParameters().size());
                out.print("MTN AGENT: payment Gateway Request:"+CommonLibrary.marshalling(pgRequest));
            }
            
            return pgRequest;
        } catch (IllegalArgumentException |SAXException |IOException | ParserConfigurationException ex) {
            
            return pgRequest;
        }
    }
}
