package com.ry.xk.main.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.never;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ry.xk.Application;
import com.ry.xk.main.bo.User;
import com.ry.xk.main.bo.UserBindDetail;
import com.ry.xk.main.dao.IUserBindDetailDao;
import com.ry.xk.main.dao.IUserDao;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest
{
    @Mock
    IUserDao userDao;

    @Mock
    IUserBindDetailDao userBindDetailDao;

    @Before
    public void setUp()
        throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @Autowired
    @InjectMocks
    IUserService userService;

    /**
     * 已经绑定过了的用户
     * 
     * @Title: checkAndBindUserwhenAlreadyBind
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void checkAndBindUserwhenAlreadyBind()
        throws Exception
    {
        Mockito.when(userBindDetailDao.getUserIdByOpenId("openId")).thenReturn(1);
        int result = userService.checkAndBindUser(1, "openId");
        Mockito.verify(userDao, never()).insert(Mockito.any(User.class));
        assertEquals(1, result);
    }

    /**
     * 未绑定过的用户
     * 
     * @Title: checkAndBindUserwhenAlreadyBind
     * @author 幸仁强
     * @throws Exception
     */
    @Test
    public void checkAndBindUserWithNoBind()
        throws Exception
    {

        Mockito.when(userBindDetailDao.getUserIdByOpenId("openId")).thenReturn(0);
        Mockito.when(userDao.insert(Mockito.any(User.class))).thenReturn(2);
        Mockito.when(userBindDetailDao.insert(Mockito.any(UserBindDetail.class))).thenReturn(1);
        int result = userService.checkAndBindUser(1, "openId");
        Mockito.verify(userBindDetailDao).insert(Mockito.any(UserBindDetail.class));
        assertEquals(2, result);
    }
}
