package com.ry.cds.amqp.bo;

import java.util.List;

import com.ry.cds.common.CommonConst;

/**
 * 写入文件MQ
 * 
 * @author 幸仁强
 *
 */
public class FileDataFormat implements IAmqpStoredObject {
	/**
	 * 无参构造方法
	 */
	public FileDataFormat() {
	}

	/**
	 * 带参构造方法
	 * 
	 * @param dataLines
	 * @param byHour
	 * @param dataTypeId
	 * @param connectionTypeId
	 * @param dataTableName
	 * @param currentDate
	 */
	public FileDataFormat(List<String> dataLines, boolean byHour, int dataTypeId, int connectionTypeId,
			String dataTableName, String currentDate) {
		this.dataLines = dataLines;
		this.byHour = byHour;
		this.dataTypeId = dataTypeId;
		this.connectionTypeId = connectionTypeId;
		this.dataTableName = dataTableName;
		this.currentDate = currentDate;
	}

	// 负责将对象转化成为多行或一行String
	public List<String> dataLines;
	// 按小时，还是按天处理
	public boolean byHour;
	// 是数据库还是ODPS, 1 MySql 2 ODPS
	public int dataTypeId;
	// 链接MySql数据库的数据库Id 1 user、2 print
	public int connectionTypeId;
	// 保存数据的表名
	public String dataTableName;
	// 当前操作时间
	public String currentDate;

	public List<String> getDataLines() {
		return dataLines;
	}

	public void setDataLines(List<String> dataLines) {
		this.dataLines = dataLines;
	}

	public boolean isByHour() {
		return byHour;
	}

	public void setByHour(boolean byHour) {
		this.byHour = byHour;
	}

	public int getDataTypeId() {
		return dataTypeId;
	}

	public void setDataTypeId(int dataTypeId) {
		this.dataTypeId = dataTypeId;
	}

	public int getConnectionTypeId() {
		return connectionTypeId;
	}

	public void setConnectionTypeId(int connectionTypeId) {
		this.connectionTypeId = connectionTypeId;
	}

	public String getDataTableName() {
		return dataTableName;
	}

	public void setDataTableName(String dataTableName) {
		this.dataTableName = dataTableName;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	private String queueName = CommonConst.GENERALFILEDATAQUEUE;

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	@Override
	public String getQueueName() {
		return this.queueName;
	}
}
