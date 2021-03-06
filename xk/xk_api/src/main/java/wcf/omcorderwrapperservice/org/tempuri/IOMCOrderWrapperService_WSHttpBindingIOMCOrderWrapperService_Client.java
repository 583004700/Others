
package wcf.omcorderwrapperservice.org.tempuri;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-05-18T10:58:09.921+08:00
 * Generated source version: 3.2.4
 *
 */
public final class IOMCOrderWrapperService_WSHttpBindingIOMCOrderWrapperService_Client {

    private static final QName SERVICE_NAME = new QName("http://tempuri.org/", "OMCOrderWrapperService");

    private IOMCOrderWrapperService_WSHttpBindingIOMCOrderWrapperService_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = OMCOrderWrapperService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        OMCOrderWrapperService ss = new OMCOrderWrapperService(wsdlURL, SERVICE_NAME);
        IOMCOrderWrapperService port = ss.getWSHttpBindingIOMCOrderWrapperService();

        {
        System.out.println("Invoking closeExpireOrder...");
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResult _closeExpireOrder__return = port.closeExpireOrder();
            System.out.println("closeExpireOrder.result=" + _closeExpireOrder__return);

        } catch (IOMCOrderWrapperServiceCloseExpireOrderErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_CloseExpireOrder_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getProductOrderNumber...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.GetProductOrderNumberRequest _getProductOrderNumber_request = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfstring _getProductOrderNumber__return = port.getProductOrderNumber(_getProductOrderNumber_request);
            System.out.println("getProductOrderNumber.result=" + _getProductOrderNumber__return);

        } catch (IOMCOrderWrapperServiceGetProductOrderNumberErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_GetProductOrderNumber_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking updateOrderPayUserId...");
        java.lang.String _updateOrderPayUserId_orderNumber = "";
        java.lang.Integer _updateOrderPayUserId_payUserId = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResult _updateOrderPayUserId__return = port.updateOrderPayUserId(_updateOrderPayUserId_orderNumber, _updateOrderPayUserId_payUserId);
            System.out.println("updateOrderPayUserId.result=" + _updateOrderPayUserId__return);

        } catch (IOMCOrderWrapperServiceUpdateOrderPayUserIdErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_UpdateOrderPayUserId_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking againCreateOrder...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.AgainOrderSection _againCreateOrder_orderSection = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfOrderPayResultdNPiHdpe _againCreateOrder__return = port.againCreateOrder(_againCreateOrder_orderSection);
            System.out.println("againCreateOrder.result=" + _againCreateOrder__return);

        } catch (IOMCOrderWrapperServiceAgainCreateOrderErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_AgainCreateOrder_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking closeOrder...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.CloseOrderRequest _closeOrder_param = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResult _closeOrder__return = port.closeOrder(_closeOrder_param);
            System.out.println("closeOrder.result=" + _closeOrder__return);

        } catch (IOMCOrderWrapperServiceCloseOrderErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_CloseOrder_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking sendFreeOrderSuccessEvent...");
        java.lang.String _sendFreeOrderSuccessEvent_orderNo = "";
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfboolean _sendFreeOrderSuccessEvent__return = port.sendFreeOrderSuccessEvent(_sendFreeOrderSuccessEvent_orderNo);
            System.out.println("sendFreeOrderSuccessEvent.result=" + _sendFreeOrderSuccessEvent__return);

        } catch (IOMCOrderWrapperServiceSendFreeOrderSuccessEventErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_SendFreeOrderSuccessEvent_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking addOrderStatusChangeLog...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.OrderstatusChangeLog _addOrderStatusChangeLog_log = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResult _addOrderStatusChangeLog__return = port.addOrderStatusChangeLog(_addOrderStatusChangeLog_log);
            System.out.println("addOrderStatusChangeLog.result=" + _addOrderStatusChangeLog__return);

        } catch (IOMCOrderWrapperServiceAddOrderStatusChangeLogErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_AddOrderStatusChangeLog_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking noticeOrderTradeSuccess...");
        java.lang.String _noticeOrderTradeSuccess_orderNumber = "";
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResult _noticeOrderTradeSuccess__return = port.noticeOrderTradeSuccess(_noticeOrderTradeSuccess_orderNumber);
            System.out.println("noticeOrderTradeSuccess.result=" + _noticeOrderTradeSuccess__return);

        } catch (IOMCOrderWrapperServiceNoticeOrderTradeSuccessErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_NoticeOrderTradeSuccess_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking createOrder...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.OrderSection _createOrder_orderSection = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfstring _createOrder__return = port.createOrder(_createOrder_orderSection);
            System.out.println("createOrder.result=" + _createOrder__return);

        } catch (IOMCOrderWrapperServiceCreateOrderErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_CreateOrder_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking noticeOrderFailure...");
        java.lang.String _noticeOrderFailure_orderNumber = "";
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResult _noticeOrderFailure__return = port.noticeOrderFailure(_noticeOrderFailure_orderNumber);
            System.out.println("noticeOrderFailure.result=" + _noticeOrderFailure__return);

        } catch (IOMCOrderWrapperServiceNoticeOrderFailureErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_NoticeOrderFailure_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking noticeCallBackSuccess...");
        java.lang.String _noticeCallBackSuccess_orderNumber = "";
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResult _noticeCallBackSuccess__return = port.noticeCallBackSuccess(_noticeCallBackSuccess_orderNumber);
            System.out.println("noticeCallBackSuccess.result=" + _noticeCallBackSuccess__return);

        } catch (IOMCOrderWrapperServiceNoticeCallBackSuccessErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_NoticeCallBackSuccess_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getOrderPayMode...");
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfArrayOfOrderPayModedNPiHdpe _getOrderPayMode__return = port.getOrderPayMode();
            System.out.println("getOrderPayMode.result=" + _getOrderPayMode__return);

        } catch (IOMCOrderWrapperServiceGetOrderPayModeErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_GetOrderPayMode_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getOrderById...");
        java.lang.Long _getOrderById_orderId = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfOrderdNPiHdpe _getOrderById__return = port.getOrderById(_getOrderById_orderId);
            System.out.println("getOrderById.result=" + _getOrderById__return);

        } catch (IOMCOrderWrapperServiceGetOrderByIdErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_GetOrderById_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking updateOrderPayMode...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.OrderPayTrade _updateOrderPayMode_orderPayTrade = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResult _updateOrderPayMode__return = port.updateOrderPayMode(_updateOrderPayMode_orderPayTrade);
            System.out.println("updateOrderPayMode.result=" + _updateOrderPayMode__return);

        } catch (IOMCOrderWrapperServiceUpdateOrderPayModeErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_UpdateOrderPayMode_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getOrderInfoByNumber...");
        java.lang.String _getOrderInfoByNumber_orderNumber = "";
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfOrderdNPiHdpe _getOrderInfoByNumber__return = port.getOrderInfoByNumber(_getOrderInfoByNumber_orderNumber);
            System.out.println("getOrderInfoByNumber.result=" + _getOrderInfoByNumber__return);

        } catch (IOMCOrderWrapperServiceGetOrderInfoByNumberErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_GetOrderInfoByNumber_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getOrderQuantity...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.QueryOrderQuantityParam _getOrderQuantity_param = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfArrayOfOrderStatusQuantitydNPiHdpe _getOrderQuantity__return = port.getOrderQuantity(_getOrderQuantity_param);
            System.out.println("getOrderQuantity.result=" + _getOrderQuantity__return);

        } catch (IOMCOrderWrapperServiceGetOrderQuantityErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_GetOrderQuantity_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking checkProductExistsOrder...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.CheckProductExistsOrderRequest _checkProductExistsOrder_request = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfboolean _checkProductExistsOrder__return = port.checkProductExistsOrder(_checkProductExistsOrder_request);
            System.out.println("checkProductExistsOrder.result=" + _checkProductExistsOrder__return);

        } catch (IOMCOrderWrapperServiceCheckProductExistsOrderErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_CheckProductExistsOrder_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getOrderScanCodePayUrl...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.GetOrderPayUrlRequest _getOrderScanCodePayUrl_request = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfstring _getOrderScanCodePayUrl__return = port.getOrderScanCodePayUrl(_getOrderScanCodePayUrl_request);
            System.out.println("getOrderScanCodePayUrl.result=" + _getOrderScanCodePayUrl__return);

        } catch (IOMCOrderWrapperServiceGetOrderScanCodePayUrlErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_GetOrderScanCodePayUrl_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getOrdersByQueryParams...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.QueryOrdersParam _getOrdersByQueryParams_pParams = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfPageOfOrderdNPiHdpem06JEnuP _getOrdersByQueryParams__return = port.getOrdersByQueryParams(_getOrdersByQueryParams_pParams);
            System.out.println("getOrdersByQueryParams.result=" + _getOrdersByQueryParams__return);

        } catch (IOMCOrderWrapperServiceGetOrdersByQueryParamsErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_GetOrdersByQueryParams_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getOrdersByFilterParams...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.OrderFilterParam _getOrdersByFilterParams_oParams = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfPageOfOrderdNPiHdpem06JEnuP _getOrdersByFilterParams__return = port.getOrdersByFilterParams(_getOrdersByFilterParams_oParams);
            System.out.println("getOrdersByFilterParams.result=" + _getOrdersByFilterParams__return);

        } catch (IOMCOrderWrapperServiceGetOrdersByFilterParamsErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_GetOrdersByFilterParams_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking changeStatus...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.ChangeOrderStatusRequest _changeStatus_request = null;
        try {
            java.lang.Boolean _changeStatus__return = port.changeStatus(_changeStatus_request);
            System.out.println("changeStatus.result=" + _changeStatus__return);

        } catch (IOMCOrderWrapperServiceChangeStatusErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_ChangeStatus_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getOrderIsSuccess...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.QueryOrderParamSection _getOrderIsSuccess_queryOrder = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfTransactionType5Y56Hjij _getOrderIsSuccess__return = port.getOrderIsSuccess(_getOrderIsSuccess_queryOrder);
            System.out.println("getOrderIsSuccess.result=" + _getOrderIsSuccess__return);

        } catch (IOMCOrderWrapperServiceGetOrderIsSuccessErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_GetOrderIsSuccess_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking createOmcOrder...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.OrderSection _createOmcOrder_orderSection = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfstring _createOmcOrder__return = port.createOmcOrder(_createOmcOrder_orderSection);
            System.out.println("createOmcOrder.result=" + _createOmcOrder__return);

        } catch (IOMCOrderWrapperServiceCreateOmcOrderErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_CreateOmcOrder_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getExistsOrderByProduct...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.CheckProductExistsOrderRequest _getExistsOrderByProduct_request = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfOrderdNPiHdpe _getExistsOrderByProduct__return = port.getExistsOrderByProduct(_getExistsOrderByProduct_request);
            System.out.println("getExistsOrderByProduct.result=" + _getExistsOrderByProduct__return);

        } catch (IOMCOrderWrapperServiceGetExistsOrderByProductErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_GetExistsOrderByProduct_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getOrderScanCodePayShortUrl...");
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub_models.GetOrderPayUrlRequest _getOrderScanCodePayShortUrl_request = null;
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfstring _getOrderScanCodePayShortUrl__return = port.getOrderScanCodePayShortUrl(_getOrderScanCodePayShortUrl_request);
            System.out.println("getOrderScanCodePayShortUrl.result=" + _getOrderScanCodePayShortUrl__return);

        } catch (IOMCOrderWrapperServiceGetOrderScanCodePayShortUrlErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_GetOrderScanCodePayShortUrl_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getOrderByNumber...");
        java.lang.String _getOrderByNumber_orderNumber = "";
        try {
            wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfOrderdNPiHdpe _getOrderByNumber__return = port.getOrderByNumber(_getOrderByNumber_orderNumber);
            System.out.println("getOrderByNumber.result=" + _getOrderByNumber__return);

        } catch (IOMCOrderWrapperServiceGetOrderByNumberErrorInfoFaultFaultMessage e) {
            System.out.println("Expected exception: IOMCOrderWrapperService_GetOrderByNumber_ErrorInfoFault_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
