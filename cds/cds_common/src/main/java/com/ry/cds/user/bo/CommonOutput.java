package com.ry.cds.user.bo;

/**
 * 通用返回实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class CommonOutput {
	// 结果代码：N失败 , Y成功
	private String result;
	// 签名
	private String signStr;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSignStr() {
		return signStr;
	}

	public void setSignStr(String signStr) {
		this.signStr = signStr;
	}

}
