package com.ry.xk.studentexamresult.bo;

import java.util.Date;
import java.util.List;

import io.protostuff.Tag;

/**
 * 存储学生答题的信息
 * 
 * @ClassName: StudentQuestion
 * @author 幸仁强
 * @date 2018年5月30日
 */

public class StudentQuestion
{
    // 默认的IRT猜测系数
    public static final double Default_GuessingParameter = 0.1;

    // 如果做题时间小于3秒，进行猜测系数惩罚
    public static final double Less_Than_3_Seconds_GuessingParameter = 0.30;

    // 题目ID
    @Tag(1)
    private int questionId;

    // 难度
    @Tag(2)
    private int questionLevel;

    // 是否正确 0/1
    @Tag(3)
    private boolean isCorrect;

    // 因为小题的问题，所以得分有可能以 0.9， 0.7出现
    @Tag(4)
    private double score;

    // 预估好学生做题时间 - 秒
    @Tag(5)
    private double estimateTimeTaken;

    // 真正做题时间 - 秒
    @Tag(6)
    private double realTimeTaken;

    // 做题完成提交时间
    @Tag(7)
    private Date completeTime;

    // 学生提交的答案
    @Tag(8)
    private String studentAnswer;

    // 主知识点
    @Tag(9)
    private int mainKnowledgePoint;

    // 次知识点
    @Tag(10)
    private int[] otherKnowledgePoints;

    // 方法
    @Tag(11)
    private int[] solvingMethods;

    // 能力
    @Tag(12)
    private int[] capabilities;

    // 章节所属ID
    @Tag(13)
    private int sectionId;

    // 主章的ID 得分计算的SectionId
    @Tag(14)
    private int rootSectionId;

    // 题目是否是线下题目,默认为否
    @Tag(15)
    private boolean isOffline;

    // 这道题目的分值
    @Tag(16)
    private double baseScore;

    // 是否进行了判卷, false表示进行了判卷，true表示未进行判卷
    @Tag(17)
    private boolean notSupportCorrect;

    // 做题使用的题目展示方式,分为客观题、主观题和0， 默认为1
    @Tag(18)
    private byte questionDoingType;

    // 学生提交的各小题答案,注意Get方法改为使用GetStudentGroupAnswers
    @Tag(19)
    private List<StudentGroupAnswer> studentGroupAnswers;

    // 学生提交的各小题答案，当做题方式为Unknow时，根据question校验题目是否主观题进行判断是否分割StudentAnswer
    @Tag(20)
    private List<OptionGroupResult> questionOptionGroupResult;

    // 学生作答判卷结果
    // 新增字段，历史数据不存在此字段，所以QuestionOptionGroupResult_get()不一定有值
    // 不要使用QuestionOptionGroupResult_get()获取对象，使用GetQuestionOptionGroupResult(Question question)方法
    @Tag(21)
    private int[] mainKnowledgePoints;

    @Tag(22)
    private int courseMappingId;

    public int getQuestionId()
    {

        return questionId;
    }

    public void setQuestionId(int questionId)
    {

        this.questionId = questionId;
    }

    public int getQuestionLevel()
    {

        return questionLevel;
    }

    public void setQuestionLevel(int questionLevel)
    {

        this.questionLevel = questionLevel;
    }

    public boolean getIsCorrect()
    {

        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect)
    {

        this.isCorrect = isCorrect;
    }

    public double getScore()
    {

        return score;
    }

    public void setScore(double score)
    {

        this.score = score;
    }

    public double getEstimateTimeTaken()
    {

        return estimateTimeTaken;
    }

    public void setEstimateTimeTaken(double estimateTimeTaken)
    {

        this.estimateTimeTaken = estimateTimeTaken;
    }

    public double getRealTimeTaken()
    {

        return realTimeTaken;
    }

    public void setRealTimeTaken(double realTimeTaken)
    {

        this.realTimeTaken = realTimeTaken;
    }

    public Date getCompleteTime()
    {

        return completeTime;
    }

    public void setCompleteTime(Date completeTime)
    {

        this.completeTime = completeTime;
    }

    public String getStudentAnswer()
    {

        return studentAnswer;
    }

    public void setStudentAnswer(String studentAnswer)
    {

        this.studentAnswer = studentAnswer;
    }

    public int getMainKnowledgePoint()
    {

        return mainKnowledgePoint;
    }

    public void setMainKnowledgePoint(int mainKnowledgePoint)
    {

        this.mainKnowledgePoint = mainKnowledgePoint;
    }

    public int[] getOtherKnowledgePoints()
    {

        return otherKnowledgePoints;
    }

    public void setOtherKnowledgePoints(int[] otherKnowledgePoints)
    {

        this.otherKnowledgePoints = otherKnowledgePoints;
    }

    public int[] getSolvingMethods()
    {

        return solvingMethods;
    }

    public void setSolvingMethods(int[] solvingMethods)
    {

        this.solvingMethods = solvingMethods;
    }

    public int[] getCapabilities()
    {

        return capabilities;
    }

    public void setCapabilities(int[] capabilities)
    {

        this.capabilities = capabilities;
    }

    public int getSectionId()
    {

        return sectionId;
    }

    public void setSectionId(int sectionId)
    {

        this.sectionId = sectionId;
    }

    public int getRootSectionId()
    {

        return rootSectionId;
    }

    public void setRootSectionId(int rootSectionId)
    {

        this.rootSectionId = rootSectionId;
    }

    public boolean getIsOffline()
    {

        return isOffline;
    }

    public void setIsOffline(boolean isOffline)
    {

        this.isOffline = isOffline;
    }

    public boolean getNotSupportCorrect()
    {

        return notSupportCorrect;
    }

    public void setNotSupportCorrect(boolean notSupportCorrect)
    {

        this.notSupportCorrect = notSupportCorrect;
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

    public List<OptionGroupResult> getQuestionOptionGroupResult()
    {

        return questionOptionGroupResult;
    }

    public void setQuestionOptionGroupResult(List<OptionGroupResult> questionOptionGroupResult)
    {

        this.questionOptionGroupResult = questionOptionGroupResult;
    }

    public int[] getMainKnowledgePoints()
    {

        return mainKnowledgePoints;
    }

    public void setMainKnowledgePoints(int[] mainKnowledgePoints)
    {

        this.mainKnowledgePoints = mainKnowledgePoints;
    }

    public void setBaseScore(double baseScore)
    {

        this.baseScore = baseScore;
    }

    public double getBaseScore()
    {
        if (baseScore == 0) return 1.0;
        return baseScore;
    }

    public int getCourseMappingId()
    {

        return courseMappingId;
    }

    public void setCourseMappingId(int courseMappingId)
    {

        this.courseMappingId = courseMappingId;
    }

    public boolean isWrong()
    {
        return !notSupportCorrect && !isCorrect;
    }

    public boolean isIncludeAnalysis()
    {
        return !notSupportCorrect;
    }

}
