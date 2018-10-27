package com.ry.xk.studentexamresult.service;


import com.ry.xk.main.bo.Course;
import com.ry.xk.main.service.CouchBaseFactory;
import com.ry.xk.main.service.ICourseService;
import com.ry.xk.main.service.IWCFService;
import com.ry.xk.response.bo.*;
import com.ry.xk.studentexamresult.bo.*;
import com.ry.xk.studentexamresult.dao.IWrongBookDao;
import com.ry.xk.utils.DateUtil;
import com.ry.xk.utils.ListHelper;
import com.ry.xk.utils.UrlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcf.tikuservice.org.datacontract.schemas._2004._07.motk_model.Question;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class WrongBookService implements IWrongBookService
{
    private static final Logger log = LoggerFactory.getLogger(WrongBookService.class);

    @Autowired
    ICourseService courseService;

    @Autowired
    IWrongBookDao wrongBookDao;

    @Autowired
    IWCFService wcfService;

    @Autowired
    IQuestionService questionService;

    /**
     * 获取用户当前学段下所有学科的错题本
     *
     * @return
     */
    public List<WrongBook> getUserWrongBook(int partnerId, int userId, int courseTypeId)
    {
        // 通过partnerId和courseTypeId获取所有学科
        List<Course> courses = courseService.getCourseByCourseType(partnerId, courseTypeId);
        // 用户当前学段每个学科的错题
        List<WrongBook> userWrongBooks = new ArrayList<WrongBook>();
        // 获取用户每个学科的错题本对象，并添加到userWrongBooks集合中
        courses.forEach((o) -> {
            WrongBook wrongBook = wrongBookDao.get(userId, o.getCourseId());
            userWrongBooks.add(wrongBook);
        });
        return userWrongBooks;
    }

    /**
     * 获取学科和对应的错题数量
     *
     * @param partnerId
     * @param userId
     * @param courseTypeId
     * @return
     */
    @Override
    public List<CourseWrongCountModule> getCourseWrongCounts(int partnerId, int userId, int courseTypeId)
    {
        // 获取用户当前学段下所有学科和错题
        List<WrongBook> userWrongBook = getUserWrongBook(partnerId, userId, courseTypeId);
        List<CourseWrongCountModule> userWrongModule = new ArrayList<CourseWrongCountModule>();
        userWrongBook.forEach((o) -> {
            CourseWrongCountModule courseWrongCountModule = new CourseWrongCountModule();
            Course course = courseService.getById(partnerId, o.getCourseId());
            try
            {
                String courseIdStr = UrlUtil.idEncrypt(o.getCourseId());
                courseWrongCountModule.setCourseId(courseIdStr);
            }
            catch (Exception e)
            {
                log.error("加密CourseId异常CourseId" + o.getCourseId(), e);
            }
            courseWrongCountModule.setCourseName(course.getCourseName());
            courseWrongCountModule.setShortCode(course.getShortCode());
            courseWrongCountModule.setWrongCount(o.getWrongQuestions().size());
            userWrongModule.add(courseWrongCountModule);
        });
        return userWrongModule;
    }

    /**
     * 获取错题列表给controller层
     *
     * @param userId
     * @param courseId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<WrongBookItemModule> getWrongBookItemModules(int userId, int courseId, int pageIndex, int pageSize)
        throws Exception
    {
        WrongBook wrongBook = wrongBookDao.get(userId, courseId);
        int startIndex = (pageIndex - 1) * pageSize;
        List<WrongQuestion> wrongQuestions = wrongBook.getWrongQuestions();
        wrongQuestions = wrongQuestions.stream().sorted((o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime())).collect(Collectors.toList());
        wrongQuestions = ListHelper.removeRepeat(wrongQuestions, (o) -> o.getQuestionId());
        List<WrongBookItemModule> wrongBookItemModules = new ArrayList<WrongBookItemModule>();
        List<QuestionCategory> questionCategories = wcfService.getAllQuestionCategories();
        wrongQuestions = wrongQuestions.stream().skip(startIndex).limit(pageSize).collect(Collectors.toList());
        List<Integer> questionIds = wrongQuestions.stream().map(o->o.getQuestionId()).collect(Collectors.toList());
        List<Question> questions = wcfService.getQuestions(questionIds);
        for (int i = 0; i < wrongQuestions.size(); i++ )
        {
            WrongBookItemModule wrongBookItemModule = new WrongBookItemModule();
            WrongQuestion wrongQuestion = wrongQuestions.get(i);
            Question question = questions.stream().filter(q -> q.getQuestionId() == wrongQuestion.getQuestionId()).collect(Collectors.toList()).get(0);
            String questionCategoryName = questionCategories.stream().filter(o -> o.getQuestionCategoryId() == question.getQuestionCategoryId()).collect(Collectors.toList()).get(
                0).getQuestionCategoryName();
            wrongBookItemModule.setQuestionCategoryName(questionCategoryName);
            String contentString = question.getQuestionContentForDisplay().getValue().replaceAll("<img[^>]*/>", "[图片]");
            wrongBookItemModule.setQuestionContent(contentString);
            wrongBookItemModule.setQuestionId(question.getQuestionId());
            Date createTime = wrongQuestion.getCreateTime();
            String yyyyMMdd = DateUtil.getTimeShortName(createTime);
            wrongBookItemModule.setTime(yyyyMMdd + DateUtil.format(createTime, "HH:mm"));
            wrongBookItemModules.add(wrongBookItemModule);
        }
        return wrongBookItemModules;
    }

    /**
     * 获取错题本详情，返回给Controller层
     *
     * @param userId
     * @param courseId
     * @param questionId
     * @return
     */
    public ExamPaperAnalysisModule getWrongBookDetail(int userId, int courseId, int questionId)
        throws Exception
    {
        ExamPaperAnalysisModule examPaperAnalysisModule = new ExamPaperAnalysisModule();
        WrongBook wrongBook = wrongBookDao.get(userId, courseId);
        Question question = wcfService.getQuestionById(questionId);
        QuestionCategoryModel questionCategoryModel = questionService.installQuestionCategory(question.getQuestionCategoryId());
        // 错题本的所有题目，并去重，倒序
        List<WrongQuestion> wrongQuestions = wrongBook.getWrongQuestions();
        wrongQuestions = wrongQuestions.stream().sorted((o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime())).collect(Collectors.toList());
        wrongQuestions = ListHelper.removeRepeat(wrongQuestions, (o) -> o.getQuestionId());
        int currentIndex = 0;
        for (int i = 0; i < wrongQuestions.size(); i++ )
        {
            if (questionId == wrongQuestions.get(i).getQuestionId())
            {
                currentIndex = i;
            }
        }
        int preQuestionId = 0;
        int nextQuestionId = 0;
        // 上一题和下一题
        if (currentIndex > 0)
        {
            preQuestionId = wrongQuestions.get(currentIndex - 1).getQuestionId();
        }
        if (currentIndex < wrongQuestions.size() - 1)
        {
            nextQuestionId = wrongQuestions.get(currentIndex + 1).getQuestionId();
        }
        examPaperAnalysisModule.setPreviousQuestionId(preQuestionId);
        examPaperAnalysisModule.setNextQuestionId(nextQuestionId);
        QuestionData questionData = getQuestionData(currentIndex, wrongBook, question);
        questionData.setQuestionCategory(questionCategoryModel);
        examPaperAnalysisModule.setQuestionInfo(questionData);
        return examPaperAnalysisModule;
    }

    /**
     * 组织题目数据
     *
     * @param currentIndex
     * @param wrongBook
     * @param question
     * @return
     */
    public QuestionData getQuestionData(int currentIndex, WrongBook wrongBook, Question question)
    {
        QuestionData questionData = new QuestionData();
        questionData.setQuestionContent(question.getQuestionContentForDisplay().getValue());
        questionData.setOrderIndex(currentIndex + 1);
        questionData.setQuestionAnalysis(question.getAnalysis().getValue());
        questionData.setQuestionDisplayTypeId(question.getQuestionDisplayTypeId());
        questionData.setQuestionId(question.getQuestionId());
        WrongQuestion wrongQuestion = null;
        try
        {
            wrongQuestion = wrongBook.getWrongQuestions().stream().filter((o) -> o.getQuestionId() - question.getQuestionId() == 0).collect(Collectors.toList()).get(0);
        }
        catch (Exception e)
        {
            log.error("在错题本中未找到该题目questionId" + question.getQuestionId(), e);
        }
        List<OptionGroupResult> optionGroupResults = wrongQuestion.getGradingResult();
        List<StudentGroupAnswer> studentGroupAnswers = wrongQuestion.getStudentGroupAnswers();
        List<SubQuestionInfo> subQuestionInfos = questionService.fitQuestionGroups(question, optionGroupResults, studentGroupAnswers);
        questionData.setQuestionGroups(subQuestionInfos);
        return questionData;
    }

    /**
     * 删除错题本错题
     *
     * @param userId
     * @param courseId
     * @param questionId
     * @return
     */
    public boolean deleteWrongQuestion(int userId, int courseId, int questionId)
    {
        boolean result = false;
        WrongBook wrongBook = wrongBookDao.get(userId, courseId);
        List<WrongQuestion> wrongQuestions = wrongBook.getWrongQuestions();
        wrongQuestions.forEach(o -> {
            if (o.getQuestionId() == questionId)
            {
                o.setStatusFlag(0);
            }
        });
        try
        {
            CouchBaseFactory.update(wrongBook);
            result = true;
        }
        catch (Exception e)
        {
            log.error("更新WrongBook缓存异常userId" + userId + "courseId" + courseId + "questionId" + questionId, e);
        }
        return result;
    }
}
