package com.ry.cds.common;

/**
 * 公用常量类
 * 
 * @author 幸仁强
 *
 */
public class CommonConst {
	// 调用接口返回结果失败
	public static final String RESULT_N = "N";
	// 调用接口返回结果成功
	public static final String RESULT_Y = "Y";
	// 同步状态,R已接收 I同步中 S成功 F失败
	public static final String SYNC_STATUS_R = "R";
	public static final String SYNC_STATUS_I = "I";
	public static final String SYNC_STATUS_S = "S";
	public static final String SYNC_STATUS_F = "F";

	// 普通机组
	public static final int CLUSTERTYPEID_ORDINARY = 1;

	// 演示机组
	public static final int CLUSTERTYPEID_DEMO = 2;

	// 打印中心组
	public static final int CLUSTERTYPEID_PRINTCENTER = 3;

	// 演示账户标志
	public static final int PRINT_FLAG_DEMOACCOUNT = 1;

	// 打印成功
	public static final String PRINT_STATUS_REPORT_SUC = "PS";

	// 打印失败
	public static final String PRINT_STATUS_REPORT_FAI = "PF";

	// 待打印
	public static final int PRINT_STATUS_TO_BE_PRINTED = 1;
	// 已创建打印任务
	public static final int PRINT_STATUS_CREATED_PRINTTASK = 2;
	// 已打印
	public static final int PRINT_STATUS_PRINTED = 3;
	// 打印失败
	public static final int PRINT_STATUS_PRINT_FAILED = 4;

	// 待打印
	public static final int TASK_STATUS_TO_BE_PRINTED = 1;
	// 2.被打印机获取
	public static final int TASK_STATUS_BE_OBTAINED = 2;
	// 已打印
	public static final int TASK_STATUS_PRINTED = 3;
	// 打印失败
	public static final int TASK_STATUS_PRINT_FAILED = 4;

	public static final String PRINTER_ERRORCODE_IDLE = "Idle";

	public static final String PRINTER_ERRORCODE_BUSY = "Busy";

	public static final String PRINTER_ERRORCODE_ERROR = "Error";

	public static final int PRINTER_STATUS_NORMAL = 1;

	public static final int PRINTER_STATUS_ERROR = 2;
	public static final String OSS_URL_SUFFIX = ".aliyuncs.com";
	public static final String OSS_INTERNAL_URL_SECTION = "-internal";
	public static final String DESKEY = "RuanYun_CDS_Key";

	public static final String USERACCOUNTCHANGEQUEUE = "CdsUserAccountChangeQueue";
	public static final String PDFCONVERTPRNQUEUE = "CdsPDFConvertPRNQueue";
	public static final String GENERALFILEDATAQUEUE = "CdsGeneralFileDataQueue";
}
