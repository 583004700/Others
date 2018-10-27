package com.ry.xk.studentexamresult.controller;


import com.ry.xk.common.CommonConst;
import com.ry.xk.common.CommonUtils;
import com.ry.xk.common.bo.ResponseBase;
import com.ry.xk.request.bo.ExamPaperDetailApiRequest;
import com.ry.xk.request.bo.ExamPapersRequest;
import com.ry.xk.response.bo.ExamPaperDetailModule;
import com.ry.xk.response.bo.ExamPaperListModule;
import com.ry.xk.studentexamresult.service.IExamPaperService;
import com.ry.xk.studentexamresult.service.IUserResourceService;
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

import javax.validation.Valid;


@RestController
@RequestMapping("/examPaper")
@Api("试卷相关api")
public class ExamPaperController
{
    // 日志操作对象
    private static final Logger log = LoggerFactory.getLogger(ExamPaperController.class);

    @Autowired
    IExamPaperService examPaperService;

    @Autowired
    IUserResourceService userResourceService;

    /**
     * 获取试卷列表
     * 
     * @Title: getExamPapers
     * @author 朱未斌
     * @param result
     * @return
     */
    @ApiOperation("获取试卷列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "examPapersRequest", dataType = "ExamPapersRequest", required = true, value = "获取试卷列表入参实体")})
    @RequestMapping(value = "/getExamPapers", method = RequestMethod.POST)
    public ResponseBase<ExamPaperListModule> getExamPapers(@RequestBody @Valid ExamPapersRequest examPapersRequest, BindingResult result)
    {
        int resultType = CommonConst.resultTypeFail;
        ExamPaperListModule examPaperListModule = new ExamPaperListModule();
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                int courseId = UrlUtil.idDecrypt(examPapersRequest.getCourseId(), Integer.class);
                examPaperListModule = examPaperService.getExamPaperList(examPapersRequest.getPartnerId(), examPapersRequest.getStatus(), courseId, examPapersRequest.getUserId(),
                    examPapersRequest.getPageIndex(), examPapersRequest.getPageSize());
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (Exception e)
        {
            log.error("获取试卷列表发生异常", e);
        }
        ResponseBase<ExamPaperListModule> rb = new ResponseBase<ExamPaperListModule>(resultType, "", examPaperListModule);
        return rb;
    }

    /**
     * 获取试卷详情
     * 
     * @Title: getExamPaperInfo
     * @author 朱未斌
     * @param result
     * @return
     */
    @ApiOperation("获取试卷详情")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "paperDetailApiRequest", dataType = "PaperDetailApiRequest", required = true, value = "获取试卷详情入参实体")})
    @RequestMapping(value = "/getExamPaperInfo", method = RequestMethod.POST)
    public ResponseBase<ExamPaperDetailModule> getExamPaperInfo(@RequestBody @Valid ExamPaperDetailApiRequest paperDetailApiRequest, BindingResult result)
    {
        int resultType = CommonConst.resultTypeFail;
        ExamPaperDetailModule examPaperDetailModule = new ExamPaperDetailModule();
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                int examPaperId = UrlUtil.idDecrypt(paperDetailApiRequest.getExamPaperId(), Integer.class);
                examPaperDetailModule = examPaperService.get(paperDetailApiRequest.getUserId(), examPaperId);
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (NumberFormatException n)
        {
            log.error("试卷Id解析异常" + paperDetailApiRequest.getExamPaperId(), n);
        }
        catch (Exception e)
        {
            log.error("获取试卷列表发生异常", e);
        }
        ResponseBase<ExamPaperDetailModule> rb = new ResponseBase<ExamPaperDetailModule>(resultType, "", examPaperDetailModule);
        return rb;
    }
}