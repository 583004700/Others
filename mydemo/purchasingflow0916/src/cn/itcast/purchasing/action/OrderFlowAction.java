package cn.itcast.purchasing.action;

import cn.itcast.purchasing.service.OrderService;
import cn.itcast.purchasing.util.UserUtil;
import cn.itcast.purchasing.vo.ActiveUser;
import cn.itcast.purchasing.vo.OrderAuditCustom;
import cn.itcast.purchasing.vo.OrderCustom;
import cn.itcast.purchasing.vo.OrderVo;
import org.activiti.spring.annotations.TaskId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/orderflow")
public class OrderFlowAction {
    @Autowired
    OrderService orderService;

    @RequestMapping("/addOrder")
    public String addOrder(Model model) throws Exception{
        return "order/addOrder";
    }

    @RequestMapping("/addOrderSave")
    public String createOrderSave(HttpSession session, OrderVo orderVo) throws Exception{

        ActiveUser activeUser = UserUtil.getUserFromSession(session);

        String userId = activeUser.getUserid();

        orderService.saveOrder(userId,orderVo.getOrderCustom());

        return "redirect:orderTaskList.action";
    }

    //采购单处理列表
    @RequestMapping("/orderTaskList")
    public String orderTaskList(HttpSession session,Model model) throws Exception{

        ActiveUser activeUser = UserUtil.getUserFromSession(session);

        String userId = activeUser.getUserid();

        List<OrderCustom> list = orderService.findOrderTaskList(userId);

        model.addAttribute("list",list);

        return "order/orderTaskList";
    }

    //提交采购单
    @RequestMapping("/submitOrder")
    public String submitOrder(HttpSession session,String taskId) throws Exception{

        ActiveUser activeUser = UserUtil.getUserFromSession(session);

        String userId = activeUser.getUserid();

        orderService.saveOrderSubmitStatus(userId,taskId);

        return "redirect:orderTaskList.action";
    }

    //采购单审核页面
    @RequestMapping("/orderAudit")
    public String orderAudit(Model model,String taskId,String orderId,String auditType) throws Exception{

        model.addAttribute("taskId", taskId);
        model.addAttribute("orderId", orderId);
        model.addAttribute("auditType", auditType);

        return "order/orderAudit";
    }

    //提交审核
    @RequestMapping("/submitOrderAudit")
    public String submitOrderAudit(HttpSession session,String taskId,String orderId,String auditType,OrderVo orderVo) throws Exception{
        ActiveUser activeUser = UserUtil.getUserFromSession(session);

        String userId = activeUser.getUserid();

        orderService.saveOrderAuditStatus(taskId,userId,orderId,auditType,orderVo.getOrderAuditCustom());

        return "redirect:orderTaskList.action";
    }
}
