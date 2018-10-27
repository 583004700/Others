package com.ry.xk.studentexamresult.bo;

import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 公众号accessToken
 * 
 * @ClassName: ThirdPartyAccessToken
 * @author 幸仁强
 * @date 2018年5月31日
 */
public class ThirdPartyAccessToken implements ICouchBaseStoredObject
{
    /**
     * 合作伙伴ID
     */
    @Tag(1)
    private int partnerId;

    /**
     * AccessToken
     */
    @Tag(2)
    private String accessToken;

    /**
     * 过期时间 110分钟*60秒
     */
    @Tag(3)
    private int expiresIn;

    /**
     * 更新时间，由微信返回给我们（毫秒）
     */
    @Tag(4)
    private long refreshTicks;

    public int getPartnerId()
    {

        return partnerId;
    }

    public void setPartnerId(int partnerId)
    {

        this.partnerId = partnerId;
    }

    public String getAccessToken()
    {

        return accessToken;
    }

    public void setAccessToken(String accessToken)
    {

        this.accessToken = accessToken;
    }

    public int getExpiresIn()
    {

        return expiresIn;
    }

    public void setExpiresIn(int expiresIn)
    {

        this.expiresIn = expiresIn;
    }

    public long getRefreshTicks()
    {

        return refreshTicks;
    }

    public void setRefreshTicks(long refreshTicks)
    {

        this.refreshTicks = refreshTicks;
    }

    public static String _key = "AccessToken_%s";

    @Override
    public String key()
    {
        return String.format(keyFormat(), partnerId);
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

    public ThirdPartyAccessToken()
    {}

    public ThirdPartyAccessToken(int partnerId, String accessToken, int expiresIn, long refreshTicks)
    {
        this.partnerId = partnerId;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.refreshTicks = refreshTicks;
    }
}
