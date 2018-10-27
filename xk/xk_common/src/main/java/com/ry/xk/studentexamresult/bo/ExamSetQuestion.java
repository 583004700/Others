package com.ry.xk.studentexamresult.bo;

import com.ry.xk.utils.ToggleQuestionInterface;
import io.protostuff.Tag;

/**
 * <描述类的作用>
 * 
 * @ClassName: ExamSetQuestion
 * @author 幸仁强
 * @date 2018年5月30日
 */

public class ExamSetQuestion implements ToggleQuestionInterface
{
    // 题集ID
    @Tag(1)
    private int examSetId;

    // 题目ID
    @Tag(2)
    private int questionId;

    // 章节ID
    @Tag(3)
    private int sectionId;

    // 题目分数
    @Tag(4)
    private double questionScore;

    // 题目排序
    @Tag(5)
    private int orderIndex;

    // 教材版本号
    @Tag(6)
    private int bookVersionId;

    // 知识点ID
    @Tag(7)
    private int knowledgePointId;

    public int getExamSetId()
    {

        return examSetId;
    }

    public void setExamSetId(int examSetId)
    {

        this.examSetId = examSetId;
    }

    public int getQuestionId()
    {

        return questionId;
    }

    public void setQuestionId(int questionId)
    {

        this.questionId = questionId;
    }

    public int getSectionId()
    {

        return sectionId;
    }

    public void setSectionId(int sectionId)
    {

        this.sectionId = sectionId;
    }

    public double getQuestionScore()
    {

        return questionScore;
    }

    public void setQuestionScore(double questionScore)
    {

        this.questionScore = questionScore;
    }

    public int getOrderIndex()
    {

        return orderIndex;
    }

    public void setOrderIndex(int orderIndex)
    {

        this.orderIndex = orderIndex;
    }

    public int getBookVersionId()
    {

        return bookVersionId;
    }

    public void setBookVersionId(int bookVersionId)
    {

        this.bookVersionId = bookVersionId;
    }

    public int getKnowledgePointId()
    {

        return knowledgePointId;
    }

    public void setKnowledgePointId(int knowledgePointId)
    {

        this.knowledgePointId = knowledgePointId;
    }

    public ExamSetQuestion()
    {}

    public ExamSetQuestion(int examSetId, int questionId, double questionScore, int orderIndex)
    {
        this.examSetId = examSetId;
        this.questionId = questionId;
        this.questionScore = questionScore;
        this.orderIndex = orderIndex;
    }

    @Override
    public int questionId() {
        return questionId;
    }
}
