package com.byefan.xhoa.flow.listener;

import org.flowable.task.service.delegate.DelegateTask;

import com.byefan.xhoa.utils.IConst;

/**
 * 借款网关判断金额的监听服务；
 * 
 * @Author ：Yuan；
 * @Date ：2018/12/7 0007 15:24；
 */
public class BorrowMoneyGateHandler extends CommonTaskHandler {
	/**
	 * 根据流程类型获取对应流程需要更新的审批状态；
	 *
	 * @param delegateTask：任务对象，用于更新流程审批人；
	 */
	@Override
	public void handleApproveData(DelegateTask delegateTask) {
		boolean agree = true;
		if (delegateTask.hasVariable("agree")) {
			agree = delegateTask.getVariable("agree", Boolean.class);
		}
		int state;
		if (agree) {
			boolean gateCheck = delegateTask.getVariable("gateCheckB", Boolean.class);
			// 判断网关；
			if (gateCheck) {
				state = IConst.STATE_CEO;
			} else {
				state = IConst.STATE_PASS;
			}
		} else {
			state = IConst.STATE_REJECT;
		}

		// 更新到数据库中；
		delegateTask.setVariable("state", state);
		// 设置审批人；
		setApproveUser(delegateTask);
	}
}