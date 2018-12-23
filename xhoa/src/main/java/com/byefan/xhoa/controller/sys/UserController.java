package com.byefan.xhoa.controller.sys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.config.Config;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.core.utils.MD5Utils;
import com.byefan.core.utils.UUIDUtil;
import com.byefan.xhoa.entity.sys.Resource;
import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.sys.IResourceService;
import com.byefan.xhoa.service.sys.IRoleService;
import com.byefan.xhoa.service.sys.IUserService;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;


@Slf4j
@Controller
@RequestMapping("/user")
@Api(description = "用户管理接口")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IResourceService resourceService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    Config config;

    @PostMapping
    @ApiOperation(value = "新增用户", notes = "新增注册")
//    @Log(opType = OperateType.ADD, module = "系统管理/新增用户", note = "新增注册")
    @ResponseBody
    public int addUser(User user) {
        return userService.add(user);
    }


    @GetMapping("/all/{pageNum}/{pageSize}")
    @ApiOperation(value = "查询所有用户分页", notes = "查询所有用户分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页数", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", required = true, paramType = "query", dataType = "Integer")
    })

    @ResponseBody
    public PageInfo<User> findAllUser(@ApiParam(value = "当前页数") @PathVariable("pageNum") int pageNum, @ApiParam(value = "每页显示条数") @PathVariable("pageSize") int pageSize) {
        return userService.listPg(pageNum, pageSize);
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询所有用户列表", notes = "查询所有用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "查询用户条件", required = true, paramType = "query", dataType = "User")
    })
    @ResponseBody
    public List<User> list(User user) {
        return userService.list(user);
    }

    @GetMapping("/listByType/{type}")
    @ApiOperation(value = "根据角色类型查询用户列表", notes = "根据角色类型查询用户列表")
    @ResponseBody
    public List<User> listByType(@ApiParam(value = "根据角色类型查询用户列表") @PathVariable("type") String type) {
        return userService.listByType(type);
    }

    @GetMapping("/listByTypeAndCode/{type}/{code}")
    @ApiOperation(value = "根据角色类型查询用户列表", notes = "根据角色类型查询用户列表")
    @ResponseBody
    public List<User> listByTypeAndCode(@ApiParam(value = "根据角色类型查询用户列表") @PathVariable("type") String type, @ApiParam(value = "根据角色类型查询用户列表") @PathVariable("code") String code) {
        return userService.listByTypeAndCode(type, code);
    }

    @GetMapping("/listByDepart")
    @ApiOperation(value = "查询所有用户列表", notes = "查询所有用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "查询用户条件", required = true, paramType = "query", dataType = "User")
    })
    @ResponseBody
    public List<User> list(User user, List<Integer> departIds) {
        return userService.list(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public PageInfo<User> all() {
        PageInfo<User> list = userService.list();
        return list;
    }

    @ResponseBody
    @PostMapping("/listPg")
    @Log(opType = OperateType.QUERY, module = "用户管理", note = "用户列表")
//    @Verify(code = "/user/listPg", module = "系统管理/用户列表")
    public PageInfo<User> listPg(Pageable pageable, @RequestParam Map map) {
        PageInfo<User> list = userService.listPg(pageable.getPageNumber(), pageable.getPageSize(), map);
        return list;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User get(@PathVariable("id") Integer id) {
//        mailService.sendSimpleMail("395037000@qq.com","test","test");
        Object user = userService.getById(id);
        return (User) user;
    }

    @GetMapping("/del/{id}")
    @ResponseBody
    public ResponseData delete(@PathVariable("id") Integer id) {
        try {
            User user = userService.getById(id);
            ResponseData data = ResponseData.ok();
            data.putDataValue("message", "操作成功");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }


    @PostMapping("/login")
    @ResponseBody
    @Log(opType = OperateType.QUERY, module = "用户管理", note = "用户登录")
    @Verify(code = "/user/login", module = "系统管理/用户登录")
    public ResponseData login(User user, HttpSession session) {
        try {
            user = userService.login(user);
            session.setAttribute(IConst.USER_KEY, user);
            ResponseData data = ResponseData.ok();
//            List<Role> list = roleService.listRoleByUserId(user.getId()) ;
            List<Resource> set = resourceService.queryAllResourceByUserId(user.getId());
            //set放入session中
//            session.setAttribute(IConst.USER_ROLE,list);
            session.setAttribute(IConst.USER_RESOURCE, set);
            data.putDataValue("image", user.getImage());
            data.putDataValue("name", user.getUserName());
            data.putDataValue("pwd", user.getPassword());
            return data;
//            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
//            return "redirect:/login";
        }
    }
//    @RequestMapping(value="/add")
//    @ResponseBody
//    public ModelAndView addUser(HttpServletRequest request) {
//        ModelAndView mav = new ModelAndView("/system/addUser") ;
//        return mav ;
//    }

//    @RequestMapping(value="/edit")
//    @ResponseBody
//    public ModelAndView editUser(HttpServletRequest request) {
//        int id = Integer.parseInt(request.getParameter("id")) ;
//        User su = userService.getById(id) ;
//        ModelAndView mav = new ModelAndView("/system/editUser") ;
//        mav.addObject("user",su) ;
//        return mav ;
//    }

    @RequestMapping(value = "/view")
    @ResponseBody
//    @Verify(code = "/user/view", module = "系统管理/用户查看")
    public ResponseData view(@RequestParam("id") Integer id) {
        try {
            ResponseData data = ResponseData.ok();
            User su = userService.getById(id);
            data.putDataValue("user", su);
            List<User> list = userService.queryAllMgr();
            data.putDataValue("list", list);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    @Log(opType = OperateType.DELETE, module = "系统管理|用户管理", note = "用户删除")
    @Verify(code = "/user/del", module = "系统管理/用户删除")
    public ResponseData delUser(@RequestParam("id") Integer id) {
        try {
            ResponseData data = ResponseData.ok();
            User su = userService.delById(id);
            data.putDataValue("user", su);
            data.putDataValue("message", "操作成功");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    @Log(opType = OperateType.ADD, module = "系统管理|用户管理", note = "新增用户")
    @Verify(code = "/user/add", module = "系统管理/新增用户")
    public ResponseData add(User user, HttpSession session) {
        try {
            //log.info("mgrId="+user.getUser().getId().toString());
            User opUser = (User) session.getAttribute(IConst.USER_KEY);
            user.setPassword(MD5Utils.encode("123"));
            user.setCreator(opUser.getId());
            user.setCreateTime(new Date());
            user.setId(null);
            user.setState(IConst.STATE_FINISH);
            userService.add(user);
            ResponseData data = ResponseData.ok();
            data.putDataValue("message", "操作成功");
            data.putDataValue("user", user);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @PostMapping("/edit")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "系统管理|用户管理", note = "修改用户")
    @Verify(code = "/user/edit", module = "系统管理/修改用户")
    public ResponseData edit(User user, HttpSession session) {
        try {
            User opUser = (User) session.getAttribute(IConst.USER_KEY);
            user.setUpdateTime(new Date());
            userService.update(user);
            ResponseData data = ResponseData.ok();
            data.putDataValue("message", "操作成功");
            data.putDataValue("user", user);
            if (user.getId() == opUser.getId()) {
                session.setAttribute(IConst.USER_KEY, user);
            }
            return data;
        } catch (Exception e) {
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping(value = "/queryAllMgr")
    @ResponseBody
//    @Verify(code = "/user/queryAllMgr", module = "系统管理/查询所有管理者")
    public ResponseData queryAllMgr(@RequestParam("id") Integer id) {
        try {
            ResponseData data = ResponseData.ok();
            User user = userService.getById(id);
            data.putDataValue("user", user);
            List<User> list = userService.queryAllMgr();
            data.putDataValue("message", "操作成功");
            data.putDataValue("list", list);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping(value = "/editUserRole")
    @ResponseBody
//    @Verify(code = "/user/editUserRole", module = "系统管理/编辑用户角色关系")
    public ResponseData editUserRole(@RequestParam("id") Integer id) {
        ResponseData data = ResponseData.ok();
        List<Role> userRole = userService.queryUserRole(id);
        List<Role> allRole = roleService.queryAllRole();
        data.putDataValue("userRole", userRole);
        data.putDataValue("allRole", allRole);
        data.putDataValue("userId", id);
        return data;
    }

    @RequestMapping("/submitUserRole")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "系统管理|用户管理", note = "修改用户的角色")
    @Verify(code = "/user/submitUserRole", module = "系统管理/修改用户的角色")
    public ResponseData submitUserRole(@RequestParam("userId") Integer userId, @RequestParam("checkId") String checkId, HttpSession session) {
        try {
            String[] checkIds = checkId.split(",");
            User user = (User) session.getAttribute(IConst.USER_KEY);
            Integer opId = user.getId();
            Integer roleId;
            userService.delUserRoleByUserId(userId);
            for (int i = 0; i < checkIds.length; i++) {
                roleId = Integer.valueOf(checkIds[i]);
                userService.insertUserRole(userId, roleId, opId);
            }
            //sys_user_role根据userId删除旧数据，
            ResponseData data = ResponseData.ok();
            data.putDataValue("message", "操作成功");
            data.putDataValue("userId", userId);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping(value = "/viewUserRole")
    @ResponseBody
//    @Verify(code = "/user/viewUserRole", module = "系统管理/用户角色关系查看")
    public ModelAndView viewUserRole(@RequestParam("id") Integer id) {
        List<Map> list = userService.viewUserRole(id);
        ModelAndView mav = new ModelAndView("/system/viewUserRole");
        mav.addObject("list", list);
        return mav;
    }

    @RequestMapping(value = "/listAll")
    @ResponseBody
    public List<User> listAll() {
        return userService.listAll();
    }

    @RequestMapping(value = "/updatePassword")
    @ResponseBody
//    @Log(opType = OperateType.UPDATE, module = "用户管理", note = "更改密码")
//    @Verify(code = "/user/updatePassword", module = "系统管理/更改密码")
    public ResponseData updatePassword(@RequestParam("oldpassword") String oldpassword,
                                       @RequestParam("password1") String password1,
                                       @RequestParam("password2") String password2, HttpSession session) {
        try {
            ResponseData data = ResponseData.ok();
            User user = (User) session.getAttribute(IConst.USER_KEY);
            if (user != null) {
                if (password1.equals(password2)) {
                    if (user.getPassword().equals(MD5Utils.encode(oldpassword))) {
                        userService.updatePassword(user.getId(), MD5Utils.encode(password1));
                    } else {
                        return ResponseData.customerError(1001, "旧密码不正确！");
                    }
                    data.putDataValue("message", "操作成功");
                    session.invalidate();
                } else {
                    return ResponseData.customerError(1001, "两次密码不一致！");
                }
            } else {
                data.putDataValue("message", ResponseData.noLogin());
                return ResponseData.noLogin();
            }

            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping(value = "/resetPassword")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "系统管理|用户管理", note = "重置密码")
    @Verify(code = "/user/resetPassword", module = "系统管理/重置密码")
    public ResponseData resetPassword(@RequestParam("id") Integer id, @RequestParam("password") String password) {
        try {
            ResponseData data = ResponseData.ok();
            User user = userService.getById(id);
            userService.updatePassword(user.getId(), MD5Utils.encode(password));
            data.putDataValue("message", "操作成功");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping(value = "/editUserSelf")
    @ResponseBody
//    @Verify(code = "/user/editUserSelf", module = "系统管理/个人信息维护")
    public ResponseData editUserSelf(HttpSession session) {
        try {
            ResponseData data = ResponseData.ok();
            User user = (User) session.getAttribute(IConst.USER_KEY);
            data.putDataValue("user", user);
            List<User> list = userService.queryAllMgr();
            data.putDataValue("list", list);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }

    }

    @RequestMapping(value = "/saveImage")
    @ResponseBody
//    @Log(opType = OperateType.UPDATE, module = "用户管理", note = "修改头像")
//    @Verify(code = "/user/saveImage", module = "系统管理/修改头像")
    public ResponseData saveImage(HttpSession session, @RequestParam(value = "image", required = true) MultipartFile multipartFile) {

        String fileName = UUIDUtil.get32UUID() + multipartFile.getOriginalFilename();
        String childPath = "system" + File.separator + "images" + File.separator;
        try {
            File destFile = new File(config.getUploadDir() + childPath + fileName);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            multipartFile.transferTo(destFile);
//            File returnFile = new File(config.getWebDir() + childPath + fileName);
            User user = (User) session.getAttribute(IConst.USER_KEY);
            user.setImage(config.getWebDir() + childPath + fileName);
            userService.update(user);
            session.setAttribute(IConst.USER_KEY, user);
            ResponseData data = ResponseData.ok();
            data.putDataValue("message", "操作成功");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }

    }

    @RequestMapping(value = "/checkUserName")
    @ResponseBody
//    @Verify(code = "/user/checkUserName", module = "系统管理/用户名排重")
    public ResponseData checkUserName(@RequestParam(value = "id", required = false) Integer id,
                                      @RequestParam("userName") String userName) {
        try {
            ResponseData data = ResponseData.ok();
            Boolean flag = false;
            if (id != null) {
                //编辑页面判断用户名是否重复，先排除自己
                User user = userService.getById(id);
                if (userName.equals(user.getUserName())) {
                    flag = true;
                } else {
                    List<User> list = userService.queryUserByUserName(userName);
                    if (list.size() == 0) {
                        flag = true;
                    }
                }
            } else {
                //新增页面判断用户名是否重复
                List<User> list = userService.queryUserByUserName(userName);
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

    /**
     * 查询通讯录
     *
     * @param pageable
     * @return
     */
    @RequestMapping("/queryUserInfo")
    @ResponseBody
    public PageInfo<Map> queryUserInfo(Pageable pageable) {
        return userService.queryUserInfo(pageable);
    }

    /**
     * 查询某个部门下的所有用户，或者查询某种角色的用户
     *
     * @param deptId
     * @return
     */
    @RequestMapping("/queryUserByDeptId")
    @ResponseBody
    public List<User> queryUserByDeptId(@RequestParam(value = "deptId", required = true) Integer deptId) {
        return userService.queryUserByDeptId(deptId);
    }


    @RequestMapping("/deptUser")
    @ResponseBody
    public PageInfo<Map> deptUser(Pageable pageable, @RequestParam Map map) {
        PageInfo<Map> pageInfo = new PageInfo<Map>(userService.deptUser(pageable.getPageNumber(), pageable.getPageSize(), map));
        return pageInfo;
    }

    @PostMapping("/mediaType")
    @ResponseBody
    public ResponseData mediaType(@RequestParam("param") String param) {
        JSONObject json = JSON.parseObject(param);
        Integer userId = json.getInteger("userId");
        Integer departId = json.getInteger("departId");
        Object typeId = json.get("typeId");
        List<Map> params = new ArrayList<>();
        if (typeId instanceof JSONArray) {
            JSONArray typeIds = (JSONArray) typeId;
            for (int i = 0; i < typeIds.size(); i++) {
                Map map = new HashMap();
                Integer id = typeIds.getInteger(i);
                map.put("mediaTypeId", id);
                map.put("departId", departId);
                map.put("userId", userId);
                params.add(map);
            }
        } else {
            Map map = new HashMap();
            Integer id = Integer.parseInt(typeId.toString());
            map.put("mediaTypeId", id);
            map.put("departId", departId);
            map.put("userId", userId);
            params.add(map);
        }
        userService.batchSave(params);
        return ResponseData.ok();
    }

    @GetMapping("/listMJByMediaId/{mediaId}")
    @ResponseBody
    public ResponseData listMJByMediaId(@PathVariable("mediaId") Integer mediaId) {
        ResponseData ok = ResponseData.ok();
        List<User> listMJByMediaId = userService.listMJByMediaId(mediaId);
        ok.putDataValue("listMJByMediaId",listMJByMediaId);
        return ok;
    }
}