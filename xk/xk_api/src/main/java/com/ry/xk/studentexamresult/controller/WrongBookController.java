package com.ry.xk.studentexamresult.controller;


import com.ry.xk.common.CommonConst;
import com.ry.xk.common.CommonUtils;
import com.ry.xk.common.bo.ResponseBase;
import com.ry.xk.request.bo.WrongBookApiRequest;
import com.ry.xk.request.bo.WrongBookItemApiRequest;
import com.ry.xk.response.bo.ExamPaperAnalysisModule;
import com.ry.xk.response.bo.WrongBookItemModule;
import com.ry.xk.studentexamresult.service.IWrongBookService;
import com.ry.xk.utils.UrlUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/wrongBook")
@Api("错题本相关api")
public class WrongBookController
{
    // 日志操作对象
    private static final Logger log = LoggerFactory.getLogger(WrongBookController.class);

    @Autowired
    IWrongBookService wrongBookService;

    @ApiOperation("删除错题本题目")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "wrongItemApiRequest", dataType = "WrongBookItemApiRequest", required = true, value = "删除错题本题目入参实体")})
    @RequestMapping(value = "/removeWrongBookItem", method = RequestMethod.POST)
    public ResponseBase<Boolean> removeWrongBookItem(@RequestBody @Valid WrongBookItemApiRequest wrongItemApiRequest, BindingResult result)
    {
        int resultType = CommonConst.resultTypeFail;
        boolean deleteResult = false;
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                int courseId = UrlUtil.idDecrypt(wrongItemApiRequest.getCourseId(), Integer.class);
                deleteResult = wrongBookService.deleteWrongQuestion(wrongItemApiRequest.getUserId(), courseId, wrongItemApiRequest.getQuestionId());
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (Exception e)
        {
            log.error("删除错题本题目userId" + wrongItemApiRequest.getUserId() + "courseId" + wrongItemApiRequest.getCourseId() + "questionId" + wrongItemApiRequest.getQuestionId(), e);
        }
        ResponseBase<Boolean> rb = new ResponseBase<Boolean>(resultType, "", deleteResult);
        return rb;
    }

    @ApiOperation("获取错题本题目详情")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "wrongItemApiRequest", dataType = "WrongBookItemApiRequest", required = true, value = "获取错题本题目详情")})

    @RequestMapping(value = "/getWrongBookItem", method = RequestMethod.POST)
    public ResponseBase<ExamPaperAnalysisModule> getWrongBookItem(@RequestBody @Valid WrongBookItemApiRequest wrongItemApiRequest, BindingResult result)
    {
        int resultType = CommonConst.resultTypeFail;
        ExamPaperAnalysisModule examPaperAnalysisModule = new ExamPaperAnalysisModule();
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                int courseId = UrlUtil.idDecrypt(wrongItemApiRequest.getCourseId(), Integer.class);
                examPaperAnalysisModule = wrongBookService.getWrongBookDetail(wrongItemApiRequest.getUserId(), courseId, wrongItemApiRequest.getQuestionId());
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (Exception e)
        {
            log.error("获取错题本题目详情异常userId" + wrongItemApiRequest.getUserId() + "courseId" + wrongItemApiRequest.getCourseId(), e);
        }
        ResponseBase<ExamPaperAnalysisModule> rb = new ResponseBase<ExamPaperAnalysisModule>(resultType, "", examPaperAnalysisModule);
        return rb;
    }

    @ApiOperation("获取错题本列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "wrongBookApiRequest", dataType = "WrongBookApiRequest", required = true, value = "获取错题本列表")})
    @RequestMapping(value = "/getWrongBook", method = RequestMethod.POST)
    public ResponseBase<List<WrongBookItemModule>> getWrongBook(@RequestBody @Valid WrongBookApiRequest wrongBookApiRequest, BindingResult result)
    {
        int resultType = CommonConst.resultTypeFail;
        List<WrongBookItemModule> wrongBookItemModules = new ArrayList<WrongBookItemModule>();
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                int courseId = UrlUtil.idDecrypt(wrongBookApiRequest.getCourseId(), Integer.class);
                wrongBookItemModules = wrongBookService.getWrongBookItemModules(wrongBookApiRequest.getUserId(), courseId, wrongBookApiRequest.getPageIndex(), wrongBookApiRequest.getPageSize());
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (Exception e)
        {
            log.error("获取错题本列表异常userId" + wrongBookApiRequest.getUserId() + "courseId" + wrongBookApiRequest.getCourseId(), e);
        }
        ResponseBase<List<WrongBookItemModule>> rb = new ResponseBase<List<WrongBookItemModule>>(resultType, "", wrongBookItemModules);
        return rb;
    }
}