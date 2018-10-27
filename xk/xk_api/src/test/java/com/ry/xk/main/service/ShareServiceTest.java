package com.ry.xk.main.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ry.xk.Application;
import com.ry.xk.main.bo.Course;
import com.ry.xk.main.bo.Partner;
import com.ry.xk.main.bo.PartnerExtension;
import com.ry.xk.main.bo.PartnerImage;
import com.ry.xk.main.dao.IPartnerDao;
import com.ry.xk.main.dao.PartnerDao;
import com.ry.xk.studentexamresult.bo.StudentExamItem;
import com.ry.xk.studentexamresult.dao.IShareDao;
import com.ry.xk.studentexamresult.dao.ShareDao;
import com.ry.xk.studentexamresult.mapper.ExamPaperMapper;
import com.ry.xk.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ShareServiceTest {


    @Mock
    IShareDao shareDao;

    @Autowired
    @InjectMocks
    IShareService shareService;

    @Test
    public void getShareImage() throws Exception{
        int partnerId = 2;
        // PartnerExtension partnerExtension = JSON.parseObject("{\"image\":[{\"type\":1,\"url\":\"www.baidu.com\"}]}", PartnerExtension.class);
        PartnerExtension partnerExtension = JSON.parseObject("{\"WeChatMenuButton\":\"{\\\"button\\\":[{\\\"type\\\":\\\"view\\\",\\\"name\\\":\\\"学考题库\\\",\\\"url\\\":\\\"[list]\\\"},{\\\"type\\\":\\\"view\\\",\\\"name\\\":\\\"已购买试卷\\\",\\\"url\\\":\\\"[buyed]\\\"},{\\\"type\\\":\\\"view\\\",\\\"name\\\":\\\"错题本\\\",\\\"url\\\":\\\"[wrongbook]\\\"}]}\",\"shareImages\":[{\"type\":1,\"url\":\"25e06ef827a84506abd2828f5378b9ed.png\"},{\"type\":2,\"url\":\"e51e2e5224db46be91336625b20c99fe.png\"}]}", PartnerExtension.class);
        Mockito.when(shareDao.getImage(partnerId)).thenReturn(partnerExtension.getShareImages());
        String imageAddress = shareService.getShareImage(partnerId,1);
        System.out.println(imageAddress);
    }
}
