package com.ry.xk.utils;


import com.ry.xk.main.service.CouchBaseFactory;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;

/**
 * 获取更新缓存的工具类
 * @author zhu.weibin
 */
public class CacheUtil
{
    /**
     * 完成逻辑 1、从缓存中取出一个对象 2、如果对象不存在，则将接口的返回值作为对象 3、将对象放入缓存中
     * @param entity 需要获取的对象
     * @param cacheReturn 获取不到时从此对象中获取
     * @param <T> 泛型
     * @return 获取到的对象或者cacheReturn回调时返回的对象（一般是从数据库中取出来的）
     */
    public static <T extends ICouchBaseStoredObject> T get(T entity, CacheReturn cacheReturn)
    {
        T reT = (T) CouchBaseFactory.get(entity.getClass(), entity.key());
        if (reT == null)
        {
            reT = (T)cacheReturn.returnEntity();
            if (reT != null)
            {
                CouchBaseFactory.update(reT);
            }
        }
        return reT;
    }

    /**
     * 从缓存中移除某个对象
     * @param entity 需要移除的对象
     * @param <T> 泛型参数
     * @return 返回移除结果
     */
    public static <T extends ICouchBaseStoredObject> boolean remove(T entity)
    {
        return CouchBaseFactory.remove(entity.couchbaseSection(), entity.key());
    }
}
