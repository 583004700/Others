package com.byefan.xhoa.entity.fee;

import com.alibaba.fastjson.annotation.JSONField;

import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "fee_income_article")
public class IncomeArticle implements Serializable {
    @Id
    private Integer id;
    private Integer incomeId ;
    private Integer articleId ;
    private Double amount ;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date ;
    private Integer state ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
