package com.ry.xk.studentexamresult.bo;

import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 公众号Ticket
 * 
 * @ClassName: ThirdPartyTicket
 * @author 幸仁强
 * @date 2018年5月31日
 */
public class ThirdPartyTicket implements ICouchBaseStoredObject
{
    /**
     * 合作伙伴ID
     */
    @Tag(1)
    private int partnerId;

    /**
     * 用户ID
     */
    @Tag(2)
    private String ticket;

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

    public String getTicket()
    {

        return ticket;
    }

    public void setTicket(String ticket)
    {

        this.ticket = ticket;
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

    public static String _key = "Ticket_%s";

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

    public ThirdPartyTicket()
    {}

    public ThirdPartyTicket(int partnerId, String ticket, int expiresIn, long refreshTicks)
    {
        this.partnerId = partnerId;
        this.ticket = ticket;
        this.expiresIn = expiresIn;
        this.refreshTicks = refreshTicks;
    }
}
