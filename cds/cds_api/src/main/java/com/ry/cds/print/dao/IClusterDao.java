package com.ry.cds.print.dao;

import java.util.List;

import com.ry.cds.print.bo.Cluster;

/**
 * 打印机组持久化接口
 * 
 * @author 幸仁强
 *
 */
public interface IClusterDao {
	/**
	 * 根据学校ID获取打印机组
	 * 
	 * @param userId
	 * @return
	 */
	public List<Cluster> getBySchoolID(long schoolID) throws Exception;

	/**
	 * 根据集群ID获取集群信息
	 * 
	 * @param clusterID
	 * @return
	 * @throws Exception
	 */
	public Cluster get(long clusterID) throws Exception;
	
	/**
	 * 根据集群ID获取对应学校ID
	 * 
	 * @param clusterID
	 * @return
	 * @throws Exception
	 */
	public long getSchoolIDByClusterID(long clusterID) throws Exception;
}