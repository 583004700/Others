package com.ry.xk.common.bo;

import java.io.Serializable;

/**
 * Map工具实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class Map implements Serializable {
	private static final long serialVersionUID = 1L;
	private Object key;
	private Object value;

	public Map() {

	}

	public Map(Object key, Object value) {
		this.key = key;
		this.value = value;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
