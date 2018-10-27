package com.ry.xk.common.bo;

/**
 * 通用字典表的数据库映射
 */
public class CommonDictionary {
    //主键
    private int commonDictionaryId;
    //分组
    private String itemGroup;
    //键
    private int itemKey;
    //值
    private String itemValue;
    //排序
    private int orderIndex;
    //拓展字段1
    private String extension1;
    //拓展字段2
    private String extension2;
    //有效状态
    private int statusFlag;

    public int getCommonDictionaryId() {
        return commonDictionaryId;
    }

    public void setCommonDictionaryId(int commonDictionaryId) {
        this.commonDictionaryId = commonDictionaryId;
    }

    public String getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(String itemGroup) {
        this.itemGroup = itemGroup;
    }

    public int getItemKey() {
        return itemKey;
    }

    public void setItemKey(int itemKey) {
        this.itemKey = itemKey;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getExtension1() {
        return extension1;
    }

    public void setExtension1(String extension1) {
        this.extension1 = extension1;
    }

    public String getExtension2() {
        return extension2;
    }

    public void setExtension2(String extension2) {
        this.extension2 = extension2;
    }

    public int getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(int statusFlag) {
        this.statusFlag = statusFlag;
    }
}
