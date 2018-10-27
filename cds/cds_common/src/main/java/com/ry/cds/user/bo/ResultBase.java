package com.ry.cds.user.bo;

import java.io.Serializable;

/**
 * 更新文档接口输出实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class ResultBase implements Serializable {
	private static final long serialVersionUID = 1L;
	// 结果：1-成功 2-失败
	private int resultType;
	// 返回消息
	private String message;

	// 执行结果
	private Object returnEntity;

	public int getResultType() {
		return resultType;
	}

	public void setResultType(int resultType) {
		this.resultType = resultType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object isReturnEntity() {
		return returnEntity;
	}

	public void setReturnEntity(Object returnEntity) {
		this.returnEntity = returnEntity;
	}

	public ResultBase() {
	}

	public ResultBase(int resultType, String message, Object returnEntity) {
		this.resultType = resultType;
		this.message = message;
		this.returnEntity = returnEntity;
	}

}
