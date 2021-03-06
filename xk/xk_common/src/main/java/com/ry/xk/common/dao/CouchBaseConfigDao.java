package com.ry.xk.common.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.xk.common.bo.CouchBaseConfig;
import com.ry.xk.common.mapper.CouchBaseConfigMapper;

@Repository("couchBaseConfigDao")
public class CouchBaseConfigDao implements ICouchBaseConfigDao {

	@Autowired
	CouchBaseConfigMapper couchBaseConfigMapper;

	@Override
	public List<CouchBaseConfig> couchBaseConfigs() {
		return couchBaseConfigMapper.couchBaseConfigs();
	}
}
