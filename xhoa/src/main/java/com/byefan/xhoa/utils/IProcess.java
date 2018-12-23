package com.byefan.xhoa.utils;

/**
 * 流程代号，用于在监听器中进行区分；
 * 
 * @Author ：Yuan；
 * @Date ：2018/12/6 0006 19:02；
 */
public interface IProcess {
	// 开票申请流程；
	int PROCESS_BALLOT = 1;
	// 借款申请流程；
	int PROCESS_BORROW = 2;
	// 媒介请款流程；
	int PROCESS_MEDIAREFUND = 3;
	// 退款流程；
	int PROCESS_REFUND = 4;
	// 财务提成流程；
	int PROCESS_ROYALTY = 5;
	// 流程正在审批中；
	int PROCESS_HANDLING = 0;
	// 流程已审批完成；
	int PROCESS_FINISHED = 1;
	// 流程审批拒绝；
	int PROCESS_REJECT = 2;
}