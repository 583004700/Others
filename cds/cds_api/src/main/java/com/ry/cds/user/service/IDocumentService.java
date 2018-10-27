package com.ry.cds.user.service;

import com.ry.cds.user.bo.Document;
import com.ry.cds.user.bo.DocumentPrintRecord;
import com.ry.cds.user.bo.SyncDocumentInput;
import com.ry.cds.user.bo.SyncDocumentOutput;
import com.ry.cds.user.bo.UpdateDocumentInput;
import com.ry.cds.user.bo.ResultBase;

/**
 * 文档业务接口
 * 
 * @author 幸仁强
 *
 */
public interface IDocumentService {
	/**
	 * 根据主键获取文档信息
	 * 
	 * @param schoolID
	 * @return
	 * @throws Exception
	 */
	public Document get(long documentID) throws Exception;

	/**
	 * 插入文档信息
	 * 
	 * @param school
	 * @return
	 */
	public long insert(Document document) throws Exception;

	/**
	 * 更新文档信息
	 * 
	 * @param document
	 * @return
	 */
	public int update(Document document) throws Exception;

	/**
	 * 文档同步
	 * 
	 * @param syncDocumentInput
	 * @return
	 * @throws Exception
	 */
	public SyncDocumentOutput synchronous(SyncDocumentInput syncDocumentInput) throws Exception;

	/**
	 * 插入打印记录
	 * 
	 * @param documentPrintRecord
	 * @return
	 */
	public long insertPrintRecode(DocumentPrintRecord documentPrintRecord);

	/**
	 * 更新打印记录
	 * 
	 * @param documentPrintRecord
	 * @return
	 */
	public int updatePrintRecode(DocumentPrintRecord documentPrintRecord);

	/**
	 * 文档装换后上报接口
	 * 
	 * @param updateDocumentInput
	 * @return
	 */
	public ResultBase updateByReportInfo(UpdateDocumentInput updateDocumentInput) throws Exception;
}
