package com.ry.xk.main.service;


import com.ry.xk.Application;
import com.ry.xk.main.bo.Course;
import com.ry.xk.main.bo.User;
import com.ry.xk.response.bo.CourseWrongCountModule;
import com.ry.xk.springbootframe.config.CommonConfig;
import com.ry.xk.studentexamresult.bo.WrongBook;
import com.ry.xk.studentexamresult.bo.WrongQuestion;
import com.ry.xk.studentexamresult.dao.IWrongBookDao;
import com.ry.xk.studentexamresult.service.IWrongBookService;
import com.ry.xk.utils.*;
import com.sun.javafx.binding.StringFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class WrongBookServiceTest
{
//    @Autowired
//    AsyncTest asyncTest;
//
//    int userId = 1;
//
//    int courseId = 1;
//
//    @Mock
//    ICourseService courseService;
//
//    @Mock
//    IWrongBookDao wrongBookDao;
//
//    @Autowired
//    @InjectMocks
//    IWrongBookService wrongBookService;
//
//    @Test
//    public void getCourseTypes()
//    {
//        int partnerId = 1;
//        int userId = 1;
//
//        Course course1 = new Course();
//        course1.setCourseId(1);
//        course1.setCourseTypeId(1);
//        course1.setCourseName("数学");
//
//        Course course2 = new Course();
//        course2.setCourseTypeId(1);
//        course2.setCourseId(2);
//        course2.setCourseName("英语");
//        List<Course> list = new ArrayList<Course>();
//        list.add(course1);
//        list.add(course2);
//
//        Mockito.when(courseService.getCourseByCourseType(partnerId, 1)).thenReturn(list);
//
//        Mockito.when(courseService.getById(partnerId, 1)).thenReturn(course1);
//        Mockito.when(courseService.getById(partnerId, 2)).thenReturn(course2);
//
//        WrongBook wrongBook = new WrongBook();
//        wrongBook.setUserId(userId);
//        wrongBook.setCourseId(1);
//        WrongQuestion wrongQuestion1 = new WrongQuestion();
//        WrongQuestion wrongQuestion2 = new WrongQuestion();
//        WrongQuestion wrongQuestion3 = new WrongQuestion();
//        List<WrongQuestion> wrongQuestions = new ArrayList<WrongQuestion>();
//        wrongQuestions.add(wrongQuestion1);
//        wrongQuestions.add(wrongQuestion2);
//        wrongQuestions.add(wrongQuestion3);
//        wrongBook.setWrongQuestions(wrongQuestions);
//
//        Mockito.when(wrongBookDao.get(userId, 1)).thenReturn(wrongBook);
//        Mockito.when(wrongBookDao.get(userId, 2)).thenReturn(wrongBook);
//
//        List<CourseWrongCountModule> courseWrongCountModules = wrongBookService.getCourseWrongCounts(partnerId, userId, 1);
//
//        courseWrongCountModules.forEach((o) -> System.out.println(o.getCourseId() + "-------" + o.getCourseName() + "------------" + o.getShortCode() + "----------" + o.getWrongCount()));
//
//    }
    @Test
    public void getWrongBookItemModules()
        throws Exception
    {
        // WrongBook wrongBook = ObjectFactory.getWrongBook();
        // Mockito.when(wrongBookDao.get(userId,courseId)).thenReturn(wrongBook);
        // List<WrongBookItemModule> wrongBookItemModules =
        // wrongBookService.getWrongBookItemModules(userId,courseId,1,10);
        // System.out.println(wrongBookItemModules.size());
//        System.out.println(DateUtil.getTimeShortName(DateUtil.parse("2018-6-7", "yyyy-MM-dd")));
//
//        List<User> users = new ArrayList<User>();
//        User user1 = new User();
//        user1.setUserId(100);
//        user1.setUserName("小红");
//        user1.setPartnerId(1);
//
//        User user2 = new User();
//        user2.setUserId(200);
//        user2.setUserName("小红");
//        user2.setPartnerId(2);
//
//        User user3 = new User();
//        user3.setUserId(200);
//        user3.setUserName("小明");
//        user3.setPartnerId(3);
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        List<User> l = ListHelper.removeRepeat(users, (o) -> o.getUserId()).stream().sorted((o1, o2) -> o2.getPartnerId() - o1.getPartnerId()).collect(Collectors.toList());
//        l.forEach(o -> {
//            System.out.println(o.getPartnerId());
//        });
//
//        List<User> l2 = ListHelper.removeRepeat(users.stream().sorted((o1, o2) -> o2.getPartnerId() - o1.getPartnerId()).collect(Collectors.toList()), (o) -> o.getUserId());
//        l2.forEach(o -> {
//            System.out.println(o.getPartnerId());
//        });
//
//        List<User> l3 = ListHelper.removeRepeat(users, (o) -> o.getUserName());
//        l3.forEach(o -> {
//            System.out.println(o.getUserName());
//        });
//
//
//        //new Thread(()->say()).start();
//        asyncTest.say();
//        for(int i=0;i<100000;i++){
//            System.out.println("主线程");
//        }
//
//       System.out.println(UrlUtil.idEncrypt(23));
//        System.out.println(UrlUtil.idEncrypt(200160));
//
//        String s = new DecimalFormat("#.00").format(31545.1);
//        System.out.println(s);
//
//        int userId = JwtHelper.getUserId("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjI1LCJleHAiOjE1NjA0OTEwMTEsIm5iZiI6MTUyODk1NTAxMX0.fZH3lSqqPRbomnfnYZ5dRVg3pbaG0cE4s1ovZJefTQg");
//        System.out.println("userId=========="+userId);
//
//        System.out.println(MessageFormat.format("'{'\"touser\":\"{0}\",\"template_id\":\"{1}\",\"url\":\"{2}\",\"data\":'{'\"first\":'{'\"value\":\"{3}\",\"color\":\"{4}\"'}',\"keyword1\":'{'\"value\":\"{5}\",\"color\":\"{6}\"'}',\"keyword2\":'{'\"value\":\"{7}\",\"color\":\"{8}\"'}',\"keyword3\":'{'\"value\":\"{9}\",\"color\":\"{10}\"'}',\"keyword4\":'{'\"value\":\"{11}\",\"color\":\"{12}\"'}',\"remark\":'{'\"value\":\"{13}\",\"color\":\"{14}\"'}''}''}'",
//                "0","1","2","3","4","5","6","7","8","9","10","11","12","13","14"));
//
        System.out.println("----------------"+new DecimalFormat("0.00").format(0));
//
//        List<Integer> l = new ArrayList<Integer>();
//        System.out.println(l.stream().findFirst());

            List<Question> questions = new ArrayList<Question>();
            Question question1 = new Question();
            question1.setQuestionId(1);
            question1.setQuestionName("题目1");

            Question question2 = new Question();
            question2.setQuestionId(2);
            question2.setQuestionName("题目2");

            Question question3 = new Question();
            question3.setQuestionId(3);
            question3.setQuestionName("题目3");

            Question question4 = new Question();
            question4.setQuestionId(4);
            question4.setQuestionName("题目4");

            questions.add(question1);
            questions.add(question2);
            questions.add(question3);
            questions.add(question4);
            //获取question1的下一题
            ToggleQuestion<Question> toggleQuestion = new ToggleQuestion<>(questions);
            System.out.println(toggleQuestion.getNextQuestion(question1).getQuestionId());
            System.out.println(toggleQuestion.getPreviousQuestion(question1));
            System.out.println(toggleQuestion.getNextQuestion(question4));

        System.out.println(toggleQuestion.getPreviousQuestion(question3).getQuestionId());
        System.out.println(toggleQuestion.getNextQuestion(question3).getQuestionId());

        System.out.println("userId-----"+JwtHelper.getUserId("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjIzLCJleHAiOjE1NjAzOTM0NDgsIm5iZiI6MTUyODg1NzQ0OH0.39D8aGJwz6PEV7SKc0ltPsJKIjsSYcRq3Ymywrf8gO4"));
    }


}

class Question implements ToggleQuestionInterface{
    private int questionId;
    private String questionName;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    @Override
    public int questionId() {
        return questionId;
    }
}
