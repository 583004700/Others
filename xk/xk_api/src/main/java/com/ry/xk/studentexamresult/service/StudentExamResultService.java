package com.ry.xk.studentexamresult.service;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.xk.common.CommonConst;
import com.ry.xk.main.bo.Course;
import com.ry.xk.main.dao.ICommonDictionaryDao;
import com.ry.xk.main.dao.ICourseDao;
import com.ry.xk.response.bo.AnalysisAnswerSheets;
import com.ry.xk.response.bo.ExamResultModule;
import com.ry.xk.response.bo.KnowledgePoint;
import com.ry.xk.studentexamresult.bo.ExamSet;
import com.ry.xk.studentexamresult.bo.ExamSetQuestion;
import com.ry.xk.studentexamresult.bo.StudentExam;
import com.ry.xk.studentexamresult.bo.StudentExamResult;
import com.ry.xk.studentexamresult.bo.StudentQuestion;
import com.ry.xk.studentexamresult.dao.IExamSetDao;
import com.ry.xk.studentexamresult.dao.IStudentExamDao;
import com.ry.xk.studentexamresult.dao.IStudentExamResultDao;
import com.ry.xk.utils.UrlUtil;

@Service
public class StudentExamResultService implements IStudentExamResultService
{
    // 日志操作对象
    private static final Logger log = LoggerFactory.getLogger(StudentExamResultService.class);

    @Autowired
    IStudentExamResultDao studentExamResultDao;

    @Autowired
    IExamSetDao examSetDao;

    @Autowired
    IStudentExamDao studentExamDao;

    @Autowired
    ICourseDao courseDao;

    @Autowired
    IExamService examService;

    @Autowired
    ICommonDictionaryDao commonDictionaryDao;

    /**
     * 通过测试ID获取本次测试的测评信息
     * 
     * @param studentExamId
     * @return
     */
    public ExamResultModule getExamResult(int userId, long studentExamId)
        throws Exception
    {
        if (!examService.validateExamAndUser(userId, studentExamId))
        {
            log.error(String.format("用户ID和学生测试ID不匹配,userId为%s,steId为%s", userId, studentExamId));
            throw new Exception();
        }
        StudentExamResult studentExamResult = studentExamResultDao.get(studentExamId);
        StudentExam studentExam = studentExamDao.getStudentExam(studentExamId);
        String courseIdStr = UrlUtil.idEncrypt(studentExam.getCourseId());
        Course course = courseDao.getAll().stream().filter(o -> o.getCourseId() == studentExam.getCourseId()).collect(Collectors.toList()).get(0);
        int courseTypeId = course.getCourseTypeId();
        String courseName = course.getCourseName();
        ExamResultModule examResultModule = null;
        if (studentExamResult != null)
        {
            examResultModule = new ExamResultModule();
            examResultModule.setScore(studentExamResult.getScore());
            examResultModule.setExamPaperId(UrlUtil.idEncrypt(studentExam.getExamPaperId()));
            examResultModule.setCourseName(courseName);
            try
            {
                String courseTypeName = commonDictionaryDao.getAll().stream().filter(
                    o -> String.valueOf(CommonConst.COMMONDICTIONARYTYPE_COUSETYPE).equals(o.getItemGroup()) && o.getItemKey() == courseTypeId).collect(Collectors.toList()).get(0).getItemValue();
                examResultModule.setCourseTypeName(courseTypeName);
            }
            catch (Exception e)
            {
                log.error("获取学段名称异常" + courseTypeId);
            }
            NumberFormat nf = NumberFormat.getInstance();
            nf.setRoundingMode(RoundingMode.HALF_UP);// 设置四舍五入
            nf.setMinimumFractionDigits(0);// 设置最小保留几位小数
            nf.setMaximumFractionDigits(0);// 设置最大保留几位小数
            double passExamProbability = Double.parseDouble(nf.format(studentExamResult.getPassExamProbability()));
            examResultModule.setPassExamProbability(passExamProbability);
            examResultModule.setCourseId(courseIdStr);
            examResultModule.setCourseTypeId(courseTypeId);
            // 构造知识点集合
            List<KnowledgePoint> knowledgePoints = new ArrayList<KnowledgePoint>();
            if (studentExamResult.getExamReviewSummaryViews() != null && studentExamResult.getExamReviewSummaryViews().size() > 0)
            {
                studentExamResult.getExamReviewSummaryViews().forEach((o) -> {
                    KnowledgePoint knowledgePoint = new KnowledgePoint();
                    knowledgePoint.setKnowledgePointAccuracy(o.getStudentAccuracy());
                    knowledgePoint.setKnowledgePointName(o.getKnowledgePointName());
                    knowledgePoints.add(knowledgePoint);
                });
            }
            examResultModule.setKnowledgePointResults(knowledgePoints);
        }
        return examResultModule;
    }

    /**
     * 获取测试解析信息
     * 
     * @param studentExamId
     * @return
     */

    public List<AnalysisAnswerSheets> getAnalysisAnswerSheets(int userId, long studentExamId)
        throws Exception
    {
        if (!examService.validateExamAndUser(userId, studentExamId))
        {
            log.error(String.format("用户ID和学生测试ID不匹配,userId为%s,steId为%s", userId, studentExamId));
            throw new Exception();
        }
        List<AnalysisAnswerSheets> analysisAnswerSheets = new ArrayList<AnalysisAnswerSheets>();
        StudentExamResult studentExamResult = studentExamResultDao.get(studentExamId);
        // 通过测试ID获取题集
        StudentExam studentExam = studentExamDao.getStudentExam(studentExamId);
        ExamSet examSet = examSetDao.getExamSet(studentExam.getExamSetId());
        if (studentExamResult != null && studentExamResult.getQuestions() != null && examSet != null && examSet.getExamSetQuestions() != null)
        {
            List<StudentQuestion> questions = studentExamResult.getQuestions();
            List<ExamSetQuestion> examSetQuestions = examSet.getExamSetQuestions();
            questions.forEach(t -> {
                AnalysisAnswerSheets analysisAnswerSheet = new AnalysisAnswerSheets();
                try
                {
                    List<ExamSetQuestion> currentQuestions = examSetQuestions.stream().filter(o -> o.getQuestionId() == t.getQuestionId()).collect(Collectors.toList());
                    analysisAnswerSheet.setOrderIndex(currentQuestions.get(0).getOrderIndex());
                }
                catch (Exception e)
                {
                    log.error("获取题目解析异常，当前题目在题集中不存在studentExamId" + studentExamId + "questionId" + t.getQuestionId(), e);
                }
                analysisAnswerSheet.setQuestionId(t.getQuestionId());
                analysisAnswerSheet.setQuestionCorrectStatus(t.getIsCorrect() ? CommonConst.PGZQ : CommonConst.PGCY);
                analysisAnswerSheets.add(analysisAnswerSheet);
            });
        }
        List<AnalysisAnswerSheets> orderAnalysisAnswerSheets = analysisAnswerSheets.stream().sorted((o1, o2) -> o1.getOrderIndex() - o2.getOrderIndex()).collect(Collectors.toList());
        return orderAnalysisAnswerSheets;
    }
}
