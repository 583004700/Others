package com.ry.xk.studentexamresult.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.xk.common.CommonConst;
import com.ry.xk.common.GradingResultTypeEnum;
import com.ry.xk.main.service.IWCFService;
import com.ry.xk.response.bo.ExamPaperAnalysisModule;
import com.ry.xk.response.bo.OptionModel;
import com.ry.xk.response.bo.QuestionAnswerItemModel;
import com.ry.xk.response.bo.QuestionAnswerModel;
import com.ry.xk.response.bo.QuestionCategoryModel;
import com.ry.xk.response.bo.QuestionData;
import com.ry.xk.response.bo.StudentAnswerModel;
import com.ry.xk.response.bo.SubQuestionInfo;
import com.ry.xk.studentexamresult.bo.ExamSet;
import com.ry.xk.studentexamresult.bo.ExamSetQuestion;
import com.ry.xk.studentexamresult.bo.OptionGroupResult;
import com.ry.xk.studentexamresult.bo.QuestionCategory;
import com.ry.xk.studentexamresult.bo.StudentExam;
import com.ry.xk.studentexamresult.bo.StudentExamResult;
import com.ry.xk.studentexamresult.bo.StudentGroupAnswer;
import com.ry.xk.studentexamresult.bo.StudentQuestion;
import com.ry.xk.studentexamresult.dao.IExamSetDao;
import com.ry.xk.studentexamresult.dao.IStudentExamDao;
import com.ry.xk.studentexamresult.dao.IStudentExamResultDao;
import com.ry.xk.utils.ToggleQuestion;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.Question;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionOption;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionOptionGroup;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionOptionGroupAnswer;


@Service
public class QuestionService implements IQuestionService
{
    // 日志操作对象
    private static final Logger log = LoggerFactory.getLogger(QuestionService.class);

    @Autowired
    IWCFService wcfService;

    @Autowired
    IExamSetDao examSetDao;

    @Autowired
    IStudentExamResultDao studentExamResultDao;

    @Autowired
    IStudentExamDao studentExamDao;

    @Autowired
    IExamService examService;

