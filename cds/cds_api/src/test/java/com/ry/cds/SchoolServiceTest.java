package com.ry.cds;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ry.cds.user.bo.School;
import com.ry.cds.user.dao.ISchoolDao;
import com.ry.cds.user.service.ISchoolService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SchoolServiceTest {

	@Autowired
	ISchoolService schoolService;

	@Autowired
	ISchoolDao schoolDao;

	@Test
	public void getTest() throws Exception {
		School school = schoolDao.getBySchoolCode("S201803060001");
		assertTrue(school.getSchoolID() > 0);
	}

	@Test
	public void insertTest() throws Exception {
		School school = new School();
		school.setSchoolID(1L);
		school.setSchoolCode("S201803060001");
		school.setSchoolName("南昌一中");
		school.setStatusFlag(0);
		school.setLocationID("0791");
		school.setSchoolTypeID(1);
		school.setAddress("南昌市高新区");
		school.setPickupAddress("京东大道中凯蓝域");
		long result = schoolService.insert(school);
		assertTrue(result > 0);
	}

	@Test
	public void updateTest() throws Exception {
		insertTest();
		School school = new School();
		school.setSchoolID(1L);
		school.setSchoolCode("S201803060001");
		school.setSchoolName("南昌一中");
		school.setStatusFlag(1);
		school.setLocationID("0791");
		school.setSchoolTypeID(1);
		school.setAddress("南昌市高新区");
		school.setPickupAddress("京东大道中凯蓝域");
		int result = schoolService.update(school);
		assertTrue(result > 0);
	}

}
