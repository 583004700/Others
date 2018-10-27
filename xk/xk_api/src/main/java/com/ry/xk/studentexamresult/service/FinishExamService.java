package com.ry.xk.studentexamresult.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.xk.common.CommonConst;
import com.ry.xk.common.GradingResultTypeEnum;
import com.ry.xk.common.GradingTypeEnum;
import com.ry.xk.common.QuestionDisplayTypeEnum;
import com.ry.xk.common.QuestionDoingStatusEnum;
import com.ry.xk.main.service.IWCFService;
import com.ry.xk.request.bo.ExamApiRequest;
import com.ry.xk.studentexamresult.bo.ExamReviewSummaryView;
import com.ry.xk.studentexamresult.bo.ExamSet;
import com.ry.xk.studentexamresult.bo.ExamSetQuestion;
import com.ry.xk.studentexamresult.bo.NameIdDataPair;
import com.ry.xk.studentexamresult.bo.OptionGroupResult;
import com.ry.xk.studentexamresult.bo.StudentExamInProgressInfo;
import com.ry.xk.studentexamresult.bo.StudentExamItem;
import com.ry.xk.studentexamresult.bo.StudentExamList;
import com.ry.xk.studentexamresult.bo.StudentExamProgressQuestion;
import com.ry.xk.studentexamresult.bo.StudentExamResult;
import com.ry.xk.studentexamresult.bo.StudentGroupAnswer;
import com.ry.xk.studentexamresult.bo.StudentQuestion;
import com.ry.xk.studentexamresult.bo.WrongBook;
import com.ry.xk.studentexamresult.bo.WrongQuestion;
import com.ry.xk.studentexamresult.dao.IExamSetDao;
import com.ry.xk.studentexamresult.dao.IStudentExamDao;
import com.ry.xk.studentexamresult.dao.IStudentExamResultDao;
import com.ry.xk.studentexamresult.dao.IWrongBookDao;
import com.ry.xk.utils.TwoTuple;
import com.ry.xk.utils.UrlUtil;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.KnowledgePoint;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.Question;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionDisplayType;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionOptionGroup;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.QuestionOptionGroupAnswer;

/**
 * 交卷业务接口
 * 
 * @ClassName: FinishExamService
 * @author 幸仁强
 * @date 2018年06月01日
 */
@Service
public class FinishExamService implements IFinishExamService
{
    private static final Logger log = LoggerFactory.getLogger(FinishExamService.class);

    @Autowired
    IStudentExamInProgressInfoService studentExamInProgressInfoService;

    @Autowired
    IWCFService wcfService;

    @Autowired
    IStudentExamResultDao studentExamResultDao;

    @Autowired
    IStudentExamDao studentExamDao;

    @Autowired
    IExamSetDao examSetDao;

    @Autowired
    IWrongBookDao wrongBookDao;

    @Autowired
    IExamService examService;

    @Override
    public boolean finishExam(ExamApiRequest examApiRequest)
        throws Exception
    {
        long studentExamId = UrlUtil.idDecrypt(examApiRequest.getSteId(), Long.class);
        if (!examService.validateExamAndUser(examApiRequest.getUserId(), studentExamId))
        {
            log.error(String.format("用户ID和学生测试ID不匹配,userId为%s,steId为%s", examApiRequest.getUserId(), studentExamId));
            throw new Exception();
        }
        StudentExamInProgressInfo seInfo = studentExamInProgressInfoService.getByEncoderID(examApiRequest.getSteId());
        StudentExamResult studentExamResult = generateStudentExamResult(seInfo);
        studentExamResult.setUseTime(examApiRequest.getUseTime());
        if (studentExamResult == null || !studentExamResult.validate())
        {
            return false;
        }

        SubmitExamResult(studentExamResult);

        // 插入考试结果到表中以及缓存中
        studentExamResultDao.insert(studentExamResult);
        // 更新学生测试表状态为已提交
        studentExamDao.updateExamStatusId(studentExamId);
        // 提取错题信息加入到错题本里
        addWrongBookItem(examApiRequest.getUserId(), seInfo.getCourseId(), studentExamResult);
        // 更新StudentExamList里相应数据的状态
        updateStudentExamListItem(examApiRequest.getUserId(), studentExamId);
        // 删除学生做题临时缓存
        studentExamInProgressInfoService.remove(seInfo);

        return true;
    }

