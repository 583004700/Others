package com.byefan.xhoa.entity.fee;

import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name="fee_reimburse_d")
public class ReimburseD implements Serializable {
    @Id
    private Integer id ;
    private Integer type ;
    private Integer remId ;
    private String purpose ;
    private Double amount ;
    private Integer billNum ;
    private Integer state ;
    private String title ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRemId() {
        return remId;
    }

    public void setRemId(Integer remId) {
        this.remId = remId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getBillNum() {
        return billNum;
    }

    public void setBillNum(Integer billNum) {
        this.billNum = billNum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
