package com.ry.cds.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.user.bo.School;
import com.ry.cds.user.mapper.SchoolMapper;
import com.ry.cds.user.service.CouchBaseFactory;

@Repository
public class SchoolDao implements ISchoolDao {
	@Autowired
	SchoolMapper schoolMapper;

	@Override
	public long insert(School school) throws Exception {
		int result = schoolMapper.insert(school);
		long schoolID = 0;
		if (result > 0) {
			schoolID = school.getSchoolID();// 该对象的自增ID
			CouchBaseFactory.update(school);
		}
		return schoolID;
	}

	@Override
	public int update(School school) throws Exception {
		int result = schoolMapper.update(school);
		if (result > 0) {
			CouchBaseFactory.update(school);
		}
		return result;
	}

	@Override
	public School get(long schoolID) throws Exception {
		School school = new School();
		school.setSchoolID(schoolID);
		School rtnSchool = CouchBaseFactory.get(School.class, school.key());
		if (null == rtnSchool) {
			rtnSchool = schoolMapper.get(schoolID);
			if (null != rtnSchool) {
				CouchBaseFactory.update(rtnSchool);
			}
		}
		return rtnSchool;
	}

	@Override
	public School getBySchoolCode(String schoolCode) throws Exception {
		long schoolID = schoolMapper.getPrimaryBySchoolCode(schoolCode);
		return schoolID > 0 ? get(schoolID) : null;

	}

}