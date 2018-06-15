///*
//* To change this license header, choose License Headers in Project Properties.
//* To change this template file, choose Tools | Templates
//* and open the template in the editor.
//*/
//package mtnecwagent.utilities;
//
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import static java.lang.System.out;
//import java.security.KeyStore;
//import javax.net.ssl.SSLContext;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.core.Response;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.ssl.SSLContexts;
//
///**
// *
// * @author manzi
// */
//public class ApacheSSLProcedures {
//    
//  
//    
//    private static final String KEYSTOREPATH = "/clientkeystore.jks"; // or .p12
//    private static final String KEYSTOREPASS = "keystorepass";
//    private static final String KEYPASS = "keypass";
//
//   private KeyStore readStore() throws Exception {
//        try (InputStream keyStoreStream = this.getClass().getResourceAsStream(KEYSTOREPATH)) {
//            KeyStore keyStore = KeyStore.getInstance("JKS"); // or "PKCS12"
//            keyStore.load(keyStoreStream, KEYSTOREPASS.toCharArray());
//            return keyStore;
//        }
//    }
//    private  HttpClient buildClientProd(){
//        try{
//            SSLContext sslContext = SSLContexts.custom()
//                    .loadKeyMaterial(readStore(), KEYPASS.toCharArray()) // use null as second param if you don't have a separate key password
//                    .build();
//            
//            HttpClient httpClient = HttpClients.custom().setSSLContext(sslContext).build();
//           return httpClient;
//        }catch(Exception Ex){
//            return null;
//        }
//    }
//    
//  
//    
//    public  Response postRequest(String url,String requestStr,String MediaType, String method,String requestType){
//        try
//        {
//            
//            HttpClient client=null;
//            
//            out.print("MTN AGENT-TEST : URL----------------------------------\n: "+url);
//            
//            HttpPost post = new HttpPost(url);
//           
//                client = buildClientProd();
//                out.print("MTN AGENT-TEST : URL production----------------------------------: "+url);
//          
//            
//            if(client==null)
//                return null;
//            out.print("MTN AGENT-TEST : Client----------------------------------: "+client);
//            
//            WebTarget target =client.target(url);
//            
//            HttpResponse response = client.execute();
//                    //target.request().post(Entity.entity(requestStr, MediaType));
//            
//            return response;
//        }
//        catch(Exception e)
//        {
//            StringWriter errors = new StringWriter();
//            e.printStackTrace(new PrintWriter(errors));
//            String message=errors.toString();
//            out.printf("MTN AGENT-TEST - Error request send :"+ e.getMessage() + "TRACE: "+ message);
//            // e.printStackTrace(Systecd m.out);
//            return null;
//        }
//        
//        
//    }
//    
//    public static Response postRequest(String url,String requestStr,MultivaluedMap<String,Object> headers,String MediaType, String method,String requestType){
//        try
//        {
//            
//            HttpClient client=null;
//            
//            out.print("MTN AGENT-TEST : URL----------------------------------\n: "+url);
//                HttpPost post = new HttpPost(url);
//                
//                for()
//            
//            if(requestType.equals("prod")){
//                client = buildClientProd();
//                out.print("MTN AGENT-PROD : URL production----------------------------------: "+url);
//            }
//            
//            if(client==null)
//                return null;
//            out.print("MTN AGENT-PROD : Client----------------------------------: "+client);
//            out.print("MTN AGEBT-PROD : Body="+requestStr);
//            
//            WebTarget target =client.target(url);
//            
//            Response response;
//            if(headers != null)
//                response = target.request().headers(headers).post(Entity.entity(requestStr, MediaType));
//            else
//                response = target.request().post(Entity.entity(requestStr, MediaType));
//            
//            
//            return response;
//        }
//        catch(Exception e)
//        {
//            StringWriter errors = new StringWriter();
//            e.printStackTrace(new PrintWriter(errors));
//            String message=errors.toString();
//            out.printf("MTN AGENT-TEST - Error request send :"+ e.getMessage() + "TRACE: "+ message);
//            // e.printStackTrace(Systecd m.out);
//            return null;
//        }
//        
//        
//    }
//    
//}
