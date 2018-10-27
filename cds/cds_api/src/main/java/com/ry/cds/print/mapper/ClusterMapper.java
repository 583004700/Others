package com.ry.cds.print.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.cds.print.bo.Cluster;

/**
 * 打印机组mapper
 * 
 * @author 幸仁强
 *
 */
@Mapper
public interface ClusterMapper {
	/**
	 * 根据学校ID获取打印机组
	 * 
	 * @param schoolID
	 * @return
	 */
	public List<Cluster> getBySchoolID(@Param("schoolID") long schoolID);

	/**
	 * 根据集群ID获取集群信息
	 * 
	 * @param clusterID
	 * @return
	 */
	public Cluster get(@Param("clusterID") long clusterID);

	/**
	 * 根据集群ID获取对应学校ID
	 * 
	 * @param clusterID
	 * @return
	 * @throws Exception
	 */
	public long getSchoolIDByClusterID(@Param("clusterID") long clusterID) throws Exception;

}