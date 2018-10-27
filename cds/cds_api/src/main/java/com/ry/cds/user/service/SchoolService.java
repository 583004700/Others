package com.ry.cds.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.user.bo.School;
import com.ry.cds.user.dao.ISchoolDao;

@Service
public class SchoolService implements ISchoolService {

	@Autowired
	ISchoolDao schoolDao;

	@Override
	public long insert(School school) throws Exception {
		return schoolDao.insert(school);
	}

	@Override
	public int update(School school) throws Exception {
		return schoolDao.update(school);
	}

}