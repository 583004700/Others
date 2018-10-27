package com.ry.xk.main.bo;

import java.io.Serializable;
import java.util.Date;

import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 用户信息类
 * 
 * @ClassName: User
 * @author 幸仁强
 * @date 2018年5月28日
 */
public class User implements Serializable, ICouchBaseStoredObject
{
    private static final long serialVersionUID = 1L;

    // 用户ID
    @Tag(1)
    private int userId;

    // 用户类型
    @Tag(2)
    private int userTypeId;

    // 合作伙伴ID
    @Tag(3)
    private int partnerId;

    // 用户名 ，openId
    @Tag(4)
    private String userName;

    // 创建时间
    @Tag(5)
    private Date createDateTime;

    // 状态，1有效，0失效
    @Tag(6)
    private int statusFlag;

    public int getUserId()
    {

        return userId;
    }

    public void setUserId(int userId)
    {

        this.userId = userId;
    }

    public int getUserTypeId()
    {

        return userTypeId;
    }

    public void setUserTypeId(int userTypeId)
    {

        this.userTypeId = userTypeId;
    }

    public int getPartnerId()
    {

        return partnerId;
    }

    public void setPartnerId(int partnerId)
    {

        this.partnerId = partnerId;
    }

    public String getUserName()
    {

        return userName;
    }

    public void setUserName(String userName)
    {

        this.userName = userName;
    }

    public Date getCreateDateTime()
    {

        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime)
    {

        this.createDateTime = createDateTime;
    }

    public int getStatusFlag()
    {

        return statusFlag;
    }

    public void setStatusFlag(int statusFlag)
    {

        this.statusFlag = statusFlag;
    }

    private static String _key = "User_%s";

    @Override
    public String key()
    {
        return String.format(keyFormat(), userId);
    }

    @Override
    public String keyFormat()
    {
        return _key;
    }

    @Override
    public CouchBaseSectionType couchbaseSection()
    {
        return CouchBaseSectionType.MAIN;
    }
}
