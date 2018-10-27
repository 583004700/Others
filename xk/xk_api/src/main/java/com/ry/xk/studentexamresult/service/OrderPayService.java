package com.ry.xk.studentexamresult.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ry.xk.common.CommonConst;
import com.ry.xk.common.bo.SystemConfig;
import com.ry.xk.common.bo.UserOrder;
import com.ry.xk.common.service.ISystemConfigService;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.PartnerExtension;
import com.ry.xk.main.bo.ProductRelation;
import com.ry.xk.main.bo.User;
import com.ry.xk.main.dao.ICourseDao;
import com.ry.xk.main.dao.IPartnerDao;
import com.ry.xk.main.dao.IProductRelationDao;
import com.ry.xk.main.dao.IUserBindDetailDao;
import com.ry.xk.main.dao.IUserDao;
import com.ry.xk.main.dao.IUserOrderDao;
import com.ry.xk.main.service.IWCFService;
import com.ry.xk.main.service.IWeChatJsSdkInitService;
import com.ry.xk.studentexamresult.bo.ExamPaper;
import com.ry.xk.studentexamresult.bo.UserResource;
import com.ry.xk.studentexamresult.bo.UserResourceList;
import com.ry.xk.studentexamresult.dao.IExamPaperDao;
import com.ry.xk.studentexamresult.dao.IUserResourceDao;
import com.ry.xk.utils.DateUtil;

@Service
public class OrderPayService implements IOrderPayService
{

    private static final Logger log = LoggerFactory.getLogger(OrderPayService.class);

    @Autowired
    IProductRelationDao productRelationDao;

    @Autowired
    IExamPaperDao examPaperDao;

    @Autowired
    IUserResourceDao userResourceDao;

    @Autowired
    IUserOrderDao userOrderDao;

    @Autowired
    IWCFService wCFService;

    @Autowired
    ISystemConfigService systemConfigService;

    @Autowired
    IWeChatJsSdkInitService weChatJsSdkInitService;

    @Autowired
    IPartnerDao partnerDao;

    @Autowired
    IUserBindDetailDao userBindDetailDao;

    @Autowired
    ICourseDao courseDao;

    @Autowired
    IUserDao userDao;

    /**
     * 支付结果通知
     * 
     * @param userId
     * @param productId
     * @param orderNumber
     * @return
     * @throws Exception
     */
    public boolean payNotify(int userId, int productId, String orderNumber)
        throws Exception
    {

        ProductRelation productRelation = productRelationDao.getByPrimary(productId, 0, CommonConst.PRODUCTSOURCETYPEID_EXAMPAPER);
        boolean result = false;
        if (productRelation != null && productRelation.getReferenceId() != 0)
        {
            User user = userDao.get(userId);
            if (user == null)
            {
                log.error(String.format("根据userID%s查询用户为空", userId));
            }
            int examPaperId = productRelation.getReferenceId();
            ExamPaper examPaper = examPaperDao.get(examPaperId);
            boolean isPack = examPaper.getIsPack() == 1 ? true : false;
            result = isPack ? buyPack(user.getPartnerId(), userId, examPaper) : buyNotPack(userId, examPaperId);
            if (result)
            {
                UserOrder userOrder = new UserOrder();
                userOrder.setStatusFlag(1);
                userOrder.setOrderNumber(orderNumber);
                result = userOrderDao.update(userOrder) > 0 ? true : false;
            }
            if (result)
            {
                try
                {
                    templateMesageSend(user.getPartnerId(), userId, examPaper, result, orderNumber);
                }
                catch (Exception e)
                {
                    log.error("发送通知异常partnerId" + user.getPartnerId() + "userId" + userId, e);
                }
            }

        }
        return result;
    }

    /**
     * 结果通知
     * 
     * @param result
     */
    @Async
    public void templateMesageSend(int partnerId, int userId, ExamPaper examPaper, boolean result, String orderNumber)
        throws Exception
    {
        try
        {
            SystemConfig systemConfig = systemConfigService.systemConfigs();
            String text = systemConfig.getPayedNotifyTemplate();
            log.info("获取到模板内容" + text);
            String openId = userBindDetailDao.getByUserId(userId).getBindContent();
            log.info("得到openId" + openId);
            String examPaperName = examPaper.getExamPaperName();
            log.info("试卷名称为" + examPaperName);
            double price = userOrderDao.getByOrderNumber(orderNumber).getPrice();
            log.info("试卷价格为" + price);
            Partner partner = partnerDao.get(partnerId);
            PartnerExtension partnerExtension = JSONObject.parseObject(partner.getPartnerExtension(), PartnerExtension.class);
            text = String.format(text, openId ,partnerExtension.getTemplateId() ,"", "您好，您已支付成功", "#173177", orderNumber, "#173177", examPaperName, "#173177", price, "#173177", DateUtil.format(new Date(), "yyyy/MM/dd HH:mm"),
                "#173177", "", "#173177");
            String accessToken = weChatJsSdkInitService.getWaChatAccessToken(partner).getAccessToken();
            wCFService.templateMesageSend(accessToken, text);
        }
        catch (Exception e)
        {
            log.error("发送通知异常", e);
        }
    }
    
    

    /**
     * 购买的是套卷
     * 
     * @return
     */
    private boolean buyPack(int partnerId, int userId, ExamPaper examPaper)
    {
        int courseId = examPaper.getCourseId();
        List<ExamPaper> examPapers = examPaperDao.getExamPaper(partnerId, courseId, 0, Integer.MAX_VALUE);
        UserResourceList userResourceList = userResourceDao.getUserResource(userId, CommonConst.EXAM_PAPER);
        if (userResourceList == null || userResourceList.getUserResource() == null)
        {
            userResourceList = new UserResourceList();
            List<UserResource> userResources = new ArrayList<UserResource>();
            userResourceList.setUserResource(userResources);
        }
        List<UserResource> userResources = userResourceList.getUserResource();
        // 得到在资源表中不存在的试卷
        List<ExamPaper> notExists = examPapers.stream().filter(o -> {
            return !userResources.stream().anyMatch(n -> n.getResourceId() == o.getExamPaperId());
        }).collect(Collectors.toList());

        List<UserResource> userResourcesList = new ArrayList<UserResource>();
        notExists.forEach(o -> {
            UserResource userResource = new UserResource();
            userResource.setResourceTypeId(CommonConst.EXAM_PAPER);
            userResource.setUserId(userId);
            userResource.setResourceId(o.getExamPaperId());
            userResourcesList.add(userResource);
        });
        int rowCount = 0;
        try
        {
            rowCount = userResourceDao.addUserResourceList(userResourcesList);
        }
        catch (Exception e)
        {
            log.error("用户" + userId + "批量购买试卷失败courseId" + courseId, e);
        }
        return rowCount > 0;
    }

    /**
     * 购买的是非套卷
     * 
     * @return
     */
    private boolean buyNotPack(int userId, int examPaperId)
    {
        UserResource userResource = new UserResource();
        userResource.setResourceId(examPaperId);
        userResource.setUserId(userId);
        userResource.setResourceTypeId(CommonConst.EXAM_PAPER);
        int rowCount = userResourceDao.addUserResource(userResource);
        return rowCount > 0;
    }

    /**
     * 前端获取支付结果
     * 
     * @param orderNumber
     * @return
     */
    public boolean payResult(String orderNumber)
    {
        boolean payResult = false;
        UserOrder userOrder = userOrderDao.getByOrderNumber(orderNumber);
        if (userOrder != null && userOrder.getStatusFlag() == 1)
        {
            payResult = true;
        }
        return payResult;
    }
}