    /**
     * 提取错题加入错题本
     * 
     * @Title: addWrongBookItem
     * @author 幸仁强
     * @param userId
     * @param courseId
     * @param studentExamResult
     */
    private void addWrongBookItem(int userId, int courseId, StudentExamResult studentExamResult)
    {
        try
        {
            List<StudentQuestion> wrongQuestions = studentExamResult.getQuestions().stream().filter(o -> (!o.getIsCorrect() && !o.getNotSupportCorrect())).collect(Collectors.toList());
            WrongBook wrongBook = wrongBookDao.get(userId, courseId);
            for (StudentQuestion sq : wrongQuestions)
            {
                wrongBook.getWrongQuestions().add(new WrongQuestion(sq.getQuestionId(), sq.getStudentGroupAnswers(), sq.getQuestionOptionGroupResult(), CommonConst.STATUS_FLAG_VALID));
            }
            wrongBookDao.update(wrongBook);
        }
        catch (Exception e)
        {
            log.error(String.format("studentExamId为%s的数据在交卷后，更新错题本时异常", studentExamResult.getStudentExamId()), e);
        }
    }

    /**
     * 更新studentExamList对象
     * 
     * @Title: updateStudentExamListItem
     * @author 幸仁强
     * @param userId
     * @param studentExamId
     * @throws Exception
     */
    private void updateStudentExamListItem(int userId, long studentExamId)
    {
        try
        {
            StudentExamList studentExamList = studentExamDao.getStudentExamList(userId);
            StudentExamItem studentExamItem = studentExamList.getStudentExamItems().stream().filter(o -> o.getStudentExamId() == studentExamId).findFirst().orElse(null);
            if (studentExamItem != null)
            {
                studentExamItem.setIsGenerateEvaluation(true);
                studentExamDao.updateStudentExamList(studentExamList);
            }
            else
            {
                log.error(String.format("studentExamId为%s的数据在生成测验数据的时候没有生成studentExamList缓存数据", studentExamId));
            }
        }
        catch (Exception e)
        {
            log.error(String.format("studentExamId为%s的数据在交卷更新studentExamList对象时异常", studentExamId), e);

        }
    }

    /**
     * 根据学生做题临时缓存生成StudentExamResult对象
     * 
     * @Title: generateStudentExamResult
     * @author 幸仁强
     * @param steId
     * @return
     * @throws Exception
     */
    private StudentExamResult generateStudentExamResult(StudentExamInProgressInfo seInfo)
        throws Exception
    {
        ExamSet examSet = examSetDao.getExamSet(seInfo.getExamSetId());
        List<ExamSetQuestion> esqs = examSet.getExamSetQuestions();
        List<StudentQuestion> sqs = new ArrayList<StudentQuestion>();
        for (StudentExamProgressQuestion seq : seInfo.getExamDoingQuestions())
        {
            ExamSetQuestion esq = esqs.stream().filter(x -> x.getQuestionId() == seq.getQuestionId()).findFirst().orElse(null);
            StudentQuestion sq = new StudentQuestion();
            sq.setQuestionId(seq.getQuestionId());
            sq.setQuestionDoingType(seq.getQuestionDoingType());
            sq.setStudentAnswer(seq.getStudentAnswer());
            sq.setStudentGroupAnswers(seq.getStudentGroupAnswers());
            sq.setBaseScore(esq.getQuestionScore());
            sqs.add(sq);
        }
        StudentExamResult studentExamResult = new StudentExamResult();
        studentExamResult.setBookVersionId(seInfo.getBookVersionId());
        studentExamResult.setStudentExamId(seInfo.getStudentExamId());
        studentExamResult.setUserId(seInfo.getUserId());
        studentExamResult.setSubmissionDate(new Date());
        studentExamResult.setQuestions(sqs);
        return studentExamResult;
    }

