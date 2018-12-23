package com.byefan.xhoa.controller.sys;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.sys.Group;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.sys.IGroupService;
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
import java.util.List;
import java.util.Map;
@Slf4j
@Controller
@RequestMapping("/group")
@Api(description = "权限组接口")
public class GroupController {
    @Autowired
    private IGroupService groupService  ;

//    @RequestMapping("/listPg")
//    @ResponseBody
//    public PageInfo<Group> list(@PageableDefault(size = 5) Pageable pageable){
//        PageInfo<Group> groups = groupService.listAll(pageable.getPageNumber(),pageable.getPageSize()) ;
//        return groups ;
//    }

    @RequestMapping("/listPg")
    @ResponseBody
    @Log(opType = OperateType.QUERY, module = "权限组管理", note = "权限组列表")
//    @Verify(code = "/group/listPg", module = "系统管理/权限组列表")
    public PageInfo<Map> listPg(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map){
        PageInfo<Map> groups = groupService.listPg(pageable.getPageNumber(),pageable.getPageSize(),map) ;
        return groups ;
    }
    @RequestMapping("/allGroups")
    @ResponseBody
//    @Verify(code = "/group/allGroup", module = "系统管理/查询所有权限组")
    public List<Group> allGroups(){
        List<Group> groups = groupService.allGroups() ;
        return groups ;
    }
    @RequestMapping(value="/del")
    @ResponseBody
    @Log(opType = OperateType.DELETE, module = "权限组管理", note = "删除权限组")
    @Verify(code = "/group/del", module = "系统管理/删除权限组")
    public ResponseData delGroup(@RequestParam("id") Integer id) {
        try {
            Group sysGroup = groupService.delById(id) ;
            ResponseData data = ResponseData.ok();
            data.putDataValue("message", "操作成功");
            data.putDataValue("sysGroup", sysGroup);

            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
//            return "redirect:/login";
        }
    }
    //    @RequestMapping("/submitGroup")
//    @ResponseBody
//    public SysGroup submitGroup(SysGroup sr) {
//        SysGroup sysGroup = GroupService.submitGroup(sr);
//        return sysGroup ;
//    }

    /**
     * 权限组修改
     * @param group
     * @param session
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "权限组管理", note = "更改权限组")
//    @Verify(code = "/group/update", module = "系统管理/提交权限组更改")
    public ResponseData update(Group group, HttpSession session) {
        try{
            User user = (User)session.getAttribute(IConst.USER_KEY) ;
            groupService.updateGroup(group);
            group.setUpdateUserId(user.getId());
            ResponseData data = ResponseData.ok() ;
            data.putDataValue("message","操作成功");
            data.putDataValue("group",group) ;

            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }

    /**
     * 权限组添加
     * @param group
     * @param session
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    @Log(opType = OperateType.ADD, module = "权限组管理", note = "添加权限组")
//    @Verify(code = "/group/add", module = "系统管理/提交权限组更改")
    public ResponseData add(Group group, HttpSession session) {
        try{
            User user = (User)session.getAttribute(IConst.USER_KEY) ;
            group.setId(null);
            group.setCreator(user.getId());
            groupService.saveGroup(group);
            ResponseData data = ResponseData.ok() ;
            data.putDataValue("message","操作成功");
            data.putDataValue("group",group) ;

            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }


    @RequestMapping(value="/edit")
    @ResponseBody
    @Verify(code = "/group/edit", module = "系统管理/编辑权限组")
    public ResponseData editGroup(@RequestParam("id")Integer id) {
        try{
            ResponseData data = ResponseData.ok();
            Group group = groupService.getGroupById(id) ;
            data.putDataValue("group",group) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }
//    @RequestMapping(value="/add")
//    @ResponseBody
//    public ModelAndView addGroup(HttpServletRequest request) {
//        ModelAndView mav = new ModelAndView("/system/addGroup") ;
//        List<Group> groups = groupService.allGroups() ;
//        return mav ;
//    }
    @RequestMapping(value="/view")
    @ResponseBody
    @Verify(code = "/group/view", module = "系统管理/权限组查看")
    public ResponseData viewGroup(@RequestParam("id")Integer id) {
        try{
            ResponseData data = ResponseData.ok();
            Group group = groupService.getGroupById(id) ;
            data.putDataValue("group",group) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }
    @RequestMapping(value="/checkName")
    @ResponseBody
    @Verify(code = "/group/checkName", module = "系统管理/权限名排重")
    public ResponseData checkName(@RequestParam("name") String name, @RequestParam(name="id",required=false) Integer id) {
        try {
            ResponseData data = ResponseData.ok() ;
            Boolean flag = false ;
            if(id!=null){
                //编辑页面判断用户名是否重复，先排除自己
                Group group = groupService.getGroupById(id) ;
                if(name.equals(group.getName())){
                    flag = true ;
                }else{
                    List<Group> list = groupService.queryGroupByName(name) ;
                    if(list.size()==0){
                        flag = true ;
                    }
                }
            }else{
                //新增页面判断用户名是否重复
                List<Group> list = groupService.queryGroupByName(name) ;
                if(list.size()==0){
                    flag = true ;
                }
            }
            data.putDataValue("flag",flag) ;
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }

    }
}
