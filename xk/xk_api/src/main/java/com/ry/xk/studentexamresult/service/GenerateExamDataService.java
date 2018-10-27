package com.ry.xk.studentexamresult.service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.ry.xk.request.bo.GenerateExamDataRequest;
import com.ry.xk.studentexamresult.bo.ExamPaper;
import com.ry.xk.studentexamresult.bo.ExamPaperQuestion;
import com.ry.xk.studentexamresult.bo.ExamSet;
import com.ry.xk.studentexamresult.bo.ExamSetQuestion;
import com.ry.xk.studentexamresult.bo.StudentExam;
import com.ry.xk.studentexamresult.bo.StudentExamInProgressInfo;
import com.ry.xk.studentexamresult.bo.StudentExamItem;
import com.ry.xk.studentexamresult.bo.StudentExamList;
import com.ry.xk.studentexamresult.bo.StudentExamProgressQuestion;
import com.ry.xk.studentexamresult.bo.UserResource;
import com.ry.xk.studentexamresult.bo.UserResourceList;
import com.ry.xk.studentexamresult.dao.IExamPaperDao;
import com.ry.xk.studentexamresult.dao.IExamSetDao;
import com.ry.xk.studentexamresult.dao.IStudentExamDao;
import com.ry.xk.studentexamresult.dao.IStudentExamInProgressInfoDao;
import com.ry.xk.studentexamresult.dao.IUserResourceDao;
import com.ry.xk.utils.DateUtil;
import com.ry.xk.utils.UrlUtil;

import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.Question;

/**
 * 测试业务类
 * 
 * @ClassName: ExamService
 * @author 幸仁强
 * @date 2018年06月01日
 */
@Service
public class GenerateExamDataService implements IGenerateExamDataService
{
    private static final Logger log = LoggerFactory.getLogger(GenerateExamDataService.class);

    @Autowired
    IUserResourceDao userResourceDao;

    @Autowired
    IStudentExamDao studentExamDao;

    @Autowired
    IExamSetDao examSetDao;

    @Autowired
    IExamPaperDao examPaperDao;

    @Autowired
    IWCFService wcfService;

    @Autowired
    IStudentExamInProgressInfoDao studentExamInProgressInfoDao;

    @Override
    public long checkAndGenerateExamData(GenerateExamDataRequest request)
        throws Exception
    {
        int userId = request.getUserId();
        int examPaperId = UrlUtil.idDecrypt(request.getExamPaperId(), Integer.class);
        if (examPaperId == 0)
        {
            log.error(MessageFormat.format("examPaperId为{0}的试卷ID解析错误", request.getExamPaperId()));
            return 0;
        }
        if (!this.isBuy(userId, examPaperId))
        {
            log.error(MessageFormat.format("userId为{0}的用户未购买examPaperId为{1}的试卷", userId, examPaperId));
            return 0;
        }
        long studentExamId = this.getDoingStudentExamId(userId, examPaperId);
        if (studentExamId > 0)
        {
            return studentExamId;
        }
        ExamPaper examPaper = examPaperDao.get(examPaperId);
        if (null == examPaper || examPaper.getStatusFlag() != 1 || examPaper.getExpireTime().before(new Date()))
        {
            log.error(MessageFormat.format("根据试卷ID{0}未查询到试卷", examPaperId));
            return 0;
        }
        if (null == examPaper.getExampaperquestion() || examPaper.getExampaperquestion().size() == 0)
        {
            log.error(MessageFormat.format("根据试卷ID{0}查询到试卷，但题目为空", examPaperId));
            return 0;
        }
        return generateExamData(userId, examPaper);
    }

