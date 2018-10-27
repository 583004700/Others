package com.ry.cds.print.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.print.bo.Cluster;
import com.ry.cds.print.bo.SchoolClusterObject;
import com.ry.cds.print.mapper.ClusterMapper;
import com.ry.cds.springbootframe.datasource.DatabaseType;
import com.ry.cds.springbootframe.datasource.MyDataSource;
import com.ry.cds.user.service.CouchBaseFactory;
import com.ry.cds.utils.ListHelper;

@Repository
public class ClusterDao implements IClusterDao {
	@Autowired
	ClusterMapper clusterMapper;

	@Override
	@MyDataSource(type=DatabaseType.PRINTDB)
	public List<Cluster> getBySchoolID(long schoolID) throws Exception {
		SchoolClusterObject schoolClusterObject = new SchoolClusterObject();
		schoolClusterObject.setSchoolID(schoolID);
		SchoolClusterObject returnSchoolClusterObject = CouchBaseFactory.get(SchoolClusterObject.class,
				schoolClusterObject.key());
		if (null == returnSchoolClusterObject) {
			returnSchoolClusterObject = new SchoolClusterObject();
			returnSchoolClusterObject.setSchoolID(schoolID);
			List<Cluster> clusterList = clusterMapper.getBySchoolID(schoolID);
			if (ListHelper.isNotEmpty(clusterList)) {
				returnSchoolClusterObject.setClusterList(clusterList);
				CouchBaseFactory.update(returnSchoolClusterObject);
			}
		}
		return returnSchoolClusterObject.getClusterList();
	}

	@Override
	@MyDataSource(type=DatabaseType.PRINTDB)
	public Cluster get(long clusterID) throws Exception {
		Cluster cluster = new Cluster();
		cluster.setClusterID(clusterID);
		Cluster rtnCluster = CouchBaseFactory.get(Cluster.class, cluster.key());
		if (null == rtnCluster) {
			rtnCluster = clusterMapper.get(clusterID);
			if (null != rtnCluster) {
				CouchBaseFactory.update(rtnCluster);
			}
		}
		return rtnCluster;
	}

	@Override
	@MyDataSource(type=DatabaseType.PRINTDB)
	public long getSchoolIDByClusterID(long clusterID) throws Exception {
		return clusterMapper.getSchoolIDByClusterID(clusterID);
	}
}