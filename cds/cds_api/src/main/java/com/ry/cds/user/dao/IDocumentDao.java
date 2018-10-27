package com.ry.cds.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ry.cds.user.bo.Document;
import com.ry.cds.user.bo.DocumentPrintRecord;

/**
 * 文档持久化接口
 * 
 * @author 幸仁强
 *
 */
public interface IDocumentDao {
	/**
	 * 根据主键获取文档信息
	 * 
	 * @param schoolID
	 * @return
	 * @throws Exception
	 */
	public Document get(long documentID) throws Exception;

	/**
	 * 根据UserID获取文档信息
	 * 
	 * @param userID
	 * @return
	 */
	public List<Document> getByUserID(@Param("userID") long userID);

	/**
	 * 插入文档信息
	 * 
	 * @param document
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
	 * 根据条件校验是否存在该文档
	 * 
	 * @param map
	 * @return
	 */
	public boolean checkExistByUCodeAndSCode(String sourceCode, int documentTypeID);

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
}