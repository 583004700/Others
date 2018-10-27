package com.ry.cds.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.cds.user.bo.Document;
import com.ry.cds.user.bo.DocumentPrintRecord;

/**
 * 学校Mapper
 * 
 * @author 幸仁强
 *
 */
@Mapper
public interface DocumentMapper {

	/**
	 * 根据主键获取文档信息
	 * 
	 * @param schoolID
	 * @return
	 */
	public Document get(@Param("documentID") long documentID);

	/**
	 * 根据UserID获取文档信息
	 * 
	 * @param schoolID
	 * @return
	 */
	public List<Document> getByUserID(@Param("userID") long userID);

	/**
	 * 插入文档
	 * 
	 * @param document
	 * @return
	 */
	public int insert(Document document);

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
	public int checkExistByUCodeAndSCode(Map<String, Object> map);

	/**
	 * 插入打印记录
	 * 
	 * @param documentPrintRecord
	 * @return
	 */
	public int insertPrintRecord(DocumentPrintRecord documentPrintRecord);

	/**
	 * 更新打印记录
	 * 
	 * @param documentPrintRecord
	 * @return
	 */
	public int updatePrintRecord(DocumentPrintRecord documentPrintRecord);

}