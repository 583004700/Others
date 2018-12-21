package com.byefan.core.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.byefan.core.annotation.Relate;
import com.byefan.xhoa.entity.sys.User;

import com.byefan.core.annotation.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Gzw
 *
 * @author GZW
 */
@Table(name = "t_log", schema = "xhoa", catalog = "")
public class Log implements Serializable {
    @Id
    @Column(name = "id", columnDefinition = "bigint")
    private long id;
    @Column(name = "user_id")
    private Integer userId;
    @Relate(name = User.class, fkName = "user_id")
    @JSONField(serialzeFeatures = {SerializerFeature.DisableCircularReferenceDetect})
    @Transient
    private User user;
    @Column(name = "op_date")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date opDate;
    @Column(name = "ip")
    private String ip;
    @Column(name = "module")
    private String module;
    @Column(name = "op_type")
    private String opType;
    @Column(name = "note")
    private String note;
    @Column(name = "class_name")
    private String className;
    @Column(name = "method_name")
    private String methodName;
    @Column(name = "args", columnDefinition = "text")
    private String args;
    @Column(name = "url")
    private String url;

    public void setOpDate(Timestamp opDate) {
        this.opDate = opDate;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOpDate() {
        return opDate;
    }

    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }


    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return id == log.id &&
                Objects.equals(userId, log.userId) &&
                Objects.equals(user, log.user) &&
                Objects.equals(opDate, log.opDate) &&
                Objects.equals(ip, log.ip) &&
                Objects.equals(module, log.module) &&
                Objects.equals(opType, log.opType) &&
                Objects.equals(note, log.note) &&
                Objects.equals(className, log.className) &&
                Objects.equals(methodName, log.methodName) &&
                Objects.equals(args, log.args) &&
                Objects.equals(url, log.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, user, opDate, ip, module, opType, note, className, methodName, args, url);
    }
}
