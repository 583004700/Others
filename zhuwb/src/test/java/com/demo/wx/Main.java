package com.demo.wx;

import com.demo.wx.mapper.WxMessageMapper;
import com.demo.wx.model.WxMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Main {
    @Autowired
    WxMessageMapper wxMessageMapper;
    @Test
    public void testMapping(){
//       WxMessage wxMessage = new WxMessage("sdf","odsf",new Date(),
//               "sf", "cote", "sdof", "dfs", "sodf", "osdjfi", "osdi");
//       wxMessageMapper.insertSelective(wxMessage);
    }
}
