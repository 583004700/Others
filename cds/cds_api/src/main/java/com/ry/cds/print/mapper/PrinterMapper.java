package com.ry.cds.print.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import com.ry.cds.print.bo.Printer;

@Mapper
public interface PrinterMapper {

	/**
	 * 根据打印机ID获取打印机信息
	 * 
	 * @param printerID
	 * @return
	 */
	public Printer get(@Param("printerID") long printerID);

	/**
	 * 根据打印机序列号获取打印机主键
	 * 
	 * @param printSN
	 * @return
	 */
	public long getPrimaryByPrintSN(@Param("printSN") String printSN);

	/**
	 * 根据学校ID获取打印机组
	 * 
	 * @param schoolID
	 * @return
	 */
	public List<Printer> getByClusterID(@Param("clusterID") long clusterID);

	/**
	 * 根据打印机ID获取所属打印机组ID
	 * 
	 * @param printerID
	 * @return
	 * @throws Exception
	 */
	public long getClusterIDByPrinterID(@Param("printerID") long printerID) throws Exception;

	/**
	 * 更新
	 * @param printer
	 * @return
	 */
	public int update(Printer printer);

}