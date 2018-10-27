package com.ry.cds.user.bo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.ry.cds.springbootframe.couchbase.CouchBaseSectionType;
import com.ry.cds.springbootframe.couchbase.ICouchBaseStoredObject;

import io.protostuff.Tag;

/**
 * 学校机构的打印价格配置表实体类
 * 
 * @author 幸仁强
 *
 */
@Component
public class SchoolPriceConfig implements Serializable, ICouchBaseStoredObject {
	private static final long serialVersionUID = 1L;
	// 主键
	@Tag(1)
	private long schoolID;
	// 金额
	@Tag(2)
	private long price;
	// 收款方式，1表示按页收费，2表示按文档个数收费
	@Tag(3)
	private int saleTypeID;
	// 状态
	@Tag(4)
	private int statusFlag;
	// 创建时间
	@Tag(5)
	private String createDateTime;
	// 更新时间
	@Tag(6)
	private String updateDateTime;

	public long getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(long schoolID) {
		this.schoolID = schoolID;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getSaleTypeID() {
		return saleTypeID;
	}

	public void setSaleTypeID(int saleTypeID) {
		this.saleTypeID = saleTypeID;
	}

	public int getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(int statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	private static String _key = "SchoolPriceConfig_%s";

	@Override
	public String key() {
		return String.format(keyFormat(), schoolID);
	}

	@Override
	public String keyFormat() {
		return _key;
	}

	@Override
	public CouchBaseSectionType couchbaseSection() {
		return CouchBaseSectionType.USER;
	}
}