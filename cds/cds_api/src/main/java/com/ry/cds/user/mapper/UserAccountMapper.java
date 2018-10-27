package com.ry.cds.user.mapper;

import java.util.Map;

import org.mapstruct.Mapper;

import com.ry.cds.user.bo.UserAccount;

/**
 * 学校Mapper
 * 
 * @author 幸仁强
 *
 */
@Mapper
public interface UserAccountMapper {

	/**
	 * 根据主键获取用户账户信息
	 * 
	 * @param map
	 * @return
	 */
	public UserAccount get(Map<String,Object> map);	

}