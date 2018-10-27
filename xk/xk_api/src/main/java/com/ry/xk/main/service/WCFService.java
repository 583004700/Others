package com.ry.xk.main.service;

import java.math.BigDecimal;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.ws.WebServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ry.xk.common.CommonConst;
import com.ry.xk.common.bo.SystemConfig;
import com.ry.xk.common.service.SystemConfigService;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.Product;
import com.ry.xk.main.bo.ProductGroup;
import com.ry.xk.main.bo.ProductGroupList;
import com.ry.xk.main.bo.UserBindDetail;
import com.ry.xk.springbootframe.config.CommonConfig;
import com.ry.xk.studentexamresult.bo.QuestionCategory;
import com.ry.xk.studentexamresult.bo.ThirdPartyAccessToken;
import com.ry.xk.studentexamresult.bo.ThirdPartyTicket;
import com.ry.xk.utils.CryptogramHelper;
import com.ry.xk.utils.DateUtil;

import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfOrderPayResultdNPiHdpe;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.PayMode;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.TradeTypeEnum;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.TransactionType;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_orderhub.OrderPayResult;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.AgainOrderSection;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.ArrayOfOrderProductSection;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.OrderProductSection;
import wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.OrderSection;
import wcf.omcorderwrapperservice.org.tempuri.OMCOrderWrapperService;
import wcf.tikuservice.com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.ArrayOfQuestionCategory;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.IdRequest;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.KnowledgePoint;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.Question;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionDisplayType;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model_tiku.GetAllQuestionCategoriesRequest;
import wcf.tikuservice.org.tempuri.TikuService;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.RequestFromTypeEnum;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.ResultTypeEnum;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.GetWeChatAccessTokenRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.GetWeChatAuthorizationInfoRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.GetWeChatTicketRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.TemplateMesageSendRequest;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatAccessTokenView;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatAuthorizationInfoView;
import wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.WeChatTicketInfoView;
import wcf.wechataccessservice.org.tempuri.WeChatAccessService;
import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_core.ServiceResultOfPayJsApiRequestzDDmiR8T;
import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models.PayJsApiRequest;
import wcf.wxpayservice.org.tempuri.WxPayService;

/**
 * WCF业务类
 * 
 * @ClassName: AuthService
 * @author 幸仁强
 * @date 2018年5月29日
 */
@Service
public class WCFService implements IWCFService
{
    private static final Logger log = LoggerFactory.getLogger(WCFService.class);

    @Autowired
    SystemConfigService systemConfigService;

    /**
     * 调用WCF接口获取OpenId
     * 
     * @Title: getOpenId
     * @author 幸仁强
     * @param partner
     * @param Code
     * @return
     * @throws Exception
     */
    @Override
    public String getOpenId(String appId, String appSecret, String code)
        throws Exception
    {
        try
        {
            SystemConfig systemConfig = systemConfigService.systemConfigs();
            wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.ObjectFactory A = new wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.ObjectFactory();
            wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.ObjectFactory B = new wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.ObjectFactory();
            GetWeChatAuthorizationInfoRequest request = new GetWeChatAuthorizationInfoRequest();
            String dateString = CryptogramHelper.encryptThreeDESECB(DateUtil.getDateString("yyyy/MM/dd HH:mm:ss"), CommonConst.WCFDESKEY);
            request.setRequestTag(A.createWcfRequestBaseRequestTag(dateString));
            request.setRequestFromType(wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.RequestFromTypeEnum.JAVA);
            request.setCode(B.createGetWeChatAuthorizationInfoRequestCode(code));
            request.setAppKey(B.createGetWeChatAuthorizationInfoRequestAppKey(CryptogramHelper.decryptThreeDESECB(appId, systemConfig.getConfigKey())));
            request.setAppSecret(B.createGetWeChatAuthorizationInfoRequestAppSecret(CryptogramHelper.decryptThreeDESECB(appSecret, systemConfig.getConfigKey())));
            WeChatAccessService weChatAccessService = new WeChatAccessService(new URL(CommonConfig.getWeChatAccessService()));
            WeChatAuthorizationInfoView view = weChatAccessService.getBasicHttpBindingIWeChatAccessService().getAuthorizationInfoV2(request);
            if (null != view)
            {
                return view.getOpenId().getValue();
            }
            else
            {
                log.error(String.format("根据appId为%s，Code为%s调用WCF获取OpenId异常", appId, code));
                throw new WebServiceException();
            }
        }
        catch (Exception e)
        {
            log.error(String.format("根据appId为%s，Code为%s调用WCF获取OpenId异常", appId, code), e);
            throw new WebServiceException();
        }
    }

