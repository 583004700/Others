package com.byefan.xhoa.entity.crm;

import com.alibaba.fastjson.annotation.JSONField;

import com.byefan.core.annotation.Column;
import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import com.byefan.core.annotation.Transient;
import com.byefan.xhoa.entity.sys.Dept;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 客户信息
 */
@Table(name = "t_crm_cust")
public class Cust implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "industry")
    private String industry;
    @Column(name = "product")
    private String product;
    @Column(name="company_build")
    private String companyBuild;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "transmission_goal")
    private String transmissionGoal;
    @Column(name = "size")
    private String size;
    @Column(name = "throw_count")
    private Integer throwCount;
    @Column(name = "area")
    private String area;
    @Column(name = "experience")
    private String experience;
    @Column(name = "public_medium")
    private String publicMedium;
    @Column(name = "throw_ditch")
    private String throwDitch;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime = new Date();
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time")
    private Date updateTime = new Date();
    @Transient
    private Dept dept;
    @Transient
    private List<DockingPeople> dockingPeoples;
    @Transient
    private List<ProductInfo> productInfos;
    @Transient
    private List<CustUsers> custUsers;

    public Cust(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCompanyBuild() {
        return companyBuild;
    }

    public void setCompanyBuild(String companyBuild) {
        this.companyBuild = companyBuild;
    }

    public String getTransmissionGoal() {
        return transmissionGoal;
    }

    public void setTransmissionGoal(String transmissionGoal) {
        this.transmissionGoal = transmissionGoal;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getThrowCount() {
        return throwCount;
    }

    public void setThrowCount(Integer throwCount) {
        this.throwCount = throwCount;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPublicMedium() {
        return publicMedium;
    }

    public void setPublicMedium(String publicMedium) {
        this.publicMedium = publicMedium;
    }

    public String getThrowDitch() {
        return throwDitch;
    }

    public void setThrowDitch(String throwDitch) {
        this.throwDitch = throwDitch;
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

    public List<DockingPeople> getDockingPeoples() {
        return dockingPeoples;
    }

    public void setDockingPeoples(List<DockingPeople> dockingPeoples) {
        this.dockingPeoples = dockingPeoples;
    }

    public List<ProductInfo> getProductInfos() {
        return productInfos;
    }

    public void setProductInfos(List<ProductInfo> productInfos) {
        this.productInfos = productInfos;
    }

    public List<CustUsers> getCustUsers() {
        return custUsers;
    }

    public void setCustUsers(List<CustUsers> custUsers) {
        this.custUsers = custUsers;
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
        Cust cust = (Cust) o;
        return Objects.equals(id, cust.id) &&
                Objects.equals(companyName, cust.companyName) &&
                Objects.equals(industry, cust.industry) &&
                Objects.equals(product, cust.product) &&
                Objects.equals(companyBuild, cust.companyBuild) &&
                Objects.equals(projectName, cust.projectName) &&
                Objects.equals(transmissionGoal, cust.transmissionGoal) &&
                Objects.equals(size, cust.size) &&
                Objects.equals(throwCount, cust.throwCount) &&
                Objects.equals(area, cust.area) &&
                Objects.equals(experience, cust.experience) &&
                Objects.equals(publicMedium, cust.publicMedium) &&
                Objects.equals(throwDitch, cust.throwDitch) &&
                Objects.equals(createTime, cust.createTime) &&
                Objects.equals(updateTime, cust.updateTime) &&
                Objects.equals(dept, cust.dept) &&
                Objects.equals(dockingPeoples, cust.dockingPeoples) &&
                Objects.equals(productInfos, cust.productInfos) &&
                Objects.equals(custUsers, cust.custUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, industry, product, companyBuild, projectName, transmissionGoal, size, throwCount, area, experience, publicMedium, throwDitch, createTime, updateTime, dept, dockingPeoples, productInfos, custUsers);
    }
}
