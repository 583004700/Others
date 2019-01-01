
package wcf.omcorderwrapperservice.org.tempuri;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-05-18T10:58:10.033+08:00
 * Generated source version: 3.2.4
 */

@WebFault(name = "ErrorInfo", targetNamespace = "http://schemas.datacontract.org/2004/07/OMCSystem.Core.Common.ServicesException")
public class IOMCOrderWrapperServiceNoticeCallBackSuccessErrorInfoFaultFaultMessage extends Exception {

    private wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.ErrorInfo errorInfo;

    public IOMCOrderWrapperServiceNoticeCallBackSuccessErrorInfoFaultFaultMessage() {
        super();
    }

    public IOMCOrderWrapperServiceNoticeCallBackSuccessErrorInfoFaultFaultMessage(String message) {
        super(message);
    }

    public IOMCOrderWrapperServiceNoticeCallBackSuccessErrorInfoFaultFaultMessage(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public IOMCOrderWrapperServiceNoticeCallBackSuccessErrorInfoFaultFaultMessage(String message, wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.ErrorInfo errorInfo) {
        super(message);
        this.errorInfo = errorInfo;
    }

    public IOMCOrderWrapperServiceNoticeCallBackSuccessErrorInfoFaultFaultMessage(String message, wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.ErrorInfo errorInfo, java.lang.Throwable cause) {
        super(message, cause);
        this.errorInfo = errorInfo;
    }

    public wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.ErrorInfo getFaultInfo() {
        return this.errorInfo;
    }
}