    @Override
    public ThirdPartyAccessToken getThirdPartyAccessToken(Partner partner)
        throws Exception
    {
        try
        {
            SystemConfig systemConfig = systemConfigService.systemConfigs();
            wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.ObjectFactory A = new wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.ObjectFactory();
            wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.ObjectFactory B = new wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.ObjectFactory();
            GetWeChatAccessTokenRequest request = new GetWeChatAccessTokenRequest();
            String dateString = CryptogramHelper.encryptThreeDESECB(DateUtil.getDateString("yyyy/MM/dd HH:mm:ss"), CommonConst.WCFDESKEY);
            request.setAppKey(B.createGetWeChatAccessTokenRequestAppKey(CryptogramHelper.decryptThreeDESECB(partner.getWeChatAppId(), systemConfig.getConfigKey())));
            request.setAppSecret(B.createGetWeChatAccessTokenRequestAppSecret(CryptogramHelper.decryptThreeDESECB(partner.getWeChatAppSecret(), systemConfig.getConfigKey())));
            request.setRequestFromType(wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.RequestFromTypeEnum.JAVA);
            request.setRequestTag(A.createWcfRequestBaseRequestTag(dateString));
            WeChatAccessService weChatAccessService = new WeChatAccessService(new URL(CommonConfig.getWeChatAccessService()));
            WeChatAccessTokenView view = weChatAccessService.getBasicHttpBindingIWeChatAccessService().getAccessToken(request);
            if (null != view && view.getResultType() == ResultTypeEnum.SUCCESS)
            {
                // 计算时间戳.NET从0001/01/01 00:00:00开始、JAVA从1970/01/01
                // 00:00:00开始，故获取的时间不一致，这里的ticks取我们自己当前时间戳，不用接口返回的
                return new ThirdPartyAccessToken(partner.getPartnerId(), view.getAccessToken().getValue(), view.getExpiresIn().intValue() - 10 * 60, new Date().getTime());
            }
        }
        catch (Exception e)
        {
            log.error(String.format("调用WCF获取公众号accessToken失败，partnerId为%s", partner.getPartnerId()), e);
            throw new WebServiceException();
        }
        log.error(String.format("调用WCF获取公众号accessToken失败，partnerId为%s", partner.getPartnerId()));
        throw new WebServiceException();
    }

    @Override
    public ThirdPartyTicket getThirdPartyTicket(int partnerId, String accessToken)
        throws Exception
    {
        try
        {
            wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.ObjectFactory A = new wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.ObjectFactory();
            wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.ObjectFactory B = new wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.ObjectFactory();
            WeChatAccessService weChatAccessService = new WeChatAccessService(new URL(CommonConfig.getWeChatAccessService()));
            GetWeChatTicketRequest request = new GetWeChatTicketRequest();
            String dateString = CryptogramHelper.encryptThreeDESECB(DateUtil.getDateString("yyyy/MM/dd HH:mm:ss"), CommonConst.WCFDESKEY);
            request.setAccessToken(B.createWeChatRequestBaseAccessToken(accessToken));
            request.setRequestFromType(wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.RequestFromTypeEnum.JAVA);
            request.setRequestTag(A.createWcfRequestBaseRequestTag(dateString));
            WeChatTicketInfoView view = weChatAccessService.getBasicHttpBindingIWeChatAccessService().getWeChatTicket(request);
            if (null != view)
            {

                return new ThirdPartyTicket(partnerId, view.getTicket().getValue(), view.getExpiresIn().intValue() - 10 * 60, new Date().getTime());
            }
        }
        catch (Exception e)
        {
            log.error(String.format("调用WCF获取公众号Ticket失败，partnerId为%s,AccessToken为%s", partnerId, accessToken), e);
            throw new WebServiceException();
        }
        log.error(String.format("调用WCF获取公众号Ticket失败，partnerId为%s,AccessToken为%s", partnerId, accessToken));
        throw new WebServiceException();

    }

