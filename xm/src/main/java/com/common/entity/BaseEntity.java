package com.common.entity;

import java.util.UUID;

public abstract class BaseEntity<T extends BaseEntity<T>> {
    private String id = UUID.randomUUID().toString();
    private String tableName = this.getClass().getSimpleName();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取表名,默认是类名
     * @return
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 获取主键，默认为id列
     * @return
     */
    public String getPrimaryKey(){
        return getId();
    }
}
