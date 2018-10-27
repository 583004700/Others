package com.demo.wx.controller;

import com.demo.wx.entity.LocationMessage;
import com.demo.wx.entity.TextMessage;
import com.demo.wx.service.WxMessageService;
import com.demo.wx.util.ChartUtil;
import com.demo.wx.util.DateUtil;
import com.demo.wx.util.WxMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@EnableAutoConfiguration
public class ChartController {
    @Autowired
    WxMessageService wxMessageService;

    @RequestMapping("/")
    String home(@RequestBody String message) throws Exception{
        System.out.println(message);
        String msgType = WxMessageUtil.getElementValue(message,"MsgType");

        if(msgType.equals("text")){
            TextMessage textMessage = WxMessageUtil.parseTextMessage(message);

            String outStr = ChartUtil.chartText(textMessage.getContent());
            wxMessageService.addTextMessage(textMessage);
            String returnMessage = "<xml><ToUserName><![CDATA["+textMessage.getFromUserName()+"]]></ToUserName><FromUserName><![CDATA["+textMessage.getToUserName()+"]]>" +
                    "</FromUserName> " +
                    "<CreateTime>"+ DateUtil.formatWxTime(new Date())+"</CreateTime> " +
                    "<MsgType><![CDATA[text]]></MsgType> " +
                    "<Content><![CDATA["+outStr+"]]></Content></xml>";
            return returnMessage;
        }else if(msgType.equals("event") && WxMessageUtil.getElementValue(message,"Event").equals("LOCATION")){
            LocationMessage locationMessage = WxMessageUtil.parseLocationMessage(message);
            wxMessageService.addLocationMessage(locationMessage);
        }
        return null;
    }
}
