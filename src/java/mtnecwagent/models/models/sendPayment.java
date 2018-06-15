/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.models.models;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author aimable
 */
@ManagedBean
@RequestScoped
public class sendPayment {

    /**
     * Creates a new instance of sendPayment
     */
    private String msisdn;

    private Long processingNumber = 1829433949L;

    private Long dueAmount;

    private String response = "Response One";

    public sendPayment() {
    }

    public String sendPaymentRequest() {
        try {

            String stringUrl = "http://172.25.48.36:8310/ThirdPartyServiceUMMImpl/UMMServiceService/RequestPayment/v17";
            URL url = new URL(stringUrl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestProperty("Content-type", "text/xml");
            httpConn.setRequestProperty("Signature", "43AD232FD45FF");
            httpConn.setDoOutput(true);
            httpConn.setRequestMethod("POST");
            OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
            String request=createSoapRequest(msisdn, dueAmount);
            writer.write(request);
            writer.flush();
            InputStream inputStream = (InputStream) httpConn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringWriter sw = new StringWriter();
            while ((line = reader.readLine()) != null) {
                sw.append(line);
            }
            response = sw.toString();
            System.out.println(request);
            System.out.println("http connection status :" + httpConn.getResponseMessage() + " on " + processingNumber);
//            Client client = ClientBuilder.newClient();
//            WebTarget target = client.target(stringUrl);
//            Response resp = target.request().header("Content-type", "text/xml").header("Signature", "43AD232FD45FF").post(Entity.entity(createSoapRequest(msisdn, dueAmount), MediaType.TEXT_XML));
//            Invocation invocation = target.request().headers(listHeaders).buildPost(Entity.entity(message, MediaType.TEXT_XML));
//            Response resp = invocation.invoke();
//            String xmlStringResp = resp.readEntity(String.class);
//            System.out.println("The Value is " + xmlStringResp);
            return response;
        }
        catch (Exception ex) {
            Logger.getLogger(sendPayment.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private String createSoapRequest(String msisdn, Long dueAmount) {

        String tr = "";
        String spId = "2500110003302";
        LocalDateTime now = LocalDateTime.now();
        String spPassword = encryptyPassword(msisdn, spId, now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime currentDatetime = LocalDateTime.now();
        String fomattedDatetime = currentDatetime.format(formatter);

        tr += "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:b2b=\"http://b2b.mobilemoney.mtn.ug_v1.0/\">";
        tr += "<SOAP-ENV:Header xmlns=\"http://www.huawei.com.cn/schema/common/v2_1\">";
        tr += "<RequestSOAPHeader>";
        tr += "<spId>" + spId + "</spId>";
        tr += "<spPassword>" + spPassword + "</spPassword>";
        tr += "<serviceId/>";
        tr += "<timeStamp>" + fomattedDatetime + "</timeStamp>";

        tr += "</RequestSOAPHeader>";

        tr += "</SOAP-ENV:Header>";
        tr += "<SOAP-ENV:Body>";
        tr += "<b2b:processRequest>";
        tr += " <serviceId>olt.sp</serviceId>";
        tr += " <parameter>";
        tr += "  <name>DueAmount</name>";
        tr += "  <value>" + dueAmount + "</value>";
        tr += " </parameter>";
        tr += " <parameter>";
        tr += "  <name>MSISDNNum</name>";
        tr += "<value>" + msisdn + "</value>";
        tr += " </parameter>";
        tr += " <parameter>";
        tr += "  <name>ProcessingNumber</name>";
        tr += "  <value>" + processingNumber + "</value>";
        tr += " </parameter>";
        tr += " <parameter>";
        tr += "  <name>serviceId</name>";
        tr += "  <value>oltrans.sp</value>";
        tr += " </parameter>";
        tr += " <parameter>";
        tr += "  <name>AcctRef</name>";
        tr += "  <value>112233</value>";
        tr += " </parameter>";
        tr += " <parameter>";
        tr += "  <name>AcctBalance</name>";
        tr += "  <value>610</value>";
        tr += " </parameter>";
        tr += " <parameter>";
        tr += "  <name>MinDueAmount</name>";
        tr += "  <value>100</value>";
        tr += " </parameter>";
        tr += " <parameter>";
        tr += "  <name>Narration</name>";
        tr += "  <value>Payment To Oltranz</value>";
        tr += " </parameter>";
        tr += " <parameter>";
        tr += "  <name>PrefLang</name>";
        tr += "  <value>121212121</value>";
        tr += " </parameter>";
        tr += " <parameter>";
        tr += "  <name>OpCoID</name>";
        tr += "  <value>25001</value>";
        tr += " </parameter>";
        tr += "</b2b:processRequest>";
        tr += "</SOAP-ENV:Body>";
        tr += "</SOAP-ENV:Envelope>";
        return tr;
    }

    public static String encryptyPassword(String msidn, String spId, LocalDateTime currentDatetime) {

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            currentDatetime = LocalDateTime.now();
            String fomattedDatetime = currentDatetime.format(formatter);
            String password = spId + "Huawei2015" + fomattedDatetime;
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(password.getBytes(), 0, password.length());
            return new BigInteger(1, digest.digest()).toString(16);

        }
        catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(sendPayment.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Long getProcessingNumber() {
        return processingNumber;
    }

    public void setProcessingNumber(Long processingNumber) {
        this.processingNumber = processingNumber;
    }

    public Long getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Long dueAmount) {
        this.dueAmount = dueAmount;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
