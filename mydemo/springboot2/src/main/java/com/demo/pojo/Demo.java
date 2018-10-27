package com.demo.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Demo {
    private int id;
    private String name;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date createTime;
    @JSONField(serialize = false)  //不需要序列化
    private String remarks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
