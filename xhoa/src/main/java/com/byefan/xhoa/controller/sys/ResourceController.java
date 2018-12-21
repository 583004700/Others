package com.byefan.xhoa.controller.sys;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.sys.Group;
import com.byefan.xhoa.entity.sys.Resource;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.sys.IGroupService;
import com.byefan.xhoa.service.sys.IResourceService;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
@Slf4j
/**
 * 资源接口
 */
@Controller
@RequestMapping("/resource")
@Api(description = "权限接口")
public class ResourceController {
    @Autowired
    private IResourceService resourceService;
    @Autowired
    private IGroupService groupService;

    @RequestMapping("/listPg")
    @ResponseBody
    @Log(opType = OperateType.QUERY, module = "资源管理", note = "资源列表")
//    @Verify(code = "/resource/listPg", module = "系统管理/资源列表")
    public PageInfo<Resource> list(@PageableDefault(size = 5) Pageable pageable, @RequestParam Map map) {
        PageInfo<Resource> resources = resourceService.listPg(pageable.getPageNumber(), pageable.getPageSize(), map);
        return resources;
    }

    @PostMapping("/search")
    @ResponseBody
//    @Verify(code = "/resource/search", module = "系统管理/资源列表2")
    public PageInfo<Resource> search(Pageable pageable, Resource resource) {
        PageInfo<Resource> resources = resourceService.search(pageable, resource);
        return resources;
    }

    @PostMapping("/listAllMenus")
    @ResponseBody
//    @Verify(code = "/resource/listAllMenus", module = "系统管理/资源管理")
    public ResponseData edit(Resource resource) {
        try {
            ResponseData data = ResponseData.ok();
            List<Resource> resources = resourceService.listAllMenus();
            data.putDataValue("resources", resources);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    @Log(opType = OperateType.DELETE, module = "系统管理|资源管理", note = "删除资源")
    @Verify(code = "/resource/del", module = "系统管理/删除资源")
    public ResponseData del(@RequestParam("id") Integer id) {
        try {
            Resource resource = resourceService.delById(id);
            ResponseData data = ResponseData.ok();
            data.putDataValue("message", "操作成功");
            data.putDataValue("resource", resource);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
//            return "redirect:/login";
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    @Log(opType = OperateType.ADD, module = "系统管理|资源管理", note = "新增资源")
    @Verify(code = "/resource/add", module = "系统管理/新增资源")
    public ResponseData add(Resource sr, HttpSession session) {
        try {
            sr.setId(null);
            User user = (User)session.getAttribute(IConst.USER_KEY) ;
            Resource resource = resourceService.add(sr, user.getId());
            ResponseData data = ResponseData.ok();
            data.putDataValue("message", "操作成功");
            data.putDataValue("resource", resource);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, module = "系统管理|资源管理", note = "修改资源")
    @Verify(code = "/resource/update", module = "系统管理/修改资源")
    public ResponseData update(Resource sr, HttpSession session) {
        try {
            User user = (User) session.getAttribute(IConst.USER_KEY);
            Resource resource = resourceService.edit(sr, user.getId());
            ResponseData data = ResponseData.ok();
            data.putDataValue("message", "操作成功");
            data.putDataValue("resource", resource);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping(value = "/editAjax")
    @ResponseBody
//    @Verify(code = "/resource/edit", module = "系统管理/跳转编辑资源页面")
    public ResponseData editAjax(@RequestParam("id") Integer id) {
        try {
            ResponseData data = ResponseData.ok();
            Resource resource = resourceService.getById(id);
            data.putDataValue("resource", resource);
            List<Group> groups = groupService.allGroups();
            data.putDataValue("groups", groups);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping(value = "/view")
    @ResponseBody
//    @Verify(code = "/resource/view", module = "系统管理/查看资源")
    public ResponseData viewResource(@RequestParam("id") Integer id) {
        try {
            ResponseData data = ResponseData.ok();
            Resource resource = resourceService.getById(id);
            data.putDataValue("resource", resource);
            List<Resource> menus = resourceService.listAllMenus();
//            List<Group> groups = groupService.allGroups();
//            data.putDataValue("groups", groups);
            data.putDataValue("menus", menus);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @RequestMapping(value = "/checkName")
    @ResponseBody
//    @Verify(code = "/resource/checkName", module = "系统管理/资源名排重")
    public ResponseData checkName(@RequestParam(name = "id", required = false) Integer id, @RequestParam("name") String name) {
        try {
            ResponseData data = ResponseData.ok();
            Boolean flag = false;
            if (id!=null) {
                //编辑页面判断是否重复，先排除自己
                Resource resource = resourceService.getById(id);
                if (name.equals(resource.getName())) {
                    flag = true;
                } else {
                    List<Resource> list = resourceService.queryResourceByName(name);
                    if (list.size() == 0) {
                        flag = true;
                    }
                }
            } else {
                //新增页面判断是否重复
                List<Resource> list = resourceService.queryResourceByName(name);
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
