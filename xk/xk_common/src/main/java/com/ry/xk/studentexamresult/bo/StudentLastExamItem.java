package com.ry.xk.studentexamresult.bo;

import io.protostuff.Tag;

import java.util.Date;

/**
 * 用户做题信息，（StudentExamList专用）
 */
public class StudentLastExamItem
{
    // 用户ID
    @Tag(1)
    private int userId;

    // 试卷ID
    @Tag(2)
    private int examPaperId;

    // 测试ID
    @Tag(3)
    private long studentExamId;

    // 创建时间
    @Tag(4)
    private Date createDateTime;

    // 结束时间
    @Tag(5)
    private Date endDateTime;

    // 是否生成测评
    @Tag(6)
    private boolean isGenerateEvaluation;

    //对应试卷状态
    @Tag(7)
    private int status;

    /**
     * 无参构造方法
     */
    public StudentLastExamItem(){}

    /**
     * 设置所有属性
     * @param userId
     * @param examPaperId
     * @param studentExamId
     * @param createDateTime
     * @param endDateTime
     * @param isGenerateEvaluation
     * @param status
     */
    public void setAllAttribute(int userId, int examPaperId, long studentExamId, Date createDateTime, Date endDateTime, boolean isGenerateEvaluation, int status) {
        this.userId = userId;
        this.examPaperId = examPaperId;
        this.studentExamId = studentExamId;
        this.createDateTime = createDateTime;
        this.endDateTime = endDateTime;
        this.isGenerateEvaluation = isGenerateEvaluation;
        this.status = status;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getExamPaperId()
    {

        return examPaperId;
    }

    public void setExamPaperId(int examPaperId)
    {

        this.examPaperId = examPaperId;
    }

    public long getStudentExamId()
    {

        return studentExamId;
    }

    public void setStudentExamId(long studentExamId)
    {

        this.studentExamId = studentExamId;
    }

    public Date getCreateDateTime()
    {

        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime)
    {

        this.createDateTime = createDateTime;
    }

    public Date getEndDateTime()
    {

        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime)
    {

        this.endDateTime = endDateTime;
    }

    public boolean getIsGenerateEvaluation()
    {

        return isGenerateEvaluation;
    }

    public void setIsGenerateEvaluation(boolean isGenerateEvaluation)
    {

        this.isGenerateEvaluation = isGenerateEvaluation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
