package com.ry.xk.studentexamresult.service;

import com.ry.xk.request.bo.CreateOrderApiRequest;
import com.ry.xk.request.bo.ExamPaperPayInfoApiRequest;
import com.ry.xk.response.bo.BuildOrderModule;
import com.ry.xk.response.bo.ExamPaperPayInfoModule;

/**
 * 订单业务接口
 * 
 * @ClassName: IAuthService
 * @author 幸仁强
 * @date 2018年6月7日
 */
public interface IOrderService
{
    /**
     * 创建订单
     * 
     * @Title: createOrder
     * @author 幸仁强
     * @param request
     * @return
     * @throws Exception
     */
    public BuildOrderModule createOrder(CreateOrderApiRequest request, String ip)
        throws Exception;

    /**
     * 获取微信支付信息
     * @Title: getWeChatPayInfo
     * @author 幸仁强
     * @param examPaperPayInfoApiRequest
     * @param ip
     * @return
     * @throws Exception
     */
    public ExamPaperPayInfoModule getWeChatPayInfo(ExamPaperPayInfoApiRequest examPaperPayInfoApiRequest, String ip)
        throws Exception;
}
