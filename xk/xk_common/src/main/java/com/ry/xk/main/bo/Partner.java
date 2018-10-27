package com.ry.xk.main.bo;


import com.ry.xk.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.xk.springbootframe.couchbase.ICouchBaseStoredObject;
import io.protostuff.Tag;

import java.io.Serializable;
import java.util.List;

/**
 * 合作伙伴实体
 * @author Administrator
 *
 */
public class Partner implements Serializable,ICouchBaseStoredObject {
	private static final long serialVersionUID = 1L;
	// 合作伙伴的id，主键自增
	@Tag(1)
	private int partnerId;
	// 合作伙伴的唯一key，平台校验使用的key
	@Tag(2)
	private String partnerKey;
	// 合作伙伴的唯一Secret，平台校验使用的密钥
	@Tag(3)
	private String partnerSecret;
	// 合作伙伴在用的Token，数据加密使用
	@Tag(4)
	private String partnerToken;
	// 合作伙伴的类型，目前存在两个值，1表示直接信任的伙伴，如云学通，2表示需要验证的伙伴，对应在commondictionary中ItemGroup为10的集合
	@Tag(5)
	private int partnerTypeId;
	// 有效开始时间
	@Tag(6)
	private String startDateTime;
	// 到期时间
	@Tag(7)
	private String endDateTime;
	// 合作伙伴的状态，目前只有1、2和0,1表示有效，2表示被禁止,0表示删除，默认值为1
	@Tag(8)
	private int statusFlag;
	// 合作伙伴标识码，用于进行不同效果展示的区分
	@Tag(9)
	private String partnerCode;
	// 合作伙伴名称
	@Tag(10)
	private String partnerName;
	// 合作伙伴的父id
	@Tag(11)
	private int parentId;
	//合作伙伴学科映射
	@Tag(12)
	private List<PartnerCourseMapping> partnerCourseMappings;
	//微信公众号ID
	@Tag(13)
	private String weChatAppId;
	//微信接口秘钥
	@Tag(14)
	private String weChatAppSecret;
	//订单中心平台Code
	@Tag(15)
	private String sourcePlantCode;
	//扩展信息
	@Tag(16)
	private String partnerExtension;

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
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

	public int getPartnerTypeId() {
		return partnerTypeId;
	}

	public void setPartnerTypeId(int partnerTypeId) {
		this.partnerTypeId = partnerTypeId;
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

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public List<PartnerCourseMapping> getPartnerCourseMappings() {
		return partnerCourseMappings;
	}

	public void setPartnerCourseMappings(List<PartnerCourseMapping> partnerCourseMappings) {
		this.partnerCourseMappings = partnerCourseMappings;
	}

	private static String _key = "Partner_%s";

	@Override
	public String key() {
		return String.format(keyFormat(), partnerId);
	}

	@Override
	public String keyFormat() {
		return _key;
	}

	@Override
	public CouchBaseSectionType couchbaseSection() {
		return CouchBaseSectionType.MAIN;
	}

	public String getWeChatAppId() {
		return weChatAppId;
	}

	public void setWeChatAppId(String weChatAppId) {
		this.weChatAppId = weChatAppId;
	}

	public String getWeChatAppSecret() {
		return weChatAppSecret;
	}

	public void setWeChatAppSecret(String weChatAppSecret) {
		this.weChatAppSecret = weChatAppSecret;
	}

	public String getSourcePlantCode() {
		return sourcePlantCode;
	}

	public void setSourcePlantCode(String sourcePlantCode) {
		this.sourcePlantCode = sourcePlantCode;
	}

	public String getPartnerExtension() {
		return partnerExtension;
	}

	public void setPartnerExtension(String partnerExtension) {
		this.partnerExtension = partnerExtension;
	}
}
