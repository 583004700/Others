package com.ry.xk.response.bo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 试卷详情的输出参数实体类 <描述类的作用>
 * 
 * @ClassName: PaperDetailModule
 * @author DELL
 * @date 2018年5月22日
 */
public class ExamPaperDetailModule
{
    /**
     * 试卷封面
     */
    private String examPaperCoverPath;

    /**
     * 试卷名称
     */
    private String examPaperName;

    /**
     * 适用年份
     */
    private String useYear;

    /**
     * 提供方
     */
    private String provider;

    /**
     * 试卷价格
     */
    private String price;

    /**
     * 是否免费
     */
    private boolean isFree;

    /**
     * 考试方式
     */
    private String examMethod;

    /**
     * 考试时间,分钟
     */
    private int examTime;

    /**
     * 试卷组成
     */
    private String build;

    /**
     * 过期时间
     */
    private String expDate;

    /**
     * 试卷状态
     */
    private int status;

    private String steId;

    private double score;

    /**
     * 答题情况
     */
    private String answerSituation;

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

    public String getUseYear()
    {

        return useYear;
    }

    public void setUseYear(String useYear)
    {

        this.useYear = useYear;
    }

    public String getProvider()
    {

        return provider;
    }

    public void setProvider(String provider)
    {

        this.provider = provider;
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

    public String getExamMethod()
    {

        return examMethod;
    }

    public void setExamMethod(String examMethod)
    {

        this.examMethod = examMethod;
    }

    public int getExamTime()
    {

        return examTime;
    }

    public void setExamTime(int examTime)
    {

        this.examTime = examTime;
    }

    public String getBuild()
    {

        return build;
    }

    public void setBuild(String build)
    {

        this.build = build;
    }

    public String getExpDate()
    {

        return expDate;
    }

    public void setExpDate(String expDate)
    {

        this.expDate = expDate;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
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

    public double getScore()
    {
    
        return score;
    }

    public void setScore(double score)
    {
    
        this.score = score;
    }
    
    

}