    /**
     * 提交学考模拟卷的做题结果
     * 
     * @Title: SubmitExamResult
     * @author 幸仁强
     * @param steId
     * @return
     * @throws Exception
     */
    private void SubmitExamResult(StudentExamResult studentExamResult)
        throws Exception
    {

        List<Question> questions = wcfService.getQuestions(studentExamResult.getQuestions().stream().map(StudentQuestion::getQuestionId).collect(Collectors.toList()));
        List<QuestionDisplayType> questionDisplayTypes = wcfService.getGetQuestionDisplayTypes();
        fillExamResultQuestions(studentExamResult.getQuestions(), questions, questionDisplayTypes);
        executeGrading(studentExamResult.getQuestions(), questions, questionDisplayTypes);
        generateResultView(studentExamResult, questions.get(0).getCourseId());
    }

    /**
     * 构造返回结果
     * 
     * @Title: generateResultView
     * @author 幸仁强
     * @param studentExamResult
     * @param courseId
     * @throws Exception
     */
    private void generateResultView(StudentExamResult studentExamResult, int courseId)
        throws Exception
    {
        int wrongCount = (int)studentExamResult.getQuestions().stream().filter(o -> (!o.getIsCorrect() && !o.getNotSupportCorrect())).count();
        int correctCount = (int)studentExamResult.getQuestions().stream().filter(o -> o.getIsCorrect()).count();
        double score = studentExamResult.getQuestions().stream().mapToDouble(StudentQuestion::getScore).sum();
        double passExamProbability = sigmoid(12.0 * (score - 57) / 100) * 100;
        List<KnowledgePoint> knowledgePointsList = wcfService.getKnowledgePoints(courseId);
        List<NameIdDataPair> knowledgePointCorrectRates = getKnowledgePointCorrectRate(studentExamResult.getQuestions(), knowledgePointsList);
        if (null == knowledgePointCorrectRates)
        {
            knowledgePointCorrectRates = new ArrayList<NameIdDataPair>();
        }
        List<ExamReviewSummaryView> reviewSummaries = new ArrayList<ExamReviewSummaryView>();
        for (NameIdDataPair kp : knowledgePointCorrectRates)
        {
            ExamReviewSummaryView examReviewSummaryView = new ExamReviewSummaryView();
            examReviewSummaryView.setKnowledgePointId(kp.getId());
            examReviewSummaryView.setKnowledgePointName(kp.getName());
            examReviewSummaryView.setStudentAccuracy((int)(kp.getValue() * 100));
            reviewSummaries.add(examReviewSummaryView);
        }
        studentExamResult.setWrongQuestionCount(wrongCount);
        studentExamResult.setCorrectQuestionCount(correctCount);
        studentExamResult.setScore(Double.parseDouble(String.format("%.1f", score)));
        studentExamResult.setPassExamProbability(passExamProbability);
        studentExamResult.setExamReviewSummaryViews(reviewSummaries);
    }

