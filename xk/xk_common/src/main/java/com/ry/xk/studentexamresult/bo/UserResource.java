package com.ry.xk.studentexamresult.bo;

import java.util.Date;

import io.protostuff.Tag;

/**
 * 用户资源表结构对应的实体类
 */
public class UserResource
{
    // 用户ID
    @Tag(1)
    private int userId;

    // 资源类型ID
    @Tag(2)
    private int resourceTypeId;

    // 资源ID，当前只有试卷ID
    @Tag(3)
    private int resourceId;

    // 购买时间
    @Tag(4)
    private Date buyingDateTime;

    // 资源来源
    @Tag(5)
    private int sourceTypeId;

    // 绑定状态
    @Tag(6)
    private int statusFlag;

    // 创建时间
    @Tag(7)
    private Date createDateTime;

    // 更新时间
    @Tag(8)
    private Date updateDateTime;

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getResourceTypeId()
    {
        return resourceTypeId;
    }

    public void setResourceTypeId(int resourceTypeId)
    {
        this.resourceTypeId = resourceTypeId;
    }

    public int getResourceId()
    {
        return resourceId;
    }

    public void setResourceId(int resourceId)
    {
        this.resourceId = resourceId;
    }

    public Date getBuyingDateTime()
    {
        return buyingDateTime;
    }

    public void setBuyingDateTime(Date buyingDateTime)
    {
        this.buyingDateTime = buyingDateTime;
    }

    public int getSourceTypeId()
    {
        return sourceTypeId;
    }

    public void setSourceTypeId(int sourceTypeId)
    {
        this.sourceTypeId = sourceTypeId;
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
}
