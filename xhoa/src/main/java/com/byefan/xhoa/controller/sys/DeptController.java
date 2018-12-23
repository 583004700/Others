package com.byefan.xhoa.controller.sys;

import com.alibaba.fastjson.JSONArray;
import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.sys.Dept;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.sys.IDeptService;
import com.byefan.xhoa.utils.IConst;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/dept")
@Api(description = "部门接口")
public class DeptController {

    @Autowired
    private IDeptService deptService;

//    @RequestMapping("/list")
//    @ResponseBody
//    public ModelAndView list(HttpServletRequest request) {
//        List<Object> list = deptService.listAll();
//        Integer maxLevel = deptService.getMaxLevel() ;
//        ModelAndView mav = new ModelAndView("/system/queryDept1") ;
//        mav.addObject("list",list) ;
//        mav.addObject("maxLevel",maxLevel) ;
//        return mav ;
//    }

    @RequestMapping("/list")
    @ResponseBody
//    @Log(opType = OperateType.QUERY, module = "系统管理", note = "部门列表")
//    @Verify(code = "/dept/list", module = "系统管理/部门列表")
    public ResponseData query() {
        try {
            ResponseData data = ResponseData.ok();
            JSONArray list  = new JSONArray() ;
            list = deptService.list() ;
            data.putDataValue("list",list) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }

    @RequestMapping("/listForTreeView")
    @ResponseBody
//    @Log(opType = OperateType.QUERY, module = "系统管理", note = "部门列表")
//    @Verify(code = "/dept/listForTreeView", module = "系统管理/部门列表")
    public ResponseData listForTreeView() {
        try {
            ResponseData data = ResponseData.ok();
            JSONArray list  = new JSONArray() ;
            list = deptService.listForTreeView() ;
            data.putDataValue("list",list) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }
    @RequestMapping("/edit")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "系统管理|部门管理", note = "修改部门")
    @Verify(code = "/dept/edit", module = "系统管理/修改部门")
    public ResponseData edit(Dept dept) {
        try {
            ResponseData data = ResponseData.ok();
            deptService.editDept(dept);
            data.putDataValue("message","操作成功");
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }
    @RequestMapping("/del")
    @ResponseBody
    @Log(opType = OperateType.DELETE, module = "系统管理|部门管理", note = "删除部门")
    @Verify(code = "/dept/del", module = "系统管理/删除部门")
    public ResponseData del(@RequestParam("id") Integer id) {
        try {
            ResponseData data = ResponseData.ok();
            deptService.delDept(id);
            data.putDataValue("message","操作成功");
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }
    @RequestMapping("/addChild")
    @ResponseBody
    @Log(opType = OperateType.ADD, module = "系统管理|部门管理", note = "添加子部门")
    @Verify(code = "/dept/addChild", module = "系统管理/添加子部门")
    public ResponseData addChildDept(@RequestParam Map map,HttpSession session) {
        try {
            User user = (User)session.getAttribute(IConst.USER_KEY) ;
            if(user==null){
                return ResponseData.customerError(1001,"session失效！") ;
            }else{
                ResponseData data = ResponseData.ok();
                map.put("userId",user.getId()) ;
                deptService.addChildDept(map);
                data.putDataValue("message","操作成功");
                return data ;
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }
    @RequestMapping(value="/checkName")
    @ResponseBody
//    @Verify(code = "/role/checkName", module = "系统管理/部门名称排重")
    public ResponseData checkName(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("childName") String childName) {
        try {
            ResponseData data = ResponseData.ok() ;
            Boolean flag = false ;

            if(StringUtils.isNotEmpty(childName)){
                //childName非空，验证的添加子子部门
                List<Dept> list2 = deptService.queryDeptByName(childName) ;
                if(list2.size()==0){
                    flag = true ;
                }

            }else{
                //验证修改节点
                Dept dept = deptService.getById(id) ;
                if(name.equals(dept.getName())){
                    flag = true ;
                }else{
                    List<Dept> list = deptService.queryDeptByName(name) ;
                    if(list.size()==0){
                        flag = true ;
                    }
                }
            }
            data.putDataValue("flag",flag) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }

    /**
     * 根据类型查找部门
     * @param type
     * @return
     */
    @RequestMapping(value="/listByType")
    @ResponseBody
    public List<Dept> listByType(@RequestParam(required = false,value = "type") String type){
        return deptService.listByType(type);
    }

}
