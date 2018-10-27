package com.ry.cds.amqp.bo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 字典实体类
 * 
 * @author 幸仁强
 *
 */
@Component
public class CommonDictionary implements Serializable {
	private static final long serialVersionUID = 1L;
	// 字典项组值
	private int itemGroup;
	// 字典项ID
	private int itemKey;
	// 字典项名称
	private String itemValue;
	// 字典项编码
	private String itemCode;
	// 字典项组描述
	private String itemGroupDesc;
	// 排序索引
	private int orderIndex;
	// 状态：1表示有效，0表示删除
	private int statusFlag;

	public int getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(int itemGroup) {
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

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemGroupDesc() {
		return itemGroupDesc;
	}

	public void setItemGroupDesc(String itemGroupDesc) {
		this.itemGroupDesc = itemGroupDesc;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	public int getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(int statusFlag) {
		this.statusFlag = statusFlag;
	}
}