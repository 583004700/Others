package com.ry.cds.print.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.print.bo.Cluster;
import com.ry.cds.print.dao.IClusterDao;

@Service
public class ClusterService implements IClusterService {

	@Autowired
	IClusterDao clusterDao;

	@Override
	public List<Cluster> getBySchoolID(long schoolID) throws Exception {
		return clusterDao.getBySchoolID(schoolID);
	}

}