package com.ry.cds.user.bo;

/**
 * 文档打印接口输出实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class DocumentPrintOutput {
	// 结果代码：N失败 , Y成功
	private String result;
	// true, false
	private boolean success;
	// 确认结果：1成功 2失败 3余额 不足
	private String comfrimResult;
	// 冻结金额，单位：元
	private double freezeAmount;
	// 打印场景：1校内打印，2学校周边小打印点，0打印中心
	private String printScene;
	// 错误代码
	private String errorCode;
	// 错误信息
	private String errorMsg;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getComfrimResult() {
		return comfrimResult;
	}

	public void setComfrimResult(String comfrimResult) {
		this.comfrimResult = comfrimResult;
	}

	public double getFreezeAmount() {
		return freezeAmount;
	}

	public void setFreezeAmount(double freezeAmount) {
		this.freezeAmount = freezeAmount;
	}

	public String getPrintScene() {
		return printScene;
	}

	public void setPrintScene(String printScene) {
		this.printScene = printScene;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
