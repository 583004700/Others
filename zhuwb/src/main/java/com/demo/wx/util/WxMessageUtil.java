package com.demo.wx.util;

import com.demo.wx.entity.LocationMessage;
import com.demo.wx.entity.TextMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class WxMessageUtil {
    /**
     * 解析文本消息
     * @param message
     * @return
     */
    public static TextMessage parseTextMessage(String message){
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(getElementValue(message,"ToUserName"));
        textMessage.setFromUserName(getElementValue(message,"FromUserName"));
        textMessage.setCreateTime(DateUtil.parseWxTime(getElementValue(message,"CreateTime")));
        textMessage.setMsgType(getElementValue(message,"MsgType"));
        textMessage.setContent(getElementValue(message,"Content"));
        textMessage.setMsgId(getElementValue(message,"MsgId"));
        return textMessage;
    }

    /**
     * 解析地理位置信息
     * @param message
     * @return
     */
    public static LocationMessage parseLocationMessage(String message){
        LocationMessage locationMessage = new LocationMessage();
        locationMessage.setToUserName(getElementValue(message,"ToUserName"));
        locationMessage.setFromUserName(getElementValue(message,"FromUserName"));
        locationMessage.setCreateTime(DateUtil.parseWxTime(getElementValue(message,"CreateTime")));
        locationMessage.setMsgType(getElementValue(message,"MsgType"));
        locationMessage.setEvent(getElementValue(message,"Event"));
        locationMessage.setLatitude(getElementValue(message,"Latitude"));
        locationMessage.setLongitude(getElementValue(message,"Longitude"));
        locationMessage.setPrecision(getElementValue(message,"Precision"));
        return locationMessage;
    }

    /**
     * 从message中获取属性值
     * @param message
     * @param element
     * @return
     * @throws DocumentException
     */
    public static String getElementValue(String message,String element){
        String elementValue = "";
        try {
            Document doc = DocumentHelper.parseText(message);
            Element rootElt = doc.getRootElement();
            elementValue = rootElt.element(element).getText();
        }catch (DocumentException e){
            e.printStackTrace();
        }
        return elementValue;
    }
}
