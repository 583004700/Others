package com.byefan.xhoa.entity.media;

import com.alibaba.fastjson.annotation.JSONField;

import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 供应商表
 */
@Table(name = "t_media_supplier")
public class Supplier implements Serializable {
    @Id
    private Integer id;

    private Integer mediaTypeId;

    private String name;

    private String desc;

    private String contactor;

    private Long phone;

    private String qqwechat;

    private String contactorDesc;

    private Integer state ;

    private Integer creator ;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime ;

    private Integer updateUserId ;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(Integer mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContactor() {
        return contactor;
    }

    public void setContactor(String contactor) {
        this.contactor = contactor == null ? null : contactor.trim();
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getQqwechat() {
        return qqwechat;
    }

    public void setQqwechat(String qqwechat) {
        this.qqwechat = qqwechat == null ? null : qqwechat.trim();
    }

    public String getContactorDesc() {
        return contactorDesc;
    }

    public void setContactorDesc(String contactorDesc) {
        this.contactorDesc = contactorDesc == null ? null : contactorDesc.trim();
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}