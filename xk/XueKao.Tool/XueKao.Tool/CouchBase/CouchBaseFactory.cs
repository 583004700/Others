/*
 * 作者:黄平
 * 创建时间:2014-10-24
 * ------------------修改记录-------------------
 * 修改人      修改日期        修改目的
 * 黄平        2014-10-24      创建
 * 黄平        2015-04-21      补充注释
 * 丁静        2015-08-04      添加SendBackUpEvent方法，保存永久缓存数据时发送备份event
 * 黄平        2015-12-30      将备份的Event放在Couchbase更新之后，并在内部消化Couchbase的备份异常
 * 唐景泰      2016-10-10      增加支持分布式锁的对象递减更新缓存方法
 * 唐景泰      2016-10-27      加长获取couchbase锁超时时间为5秒
 * 唐景泰      2016-12-14      添加GetAllCouchbaseClient方法
-----------------------------------------------------*/
using System;
using System.Collections.Generic;
using System.IO;
using System.IO.Compression;
using System.Linq;
using System.Reflection;
using Couchbase.Authentication;
using Couchbase.Configuration;
using Couchbase.Configuration.Client;
using Couchbase.N1QL;
using ProtoBuf;
using RuanYun.Caching.CouchBase;
using RuanYun.DBUtility;
using XueKao.Tool.Helper;
using XueKao.Tool.Model;
using XueKao.Tool.Model.Config;
using XueKao.Tool.Model.Enum;
using XueKao.Tool.Model.Interface;

namespace XueKao.Tool.Couchbase
{
    /// <summary>
    /// CouchBase操作类
    /// </summary>
    public static class CouchBaseFactory
    {
        private static CouchBaseProtoBufManager couchBaseProtoBufManager;
        private static Dictionary<CouchBaseSectionType, string> bucketNameMappings = new Dictionary<CouchBaseSectionType, string>();
        private static readonly object Lock = new object();
        // 获取couchbase锁超时时间
        private const int _lockTimeOut = 5 * 1000;

        /// <summary>
        /// 获取所有Couchbase客户端连接
        /// </summary>
        /// <returns></returns>
        public static CouchBaseProtoBufManager GetAllCouchbaseClient()
        {
            return couchBaseProtoBufManager;
        }

        static CouchBaseFactory()
        {
            InitAllCouchBaseClient();
        }

        /// <summary>
        /// 初始化所有的CouchBase设置，一般在系统启动的时候会调用
        /// </summary>
        public static void InitAllCouchBaseClient()
        {
            lock (Lock)
            {
                if (bucketNameMappings.Count > 0)
                {
                    return;
                }
                var systemConfig = QueryHelper.GetSystemConfig();
                var couchBaseConfigs = QueryHelper.GetAllCouchBaseConfig();
                var clientConfiguration = new ClientConfiguration() { Servers = new List<Uri>() };
                var clusterCredentials = new ClusterCredentials { BucketCredentials = new Dictionary<string, string>() };
                foreach (var couchBaseConfig in couchBaseConfigs)
                {
                    try
                    {
                        // 解密初始化设置
                        GenerateConfiguration(clientConfiguration, clusterCredentials, couchBaseConfig, systemConfig);
                    }
                    catch (Exception ex)
                    {
                        throw ex;
                    }
                }
                couchBaseProtoBufManager = new CouchBaseProtoBufManager(clientConfiguration, clusterCredentials);
            }
        }

        /// <summary>
        /// 解密并初始化clientConfiguration配置对象
        /// </summary>
        /// <param name="clientConfiguration">需要初始化的Couchbase配置对象</param>
        /// <param name="clusterCredentials">每个bucket的验证配置</param>
        /// <param name="couchBaseConfig">数据库配置</param>
        /// <param name="systemConfig">系统配置，需要获取解密的秘钥</param>
        private static void GenerateConfiguration(ClientConfiguration clientConfiguration, ClusterCredentials clusterCredentials,
                                                  CouchBaseConfig couchBaseConfig, SystemConfig systemConfig)
        {
            var decryptValue = CryptogramHelper.Decrypt3DESWithTrueKey(couchBaseConfig.CouchBaseConfigValue, systemConfig.ConfigKey);
            try
            {

                var arryValues = decryptValue.Split(';');
                if (!clientConfiguration.Servers.Exists(p => p.AbsoluteUri.Equals(arryValues[2])))
                {
                    clientConfiguration.Servers.Add(new Uri(arryValues[2]));
                }
                clusterCredentials.BucketCredentials.Add(arryValues[0], arryValues[1]);
                bucketNameMappings.Add((CouchBaseSectionType)couchBaseConfig.CouchBaseConfigId, arryValues[0]);
            }
            catch (Exception ex)
            {
                throw new InvalidDataException(string.Format("解密后的数据无效，Value：{0}", decryptValue));
            }
        }

