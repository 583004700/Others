package com.ry.xk.studentexamresult.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.xk.common.CommonConst;
import com.ry.xk.main.service.IWCFService;
import com.ry.xk.request.bo.QuestionInfoApiRequest;
import com.ry.xk.request.bo.SubmitDoQuestionInfo;
import com.ry.xk.response.bo.QuestionCategoryModel;
import com.ry.xk.response.bo.QuestionGroupModel;
import com.ry.xk.response.bo.QuestionInfoModule;
import com.ry.xk.response.bo.SubQuestionOption;
import com.ry.xk.response.bo.UserAnswer;
import com.ry.xk.studentexamresult.bo.QuestionCategory;
import com.ry.xk.studentexamresult.bo.StudentExamInProgressInfo;
import com.ry.xk.studentexamresult.bo.StudentExamProgressQuestion;
import com.ry.xk.studentexamresult.bo.StudentGroupAnswer;
import com.ry.xk.utils.UrlUtil;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.Question;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionOption;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionOptionGroup;

/**
 * 考试题目业务接口
 *
 * @ClassName: ExamQuestionService
 * @author 幸仁强
 * @date 2018年06月01日
 */
@Service
public class ExamQuestionService implements IExamQuestionService
{
    // 日志操作对象
    private static final Logger log = LoggerFactory.getLogger(ExamQuestionService.class);

    @Autowired
    IStudentExamInProgressInfoService studentExamInProgressInfoService;

    @Autowired
    IWCFService wcfService;

    @Autowired
    IExamService examService;

    @Override
    public QuestionInfoModule getExamItem(QuestionInfoApiRequest request)
        throws Exception
    {
        long steId = UrlUtil.idDecrypt(request.getSteId(), Long.class);
        if (!examService.validateExamAndUser(request.getUserId(), steId))
        {
            log.error(String.format("用户ID和学生测试ID不匹配,userId为%s,steId为%s", request.getUserId(), steId));
            throw new Exception();
        }
        StudentExamInProgressInfo studentExamInProgressInfo = studentExamInProgressInfoService.getByEncoderID(request.getSteId());
        if (null == studentExamInProgressInfo)
        {
            log.error(String.format("学生做测试时候的临时数据对象异常,questionId为%s,学生测试ID为%s", request.getQuestionId(), steId));
            return null;
        }
        int questionId = request.getQuestionId();
        QuestionInfoModule questionInfoModule = new QuestionInfoModule();
        Question question = wcfService.getQuestionById(questionId);
        List<StudentExamProgressQuestion> examDoingQuestions = studentExamInProgressInfo.getExamDoingQuestions();
        StudentExamProgressQuestion studentExamProgressQuestion = examDoingQuestions.stream().filter(o -> o.getQuestionId() == questionId).findFirst().orElse(null);
        questionInfoModule.setOrderIndex(studentExamProgressQuestion.getQuestionIndex());
        questionInfoModule.setQuestionId(questionId);
        questionInfoModule.setQuestionContent(question.getQuestionContentForDisplay().getValue());
        questionInfoModule.setQuestionDisplayTypeId(question.getQuestionDisplayTypeId());
        questionInfoModule.setOptionGroups(installQuestionOptionGroup(questionInfoModule, question, studentExamProgressQuestion));
        questionInfoModule.setQuestionCategory(installQuestionCategory(question.getQuestionCategoryId().intValue()));
        return questionInfoModule;
    }

    /**
     * 组装题型实体
     *
     * @Title: installQuestionCategory
     * @author 幸仁强
     * @param questionCategoryId
     * @return
     * @throws Exception
     */
    private QuestionCategoryModel installQuestionCategory(int questionCategoryId)
        throws Exception
    {
        List<QuestionCategory> questionCategorys = wcfService.getAllQuestionCategories();
        QuestionCategory questionCategory = questionCategorys.stream().filter(o -> o.getQuestionCategoryId() == questionCategoryId).findFirst().orElse(null);
        QuestionCategoryModel questionCategoryModel = new QuestionCategoryModel();
        questionCategoryModel.setQuestionCategoryId(questionCategoryId);
        questionCategoryModel.setQuestionCategoryName(questionCategory.getQuestionCategoryName());
        return questionCategoryModel;
    }

    /**
     * 组装小题列表
     *
     * @Title: installQuestionOptionGroup
     * @author 幸仁强
     * @param questionInfoModule
     * @param question
     * @return
     */
    private List<QuestionGroupModel> installQuestionOptionGroup(QuestionInfoModule questionInfoModule, Question question, StudentExamProgressQuestion studentExamProgressQuestion)
    {
        List<QuestionGroupModel> optionGroups = new ArrayList<QuestionGroupModel>();
        List<QuestionOptionGroup> questionOptionGroups = question.getOptionGroups().getValue().getQuestionOptionGroup();
        for (QuestionOptionGroup questionOptionGroup : questionOptionGroups)
        {
            int displayTypeId = questionOptionGroup.getDisplayTypeId().intValue() == 0 ? question.getQuestionDisplayTypeId().intValue() : questionOptionGroup.getDisplayTypeId().intValue();
            UserAnswer answer = installQuestionOptionGroupAnswer(questionOptionGroup.getQuestionOptionGroupId().intValue(), studentExamProgressQuestion);
            if (null == answer)
            {
                List<String> answers = new ArrayList<String>();
                questionOptionGroup.getAnswers().getValue().getQuestionOptionGroupAnswer().forEach(o -> {
                    answers.add("");
                });
                answer = new UserAnswer(questionOptionGroup.getQuestionOptionGroupId().intValue(), answers);
            }
            List<SubQuestionOption> options = installQuestionOptionGroupOptions(questionOptionGroup);
            QuestionGroupModel questionGroupModel = new QuestionGroupModel(questionOptionGroup.getQuestionOptionGroupId().intValue(), displayTypeId, questionOptionGroup.getQuestionText().getValue(),
                answer, options);
            optionGroups.add(questionGroupModel);
        }
        questionInfoModule.setOptionGroups(optionGroups);
        return optionGroups;

    }

