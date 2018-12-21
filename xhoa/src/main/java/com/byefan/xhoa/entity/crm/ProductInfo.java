package com.byefan.xhoa.entity.crm;

import com.alibaba.fastjson.annotation.JSONField;

import com.byefan.core.annotation.Column;
import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_crm_product_info")
public class ProductInfo implements Serializable{
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "category")
    private String category;
    @Column(name = "suit_users")
    private String suitUsers;
    //适用场景
    @Column(name = "suit_scene")
    private String suitScene;
    @Column(name = "pack_style")
    private String packStyle;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "func")
    private String func;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSuitUsers() {
        return suitUsers;
    }

    public void setSuitUsers(String suitUsers) {
        this.suitUsers = suitUsers;
    }

    public String getSuitScene() {
        return suitScene;
    }

    public void setSuitScene(String suitScene) {
        this.suitScene = suitScene;
    }

    public String getPackStyle() {
        return packStyle;
    }

    public void setPackStyle(String packStyle) {
        this.packStyle = packStyle;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
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

        ProductInfo that = (ProductInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (suitUsers != null ? !suitUsers.equals(that.suitUsers) : that.suitUsers != null) return false;
        if (suitScene != null ? !suitScene.equals(that.suitScene) : that.suitScene != null) return false;
        if (packStyle != null ? !packStyle.equals(that.packStyle) : that.packStyle != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (func != null ? !func.equals(that.func) : that.func != null) return false;
        if (companyId != null ? !companyId.equals(that.companyId) : that.companyId != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        return updateTime != null ? updateTime.equals(that.updateTime) : that.updateTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (suitUsers != null ? suitUsers.hashCode() : 0);
        result = 31 * result + (suitScene != null ? suitScene.hashCode() : 0);
        result = 31 * result + (packStyle != null ? packStyle.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (func != null ? func.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
