package com.ry.cds.user.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ry.cds.user.bo.ClassRoomUser;
import com.ry.cds.user.mapper.ClassRoomUserMapper;

@Repository
public class ClassRoomUserDao implements IClassRoomUserDao {
	@Autowired
	ClassRoomUserMapper classRoomUserMapper;

	@Override
	public int insert(ClassRoomUser classRoomUser) throws Exception {
		return classRoomUserMapper.insert(classRoomUser);
	}

	@Override
	public boolean isExist(long classRoomID, long userID) throws Exception {
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("classRoomID", classRoomID);
		params.put("userID", userID);
		int result = classRoomUserMapper.checkExistByPrimary(params);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
}