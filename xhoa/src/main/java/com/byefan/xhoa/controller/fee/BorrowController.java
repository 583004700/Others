package com.byefan.xhoa.controller.fee;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.config.Config;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.core.utils.UUIDUtil;
import com.byefan.xhoa.entity.crm.Const;
import com.byefan.xhoa.entity.fee.Borrow;
import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.entity.workbench.Items;
import com.byefan.xhoa.entity.workbench.Message;
import com.byefan.xhoa.service.fee.IBorrowService;
import com.byefan.xhoa.service.fee.IBorrowService;
import com.byefan.xhoa.service.flow.IProcessService;
import com.byefan.xhoa.service.sys.IUserService;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/borrow")
@Api(description = "借款流水接口")
public class BorrowController {

    @Autowired
    private IBorrowService borrowService;
    @Autowired
    private IProcessService processService;
    @Autowired
    private IItemsService itemsService;
    @Autowired
    private IUserService userService;
    @Autowired
    private Config config ;

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
                list = borrowService.listPg(pageable.getPageNumber(), pageable.getPageSize(),map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @ResponseBody
    @RequestMapping("/listPgForOutgo")
//    @Log(opType = OperateType.QUERY, module = "角色管理", note = "角色列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<Map> listPgForOutgo(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        PageInfo<Map> list = borrowService.listPgForOutgo(pageable.getPageNumber(), pageable.getPageSize(),map);
        return list;
    }