    /**
     * 组装小题选项
     *
     * @Title: installQuestionOptionGroupOptions
     * @author 幸仁强
     * @param questionOptionGroup
     * @return
     */
    private List<SubQuestionOption> installQuestionOptionGroupOptions(QuestionOptionGroup questionOptionGroup)
    {
        List<SubQuestionOption> subQuestionOptions = new ArrayList<SubQuestionOption>();
        if (null == questionOptionGroup.getOptions() || null == questionOptionGroup.getOptions().getValue() || null == questionOptionGroup.getOptions().getValue().getQuestionOption())
        {
            return subQuestionOptions;
        }
        List<QuestionOption> questionOptions = questionOptionGroup.getOptions().getValue().getQuestionOption();
        for (QuestionOption questionOption : questionOptions)
        {
            SubQuestionOption subQuestionOption = new SubQuestionOption(questionOption.getQuestionOptionId().getValue(), questionOption.getQuestionOptionText().getValue());
            subQuestionOptions.add(subQuestionOption);
        }
        return subQuestionOptions;
    }

    /**
     * 组装用户作答信息
     *
     * @Title: installQuestionOptionGroupAnswer
     * @author 幸仁强
     * @param questionOptionGroup
     * @param studentExamProgressQuestion
     */
    private UserAnswer installQuestionOptionGroupAnswer(int questionOptionGroupId, StudentExamProgressQuestion studentExamProgressQuestion)
    {
        List<StudentGroupAnswer> studentGroupAnswers = studentExamProgressQuestion.getStudentGroupAnswers();
        if (null == studentGroupAnswers || studentGroupAnswers.size() == 0)
        {
            return null;
        }
        List<StudentGroupAnswer> filterList = studentGroupAnswers.stream().sorted(Comparator.comparing(StudentGroupAnswer::getOrderId).reversed()).filter(
            o -> o.getQuestionOptionGroupId() == questionOptionGroupId).collect(Collectors.toList());
        List<String> answer = filterList.stream().map(StudentGroupAnswer::getAnswer).collect(Collectors.toList());
        UserAnswer userAnswer = new UserAnswer(questionOptionGroupId, answer);
        return userAnswer;

    }

    @Override
    public boolean saveExamItem(SubmitDoQuestionInfo request)
        throws Exception
    {
        long steId = UrlUtil.idDecrypt(request.getSteId(), Long.class);
        if (!examService.validateExamAndUser(request.getUserId(), steId))
        {
            log.error(String.format("用户ID和学生测试ID不匹配,userId为%s,steId为%s", request.getUserId(), steId));
            throw new Exception();
        }
        StudentExamInProgressInfo studentExamInProgressInfo = studentExamInProgressInfoService.getByEncoderID(request.getSteId());
        if (null == studentExamInProgressInfo)
        {
            return false;
        }
        int questionId = request.getQuestionId();
        List<StudentExamProgressQuestion> studentExamProgressQuestions = studentExamInProgressInfo.getExamDoingQuestions();
        StudentExamProgressQuestion studentExamProgressQuestion = studentExamProgressQuestions.stream().filter(o -> o.getQuestionId() == questionId).findFirst().orElse(null);
        List<StudentGroupAnswer> studentGroupAnswers = new ArrayList<StudentGroupAnswer>();
        List<UserAnswer> userAnswers = request.getUserAnswers();
        List<String> singleSpaceJoinAnswers = new ArrayList<String>();
        for (int i = 0; i < userAnswers.size(); i++ )
        {
            UserAnswer userAnswer = request.getUserAnswers().get(i);
            for (int j = 0; j < userAnswer.getAnswer().size(); j++ )
            {
                String answerItem = userAnswer.getAnswer().get(j);
                StudentGroupAnswer studentGroupAnswer = new StudentGroupAnswer();
                studentGroupAnswer.setQuestionOptionGroupId(userAnswer.getQuestionOptionGroupId());
                studentGroupAnswer.setAnswer(answerItem);
                studentGroupAnswer.setFillBlankTypeId(CommonConst.FILLBLANKTYPEID_SINGLESPACE);
                studentGroupAnswer.setOperateType(CommonConst.OPERATETYPE_INSERT);
                studentGroupAnswer.setId(i + 1);
                studentGroupAnswer.setOrderId(j + 1);
                studentGroupAnswers.add(studentGroupAnswer);
            }
            String singleSpaceJoinStr = String.join(",", userAnswer.getAnswer());
            singleSpaceJoinAnswers.add(singleSpaceJoinStr);
        }
        studentExamProgressQuestion.setStudentAnswer(String.join("\t", singleSpaceJoinAnswers));
        studentExamProgressQuestion.setStudentGroupAnswers(studentGroupAnswers);
        studentExamProgressQuestion.setQuestionDoingType(request.getDoingType());
        studentExamInProgressInfo.setLastQuestionId(questionId);
        studentExamInProgressInfo.setLastSaveTime(new Date());
        return studentExamInProgressInfoService.update(studentExamInProgressInfo);
    }
}
