package com.ry.cds.user.dao;

import java.util.List;

import com.ry.cds.user.bo.Partner;

/**
 * Partner表持久层
 * 
 * @author 幸仁强
 */
public interface IPartnerDao {
	/**
	 * 查询所有Partner
	 * 
	 * @return Partner集合
	 */
	public List<Partner> partners();
}
