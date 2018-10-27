package com.ry.cds.user.service;

import java.io.IOException;

import com.ry.cds.amqp.bo.FileDataFormat;

/**
 * 业务类
 * 
 * @author 幸仁强
 *
 */
public interface IGeneralFileDataService {
	/**
	 * 对象写入文件
	 * 
	 * @param printerReportRecord
	 * @throws IOException
	 */
	public void writeToFile(FileDataFormat fileDataFormat) throws IOException;
}
