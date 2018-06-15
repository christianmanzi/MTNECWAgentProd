/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtnecwagent.logic.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author manzi
 */
@Entity
@Table(name = "payment_sp_merchant_settings_sets")
public class PaymentSPMerchantSettingsSet implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @Column(name = "mtn_merchant_code", length = 50)
    private String MTNMerchantCode;
    
    @Column(name = "username", length = 50)
    private String userName;
    
      @Column(name = "sp_id", length = 50)
    private String spId;
    
    @Column(name = "password", length = 50)
    private String password;
    
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (MTNMerchantCode != null ? MTNMerchantCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentSPMerchantSettingsSet)) {
            return false;
        }
        PaymentSPMerchantSettingsSet other = (PaymentSPMerchantSettingsSet) object;
        if ((this.MTNMerchantCode == null && other.MTNMerchantCode != null) || (this.MTNMerchantCode != null && !this.MTNMerchantCode.equals(other.MTNMerchantCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oltranz.mmagent.entities.BillPaymentMerchant[ MTNMerchantCode=" + MTNMerchantCode + " ]";
    }

    /**
     * @return the MTNMerchantCode
     */
    public String getMTNMerchantCode() {
        return MTNMerchantCode;
    }

    /**
     * @param MTNMerchantCode the MTNMerchantCode to set
     */
    public void setMTNMerchantCode(String MTNMerchantCode) {
        this.MTNMerchantCode = MTNMerchantCode;
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

    /**
     * @return the spId
     */
    public String getSpId() {
        return spId;
    }

    /**
     * @param spId the spId to set
     */
    public void setSpId(String spId) {
        this.spId = spId;
    }

  

}
