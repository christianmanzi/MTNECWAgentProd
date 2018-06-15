/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mtnecwagent.models.client.debitmodels;


import javax.xml.bind.annotation.*;


/*
 *
 * <?xml version="1.0" encoding="UTF-8"?>
<ns0:debitrequest xmlns:ns0="http://www.ericsson.com/em/emm/financial/v1_0">
<fromfri>FRI:250788386455/MSISDN</fromfri>
<tofri>FRI:atlantis.bank/USER</tofri>
<amount>
<amount>5</amount>
<currency>RWF</currency>
</amount>
<externaltransactionid>0120136424262</externaltransactionid>
<frommessage>Message from</frommessage>
<tomessage>Message to</tomessage>
<referenceid>0120136424262</referenceid>
</ns0:debitrequest>
 * 
 * @author manzi
 */



@XmlRootElement (
   name = "debitrequest", 
   namespace = "http://www.ericsson.com/em/emm/financial/v1_0" 
)

public class DebitRequest {
    private String fromfri;
    private String tofri;
    private AmountModel amount;
    private String externaltransactionid;
    private String frommessage;
    private String tomessage;
    private String referenceid;

    /**
     * @return the fromfri
     */
    public String getFromfri() {
        return fromfri;
    }

    /**
     * @param fromfri the fromfri to set
     */
    public void setFromfri(String fromfri) {
        this.fromfri = fromfri;
    }

    /**
     * @return the tofri
     */
    public String getTofri() {
        return tofri;
    }

    /**
     * @param tofri the tofri to set
     */
    public void setTofri(String tofri) {
        this.tofri = tofri;
    }

    /**
     * @return the amount
     */
    public AmountModel getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(AmountModel amount) {
        this.amount = amount;
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
     * @return the frommessage
     */
    public String getFrommessage() {
        return frommessage;
    }

    /**
     * @param frommessage the frommessage to set
     */
    public void setFrommessage(String frommessage) {
        this.frommessage = frommessage;
    }

    /**
     * @return the tomessage
     */
    public String getTomessage() {
        return tomessage;
    }

    /**
     * @param tomessage the tomessage to set
     */
    public void setTomessage(String tomessage) {
        this.tomessage = tomessage;
    }

    /**
     * @return the referenceid
     */
    public String getReferenceid() {
        return referenceid;
    }

    /**
     * @param referenceid the referenceid to set
     */
    public void setReferenceid(String referenceid) {
        this.referenceid = referenceid;
    }

    
}
