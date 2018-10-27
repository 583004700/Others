package com.ry.cds.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.user.bo.ClassRoomUser;
import com.ry.cds.user.dao.IClassRoomUserDao;

@Service
public class ClassRoomUserService implements IClassRoomUserService {

	@Autowired
	IClassRoomUserDao classRoomUserDao;

	@Override
	public int insert(ClassRoomUser classRoomUser) throws Exception {
		return classRoomUserDao.insert(classRoomUser);
	}
}