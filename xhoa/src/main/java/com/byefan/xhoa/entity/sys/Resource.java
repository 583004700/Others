package com.byefan.xhoa.entity.sys;

import com.alibaba.fastjson.annotation.JSONField;

import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Relate;
import com.byefan.core.annotation.Table;
import com.byefan.core.annotation.Transient;

import java.io.Serializable;
import java.util.*;

@Table(name = "sys_resource")
public class Resource implements Serializable {
    @Id
    private Integer id;

    private Integer parentId;

    private String name;

    private String url;

    private String icon;

    private Integer state;
    private Integer isMenu;

    private Integer creator;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Integer updateUserId;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private Integer sort;
    @Transient
    private User user;
    @Transient
    private User updateUser;
    //    @Transient
    @Relate(name = Resource.class, fkName = "parent_id")
    private Resource parent;
    @Transient
    private List<Resource> childs = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Resource getParent() {
        return parent;
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }

    public List<Resource> getChilds() {
        return childs;
    }

    public void setChilds(List<Resource> childs) {
        this.childs = childs;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public User getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(User updateUser) {
        this.updateUser = updateUser;
    }

    public Resource(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Objects.equals(id, resource.id) &&
                Objects.equals(parentId, resource.parentId) &&
                Objects.equals(name, resource.name) &&
                Objects.equals(url, resource.url) &&
                Objects.equals(icon, resource.icon) &&
                Objects.equals(state, resource.state) &&
                Objects.equals(isMenu, resource.isMenu) &&
                Objects.equals(creator, resource.creator) &&
                Objects.equals(createTime, resource.createTime) &&
                Objects.equals(updateUserId, resource.updateUserId) &&
                Objects.equals(updateTime, resource.updateTime) &&
                Objects.equals(sort, resource.sort) &&
                Objects.equals(user, resource.user) &&
                Objects.equals(updateUser, resource.updateUser) &&
                Objects.equals(parent, resource.parent) &&
                Objects.equals(childs, resource.childs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, name, url, icon, state, isMenu, creator, createTime, updateUserId, updateTime, sort, user, updateUser, parent, childs);
    }
}