package com.ry.cds.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.user.bo.ClassRoom;
import com.ry.cds.user.mapper.ClassRoomMapper;
import com.ry.cds.user.service.CouchBaseFactory;

@Repository
public class ClassRoomDao implements IClassRoomDao {
	@Autowired
	ClassRoomMapper classRoomMapper;

	@Override
	public long insert(ClassRoom classRoom) throws Exception {
		int result = classRoomMapper.insert(classRoom);
		long classRoomID = 0;
		if (result > 0) {
			classRoomID = classRoom.getClassRoomID();
			CouchBaseFactory.update(classRoom);
		}
		return classRoomID;
	}

	@Override
	public int update(ClassRoom classRoom) throws Exception {
		int result = classRoomMapper.update(classRoom);
		if (result > 0) {
			CouchBaseFactory.update(classRoom);
		}
		return result;
	}

	@Override
	public ClassRoom get(long classRoomID) throws Exception {
		ClassRoom classRoom = new ClassRoom();
		classRoom.setClassRoomID(classRoomID);
		ClassRoom rtnClassRoom = CouchBaseFactory.get(ClassRoom.class, classRoom.key());
		if (null == rtnClassRoom) {
			rtnClassRoom = classRoomMapper.get(classRoomID);
			if (null != rtnClassRoom) {
				CouchBaseFactory.update(rtnClassRoom);
			}
		}
		return rtnClassRoom;
	}

	@Override
	public ClassRoom getByClassRoomCode(String classRoomCode) throws Exception {
		long classRoomID = classRoomMapper.getPrimaryByClassRoomCode(classRoomCode);
		return classRoomID > 0 ? get(classRoomID) : null;
	}
}