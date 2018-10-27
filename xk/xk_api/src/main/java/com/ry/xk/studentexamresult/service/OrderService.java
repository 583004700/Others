package com.ry.xk.studentexamresult.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.xk.common.CommonConst;
import com.ry.xk.common.bo.UserOrder;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.PartnerCourseMapping;
import com.ry.xk.main.bo.Product;
import com.ry.xk.main.bo.ProductGroupList;
import com.ry.xk.main.bo.UserBindDetail;
import com.ry.xk.main.dao.IPartnerDao;
import com.ry.xk.main.dao.IProductDao;
import com.ry.xk.main.dao.IUserBindDetailDao;
import com.ry.xk.main.dao.IUserOrderDao;
import com.ry.xk.main.service.IWCFService;
import com.ry.xk.request.bo.CreateOrderApiRequest;
import com.ry.xk.request.bo.ExamPaperPayInfoApiRequest;
import com.ry.xk.response.bo.BuildOrderModule;
import com.ry.xk.response.bo.ExamPaperPayInfoModule;
import com.ry.xk.studentexamresult.bo.ExamPaper;
import com.ry.xk.studentexamresult.dao.IExamPaperDao;
import com.ry.xk.utils.UrlUtil;

import wcf.wxpayservice.org.datacontract.schemas._2004._07.omcsystem_imoduleservices_wechat_models.PayJsApiRequest;

/**
 * 订单业务类
 * 
 * @ClassName: AuthService
 * @author 幸仁强
 * @date 2018年6月7日
 */
@Service
public class OrderService implements IOrderService
{
    // 日志操作对象
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    IUserOrderDao userOrderDao;

    @Autowired
    IProductDao productDao;

    @Autowired
    IExamPaperDao examPaperDao;

    @Autowired
    IPartnerDao partnerDao;

    @Autowired
    IUserBindDetailDao userBindDetailDao;

    @Autowired
    IWCFService wcfService;

    @Override
    public BuildOrderModule createOrder(CreateOrderApiRequest request, String ip)
        throws Exception
    {
        int examPaperId = 0;
        UserBindDetail userBindDetail = userBindDetailDao.getByUserId(request.getUserId());
        if (request.getIsBuyAll())
        {
            int courseId = UrlUtil.idDecrypt(request.getCourseId(), Integer.class);
            int partnerId = request.getPartnerId();
            examPaperId = examPaperDao.getPackExamPaperIdByCourseIdAndPartnerId(courseId, partnerId);
        }
        else
        {
            examPaperId = UrlUtil.idDecrypt(request.getExamPaperId(), Integer.class);
        }
        if (examPaperId == 0)
        {
            log.error(String.format("创建订单时，examPaperId获取失败，isBuyAll为%s", request.getIsBuyAll()));
            throw new Exception();
        }
        Product product = productDao.getProductByReferenceId(examPaperId);
        ProductGroupList productGroupList = productDao.getProductGroup();
        if (null == product || null == productGroupList)
        {
            log.error(String.format("创建订单时，产品信息获取失败，isBuyAll为%s", request.getIsBuyAll()));
            throw new Exception();
        }
        ExamPaper examPaper = examPaperDao.get(examPaperId);
        Partner partner = partnerDao.get(request.getPartnerId());
        float price = examPaper.getPrice();
        if (examPaper.getIsPack() == 1)
        {
            PartnerCourseMapping partnerCourseMapping = partner.getPartnerCourseMappings().stream().filter(o -> o.getCourseId() == examPaper.getCourseId()).findFirst().orElse(null);
            if (null == partnerCourseMapping)
            {
                log.error(String.format("创建订单时(购买套卷)，根据examPaper的courseId为%s没匹配到partner对象里面的partnerCourseMapping信息", examPaper.getCourseId()));
                throw new Exception();
            }
            else
            {
                price = partnerCourseMapping.getPackagePrice();
            }
        }
        String orderNum = wcfService.createOmcOrder(product, productGroupList, price, partner, userBindDetail, ip);
        if (StringUtils.isNotBlank(orderNum))
        {
            UserOrder userOrder = new UserOrder();
            userOrder.setOrderNumber(orderNum);
            userOrder.setPrice(price);
            userOrder.setProductId(product.getProductId());
            userOrder.setUserId(request.getUserId());
            if (userOrderDao.insert(userOrder) > 0)
            {
                return new BuildOrderModule(CommonConst.RT_SUC, orderNum);
            }
        }
        return null;
    }

    @Override
    public ExamPaperPayInfoModule getWeChatPayInfo(ExamPaperPayInfoApiRequest request, String ip)
        throws Exception
    {
        UserBindDetail userBindDetail = userBindDetailDao.getByUserId(request.getUserId());
        String weChatOrderNum = wcfService.againCreateOrder(userBindDetail, ip, request.getOrderNum());
        PayJsApiRequest payJsApiRequest = wcfService.getJsApiParameters(weChatOrderNum);
        if (null == payJsApiRequest)
        {
            return null;
        }
        return new ExamPaperPayInfoModule(CommonConst.RT_SUC, payJsApiRequest.getAppId().getValue(), payJsApiRequest.getNonceStr().getValue(), payJsApiRequest.getTimeStamp().getValue(),
            payJsApiRequest.getPackage().getValue(), payJsApiRequest.getSignType().getValue(), payJsApiRequest.getPaySign().getValue());
    }
}
