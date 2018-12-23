package com.byefan.xhoa.controller.fee;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.crm.Const;
import com.byefan.xhoa.entity.fee.Account;
import com.byefan.xhoa.entity.fee.Refund;
import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.entity.workbench.Items;
import com.byefan.xhoa.service.fee.IAccountService;
import com.byefan.xhoa.service.fee.IRefundService;
import com.byefan.xhoa.service.flow.IProcessService;
import com.byefan.xhoa.service.workbench.IItemsService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/refund")
@Api(description = "借款流水接口")
public class RefundController {

    @Autowired
    private IRefundService refundService;
    @Autowired
    private IProcessService processService;
    @Autowired
    private IItemsService itemsService;

    @ResponseBody
    @RequestMapping("/listPg")
//    @Log(opType = OperateType.QUERY, module = "角色管理", note = "角色列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<Map> listPg(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        PageInfo<Map> list = null ;
        try{
            User user = AppUtil.getUser() ;
            List<Role> roles = user.getRoles() ;
            if(roles==null||roles.size()==0){
                throw new Exception("未查询到角色信息") ;
            }else{
                map.put("roleType",roles.get(0).getType()) ;
                map.put("roleCode",roles.get(0).getCode()) ;
                map.put("user",user) ;
                list = refundService.listPg(pageable.getPageNumber(), pageable.getPageSize(),map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping(value="/editAjax")
    @ResponseBody
//    @Verify(code = "/role/edit", module = "系统管理/角色编辑")
    public ResponseData editAjax(@RequestParam("id") Integer id) {
        try{
            ResponseData data = ResponseData.ok();
            Refund entity = refundService.getById(id) ;

            Map map = refundService.querySumAmountById(id) ;
            Double refundAmount = (Double)map.get("sumRefundAmount") ;
            Double otherPay = (Double)map.get("sumOtherPay") ;
            Double applyAmount = refundAmount + otherPay ;
            entity.setRefundAmount(refundAmount);
            entity.setOtherPay(otherPay);
            entity.setApplyAmount(applyAmount);
            data.putDataValue("entity",entity) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping(value="/view")
    @ResponseBody
//    @Verify(code = "/role/view", module = "系统管理/角色查看")
    public ResponseData view(@RequestParam("id") Integer id) {
        try{
            ResponseData data = ResponseData.ok();
            Refund entity = refundService.getById(id) ;
            data.putDataValue("entity",entity) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping(value="/del")
    @ResponseBody
    @Log(opType = OperateType.DELETE, module = "财务管理|退款管理", note = "删除退款")
    @Verify(code = "/refund/del", module = "财务管理/删除退款")
    public ResponseData del(@RequestParam("id") Integer id) {
        try {
            Refund entity = refundService.getById(id) ;
            //state=0||state=1才能删除
            if(entity.getState()==IConst.STATE_REJECT||entity.getState()==IConst.STATE_SAVE){
                User user = AppUtil.getUser();
                refundService.reutrnCommInfo(id) ;
                refundService.changeRefundStates(id,0);
                refundService.delRefundArticle(id);
                refundService.delById(id,user) ;
                ResponseData data = ResponseData.ok();
                data.putDataValue("message", "操作成功");
                return data;
            }else{
                return ResponseData.customerError(1001, "当前状态不支持删除！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    /**
     * 暂不启用，使用saveStepOne()替代
     * @param entity
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
//    @Log(opType = OperateType.ADD, module = "财务管理|进账流水管理", note = "新增进账流水")
//    @Verify(code = "/income/add", module = "系统管理/角色提交")
    public ResponseData add(Refund entity) {
        try{
            User user = AppUtil.getUser();
            refundService.add(entity,user);
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
    @Log(opType = OperateType.UPDATE, module = "财务管理|退款管理", note = "修改退款")
    @Verify(code = "/refund/edit", module = "财务管理/修改退款")
    public ResponseData edit(Refund entity) {
        try{
            User user = AppUtil.getUser();
            //state=0||state=-1才能编辑
            if(entity.getState()==IConst.STATE_REJECT||entity.getState()==IConst.STATE_SAVE){
                entity.setState(IConst.STATE_BZ);
                refundService.edit(entity,user.getId());
                //urgencyLevel紧急程度，暂不启用
                processService.addRefundProcess(entity, 3);
                //refundStates发起退款置2，审批通过财务置1，默认0
                refundService.changeRefundStates(entity.getId(),2);
                ResponseData data = ResponseData.ok() ;
                data.putDataValue("message","操作成功");
                data.putDataValue("entity", entity) ;
                return data ;
            }else{
                return ResponseData.customerError(1001,"当前状态不支持修改！") ;
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    /**
     * 出纳出款
     * @param id
     * @param outAccountId
     * @param outAccountName
     * @param payAmount
     * @param payTime
     * @return
     */
    @RequestMapping("/confirm")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "财务管理|退款管理", note = "出纳确认退款")
    @Verify(code = "/refund/confirm", module = "财务管理/出纳确认退款")
    public ResponseData confirm(@RequestParam("id") Integer id,
                                @RequestParam("outAccountId") Integer outAccountId,
                                @RequestParam("outAccountName") String outAccountName,
                                @RequestParam("payAmount") Double payAmount,
                                @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date payTime) {
        try{
            User user = AppUtil.getUser() ;
            Boolean flag = false;

            if (user.getRoles() != null && user.getRoles().size() > 0) {
                for (Role role : user.getRoles()) {
                    if (IConst.ROLE_TYPE_CW.equals(role.getType())) {
                        flag = true;
                    }
                }
            };
            if(flag){
                Refund entity = refundService.getById(id) ;
                //state=2才能出款
                if(entity.getState()==IConst.STATE_PASS){
                    refundService.reutrnCommInfo(id) ;
                    entity.setOutAccountId(outAccountId);
                    entity.setOutAccountName(outAccountName);
                    entity.setPayAmount(payAmount);
                    entity.setPayTime(payTime);
                    entity.setState(IConst.STATE_FINISH);//1通过
                    refundService.edit(entity,user.getId());
                    //后处理稿件表的状态
                    //refundStates发起退款置2，审批通过财务置1，默认0
                    refundService.changeRefundStates(id,1);

                    //待办变已办
                    Items items = new Items();
                    items.setId(entity.getItemId());
                    items.setTransactionState(Const.ITEM_Y);
                    itemsService.finishItems(items);

                    ResponseData data = ResponseData.ok() ;
                    data.putDataValue("message","操作成功");
                    data.putDataValue("entity", entity) ;
                    return data ;
                }else{
                    return ResponseData.customerError(1001,"当前状态不支持该操作！") ;
                }
            }else{
                return ResponseData.customerError(1001,"当前用户没有操作权限！") ;
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }

    @ResponseBody
    @RequestMapping("/listPgForSelectedArticle")
//    @Log(opType = OperateType.QUERY, module = "财务管理|请款查询", note = "请款列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<Map> listPgForSelectedArticle(@PageableDefault(size = 5) Pageable pageable,@RequestParam("id") Integer id) {
        PageInfo<Map> list = refundService.listPgForSelectedArticle(pageable.getPageNumber(), pageable.getPageSize(),id);
        return list;
    }

    @RequestMapping(value="/listPgForSelectArticle")
    @ResponseBody
//    @Verify(code = "/role/view", module = "系统管理/角色查看")
    public PageInfo<Map> listPgForSelectArticle(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        User user = AppUtil.getUser() ;
        map.put("id",user.getId());
        PageInfo<Map> list = refundService.listPgForSelectArticle(pageable.getPageNumber(), pageable.getPageSize(),map);
        return list;
    }

    @RequestMapping("/saveStepOne")
    @ResponseBody
    @Log(opType = OperateType.ADD, module = "财务管理|退款管理", note = "新增退款")
    @Verify(code = "/refund/saveStepOne", module = "财务管理/新增退款")
    public ResponseData saveStepOne(@RequestParam Map map) {
        try{
            ResponseData data = ResponseData.ok() ;
            if(map.get("custCompanyIdSec") == null && map.get("custIdSec") == null || map.get("articleIdsSec") == null){
                return ResponseData.customerError(1001,"未选择客户或稿件！") ;
            }else{
                Refund entity = refundService.saveStepOne(map);
                data.putDataValue("entity",entity) ;
                data.putDataValue("message","操作成功");
                return data ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }

}
