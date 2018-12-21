package com.byefan.xhoa.controller.media;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.config.Config;
import com.byefan.core.exception.ByeFanException;
import com.byefan.core.exception.ResultEnum;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.core.serivce.IWorkFlowService;
import com.byefan.core.utils.UUIDUtil;
import com.byefan.xhoa.entity.media.Media;
import com.byefan.xhoa.entity.sys.Role;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.biz.IOrderService;
import com.byefan.xhoa.service.media.IMediaService;
import com.byefan.xhoa.service.sys.IRoleService;
import com.byefan.xhoa.utils.AppUtil;
import com.byefan.xhoa.utils.IConst;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 媒体管理
 *
 * @author GZW
 */
@Slf4j
@Controller
@RequestMapping("/media")
@Api(description = "媒体管理接口")
public class MediaController {
    @Autowired
    IMediaService mediaService;
    @Autowired
    IOrderService orderService;
    @Autowired
    Config config;
    @Autowired
    IWorkFlowService workFlowService;
    @Autowired
    IRoleService roleService;

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "分页查询媒体列表", notes = "分页查询媒体列表", response = PageInfo.class)
    @Log(opType = OperateType.QUERY, note = "分页查询媒体列表", module = "媒体管理/分页查询媒体列表")
//    @Verify(code = "/media", action = "分页查询媒体列表", module = "媒体管理/分页查询媒体列表")
    public PageInfo<Media> list(@ApiParam("媒体筛选条件") Media media, @ApiParam("分页对象") Pageable pageable) {
        return mediaService.list(media, pageable);
    }

    /**
     * 根据媒体ID查询媒体信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "根据媒体ID查询媒体信息", notes = "根据媒体ID查询媒体信息", response = ResponseData.class)
    @Log(opType = OperateType.QUERY, note = "根据媒体ID查询媒体信息", module = "媒体管理/根据媒体ID查询媒体信息")
//    @Verify(code = "/media/{id}", action = "根据媒体ID查询媒体信息", module = "媒体管理/根据媒体ID查询媒体信息")
    public ResponseData get(@PathVariable("id") Integer id) {
        Media media = mediaService.getById(id);
        ResponseData ok = ResponseData.ok().putDataValue("media", media);
        return ok;
    }

    /**
     * 更新媒体信息
     *
     * @param media
     * @param session
     * @param multipartFile
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    @ApiOperation(value = "更新媒体信息", notes = "更新媒体信息", response = ResponseData.class)
    @Log(opType = OperateType.UPDATE, note = "更新媒体信息", module = "媒体管理/更新媒体信息")
    @Verify(code = "/media/update", action = "更新媒体信息", module = "媒体管理/更新媒体信息")
    public ResponseData update(@ApiParam("媒体实体类") Media media, HttpSession session, @RequestParam("file") MultipartFile multipartFile) {
        String originalFileName = multipartFile.getOriginalFilename();
        if (StringUtils.isNotEmpty(originalFileName)) {
            String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = UUIDUtil.get32UUID() + ext;
            File file = new File(config.getUploadDir(), fileName);
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            media.setPicPath(config.getWebDir() + fileName);
        }
        User user = (User) session.getAttribute(IConst.USER_KEY);
        media.setCreatorId(user.getId());
        //判断如果“更新责任人”未选择，默认就是当前用户
        if (media.getUserId() == null)
            media.setUserId(user.getId());
        mediaService.update(media);
        return ResponseData.ok();
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "新增媒体", notes = "新增媒体", response = ResponseData.class)
    @Log(opType = OperateType.ADD, note = "新增媒体", module = "媒体管理/新增媒体")
    @Verify(code = "/media/add", action = "新增媒体", module = "媒体管理/新增媒体")
    public ResponseData save(@ApiParam("媒体实体类") Media media, HttpSession session, @RequestParam("file") MultipartFile multipartFile) {
        String originalFileName = multipartFile.getOriginalFilename();
        if (StringUtils.isNotEmpty(originalFileName)) {
            String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = UUIDUtil.get32UUID() + ext;
            File file = new File(config.getUploadDir(), fileName);
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            media.setPicPath(config.getWebDir() + fileName);
        }
        User user = (User) session.getAttribute(IConst.USER_KEY);
        media.setCreatorId(user.getId());
        //判断如果“更新责任人”未选择，默认就是当前用户
        if (media.getUserId() == null)
            media.setUserId(user.getId());
        media.setCreateDate(new Date());
        mediaService.save(media);
        return ResponseData.ok();
    }

    @GetMapping("isDuplicateForName")
    @ResponseBody
    @ApiOperation(value = "媒体名称查询媒体", notes = "通过媒体名称查询是否有媒体记录")
    @Log(opType = OperateType.QUERY, note = "媒体名称查询媒体", module = "媒体管理/媒体名称查询媒体")
//    @Verify(code = "/media/isDuplicateForName", action = "媒体名称查询媒体", module = "媒体管理/媒体名称查询媒体")
    public ResponseData isDuplicateForName(@ApiParam("媒体板块类型") int mType, @ApiParam("媒体名称") String mediaName) {
        boolean flag = mediaService.getByName(mType, mediaName);
        if (flag) {
            return ResponseData.customerError(1001, "媒体名称已存在!");
        }
        return ResponseData.ok();
    }

    /**
     * 查询媒体列表
     *
     * @param mv
     * @return
     */
    @GetMapping("medias")
    @Log(opType = OperateType.QUERY, note = "查询媒体列表", module = "媒体管理/查询媒体列表")
