package com.byefan.core.entity;

import com.byefan.core.annotation.Id;
import com.byefan.core.annotation.Table;

import com.byefan.core.annotation.Column;
import com.byefan.core.annotation.Transient;
import java.io.Serializable;
import java.util.Set;

@Table(name = "sys_dict")
public class Dict implements Serializable {

    @Id
    @Column(name = "id")
    private int id;
    private String typeCode;
    private String typeName;
    private String code;
    private String name;
    private int parentId;
    private byte disabled;
    private String type;
    @Transient
    private Dict parent;
    @Transient
    private Set<Dict> childs;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Dict getParent() {
        return parent;
    }

    public void setParent(Dict parent) {
        this.parent = parent;
    }

    public void setDisabled(byte disabled) {
        this.disabled = disabled;
    }

    public Set<Dict> getChilds() {
        return childs;
    }

    public void setChilds(Set<Dict> childs) {
        this.childs = childs;
    }

    public byte getDisabled() {
        return disabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
