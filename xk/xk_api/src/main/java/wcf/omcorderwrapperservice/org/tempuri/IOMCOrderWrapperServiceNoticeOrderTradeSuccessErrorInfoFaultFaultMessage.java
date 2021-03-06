
package wcf.omcorderwrapperservice.org.tempuri;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-05-18T10:58:10.020+08:00
 * Generated source version: 3.2.4
 */

@WebFault(name = "ErrorInfo", targetNamespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.ServicesException")
public class IOMCOrderWrapperServiceNoticeOrderTradeSuccessErrorInfoFaultFaultMessage extends Exception {

    private wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.ErrorInfo errorInfo;

    public IOMCOrderWrapperServiceNoticeOrderTradeSuccessErrorInfoFaultFaultMessage() {
        super();
    }

    public IOMCOrderWrapperServiceNoticeOrderTradeSuccessErrorInfoFaultFaultMessage(String message) {
        super(message);
    }

    public IOMCOrderWrapperServiceNoticeOrderTradeSuccessErrorInfoFaultFaultMessage(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public IOMCOrderWrapperServiceNoticeOrderTradeSuccessErrorInfoFaultFaultMessage(String message, wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.ErrorInfo errorInfo) {
        super(message);
        this.errorInfo = errorInfo;
    }

    public IOMCOrderWrapperServiceNoticeOrderTradeSuccessErrorInfoFaultFaultMessage(String message, wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.ErrorInfo errorInfo, java.lang.Throwable cause) {
        super(message, cause);
        this.errorInfo = errorInfo;
    }

    public wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.ErrorInfo getFaultInfo() {
        return this.errorInfo;
    }
}
