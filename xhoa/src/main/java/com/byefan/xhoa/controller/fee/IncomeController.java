package com.byefan.xhoa.controller.fee;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.entity.fee.Income;
import com.byefan.xhoa.entity.fee.IncomeUser;
import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.fee.IIncomeService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/income")
@Api(description = "进账流水接口")
public class IncomeController {

    @Autowired
    private IIncomeService incomeService;

    @ResponseBody
    @RequestMapping("/listPg")
    @Log(opType = OperateType.QUERY, module = "请款管理", note = "请款列表")
//    @Verify(code = "/role/listPg", module = "请款管理/请款列表")
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
                map.put("deptId",user.getDeptId()) ;
                list = incomeService.listPg(pageable.getPageNumber(), pageable.getPageSize(),map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list ;
    }

    @RequestMapping(value="/editAjax")
    @ResponseBody
//    @Verify(code = "/role/edit", module = "系统管理/角色编辑")
    public ResponseData editAjax(@RequestParam("id") Integer id) {
        try{
            ResponseData data = ResponseData.ok();
            Income entity = incomeService.getById(id) ;
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
            Income entity = incomeService.getById(id) ;
            data.putDataValue("entity",entity) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping(value="/del")
    @ResponseBody
    @Log(opType = OperateType.DELETE, module = "财务管理|进账流水管理", note = "删除进账流水")
    @Verify(code = "/income/del", module = "财务管理/删除进账")
    public ResponseData del(@RequestParam("id") Integer id) {
        try {
            List<IncomeUser> list = incomeService.queryIncomeUserByIncomeId(id) ;
            if(list==null || list.size()==0){
                Income entity = incomeService.getById(id) ;
                User user = AppUtil.getUser() ;
                if(entity.getCreator().intValue() == user.getId().intValue()){
                    incomeService.delById(id) ;
                    ResponseData data = ResponseData.ok();
                    data.putDataValue("message", "操作成功");
                    return data;
                }else{
                    return ResponseData.customerError(1001,"当前用户没有删除权限，录入人才能删除！") ;
                }
            }else{
                return ResponseData.customerError(1001, "该笔进账已被领取，无法删除！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    @Log(opType = OperateType.ADD, module = "财务管理|进账流水管理", note = "新增进账流水")
    @Verify(code = "/income/add", module = "财务管理/新增进账")
    public ResponseData add(Income entity) {
        try{
            User user = AppUtil.getUser() ;
            entity.setCreator(user.getId()) ;
            entity.setCreateTime(new Date());
            entity.setId(null);
            incomeService.add(entity);
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
    @Log(opType = OperateType.UPDATE, module = "财务管理|进账流水管理", note = "修改进账流水")
    @Verify(code = "/income/edit", module = "财务管理/编辑进账")
    public ResponseData edit(Income entity) {
        try{
            User user = AppUtil.getUser() ;
            Income oldEntity =  incomeService.getById(entity.getId()) ;
           //自己才能修改
            if(entity.getCreator().intValue() == user.getId().intValue()){
                //还没人领款才能编辑
                if(oldEntity.getUnclaimedAmount().toString().equals(oldEntity.getTradeAmount().toString())){
                    entity.setUpdateUserId(user.getId());
                    entity.setUnclaimedAmount(entity.getTradeAmount());
                    incomeService.edit(entity);
                    ResponseData data = ResponseData.ok();
                    data.putDataValue("message", "操作成功");
                    data.putDataValue("entity", entity) ;
                    return data;
                }else{
                    return ResponseData.customerError(1001,"当前进账流水已有人领取，无法修改！") ;
                }
            }else{
                return ResponseData.customerError(1001,"当前用户没有编辑权限，录入人才能编辑！") ;
            }
//            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }
    @RequestMapping(value="/receive")
    @ResponseBody
    @Verify(code = "/income/receive", module = "财务管理/领款")
    public ResponseData receive(@RequestParam("id") Integer id,@RequestParam("amount") Double amount) {
        try{
            ResponseData data = ResponseData.ok();
            User opUser = AppUtil.getUser() ;
            Income entity = incomeService.receiveIncome(id,amount,opUser) ;
            data.putDataValue("entity",entity) ;
            data.putDataValue("message","操作成功") ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping(value="/returnIncome")
    @ResponseBody
//    @Verify(code = "/role/edit", module = "系统管理/角色编辑")
    public ResponseData returnIncome(@RequestParam("id") Integer id){
        try{
            ResponseData data = ResponseData.ok();
            User user = AppUtil.getUser() ;
            List<IncomeUser> list = incomeService.queryIncomeUserByIncomeIdAndUserId(id,user.getId()) ;
            if(list!=null && list.size()>0){
                Map map = incomeService.querySumAmount(id,user.getId()) ;
                Double receiveAmount = (Double)map.get("receiveSum") ;
                Double remainAmount = (Double)map.get("remainSum") ;
                if(receiveAmount.toString().equals(remainAmount.toString())){
                    incomeService.returnIncome(id,receiveAmount,list) ;
                    data.putDataValue("message","操作成功") ;
                    return data ;
                }else{
                    return ResponseData.customerError(1001,"已分款，不能退回！") ;
                }
            }else{
                return ResponseData.customerError(1001,"您没有可退回的领款！") ;
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping(value="/assignAjax")
    @ResponseBody
//    @Verify(code = "/role/view", module = "系统管理/角色查看")
    public ResponseData assignAjax(@RequestParam("incomeId") Integer incomeId) {
        try{
            ResponseData data = ResponseData.ok();
            User user = AppUtil.getUser() ;
            IncomeUser incomeUser = incomeService.getIncomeUser(incomeId,user.getId()) ;
            data.putDataValue("entity",incomeUser) ;
            data.putDataValue("message","操作成功") ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping(value="/assignIncome")
    @ResponseBody
    @Verify(code = "/income/assignIncome", module = "财务管理/分款")
    public ResponseData assignIncome(@RequestParam Map map) {
        try{
            User user = AppUtil.getUser() ;
            ResponseData data = ResponseData.ok();
            incomeService.assignIncome(map,user) ;
            data.putDataValue("message","操作成功") ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping(value="/listPgForAssign")
    @ResponseBody
//    @Verify(code = "/role/view", module = "系统管理/角色查看")
    public PageInfo<Map> listPgForAssign(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        User user = AppUtil.getUser();
        map.put("id",user.getId());
        PageInfo<Map> list = incomeService.listPgForAssign(pageable.getPageNumber(), pageable.getPageSize(),map);
        return list;
    }

    @RequestMapping(value="/listPgForAssignAjax")
    @ResponseBody
//    @Verify(code = "/role/view", module = "系统管理/角色查看")
    public PageInfo<Map> listPgForAssignAjax(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        User user = AppUtil.getUser();
        map.put("userId",user.getId()) ;
        PageInfo<Map> list = incomeService.queryArticleForAssign(pageable.getPageNumber(), pageable.getPageSize(),map);
        return list;
    }

    @ResponseBody
    @RequestMapping("/listPgForSelectedArticle")
    @Log(opType = OperateType.QUERY, module = "财务管理|请款查询", note = "请款列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<Map> listPgForSelectedArticle(@PageableDefault(size = 5) Pageable pageable,@RequestParam("id") Integer id) {
        PageInfo<Map> list = incomeService.listPgForSelectedArticle(pageable.getPageNumber(), pageable.getPageSize(),id);
        return list;
    }

    @ResponseBody
    @RequestMapping("/listPaByArticleId")
    @Log(opType = OperateType.QUERY, module = "财务管理|获取稿件入账记录", note = "获取稿件入账记录")
    public PageInfo<Map> listPaByArticleId(@PageableDefault(size = 10) Pageable pageable, Article article) {
        PageHelper.startPage(pageable.getPageNumber(),pageable.getPageSize());
        List<Map> list = incomeService.listPgByArticleId(article);
        PageInfo<Map> pageInfo = new PageInfo<Map>(list);
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping("/listPgIncomeUserByIncomeId")
    @Log(opType = OperateType.QUERY, module = "进账管理|获取入账关联稿件详情", note = "获取入账关联稿件详情")
    public PageInfo<IncomeUser> listPgIncomeUserByIncomeId(@PageableDefault(size = 10) Pageable pageable, @RequestParam("id") Integer id) {
        PageHelper.startPage(pageable.getPageNumber(),pageable.getPageSize());
        List<IncomeUser> list = incomeService.queryIncomeUserByIncomeId(id);
        PageInfo<IncomeUser> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
