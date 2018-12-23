package com.byefan.xhoa.controller.fee;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.fee.Account;
import com.byefan.xhoa.entity.fee.IncomeUser;
import com.byefan.xhoa.entity.sys.Dept;
import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.fee.IAccountService;
import com.byefan.xhoa.service.fee.IIncomeService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/account")
@Api(description = "银行账户管理接口")
public class AccountController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private IIncomeService incomeService;

    @ResponseBody
    @RequestMapping("/listPg")
//    @Log(opType = OperateType.QUERY, module = "系统管理|账户管理", note = "账户列表")
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
                list = accountService.listPg(pageable.getPageNumber(), pageable.getPageSize(),map);
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
            Account entity = accountService.getById(id) ;
            List<Dept> list = accountService.queryDeptByAccountId(entity.getId()) ;
            data.putDataValue("entity",entity) ;
            data.putDataValue("list",list) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping(value="/view")
    @ResponseBody
//    @Verify(code = "/account/view", module = "系统管理/角色查看")
    public ResponseData view(@RequestParam("id") Integer id) {
        try{
            ResponseData data = ResponseData.ok();
            Account entity = accountService.getById(id) ;
            List<Dept> list = accountService.queryDeptByAccountId(entity.getId()) ;
            data.putDataValue("entity",entity) ;
            data.putDataValue("list",list) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    /**
     * 删除账户时删除对应的账户关联部门信息
     * @param id
     * @return
     */
    @RequestMapping(value="/del")
    @ResponseBody
    @Log(opType = OperateType.DELETE, module = "财务管理", note = "删除账户")
    @Verify(code = "/account/del", module = "财务管理/删除账户")
    public ResponseData del(@RequestParam("id") Integer id) {
        try {
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
            Account entity = accountService.getById(id) ;
            if(entity.getCreator().intValue()==user.getId().intValue()||set.contains(IConst.ROLE_TYPE_CW)){
                ResponseData data = ResponseData.ok();
                List list = incomeService.queryIncomeByAccountId(id) ;
                if(list!=null && list.size()>0){
                    return ResponseData.customerError(1001, "该账号已有金额流水记录，不支持删除操作！");
                }else{
                    accountService.delById(id) ;
                    accountService.deleteAccountDept(id);
                    data.putDataValue("message", "操作成功");
                }
                return data;
            }else{
                return ResponseData.customerError(1001, "您没有权限删除本条记录！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    @Log(opType = OperateType.ADD, module = "财务管理|账户管理", note = "新增账户")
    @Verify(code = "/account/add", module = "财务管理/新增账户")
    public ResponseData add(Account entity) {
        try{
            //编辑和新增公用一个页面，导致页面id可能有值，以防万一，新增时删掉id
            entity.setId(null) ;
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
            if(entity.getCompanyId()==0){
                if(set.contains(IConst.ROLE_TYPE_CW)){//财务添加的是公司账户
                    entity.setType(IConst.ACCOUNT_TYPE_COMPANY);
                }else{//私人账户
                    entity.setType(IConst.ACCOUNT_TYPE_PERSONAL);
                }
            }
            entity.setCreator(user.getId());
            entity.setCreateTime(new Date());
            entity.setState(IConst.STATE_FINISH);
            accountService.add(entity);
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
    @Log(opType = OperateType.UPDATE, module = "财务管理|账户管理", note = "修改账户")
    @Verify(code = "/account/edit", module = "财务管理/修改账户")
    public ResponseData edit(Account entity) {
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
            if(user.getId().intValue()==entity.getCreator().intValue()||set.contains(IConst.ROLE_TYPE_CW)){
                entity.setUpdateUserId(user.getId());
                entity.setState(IConst.STATE_FINISH);
                accountService.edit(entity);
                List<Dept> list = accountService.queryDeptByAccountId(entity.getId()) ;
                ResponseData data = ResponseData.ok() ;
                data.putDataValue("message","操作成功");
                data.putDataValue("entity", entity) ;
                data.putDataValue("list",list) ;
                return data ;
            }else{
                return ResponseData.customerError(1001,"当前用户没有编辑权限，录入人才能编辑！") ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }


    @RequestMapping("/insertAccountDept")
    @ResponseBody
    @Log(opType = OperateType.ADD, module = "财务管理|账户管理", note = "账户关联部门")
    @Verify(code = "/account/insertAccountDept", module = "账户管理/账户关联部门")
    public ResponseData insertAccountDept(@RequestParam("accountId") Integer accountId,@RequestParam("deptId") Integer deptId) {
        try{

            accountService.insertAccountDept(accountId,deptId);
            ResponseData data = ResponseData.ok() ;
            data.putDataValue("message","操作成功");
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping("/deleteAccountDept")
    @ResponseBody
    @Log(opType = OperateType.DELETE, module = "财务管理|账户管理", note = "删除账户关联部门")
    @Verify(code = "/account/deleteAccountDept", module = "账户管理/删除账户关联部门")
    public ResponseData deleteAccountDept(@RequestParam("accountId") Integer accountId,@RequestParam("deptId") Integer deptId) {
        try{
            accountService.deleteAccountDept(accountId,deptId);
            ResponseData data = ResponseData.ok() ;
            data.putDataValue("message","操作成功");
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }
    /**
     *
     * @param type=3 客户账户
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryCustAccount")
//    @Log(opType = OperateType.QUERY, module = "系统管理|账户管理", note = "账户列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<Map> queryCustAccount(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        PageInfo<Map> list = null ;
        try{
            if(map.get("custId")!=null){
                Integer custId = Integer.parseInt((String)map.get("custId")) ;
                list = accountService.listPgForSelectAccount(pageable.getPageNumber(), pageable.getPageSize(),custId,IConst.ACCOUNT_TYPE_CUST,map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    /**
     *
     * @param type=2 供应商账户
     * @return
     */
    @ResponseBody
    @RequestMapping("/querySupplierAccount")
//    @Log(opType = OperateType.QUERY, module = "系统管理|账户管理", note = "账户列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<Map> querySupplierAccount(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        PageInfo<Map> list = null ;
        try{
            if(map.get("supplierId")!=null){
                Integer supplierId = Integer.parseInt((String)map.get("supplierId")) ;
                list = accountService.listPgForSelectAccount(pageable.getPageNumber(), pageable.getPageSize(),supplierId,IConst.ACCOUNT_TYPE_SUPPLIER,map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     *
     * @param companyId=0,type=1 公司公用账户
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryInnerAccount")
//    @Log(opType = OperateType.QUERY, module = "系统管理|账户管理", note = "账户列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<Map> queryInnerAccount(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        return accountService.listPgForSelectAccount(pageable.getPageNumber(), pageable.getPageSize(),0,IConst.ACCOUNT_TYPE_COMPANY,map);
    }
    /**
     *
     * @param companyId=0,type=4 公司个人账户
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryInnerAccountForUser")
//    @Log(opType = OperateType.QUERY, module = "系统管理|账户管理", note = "账户列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<Map> queryInnerAccountForUser(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        User user = AppUtil.getUser();
        //把用户id传进去，如果是借款到个人账户，就只选择显示个人账户信息，
        // 不传用户id了，显示全部公司内部的账户，
//        map.put("dockingId",user.getId()) ;
        return accountService.listPgForSelectAccount(pageable.getPageNumber(), pageable.getPageSize(),0,IConst.ACCOUNT_TYPE_PERSONAL,map);
    }
}