    @Override
    public Question getQuestionById(int questionId)
    {
        try
        {
            TikuService tikuService = new TikuService(new URL(CommonConfig.getTikuServicewsdl()));
            Question question = tikuService.getBasicHttpBindingITikuService().getQuestionByIdForJava(questionId);
            return question;
        }
        catch (Exception e)
        {
            log.error(MessageFormat.format("WCF获取题目失败,questionId为{0}", questionId), e);
            throw new WebServiceException();
        }
    }

    @Override
    public List<Question> getQuestions(List<Integer> questionIds)
        throws Exception
    {
        try
        {
            ArrayOfint arrayOfQuestionId = new ArrayOfint();
            arrayOfQuestionId.setInt(questionIds);
            TikuService tikuService = new TikuService(new URL(CommonConfig.getTikuServicewsdl()));
            List<Question> questions = tikuService.getBasicHttpBindingITikuService().getQuestionsForJava(arrayOfQuestionId).getQuestion();
            return questions;
        }
        catch (Exception e)
        {
            log.error("WCF获取题目失败", e);
            throw new WebServiceException();
        }
    }

    @Cacheable(value = "questionCategorys")
    @Override
    public List<QuestionCategory> getAllQuestionCategories()
        throws Exception
    {
        try
        {
            List<QuestionCategory> returnQuestionCategorys = new ArrayList<QuestionCategory>();
            GetAllQuestionCategoriesRequest request = new GetAllQuestionCategoriesRequest();
            request.setIsEnabled(true);
            request.setRequestFromType(wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.RequestFromTypeEnum.JAVA);
            TikuService tikuService = new TikuService(new URL(CommonConfig.getTikuServicewsdl()));
            ArrayOfQuestionCategory arrayOfQuestionCategory = tikuService.getBasicHttpBindingITikuService().getAllQuestionCategories(request);
            List<wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionCategory> questionCategorys = arrayOfQuestionCategory.getQuestionCategory();
            for (wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionCategory questionCategory : questionCategorys)
            {
                QuestionCategory returnQuestionCategory = new QuestionCategory();
                returnQuestionCategory.setIsAllowAdd(questionCategory.isAllowAdd().booleanValue());
                returnQuestionCategory.setCourseId(questionCategory.getCourseId().intValue());
                returnQuestionCategory.setIsEnabled(questionCategory.isEnabled().booleanValue());
                returnQuestionCategory.setOrderIndex(questionCategory.getOrderIndex().intValue());
                returnQuestionCategory.setParentCategoryId(questionCategory.getParentCategoryId().getValue());
                returnQuestionCategory.setQuestionCategoryId(questionCategory.getQuestionCategoryId().intValue());
                returnQuestionCategory.setQuestionCategoryModelId(questionCategory.getQuestionCategoryModelId().intValue());
                returnQuestionCategory.setQuestionCategoryName(questionCategory.getQuestionCategoryName().getValue());
                returnQuestionCategory.setQuestionDisplayTypeId(questionCategory.getQuestionDisplayTypeId().intValue());
                returnQuestionCategory.setRootCategoryId(questionCategory.getRootCategoryId().intValue());
                returnQuestionCategorys.add(returnQuestionCategory);
            }
            return returnQuestionCategorys;
        }
        catch (Exception e)
        {
            log.error("WCF获取题型失败", e);
            throw new WebServiceException();
        }

    }

    @Override
    public QuestionDisplayType getQuestionDisplayType(int questionDisplayTypeid)
    {
        try
        {
            IdRequest idRequest = new IdRequest();
            idRequest.setId(questionDisplayTypeid);
            idRequest.setRequestFromType(wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.RequestFromTypeEnum.JAVA);
            TikuService tikuService = new TikuService(new URL(CommonConfig.getTikuServicewsdl()));
            return tikuService.getBasicHttpBindingITikuService().getQuestionDisplayType(idRequest);
        }
        catch (Exception e)
        {
            log.error("WCF获取题目显示方式失败", e);
            return null;
        }
    }

