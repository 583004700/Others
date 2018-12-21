package com.byefan.xhoa.entity.crm;

import com.alibaba.fastjson.annotation.JSONField;
import com.byefan.core.annotation.Column;
import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import com.byefan.core.annotation.Transient;
import com.byefan.xhoa.entity.sys.User;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 对接人信息
 */
@Table(name = "t_crm_docking_people")
public class DockingPeople implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "cust_name")
    private String custName;
    @Column(name = "department")
    private String department;
    @Column(name = "fproject")
    private String fproject;
    @Column(name = "job")
    private String job;
    //客户级别（字典表）
    @Column(name = "cust_level")
    private Integer custLevel;
    //客户状态 0有效 1待开发 2流失
    @Column(name = "status")
    private Integer status = Const.CUST_STATUS_DEVELOP;
    //客户类型（字典表）
    @Column(name = "cust_type")
    private Integer custType;
    //客户性质（1公海2非公海）
    @Column(name = "cust_property")
    private Integer custProperty = Const.CUST_PROPERTY_FEIGONGHAI;
    //创建人
    @Column(name = "create_worker")
    private Integer createWorker;
    //负责人
    @Column(name = "worker")
    private Integer worker;
    //性格
    @Column(name = "kidney")
    private String kidney;
    @Column(name = "age")
    private Integer age;
    @Column(name = "home")
    private String home;
    //联系方式
    @Column(name = "connection_type")
    private String connectionType;
    //专业程度
    @Column(name = "profession_level")
    private String professionLevel;
    @Column(name = "cultural")
    private String cultural;
    @Column(name = "hobby")
    private String hobby;
    @Column(name = "looks")
    private String looks;
    @Column(name = "old_company")
    private String oldCompany;
    //成交详情
    @Column(name = "success_detail")
    private String successDetail;
    //意向度
    @Column(name = "like_level")
    private String likeLevel;
    //是否重复(1是2否)
    @Column(name = "repeat_flag")
    private Integer repeatFlag = Const.REPEATLAG_NO;
    //对接人所在的公司，系统中录入过的
    @Column(name = "company_id")
    private Integer companyId;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime = new Date();
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date updateTime = new Date();
    @Column(name = "photo")
    private String photo;
    @Column(name = "delete_flag")
    private Integer deleteFlag = 0;
    @Transient
    private User user;

    //对应的客户信息
    @Transient
    private Cust cust;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFproject() {
        return fproject;
    }

    public void setFproject(String fproject) {
        this.fproject = fproject;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(Integer custLevel) {
        this.custLevel = custLevel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCustType() {
        return custType;
    }

    public void setCustType(Integer custType) {
        this.custType = custType;
    }

    public Integer getCustProperty() {
        return custProperty;
    }

    public void setCustProperty(Integer custProperty) {
        this.custProperty = custProperty;
    }

    public Integer getCreateWorker() {
        return createWorker;
    }

    public void setCreateWorker(Integer createWorker) {
        this.createWorker = createWorker;
    }

    public Integer getWorker() {
        return worker;
    }

    public void setWorker(Integer worker) {
        this.worker = worker;
    }

    public String getKidney() {
        return kidney;
    }

    public void setKidney(String kidney) {
        this.kidney = kidney;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getProfessionLevel() {
        return professionLevel;
    }

    public void setProfessionLevel(String professionLevel) {
        this.professionLevel = professionLevel;
    }

    public String getCultural() {
        return cultural;
    }

    public void setCultural(String cultural) {
        this.cultural = cultural;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getLooks() {
        return looks;
    }

    public void setLooks(String looks) {
        this.looks = looks;
    }

    public String getOldCompany() {
        return oldCompany;
    }

    public void setOldCompany(String oldCompany) {
        this.oldCompany = oldCompany;
    }

    public String getSuccessDetail() {
        return successDetail;
    }

    public void setSuccessDetail(String successDetail) {
        this.successDetail = successDetail;
    }

    public String getLikeLevel() {
        return likeLevel;
    }

    public void setLikeLevel(String likeLevel) {
        this.likeLevel = likeLevel;
    }

    public Integer getRepeatFlag() {
        return repeatFlag;
    }

    public void setRepeatFlag(Integer repeatFlag) {
        this.repeatFlag = repeatFlag;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Cust getCust() {
        return cust;
    }

    public void setCust(Cust cust) {
        this.cust = cust;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DockingPeople that = (DockingPeople) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(custName, that.custName) &&
                Objects.equals(department, that.department) &&
                Objects.equals(fproject, that.fproject) &&
                Objects.equals(job, that.job) &&
                Objects.equals(custLevel, that.custLevel) &&
                Objects.equals(status, that.status) &&
                Objects.equals(custType, that.custType) &&
                Objects.equals(custProperty, that.custProperty) &&
                Objects.equals(createWorker, that.createWorker) &&
                Objects.equals(worker, that.worker) &&
                Objects.equals(kidney, that.kidney) &&
                Objects.equals(age, that.age) &&
                Objects.equals(home, that.home) &&
                Objects.equals(connectionType, that.connectionType) &&
                Objects.equals(professionLevel, that.professionLevel) &&
                Objects.equals(cultural, that.cultural) &&
                Objects.equals(hobby, that.hobby) &&
                Objects.equals(looks, that.looks) &&
                Objects.equals(oldCompany, that.oldCompany) &&
                Objects.equals(successDetail, that.successDetail) &&
                Objects.equals(likeLevel, that.likeLevel) &&
                Objects.equals(repeatFlag, that.repeatFlag) &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(photo, that.photo) &&
                Objects.equals(deleteFlag, that.deleteFlag) &&
                Objects.equals(user, that.user) &&
                Objects.equals(cust, that.cust);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, custName, department, fproject, job, custLevel, status, custType, custProperty, createWorker, worker, kidney, age, home, connectionType, professionLevel, cultural, hobby, looks, oldCompany, successDetail, likeLevel, repeatFlag, companyId, createTime, updateTime, photo, deleteFlag, user, cust);
    }
}
