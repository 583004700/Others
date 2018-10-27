package com.ry.xk.studentexamresult.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ry.xk.common.CommonConst;
import com.ry.xk.common.CommonUtils;
import com.ry.xk.common.bo.ResponseBase;
import com.ry.xk.request.bo.ExamApiRequest;
import com.ry.xk.request.bo.GenerateExamDataRequest;
import com.ry.xk.request.bo.QuestionInfoApiRequest;
import com.ry.xk.request.bo.SubmitDoQuestionInfo;
import com.ry.xk.response.bo.AnalysisAnswerSheets;
import com.ry.xk.response.bo.ExamModule;
import com.ry.xk.response.bo.ExamPaperAnalysisModule;
import com.ry.xk.response.bo.ExamResultModule;
import com.ry.xk.response.bo.QuestionInfoModule;
import com.ry.xk.response.bo.SubmitDoQuestionModule;
import com.ry.xk.studentexamresult.service.IExamQuestionService;
import com.ry.xk.studentexamresult.service.IExamService;
import com.ry.xk.studentexamresult.service.IFinishExamService;
import com.ry.xk.studentexamresult.service.IGenerateExamDataService;
import com.ry.xk.studentexamresult.service.IQuestionService;
import com.ry.xk.studentexamresult.service.IStudentExamResultService;
import com.ry.xk.utils.UrlUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/exam")
@Api("模拟测试相关api")
public class ExamController
{
    // 日志操作对象
    private static final Logger log = LoggerFactory.getLogger(ExamController.class);

    @Autowired
    IGenerateExamDataService generateExamDataService;

    @Autowired
    IExamService examService;

    @Autowired
    IStudentExamResultService studentExamResultService;

    @Autowired
    IExamQuestionService examQuestionService;

    @Autowired
    IQuestionService questionService;

    @Autowired
    IFinishExamService finishExamService;

