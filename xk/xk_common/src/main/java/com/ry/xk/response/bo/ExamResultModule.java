package com.ry.xk.response.bo;

import java.util.ArrayList;
import java.util.List;

public class ExamResultModule
{
    /**
     * 本次测试得分
     */
    private double score;
    /**
     * 试卷ID
     */
    private String examPaperId;
    /**
     * 学科名称
     */
    private String courseName;
    /**
     * 学段名称
     */
    private String courseTypeName;
    /**
     * 通过率
     */
    private double passExamProbability;
    /**
     * 学段ID
     */
    private int courseTypeId;
    /**
     * 学科ID
     */
    private String courseId;
    /**
     * 知识点信息集合
     */
    private List<KnowledgePoint> KnowledgePointResults = new ArrayList<KnowledgePoint>();

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getPassExamProbability() {
        return passExamProbability;
    }

    public void setPassExamProbability(double passExamProbability) {
        this.passExamProbability = passExamProbability;
    }

    public int getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(int courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public List<KnowledgePoint> getKnowledgePointResults()
    {

        return KnowledgePointResults;
    }

    public void setKnowledgePointResults(List<KnowledgePoint> knowledgePointResults)
    {

        KnowledgePointResults = knowledgePointResults;
    }

    public String getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(String examPaperId) {
        this.examPaperId = examPaperId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }
}
