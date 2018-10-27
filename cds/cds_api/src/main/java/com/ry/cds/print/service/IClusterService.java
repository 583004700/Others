package com.ry.cds.print.service;

import java.util.List;

import com.ry.cds.print.bo.Cluster;

/**
 * 打印机组业务接口
 * 
 * @author 幸仁强
 *
 */
public interface IClusterService {
	/**
	 * 根据学校ID获取打印机组
	 * 
	 * @param userId
	 * @return
	 */
	public List<Cluster> getBySchoolID(long schoolID) throws Exception;

}
