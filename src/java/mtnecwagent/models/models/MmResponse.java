/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.models.models;

import java.util.Map;

/**
 *
 * @author aimable
 */
public class MmResponse {
    
    private String faultcode;
    private String faultstring;

    private Map<String,Object> parameters;

    public MmResponse() {
    }
    
    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameter) {
        this.parameters = parameter;
    }

    /**
     * @return the faultcode
     */
    public String getFaultcode() {
        return faultcode;
    }

    /**
     * @param faultcode the faultcode to set
     */
    public void setFaultcode(String faultcode) {
        this.faultcode = faultcode;
    }

    /**
     * @return the faultstring
     */
    public String getFaultstring() {
        return faultstring;
    }

    /**
     * @param faultstring the faultstring to set
     */
    public void setFaultstring(String faultstring) {
        this.faultstring = faultstring;
    }

}
