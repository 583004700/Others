package com.demo.wx.entity;

public class LocationMessage extends WxMessage{
    private String event;
    private String latitude;
    private String longitude;
    private String precision;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    public void setPrecision(String precision) {
        this.precision = precision;
    }
}
