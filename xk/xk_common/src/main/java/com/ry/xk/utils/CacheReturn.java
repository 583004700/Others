package com.ry.xk.utils;

/**
 * 从缓存中获取时，获取不到时返回的实体。该实体放入缓存中
 * 
 * @author zhu.weibin
 */
public interface CacheReturn
{
    /**
     * 返回实体对象
     * 
     * @return 将返回值保存到缓存中
     */
    Object returnEntity();
}
