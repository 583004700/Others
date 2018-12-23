package com.byefan.xhoa.entity.crm;

import com.alibaba.fastjson.annotation.JSONField;

import com.byefan.core.annotation.Column;
import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 客户用户信息
 */
@Table(name = "t_crm_cust_users")
public class CustUsers implements Serializable{
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "age")
    private Integer age;
    @Column(name = "sex")
    private Integer sex = Const.SEX_MAN;
    @Column(name = "area")
    private String area;
    @Column(name = "cultural_level")
    private String culturalLevel;
    @Column(name = "ujob")
    private String ujob;
    @Column(name = "hobby")
    private String hobby;
    @Column(name = "topic")
    private String topic;
    @Column(name = "company_id")
    private Integer companyId;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime = new Date();
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date updateTime = new Date();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCulturalLevel() {
        return culturalLevel;
    }

    public void setCulturalLevel(String culturalLevel) {
        this.culturalLevel = culturalLevel;
    }

    public String getUjob() {
        return ujob;
    }

    public void setUjob(String ujob) {
        this.ujob = ujob;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustUsers custUsers = (CustUsers) o;

        if (id != null ? !id.equals(custUsers.id) : custUsers.id != null) return false;
        if (age != null ? !age.equals(custUsers.age) : custUsers.age != null) return false;
        if (sex != null ? !sex.equals(custUsers.sex) : custUsers.sex != null) return false;
        if (area != null ? !area.equals(custUsers.area) : custUsers.area != null) return false;
        if (culturalLevel != null ? !culturalLevel.equals(custUsers.culturalLevel) : custUsers.culturalLevel != null)
            return false;
        if (ujob != null ? !ujob.equals(custUsers.ujob) : custUsers.ujob != null) return false;
        if (hobby != null ? !hobby.equals(custUsers.hobby) : custUsers.hobby != null) return false;
        if (topic != null ? !topic.equals(custUsers.topic) : custUsers.topic != null) return false;
        if (companyId != null ? !companyId.equals(custUsers.companyId) : custUsers.companyId != null) return false;
        if (createTime != null ? !createTime.equals(custUsers.createTime) : custUsers.createTime != null) return false;
        return updateTime != null ? updateTime.equals(custUsers.updateTime) : custUsers.updateTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (culturalLevel != null ? culturalLevel.hashCode() : 0);
        result = 31 * result + (ujob != null ? ujob.hashCode() : 0);
        result = 31 * result + (hobby != null ? hobby.hashCode() : 0);
        result = 31 * result + (topic != null ? topic.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
