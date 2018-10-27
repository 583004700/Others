package com.ry.cds.testMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ry.cds.Application;
import com.ry.cds.user.bo.ClassRoom;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestMapper {
	//因为有一个相同的classRoomMapper
	@Autowired
	ClassRoomMapper1 classRoomMapper1;
	/**
	 * 测试通过ID查找单条记录
	 * 
	 * @return
	 */
	//@Test
	public void findByPrimaryKey() throws Exception {
		ClassRoom classroomObj = classRoomMapper1.findByPrimaryKey("classRoomCode,classRoomName,createDateTime","1");
		System.out.println(classroomObj.getCreateDateTime());
		System.out.println(classroomObj.getClassRoomName());
		System.out.println(classroomObj.getClassRoomCode());
	}
	/**
	 * 测试通过列名查找单条记录
	 */
	//@Test
	public void findSingByColumnName() {
		ClassRoom classroomObj = classRoomMapper1.findSingByColumnName("classRoomCode,classRoomName,createDateTime","classroomcode","410460");
		System.out.println(classroomObj.getCreateDateTime());
		System.out.println(classroomObj.getClassRoomName());
		System.out.println(classroomObj.getClassRoomCode());
	}
	/**
	 * 测试添加单条记录
	 * @throws Exception
	 */
	//@Test
	public void addOne() throws Exception {
		ClassRoom classroom = new ClassRoom();
		classroom.setClassRoomCode("12345");
		classroom.setClassRoomName("测试一班");
		classroom.setClassRoomTypeID(1);
		int k = classRoomMapper1.addOne(classroom);
		System.out.println(k);
	}

	/**
	 * 测试更新单条记录
	 * @throws Exception
	 */
	@Test
	public void updateOne() throws Exception {
		//查找classRoomCode为123456789的记录
		ClassRoom classroomObj = classRoomMapper1.findSingByColumnName("classRoomCode","classRoomCode","123456");
		classroomObj.setClassRoomName("测试更新110");
		classroomObj.setClassRoomCode("12345605514");
		int k = classRoomMapper1.updateOne(classroomObj,String.valueOf(classroomObj.getClassRoomID()));

		ClassRoom classRoomObj2 = classRoomMapper1.findByPrimaryKey("","403");
		classRoomObj2.setClassRoomName("测试更新22");
		int m = classRoomMapper1.updateOne(classRoomObj2,String.valueOf(classRoomObj2.getClassRoomID()));
		System.out.println(k);
		System.out.println(m);
	}
}