    /**
     * 生成考试数据
     * 
     * @Title: generateExamData
     * @author 幸仁强
     * @param userId
     * @param examPaper
     * @return
     * @throws Exception
     */
    private long generateExamData(int userId, ExamPaper examPaper)
        throws Exception
    {
        List<ExamPaperQuestion> examPaperQuestions = examPaper.getExampaperquestion().stream().sorted(Comparator.comparing(ExamPaperQuestion::getOrderIndex)).collect(Collectors.toList());
        ExamSet examSet = new ExamSet(1);
        int examSetId = examSetDao.insertExamSet(examSet);
        if (examSetId == 0)
        {
            log.error(MessageFormat.format("根据试卷ID{0}生成题集信息失败", examPaper.getExamPaperId()));
            return 0;
        }
        List<ExamSetQuestion> examSetQuestions = new ArrayList<ExamSetQuestion>();
        List<StudentExamProgressQuestion> examDoingQuestions = new ArrayList<StudentExamProgressQuestion>();
        double totalScore = 0;
        for (ExamPaperQuestion o : examPaperQuestions)
        {
            // TODO 章节，知识点没填充
            ExamSetQuestion examSetQuestion = new ExamSetQuestion(examSetId, o.getQuestionId(), o.getQuestionScore(), o.getOrderIndex());
            StudentExamProgressQuestion studentExamProgressQuestion = new StudentExamProgressQuestion(examSetQuestion, o.getOrderIndex(), 0, o.getQuestionId(),
                CommonConst.QUESTIONDOINGTYPE_OBJECTIVE);
            examSetQuestions.add(examSetQuestion);
            examDoingQuestions.add(studentExamProgressQuestion);
            totalScore += o.getQuestionScore();
        }
        // TODO,注意看下examSetID是否自动回填进ExamSet对象
        examSet.setExamSetQuestions(examSetQuestions);
        if (!examSetDao.updateExamSet(examSet))
        {
            log.error(MessageFormat.format("根据试卷ID{0}生成题集题目信息失败", examPaper.getExamPaperId()));
            return 0;
        }
        int firstQuestionId = examPaperQuestions.get(0).getQuestionId();
        Question question = wcfService.getQuestionById(firstQuestionId);
        int bookVersionId = getBookVersionIdByQuestion(question);
        int courseMappingId = getCourseMappingIdByQuestion(question);
        Calendar nowTime = Calendar.getInstance();
        Date startTime = nowTime.getTime();
        nowTime.add(Calendar.MINUTE, examPaper.getExamTime());
        Date endTime = nowTime.getTime();
        StudentExam studentExam = new StudentExam(examPaper.getExamPaperId(), userId, examSetId, CommonConst.EXAMPAPER_UNSUBMITTED, totalScore, examPaper.getCourseId(), examPaperQuestions.size(),
            CommonConst.STATUS_FLAG_VALID, startTime);
        studentExam.setExamEndTime(endTime);

        studentExam.setBookVersionId(bookVersionId);
        long studentExamId = studentExamDao.insertStudentExam(studentExam);
        if (studentExamId == 0)
        {
            log.error(MessageFormat.format("根据试卷ID{0}生成学生测试信息失败", examPaper.getExamPaperId()));
            return 0;
        }
        StudentExamInProgressInfo studentExamInProgressInfo = studentExamInProgressInfoDao.get(studentExamId);
        if (null == studentExamInProgressInfo)
        {
            studentExamInProgressInfo = new StudentExamInProgressInfo(studentExamId, examSetId, examDoingQuestions, bookVersionId, courseMappingId, userId, firstQuestionId, startTime,
                examPaper.getCourseId());
            studentExamInProgressInfoDao.update(studentExamInProgressInfo);
        }
        StudentExamList studentExamList = studentExamDao.getStudentExamList(userId);
        if (null == studentExamList)
        {
            List<StudentExamItem> studentExamItems = new ArrayList<StudentExamItem>();
            studentExamItems.add(new StudentExamItem(userId, examPaper.getExamPaperId(), studentExamId, startTime, endTime, false));
            studentExamList = new StudentExamList(userId, studentExamItems);
            studentExamDao.updateStudentExamList(studentExamList);
        }
        else
        {
            studentExamList.getStudentExamItems().add(new StudentExamItem(userId, examPaper.getExamPaperId(), studentExamId, startTime, endTime, false));
            studentExamDao.updateStudentExamList(studentExamList);
        }
        return studentExamId;
    }

    @Override
    public boolean isBuy(int userId, int examPaperId)
    {
        UserResourceList resourceListObj = userResourceDao.getUserResource(userId, CommonConst.RESOURCETYPE_EXAMEPAPER);
        if (null == resourceListObj || null == resourceListObj.getUserResource() || resourceListObj.getUserResource().size() == 0)
        {
            return false;
        }
        UserResource resource = resourceListObj.getUserResource().stream().filter(o -> o.getResourceId() == examPaperId && o.getStatusFlag() == CommonConst.STATUS_FLAG_VALID).findFirst().orElse(null);
        if (null == resource)
        {
            return false;
        }
        return true;
    }

    @Override
    public long getDoingStudentExamId(int userId, int examPaperId)
    {
        StudentExamList studentExamList = studentExamDao.getStudentExamList(userId);
        if (null == studentExamList || null == studentExamList.getStudentExamItems() || studentExamList.getStudentExamItems().size() == 0)
        {
            return 0;
        }
        List<StudentExamItem> recodes = studentExamList.getStudentExamItems();
        StudentExamItem firstRecode;
        try
        {
            firstRecode = recodes.stream().sorted(Comparator.comparing(StudentExamItem::getCreateDateTime).reversed()).filter(
                o -> (DateUtil.isPassDate(o.getCreateDateTime(), o.getEndDateTime()) && !o.getIsGenerateEvaluation() && o.getExamPaperId() == examPaperId)).findFirst().orElse(null);
        }
        catch (Exception e)
        {
            log.error(String.format("获取正在进行的测试异常，userId为%s,examPaperId为", userId, examPaperId), e);
            return 0;
        }
        return null != firstRecode ? firstRecode.getStudentExamId() : 0;
    }

    /**
     * 根据题目获取BookVersionID
     * 
     * @Title: getBookVersionIdByQuestionId
     * @author 幸仁强
     * @param questionId
     * @return
     * @throws Exception
     */
    private int getBookVersionIdByQuestion(Question question)
    {
        try
        {
            int bookVersionId = question.getSectionMappings().getValue().getQuestionChapterSectionMapping().get(0).getBookVersionId();
            if (bookVersionId == 0)
            {
                log.error(MessageFormat.format("根据试卷题目ID为{0}生成学生测试信息失败，bookVersionId为0", question.getQuestionId()));
            }
            return bookVersionId;
        }
        catch (Exception e)
        {
            log.error(MessageFormat.format("根据试卷题目ID为{0}生成学生测试信息失败，获取bookVersionId是异常", question.getQuestionId()), e);
            return 0;
        }
    }

    /**
     * 根据题目获取courseMappingID
     * 
     * @Title: getBookVersionIdByQuestionId
     * @author 幸仁强
     * @param questionId
     * @return
     * @throws Exception
     */
    private int getCourseMappingIdByQuestion(Question question)
    {
        try
        {
            int courseMappingId = question.getSectionMappings().getValue().getQuestionChapterSectionMapping().get(0).getCourseMappingId();
            if (courseMappingId == 0)
            {
                log.error(MessageFormat.format("根据试卷题目ID为{0}生成学生测试信息失败，bookVersionId为0", question.getQuestionId()));
            }
            return courseMappingId;
        }
        catch (Exception e)
        {
            log.error(MessageFormat.format("根据试卷题目ID为{0}生成学生测试信息失败，获取bookVersionId是异常", question.getQuestionId()), e);
            return 0;
        }
    }

}
