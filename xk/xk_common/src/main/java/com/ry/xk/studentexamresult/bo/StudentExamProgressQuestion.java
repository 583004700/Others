package com.ry.xk.studentexamresult.bo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import io.protostuff.Tag;

/**
 * 做题临时缓存题目信息
 * @ClassName: StudentExamProgressQuestion
 * @author 幸仁强
 * @date 2018年6月4日
 */
public class StudentExamProgressQuestion
{
    // 题目信息
    @Tag(1)
    public ExamSetQuestion examSetQuestion;

    // 题目顺序
    @Tag(2)
    public int questionIndex;

    /// 题目答案，按\t分割，如：\t\tA\tB\t
    @Tag(3)
    public String studentAnswer;

    // 所花费的时间
    @Tag(4)
    public double timeTaken;

    // 题目id
    @Tag(5)
    public int questionId;

    // 做题使用的题目展示方式,分为1客观题、2主观题和0
    @Tag(6)
    public byte questionDoingType;

    // 学生提交的各小题答案
    @Tag(7)
    public List<StudentGroupAnswer> studentGroupAnswers;

    // 临时判卷结果
    @Tag(8)
    public List<OptionGroupResult> gradingResult;

    public ExamSetQuestion getExamSetQuestion()
    {

        return examSetQuestion;
    }

    public void setExamSetQuestion(ExamSetQuestion examSetQuestion)
    {

        this.examSetQuestion = examSetQuestion;
    }

    public int getQuestionIndex()
    {

        return questionIndex;
    }

    public void setQuestionIndex(int questionIndex)
    {

        this.questionIndex = questionIndex;
    }

    public String getStudentAnswer()
    {

        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer)
    {

        this.studentAnswer = studentAnswer;
    }

    public double getTimeTaken()
    {

        return timeTaken;
    }

    public void setTimeTaken(double timeTaken)
    {

        this.timeTaken = timeTaken;
    }

    public int getQuestionId()
    {

        return questionId;
    }

    public void setQuestionId(int questionId)
    {

        this.questionId = questionId;
    }

    public byte getQuestionDoingType()
    {

        return questionDoingType;
    }

    public void setQuestionDoingType(byte questionDoingType)
    {

        this.questionDoingType = questionDoingType;
    }

    public List<StudentGroupAnswer> getStudentGroupAnswers()
    {

        return studentGroupAnswers;
    }

    public void setStudentGroupAnswers(List<StudentGroupAnswer> studentGroupAnswers)
    {

        this.studentGroupAnswers = studentGroupAnswers;
    }

    public List<OptionGroupResult> getGradingResult()
    {

        return gradingResult;
    }

    public void setGradingResult(List<OptionGroupResult> gradingResult)
    {

        this.gradingResult = gradingResult;
    }

    public String[] studentAnswerList()
    {
        if (StringUtils.isNotBlank(studentAnswer))
        {
            return studentAnswer.split(studentAnswer, '\t');
        }
        return null;
    }

    public boolean isAnswer()
    {
        if (studentGroupAnswers == null || studentGroupAnswers.size() == 0)
        {
            return false;
        }

        return null != studentGroupAnswers.stream().filter(p -> StringUtils.isNotBlank(p.getAnswer())).findFirst().orElse(null);
    }

    public StudentExamProgressQuestion()
    {}

    public StudentExamProgressQuestion(ExamSetQuestion examSetQuestion, int questionIndex, double timeTaken, int questionId, byte questionDoingType)
    {
        this.examSetQuestion = examSetQuestion;
        this.questionIndex = questionIndex;
        this.timeTaken = timeTaken;
        this.questionId = questionId;
        this.questionDoingType = questionDoingType;
    }
}
