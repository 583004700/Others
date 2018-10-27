package com.ry.cds.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.user.bo.SchoolPriceConfig;
import com.ry.cds.user.mapper.SchoolPriceConfigMapper;
import com.ry.cds.user.service.CouchBaseFactory;

@Repository
public class SchoolPriceConfigDao implements ISchoolPriceConfigDao {
	@Autowired
	SchoolPriceConfigMapper schoolPriceConfigMapper;

	@Override
	public SchoolPriceConfig get(long schoolID) throws Exception {		
		SchoolPriceConfig schoolPriceConfig = new SchoolPriceConfig();
		schoolPriceConfig.setSchoolID(schoolID);
		SchoolPriceConfig rtnSchoolPriceConfig = CouchBaseFactory.get(SchoolPriceConfig.class, schoolPriceConfig.key());
		if (null == rtnSchoolPriceConfig) {
			
			rtnSchoolPriceConfig = schoolPriceConfigMapper.get(schoolID);
			if (null != rtnSchoolPriceConfig) {
				CouchBaseFactory.update(rtnSchoolPriceConfig);
			}
		}
		return rtnSchoolPriceConfig;
		
	}

	

}