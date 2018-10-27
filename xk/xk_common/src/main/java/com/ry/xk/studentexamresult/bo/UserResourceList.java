package com.ry.xk.studentexamresult.bo;

import java.util.List;

import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 用来放到缓存中
 */
public class UserResourceList implements ICouchBaseStoredObject
{
    // 用户
    @Tag(1)
    private int userId;

    // 资源类型
    @Tag(2)
    private int resourceTypeId;

    // 用户资源集合
    @Tag(3)
    private List<UserResource> userResource;

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

    public List<UserResource> getUserResource()
    {
        return userResource;
    }

    public void setUserResource(List<UserResource> userResource)
    {
        this.userResource = userResource;
    }

    private static String _key = "UserResource_%s_%s";

    @Override
    public String key()
    {
        return String.format(keyFormat(), userId, resourceTypeId);
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
