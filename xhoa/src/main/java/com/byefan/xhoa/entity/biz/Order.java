package com.byefan.xhoa.entity.biz;

import com.alibaba.fastjson.annotation.JSONField;
import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import com.byefan.core.annotation.Transient;
import com.byefan.core.utils.DateUtils;
import com.byefan.xhoa.entity.sys.Dept;
import com.byefan.xhoa.entity.sys.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Table(name = "t_biz_order")
public class Order implements Serializable {
    @Id
    private Integer id;

    private String no;

    private Integer creator;

    @JSONField(format = DateUtils.DEFAULT)
    private Date createDate;

    private Integer companyId;

    private String companyName;

    private Integer custId;

    private String custName;

    private Integer userId;

    private Integer depatId;

    private String userName;

    private String desc;

    private Integer state;

    private Float amount;

    private Integer orderType;

    private String title;
    @JSONField(format = DateUtils.DATE_SMALL)
    private Date updateDate;
    private Integer updateUserId;

    @Transient
    private List<Article> articles = new ArrayList<>();

    @Transient
    private User user;
    @Transient
    private User updateUser;
    @Transient
    private Dept dept;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getDepatId() {
        return depatId;
    }

    public void setDepatId(Integer depatId) {
        this.depatId = depatId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(User updateUser) {
        this.updateUser = updateUser;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(no, order.no) &&
                Objects.equals(creator, order.creator) &&
                Objects.equals(createDate, order.createDate) &&
                Objects.equals(companyId, order.companyId) &&
                Objects.equals(companyName, order.companyName) &&
                Objects.equals(custId, order.custId) &&
                Objects.equals(custName, order.custName) &&
                Objects.equals(userId, order.userId) &&
                Objects.equals(depatId, order.depatId) &&
                Objects.equals(userName, order.userName) &&
                Objects.equals(desc, order.desc) &&
                Objects.equals(state, order.state) &&
                Objects.equals(amount, order.amount) &&
                Objects.equals(orderType, order.orderType) &&
                Objects.equals(title, order.title) &&
                Objects.equals(updateDate, order.updateDate) &&
                Objects.equals(updateUserId, order.updateUserId) &&
                Objects.equals(articles, order.articles) &&
                Objects.equals(user, order.user) &&
                Objects.equals(updateUser, order.updateUser) &&
                Objects.equals(dept, order.dept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, no, creator, createDate, companyId, companyName, custId, custName, userId, depatId, userName, desc, state, amount, orderType, title, updateDate, updateUserId, articles, user, updateUser, dept);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", creator=" + creator +
                ", createDate=" + createDate +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", custId=" + custId +
                ", custName='" + custName + '\'' +
                ", userId=" + userId +
                ", depatId=" + depatId +
                ", userName='" + userName + '\'' +
                ", desc='" + desc + '\'' +
                ", state=" + state +
                ", amount=" + amount +
                ", orderType=" + orderType +
                ", title='" + title + '\'' +
                ", updateDate=" + updateDate +
                ", updateUserId=" + updateUserId +
                ", articles=" + articles +
                ", user=" + user +
                ", updateUser=" + updateUser +
                ", dept=" + dept +
                '}';
    }
}