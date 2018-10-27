package com.ry.cds.user.bo;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 文档打印接口输入实体
 * 
 * @author 幸仁强
 * @createTime 2018-03-05
 */
public class DocumentPrintInput {
	// 时间戳 必须保证每条数据唯一
	@NotBlank(message = "timestamp不允许为空")
	private String timestamp;
	// 卡号
	@NotBlank(message = "cardNo不允许为空")
	private String cardNo;
	// 打印群组Id(预留)
	private int clusterId;
	// 文档列表<宜联平台文档资源编号>
	@Size(min = 1, message = "list不允许为空")
	private List<String> list;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public int getClusterId() {
		return clusterId;
	}

	public void setClusterId(int clusterId) {
		this.clusterId = clusterId;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
