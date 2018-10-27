package com.ry.cds.user.bo;

import java.io.Serializable;

/**
 * 合作伙伴实体
 * @author Administrator
 *
 */
public class Partner implements Serializable {
	private static final long serialVersionUID = 1L;
	// 合作伙伴的id，主键自增
	private long partnerID;
	// 合作伙伴的唯一key，平台校验使用的key
	private String partnerKey;
	// 合作伙伴的唯一Secret，平台校验使用的密钥
	private String partnerSecret;
	// 合作伙伴在用的Token，数据加密使用
	private String partnerToken;
	// 合作伙伴的类型，目前存在两个值，1表示直接信任的伙伴，如云学通，2表示需要验证的伙伴，对应在commondictionary中ItemGroup为10的集合
	private int partnerTypeID;
	// 有效开始时间
	private String startDateTime;
	// 到期时间
	private String endDateTime;
	// 合作伙伴的状态，目前只有1、2和0,1表示有效，2表示被禁止,0表示删除，默认值为1
	private int statusFlag;
	// 合作伙伴标识码，用于进行不同效果展示的区分
	private String partnerCode;
	// 合作伙伴名称
	private String partnerName;
	// 合作伙伴的父id
	private long parentID;

	public long getPartnerID() {
		return partnerID;
	}

	public void setPartnerID(long partnerID) {
		this.partnerID = partnerID;
	}

	public String getPartnerKey() {
		return partnerKey;
	}

	public void setPartnerKey(String partnerKey) {
		this.partnerKey = partnerKey;
	}

	public String getPartnerSecret() {
		return partnerSecret;
	}

	public void setPartnerSecret(String partnerSecret) {
		this.partnerSecret = partnerSecret;
	}

	public String getPartnerToken() {
		return partnerToken;
	}

	public void setPartnerToken(String partnerToken) {
		this.partnerToken = partnerToken;
	}

	public int getPartnerTypeID() {
		return partnerTypeID;
	}

	public void setPartnerTypeID(int partnerTypeID) {
		this.partnerTypeID = partnerTypeID;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public int getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(int statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public long getParentID() {
		return parentID;
	}

	public void setParentID(long parentID) {
		this.parentID = parentID;
	}

}