    @RequestMapping(value="/editAjax")
    @ResponseBody
//    @Verify(code = "/role/edit", module = "系统管理/角色编辑")
    public ResponseData editAjax(@RequestParam("id") Integer id) {
        try{
            ResponseData data = ResponseData.ok();
            Borrow entity = borrowService.getById(id) ;
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
            Borrow entity = borrowService.getById(id) ;
            data.putDataValue("entity",entity) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping(value="/del")
    @ResponseBody
    @Log(opType = OperateType.DELETE, module = "财务管理|借款管理", note = "删除借款")
    @Verify(code = "/borrow/del", module = "财务管理/删除借款")
    public ResponseData del(@RequestParam("id") Integer id) {
        try {
            Borrow entity = borrowService.getById(id) ;
            if(entity.getState()==IConst.STATE_REJECT||entity.getState()==IConst.STATE_SAVE){
                borrowService.delById(id) ;
                ResponseData data = ResponseData.ok();
                data.putDataValue("message", "操作成功");
                return data;
            }else{
                return ResponseData.customerError(1001, "当前状态不支持删除操作");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    @Log(opType = OperateType.ADD, module = "财务管理|借款管理", note = "新增借款")
    @Verify(code = "/borrow/add", module = "财务管理/新增借款")
    public ResponseData add(Borrow entity, @RequestParam(value = "affix", required = false) MultipartFile multipartFile) {
        try{
            if(multipartFile!=null) {
                String fileName = UUIDUtil.get32UUID() + multipartFile.getOriginalFilename();
                String childPath = "/fee/borrow/";
                File destFile = new File(config.getUploadDir() + childPath + fileName);
                if (!destFile.getParentFile().exists()) {
                    destFile.getParentFile().mkdirs();
                }
                multipartFile.transferTo(destFile);
                entity.setAffixName(multipartFile.getOriginalFilename());
                entity.setAffixLink(config.getWebDir() + childPath + fileName);
            }
            User user = AppUtil.getUser();
            entity.setId(null);
            entity.setApplyId(user.getId());
            entity.setApplyName(user.getName());
            entity.setDeptId(user.getDeptId());
            entity.setDeptName(user.getDeptName()) ;
            entity.setCreator(user.getId());
            entity.setApplyTime(new Date());
            entity.setCreateTime(new Date());
            borrowService.add(entity);
            // 紧急程度字段暂不启用
            // taskId为空：首次提交审批；不为空：驳回后提交审批
            processService.addBorrowProcess(entity, 3);
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
    @Log(opType = OperateType.UPDATE, module = "财务管理|借款管理", note = "修改借款")
    @Verify(code = "/borrow/edit", module = "财务管理/修改借款")
    public ResponseData edit(Borrow entity, @RequestParam(value = "file", required = false) MultipartFile multipartFile) {
        try{
            if(entity.getState()==IConst.STATE_SAVE||entity.getState()==IConst.STATE_REJECT){
                if(multipartFile!=null){
                    String fileName = UUIDUtil.get32UUID() + multipartFile.getOriginalFilename();
                    String childPath = "/fee/borrow/";
                    File destFile = new File(config.getUploadDir() + childPath + fileName);
                    if (!destFile.getParentFile().exists()) {
                        destFile.getParentFile().mkdirs();
                    }
                    multipartFile.transferTo(destFile);
                    if(!StringUtils.isEmpty(multipartFile.getOriginalFilename())){
                        entity.setAffixName(multipartFile.getOriginalFilename());
                    }
                    entity.setAffixLink(config.getWebDir() + childPath + fileName);
                }

                User user = AppUtil.getUser();
                entity.setState(IConst.STATE_BZ);
                entity.setUpdateUserId(user.getId());
                borrowService.edit(entity);
                // 紧急程度字段暂不启用
                // taskId为空：首次提交审批；不为空：驳回后提交审批
                processService.addBorrowProcess(entity, 3);
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

    @RequestMapping("/confirm")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "财务管理|借款管理", note = "出纳确认借款")
    @Verify(code = "/borrow/confirm", module = "财务管理/出纳确认借款")
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
            ResponseData data = ResponseData.ok();
            if(flag){
                Borrow entity = borrowService.getById(id) ;
                if(entity.getState()==IConst.STATE_PASS){
                    entity.setOutAccountId(outAccountId);
                    entity.setOutAccountName(outAccountName);
                    entity.setPayAmount(payAmount);
                    entity.setRemainAmount(payAmount);
                    entity.setPayTime(payTime);
                    entity.setState(IConst.STATE_FINISH);//1通过
                    borrowService.edit(entity);

                    //待办变已办
                    Items items = new Items();
                    items.setId(entity.getItemId());
                    items.setTransactionState(Const.ITEM_Y);
                    itemsService.finishItems(items);

                    data.putDataValue("message","操作成功");
                    data.putDataValue("entity", entity) ;
                    return data ;
                }else{
                    return ResponseData.customerError(1001,"当前状态不支持该操作") ;
                }
            }else{
                return ResponseData.customerError(1001,"当前用户不支持该操作") ;
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    /**
     * 还款
     */
    @RequestMapping("/repay")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "财务管理|借款管理", note = "还款")
//    @Verify(code = "/borrow/repay", module = "财务管理/还款")
    public ResponseData repay (@RequestParam("id") Integer id,
                               @RequestParam("amount") Double amount,
                               @RequestParam("repayRemark") String repayRemark
    ) {
        try{
            User user = AppUtil.getUser() ;
            Borrow entity = borrowService.getById(id) ;
            if(entity.getRepaying()==0){
                entity.setRepaying(1) ;
                entity.setAmount(amount) ;
                entity.setRepayRemark(repayRemark);
                entity.setRepayTime(new Date());
                entity.setUpdateUserId(user.getId());

                //增加待办
                Items items = new Items();
                items.setItemName(entity.getTitle()+"-还款确认等待处理");
                items.setItemContent("您有新的还款申请需要处理");
                items.setWorkType("还款申请");
                items.setInitiatorWorker(user.getId());
                items.setInitiatorDept(user.getDeptId());
                items.setStartTime(new Date());
                Calendar ca = Calendar.getInstance();
                ca.add(Calendar.DATE, 3);// 增加的天数3，
                items.setEndTime(ca.getTime());
                items.setTransactionAddress("/fee/queryBorrow");
                items.setFinishAddress("/fee/queryBorrow");
                User cw = userService.getAccountingInfo() ;
                items.setAcceptWorker(cw.getId()) ;
                items.setAcceptDept(cw.getDeptId());
                items.setTransactionState(Const.ITEM_W);
                itemsService.addItems(items);

                entity.setItemId(items.getId());
                borrowService.edit(entity);
                ResponseData data = ResponseData.ok() ;
                data.putDataValue("message","操作成功");
                data.putDataValue("entity", entity) ;
                return data ;
            }else{
                return ResponseData.customerError(1001,"请勿重复提交") ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    /**
     * 还款确认
     */
    @RequestMapping("/repayConfirm")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "财务管理|借款管理", note = "还款确认通过")
//    @Verify(code = "/borrow/repay", module = "财务管理/还款")
    public ResponseData repayConfirm (@RequestParam("id") Integer id,
                               @RequestParam("amount") Double amount
    ) {
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
            if(flag){//财务才能执行该操作
                Borrow entity = borrowService.getById(id) ;
                if(entity.getRepaying()==1){//还款中
                    entity.setRepayAmount(entity.getRepayAmount()+amount);
                    entity.setRemainAmount(entity.getPayAmount()-amount);
                    if(entity.getRepayAmount()<entity.getPayAmount()){
                        //还了部分
                        entity.setRepayFlag(2);
                    }else{
                        //全部还清
                        entity.setRepayFlag(1);
                    }
                    entity.setRepaying(0);
                    entity.setUpdateUserId(user.getId());
                    borrowService.edit(entity);

                    //待办变已办
                    Items items = new Items();
                    items.setId(entity.getItemId());
                    items.setTransactionState(Const.ITEM_Y);
                    itemsService.finishItems(items);

                    //发消息

                    ResponseData data = ResponseData.ok() ;
                    data.putDataValue("message","操作成功");
                    data.putDataValue("entity", entity) ;
                    return data ;
                }else{
                    return ResponseData.customerError(1001,"当前状态不支持该操作") ;
                }
            }else{
                return ResponseData.customerError(1001,"当前用户不支持该操作") ;
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    /**
     * 还款确认
     */
    @RequestMapping("/repayReject")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "财务管理|借款管理", note = "还款确认驳回")
//    @Verify(code = "/borrow/repay", module = "财务管理/还款")
    public ResponseData repayReject (@RequestParam("id") Integer id
    ) {
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
            if(flag){//财务才能执行该操作
                Borrow entity = borrowService.getById(id) ;
                if(entity.getRepaying()==1){//还款中
                    entity.setRepaying(0);
                    entity.setUpdateUserId(user.getId());
                    borrowService.edit(entity);

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
                    return ResponseData.customerError(1001,"当前状态不支持该操作") ;
                }
            }else{
                return ResponseData.customerError(1001,"当前用户不支持该操作") ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }
}
