package mtnecwagent.logic.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-15T01:15:54")
@StaticMetamodel(BillPaymentCompletedResponse.class)
public class BillPaymentCompletedResponse_ { 

    public static volatile SingularAttribute<BillPaymentCompletedResponse, Date> requestTime;
    public static volatile SingularAttribute<BillPaymentCompletedResponse, String> providertransactionid;
    public static volatile SingularAttribute<BillPaymentCompletedResponse, String> message;
    public static volatile SingularAttribute<BillPaymentCompletedResponse, String> MoMtransactionid;
    public static volatile SingularAttribute<BillPaymentCompletedResponse, Integer> newbalance;
    public static volatile SingularAttribute<BillPaymentCompletedResponse, String> status;

}