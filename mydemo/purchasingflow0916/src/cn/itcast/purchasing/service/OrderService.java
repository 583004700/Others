package cn.itcast.purchasing.service;

import cn.itcast.purchasing.vo.OrderAuditCustom;
import cn.itcast.purchasing.vo.OrderCustom;

import java.util.List;

/**
 * 采购单管理
 */
public interface OrderService {
    //保存采购单
    void saveOrder(String userId,OrderCustom orderCustom) throws Exception;

    List<OrderCustom> findOrderTaskList(String userId) throws Exception;

    void saveOrderSubmitStatus(String userId,String taskId) throws Exception;

    void saveOrderAuditStatus(String taskId,String userId, String orderId, String auditType, OrderAuditCustom orderAuditCustom) throws Exception;
}