    /**
     * 1.7 H5 - 获取模拟测试Id
     * 
     * @Title: generateExamData
     * @author 幸仁强
     * @param result
     * @return
     */
    @ApiOperation("获取测试ID")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "request", dataType = "GenerateExamDataRequest", required = true, value = "生成测试数据入参实体")})
    @RequestMapping(value = "/generateExamData", method = RequestMethod.POST)
    public ResponseBase<String> generateExamData(@RequestBody @Valid GenerateExamDataRequest request, BindingResult result)
    {
        try
        {
            if (result.hasErrors())
            {
                log.error("获取测试ID接口入参校验失败：", CommonUtils.getAllValidateError(result.getAllErrors()));
                return new ResponseBase<String>(CommonConst.RT_FAIL, "入参校验失败", null);
            }
            long studentExamId = generateExamDataService.checkAndGenerateExamData(request);
            if (studentExamId > 0)
            {
                return new ResponseBase<String>(CommonConst.RT_SUC, CommonConst.RT_SUC_MSG, UrlUtil.idEncrypt(studentExamId));
            }
            else
            {
                return new ResponseBase<String>(CommonConst.RT_FAIL, "获取测试ID失败", null);
            }
        }
        catch (Exception e)
        {
            log.error(String.format("获取测试ID接口异常,partnerId为%s,examPaperId为%s", request.getPartnerId(), UrlUtil.idDecrypt(request.getExamPaperId(), Integer.class)), e);
            return new ResponseBase<String>(CommonConst.RT_FAIL, "获取测试ID异常", null);
        }
    }

    @ApiOperation("获取测试基本信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "request", dataType = "ExamApiRequest", required = true, value = "获取测试基本信息入参实体")})
    @RequestMapping(value = "/getExamBaseInfo", method = RequestMethod.POST)
    public ResponseBase<ExamModule> getExamBaseInfo(@RequestBody @Valid ExamApiRequest request, BindingResult result)
    {
        int resultType = CommonConst.resultTypeFail;
        ExamModule examModule = new ExamModule();
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确：", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                int steId = UrlUtil.idDecrypt(request.getSteId(), Integer.class);
                examModule = examService.get(request.getUserId(), steId);
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (Exception e)
        {
            log.error("获取测试基本信息发生异常", e);
        }
        ResponseBase<ExamModule> rb = new ResponseBase<ExamModule>(resultType, "", examModule);
        return rb;
    }

    @ApiOperation("获取题目信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "request", dataType = "QuestionInfoApiRequest", required = true, value = "获取题目信息入参实体")})
    @RequestMapping(value = "/getExamItem", method = RequestMethod.POST)
    public ResponseBase<QuestionInfoModule> getExamItem(@RequestBody @Valid QuestionInfoApiRequest request, BindingResult result)
    {
        try
        {
            if (result.hasErrors())
            {
                log.error("获取获取题目信息接口入参校验失败：", CommonUtils.getAllValidateError(result.getAllErrors()));
                return new ResponseBase<QuestionInfoModule>(CommonConst.RT_FAIL, "入参校验失败", null);
            }
            QuestionInfoModule questionInfoModule = examQuestionService.getExamItem(request);
            if (null == questionInfoModule)
            {
                log.error(String.format("获取题目信息失败,questionId为%s,examPaperId为%s", request.getQuestionId(), UrlUtil.idDecrypt(request.getSteId(), Integer.class)));
                return new ResponseBase<QuestionInfoModule>(CommonConst.RT_FAIL, "获取题目信息失败", null);
            }
            else
            {
                return new ResponseBase<QuestionInfoModule>(CommonConst.RT_SUC, CommonConst.RT_SUC_MSG, questionInfoModule);
            }
        }
        catch (Exception e)
        {
            log.error(String.format("获取获取题目信息接口异常,questionId为%s,examPaperId为%s", request.getQuestionId(), UrlUtil.idDecrypt(request.getSteId(), Integer.class)), e);
            return new ResponseBase<QuestionInfoModule>(CommonConst.RT_FAIL, "获取题目信息异常", null);
        }
    }

    @ApiOperation("提交做题信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "request", dataType = "SubmitDoQuestionInfo", required = true, value = "提交做题信息入参实体")})
    @RequestMapping(value = "/saveExamItem", method = RequestMethod.POST)
    public ResponseBase<SubmitDoQuestionModule> saveExamItem(@RequestBody @Valid SubmitDoQuestionInfo request, BindingResult result)
    {
        try
        {
            if (result.hasErrors())
            {
                log.error("提交做题信息接口入参校验失败：", CommonUtils.getAllValidateError(result.getAllErrors()));
                return new ResponseBase<SubmitDoQuestionModule>(CommonConst.RT_FAIL, "入参校验失败", new SubmitDoQuestionModule(CommonConst.RT_FAIL));
            }
            boolean rtn = examQuestionService.saveExamItem(request);
            if (rtn)
            {
                return new ResponseBase<SubmitDoQuestionModule>(CommonConst.RT_SUC, CommonConst.RT_SUC_MSG, new SubmitDoQuestionModule(CommonConst.RT_SUC));
            }
            else
            {
                log.error(String.format("提交做题信息失败,questionId为%s,studentExamId为%s", request.getQuestionId(), UrlUtil.idDecrypt(request.getSteId(), Long.class)));
                return new ResponseBase<SubmitDoQuestionModule>(CommonConst.RT_FAIL, "提交做题信息失败", new SubmitDoQuestionModule(CommonConst.RT_FAIL));
            }
        }
        catch (Exception e)
        {
            log.error(String.format("提交做题信息接口异常,questionId为%s,studentExamId为%s", request.getQuestionId(), UrlUtil.idDecrypt(request.getSteId(), Long.class)), e);
            return new ResponseBase<SubmitDoQuestionModule>(CommonConst.RT_FAIL, "提交做题信息异常", new SubmitDoQuestionModule(CommonConst.RT_FAIL));
        }
    }

    @ApiOperation("提交试卷")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "request", dataType = "ExamApiRequest", required = true, value = "交卷入参实体")})
    @RequestMapping(value = "/finishExam", method = RequestMethod.POST)
    public ResponseBase<Boolean> finishExam(@RequestBody @Valid ExamApiRequest request, BindingResult result)
    {
        try
        {
            if (result.hasErrors())
            {
                log.error("提交试卷信息接口入参校验失败：", CommonUtils.getAllValidateError(result.getAllErrors()));
                return new ResponseBase<Boolean>(CommonConst.RT_FAIL, "入参校验失败", false);
            }
            boolean rtn = finishExamService.finishExam(request);
            if (rtn)
            {
                return new ResponseBase<Boolean>(CommonConst.RT_SUC, CommonConst.RT_SUC_MSG, true);
            }
            else
            {
                log.error(String.format("提交试卷信息失败,studentExamId为%s", UrlUtil.idDecrypt(request.getSteId(), Long.class)));
                return new ResponseBase<Boolean>(CommonConst.RT_FAIL, "提交做题信息失败", false);
            }
        }
        catch (Exception e)
        {
            log.error(String.format("提交试卷信息接口异常,studentExamId为%s", UrlUtil.idDecrypt(request.getSteId(), Long.class)), e);
            return new ResponseBase<Boolean>(CommonConst.RT_FAIL, "提交试卷信息异常", false);
        }
    }

    @ApiOperation("获取题目解析")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "questionInfoApiRequest", dataType = "QuestionInfoApiRequest", required = true, value = "获取题目解析入参实体")})
    @RequestMapping(value = "/getExamPaperItemAnalysis", method = RequestMethod.POST)
    public ResponseBase<ExamPaperAnalysisModule> getExamPaperItemAnalysis(@RequestBody @Valid QuestionInfoApiRequest questionInfoApiRequest, BindingResult result)
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
                long steId = UrlUtil.idDecrypt(questionInfoApiRequest.getSteId(), Long.class);
                examPaperAnalysisModule = questionService.getExamPaperAnalysisModule(questionInfoApiRequest.getUserId(), steId, questionInfoApiRequest.getQuestionId());
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (Exception e)
        {
            log.error("获取题目解析发生异常", e);
        }
        ResponseBase<ExamPaperAnalysisModule> rb = new ResponseBase<ExamPaperAnalysisModule>(resultType, "", examPaperAnalysisModule);
        return rb;
    }

    @ApiOperation("获取考试测评")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "examEvaluationRequest", dataType = "ExamApiRequest", required = true, value = "获取考试测评入参实体")})
    @RequestMapping(value = "/getExamEvaluation", method = RequestMethod.POST)
    public ResponseBase<ExamResultModule> getExamEvaluation(@RequestBody @Valid ExamApiRequest examApiRequest, BindingResult result)
    {
        int resultType = CommonConst.resultTypeFail;
        ExamResultModule examResultModule = new ExamResultModule();
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                int steId = UrlUtil.idDecrypt(examApiRequest.getSteId(), Integer.class);
                examResultModule = studentExamResultService.getExamResult(examApiRequest.getUserId(), steId);
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (Exception e)
        {
            log.error("获取考试测评发生异常", e);
        }
        ResponseBase<ExamResultModule> rb = new ResponseBase<ExamResultModule>(resultType, "", examResultModule);
        return rb;
    }

    @ApiOperation("获取试卷解析答题卡信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "examApiRequest", dataType = "ExamApiRequest", required = true, value = "获取试卷解析基本信息入参实体")})
    @RequestMapping(value = "/getExamPaperAnalysisBaseInfo", method = RequestMethod.POST)
    public ResponseBase<List<AnalysisAnswerSheets>> getExamPaperAnalysisBaseInfo(@RequestBody @Valid ExamApiRequest examApiRequest, BindingResult result)
    {
        int resultType = CommonConst.resultTypeFail;
        List<AnalysisAnswerSheets> analysisAnswerSheets = new ArrayList<AnalysisAnswerSheets>();
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                int steId = UrlUtil.idDecrypt(examApiRequest.getSteId(), Integer.class);
                analysisAnswerSheets = studentExamResultService.getAnalysisAnswerSheets(examApiRequest.getUserId(), steId);
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (Exception e)
        {
            log.error("获取试卷解析答题卡信息发生异常", e);
        }
        ResponseBase<List<AnalysisAnswerSheets>> rb = new ResponseBase<List<AnalysisAnswerSheets>>(resultType, "", analysisAnswerSheets);
        return rb;
    }

}