package com.byefan.xhoa.utils;

/**
 * 系统常量
 *
 * @author ByeFan gzw
 */
public interface IConst {
	/**
	 * 系统登录sessionKey
	 */
	String USER_KEY = "user";

	String APP_NAME = "内部智能管理系统";
	/**
	 * 验证码
	 */
	String VERIFY_CODE = "verifyCode";

	String AUTHOR = "Authorization";

	String PROCESSES = "processes";

	String TOKEN = "token";

	String REGION = "region";

	String REGIONS = "regions";

	String PROJECT = "project";

	String USERS = "users";

	String COMPANIES = "companies";

	String USER_RESOURCE = "resources";

	String ACTIVE = "spring.profiles.active";

	String ENVIRONMENT = "server.environment";

	String USER_ROLE = "roles";

	String INVOICE_CODE = "FP";
	String ACCOUNT_CODE = "ZH";
	String INCOME_CODE = "JZ";
	String ASSIGN_CODE = "FK";
	String OUTGO_CODE = "QK";
	String REFUND_CODE = "TK";
	String BORROW_CODE = "JK";
	String COMMISSION_CODE = "TC";
	String REIMBURSE_CODE = "BG";

	/**
	 * YW 业务
	 */
	String ROLE_TYPE_YW = "YW";
	/**
	 * MJ 媒介
	 */
	String ROLE_TYPE_MJ = "MJ";
	/**
	 * HQ 后勤
	 */
	String ROLE_TYPE_HQ = "HQ";
	/**
	 * CW 财务
	 */
	String ROLE_TYPE_CW = "CW";

	/**
	 * RS 人事
	 */
	String ROLE_TYPE_RS = "RS";
	/**
	 * XZ 行政
	 */
	String ROLE_TYPE_XZ = "XZ";

	/**
	 * 部长
	 */
	String ROLE_CODE_BZ = "BZ";
	/**
	 * 员工
	 */
	String ROLE_CODE_YG = "YG";
	/**
	 * 组长
	 */
	String ROLE_CODE_ZZ = "ZZ";
	/**
	 * state状态对应值 统计查state>0 列表页面查state>-2 删除和编辑功能仅限 state==0 || state==-1
	 * 审核完成后如果需要出纳操作state置2，不需要出纳操作置1 财务出纳操作后置1
	 */
	int STATE_DELETE = -9;// 删除
	int STATE_REJECT = -1;// 审核驳回
	int STATE_SAVE = 0; // 已保存，默认
	int STATE_FINISH = 1;// 已完成
	int STATE_PASS = 2;// 审核通过,出纳出款
	int STATE_ZZ = 3;// 组长审核
	int STATE_BZ = 4;// 部长审核
	int STATE_ZJ = 5;// 总监审核
	int STATE_CFO = 6;// 财务总监复核
	int STATE_VP = 7;// 副总经理复核
	int STATE_CEO = 8;// 总经理复核
	int STATE_KJ = 9;// 会计审核
	int STATE_YW = 10;// 业务员确认

	int ACCOUNT_TYPE_COMPANY = 1;// 公司账户，公司财务用
	int ACCOUNT_TYPE_SUPPLIER = 2; // 供应商银行账户
	int ACCOUNT_TYPE_CUST = 3; // 客户银行账户
	int ACCOUNT_TYPE_PERSONAL = 4;// 个人账户，公司内部使用

	/**
	 * 当前登录用户媒体类型列表
	 */
	String USER_MEDIA_TYPE_LIST = "userMediaTypeList";
}
