package com.ry.cds.print.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ry.cds.print.bo.Printer;

/**
 * 打印机组持久化接口
 * 
 * @author 幸仁强
 *
 */
public interface IPrinterDao {
	/**
	 * 根据打印机ID获取打印机信息
	 * 
	 * @param printerID
	 * @return
	 */
	public Printer get(@Param("printerID") long printerID) throws Exception;

	/**
	 * 根据打印机序列号获取打印机主键
	 * 
	 * @param printSN
	 * @return
	 */
	public long getPrimaryByPrintSN(@Param("printSN") String printSN);

	/**
	 * 根据序列号获取打印机
	 * 
	 * @param printSN
	 * @return
	 */
	public Printer getByPrintSN(String printSN) throws Exception;

	/**
	 * 根据学校ID获取打印机组
	 * 
	 * @param schoolID
	 * @return
	 * @throws Exception
	 */
	public List<Printer> getByClusterID(long clusterID) throws Exception;

	/**
	 * 根据打印机ID获取所属打印机组ID
	 * 
	 * @param printerID
	 * @return
	 * @throws Exception
	 */
	public long getClusterIDByPrinterID(long printerID) throws Exception;

	/**
	 * 更新
	 * 
	 * @param printer
	 * @return
	 * @throws Exception
	 */
	public int update(Printer printer) throws Exception;

}