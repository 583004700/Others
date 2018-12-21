package com.byefan.xhoa.flow.listener;

import org.flowable.task.service.delegate.DelegateTask;

import com.byefan.xhoa.utils.IConst;

/**
 * 退款网关判断职务的监听服务；
 * 
 * @Author ：Yuan；
 * @Date ：2018/12/7 0007 15:24；
 */
public class RefundMoneyGateHandler extends CommonTaskHandler {
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
			// 判断金额；
			boolean gateCheck = delegateTask.getVariable("gateCheck", Boolean.class);
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