    /**
     * 填充考试结果的题目信息
     * 
     * @Title: fillExamResultQuestions
     * @author 幸仁强
     * @param sqs
     *            学生做题数据集合
     * @param qs
     *            MOTK题目对象集合
     */
    private void fillExamResultQuestions(List<StudentQuestion> sqs, List<Question> qs, List<QuestionDisplayType> questionDisplayTypes)
    {

        for (StudentQuestion sq : sqs)
        {
            Question q = qs.stream().filter(x -> x.getQuestionId() == sq.getQuestionId()).findFirst().orElse(null);
            if (StringUtils.isNotBlank(q.getCapabilityAnalysis().getValue()))
            {
                sq.setCapabilities(Arrays.stream(q.getCapabilityAnalysis().getValue().split(",")).mapToInt(Integer::valueOf).toArray());
            }
            if (StringUtils.isNotBlank(q.getSolveMethodLabel().getValue()))
            {
                sq.setSolvingMethods(Arrays.stream(q.getSolveMethodLabel().getValue().split(",")).mapToInt(Integer::valueOf).toArray());
            }
            sq.setMainKnowledgePoint(q.getMainKnowledgePoint());
            if (StringUtils.isNotBlank(q.getKnowledgePointLabels().getValue()))
            {
                sq.setOtherKnowledgePoints(Arrays.stream(q.getKnowledgePointLabels().getValue().split(",")).mapToInt(Integer::valueOf).toArray());
            }
            sq.setSectionId(q.getSectionMappings().getValue().getQuestionChapterSectionMapping().get(0).getSectionId());
            sq.setRootSectionId(q.getSectionMappings().getValue().getQuestionChapterSectionMapping().get(0).getRootSectionId());
            sq.setCourseMappingId(q.getSectionMappings().getValue().getQuestionChapterSectionMapping().get(0).getCourseMappingId());
            sq.setQuestionLevel(q.getQuestionLevel().intValue());
            sq.setIsCorrect(sq.getScore() / sq.getBaseScore() >= 0.6 ? true : false);
            sq.setIsOffline(true);
            sq.setRealTimeTaken(q.getFinishTime());
            if (StringUtils.isNotBlank(q.getMainKnowledgePoints().getValue()))
            {
                sq.setMainKnowledgePoints(
                    Arrays.stream((StringUtils.isNotBlank(q.getMainKnowledgePoints().getValue()) ? q.getMainKnowledgePoints().getValue() : "").split(",")).mapToInt(Integer::valueOf).toArray());
            }
            else
            {
                sq.setMainKnowledgePoints(new int[0]);
            }
            QuestionDisplayType questionDisplayType = questionDisplayTypes.stream().filter(o -> q.getQuestionDisplayTypeId() == o.getQuestionDisplayTypeId()).findFirst().orElse(null);
            if (null == questionDisplayType)
            {
                questionDisplayType = new QuestionDisplayType();
            }
            sq.setNotSupportCorrect(!questionDisplayType.isSupportOnline());
        }
    }

    /**
     * 判卷
     * 
     * @Title: executeGrading
     * @author 幸仁强
     * @param sqs
     *            学生答题信息集合
     * @param qs
     *            题库获取的题目信息集合
     */
    private void executeGrading(List<StudentQuestion> sqs, List<Question> qs, List<QuestionDisplayType> questionDisplayTypes)
    {
        for (StudentQuestion sq : sqs)
        {
            if (null == sq.getStudentGroupAnswers())
            {
                sq.setStudentGroupAnswers(new ArrayList<StudentGroupAnswer>());
            }
            Question q = qs.stream().filter(x -> x.getQuestionId() == sq.getQuestionId()).findFirst().orElse(null);
            if (null == q)
            {
                continue;
            }
            List<QuestionOptionGroup> optionGroups = q.getOptionGroups().getValue().getQuestionOptionGroup().stream().sorted(Comparator.comparing(QuestionOptionGroup::getOrder)).collect(
                Collectors.toList());
            double score = sq.getBaseScore() / (q.getOptionGroups().getValue().getQuestionOptionGroup().size() * 1.0);
            for (QuestionOptionGroup optionGroup : optionGroups)
            {
                if (optionGroup.getQuestionOptionGroupId() == 76021433)
                {
                    System.out.println(sq.getStudentGroupAnswers().size());
                }
                List<StudentGroupAnswer> studentAnswers = new ArrayList<StudentGroupAnswer>();
                studentAnswers = sq.getStudentGroupAnswers().stream().filter(o -> o.getQuestionOptionGroupId() == optionGroup.getQuestionOptionGroupId()).sorted(
                    Comparator.comparing(StudentGroupAnswer::getOrderId)).collect(Collectors.toList());

                if (studentAnswers.size() == 0)
                {
                    List<QuestionOptionGroupAnswer> optionGroupAnswers = optionGroup.getAnswers().getValue().getQuestionOptionGroupAnswer().stream().sorted(
                        Comparator.comparing(QuestionOptionGroupAnswer::getOrder)).collect(Collectors.toList());
                    for (QuestionOptionGroupAnswer oga : optionGroupAnswers)
                    {
                        StudentGroupAnswer studentGroupAnswer = new StudentGroupAnswer();
                        studentGroupAnswer.setQuestionOptionGroupId(optionGroup.getQuestionOptionGroupId());
                        studentGroupAnswer.setAnswer("");
                        studentGroupAnswer.setFillBlankTypeId(CommonConst.FILLBLANKTYPEID_SINGLESPACE);
                        studentGroupAnswer.setOperateType(CommonConst.OPERATETYPE_INSERT);
                        studentGroupAnswer.setId(optionGroup.getOrder());
                        studentGroupAnswer.setOrderId(oga.getOrder());
                        studentAnswers.add(studentGroupAnswer);
                    }
                    sq.getStudentGroupAnswers().addAll(studentAnswers);
                }
                int groupDisplayTypeId = optionGroup.getDisplayTypeId().intValue() == 0 ? q.getQuestionDisplayTypeId().intValue() : optionGroup.getDisplayTypeId().intValue();
                QuestionDisplayType questionDisplayType = questionDisplayTypes.stream().filter(o -> groupDisplayTypeId == o.getQuestionDisplayTypeId()).findFirst().orElse(null);
                if (null == questionDisplayType)
                {
                    questionDisplayType = new QuestionDisplayType();
                    questionDisplayType.setSupportArtificialGrading(false);
                    questionDisplayType.setSupportOnline(false);
                }

                TwoTuple<GradingResultTypeEnum, List<OptionGroupResult>> gradingResult = generateStudentAnswerCorrectForXk(optionGroup, studentAnswers, questionDisplayType, score);
                sq.setScore(sq.getScore() + gradingResult.second.stream().mapToDouble(OptionGroupResult::getScore).sum());
                generateQuestionOptionGroupResult(sq, optionGroup, gradingResult.second);
            }
            if (!sq.getNotSupportCorrect() && sq.getQuestionOptionGroupResult() != null)
            {
                sq.setIsCorrect(isAllCorrect(sq.getQuestionOptionGroupResult()));
            }
        }
    }

