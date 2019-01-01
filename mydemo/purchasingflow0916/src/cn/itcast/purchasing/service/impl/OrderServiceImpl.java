package cn.itcast.purchasing.service.impl;

import cn.itcast.purchasing.dao.mapper.PurBusOrderAuditMapper;
import cn.itcast.purchasing.dao.mapper.PurBusOrderMapper;
import cn.itcast.purchasing.po.PurBusOrder;
import cn.itcast.purchasing.service.OrderService;
import cn.itcast.purchasing.util.ResourcesUtil;
import cn.itcast.purchasing.util.UUIDBuild;
import cn.itcast.purchasing.vo.OrderAuditCustom;
import cn.itcast.purchasing.vo.OrderCustom;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 采购单的管理
 */
public class OrderServiceImpl implements OrderService{
    @Autowired
    private PurBusOrderMapper purBusOrderMapper;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private PurBusOrderAuditMapper purBusOrderAuditMapper;

    @Override
    public void saveOrder(String userId, OrderCustom orderCustom) throws Exception {

        String orderId = UUIDBuild.getUUID();

        String processDefinitionKey = ResourcesUtil.getValue("diagram.purchasingflow","purchasingProcessDefinitionKey");

        String businessKey = orderId;

        //启动流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey,businessKey);


        orderCustom.setUserId(userId);
        orderCustom.setCreatetime(new Date());
        orderCustom.setId(orderId);
        orderCustom.setProcessinstanceId(processInstance.getProcessInstanceId());
        purBusOrderMapper.insert(orderCustom);

    }

    @Override
    public List<OrderCustom> findOrderTaskList(String userId) throws Exception {
        String processDefinitionKey = ResourcesUtil.getValue("diagram.purchasingflow","purchasingProcessDefinitionKey");
        //负责人
        String assignee = userId;
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskAssignee(assignee);
        taskQuery.processDefinitionKey(processDefinitionKey);

        List<Task> list = taskQuery.list();

        List<OrderCustom> orderCustomList = new ArrayList<OrderCustom>();

        for(Task task : list){
            OrderCustom orderCustom = new OrderCustom();

            String processInstanceId = task.getProcessInstanceId();
            ProcessInstance processInstance = runtimeService.
                    createProcessInstanceQuery().processInstanceId(processInstanceId).
                    singleResult();

            //采购单id
            String businessKey = processInstance.getBusinessKey();

            PurBusOrder purBusOrder = purBusOrderMapper.selectByPrimaryKey(businessKey);

            BeanUtils.copyProperties(purBusOrder,orderCustom);

            orderCustom.setTaskId(task.getId());
            orderCustom.setTaskDefinitionKey(task.getTaskDefinitionKey());
            orderCustom.setTaskName(task.getName());
            orderCustom.setAssignee(task.getAssignee());
            orderCustomList.add(orderCustom);
        }

        return orderCustomList;
    }

    //提交订单
    public void saveOrderSubmitStatus(String userId,String taskId){
        Task task = taskService.createTaskQuery().taskId(taskId)
                .taskAssignee(userId).singleResult();

        if(task != null){
            taskService.complete(taskId);
        }
    }

    //订单审核
    public void saveOrderAuditStatus(String taskId,String userId, String orderId, String auditType, OrderAuditCustom orderAuditCustom){
        orderAuditCustom.setId(UUIDBuild.getUUID());
        orderAuditCustom.setAuditType(auditType);
        orderAuditCustom.setOrderId(orderId);
        orderAuditCustom.setCreatetime(new Date());
        orderAuditCustom.setUserId(userId);
        purBusOrderAuditMapper.insert(orderAuditCustom);

        Task task = taskService.createTaskQuery().taskId(taskId)
                .taskAssignee(userId).singleResult();

        if(task != null){
            taskService.complete(taskId);
        }
    }
}
