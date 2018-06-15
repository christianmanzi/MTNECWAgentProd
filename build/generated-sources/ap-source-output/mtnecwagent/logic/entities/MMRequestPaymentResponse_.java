package mtnecwagent.logic.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-15T01:15:54")
@StaticMetamodel(MMRequestPaymentResponse.class)
public class MMRequestPaymentResponse_ { 

    public static volatile SingularAttribute<MMRequestPaymentResponse, String> StatusDesc;
    public static volatile SingularAttribute<MMRequestPaymentResponse, Date> firstResponseTime;
    public static volatile SingularAttribute<MMRequestPaymentResponse, String> lastStatusCode;
    public static volatile SingularAttribute<MMRequestPaymentResponse, Date> lastResponseTime;
    public static volatile SingularAttribute<MMRequestPaymentResponse, String> StatusCode;
    public static volatile SingularAttribute<MMRequestPaymentResponse, String> ProcessingNumber;
    public static volatile SingularAttribute<MMRequestPaymentResponse, String> MOMTransactionID;
    public static volatile SingularAttribute<MMRequestPaymentResponse, String> ThirdPartyAcctRef;

}