package com.ry.cds;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ry.cds.user.bo.ClassRoom;
import com.ry.cds.user.dao.ClassRoomDao;
import com.ry.cds.user.service.IClassRoomService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ClassRoomServiceTest {

	@Autowired
	IClassRoomService classRoomService;
	@Autowired
	ClassRoomDao classRoomDao;

	// @Test
	public void getTest() throws Exception {
		ClassRoom classRoom = classRoomDao.getByClassRoomCode("C201803060001");
		assertTrue(classRoom.getClassRoomID() > 0);
	}

	@Test
	public void insertTest() throws Exception {
		ClassRoom classRoom = new ClassRoom();
		classRoom.setClassRoomID(1L);
		classRoom.setClassRoomCode("C201803060001");
		classRoom.setClassRoomName("高二一班");
		classRoom.setClassRoomTypeID(1);
		classRoom.setStatusFlag(0);
		classRoom.setSchoolID(1L);
		long classRoomID = classRoomService.insert(classRoom);
		assertTrue(classRoomID > 0);
	}

	// @Test
	public void updateTest() throws Exception {
		insertTest();
		ClassRoom classRoom = new ClassRoom();
		classRoom.setClassRoomID(1L);
		classRoom.setClassRoomCode("C201803060001");
		classRoom.setClassRoomName("高二一班");
		classRoom.setClassRoomTypeID(1);
		classRoom.setStatusFlag(1);
		classRoom.setSchoolID(1L);
		int result = classRoomService.update(classRoom);
		assertTrue(result > 0);
	}
}
