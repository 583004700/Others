package com.ry.xk.studentexamresult.controller;

import com.ry.xk.IgnoreToken;
import com.ry.xk.common.CommonConst;
import com.ry.xk.common.CommonUtils;
import com.ry.xk.common.bo.ResponseBase;
import com.ry.xk.request.bo.*;
import com.ry.xk.response.bo.BuildOrderModule;
import com.ry.xk.response.bo.ExamPaperPayInfoModule;
import com.ry.xk.studentexamresult.service.IOrderPayService;
import com.ry.xk.studentexamresult.service.IOrderService;
import com.ry.xk.studentexamresult.service.IUserResourceService;
import com.ry.xk.utils.IpUtil;
import com.ry.xk.utils.UrlUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/order")
@Api("订单相关api")
public class OrderController
{
    // 日志操作对象
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    IOrderPayService orderPayService;

    @Autowired
    IOrderService orderService;

    @Autowired
    IUserResourceService userResourceService;

    @ApiOperation("获取购买试卷订单支付信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "examPaperPayInfoApiRequest", dataType = "ExamPaperPayInfoApiRequest", required = true, value = "获取购买试卷订单支付信息入参实体")})
    @RequestMapping(value = "/getWeChatPayInfo", method = RequestMethod.POST)
    public ResponseBase<ExamPaperPayInfoModule> getWeChatPayInfo(@RequestBody @Valid ExamPaperPayInfoApiRequest examPaperPayInfoApiRequest, BindingResult result, HttpServletRequest request)
    {

        try
        {
            if (result.hasErrors())
            {
                log.error("获取购买试卷订单支付信息入参校验失败：", CommonUtils.getAllValidateError(result.getAllErrors()));
                return new ResponseBase<ExamPaperPayInfoModule>(CommonConst.RT_FAIL, "入参校验失败", null);
            }
            ExamPaperPayInfoModule examPaperPayInfoModule = orderService.getWeChatPayInfo(examPaperPayInfoApiRequest, IpUtil.getIpAddr(request));
            if (null == examPaperPayInfoModule)
            {
                throw new NullPointerException();
            }
            return new ResponseBase<ExamPaperPayInfoModule>(CommonConst.RT_SUC, CommonConst.RT_SUC_MSG, examPaperPayInfoModule);
        }
        catch (Exception e)
        {
            log.error(String.format("创建订单信息异常,partnerId为%s,orderNum为%s", examPaperPayInfoApiRequest.getPartnerId(), examPaperPayInfoApiRequest.getOrderNum()), e);
            return new ResponseBase<ExamPaperPayInfoModule>(CommonConst.RT_FAIL, "获取购买试卷订单支付信息异常", null);
        }

    }

    @ApiOperation("创建订单信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "createOrderApiRequest", dataType = "CreateOrderApiRequest", required = true, value = "创建订单信息入参实体")})
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public ResponseBase<BuildOrderModule> createOMCOrder(@RequestBody @Valid CreateOrderApiRequest createOrderApiRequest, BindingResult result, HttpServletRequest request)
    {
        try
        {
            if (result.hasErrors())
            {
                log.error("创建订单信息入参校验失败：", CommonUtils.getAllValidateError(result.getAllErrors()));
                return new ResponseBase<BuildOrderModule>(CommonConst.RT_FAIL, "入参校验失败", null);
            }
            BuildOrderModule buildOrderModule = orderService.createOrder(createOrderApiRequest, IpUtil.getIpAddr(request));
            if (null == buildOrderModule)
            {
                log.error(String.format("创建订单信息失败,partnerId为%s,examPaperId为%s", createOrderApiRequest.getPartnerId(), UrlUtil.idDecrypt(createOrderApiRequest.getExamPaperId(), Integer.class)));
                throw new NullPointerException();
            }
            return new ResponseBase<BuildOrderModule>(CommonConst.RT_SUC, CommonConst.RT_SUC_MSG, buildOrderModule);
        }
        catch (Exception e)
        {
            log.error(String.format("创建订单信息异常,partnerId为%s,examPaperId为%s", createOrderApiRequest.getPartnerId(), UrlUtil.idDecrypt(createOrderApiRequest.getExamPaperId(), Integer.class)), e);
            return new ResponseBase<BuildOrderModule>(CommonConst.RT_FAIL, "创建订单信息异常", null);
        }
    }

    @ApiOperation("获取免费试卷")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "createFreeExamPaperRequest", dataType = "CreateFreeExamPaperRequest", required = true, value = "获取免费试卷入参实体")})
    @RequestMapping(value = "/createFreeExamPaper", method = RequestMethod.POST)
    public ResponseBase<Integer> createFreeExamPaper(@RequestBody @Valid CreateFreeExamPaperRequest createFreeExamPaperRequest, BindingResult result)
    {
        int resultType = CommonConst.resultTypeFail;
        ResponseBase<Integer> rb = new ResponseBase<Integer>();
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                int examPaperId = UrlUtil.idDecrypt(createFreeExamPaperRequest.getExamPaperId(), Integer.class);
                rb = userResourceService.getFreeExamPaper(createFreeExamPaperRequest.getUserId(), examPaperId);
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (NumberFormatException n)
        {
            log.error("试卷Id解析异常" + createFreeExamPaperRequest.getExamPaperId(), n);
        }
        catch (Exception e)
        {
            log.error("获取免费试卷发生异常", e);
        }
        rb.setResultType(resultType);
        return rb;
    }

    @ApiOperation("支付结果通知接口")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "payNotifyRequest", dataType = "PayNotifyRequest", required = true, value = "获取免费试卷入参实体")})
    @RequestMapping(value = "/payNotify", method = RequestMethod.POST)
    @IgnoreToken
    public ResponseBase<Boolean> payNotify(@RequestBody @Valid PayNotifyRequest payNotifyRequest, BindingResult result)
    {
        log.error(String.format("OrderNumber:%s,TargetId:%s,ProductId:%s", payNotifyRequest.getOrderNumber(), payNotifyRequest.getTargetId(), payNotifyRequest.getProductId()));
        int resultType = CommonConst.resultTypeFail;
        boolean payResult = false;
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确：", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                int userId = UrlUtil.idDecrypt(payNotifyRequest.getTargetId(), Integer.class);
                int productId = UrlUtil.idDecrypt(payNotifyRequest.getProductId(), Integer.class);
                payResult = orderPayService.payNotify(userId, productId, payNotifyRequest.getOrderNumber());
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (Exception e)
        {
            log.error("支付结果通知接口", e);
        }
        ResponseBase<Boolean> rb = new ResponseBase<Boolean>(resultType, "", payResult);
        return rb;
    }

    @ApiOperation("前端轮询支付结果接口")
    @IgnoreToken
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "checkPayResultRequest", dataType = "CheckPayResultRequest", required = true, value = "前端轮询支付结果接口实体")})
    @RequestMapping(value = "/checkPayResult", method = RequestMethod.POST)
    public ResponseBase<Boolean> checkPayResult(@RequestBody @Valid CheckPayResultRequest checkPayResultRequest, BindingResult result)
    {
        int resultType = CommonConst.resultTypeFail;
        boolean payResult = false;
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确：orderNumber为" + checkPayResultRequest.getOrderNumber(), CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                payResult = orderPayService.payResult(checkPayResultRequest.getOrderNumber());
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (Exception e)
        {
            log.error("前端轮询支付结果接口异常orderNumber" + checkPayResultRequest.getOrderNumber(), e);
        }
        ResponseBase<Boolean> rb = new ResponseBase<Boolean>(resultType, "", payResult);
        return rb;
    }
}