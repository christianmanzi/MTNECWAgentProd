package mtnecwagent.logic.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-15T01:15:54")
@StaticMetamodel(BillConfirmPaymentRequests.class)
public class BillConfirmPaymentRequests_ { 

    public static volatile SingularAttribute<BillConfirmPaymentRequests, Date> requestTime;
    public static volatile SingularAttribute<BillConfirmPaymentRequests, String> MOMAcctNum;
    public static volatile SingularAttribute<BillConfirmPaymentRequests, String> AcctRef;
    public static volatile SingularAttribute<BillConfirmPaymentRequests, Integer> RequestAmount;
    public static volatile SingularAttribute<BillConfirmPaymentRequests, String> ProcessingNumber;

}