package com.byefan.xhoa.entity.sys;

import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import com.byefan.core.annotation.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Table(name = "sys_dept")
public class Dept implements Serializable {
    @Id
    private Integer id;

    private String code;

    private String type;

    private String name;

    private Integer parentId;

    private Integer level;

    private Integer state;

    private Integer creator;

    private Date createTime;

    private Integer updateUserId;

    private Date updateTime;

    private Integer mgrId ;

    private String mgrName ;

    private Integer mgrLeaderId ;

    private String mgrLeaderName ;

    private String mediaType ;
    /**
     * 部门下的子部门
     */
    @Transient
    private List<Dept> depts = new ArrayList<Dept>();
    /**
     * 部门下的所有直接或间接下级部门
     */
    @Transient
    private List<Dept> childDepts = new ArrayList<Dept>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public List<Dept> getDepts() {
        return depts;
    }

    public void setDepts(List<Dept> depts) {
        this.depts = depts;
    }

    public List<Dept> getChildDepts() {
        return childDepts;
    }

    public void setChildDepts(List<Dept> childDepts) {
        this.childDepts = childDepts;
    }

    public Integer getMgrId() {
        return mgrId;
    }

    public void setMgrId(Integer mgrId) {
        this.mgrId = mgrId;
    }

    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    public Integer getMgrLeaderId() {
        return mgrLeaderId;
    }

    public void setMgrLeaderId(Integer mgrLeaderId) {
        this.mgrLeaderId = mgrLeaderId;
    }

    public String getMgrLeaderName() {
        return mgrLeaderName;
    }

    public void setMgrLeaderName(String mgrLeaderName) {
        this.mgrLeaderName = mgrLeaderName;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}