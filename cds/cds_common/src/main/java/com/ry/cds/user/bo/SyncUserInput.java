package com.ry.cds.user.bo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 同步用户接口输入实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class SyncUserInput implements Serializable {
	private static final long serialVersionUID = 1L;
	// 导入用户数量
	@NotNull(message = "导入数量不能为空")
	@Min(value = 1, message = "count要大于0")
	private int count;
	// 用户数据集合
	@NotNull(message = "导入数据不能为空")
	@Size(min = 1, message = "导入数据不能为空")
	List<SyncUser> data;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<SyncUser> getData() {
		return data;
	}

	public void setData(List<SyncUser> data) {
		this.data = data;
	}

}