        /// <summary>
        /// 根据bucket类型获取bucket的名字
        /// </summary>
        /// <param name="couchBaseSectionType">bucket类型</param>
        /// <returns>bucket名字</returns>
        private static string GetBucketName(CouchBaseSectionType couchBaseSectionType)
        {
            if (bucketNameMappings.ContainsKey(couchBaseSectionType))
            {
                return bucketNameMappings[couchBaseSectionType];
            }
            throw new ConfigNotFoundException(String.Format("Bucket不存在:{0}", couchBaseSectionType));
        }

        /// <summary>
        /// 添加缓存(未指定过期时间，则永不过期)
        /// </summary>
        /// <param name="value">键值</param>
        public static bool Add<T>(T value) where T : ICouchBaseStoredObject
        {
            var result = couchBaseProtoBufManager.Add(value.Key, value, GetBucketName(value.CouchBaseSection));
            return result;
        }

        /// <summary>
        /// 添加缓存(指定缓存绝对过期时间)
        /// </summary>
        /// <param name="value">键值</param>
        /// <param name="numOfMinutes">缓存绝对过期时间值(分钟计)</param>
        public static bool Add<T>(T value, long numOfMinutes) where T : ICouchBaseStoredObject
        {
            return couchBaseProtoBufManager.Add(value.Key, value, numOfMinutes, GetBucketName(value.CouchBaseSection));
        }

        /// <summary>
        /// 更新指定缓存
        /// </summary>
        /// <param name="value">键值</param>
        /// <returns>是否更新成功</returns>
        public static bool Update<T>(T value) where T : ICouchBaseStoredObject
        {
            var result = couchBaseProtoBufManager.Update(value.Key, value, GetBucketName(value.CouchBaseSection));
            return result;
        }

        /// <summary>
        /// 更新指定缓存
        /// </summary>
        /// <param name="value">键值</param>
        /// <param name="numOfMinutes">缓存绝对过期时间值(分钟计) </param>
        /// <returns>是否更新成功</returns>
        public static bool Update<T>(T value, long numOfMinutes) where T : ICouchBaseStoredObject
        {
            return couchBaseProtoBufManager.Update(value.Key, value, numOfMinutes, GetBucketName(value.CouchBaseSection));
        }

        /// <summary>
        /// 获取Cache值对象
        /// </summary>
        /// <param name="sectionType"></param>
        /// <param name="key">要获取的Cache项键名</param>
        /// <returns>Cache对象</returns>
        public static T Get<T>(CouchBaseSectionType sectionType, string key) where T : class, ICouchBaseStoredObject
        {
            try
            {
                return couchBaseProtoBufManager.Get<T>(key, GetBucketName(sectionType));
            }
            catch (Exception ex)
            {
                return default(T);
            }

        }

        /// <summary>
        /// 获取Cache值对象
        /// </summary>
        /// <returns>Cache对象</returns>
        public static T Get<T>(params object[] keyValues) where T : class, ICouchBaseStoredObject, new()
        {
            try
            {
                var obj = new T();
                var key = string.Format(obj.KeyFormat, keyValues);
                return couchBaseProtoBufManager.Get<T>(key, GetBucketName(obj.CouchBaseSection));
            }
            catch (Exception ex)
            {
                return default(T);
            }

        }

        /// <summary>
        /// 移除Couchbase中bucket的指定键缓存数据
        /// </summary>
        /// <param name="sectionType">Couchbase中bucket枚举</param>
        /// <param name="key">couchbase中key</param>
        /// <returns>true 成功，false 失败</returns>
        public static bool Remove(CouchBaseSectionType sectionType, string key)
        {
            return couchBaseProtoBufManager.Remove(key, GetBucketName(sectionType));
        }

        /// <summary>
        /// 更新缓存，该缓存没有失效时间<br/>
        /// 在当前缓存对象上执行累加后并更新原有缓存<br/>
        /// 当前缓存对象不存在或为null，使用增量直接更新缓存并返回<br/>
        /// 已实现分布式锁，保证在缓存更新过程中不会被有其他线程更新<br/>
        /// 适用场景：当需要对缓存对象（对象多个属性）做累加或修改并且需要保证修改过程中不会被其他线程更新时，使用该方法可保证不会出现“更新丢失”现象
        /// </summary>
        /// <typeparam name="T">更新缓存对象类型，该类型必须实现IAccumulator接口</typeparam>
        /// <param name="increment">当前缓存对象增量<br/>
        /// key存在，则在该缓存对象上执行增量累加<br/>
        /// 不存在则将增量作为初始值缓存
        /// </param>
        /// <returns>执行完累加后的缓存对象</returns>
        /// <exception cref="System.ArgumentNullException">在参数increment或者increment.key值为null时抛出</exception>
        public static T IncrementWithLock<T>(T increment)
            where T : class, ICouchBaseStoredObject, RuanYun.Caching.Common.IAccumulator
        {
            if (increment == null)
                throw new ArgumentNullException("increment");


            var current = couchBaseProtoBufManager.IncrementWithLock(increment.Key, increment, GetBucketName(increment.CouchBaseSection), _lockTimeOut);
            return current;
        }

