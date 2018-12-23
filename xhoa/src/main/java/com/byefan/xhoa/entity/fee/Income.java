package com.byefan.xhoa.entity.fee;

import com.alibaba.fastjson.annotation.JSONField;

import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Table(name = "fee_income")
public class Income implements Serializable {
    @Id
    private Integer id;
    private Integer accountId;
    private String accountName;
    private String bankNo;
    private String code;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date tradeTime;
    private String tradeBank;
    private String tradeMan;
    private Double tradeAmount;
    private Double unclaimedAmount;
    private Double preclaimedAmount;
    private Integer custCompanyId;
    private String custCompanyName;
    private Integer state;
    private Integer creator;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private Integer updateUserId;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String taskId ;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getTradeBank() {
        return tradeBank;
    }

    public void setTradeBank(String tradeBank) {
        this.tradeBank = tradeBank;
    }

    public String getTradeMan() {
        return tradeMan;
    }

    public void setTradeMan(String tradeMan) {
        this.tradeMan = tradeMan;
    }

    public Double getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(Double tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public Double getUnclaimedAmount() {
        return unclaimedAmount;
    }

    public void setUnclaimedAmount(Double unclaimedAmount) {
        this.unclaimedAmount = unclaimedAmount;
    }

    public Double getPreclaimedAmount() {
        return preclaimedAmount;
    }

    public void setPreclaimedAmount(Double preclaimedAmount) {
        this.preclaimedAmount = preclaimedAmount;
    }

    public Integer getCustCompanyId() {
        return custCompanyId;
    }

    public void setCustCompanyId(Integer custCompanyId) {
        this.custCompanyId = custCompanyId;
    }

    public String getCustCompanyName() {
        return custCompanyName;
    }

    public void setCustCompanyName(String custCompanyName) {
        this.custCompanyName = custCompanyName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Income income = (Income) o;
        return Objects.equals(id, income.id) &&
                Objects.equals(accountId, income.accountId) &&
                Objects.equals(accountName, income.accountName) &&
                Objects.equals(bankNo, income.bankNo) &&
                Objects.equals(code, income.code) &&
                Objects.equals(tradeTime, income.tradeTime) &&
                Objects.equals(tradeBank, income.tradeBank) &&
                Objects.equals(tradeMan, income.tradeMan) &&
                Objects.equals(tradeAmount, income.tradeAmount) &&
                Objects.equals(unclaimedAmount, income.unclaimedAmount) &&
                Objects.equals(preclaimedAmount, income.preclaimedAmount) &&
                Objects.equals(custCompanyId, income.custCompanyId) &&
                Objects.equals(custCompanyName, income.custCompanyName) &&
                Objects.equals(state, income.state) &&
                Objects.equals(creator, income.creator) &&
                Objects.equals(createTime, income.createTime) &&
                Objects.equals(updateUserId, income.updateUserId) &&
                Objects.equals(updateTime, income.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, accountName, bankNo, code, tradeTime, tradeBank, tradeMan, tradeAmount, unclaimedAmount, preclaimedAmount, custCompanyId, custCompanyName, state, creator, createTime, updateUserId, updateTime);
    }
}
