package com.ry.cds;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ry.cds.user.bo.User;
import com.ry.cds.user.dao.IUserDao;
import com.ry.cds.user.service.IUserService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

	@Autowired
	IUserService userService;

	@Autowired
	IUserDao userDao;

	// @Test
	public void getTest() throws Exception {
		User user = userDao.getByUserCode("C000001");
		assertTrue(user.getUserID() > 0);
	}

	// @Test
	public void insertTest() throws Exception {
		User user = userService.get(2);
		long result = userService.insert(user);
		assertTrue(result > 0);
	}

	// @Test
	public void updateTest() throws Exception {
		User user = userService.get(2);
		user.setCardNo("C88888888");
		int result = userService.update(user);
		assertTrue(result > 0);
	}

	@Test
	public void upsetTest() throws Exception {
		User user = userService.get(3);
		user.setUserCode("W2125444");
		user.setMobile("18679137975");
		long result = userDao.upset(user);
		assertTrue(result > 0);
	}
}
