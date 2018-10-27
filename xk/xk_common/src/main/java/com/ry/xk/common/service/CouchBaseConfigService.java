package com.ry.xk.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.xk.common.bo.CouchBaseConfig;
import com.ry.xk.common.dao.ICouchBaseConfigDao;

@Service
public class CouchBaseConfigService implements ICouchBaseConfigService {
	@Autowired
	private ICouchBaseConfigDao couchBaseConfigDao;

	@Override
	public List<CouchBaseConfig> couchBaseConfigs() {
		return couchBaseConfigDao.couchBaseConfigs();
	}

}