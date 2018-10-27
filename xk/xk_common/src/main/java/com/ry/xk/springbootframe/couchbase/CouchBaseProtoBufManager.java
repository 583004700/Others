package com.ry.xk.springbootframe.couchbase;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.couchbase.client.core.CouchbaseException;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.auth.ClassicAuthenticator;
import com.couchbase.client.java.document.ByteArrayDocument;
import com.ry.xk.utils.GZipUtil;
import com.ry.xk.utils.ProtoBufUtil;

/**
 * couchbase操作类
 * 
 * @author Administrator
 *
 */
public class CouchBaseProtoBufManager {

	private final static Logger log = LoggerFactory.getLogger(CouchBaseProtoBufManager.class);
	//
	private static Cluster _instance;

	/**
	 * couchbase实例
	 * 
	 * @return
	 */
	public static Cluster getInstance() {
		return _instance;
	}

	/**
	 * 获取bucket对象
	 * 
	 * @param bucketName
	 * @return
	 */
	public Bucket getBucket(String bucketName) {
		return this.openBucket(bucketName);
	}

	/**
	 * 开启couchbase对应的bucket 因为开启关闭bucket会有性能消耗，故将bucket进行静态缓存
	 * 
	 * @param bucketName
	 * @return
	 */
	private Bucket openBucket(String bucketName) {
		return _instance.openBucket(bucketName, 5000, TimeUnit.SECONDS);
	}

	/**
	 * 构造函数
	 * 
	 * @param nodeList
	 * @param clusterCredentials
	 */
	public CouchBaseProtoBufManager(List<String> nodeList, ClassicAuthenticator classicAuthenticator) {
		if (_instance == null) {
			_instance = CouchbaseCluster.create(nodeList);
			_instance.authenticate(classicAuthenticator);
		}
	}

	/**
	 * 获取缓存对象的byte数组
	 * 
	 * @param <T>
	 * 
	 * @param key
	 * @param bucketName
	 * @return
	 * @return
	 * @throws IOException
	 */
	public <T> T get(Class<T> clazz, String key, String bucketName) throws IOException {
		Bucket bucket = getBucket(bucketName);
		ByteArrayDocument response = bucket.get(key, ByteArrayDocument.class);
		if (response == null) {
			return null;
		} else {
			return (T) ProtoBufUtil.deserializer(GZipUtil.uncompress(response.content()), clazz);
		}
	}

	/**
	 * 添加缓存
	 * 
	 * @param key
	 *            键名
	 * @param value
	 *            键值的byte数组
	 * @param bucketName
	 *            bucket名称
	 * @return
	 * @throws Exception
	 */
	public <T> boolean add(String key, T value, String bucketName) throws Exception {
		return update(key, value, bucketName);
	}

	/**
	 * 添加缓存（未指定过期时间，则永不过期）
	 * 
	 * @param key
	 *            键名
	 * @param bytes
	 *            键值的byte数组
	 * @param numOfMinutes
	 *            过期时间（分钟）
	 * @param bucketName
	 *            bucket名称
	 * @return
	 * @throws Exception
	 */
	public <T> boolean add(String key, T value, long numOfMinutes, String bucketName) throws Exception {
		return update(key, value, numOfMinutes, bucketName);
	}

	/**
	 * 更新指定缓存
	 * 
	 * @param key
	 *            键名
	 * @param bytes
	 *            键值的byte[]数组
	 * @param bucketName
	 *            bucket名称
	 * @return
	 * @throws Exception
	 */
	public <T> boolean update(String key, T value, String bucketName) throws Exception {
		return update(key, value, -1, bucketName);
	}

	/**
	 * 
	 * @param key
	 *            键名
	 * @param bytes
	 *            键值的byte[]数组
	 * @param numOfMinutes
	 *            缓存过期时间（分钟）
	 * @param bucketName
	 *            bucket名称
	 * @return
	 * @throws Exception
	 */
	public <T> boolean update(String key, T value, long numOfMinutes, String bucketName) throws Exception {
		try {
			// protoBuf压缩和Gzip压缩
			byte[] bytes = GZipUtil.compress(ProtoBufUtil.serializer(value));
			ByteArrayDocument byteArrDocment = ByteArrayDocument.create(key, bytes);
			Bucket bucket = getBucket(bucketName);
			ByteArrayDocument result = numOfMinutes < 0 ? bucket.upsert(byteArrDocment)
					: bucket.upsert(byteArrDocment, numOfMinutes, TimeUnit.MINUTES);
			if (result != null && result.content() != null && result.content().length > 0)
				return true;
		} catch (Exception e) {
			log.error("存入couchBase缓存失败！", e);
			throw new CouchbaseException();
		}
		return false;
	}

	/**
	 * 更新指定缓存
	 * 
	 * @param key
	 *            键名
	 * @param bytes
	 *            键值的byte[]数组
	 * @param bucketName
	 *            bucket名称
	 * @return
	 * @throws Exception
	 */
	public <T extends ICouchBaseOperationObject & ICouchBaseStoredObject> boolean updateCas(String key, T value,
			String bucketName) throws Exception {
		return updateCas(key, value, -1, bucketName);
	}

	/**
	 * 
	 * @param key
	 *            键名
	 * @param bytes
	 *            键值的byte[]数组
	 * @param numOfMinutes
	 *            缓存过期时间（分钟）
	 * @param bucketName
	 *            bucket名称
	 * @return
	 * @throws Exception
	 */
	public <T extends ICouchBaseOperationObject & ICouchBaseStoredObject> boolean updateCas(String key, T value,
			long numOfMinutes, String bucketName) throws Exception {
		Bucket bucket = null;
		ByteArrayDocument lockByteArrDocment = null;
		try {
			bucket = getBucket(bucketName);
			lockByteArrDocment = bucket.getAndLock(key, 600, ByteArrayDocument.class);
			value.reckon(lockByteArrDocment);
			// protoBuf压缩和Gzip压缩
			byte[] bytes = GZipUtil.compress(ProtoBufUtil.serializer(value));
			ByteArrayDocument byteArrDocment = ByteArrayDocument.create(key, bytes, lockByteArrDocment.cas());
			ByteArrayDocument result = numOfMinutes < 0 ? bucket.replace(byteArrDocment)
					: bucket.replace(byteArrDocment, numOfMinutes, TimeUnit.MINUTES);
			if (result != null && result.content() != null && result.content().length > 0)
				return true;
		} catch (Exception e) {
			if (lockByteArrDocment.cas() > 0) {
				bucket.unlock(key, lockByteArrDocment.cas());
			}
			log.error("存入couchBase缓存失败！", e);
			throw new CouchbaseException();
		}
		return false;
	}

	/**
	 * 
	 * @param key
	 * @param bucketName
	 * @return
	 */
	public <T> boolean remove(String key, String bucketName) {
		if (key == null) {
			throw new NullPointerException("key不能为空");
		}
		Bucket bucket = getBucket(bucketName);
		bucket.remove(key);
		return !bucket.exists(key);
	}

}
