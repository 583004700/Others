package com.demo.wx.entity;

/**
 * 文本消息
 */
public class TextMessage extends WxMessage{

    private String content;
    private String msgId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
