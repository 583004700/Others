package com.byefan.xhoa.controller.fee;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.crm.Const;
import com.byefan.xhoa.entity.fee.Borrow;
import com.byefan.xhoa.entity.fee.Outgo;
import com.byefan.xhoa.entity.fee.OutgoBorrow;
import com.byefan.xhoa.entity.fee.Refund;
import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.entity.workbench.Items;
import com.byefan.xhoa.service.fee.IBorrowService;
import com.byefan.xhoa.service.fee.IOutgoService;
import com.byefan.xhoa.service.flow.IProcessService;
import com.byefan.xhoa.service.workbench.IItemsService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.flowable.spring.boot.app.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/outgo")
@Api(description = "请款流水接口")
public class OutgoController {

    @Autowired
    private IOutgoService outgoService;
    @Autowired
    private IBorrowService borrowService;
    @Autowired
    private IProcessService processService;
    @Autowired
    private IItemsService itemsService;

    @ResponseBody
    @RequestMapping("/listPg")
//    @Log(opType = OperateType.QUERY, module = "财务管理|请款查询", note = "请款列表")
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
                list = outgoService.listPg(pageable.getPageNumber(), pageable.getPageSize(),map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping(value="/editAjax")
    @ResponseBody
//    @Verify(code = "/role/edit", module = "系统管理/角色编辑")
    public ResponseData editAjax(@PageableDefault(size = 5) Pageable pageable,@RequestParam("id") Integer id) {
        try{
            ResponseData data = ResponseData.ok();
            Outgo entity = outgoService.getById(id) ;
//            PageInfo<Map> list = outgoService.listPgSelectedArticle(pageable.getPageNumber(), pageable.getPageSize(),id);
            data.putDataValue("entity",entity) ;
            List<Map> list = outgoService.queryBorrowById(entity.getId()) ;
            data.putDataValue("list",list) ;
            Double sumAmount = outgoService.getSumAmountById(entity.getId());
            data.putDataValue("sumAmount",sumAmount) ;
//            data.putDataValue("list",list) ;
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
            Outgo entity = outgoService.getById(id) ;
            data.putDataValue("entity",entity) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping(value="/del")
    @ResponseBody
    @Log(opType = OperateType.DELETE, module = "财务管理|请款流水管理", note = "删除请款流水")
    @Verify(code = "/outgo/del", module = "财务管理/删除请款")
    public ResponseData del(@RequestParam("id") Integer id) {
        try {
            Outgo entity = outgoService.getById(id);
            if (entity.getState()==IConst.STATE_SAVE ||entity.getState()==IConst.STATE_REJECT) {
//                User user = AppUtil.getUser() ;
                outgoService.delById(id) ;
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
     * 新增功能暂不启用，使用saveStepOne()替代
     * @param entity
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
//    @Log(opType = OperateType.ADD, module = "财务管理|请款管理", note = "新增请款流水")
//    @Verify(code = "/outgo/add", module = "系统管理/角色提交")
    public ResponseData add(Outgo entity) {
        try{
            User user = AppUtil.getUser();
            entity.setState(IConst.STATE_BZ);
            entity.setCreator(user.getId());
            entity.setCreateTime(new Date());
            outgoService.add(entity);
            // 紧急程度字段暂不启用
            // taskId为空：首次提交审批；不为空：驳回后提交审批
            processService.addMediaRefundProcess(entity, 0);
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
    @Log(opType = OperateType.UPDATE, module = "财务管理|请款管理", note = "修改请款")
    @Verify(code = "/outgo/edit", module = "财务管理/修改请款")
    public ResponseData edit(Outgo entity) {
        try{
            if(entity.getState()==IConst.STATE_SAVE ||entity.getState()==IConst.STATE_REJECT ){
                User user = AppUtil.getUser();
                entity.setState(IConst.STATE_BZ);
                entity.setUpdateUserId(user.getId());
                outgoService.edit(entity);
                outgoService.changeOutgoStates(entity.getId(),2);
                // 紧急程度字段暂不启用
                // taskId为空：首次提交审批；不为空：驳回后提交审批
                processService.addMediaRefundProcess(entity, 3);
                ResponseData data = ResponseData.ok() ;
                data.putDataValue("message","操作成功");
                data.putDataValue("entity", entity) ;
                return data ;
            }else{
                return ResponseData.customerError(1001,"当前状态不能编辑！") ;
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }

    /**
     * 出纳出款操作
     * @param id
     * @param outAccountId
     * @param outAccountName
     * @param payAmount
     * @param payTime
     * @return
     */
    @RequestMapping("/confirm")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "财务管理|进账流水管理", note = "出纳确认请款")
    @Verify(code = "/outgo/confirm", module = "财务管理/出纳确认请款")
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
            }
            ;
            if(flag){
                Outgo entity = outgoService.getById(id) ;
                //审批通过才能出款
                if(entity.getState()==IConst.STATE_PASS){
                    entity.setOutAccountId(outAccountId);
                    entity.setOutAccountName(outAccountName);
                    entity.setPayAmount(payAmount);
                    entity.setPayTime(payTime);
                    entity.setState(IConst.STATE_FINISH);//1通过
                    entity.setUpdateUserId(user.getId());
                    outgoService.edit(entity);
                    //后处理稿件表的状态
                    outgoService.changeOutgoStates(id,1);
                    //处理借款状态
                    List<Borrow> list = borrowService.queryByOutgoId(entity.getId()) ;
                    for(Borrow borrow:list){
                        OutgoBorrow ob = outgoService.getByOutgoIdAndBorrowId(entity.getId(),borrow.getId()) ;
                        Double amount = ob.getAmount() ;
                        borrow.setRemainAmount(borrow.getRemainAmount()-amount);
                        borrow.setRepayAmount(borrow.getPayAmount()+amount);
                        if(borrow.getRemainAmount()>amount){
                            //还清了，置标志位为1
                            borrow.setRepayFlag(1) ;
                        }
                    }
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
                    return ResponseData.customerError(1001,"当前状态不支持出款操作") ;
                }
            }else{
                return ResponseData.customerError(1001,"当前用户不支持出款操作") ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }

    /**
     * add方法
     * @param map
     * @return
     */
    @RequestMapping("/saveStepOne")
    @ResponseBody
    @Log(opType = OperateType.ADD, module = "财务管理|请款管理", note = "新增请款")
    @Verify(code = "/outgo/saveStepOne", module = "财务管理/新增请款")
    public ResponseData saveStepOne(@RequestParam Map map) {
        try{
            ResponseData data = ResponseData.ok() ;
            if(map.get("supplierIdSec")==null && map.get("supplierNameSec")==null || map.get("articleIdsSec")==null){
                return ResponseData.customerError(1001,"未选择供应商或稿件！") ;
            }else{
                User user = AppUtil.getUser();
                Outgo entity = outgoService.saveStepOne(map,user);
                data.putDataValue("entity",entity) ;
                List<Map> list = outgoService.queryBorrowById(entity.getId()) ;
                data.putDataValue("list",list) ;
                data.putDataValue("message","操作成功");
                return data ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }

    /**
     * 该请款已经关联的稿件
     * @param pageable
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/listPgForSelectedArticle")
//    @Log(opType = OperateType.QUERY, module = "财务管理|请款查询", note = "请款列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<Map> listPgForSelectedArticle(@PageableDefault(size = 5) Pageable pageable,@RequestParam("id") Integer id) {
        PageInfo<Map> list = outgoService.listPgForSelectedArticle(pageable.getPageNumber(), pageable.getPageSize(),id);
        return list;
    }


    /**
     * 选择未请款的稿件
     * @param pageable
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/listPgForSelectArticle")
//    @Log(opType = OperateType.QUERY, module = "财务管理|请款查询", note = "请款列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<Map> listPgForSelectArticle(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        PageInfo<Map> list = outgoService.listPgForSelectArticle(pageable.getPageNumber(), pageable.getPageSize(),map);
        return list;
    }

    /**
     * 保存请款关联的备用金信息
     * @param map
     * @return
     */
    @RequestMapping("/saveOutgoBorrow")
    @ResponseBody
//    @Log(opType = OperateType.UPDATE, module = "财务管理|请款流水管理", note = "修改请款流水")
//    @Verify(code = "/outgo/add", module = "系统管理/角色提交")
    public ResponseData saveOutgoBorrow(@RequestParam Map map) {
        try{
            ResponseData data = ResponseData.ok() ;
            Double amount = 0.0 ;
            if(map.get("outgoId")==null && map.get("borrowIds")==null){
                return ResponseData.customerError(1001,"未选择备付金信息！") ;
            }else{
                Integer outgoId = Integer.parseInt((String)map.get("outgoId")) ;
                outgoService.deleteByOutgoId(outgoId);
                String borrowIds = (String)map.get("borrowIds") ;
                if(borrowIds.indexOf(",")>-1){
                    String[] ids = borrowIds.split(",") ;
                    for(int i=0;i<ids.length;i++){
                        OutgoBorrow ob = new OutgoBorrow() ;
                        ob.setOutgoId(outgoId);
                        ob.setBorrowId(Integer.parseInt(ids[i]));
                        String fundAmount = (String)map.get("fund_"+ids[i]) ;
                        Double temp = StringUtils.isNotEmpty(fundAmount)?Double.parseDouble(fundAmount):0 ;
                        ob.setAmount(temp);
                        amount += temp ;
                        outgoService.insertOutgoBorrrow(ob);
                    }
                }else{
                    OutgoBorrow ob = new OutgoBorrow() ;
                    ob.setOutgoId(outgoId);
                    ob.setBorrowId(Integer.parseInt(borrowIds));
                    String fundAmount = (String)map.get("fund_"+borrowIds) ;
                    Double temp = StringUtils.isNotEmpty(fundAmount)?Double.parseDouble(fundAmount):0 ;
                    ob.setAmount(temp);
                    amount += temp ;
                    outgoService.insertOutgoBorrrow(ob);
                }
                Outgo entity = outgoService.getById(outgoId) ;
                entity.setFundAmount(amount);
                outgoService.updateEntity(entity) ;
//                Outgo entity = outgoService.saveStepOne(map);
                data.putDataValue("amount",amount) ;
                List<Map> list = outgoService.queryBorrowById(outgoId) ;
                data.putDataValue("list",list) ;
                data.putDataValue("message","操作成功");
                return data ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }

    /**
     * 清除选中的备用金信息
     * @param id
     * @return
     */
    @RequestMapping("/cleanOutgoBorrow")
    @ResponseBody
//    @Log(opType = OperateType.UPDATE, module = "财务管理|请款流水管理", note = "修改请款流水")
//    @Verify(code = "/outgo/add", module = "系统管理/角色提交")
    public ResponseData cleanOutgoBorrow(@RequestParam("id") Integer id) {
        try{
            ResponseData data = ResponseData.ok() ;
            outgoService.deleteByOutgoId(id);
            Outgo entity = outgoService.getById(id) ;
            entity.setFundAmount(0.0);
            outgoService.updateEntity(entity) ;
            data.putDataValue("message","操作成功");
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }

}
