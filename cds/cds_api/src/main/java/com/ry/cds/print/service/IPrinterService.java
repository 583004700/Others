package com.ry.cds.print.service;

import com.ry.cds.print.bo.PrintResultNotificationInput;
import com.ry.cds.print.bo.PrintTask;
import com.ry.cds.print.bo.Printer;
import com.ry.cds.print.bo.PrinterGetTaskInput;
import com.ry.cds.print.bo.PrinterGetTaskOutput;
import com.ry.cds.print.bo.PrinterStateReportInput;
import com.ry.cds.user.bo.CommonOutput;

/**
 * 打印任务业务接口
 * 
 * @author 幸仁强
 *
 */
public interface IPrinterService {
	/**
	 * 插入打印任务
	 * 
	 * @param printTask
	 * @return
	 */
	public int insert(PrintTask printTask);

	/**
	 * 更新打印任务
	 * 
	 * @param printTask
	 * @return
	 * @throws Exception
	 */
	public int update(PrintTask printTask) throws Exception;

	/**
	 * 根据主键获取打印任务
	 * 
	 * @param printTaskID
	 * @return
	 */
	public PrintTask get(long printTaskID);

	/**
	 * 获取重试次数
	 * 
	 * @param printTaskID
	 * @return
	 */
	public int getRetryCount(long printTaskID);

	/**
	 * 打印结果通知
	 * 
	 * @param printResultNotificationInput
	 * @return
	 * @throws Exception
	 */
	public CommonOutput printResultNotification(PrintResultNotificationInput printResultNotificationInput)
			throws Exception;

	/**
	 * 打印机获取打印任务
	 * 
	 * @param printTaskID
	 * @return
	 * @throws Exception
	 */
	public PrinterGetTaskOutput printerGetTask(PrinterGetTaskInput printerGetTaskInput) throws Exception;

	/**
	 * 打印机状态上报
	 * 
	 * @param printerStateReportInput
	 * @return
	 * @throws Exception
	 */
	public CommonOutput stateReport(PrinterStateReportInput printerStateReportInput) throws Exception;

	/**
	 * 更新
	 * 
	 * @param printer
	 * @return
	 * @throws Exception
	 */
	public int update(Printer printer) throws Exception;

	/**
	 * 根据打印机序列号获取打印机主键
	 * 
	 * @param printSN
	 * @return
	 */
	public long getPrimaryByPrintSN(String printSN);

	/**
	 * 生成返回实体
	 * 
	 * @param partnerKey
	 * @param result
	 * @return
	 */
	public CommonOutput fitCommonOutPut(String partnerKey, String result);

	/**
	 * 组装返回实体
	 * 
	 * @param printTask
	 * @param printerGetTaskInput
	 * @return
	 * @throws Exception
	 */
	PrinterGetTaskOutput fitPrinterGetTaskOutput(PrintTask printTask, String partnerKey, String result);
}
