package com.byefan.xhoa.entity.fee;

import com.alibaba.fastjson.annotation.JSONField;

import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name="fee_reimburse")
public class Reimburse implements Serializable {
    @Id
    private Integer id ;
    private String code ;
    private String title ;
    private Integer type ;
    private Integer recId ;
    private String recName ;
    private String recBankNo ;
    private String recBankName ;
    private Integer applyId ;
    private String applyName ;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date applyTime ;
    private Double applyAmount ;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date expertPayTime ;
    private Integer outAccountId ;
    private String outAccountName ;
    private Double payAmount ;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date payTime ;
    private Integer payUserId ;
    private Integer flag ;
    private String remark ;
    private String affix ;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public String getRecBankNo() {
        return recBankNo;
    }

    public void setRecBankNo(String recBankNo) {
        this.recBankNo = recBankNo;
    }

    public String getRecBankName() {
        return recBankName;
    }

    public void setRecBankName(String recBankName) {
        this.recBankName = recBankName;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Double getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(Double applyAmount) {
        this.applyAmount = applyAmount;
    }

    public Date getExpertPayTime() {
        return expertPayTime;
    }

    public void setExpertPayTime(Date expertPayTime) {
        this.expertPayTime = expertPayTime;
    }

    public Integer getOutAccountId() {
        return outAccountId;
    }

    public void setOutAccountId(Integer outAccountId) {
        this.outAccountId = outAccountId;
    }

    public String getOutAccountName() {
        return outAccountName;
    }

    public void setOutAccountName(String outAccountName) {
        this.outAccountName = outAccountName;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getPayUserId() {
        return payUserId;
    }

    public void setPayUserId(Integer payUserId) {
        this.payUserId = payUserId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAffix() {
        return affix;
    }

    public void setAffix(String affix) {
        this.affix = affix;
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
