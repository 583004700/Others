package com.ry.cds;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ry.cds.user.bo.ClassRoomUser;
import com.ry.cds.user.service.IClassRoomUserService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ClassRoomUserServiceTest {

	@Autowired
	IClassRoomUserService classRoomUserService;

	@Test
	public void insertTest() throws Exception {
		ClassRoomUser classRoomUser = new ClassRoomUser();
		classRoomUser.setClassRoomID(1);
		classRoomUser.setUserID(1);
		classRoomUser.setUserTypeID(1);
		classRoomUser.setTeacherTypeID(1);
		classRoomUser.setStatusFlag(1);
		int result = classRoomUserService.insert(classRoomUser);
		assertTrue(result > 0);
	}

}
