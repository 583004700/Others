package com.byefan.xhoa.controller.fee;

import com.byefan.core.ResponseData;
import com.byefan.xhoa.entity.fee.Reimburse;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.fee.IReimburseService;
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
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/reimburse")
@Api(description = "借款流水接口")
public class ReimburseController {

    @Autowired
    private IReimburseService reimburseService;

    @ResponseBody
    @RequestMapping("/listPg")
//    @Log(opType = OperateType.QUERY, module = "角色管理", note = "角色列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<Map> listPg(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        PageInfo<Map> list = reimburseService.listPg(pageable.getPageNumber(), pageable.getPageSize(),map);
        return list;
    }

    @RequestMapping(value="/editAjax")
    @ResponseBody
//    @Verify(code = "/role/edit", module = "系统管理/角色编辑")
    public ResponseData editAjax(@RequestParam("id") Integer id) {
        try{
            ResponseData data = ResponseData.ok();
            Reimburse entity = reimburseService.getById(id) ;
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
            Reimburse entity = reimburseService.getById(id) ;
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
            reimburseService.delById(id) ;
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
    public ResponseData add(Reimburse entity, HttpSession session) {
        try{
            User user = (User)session.getAttribute(IConst.USER_KEY);
            reimburseService.add(entity,user.getId());
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
    public ResponseData edit(Reimburse entity, HttpSession session) {
        try{
            User user = (User)session.getAttribute(IConst.USER_KEY);
            reimburseService.edit(entity,user.getId());
            ResponseData data = ResponseData.ok() ;
            data.putDataValue("message","操作成功");
            data.putDataValue("entity", entity) ;

            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }

}
