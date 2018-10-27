package com.ry.xk.common.bo;

public class RequestBase
{
    /**
     * 用户ID
     */
    private int userId;

    /**
     * 加密前机构ID
     */
    private String orgId;

    /**
     * 解密后机构ID
     */
    private int partnerId;

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getOrgId()
    {

        return orgId;
    }

    public void setOrgId(String orgId)
    {

        this.orgId = orgId;
    }

    public int getPartnerId()
    {

        return partnerId;
    }

    public void setPartnerId(int partnerId)
    {
    
        this.partnerId = partnerId;
    }
    
}
