package com.demo.wx.service;

import com.demo.wx.entity.LocationMessage;
import com.demo.wx.entity.TextMessage;
import com.demo.wx.mapper.WxMessageMapper;
import com.demo.wx.model.WxMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WxMessageService {
    @Autowired
    WxMessageMapper wxMessageMapper;

    /**
     * 添加文本消息
     * @param textMessage
     */
    public void addTextMessage(TextMessage textMessage){
        WxMessage wxMessage = new WxMessage(textMessage.getToUserName(),textMessage.getFromUserName(),new Date(),
                textMessage.getMsgType(), textMessage.getContent(), textMessage.getMsgId(), null, null, null, null);
        wxMessageMapper.insertSelective(wxMessage);
    }

    /**
     * 添加地理位置消息
     * @param locationMessage
     */
    public void addLocationMessage(LocationMessage locationMessage){
        WxMessage wxMessage = new WxMessage(locationMessage.getToUserName(),locationMessage.getFromUserName(),new Date(),
                locationMessage.getMsgType(), null, null, locationMessage.getEvent(), locationMessage.getLatitude(), locationMessage.getLongitude(), locationMessage.getPrecision());
        wxMessageMapper.insertSelective(wxMessage);
    }
}
