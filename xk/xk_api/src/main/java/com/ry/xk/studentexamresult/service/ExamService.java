package com.ry.xk.studentexamresult.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.xk.response.bo.AnswerSheet;
import com.ry.xk.response.bo.ExamModule;
import com.ry.xk.studentexamresult.bo.StudentExam;
import com.ry.xk.studentexamresult.bo.StudentExamInProgressInfo;
import com.ry.xk.studentexamresult.bo.StudentExamItem;
import com.ry.xk.studentexamresult.bo.StudentExamList;
import com.ry.xk.studentexamresult.bo.StudentExamProgressQuestion;
import com.ry.xk.studentexamresult.dao.IExamPaperDao;
import com.ry.xk.studentexamresult.dao.IExamSetDao;
import com.ry.xk.studentexamresult.dao.IStudentExamDao;
import com.ry.xk.studentexamresult.dao.IStudentExamInProgressInfoDao;
import com.ry.xk.studentexamresult.dao.IUserResourceDao;
import com.ry.xk.utils.DateUtil;

/**
 * 测试业务类
 * 
 * @ClassName: ExamService
 * @author 幸仁强
 * @date 2018年06月01日
 */
@Service
public class ExamService implements IExamService
{
    private static final Logger log = LoggerFactory.getLogger(ExamService.class);

    @Autowired
    IUserResourceDao userResourceDao;

    @Autowired
    IStudentExamDao studentExamDao;

    @Autowired
    IExamSetDao examSetDao;

    @Autowired
    IExamPaperDao examPaperDao;

    @Autowired
    IStudentExamInProgressInfoDao studentExamInProgressInfoDao;

    /**
     * 验证测试是否属于某个用户
     * 
     * @param userId
     * @param studentExamId
     * @return
     */
    public boolean validateExamAndUser(int userId, long studentExamId)
    {
        boolean validateResult = false;
        try
        {
            StudentExam studentExam = studentExamDao.getStudentExam(studentExamId);
            if (studentExam.getUserId() == userId)
            {
                validateResult = true;
            }
        }
        catch (Exception e)
        {
            log.error("获取studentExma异常" + studentExamId, e);
        }
        return validateResult;
    }

    /**
     * 获取测试基本信息
     * 
     * @param studentExamId
     * @return
     */
    @Override
    public ExamModule get(int userId, long studentExamId)
        throws Exception
    {
        if (!validateExamAndUser(userId, studentExamId))
        {
            log.error(String.format("用户ID和学生测试ID不匹配,userId为%s,studentExamId为%s", userId, studentExamId));
            throw new Exception();
        }
        StudentExamInProgressInfo studentExamInProgressInfo = studentExamInProgressInfoDao.get(studentExamId);
        ExamModule examModule = null;
        if (studentExamInProgressInfo != null)
        {
            examModule = new ExamModule();
            examModule.setDoneQuestionCount(0);
            StudentExamItem studentExamItem = null;
            StudentExamList studentExamList = studentExamDao.getStudentExamList(userId);
            if (studentExamList != null)
            {
                List<StudentExamItem> studentExamItems = studentExamList.getStudentExamItems().stream().filter((o) -> o.getStudentExamId() == studentExamId).collect(Collectors.toList());
                if (studentExamItems.size() > 0)
                {
                    studentExamItem = studentExamItems.get(0);
                }
            }
            if (studentExamItem == null)
            {
                // 学生当前测试记录在缓存中不存在
                return null;
            }
            examModule.setExamTime((int)DateUtil.min(studentExamItem.getCreateDateTime(), studentExamItem.getEndDateTime()));
            examModule.setExamTimed((int)DateUtil.second(studentExamItem.getCreateDateTime(), new Date()));
            if (studentExamInProgressInfo.getExamDoingQuestions() != null)
            {
                int doneCount = (int)studentExamInProgressInfo.getExamDoingQuestions().stream().filter(o -> StringUtils.isNotEmpty(o.getStudentAnswer())).count();
                int count = studentExamInProgressInfo.getExamDoingQuestions().size();
                examModule.setDoneQuestionCount(doneCount);
                examModule.setQuestionCount(count);
                examModule.setLastQuestionId(studentExamInProgressInfo.getLastQuestionId());
                // 组织答题卡信息
                List<AnswerSheet> answerSheets = new ArrayList<AnswerSheet>();
                // 先排序
                List<StudentExamProgressQuestion> sortStudentExamProgressQuestions = studentExamInProgressInfo.getExamDoingQuestions().stream().sorted(
                    (o1, o2) -> o1.getQuestionIndex() - o2.getQuestionIndex()).collect(Collectors.toList());
                sortStudentExamProgressQuestions.forEach((o) -> {
                    int questionId = o.getQuestionId();
                    int orderIndex = o.getQuestionIndex();
                    boolean isDone = StringUtils.isNotEmpty(o.getStudentAnswer());
                    AnswerSheet answerSheet = new AnswerSheet(questionId, orderIndex, isDone);
                    answerSheets.add(answerSheet);
                });
                examModule.setAnswerSheets(answerSheets);
            }
            else
            {
                log.error("获取本次测试题目信息异常studentExamId" + studentExamId);
            }
        }
        return examModule;
    }

}
