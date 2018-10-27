package com.ry.xk.response.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 获取试卷详情每个试卷 <描述类的作用>
 * 
 * @ClassName: Paper
 * @author DELL
 * @date 2018年5月22日
 */
public class ExamPaper
{
    /**
     * 试卷ID
     */
    private String examPaperId;

    /**
     * 试卷封面
     */
    private String examPaperCoverPath;

    /**
     * 试卷名称
     */
    private String examPaperName;

    /**
     * 试卷状态
     */
    private int status;

    /**
     * 试卷价格
     */
    private String price;

    /**
     * 是否免费
     */
    private boolean isFree;

    /**
     * 试卷得分
     */
    private double score;

    /**
     * 答题情况
     */
    private String answerSituation;

    /**
     * 测试ID
     */
    private String steId;

    public String getExamPaperId() {
        return examPaperId;
    }

    public void setExamPaperId(String examPaperId) {
        this.examPaperId = examPaperId;
    }

    public String getExamPaperCoverPath()
    {

        return examPaperCoverPath;
    }

    public void setExamPaperCoverPath(String examPaperCoverPath)
    {

        this.examPaperCoverPath = examPaperCoverPath;
    }

    public String getExamPaperName()
    {

        return examPaperName;
    }

    public void setExamPaperName(String examPaperName)
    {

        this.examPaperName = examPaperName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty(value = "isFree")
    public boolean getIsFree()
    {
        return isFree;
    }

    public void setIsFree(boolean isFree)
    {

        this.isFree = isFree;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAnswerSituation()
    {

        return answerSituation;
    }

    public void setAnswerSituation(String answerSituation)
    {

        this.answerSituation = answerSituation;
    }

    public String getSteId()
    {

        return steId;
    }

    public void setSteId(String steId)
    {

        this.steId = steId;
    }

}
