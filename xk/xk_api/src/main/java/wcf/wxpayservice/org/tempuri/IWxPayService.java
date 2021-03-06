package wcf.wxpayservice.org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.4 2018-05-18T09:26:36.244+08:00 Generated source
 * version: 3.2.4
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "IWxPayService")
@XmlSeeAlso({wcf.wxpayservice.com.microsoft.schemas._2003._10.serialization.ObjectFactory.class, ObjectFactory.class,
    wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.ObjectFactory.class,
    wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models.ObjectFactory.class,
    wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ObjectFactory.class})
public interface IWxPayService
{

    @WebMethod(operationName = "NoticeOrderTradeSuccess", action = "http://tempuri.org/IWxPayService/NoticeOrderTradeSuccess")
    @Action(input = "http://tempuri.org/IWxPayService/NoticeOrderTradeSuccess", output = "http://tempuri.org/IWxPayService/NoticeOrderTradeSuccessResponse")
    @RequestWrapper(localName = "NoticeOrderTradeSuccess", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NoticeOrderTradeSuccess")
    @ResponseWrapper(localName = "NoticeOrderTradeSuccessResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.NoticeOrderTradeSuccessResponse")
    @WebResult(name = "NoticeOrderTradeSuccessResult", targetNamespace = "http://tempuri.org/")
    public wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResult noticeOrderTradeSuccess(@WebParam(name = "orderNumber", targetNamespace = "http://tempuri.org/") java.lang.String orderNumber);

    @WebMethod(operationName = "GetJsApiParameters", action = "http://tempuri.org/IWxPayService/GetJsApiParameters")
    @Action(input = "http://tempuri.org/IWxPayService/GetJsApiParameters", output = "http://tempuri.org/IWxPayService/GetJsApiParametersResponse")
    @RequestWrapper(localName = "GetJsApiParameters", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetJsApiParameters")
    @ResponseWrapper(localName = "GetJsApiParametersResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetJsApiParametersResponse")
    @WebResult(name = "GetJsApiParametersResult", targetNamespace = "http://tempuri.org/")
    public wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfPayJsApiRequestzDDmiR8T getJsApiParameters(@WebParam(name = "orderNumber", targetNamespace = "http://tempuri.org/") java.lang.String orderNumber,
                                                                                                                                        @WebParam(name = "orderFrom", targetNamespace = "http://tempuri.org/") java.lang.Integer orderFrom);

    @WebMethod(operationName = "ScanCodeCallback", action = "http://tempuri.org/IWxPayService/ScanCodeCallback")
    @Action(input = "http://tempuri.org/IWxPayService/ScanCodeCallback", output = "http://tempuri.org/IWxPayService/ScanCodeCallbackResponse")
    @RequestWrapper(localName = "ScanCodeCallback", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ScanCodeCallback")
    @ResponseWrapper(localName = "ScanCodeCallbackResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ScanCodeCallbackResponse")
    @WebResult(name = "ScanCodeCallbackResult", targetNamespace = "http://tempuri.org/")
    public wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfScanCodeCallbackResultzDDmiR8T scanCodeCallback(@WebParam(name = "paras", targetNamespace = "http://tempuri.org/") wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models.ScanCodeCallbackParam paras);

    @WebMethod(operationName = "GetAppParameters", action = "http://tempuri.org/IWxPayService/GetAppParameters")
    @Action(input = "http://tempuri.org/IWxPayService/GetAppParameters", output = "http://tempuri.org/IWxPayService/GetAppParametersResponse")
    @RequestWrapper(localName = "GetAppParameters", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetAppParameters")
    @ResponseWrapper(localName = "GetAppParametersResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.GetAppParametersResponse")
    @WebResult(name = "GetAppParametersResult", targetNamespace = "http://tempuri.org/")
    public wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfAppPayParameterResponsex2ZDcWkJ getAppParameters(@WebParam(name = "orderNumber", targetNamespace = "http://tempuri.org/") java.lang.String orderNumber,
                                                                                                                                              @WebParam(name = "orderFrom", targetNamespace = "http://tempuri.org/") java.lang.Integer orderFrom);
}