    /**
     * 拆分CalculateScore，进行判卷结果赋值
     * 
     * @Title: GenerateQuestionOptionGroupResult
     * @author 幸仁强
     * @param studentQuestion
     *            学生做题信息
     * @param group
     *            小题信息
     * @param gradingResult
     *            判卷结果
     */
    private void generateQuestionOptionGroupResult(StudentQuestion sq, QuestionOptionGroup group, List<OptionGroupResult> gradingResult)
    {
        if (null == sq.getQuestionOptionGroupResult())
        {
            sq.setQuestionOptionGroupResult(new ArrayList<OptionGroupResult>());
        }
        sq.getQuestionOptionGroupResult().stream().sorted(Comparator.comparing(OptionGroupResult::getQuestionOptionGroupId).thenComparing(OptionGroupResult::getOrderId)).collect(Collectors.toList());
        OptionGroupResult ogr = sq.getQuestionOptionGroupResult().stream().filter(o -> o.getQuestionOptionGroupId() == group.getQuestionOptionGroupId()).findFirst().orElse(null);
        int index = sq.getQuestionOptionGroupResult().indexOf(ogr);
        OptionGroupResult result = gradingResult.stream().findFirst().orElse(null);
        if (result == null)
        {
            return;
        }
        if (index < 0)
        {
            sq.getQuestionOptionGroupResult().add(result);
        }
        else
        {
            Collections.replaceAll(sq.getQuestionOptionGroupResult(), sq.getQuestionOptionGroupResult().get(index), result);
        }
    }

    /**
     * 自动批改工厂，根据不同的题型进行分配
     * 
     * @Title: generateStudentAnswerCorrectForXk
     * @author 幸仁强
     * @param studentAnswers
     *            用户作答的答案
     * @param questionDisplayType
     *            题型
     * @param score
     *            分数
     * @return
     */
    private TwoTuple<GradingResultTypeEnum, List<OptionGroupResult>> generateStudentAnswerCorrectForXk(QuestionOptionGroup optionGroup, List<StudentGroupAnswer> studentAnswers,
                                                                                                       QuestionDisplayType questionDisplayType, double score)
    {
        if (questionDisplayType.isSupportOnline())
        {
            return isStudentAnswerCorrectForXk(optionGroup, studentAnswers, QuestionDisplayTypeEnum.convertThis(questionDisplayType.getQuestionDisplayTypeId().intValue()), score);
        }
        if (questionDisplayType.isSupportArtificialGrading())
        {
            log.error(String.format("questionId为%s的题目为主观题", optionGroup.getQuestionId()));
        }
        return isUnknownAnswerCorrect(optionGroup, studentAnswers);
    }