    /**
     * 获取题目解析
     * 
     * @param studentExamId
     * @param questionId
     * @return
     */
    public ExamPaperAnalysisModule getExamPaperAnalysisModule(int userId, long studentExamId, int questionId) throws Exception
    {
        if (!examService.validateExamAndUser(userId, studentExamId))
        {
            log.error(String.format("用户ID和学生测试ID不匹配,userId为%s,steId为%s", userId, studentExamId));
            throw new Exception();
        }
        ExamPaperAnalysisModule examPaperAnalysisModule = null;
        try
        {
            Question question = wcfService.getQuestionById(questionId);
            // 通过测试ID获取题集
            StudentExam studentExam = studentExamDao.getStudentExam(studentExamId);
            ExamSet examSet = examSetDao.getExamSet(studentExam.getExamSetId());
            StudentExamResult studentExamResult = studentExamResultDao.get(studentExamId);
            List<ExamSetQuestion> examSetQuestions = examSet.getExamSetQuestions().stream().sorted((o1, o2) -> o1.getOrderIndex() - o2.getOrderIndex()).collect(Collectors.toList());
            if (question != null)
            {
                examPaperAnalysisModule = new ExamPaperAnalysisModule();
                try
                {
                    List<ExamSetQuestion> currentQuestions = examSetQuestions.stream().filter(o -> o.getQuestionId() == questionId).collect(Collectors.toList());
                    ExamSetQuestion currentExamSetQuestion = currentQuestions.get(0);
                    // 在题集中的上一题
                    ToggleQuestion<ExamSetQuestion> toggleQuestion = new ToggleQuestion<ExamSetQuestion>(examSetQuestions);
                    ExamSetQuestion examSetQuestionPre = toggleQuestion.getPreviousQuestion(currentExamSetQuestion);
                    ExamSetQuestion examSetQuestionNext = toggleQuestion.getNextQuestion(currentExamSetQuestion);
                    if (examSetQuestionPre != null)
                    {
                        examPaperAnalysisModule.setPreviousQuestionId(examSetQuestionPre.getQuestionId());
                    }
                    if (examSetQuestionNext != null)
                    {
                        examPaperAnalysisModule.setNextQuestionId(examSetQuestionNext.getQuestionId());
                    }
                    QuestionData questionData = getQuestionData(studentExamResult, examSetQuestions, question);
                    examPaperAnalysisModule.setQuestionInfo(questionData);
                }
                catch (Exception e)
                {
                    throw new RuntimeException("获取题目失败studentExamId" + studentExamId + "questionId" + questionId,e);
                }
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("获取题目失败studentExamId" + studentExamId + "questionId" + questionId);
        }
        return examPaperAnalysisModule;
    }

    /**
     * 组织题目数据
     * 
     * @param question
     * @return
     */
    public QuestionData getQuestionData(StudentExamResult studentExamResult, List<ExamSetQuestion> examSetQuestions, Question question) throws Exception
    {
        QuestionData questionData = new QuestionData();
        questionData.setQuestionContent(question.getQuestionContentForDisplay().getValue());
        questionData.setOrderIndex(getExamSetQuestionByQuestionId(examSetQuestions, question.getQuestionId()).getOrderIndex());
        questionData.setQuestionAnalysis(question.getAnalysis().getValue());
        questionData.setQuestionDisplayTypeId(question.getQuestionDisplayTypeId());
        questionData.setQuestionId(question.getQuestionId());
        questionData.setQuestionCategory(installQuestionCategory(question.getQuestionCategoryId().intValue()));
        // 题目链
        List<StudentQuestion> studentQuestions = studentExamResult.getQuestions();
        if (studentQuestions == null || studentQuestions.size() < 1)
        {
            log.error("测试没有生成测评数据");
        }
        // 大题测评信息
        StudentQuestion studentQuestion = null;
        try
        {
            studentQuestion = studentQuestions.stream().filter(o -> o.getQuestionId() == question.getQuestionId()).collect(Collectors.toList()).get(0);
        }
        catch (Exception e)
        {
            log.error("获取当前题目的测评信息失败questionId" + question.getQuestionId(), e);
        }
        // 得到当前大题的所有小题测评结果数据
        List<OptionGroupResult> optionGroupResults = studentQuestion.getQuestionOptionGroupResult();
        // 得到当前大题的所有用户提交的答案信息
        List<StudentGroupAnswer> studentGroupAnswers = studentQuestion.getStudentGroupAnswers();
        List<SubQuestionInfo> questionGroups = fitQuestionGroups(question, optionGroupResults, studentGroupAnswers);
        questionData.setQuestionGroups(questionGroups);
        return questionData;
    }

    /**
     * 组装小题数据
     * 
     * @param optionGroupResults
     * @param studentGroupAnswers
     * @return
     */
    public List<SubQuestionInfo> fitQuestionGroups(Question question, List<OptionGroupResult> optionGroupResults, List<StudentGroupAnswer> studentGroupAnswers)
    {
        List<QuestionOptionGroup> questionOptionGroups = question.getOptionGroups().getValue().getQuestionOptionGroup();
        // 小题集合
        List<SubQuestionInfo> questionGroups = new ArrayList<SubQuestionInfo>();
        questionOptionGroups.forEach((o) -> {
            SubQuestionInfo subQuestionInfo = new SubQuestionInfo();
            subQuestionInfo.setQuestionGroupContent(o.getQuestionText().getValue());
            subQuestionInfo.setQuestionGroupDisplayTypeId(o.getDisplayTypeId());
            subQuestionInfo.setQuestionGroupId(o.getQuestionId());
            List<QuestionOption> questionOptions = o.getOptions().getValue().getQuestionOption();
            List<OptionModel> optionModels = new ArrayList<OptionModel>();
            // 组织小题选项
            questionOptions.forEach((sub) -> {
                OptionModel optionModel = new OptionModel();
                optionModel.setOptionTag(sub.getQuestionOptionId().getValue());
                optionModel.setOptionContent(sub.getQuestionOptionText().getValue());
                optionModels.add(optionModel);
            });
            subQuestionInfo.setOptions(optionModels);
            QuestionAnswerModel questionAnswerModel = new QuestionAnswerModel();
            // 获取到当前小题的测评结果
            List<OptionGroupResult> optionGroupResult = null;
            try
            {
                optionGroupResult = optionGroupResults.stream().filter(s -> s.getQuestionOptionGroupId() == o.getQuestionOptionGroupId()).sorted((k1,k2)->k1.getOrderId() - k2.getOrderId()).collect(Collectors.toList());
            }
            catch (Exception e)
            {
                log.error("从optionGroupResults中获取小题异常questionOptionGroupId" + o.getQuestionOptionGroupId() + "QuestionId" + question.getQuestionId());
            }
            // 设置小题是否正确
            long wrongCount = optionGroupResult.stream().filter(opr->opr.getGradingResult() != GradingResultTypeEnum.Correct).count();
            questionAnswerModel.setIsCorrectAnswer(wrongCount<1);
            questionAnswerModel.setCorrectStatus(wrongCount<1 ? CommonConst.PGZQ : CommonConst.PGCY);
            // 小题的正确答案
            List<QuestionAnswerItemModel> correctAnswerList = new ArrayList<QuestionAnswerItemModel>();
            // 从接口中获取到的小题正确答案
            List<QuestionOptionGroupAnswer> questionOptionGroupAnswers = o.getAnswers().getValue().getQuestionOptionGroupAnswer().stream().sorted((o1, o2) -> o1.getOrder() - o2.getOrder()).collect(
                Collectors.toList());
            questionOptionGroupAnswers.forEach(q -> {
                QuestionAnswerItemModel questionAnswerItemModel = new QuestionAnswerItemModel();
                questionAnswerItemModel.setAnswer(q.getAnswer().getValue());
                questionAnswerItemModel.setOrder(q.getOrder());
                correctAnswerList.add(questionAnswerItemModel);
            });
            questionAnswerModel.setCorrectAnswerList(correctAnswerList);
            // 学生提交的答案
            List<StudentAnswerModel> studentAnswerList = new ArrayList<StudentAnswerModel>();
            // 从测评结果中获取到的用户提交的答案
            List<StudentGroupAnswer> studentGroupAnswersU = null;
            try
            {
                studentGroupAnswersU = studentGroupAnswers.stream().filter((xt)->xt.getQuestionOptionGroupId() == o.getQuestionOptionGroupId()).sorted((o1, o2) -> o1.getOrderId() - o2.getOrderId()).collect(Collectors.toList());
            }
            catch (Exception e)
            {
                log.error("从studentGroupAnswers中获取用户答案数据异常questionOptionGroupId" + o.getQuestionOptionGroupId() + "QuestionId" + question.getQuestionId());
            }

            for(int i=0;i<studentGroupAnswersU.size() && i<optionGroupResult.size();i++)
            {
                StudentGroupAnswer s = studentGroupAnswersU.get(i);
                StudentAnswerModel studentAnswerModel = new StudentAnswerModel();
                studentAnswerModel.setAnswer(s.getAnswer());
                studentAnswerModel.setOrderIndex(s.getOrderId());
                OptionGroupResult kong = optionGroupResult.get(i);
                int correctIsTypeId = -1;
                if(StringUtils.isEmpty(s.getAnswer())){
                    correctIsTypeId = CommonConst.WZ;
                }
                if(kong.getGradingResult() == GradingResultTypeEnum.Correct){
                    correctIsTypeId = CommonConst.PGZQ;
                }else if(kong.getGradingResult() == GradingResultTypeEnum.PartiallyCorrect || kong.getGradingResult()== GradingResultTypeEnum.Wrong ){
                    correctIsTypeId = CommonConst.PGCY;
                }
                studentAnswerModel.setCorrectIsTypeId(correctIsTypeId);
                studentAnswerList.add(studentAnswerModel);
            }
            questionAnswerModel.setStudentAnswerList(studentAnswerList);
            subQuestionInfo.setQuestionAnswer(questionAnswerModel);
            questionGroups.add(subQuestionInfo);
        });
        return questionGroups;
    }

    /**
     * 通过ID获取题集中的题目
     * 
     * @param examSetQuestions
     * @param questionId
     * @return
     */
    private ExamSetQuestion getExamSetQuestionByQuestionId(List<ExamSetQuestion> examSetQuestions, int questionId)
    {
        ExamSetQuestion examSetQuestion = null;
        List<ExamSetQuestion> currentExamSetQuestions = examSetQuestions.stream().filter((o) -> o.getQuestionId() == questionId).collect(Collectors.toList());
        if (currentExamSetQuestions != null && currentExamSetQuestions.size() > 0)
        {
            examSetQuestion = currentExamSetQuestions.get(0);
        }
        return examSetQuestion;
    }

    /**
     * 组装题型实体
     *
     * @Title: installQuestionCategory
     * @author
     * @param questionCategoryId
     * @return
     * @throws Exception
     */
    public QuestionCategoryModel installQuestionCategory(int questionCategoryId)
        throws Exception
    {
        List<QuestionCategory> questionCategorys = wcfService.getAllQuestionCategories();
        QuestionCategory questionCategory = questionCategorys.stream().filter(o -> o.getQuestionCategoryId() == questionCategoryId).findFirst().orElse(null);
        QuestionCategoryModel questionCategoryModel = new QuestionCategoryModel();
        questionCategoryModel.setQuestionCategoryId(questionCategoryId);
        questionCategoryModel.setQuestionCategoryName(questionCategory.getQuestionCategoryName());
        return questionCategoryModel;
    }

}
