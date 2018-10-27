package com.ry.xk.studentexamresult.bo;

import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

import java.util.Date;
import java.util.List;

/**
 * 试卷实体类，对应缓存和表结构
 */
public class ExamPaper implements ICouchBaseStoredObject
{
    // 试卷ID
    @Tag(1)
    private int examPaperId;

    // 试卷名称
    @Tag(2)
    private String examPaperName;

    // 学科ID
    @Tag(3)
    private int courseId;

    // 使用年份
    @Tag(4)
    private int useYear;

    // 考试方式 1闭卷 2开卷
    @Tag(5)
    private int examType;

    // 试卷封面
    @Tag(6)
    private String examPaperCoverPath;

    // 考试时间(分钟)
    @Tag(7)
    private int examTime;

    // 过期时间
    @Tag(8)
    private Date expireTime;

    // 价格,保留两位小数
    @Tag(9)
    private float price;

    // 是否免费 1免费
    @Tag(10)
    private int isFree;

    // 排序
    @Tag(11)
    private int orderIndex;

    // 试卷组成
    @Tag(12)
    private String examConstitute;

    // 试卷提供方
    @Tag(13)
    private String provider;

    // 机构ID
    @Tag(14)
    private int partnerId;

    // 有效状态 1有效 0无效
    @Tag(15)
    private int statusFlag;

    // 创建时间
    @Tag(16)
    private Date createDateTime;

    // 更新时间
    @Tag(17)
    private Date updateDateTime;

    // 是否套卷 1是 0否
    @Tag(18)
    private int isPack;

    // 题目集合
    @Tag(19)
    private List<ExamPaperQuestion> exampaperquestion;

    public int getExamPaperId()
    {
        return examPaperId;
    }

    public void setExamPaperId(int examPaperId)
    {
        this.examPaperId = examPaperId;
    }

    public String getExamPaperName()
    {
        return examPaperName;
    }

    public void setExamPaperName(String examPaperName)
    {
        this.examPaperName = examPaperName;
    }

    public int getCourseId()
    {
        return courseId;
    }

    public void setCourseId(int courseId)
    {
        this.courseId = courseId;
    }

    public int getUseYear()
    {
        return useYear;
    }

    public void setUseYear(int useYear)
    {
        this.useYear = useYear;
    }

    public int getExamType()
    {
        return examType;
    }

    public void setExamType(int examType)
    {
        this.examType = examType;
    }

    public String getExamPaperCoverPath()
    {
        return examPaperCoverPath;
    }

    public void setExamPaperCoverPath(String examPaperCoverPath)
    {
        this.examPaperCoverPath = examPaperCoverPath;
    }

    public int getExamTime()
    {
        return examTime;
    }

    public void setExamTime(int examTime)
    {
        this.examTime = examTime;
    }

    public Date getExpireTime()
    {
        return expireTime;
    }

    public void setExpireTime(Date expireTime)
    {
        this.expireTime = expireTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIsFree()
    {
        return isFree;
    }

    public void setIsFree(int isFree)
    {
        this.isFree = isFree;
    }

    public int getOrderIndex()
    {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex)
    {
        this.orderIndex = orderIndex;
    }

    public String getExamConstitute()
    {
        return examConstitute;
    }

    public void setExamConstitute(String examConstitute)
    {
        this.examConstitute = examConstitute;
    }

    public String getProvider()
    {
        return provider;
    }

    public void setProvider(String provider)
    {
        this.provider = provider;
    }

    public int getStatusFlag()
    {
        return statusFlag;
    }

    public void setStatusFlag(int statusFlag)
    {
        this.statusFlag = statusFlag;
    }

    public Date getCreateDateTime()
    {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime)
    {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime()
    {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime)
    {
        this.updateDateTime = updateDateTime;
    }

    public int getIsPack()
    {
        return isPack;
    }

    public void setIsPack(int isPack)
    {
        this.isPack = isPack;
    }

    public List<ExamPaperQuestion> getExampaperquestion()
    {
        return exampaperquestion;
    }

    public void setExampaperquestion(List<ExamPaperQuestion> exampaperquestion)
    {
        this.exampaperquestion = exampaperquestion;
    }

    private static String _key = "ExamPaper_%s";

    @Override
    public String key()
    {
        return String.format(keyFormat(), examPaperId);
    }

    @Override
    public String keyFormat()
    {
        return _key;
    }

    @Override
    public CouchBaseSectionType couchbaseSection()
    {
        return CouchBaseSectionType.EXAMRESULT;
    }
}
