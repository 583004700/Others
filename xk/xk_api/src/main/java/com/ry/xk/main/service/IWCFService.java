package com.ry.xk.main.service;

import java.util.List;

import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.Product;
import com.ry.xk.main.bo.ProductGroupList;
import com.ry.xk.main.bo.UserBindDetail;
import com.ry.xk.studentexamresult.bo.QuestionCategory;
import com.ry.xk.studentexamresult.bo.ThirdPartyAccessToken;
import com.ry.xk.studentexamresult.bo.ThirdPartyTicket;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.KnowledgePoint;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.Question;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionDisplayType;
import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models.PayJsApiRequest;

/**
 * WCF业务接口
 * 
 * @ClassName: IAuthService
 * @author 幸仁强
 * @date 2018年5月29日
 */
public interface IWCFService
{
    /**
     * 获取OpenId
     * 
     * @Title: getOpenId
     * @author 幸仁强
     * @param partner
     * @param Code
     * @return
     */
    public String getOpenId(String appId, String appSecret, String code)
        throws Exception;

    /**
     * 获取公众号AccessToken
     * 
     * @Title: getThirdPartyAccessToken
     * @author 幸仁强
     * @param partner
     * @return
     * @throws Exception
     */
    public ThirdPartyAccessToken getThirdPartyAccessToken(Partner partner)
        throws Exception;

    /**
     * 获取公众号Ticket
     * 
     * @Title: getThirdPartyTicket
     * @author 幸仁强
     * @param partner
     * @return
     * @throws Exception
     */
    public ThirdPartyTicket getThirdPartyTicket(int partnerId, String accessToken)
        throws Exception;

    /**
     * 根据ID获取题目信息
     * 
     * @Title: getQuestionInfo
     * @author 幸仁强
     * @param questionId
     * @return
     * @throws Exception
     */
    public Question getQuestionById(int questionId)
        throws Exception;

    /**
     * 根据IDS批量获取题目信息
     * 
     * @Title: getQuestions
     * @author 幸仁强
     * @param questionIds
     * @return
     */
    public List<Question> getQuestions(List<Integer> questionIds)
        throws Exception;

    /**
     * 获取所有题目类型
     * 
     * @Title: getAllQuestionCategories
     * @author 幸仁强
     * @return
     * @throws Exception
     */
    public List<QuestionCategory> getAllQuestionCategories()
        throws Exception;

    /**
     * 获取题目显示方式
     * 
     * @Title: getQuestionDisplayType
     * @author 幸仁强
     * @return
     * @throws Exception
     */
    public QuestionDisplayType getQuestionDisplayType(int questionDisplayTypeid);
    
    /**
     * 一次获取全部题目显示方式
     * @Title: getGetQuestionDisplayTypes
     * @author 幸仁强
     * @return
     */
    public List<QuestionDisplayType> getGetQuestionDisplayTypes();

    /**
     * 获取题目题目知识点
     * 
     * @Title: getQuestionDisplayType
     * @author 幸仁强
     * @return
     * @throws Exception
     */
    public List<KnowledgePoint> getKnowledgePoints(int courseId)
        throws Exception;

    /**
     * 发送模板消息
     */
    public void templateMesageSend(String accessToken, String text)
        throws Exception;

    /**
     * 创建订单
     * 
     * @Title: createOmcOrder
     * @author 幸仁强
     * @return
     * @throws Exception
     */
    public String createOmcOrder(Product product, ProductGroupList productGroupList, float price, Partner partner, UserBindDetail userBindDetail, String ip)
        throws Exception;

    /**
     * 获取weChatOrderNum（订单中心调用微信统一下单接口生成预支付ID并且把微信订单编号返回）
     * 
     * @Title: againCreateOrder
     * @author 幸仁强
     * @param userBindDetail
     * @param ip
     * @param orderNum
     * @return
     * @throws Exception
     */
    public String againCreateOrder(UserBindDetail userBindDetail, String ip, String orderNum)
        throws Exception;

    /**
     * 获取JSAPI初始化参数，提供给前端唤醒支付窗口
     * 
     * @Title: getJsApiParameters
     * @author 幸仁强
     * @param orderNum
     * @return
     * @throws Exception
     */
    public PayJsApiRequest getJsApiParameters(String orderNum)
        throws Exception;
}
