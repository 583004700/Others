package com.byefan.xhoa.controller.fee;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.crm.Const;
import com.byefan.xhoa.entity.fee.Commission;
import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.entity.workbench.Items;
import com.byefan.xhoa.entity.workbench.Message;
import com.byefan.xhoa.service.biz.IArticleService;
import com.byefan.xhoa.service.fee.ICommissionService;
import com.byefan.xhoa.service.sys.IUserService;
import com.byefan.xhoa.service.workbench.IItemsService;
import com.byefan.xhoa.service.workbench.IMessageService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/commission")
@Api(description = "借款流水接口")
public class CommissionController {

    @Autowired
    private ICommissionService commissionService;
    @Autowired
    private IArticleService articleService;
    @Autowired
    private IItemsService itemsService;
    @Autowired
    private IMessageService messageService;
    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping("/listPg")
//    @Log(opType = OperateType.QUERY, module = "角色管理", note = "角色列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<Map> listPg(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        PageInfo<Map> list = null ;
        try{
            User user = AppUtil.getUser();
            List<Role> roles = user.getRoles() ;
            if(roles==null||roles.size()==0){
                throw new Exception("未查询到角色信息") ;
            }else{
                map.put("roleType",roles.get(0).getType()) ;
                map.put("roleCode",roles.get(0).getCode()) ;
                map.put("user",user) ;
                list = commissionService.listPg(pageable.getPageNumber(), pageable.getPageSize(),map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping(value="/view")
    @ResponseBody
//    @Verify(code = "/role/view", module = "系统管理/角色查看")
    public ResponseData view(@RequestParam("id") Integer id) {
        try{
            ResponseData data = ResponseData.ok();
            Commission entity = commissionService.getById(id) ;
            data.putDataValue("entity",entity) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping(value="/del")
    @ResponseBody
//    @Log(opType = OperateType.DELETE, module = "财务管理|进账流水管理", note = "删除进账流水")
//    @Verify(code = "/role/del", module = "系统管理/角色删除")
    public ResponseData del(@RequestParam("id") Integer id) {
        try {
            commissionService.delById(id) ;
            ResponseData data = ResponseData.ok();
            data.putDataValue("message", "操作成功");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping("/add")
    @ResponseBody
//    @Log(opType = OperateType.ADD, module = "财务管理|进账流水管理", note = "新增进账流水")
//    @Verify(code = "/income/add", module = "系统管理/角色提交")
    public ResponseData add(Commission entity) {
        try{
            User user = AppUtil.getUser();
            commissionService.add(entity);
            ResponseData data = ResponseData.ok() ;
            data.putDataValue("message","操作成功");
            data.putDataValue("entity", entity) ;

            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }

    @RequestMapping("/edit")
    @ResponseBody
//    @Log(opType = OperateType.UPDATE, module = "财务管理|进账流水管理", note = "修改进账流水")
//    @Verify(code = "/income/add", module = "系统管理/角色提交")
    public ResponseData edit(Commission entity) {
        try{
            User user = AppUtil.getUser();
            commissionService.edit(entity);
            ResponseData data = ResponseData.ok() ;
            data.putDataValue("message","操作成功");
            data.putDataValue("entity", entity) ;

            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping("/confirm")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "财务管理|提成管理", note = "财务发送提成给业务员确认")
    @Verify(code = "/commission/confirm", module = "财务管理/财务发送提成给业务员确认")
    public ResponseData confirm(@RequestParam("id") Integer id) {
        try{
            User user = AppUtil.getUser();
            List<Role> roles = user.getRoles() ;
            Set<String> set = new HashSet<>() ;
            if(roles==null||roles.size()==0){
                throw new Exception("未查询到角色信息") ;
            }else{
                for(Role role:roles){
                    set.add(role.getType()) ;
                }
            }
            if(set.contains(IConst.ROLE_TYPE_CW)){
                Commission entity = commissionService.getById(id) ;
                entity.setState(IConst.STATE_YW);
                entity.setReleaseId(user.getId());
                entity.setReleaseTime(new Date());
                commissionService.edit(entity) ;

                //增加待办
                Items items = new Items();
                items.setItemName(entity.getName()+":"+entity.getYear()+"年"+entity.getMonth()+"月-提成确认等待处理");
                items.setItemContent("您有新的提成申请需要处理");
                items.setWorkType("提成确认");
                items.setInitiatorWorker(user.getId());
                items.setInitiatorDept(user.getDeptId());
                items.setStartTime(new Date());
                Calendar ca = Calendar.getInstance();
                ca.add(Calendar.DATE, 3);// 增加的天数3，
                items.setEndTime(ca.getTime());
                items.setTransactionAddress("/fee/queryCommission");
                items.setFinishAddress("/fee/queryCommission");
                User cw = userService.getAccountingInfo() ;
                items.setAcceptWorker(cw.getId()) ;
                items.setAcceptDept(cw.getDeptId());
                items.setTransactionState(Const.ITEM_W);
                itemsService.addItems(items);

                entity.setItemId(items.getId());
                commissionService.edit(entity) ;
                ResponseData data = ResponseData.ok() ;
                data.putDataValue("message","操作成功");
                data.putDataValue("entity", entity) ;
                return data ;
            }else{
                return ResponseData.customerError(1001,"只有财务才能发起提成确认流程！") ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping("/pass")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "财务管理|提成管理", note = "业务员确认提成通过")
    @Verify(code = "/commission/pass", module = "财务管理/业务员确认提成通过")
    public ResponseData pass(@RequestParam("id") Integer id) {
        try{
            User user = AppUtil.getUser();
            Commission comm = commissionService.getById(id) ;
            if(user.getId().intValue()==comm.getUserId().intValue()){
                Commission entity = commissionService.getById(id) ;
                entity.setState(IConst.STATE_PASS);
                commissionService.edit(entity) ;

                //待办变已办
                Items items = new Items();
                items.setId(entity.getItemId());
                items.setTransactionState(Const.ITEM_Y);
                itemsService.finishItems(items);
                //发消息
                Message message = new Message() ;
                message.setPic("/img/noPic.jpg") ;
//                message.setType(0) ;
                message.setContent(user.getName()+":"+comm.getYear()+"年"+comm.getMonth()+"月的提成由业务员核实通过！");
                message.setInitiatorWorker(user.getId());
                message.setInitiatorDept(user.getDeptId());
                User account = userService.getAccountingInfo() ;
                message.setAcceptWorker(account.getId());
                message.setAcceptDept(account.getDeptId());
                messageService.addMessage(message);

                ResponseData data = ResponseData.ok() ;
                data.putDataValue("message","操作成功");
                data.putDataValue("entity", entity) ;
                return data ;
            }else{
                return ResponseData.customerError(1001,"当前用户没有权限，需要业务员本人操作！") ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }
    @RequestMapping("/reject")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "财务管理|提成管理", note = "业务员确认提成驳回")
    @Verify(code = "/commission/reject", module = "财务管理/业务员确认提成驳回")
    public ResponseData reject(@RequestParam("id") Integer id) {
        try{
            User user = AppUtil.getUser();
            Commission comm = commissionService.getById(id) ;
            if(user.getId().intValue()==comm.getUserId().intValue()){
                Commission entity = commissionService.getById(id) ;
                entity.setState(IConst.STATE_REJECT);
                commissionService.edit(entity) ;
                //待办变已办
                Items items = new Items();
                items.setId(entity.getItemId());
                items.setTransactionState(Const.ITEM_Y);
                itemsService.finishItems(items);

                //发消息
                Message message = new Message() ;
                message.setPic("/img/noPic.jpg") ;
//                message.setType(0) ;
                message.setContent(user.getName()+":"+comm.getYear()+"年"+comm.getMonth()+"月的提成由业务员核实有误，请核实后重新发送确认！");
                message.setInitiatorWorker(user.getId());
                message.setInitiatorDept(user.getDeptId());
                User account = userService.getAccountingInfo() ;
                message.setAcceptWorker(account.getId());
                message.setAcceptDept(account.getDeptId());
                messageService.addMessage(message);

                ResponseData data = ResponseData.ok() ;
                data.putDataValue("message","操作成功");
                data.putDataValue("entity", entity) ;
                return data ;
            }else{
                return ResponseData.customerError(1001,"当前用户没有权限，需要业务员本人操作！") ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping("/release")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "财务管理|提成管理", note = "财务发放提成")
    @Verify(code = "/commission/release", module = "财务管理/财务发放提成")
    public ResponseData release(@RequestParam("id") Integer id) {
        try{
            User user = AppUtil.getUser();
            List<Role> roles = user.getRoles() ;
            Set<String> set = new HashSet<>() ;
            if(roles==null||roles.size()==0){
                throw new Exception("未查询到角色信息") ;
            }else{
                for(Role role:roles){
                    set.add(role.getType()) ;
                }
            }
            Commission comm = commissionService.getById(id) ;
            if(set.contains(IConst.ROLE_TYPE_CW)&&comm.getState()==IConst.STATE_PASS){
                Commission entity = commissionService.getById(id) ;
                entity.setState(IConst.STATE_FINISH);
                entity.setReleaseId(user.getId());
                entity.setReleaseTime(new Date());
                commissionService.edit(entity) ;

                //把稿件状态改成已提成
                List<Article> list = articleService.queryArticleForComm(comm.getUserId(),comm.getYear(),comm.getMonth()) ;
                if(list!=null && list.size()>0){
                    for(Article article : list){
                        article.setCommissionStates(1);
                        articleService.save(article) ;
                    }
                }
                //发消息
                Message message = new Message() ;
                message.setPic("/img/noPic.jpg") ;
//                message.setType(0) ;
                message.setContent(user.getName()+":"+comm.getYear()+"年"+comm.getMonth()+"月的提成已由财务核实完成！");
                message.setInitiatorWorker(user.getId());
                message.setInitiatorDept(user.getDeptId());
                message.setAcceptWorker(comm.getUserId());
                message.setAcceptDept(comm.getDeptId());
                messageService.addMessage(message);

                ResponseData data = ResponseData.ok() ;
                data.putDataValue("message","操作成功");
                data.putDataValue("entity", entity) ;
                return data ;
            }else{
                return ResponseData.customerError(1001,"权限不足或当前状态不允许提成！") ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }
}
