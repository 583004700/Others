package com.ry.cds.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.user.bo.CouchBaseConfig;
import com.ry.cds.user.dao.ICouchBaseConfigDao;

@Service
public class CouchBaseConfigService implements ICouchBaseConfigService {
	@Autowired
	private ICouchBaseConfigDao couchBaseConfigDao;

	@Override
	public List<CouchBaseConfig> couchBaseConfigs() {
		return couchBaseConfigDao.couchBaseConfigs();
	}

}