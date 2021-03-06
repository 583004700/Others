package com.byefan.xhoa.controller.media;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.xhoa.entity.media.MediaType;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.media.IMediaTypeService;
import com.byefan.xhoa.service.sys.IRoleService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.IConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mediaType")
@Api(description = "媒体管理接口")
public class MediaTypeController {
    @Autowired
    IMediaTypeService mediaTypeService;
    @Autowired
    IRoleService roleService;

    @GetMapping
    @ResponseBody
    public List<MediaType> list(MediaType mediaType) {
        return mediaTypeService.list(mediaType);
    }

    @GetMapping("/parentId/{parentId}")
    @ResponseBody
    @ApiOperation(value = "根据媒体类型ID查询媒体类型列表", notes = "根据媒体类型ID查询媒体类型列表", response = ResponseData.class)
    @Log(opType = OperateType.QUERY, note = "根据媒体类型ID查询媒体类型列表", module = "媒体管理/根据媒体类型ID查询媒体类型列表")
//    @Verify(code = "/mediaType/parentId/{parentId}", action = "根据媒体类型ID查询媒体类型列表", module = "媒体管理/根据媒体类型ID查询媒体类型列表")
    public List<MediaType> listByParentId(@PathVariable("parentId") Integer parentId, String isFlag) {
        User user = AppUtil.getUser();
        if (isFlag != null) {
            if (roleService.isRole(user.getId(), IConst.ROLE_TYPE_MJ))
                return mediaTypeService.listByParentId(parentId, user);
        }
        return mediaTypeService.listByParentId(parentId);

    }
//    @GetMapping("/parentId/{parentId}")
//    @ResponseBody
//    public List<MediaType> listByParentId(@PathVariable("parentId") Integer parentId, String isFlag) {
//        User user = AppUtil.getUser();
//        return mediaTypeService.listByParentId(parentId, user,isFlag);
//    }

//    /**
//     * 根据媒介用户ID获取媒体板块类型列表
//     *
//     * @param userId
//     * @return
//     */
//    @GetMapping("/userId/{userId}")
//    @ResponseBody
//    public List<MediaType> listByUserId(@PathVariable("userId") Integer userId) {
//        return mediaTypeService.listByUserId(userId);
//    }

    /**
     * 根据媒介用户ID获取媒体板块类型列表
     *有问题，废弃，用户id要通过参数传进来，不是获取当前用户的id
     * @return
     */
    @GetMapping("/userId")
    @ResponseBody
    @ApiOperation(value = "根据媒介用户ID获取媒体板块类型列表", notes = "根据媒介用户ID获取媒体板块类型列表", response = ResponseData.class)
    @Log(opType = OperateType.QUERY, note = "根据媒介用户ID获取媒体板块类型列表", module = "媒体管理/根据媒介用户ID获取媒体板块类型列表")
//    @Verify(code = "/mediaType/userId", action = "根据媒介用户ID获取媒体板块类型列表", module = "媒体管理/根据媒介用户ID获取媒体板块类型列表")
    public List<MediaType> listByUserId() {
        Integer userId = AppUtil.getUser().getId();
        return mediaTypeService.listByUserId(userId);
    }

    /**
     * 根据媒介用户ID获取媒体板块类型列表
     *
     * @return
     */
    @RequestMapping("/listByUserId")
    @ResponseBody
    @ApiOperation(value = "根据媒介用户ID获取媒体板块类型列表", notes = "根据媒介用户ID获取媒体板块类型列表", response = ResponseData.class)
    @Log(opType = OperateType.QUERY, note = "根据媒介用户ID获取媒体板块类型列表", module = "媒体管理/根据媒介用户ID获取媒体板块类型列表")
//    @Verify(code = "/mediaType/listByUserId", action = "根据媒介用户ID获取媒体板块类型列表", module = "媒体管理/根据媒介用户ID获取媒体板块类型列表")
    public List<MediaType> listByUserId(@RequestParam("userId") Integer userId) {
        return mediaTypeService.listByUserId(userId);
    }
}
