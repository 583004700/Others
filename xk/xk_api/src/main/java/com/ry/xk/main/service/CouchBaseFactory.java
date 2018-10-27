package com.ry.xk.main.service;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.couchbase.client.core.config.ConfigurationException;
import com.couchbase.client.java.auth.ClassicAuthenticator;
import com.ry.xk.common.bo.CouchBaseConfig;
import com.ry.xk.common.bo.SystemConfig;
import com.ry.xk.common.service.ICouchBaseConfigService;
import com.ry.xk.common.service.SystemConfigService;
import com.ry.xk.springbootframe.couchbase.CouchBaseProtoBufManager;
import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseOperationObject;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;
import com.ry.xk.utils.CryptogramHelper;

/**
 * couchbase工厂类
 * 
 * @author 幸仁强
 * @createtime 2018-2-22
 */
@Component
public class CouchBaseFactory
{
    private static Logger logger = LoggerFactory.getLogger(CouchBaseFactory.class);

    private static CouchBaseProtoBufManager _couchBaseProtoBufManager;

    private static Dictionary<CouchBaseSectionType, String> _bucketNameMappings = new Hashtable<CouchBaseSectionType, String>();

    private static Lock lock = new ReentrantLock();

    private static CouchBaseFactory couchBaseFactory;

    @Autowired
    ICouchBaseConfigService couchBaseConfigService;

    @Autowired
    SystemConfigService systemConfigService;

    @PostConstruct
    public void init()
    {
        logger.info("开始获取couchbase相关配置");
        couchBaseFactory = this;
        couchBaseFactory.couchBaseConfigService = this.couchBaseConfigService;
        couchBaseFactory.systemConfigService = this.systemConfigService;
        lock.lock();
        try
        {
            SystemConfig systemConfig = systemConfigService.systemConfigs();
            List<CouchBaseConfig> couchBaseConfigs = couchBaseConfigService.couchBaseConfigs();
            List<String> nodeList = new ArrayList<String>();
            ClassicAuthenticator classicAuthenticator = new ClassicAuthenticator();
            for (CouchBaseConfig couchBaseConfigBO : couchBaseConfigs)
            {
                generateConfiguration(nodeList, classicAuthenticator, couchBaseConfigBO, systemConfig);
            }
            _couchBaseProtoBufManager = new CouchBaseProtoBufManager(nodeList, classicAuthenticator);
            logger.info("成功获取couchbase相关配置");
        }
        catch (Exception e)
        {
            logger.error("获取couchbase相关配置异常", e);
        }
        finally
        {
            lock.unlock();
        }
    }

    /**
     * 获取配置信息
     * 
     * @param nodeList
     * @param classicAuthenticator
     * @param couchBaseConfigBO
     */
    private static void generateConfiguration(List<String> nodeList, ClassicAuthenticator classicAuthenticator, CouchBaseConfig couchBaseConfigBO, SystemConfig systemConfig)
    {
        try
        {
            String configValue = CryptogramHelper.decryptThreeDESECB(couchBaseConfigBO.getCouchBaseConfigValue(), systemConfig.getConfigKey());

            String[] arryValues = configValue.split(";");
            String node = arryValues[2].substring(0, arryValues[2].lastIndexOf("/"));
            if (!nodeList.contains(node))
            {
                nodeList.add(node);
            }
            classicAuthenticator.bucket(arryValues[0], arryValues[1]);
            for (CouchBaseSectionType e : CouchBaseSectionType.values())
            {
                if (e.getIndex() == couchBaseConfigBO.getCouchBaseConfigID())
                {
                    _bucketNameMappings.put(e, arryValues[0]);
                }
            }
        }
        catch (Exception e)
        {
            logger.error("获取couchbase相关配置异常", e);
            e.printStackTrace();
        }

    }

    private static String getBucketName(CouchBaseSectionType couchBaseSectionType)
    {
        if (_bucketNameMappings.get(couchBaseSectionType) != null)
        {
            return _bucketNameMappings.get(couchBaseSectionType);
        }
        logger.error(String.format("Bucket不存在:{%s}", couchBaseSectionType));
        throw new ConfigurationException(String.format("Bucket不存在:{%s}", couchBaseSectionType));
    }

    public static <T extends ICouchBaseStoredObject> T get(Class<T> clazz, String key)
    {
        try
        {
            return _couchBaseProtoBufManager.get(clazz, key, getBucketName(clazz.newInstance().couchbaseSection()));
        }
        catch (Exception e)
        {
            logger.error("获取couchbase缓存异常", e);
            return null;
        }
    }

    public static <T extends ICouchBaseStoredObject> boolean add(T value)
    {
        try
        {
            return _couchBaseProtoBufManager.add(value.key(), value, getBucketName(value.couchbaseSection()));
        }
        catch (Exception e)
        {
            logger.error("添加couchbase缓存异常", e);
            return false;
        }
    }

    public static <T extends ICouchBaseStoredObject> boolean add(T value, long numOfMinutes)
    {
        try
        {
            return _couchBaseProtoBufManager.add(value.key(), value, numOfMinutes, getBucketName(value.couchbaseSection()));
        }
        catch (Exception e)
        {
            logger.error("添加couchbase缓存异常", e);
            return false;
        }
    }

    public static <T extends ICouchBaseStoredObject> boolean update(T value)
    {
        try
        {
            return _couchBaseProtoBufManager.update(value.key(), value, getBucketName(value.couchbaseSection()));
        }
        catch (Exception e)
        {
            logger.error("更新couchbase缓存异常", e);
            return false;
        }
    }

    public static <T extends ICouchBaseStoredObject> boolean update(T value, long numOfMinutes)
    {
        try
        {
            return _couchBaseProtoBufManager.update(value.key(), value, numOfMinutes, getBucketName(value.couchbaseSection()));
        }
        catch (Exception e)
        {
            logger.error("更新couchbase缓存异常", e);
            return false;
        }
    }

    public static <T extends ICouchBaseOperationObject & ICouchBaseStoredObject> boolean updateCas(T value)
    {
        try
        {
            return _couchBaseProtoBufManager.updateCas(value.key(), value, getBucketName(value.couchbaseSection()));
        }
        catch (Exception e)
        {
            logger.error("更新couchbase缓存异常", e);
            return false;
        }
    }

    public static <T extends ICouchBaseOperationObject & ICouchBaseStoredObject> boolean updateCas(T value, long numOfMinutes)
    {
        try
        {
            return _couchBaseProtoBufManager.updateCas(value.key(), value, numOfMinutes, getBucketName(value.couchbaseSection()));
        }
        catch (Exception e)
        {
            logger.error("更新couchbase缓存异常", e);
            return false;
        }
    }

    public static boolean remove(CouchBaseSectionType sectionType, String key)
    {
        return _couchBaseProtoBufManager.remove(key, getBucketName(sectionType));
    }
}
