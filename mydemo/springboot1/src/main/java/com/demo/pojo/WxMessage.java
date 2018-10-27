package com.demo.pojo;

import java.io.Serializable;
import java.util.Date;

public class WxMessage implements Serializable{
    private Integer id;

    private String tousername;

    private String fromusername;

    private Date createtime;

    private String msgtype;

    private String content;

    private String msgid;

    private String event;

    private String latitude;

    private String longitude;

    private String precision;

    public WxMessage() {
    }

    public WxMessage(String tousername, String fromusername, Date createtime, String msgtype, String content, String msgid, String event, String latitude, String longitude, String precision) {
        this.tousername = tousername;
        this.fromusername = fromusername;
        this.createtime = createtime;
        this.msgtype = msgtype;
        this.content = content;
        this.msgid = msgid;
        this.event = event;
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTousername() {
        return tousername;
    }

    public void setTousername(String tousername) {
        this.tousername = tousername == null ? null : tousername.trim();
    }

    public String getFromusername() {
        return fromusername;
    }

    public void setFromusername(String fromusername) {
        this.fromusername = fromusername == null ? null : fromusername.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype == null ? null : msgtype.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid == null ? null : msgid.trim();
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision == null ? null : precision.trim();
    }
}