    @Cacheable(value = "questionDisplayTypes")
    @Override
    public List<QuestionDisplayType> getGetQuestionDisplayTypes()
    {
        try
        {
            TikuService tikuService = new TikuService(new URL(CommonConfig.getTikuServicewsdl()));
            return tikuService.getBasicHttpBindingITikuService().getGetQuestionDisplayTypes().getQuestionDisplayType();
        }
        catch (Exception e)
        {
            log.error("WCF获取题目显示方式失败", e);
            return null;
        }
    }

    @Override
    public List<KnowledgePoint> getKnowledgePoints(int courseId)
        throws Exception
    {
        try
        {
            TikuService tikuService = new TikuService(new URL(CommonConfig.getTikuServicewsdl()));
            return tikuService.getBasicHttpBindingITikuService().getKnowledgePoints(courseId).getKnowledgePoints().getValue().getKnowledgePoint();
        }
        catch (Exception e)
        {
            log.error("WCF获取知识点失败", e);
            throw new WebServiceException();
        }

    }

    @Override
    public void templateMesageSend(String accessToken, String text)
        throws Exception
    {
        TemplateMesageSendRequest templateMesageSendRequest = new TemplateMesageSendRequest();
        wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.ObjectFactory o1 = new wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model_thirdparty.ObjectFactory();

        templateMesageSendRequest.setAccessToken(o1.createWeChatRequestBaseAccessToken(accessToken));
        wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.ObjectFactory o2 = new wcf.wechataccessservice.org.datacontract.schemas._2004._07.motk_model.ObjectFactory();
        templateMesageSendRequest.setRequestFromType(RequestFromTypeEnum.JAVA);
        String requestTag = CryptogramHelper.encryptThreeDESECB(DateUtil.format(new Date(), "yyyy/MM/dd HH:mm:ss"), CommonConst.WCFDESKEY);
        templateMesageSendRequest.setRequestTag(o2.createWcfRequestBaseRequestTag(requestTag));
        templateMesageSendRequest.setText(o1.createTemplateMesageSendRequestText(text));
        WeChatAccessService weChatAccessService = new WeChatAccessService(new URL(CommonConfig.getWeChatAccessService()));
        weChatAccessService.getBasicHttpBindingIWeChatAccessService().templateMesageSend(templateMesageSendRequest);
    }

    @Override
    public String createOmcOrder(Product product, ProductGroupList productGroupList, float price, Partner partner, UserBindDetail userBindDetail, String ip)
        throws Exception
    {
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.ObjectFactory A = new wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.ObjectFactory();
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.ObjectFactory B = new wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_core_common.ObjectFactory();
        OrderSection orderSection = new OrderSection();
        orderSection.setClientId(1);
        orderSection.setOpenID(A.createOrderSectionOpenID(userBindDetail.getBindContent()));
        orderSection.setOrderCreateUserId(userBindDetail.getUserId());
        ProductGroup productGroup = productGroupList.getProductGroups().stream().filter(o -> o.getProductGroupId() == product.getProductGroupId()).findFirst().orElse(null);
        if (null == productGroup)
        {
            log.error(String.format("WCF创建订单时，根据product的ProductGroupId为%s没匹配到ProductGroup信息", product.getProductGroupId()));
            throw new Exception();
        }
        String orderDes = String.format(productGroup.getProductGroupName(), product.getProductName());
        orderSection.setOrderDes(A.createOrderSectionOrderDes(orderDes));
        BigDecimal totalPrice = new BigDecimal(price);
        orderSection.setOrderTotalPrice(totalPrice);
        orderSection.setPaymentingMode(B.createPayMode(PayMode.WE_CHAT));
        orderSection.setProductInfos(A.createOrderSectionProductInfos(createOmcOrderBuildArrayOfOrderProductSection(product, totalPrice)));
        orderSection.setSalseReference(A.createOrderSectionSalseReference(""));
        orderSection.setSourcePlantCode(A.createOrderSectionSourcePlantCode(partner.getSourcePlantCode()));
        // TODO SourcePlantId是否必填
        orderSection.setSourcePlantId(0);
        orderSection.setSpbillCreateIp(A.createOrderSectionSpbillCreateIp(ip));
        orderSection.setTargetUserID(userBindDetail.getUserId());
        orderSection.setTradingType(B.createTradeTypeEnum(TradeTypeEnum.JSAPI));
        try
        {
            OMCOrderWrapperService omcOrderWrapperService = new OMCOrderWrapperService(new URL(CommonConfig.getOmcOrderWrapperServicewsdl()));
            return omcOrderWrapperService.getWSHttpBindingIOMCOrderWrapperService().createOmcOrder(orderSection).getEntity().getValue();
        }
        catch (Exception e)
        {
            log.error(String.format("WCF创建订单失败，产品ID为%s", product.getProductId()), e);
            throw new WebServiceException();
        }
    }

