package com.ry.xk.studentexamresult.bo;

import io.protostuff.Tag;

/**
 * 测评实体类
 * 
 * @ClassName: XkExamReviewSummaryView
 * @author 幸仁强
 * @date 2018年6月1日
 */

public class ExamReviewSummaryView
{
    // 知识点Id
    @Tag(1)
    private int knowledgePointId;

    // 知识点名称
    @Tag(2)
    private String knowledgePointName;

    // 学生正确率（掌握度）
    @Tag(3)
    private int studentAccuracy;

    public int getKnowledgePointId()
    {

        return knowledgePointId;
    }

    public void setKnowledgePointId(int knowledgePointId)
    {

        this.knowledgePointId = knowledgePointId;
    }

    public String getKnowledgePointName()
    {

        return knowledgePointName;
    }

    public void setKnowledgePointName(String knowledgePointName)
    {

        this.knowledgePointName = knowledgePointName;
    }

    public double getStudentAccuracy()
    {

        return studentAccuracy;
    }

    public void setStudentAccuracy(int studentAccuracy)
    {

        this.studentAccuracy = studentAccuracy;
    }

    public ExamReviewSummaryView()
    {}

    public ExamReviewSummaryView(int knowledgePointId, String knowledgePointName, int studentAccuracy)
    {
        this.knowledgePointId = knowledgePointId;
        this.knowledgePointName = knowledgePointName;
        this.studentAccuracy = studentAccuracy;
    }

}
