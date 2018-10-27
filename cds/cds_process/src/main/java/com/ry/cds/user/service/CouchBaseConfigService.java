package com.ry.cds.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.user.bo.CouchBaseConfig;
import com.ry.cds.user.mapper.CouchBaseConfigMapper;

@Service
public class CouchBaseConfigService implements ICouchBaseConfigService {
	@Autowired
	private CouchBaseConfigMapper couchBaseConfigMapper;

	@Override
	public List<CouchBaseConfig> couchBaseConfigs() {
		return couchBaseConfigMapper.couchBaseConfigs();
	}

}