    /**
     * 单选题格式 A 多选题格式 BC 完形填空 A 7选5题型 A,B,C(每空判分) 处理小题的学生答案是否正确
     * 
     * @Title: isStudentAnswerCorrect
     * @author 幸仁强
     * @param optionGroup
     * @param studentAnswers
     *            用户作答的答案
     * @param questionDisplayType
     * @param groupScore
     * @return
     */
    private TwoTuple<GradingResultTypeEnum, List<OptionGroupResult>> isStudentAnswerCorrectForXk(QuestionOptionGroup optionGroup, List<StudentGroupAnswer> studentAnswers,
                                                                                                 QuestionDisplayTypeEnum questionDisplayType, double groupScore)
    {
        List<OptionGroupResult> result = new ArrayList<OptionGroupResult>();
        List<QuestionOptionGroupAnswer> groupAnswers = optionGroup.getAnswers().getValue().getQuestionOptionGroupAnswer().stream().sorted(
            Comparator.comparing(QuestionOptionGroupAnswer::getOrder)).collect(Collectors.toList());
        List<StudentGroupAnswer> userAnswers = studentAnswers.stream().sorted(Comparator.comparing(StudentGroupAnswer::getOrderId)).collect(Collectors.toList());
        double score = groupScore / groupAnswers.size() * 1.0;
        int orderIndex = 0;
        for (int i = 0; i < groupAnswers.size(); i++ )
        {
            QuestionOptionGroupAnswer groupAnswer = groupAnswers.get(i);
            log.info(String.format("questionId:%s, QuestionOptionGroupId:%s", groupAnswer.getQuestionId(), groupAnswer.getQuestionOptionGroupId()));
            StudentGroupAnswer userAnswer = userAnswers.get(i);

            if (userAnswer.getAnswer().compareToIgnoreCase(groupAnswer.getAnswer().getValue()) != 0)
            {
                QuestionDoingStatusEnum questionDoingStatus = !StringUtils.isNotBlank(userAnswer.getAnswer()) ? QuestionDoingStatusEnum.Done : QuestionDoingStatusEnum.Undo;
                OptionGroupResult optionGroupResult = new OptionGroupResult(optionGroup.getQuestionOptionGroupId().intValue(), GradingResultTypeEnum.Wrong, orderIndex, userAnswer.getId(),
                    GradingTypeEnum.Auto, questionDoingStatus, true, 0);
                result.add(optionGroupResult);
            }
            else
            {
                result.add(new OptionGroupResult(optionGroup.getQuestionOptionGroupId().intValue(), GradingResultTypeEnum.Correct, orderIndex, userAnswer.getId(), GradingTypeEnum.Auto,
                    QuestionDoingStatusEnum.Done, true, score));
            }
            orderIndex++ ;
        }
        return new TwoTuple<GradingResultTypeEnum, List<OptionGroupResult>>(isAllCorrect(result) ? GradingResultTypeEnum.Correct : GradingResultTypeEnum.Wrong, result);
    }

    /**
     * 主观题判卷，如果不能人工判卷的情况使用此方式
     * 
     * @Title: IsUnknownAnswerCorrect
     * @author 幸仁强
     * @param studentAnswers
     *            用户作答的答案
     * @return
     */
    private TwoTuple<GradingResultTypeEnum, List<OptionGroupResult>> isUnknownAnswerCorrect(QuestionOptionGroup optionGroup, List<StudentGroupAnswer> studentAnswers)
    {
        List<OptionGroupResult> result = new ArrayList<OptionGroupResult>();
        List<String> userAnswers = studentAnswers.stream().sorted(Comparator.comparing(StudentGroupAnswer::getOrderId)).map(StudentGroupAnswer::getAnswer).collect(Collectors.toList());
        QuestionDoingStatusEnum questionDoingStatus = (isAllEmpty(userAnswers) ? QuestionDoingStatusEnum.Undo : QuestionDoingStatusEnum.Done);
        OptionGroupResult optionGroupResult = new OptionGroupResult(optionGroup.getQuestionOptionGroupId().intValue(), GradingResultTypeEnum.UnGrading, -1, -1, GradingTypeEnum.UnKnow,
            questionDoingStatus, false, 0);
        result.add(optionGroupResult);
        return new TwoTuple<GradingResultTypeEnum, List<OptionGroupResult>>(GradingResultTypeEnum.UnGrading, result);
    }

