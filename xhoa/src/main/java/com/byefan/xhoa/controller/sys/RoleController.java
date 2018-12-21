package com.byefan.xhoa.controller.sys;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.sys.Dept;
import com.byefan.xhoa.entity.sys.Resource;
import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.sys.*;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/role")
@Api(description = "角色接口")
public class RoleController {

    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IGroupService groupService;
    @Autowired
    private IResourceService resourceService;
    @Autowired
    private IDeptService deptService;
//    @Autowired
//    private MailService mailService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Role> listAll() {
        return roleService.listAll();
    }

//    @ResponseBody
//    @RequestMapping("/list2")
//    public PageInfo<SysRole> list2(@PageableDefault(size = 5) Pageable pageable) {
//        log.warn("测试角色列表2");
//        PageInfo<SysRole> list = roleService.list2(pageable.getPageNumber(), pageable.getPageSize());
//        return list;
//    }

//    @ResponseBody
//    @RequestMapping("/listPg")
//    public PageInfo<Role> list(@PageableDefault(size = 5) Pageable pageable) {
//        PageInfo<Role> list = roleService.listAll(pageable.getPageNumber(), pageable.getPageSize());
//        return list;
//    }

    @ResponseBody
    @RequestMapping("/listPg")
//    @Log(opType = OperateType.QUERY, module = "角色管理", note = "角色列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<Role> listPg(@PageableDefault(size = 5) Pageable pageable, @RequestParam Map map) {
        PageInfo<Role> list = roleService.listPg(pageable.getPageNumber(), pageable.getPageSize(), map);
        return list;
    }

    @RequestMapping(value = "/editAjax")
    @ResponseBody