//    @Verify(code = "/media/medias", action = "查询媒体列表", module = "媒体管理/查询媒体列表")
    public ModelAndView medias(ModelAndView mv) {
        mv.setViewName("/media/medias");
        return mv;
    }

    /**
     * 审核驳回
     *
     * @param id
     * @return
     */
    @GetMapping("reject/{id}")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, note = "审核驳回", module = "媒体审核/审核驳回")
    @Verify(code = "/media/reject/{id}", action = "审核驳回", module = "媒体管理/审核驳回")
    public ResponseData reject(@PathVariable("id") Integer id) {
//        Integer userId = AppUtil.getUser().getId();
        Map<String, Object> map = new HashMap<>();
        mediaService.reject(id);
        return ResponseData.ok();
    }

    /**
     * 审核通过
     *
     * @param id
     * @return
     */
    @GetMapping("pass/{id}")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, note = "审核通过", module = "媒体审核/审核通过")
    @Verify(code = "/media/pass/{id}", action = "审核通过", module = "媒体管理/审核通过")
    public ResponseData pass(@PathVariable("id") Integer id) {
//        Map<String, Object> map = new HashMap<>();
        mediaService.pass(id);
        return ResponseData.ok();
    }

    /**
     * 审核删除
     *
     * @param id
     * @return
     */
    @GetMapping("del/{id}")
    @ResponseBody
    @Log(opType = OperateType.DELETE, note = "媒体删除", module = "媒体审核/媒体删除")
    @Verify(code = "/media/del/{id}", action = "媒体删除", module = "媒体管理/媒体删除")
    public ResponseData del(@PathVariable("id") Integer id) {
//        Map<String, Object> map = new HashMap<>();
        mediaService.del(id);
        return ResponseData.ok();
    }

    @GetMapping("/audit/{id}/{taskId}")
    @ResponseBody
    @ApiOperation(value = "根据媒体ID查询媒体信息", notes = "根据媒体ID查询媒体信息", response = ResponseData.class)
    @Log(opType = OperateType.QUERY, note = "根据媒体ID查询媒体信息", module = "媒体管理/根据媒体ID查询媒体信息")
//    @Verify(code = "/audit/{id}/{taskId}", action = "根据媒体ID查询媒体信息", module = "媒体管理/根据媒体ID查询媒体信息")
    public ModelAndView get(@PathVariable("id") Integer id, @PathVariable("taskId") String taskId, ModelAndView mv) {
        Media media = mediaService.getById(id);
        mv.addObject("media", media);
        mv.addObject("taskId", taskId);
        mv.setViewName("/media/auditMedia");
        return mv;
    }

    @GetMapping("/audits")
    @ResponseBody
    @Log(opType = OperateType.QUERY, note = "查询媒体审核列表", module = "媒体管理/查询媒体审核列表")
    @Verify(code = "/media/audits", action = "查询媒体审核列表", module = "媒体管理/查询媒体审核列表")
    public ModelAndView audit(ModelAndView mv) {
        User user = AppUtil.getUser();
        List<Role> roles = user.getRoles();
        boolean bz = false, zz = false;
        for (Role role : roles) {
            if (IConst.ROLE_TYPE_MJ.equalsIgnoreCase(role.getType())) {
                if (IConst.ROLE_CODE_BZ.equalsIgnoreCase(role.getCode()))
                    bz = true;
                if (IConst.ROLE_CODE_ZZ.equalsIgnoreCase(role.getCode()))
                    zz = true;
            }
        }
        if (!bz && !zz) {
            throw new ByeFanException(ResultEnum.NOAUDIT);
        }
//        //查询状态 组长查询0的值 部长查询1的值
//        mv.addObject("state", bz ? 1 : 0);
        mv.setViewName("/media/audits");
        return mv;
    }
}
