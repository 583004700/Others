package com.ry.cds.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.user.bo.Partner;
import com.ry.cds.user.mapper.PartnerMapper;

/**
 * SystemConfig配置表持久层
 * 
 * @author 幸仁强
 */
@Repository("partnerDao")
public class PartnerDao implements IPartnerDao {
	@Autowired
	PartnerMapper partnerMapper;

	@Override
	public List<Partner> partners() {
		return partnerMapper.partners();
	}

}
