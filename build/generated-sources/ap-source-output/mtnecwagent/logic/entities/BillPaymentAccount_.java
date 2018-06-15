package mtnecwagent.logic.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-15T01:15:54")
@StaticMetamodel(BillPaymentAccount.class)
public class BillPaymentAccount_ { 

    public static volatile SingularAttribute<BillPaymentAccount, String> accountId;
    public static volatile SingularAttribute<BillPaymentAccount, Integer> dueAmount;
    public static volatile SingularAttribute<BillPaymentAccount, Integer> paid;
    public static volatile SingularAttribute<BillPaymentAccount, Integer> processingDuration;

}