//    @Verify(code = "/role/editAjax", module = "系统管理/角色编辑")
    public ResponseData editAjax(@RequestParam("id") Integer id) {
        try {
            ResponseData data = ResponseData.ok();
            Role role = roleService.getRoleById(id);
            data.putDataValue("role", role);
            List<Dept> list = deptService.queryAllDept();
            data.putDataValue("list", list);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    //    @RequestMapping(value="/add")
//    @ResponseBody
//    public ModelAndView addRole(HttpServletRequest request) {
//
//        ModelAndView mav = new ModelAndView("/system/addRole") ;
//        return mav ;
//    }
    @RequestMapping(value = "/view")
    @ResponseBody
//    @Verify(code = "/role/view", module = "系统管理/角色查看")
    public ResponseData viewRole(@RequestParam("id") Integer id) {
        try {
            ResponseData data = ResponseData.ok();
            Role role = roleService.getRoleById(id);
            data.putDataValue("role", role);
//            List<User> list= userService.queryByRoleId(id) ;
//            data.putDataValue("list",list) ;
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/queryUserByRoleId")
//    @Log(opType = OperateType.QUERY, module = "角色管理", note = "角色列表")
//    @Verify(code = "/role/listPg", module = "系统管理/角色列表")
    public PageInfo<User> queryUserByRoleId(@PageableDefault(size = 5) Pageable pageable, @RequestParam Map map) {
        PageInfo<User> list = null;
        log.info((String) map.get("roleId"));
        try {
            if (map.get("roleId") == null) {
                throw new Exception("未获取到角色id！");
            } else {
                list = userService.queryByRoleId(pageable.getPageNumber(), pageable.getPageSize(), map);
            }
        } catch (Exception e) {

        }
        return list;
    }

    //    @RequestMapping("/edit/{id}")
//    @ResponseBody
//    public SysRole editRole(@PathVariable("id") Integer id) {
//        SysRole sysRole = roleService.getRoleById(id);
//        return sysRole ;
//    }
//    @RequestMapping("/edit")
//    @ResponseBody
//    public ResponseData editRole(HttpServletRequest request) {
//        try{
//            int id = Integer.parseInt(request.getParameter("id")) ;
//            SysRole sysRole = roleService.getRoleById(id);
//            ResponseData data = ResponseData.ok() ;
//            data.putDataValue("message","操作成功");
//            data.putDataValue("sysRole",sysRole) ;
//            return data ;
//        }catch (Exception e){
//            e.printStackTrace(); ;
//            return ResponseData.customerError(1001,e.getMessage()) ;
//        }
//    }
//    @RequestMapping(value="/del")
//    @ResponseBody
//    public ModelAndView delRole(HttpServletRequest request) {
//        ModelAndView mav = new ModelAndView("/system/roleList") ;
//        int id = Integer.parseInt(request.getParameter("id")) ;
//        SysRole sysRole = roleService.delById(id) ;
//        mav.addObject("sysRole", sysRole);
//        mav.addObject("msg","操作成功");
//        return mav ;
//    }
    @RequestMapping(value = "/del")
    @ResponseBody
    @Log(opType = OperateType.DELETE, module = "系统管理|角色管理", note = "删除角色")
    @Verify(code = "/role/del", module = "系统管理/删除角色")
    public ResponseData delRole(@RequestParam("id") Integer id) {
        try {
            User user = AppUtil.getUser();
            Role role = roleService.delById(id, user.getId());
            ResponseData data = ResponseData.ok();
            data.putDataValue("message", "操作成功");
            data.putDataValue("sysRole", role);

            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
//            return "redirect:/login";
        }
    }

    //    @RequestMapping("/submitRole")
//    @ResponseBody
//    public SysRole submitRole(SysRole sr) {
//        SysRole sysRole = roleService.submitRole(sr);
//        return sysRole ;
//    }
    @RequestMapping("/update")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "系统管理|角色管理", note = "修改角色")
    @Verify(code = "/role/update", module = "系统管理/修改角色")
    public ResponseData update(Role role) {
        try {
            User user = AppUtil.getUser();
            role.setUpdateUserId(user.getId());
            roleService.updateRole(role);
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
    @Log(opType = OperateType.ADD, module = "系统管理|角色管理", note = "新增角色")
    @Verify(code = "/role/add", module = "系统管理/新增角色")
    public ResponseData add(Role role, HttpSession session) {
        try {
            User user = (User) session.getAttribute(IConst.USER_KEY);
            role.setCreator(user.getId());
            role.setId(null);
            roleService.saveRole(role);
            ResponseData data = ResponseData.ok();
            data.putDataValue("message", "操作成功");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @GetMapping("/allGroupsAndResources/{id}")
    @ResponseBody
    public List<Map> allGroupsAndResources(@PathVariable("id")Integer id){
        List<Map> lists = resourceService.allParentsAndResources(id);
        return lists;
    }

    @RequestMapping(value = "/editRoleResource")
    @ResponseBody
//    @Verify(code = "/role/editRoleResource", module = "系统管理/编辑角色权限关系")
    public ModelAndView editRoleResource(@RequestParam("id") Integer id) {
        ModelAndView mav = new ModelAndView("/system/editRoleResource");
        List<Role> roleList = roleService.queryAllRole();
        Role role = roleService.getRoleById(id);
        List<Map> lists = groupService.allGroupsAndResources(id);
//        String checkresource = roleService.queryresourceByRoleId(id) ;
        mav.addObject("roleList", roleList);
        mav.addObject("sysRole", role);
        mav.addObject("allGroups", lists);
//        mav.addObject("checkresource",checkresource);
//        mav.addObject("checkresource",checkresource==null?"":checkresource);
        return mav;
    }

    @RequestMapping("/submitRoleresource")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "角色管理", note = "赋权")
    @Verify(code = "/role/submitRoleResource", module = "系统管理/赋权")
    public ResponseData submitRoleResource(@RequestParam("roleId") Integer roleId, @RequestParam("checkId") String checkId) {
        ResponseData data = ResponseData.ok();
        try {
            //判断角色编辑不能不为空
            if (StringUtils.isNotEmpty(checkId)) {
                Set<Integer> set = new HashSet() ;
                String[] pArray = checkId.split("\\|");
                int len = pArray.length;
                //sys_role_resource根据roleId删除旧数据，
                roleService.delRoleResourceByRoleId(roleId);
                //sys_role_resource根据roleId和resourceId新增新数据，
                for (int i = 0; i < len; i++) {
                    int resourceId = Integer.parseInt(pArray[i]);
                    Resource r = resourceService.getById(resourceId) ;
                    //子资源是菜单，就要放入set中，用于加载父菜单
                    if(r.getIsMenu()==0){
                        set.add(r.getParentId()) ;
                    }
                    roleService.insertRoleResource(roleId, resourceId);
                }
                Iterator iter = set.iterator() ;
                while(iter.hasNext()){
                    roleService.insertRoleResource(roleId, (Integer)iter.next());
                }
                data.putDataValue("message", "操作成功");
                data.putDataValue("roleId", roleId);
            } else {
                data.putDataValue("message", "操作成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
        return data;
    }
//    @RequestMapping(value="/validateNameRepeat")
//    @ResponseBody
//    public ResponseData validateNameRepeat(HttpServletRequest request) {
//        String name = request.getParameter("name") ;
//        Role role = roleService.findRoleByName(name) ;
//        ResponseData data = null ;
//        if(role !=null){
//            data = ResponseData.customerError(1001,"角色名称重复") ;
//        }else{
//            data = ResponseData.ok() ;
//        }
//
//        return data ;
//    }
//    @RequestMapping(value="/validateTypeRepeat")
//    @ResponseBody
//    public ResponseData validateTypeRepeat(HttpServletRequest request) {
//        String roleType = request.getParameter("roleType") ;
//        Role role = roleService.findRoleByType(roleType) ;
//        ResponseData data = null ;
//        if(role !=null){
//            data = ResponseData.customerError(1001,"角色类型重复") ;
//        }else{
//            data = ResponseData.ok() ;
//        }
//        return data ;
//    }

    @RequestMapping(value = "/queryAllDept")
    @ResponseBody
//    @Verify(code = "/role/queryAllDept", module = "系统管理/查询所有部门")
    public ResponseData queryAllDept() {
        try {
            ResponseData data = ResponseData.ok();
            List<Dept> list = deptService.queryAllDept();
            data.putDataValue("message", "操作成功");
            data.putDataValue("list", list);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping(value = "/checkName")
    @ResponseBody
//    @Verify(code = "/role/checkName", module = "系统管理/角色排重")
    public ResponseData checkName(@RequestParam("id") Integer id, @RequestParam("name") String name) {

        try {
            ResponseData data = ResponseData.ok();
            Boolean flag = false;
            if (id != null) {
                //编辑页面判断用户名是否重复，先排除自己
                Role role = roleService.getRoleById(id);
                if (name.equals(role.getName())) {
                    flag = true;
                } else {
                    List<Role> list = roleService.queryRoleByName(name);
                    if (list.size() == 0) {
                        flag = true;
                    }
                }
            } else {
                //新增页面判断用户名是否重复
                List<Role> list = roleService.queryRoleByName(name);
                if (list.size() == 0) {
                    flag = true;
                }
            }
            data.putDataValue("flag", flag);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }

    }
}