        /// <summary>
        /// 更新缓存，指定过期时间后失效<br/>
        /// 在当前缓存对象上执行累加后并更新原有缓存<br/>
        /// 当前缓存对象不存在或为null，使用增量直接更新缓存并返回<br/>
        /// 已实现分布式锁，保证在缓存更新过程中不会被有其他线程更新<br/>
        /// 适用场景：当需要对缓存对象（对象多个属性）做累加或修改并且需要保证修改过程中不会被其他线程更新时，使用该方法可保证不会出现“更新丢失”现象
        /// </summary>
        /// <typeparam name="T">更新缓存对象类型，该类型必须实现IAccumulator接口</typeparam>
        /// <param name="increment">当前缓存对象增量<br/>
        /// key存在，则在该缓存对象上执行增量累加<br/>
        /// 不存在则将增量作为初始值缓存
        /// </param>
        /// <param name="numOfMinutes">缓存对象失效时间，小于0则没有永久存储<br/>单位：分钟</param>
        /// <returns>执行完累加后的缓存对象</returns>
        /// <exception cref="System.ArgumentNullException">在参数increment或者increment.key值为null时抛出</exception>
        public static T IncrementWithLock<T>(T increment, int numOfMinutes)
            where T : class,ICouchBaseStoredObject, RuanYun.Caching.Common.IAccumulator
        {
            if (increment == null)
                throw new ArgumentNullException("increment");

            return couchBaseProtoBufManager.IncrementWithLock(increment.Key, increment, numOfMinutes, _lockTimeOut, GetBucketName(increment.CouchBaseSection));
        }

        /// <summary>
        /// 更新缓存，永久缓存，无过期时间<br/>
        /// 在当前缓存对象上执行减量后并更新原有缓存<br/>
        /// 当前缓存对象不存在或为null，不做处理，直接返回null<br/>
        /// 已实现分布式锁，保证在缓存更新过程中不会被有其他线程更新<br/>
        /// 适用场景：当需要对缓存对象（对象多个属性）做减量或修改并且需要保证修改过程中不会被其他线程更新时，使用该方法可保证不会出现“更新丢失”现象
        /// </summary>
        /// <typeparam name="T">更新缓存对象类型，该类型必须实现IDecrementer接口</typeparam>
        /// <param name="key">couchbase缓存key</param>
        /// <param name="decrement">当前缓存对象的减量<br/>
        /// key存在，则在该缓存对象上执行增量累加<br/>
        /// 不存在则将增量作为初始值缓存
        /// </param>
        /// <returns>执行完累加后的缓存对象</returns>
        /// <exception cref="System.ArgumentNullException">在参数key或者decrement值为null时抛出</exception>
        public static T DecrementWithLock<T>(T decrement)
            where T : class,ICouchBaseStoredObject, RuanYun.Caching.Common.IDecrementer
        {
            if (decrement == null)
                throw new ArgumentNullException("decrement");
            return DecrementWithLock(decrement, -1);
        }

        /// <summary>
        /// 更新缓存，指定过期时间后失效<br/>
        /// 在当前缓存对象上执行减量后并更新原有缓存<br/>
        /// 当前缓存对象不存在或为null，不做处理，直接返回null<br/>
        /// 已实现分布式锁，保证在缓存更新过程中不会被有其他线程更新<br/>
        /// 适用场景：当需要对缓存对象（对象多个属性）做减量或修改并且需要保证修改过程中不会被其他线程更新时，使用该方法可保证不会出现“更新丢失”现象
        /// </summary>
        /// <typeparam name="T">更新缓存对象类型，该类型必须实现IDecrementer接口</typeparam>
        /// <param name="key">couchbase缓存key</param>
        /// <param name="decrement">当前缓存对象的减量<br/>
        /// key存在，则在该缓存对象上执行增量累加<br/>
        /// 不存在则将增量作为初始值缓存
        /// </param>
        /// <param name="numOfMinutes">缓存对象失效时间，小于0则没有永久存储<br/>单位：分钟</param>
        /// <returns>执行完累加后的缓存对象</returns>
        /// <exception cref="System.ArgumentNullException">在参数key或者decrement值为null时抛出</exception>
        public static T DecrementWithLock<T>(T decrement, int numOfMinutes)
            where T : class,ICouchBaseStoredObject, RuanYun.Caching.Common.IDecrementer
        {
            if (decrement == null)
                throw new ArgumentNullException("decrement");

            return couchBaseProtoBufManager.DecrementWithLock(decrement.Key, decrement, numOfMinutes, _lockTimeOut, GetBucketName(decrement.CouchBaseSection));
        }
    }
}