    /**
     * 组装创建订单入参
     * 
     * @Title: createOmcOrderBuildArrayOfOrderProductSection
     * @author 幸仁强
     * @param product
     * @param totalPrice
     * @return
     */
    private ArrayOfOrderProductSection createOmcOrderBuildArrayOfOrderProductSection(Product product, BigDecimal totalPrice)
    {
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.ObjectFactory A = new wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.ObjectFactory();
        OrderProductSection orderProductSection = new OrderProductSection();
        orderProductSection.setOriginalPrice(totalPrice);
        orderProductSection.setProductCount(1);
        orderProductSection.setProductDetailID(product.getProductDetails().get(0).getProductDetailId());
        orderProductSection.setProductGroupID(product.getProductGroupId());
        orderProductSection.setProductID((long)product.getProductId());
        orderProductSection.setProductInfo(A.createOrderProductSectionProductInfo(product.getProductName()));
        orderProductSection.setProductName(A.createOrderProductSectionProductName(product.getProductName()));
        orderProductSection.setProductNumber(A.createOrderProductSectionProductNumber(product.getProductNumber()));
        orderProductSection.setProductPicture(A.createOrderProductSectionProductPicture(product.getProductPicture()));
        orderProductSection.setProductSourceTypeID(product.getProductRelations().get(0).getProductSourceTypeId());
        orderProductSection.setProductTotalPrice(totalPrice);
        ArrayOfOrderProductSection arrayOfOrderProductSection = new ArrayOfOrderProductSection();
        arrayOfOrderProductSection.getOrderProductSection().add(orderProductSection);
        return arrayOfOrderProductSection;
    }

    @Override
    public String againCreateOrder(UserBindDetail userBindDetail, String ip, String orderNum)
        throws Exception
    {
        wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.ObjectFactory A = new wcf.omcorderwrapperservice.org.datacontract.schemas._2004._07.omcsystem_services_servicecontract.ObjectFactory();
        AgainOrderSection orderSection = new AgainOrderSection();
        orderSection.setOpenID(A.createAgainOrderSectionOpenID(userBindDetail.getBindContent()));
        orderSection.setOrderFrom(1);
        orderSection.setOrderNumber(A.createAgainOrderSectionOrderNumber(orderNum));
        orderSection.setPaymentingMode(PayMode.WE_CHAT);
        orderSection.setPayUserId(userBindDetail.getUserId());
        orderSection.setSpbillCreateIp(A.createAgainOrderSectionSpbillCreateIp(ip));
        orderSection.setTradingType(TradeTypeEnum.JSAPI);
        OMCOrderWrapperService omcOrderWrapperService = new OMCOrderWrapperService(new URL(CommonConfig.getOmcOrderWrapperServicewsdl()));
        ServiceResultOfOrderPayResultdNPiHdpe serviceResultOfOrderPayResultdNPiHdpe = omcOrderWrapperService.getWSHttpBindingIOMCOrderWrapperService().againCreateOrder(orderSection);
        OrderPayResult orderPayResult = serviceResultOfOrderPayResultdNPiHdpe.getEntity().getValue();
        if (orderPayResult.getTransactionType() == TransactionType.WAIT_PAY)
        {
            return orderPayResult.getOrderNumber().getValue();
        }
        return null;
    }

    @Override
    public PayJsApiRequest getJsApiParameters(String orderNum)
        throws Exception
    {
        WxPayService wxPayService = new WxPayService(new URL(CommonConfig.getWxPayService()));
        ServiceResultOfPayJsApiRequestzDDmiR8T serviceResultOfPayJsApiRequestzDDmiR8T = wxPayService.getWSHttpBindingIWxPayService().getJsApiParameters(orderNum, 1);
        return serviceResultOfPayJsApiRequestzDDmiR8T.getEntity().getValue();
    }

}
