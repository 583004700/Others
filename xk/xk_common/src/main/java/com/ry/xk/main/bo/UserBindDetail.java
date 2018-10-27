package com.ry.xk.main.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息类
 * 
 * @ClassName: User
 * @author 幸仁强
 * @date 2018年5月28日
 */
public class UserBindDetail implements Serializable
{
    private static final long serialVersionUID = 1L;

    // 用户ID
    private int userId;

    // OpenID
    private String bindContent;

    // 绑定类型  1微信
    private int bindTypeId;

    // 状态，1有效，0失效
    private int statusFlag;

    // 创建时间
    private Date createDateTime;

    // 更新时间
    private Date updateDateTime;

    public int getUserId()
    {
    
        return userId;
    }

    public void setUserId(int userId)
    {
    
        this.userId = userId;
    }

    public String getBindContent()
    {
    
        return bindContent;
    }

    public void setBindContent(String bindContent)
    {
    
        this.bindContent = bindContent;
    }

    public int getBindTypeId()
    {
    
        return bindTypeId;
    }

    public void setBindTypeId(int bindTypeId)
    {
    
        this.bindTypeId = bindTypeId;
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
