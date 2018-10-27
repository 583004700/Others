package com.ry.xk.main.bo;

import java.util.Date;

import io.protostuff.Tag;

/**
 * 机构学科映射
 */
public class PartnerCourseMapping
{
    /**
     * partnerID
     */
    @Tag(1)
    private Integer partnerId;

    /**
     * 学科ID
     */
    @Tag(2)
    private Integer courseId;

    /**
     * 学段ID
     */
    @Tag(3)
    private Integer courseTypeId;

    /**
     * 有效状态
     */
    @Tag(4)
    private Integer statusFlag;

    /**
     * 创建时间
     */
    @Tag(5)
    private Date createDateTime;

    /**
     * 更新时间
     */
    @Tag(6)
    private Date updateDateTime;

    /**
     * 试卷打包价格
     * 
     * @return
     */
    @Tag(7)
    private float packagePrice;

    public Integer getPartnerId()
    {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId)
    {
        this.partnerId = partnerId;
    }

    public Integer getCourseId()
    {
        return courseId;
    }

    public void setCourseId(Integer courseId)
    {
        this.courseId = courseId;
    }

    public Integer getCourseTypeId()
    {
        return courseTypeId;
    }

    public void setCourseTypeId(Integer courseTypeId)
    {
        this.courseTypeId = courseTypeId;
    }

    public Integer getStatusFlag()
    {
        return statusFlag;
    }

    public void setStatusFlag(Integer statusFlag)
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

    public float getPackagePrice()
    {
        return packagePrice;
    }

    public void setPackagePrice(float packagePrice)
    {
        this.packagePrice = packagePrice;
    }
}