    /**
     * List是否为空，或者是否里面都为空字符串
     * 
     * @Title: isAllEmpty
     * @author 幸仁强
     * @param list
     * @return
     */
    private boolean isAllEmpty(List<String> list)
    {
        if (list == null || list.isEmpty())
        {
            return true;
        }
        for (String o : list)
        {
            if (StringUtils.isNotBlank(o))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否全对
     * 
     * @Title: isAllCorrect
     * @author 幸仁强
     * @param list
     * @return
     */
    private boolean isAllCorrect(List<OptionGroupResult> list)
    {
        for (OptionGroupResult o : list)
        {
            if (o.getGradingResult() != GradingResultTypeEnum.Correct)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Sigmoid数学函数
     * 
     * @Title: sigmoid
     * @author 幸仁强
     * @param x
     * @return
     */
    private static double sigmoid(double x)
    {
        return 1 / (1 + Math.pow(Math.E, -1 * x));
    }

    /**
     * 封装NameIdDataPair对象
     * 
     * @Title: getKnowledgePointCorrectRate
     * @author 幸仁强
     * @param studentQuestions
     * @param knowledePoints
     * @return
     */
    public List<NameIdDataPair> getKnowledgePointCorrectRate(List<StudentQuestion> studentQuestions, List<KnowledgePoint> knowledePoints)
    {
        // 临时存正确数量
        Map<Integer, NameIdDataPair> dics = new HashMap<Integer, NameIdDataPair>();
        // 临时存总数
        Map<Integer, NameIdDataPair> dics1 = new HashMap<Integer, NameIdDataPair>();
        generateKnowledgePointCorrectRate(dics, dics1, studentQuestions, knowledePoints);
        List<NameIdDataPair> result = new ArrayList<NameIdDataPair>();
        for (Integer key : dics.keySet())
        {
            NameIdDataPair kp = dics.get(key);
            kp.setValue(kp.getValue() / dics1.get(key).getValue());
            result.add(kp);
        }
        return result;
    }

    /**
     * 生成知识点正确率
     * 
     * @Title: generateKnowledgePointCorrectRate
     * @author 幸仁强
     * @param correctCount
     * @param totalCount
     * @param studentQuestions
     * @param knowledePoints
     */
    public void generateKnowledgePointCorrectRate(Map<Integer, NameIdDataPair> correctCount, Map<Integer, NameIdDataPair> totalCount, List<StudentQuestion> studentQuestions,
                                                  List<KnowledgePoint> knowledePoints)
    {
        for (StudentQuestion sq : studentQuestions)
        {
            if (!sq.isIncludeAnalysis())
            {
                continue;
            }
            List<Integer> mainKnowledgePoints = new ArrayList<Integer>();
            mainKnowledgePoints.add(sq.getMainKnowledgePoint());
            mainKnowledgePoints.addAll(Arrays.stream(sq.getMainKnowledgePoints()).boxed().collect(Collectors.toList()));
            for (int mainKnowledgePoint : mainKnowledgePoints)
            {
                if (correctCount.containsKey(mainKnowledgePoint))
                {
                    if (sq.getIsCorrect())
                    {
                        NameIdDataPair kp = correctCount.get(mainKnowledgePoint);
                        kp.setValue(kp.getValue() + 1.0);
                    }
                    NameIdDataPair kp1 = totalCount.get(mainKnowledgePoint);
                    kp1.setValue(kp1.getValue() + 1.0);
                }
                else
                {
                    KnowledgePoint k = knowledePoints.stream().filter(x -> x.getKnowledgePointId() == mainKnowledgePoint).findFirst().orElse(null);
                    if (k != null)
                    {
                        correctCount.put(mainKnowledgePoint, new NameIdDataPair(mainKnowledgePoint, k.getKnowledgePointName().getValue(), sq.getIsCorrect() ? 1.0 : 0.0));
                        totalCount.put(mainKnowledgePoint, new NameIdDataPair(mainKnowledgePoint, k.getKnowledgePointName().getValue(), 1.0));
                    }
                }
            }
        }
    }
}
