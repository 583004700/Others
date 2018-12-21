package com.byefan.xhoa.service.flow;

import java.util.List;
import java.util.Map;

import com.byefan.xhoa.entity.fee.*;
import com.github.pagehelper.PageInfo;

/**
 * 开票流程的流程服务；
 * 
 * @Author ：Yuan；
 * @Date ：2018/12/6 0006 14:01；
 */
public interface IProcessService {
	/**
	 * 发起开票审批流程：1、发起流程； 2、更新数据状态； 3、审核对象的代办事项和消息中添加数据；
	 *
	 * @param invoice：需要审批的开票对象；
	 * @param urgencyLevel：审批的紧急程度，参考com.byefan.xhoa.entity.crm.Const；
	 * @return ：审批的流程ID，流程提交失败返回空；
	 */
	String addBallotProcess(Invoice invoice, int urgencyLevel);

	/**
	 * 发起借款审批流程：1、发起流程； 2、更新数据状态； 3、审核对象的代办事项和消息中添加数据；
	 * 
	 * @param borrow：需要审批的借款对象；
	 * @param urgencyLevel：审批的紧急程度，参考com.byefan.xhoa.entity.crm.Const；
	 * @return ：审批的流程ID，流程提交失败返回空；
	 */
	String addBorrowProcess(Borrow borrow, int urgencyLevel);

	/**
	 * 发起媒介请款审批流程：1、发起流程； 2、更新数据状态； 3、审核对象的代办事项和消息中添加数据；
	 *
	 * @param outgo：需要审批的媒介请款对象；
	 * @param urgencyLevel：审批的紧急程度，参考com.byefan.xhoa.entity.crm.Const；
	 * @return ：审批的流程ID，流程提交失败返回空；
	 */
	String addMediaRefundProcess(Outgo outgo, int urgencyLevel);

	/**
	 * 
	 * /** 发起退款申请审批流程：1、发起流程； 2、更新数据状态； 3、审核对象的代办事项和消息中添加数据；
	 *
	 * @param refund：需要审批的退款对象；
	 * @param urgencyLevel：审批的紧急程度，参考com.byefan.xhoa.entity.crm.Const；
	 * @return ：审批的流程ID，流程提交失败返回空；
	 */
	String addRefundProcess(Refund refund, int urgencyLevel);

	/**
	 * 发起财务提成流程：1、发起流程； 2、更新数据状态； 3、审核对象的代办事项和消息中添加数据；
	 *
	 * @param commission：需要审批的提成对象；
	 * @param urgencyLevel：审批的紧急程度，参考com.byefan.xhoa.entity.crm.Const；
	 * @return ：审批的流程ID，流程提交失败返回空；
	 */
	String addCommissionProcess(Commission commission, int urgencyLevel);

	/**
	 * 批量审批流程数据：1、流程更新；2、数据状态更新；3、审核对象的代办事项和消息中添加数据；
	 *
	 * @param taskIds：需要审批的任务ID数组；
	 * @param desc：审批备注信息；
	 * @param agree
	 *            ：是否同意，true为是，false为否；
	 * @return ：操作结果描述；
	 */
	String approveProcess(String[] taskIds, String desc, boolean agree);

	/**
	 * 分页查询登录人的审批任务列表；
	 * 
	 * @param map：查询参数；
	 * @param pageNum：当前页码；
	 * @param pageSize：每页显示数量；
	 * @return ：分页数据集合；
	 */
	PageInfo<Map<String, Object>> listTasks(Map<String, String> map, int pageNum, int pageSize);

	/**
	 * 查询数据的审批记录；
	 * 
	 * @param dataId：数据ID；
	 * @param process：流程标志，定义参考com.byefan.xhoa.utils.IProcess；
	 * @return ：审批记录集合；
	 */
	List<Map<String, Object>> listTaskHistory(String dataId, int process);
}