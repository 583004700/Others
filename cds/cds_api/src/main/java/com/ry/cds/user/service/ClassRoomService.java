package com.ry.cds.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.cds.user.bo.ClassRoom;
import com.ry.cds.user.dao.IClassRoomDao;

@Service
public class ClassRoomService implements IClassRoomService {

	@Autowired
	IClassRoomDao classRoomDao;

	@Override
	public long insert(ClassRoom classRoom) throws Exception {
		return classRoomDao.insert(classRoom);
	}

	@Override
	public int update(ClassRoom classRoom) throws Exception {
		return classRoomDao.update(classRoom);
	}

}