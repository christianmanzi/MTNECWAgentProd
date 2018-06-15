/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package mtnecwagent.models.client.gettransactionstatus;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *<?xml version="1.0" encoding="UTF-8" standalone="no"?>
 * <ns2:gettransactionstatusrequest xmlns:ns2="http://www.ericsson.com/em/emm">
 *      <referenceid>345678IUN</referenceid>
 * </ns2:gettransactionstatusrequest>
 *
 * @author manzi
 */
@XmlRootElement (
        name = "gettransactionstatusrequest",
        namespace = "http://www.ericsson.com/em/emm"
)
public class ECWTxStatusRequestModel {
    private String userName;
    private String password;
    private String referenceid;
    
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
    
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
