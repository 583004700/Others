package com.ry.cds.user.service;

import java.util.Map;

import com.ry.cds.print.bo.Printer;

/**
 * 系统配置表业务类接口
 * 
 * @author 幸仁强
 *
 */
public interface IPartnerService {
	/**
	 * 获取Key，Secret的map对应关系
	 * 
	 * @return Key，Secret的map对应关系
	 * @throws Exception
	 */
	public Map<String, String> partnerKeySecretMap();

	/**
	 * 根据key获取secret
	 * @param key
	 * @return
	 */
	public String getSecretByKey(String key);
}
