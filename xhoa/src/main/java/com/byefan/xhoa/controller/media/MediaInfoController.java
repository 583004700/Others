package com.byefan.xhoa.controller.media;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.config.Config;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.core.serivce.IWorkFlowService;
import com.byefan.core.utils.UUIDUtil;
import com.byefan.xhoa.entity.media.MediaInfo;
import com.byefan.xhoa.entity.sys.User;
import com.byefan.xhoa.service.biz.IOrderService;
import com.byefan.xhoa.service.media.IMediaInfoService;
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
import java.util.HashMap;
import java.util.Map;

/**
 * 媒体管理
 *
 * @author GZW
 */
@Slf4j
@Controller
@RequestMapping("/mediaInfo")
@Api(description = "媒体管理接口")
public class MediaInfoController {
    @Autowired
    IMediaInfoService mediaInfoService;
    @Autowired
    IOrderService orderService;
    @Autowired
    Config config;
    @Autowired
    IWorkFlowService workFlowService;

    @GetMapping
    @ResponseBody
    @ApiOperation(value = "分页查询媒体列表", notes = "分页查询媒体列表", response = PageInfo.class)
    @Log(opType = OperateType.QUERY, note = "分页查询媒体列表", module = "媒体管理/分页查询媒体列表")
//    @Verify(code = "/mediaInfo", action = "分页查询媒体列表", module = "媒体管理/分页查询媒体列表")
    public PageInfo<MediaInfo> list(@ApiParam("媒体筛选条件") MediaInfo mediaInfo, @ApiParam("分页对象") Pageable pageable) {
        return mediaInfoService.list(mediaInfo, pageable);
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
//    @Verify(code = "/mediaInfo/{id}", action = "根据媒体ID查询媒体信息", module = "媒体管理/根据媒体ID查询媒体信息")
    public ResponseData get(@PathVariable("id") Integer id) {
        MediaInfo mediaInfo = mediaInfoService.getById(id);
        ResponseData ok = ResponseData.ok().putDataValue("mediaInfo", mediaInfo);
        return ok;
    }

    /**
     * 更新媒体信息
     *
     * @param mediaInfo
     * @param session
     * @param multipartFile
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    @ApiOperation(value = "更新媒体信息", notes = "更新媒体信息", response = ResponseData.class)
    @Log(opType = OperateType.UPDATE, note = "更新媒体信息", module = "媒体管理/更新媒体信息")
//    @Verify(code = "/mediaInfo/update", action = "更新媒体信息", module = "媒体管理/更新媒体信息")
    public ResponseData update(@ApiParam("媒体实体类") MediaInfo mediaInfo, HttpSession session, @RequestParam("file") MultipartFile multipartFile) {
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
            mediaInfo.setPicPath(config.getWebDir() + fileName);
        }
        User user = (User) session.getAttribute(IConst.USER_KEY);
        mediaInfo.setCreatorId(user.getId());
        //判断如果“更新责任人”未选择，默认就是当前用户
        if (mediaInfo.getUserId() == null)
            mediaInfo.setUserId(user.getId());
        mediaInfoService.update(mediaInfo);
        return ResponseData.ok();
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "新增媒体", notes = "新增媒体", response = ResponseData.class)
    @Log(opType = OperateType.ADD, note = "新增媒体", module = "媒体管理/新增媒体")
//    @Verify(code = "/mediaInfo/add", action = "新增媒体", module = "媒体管理/新增媒体")
    public ResponseData save(@ApiParam("媒体实体类") MediaInfo mediaInfo, HttpSession session, @RequestParam("file") MultipartFile multipartFile) {
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
            mediaInfo.setPicPath(config.getWebDir() + fileName);
        }
        User user = (User) session.getAttribute(IConst.USER_KEY);
        mediaInfo.setCreatorId(user.getId());
        //判断如果“更新责任人”未选择，默认就是当前用户
        if (mediaInfo.getUserId() == null)
            mediaInfo.setUserId(user.getId());
        mediaInfoService.save(mediaInfo);
        return ResponseData.ok();
    }

    @GetMapping("isDuplicateForName")
    @ResponseBody
    @ApiOperation(value = "通过媒体名称查询是否有媒体记录", notes = "通过媒体名称查询是否有媒体记录")
    @Log(opType = OperateType.QUERY, note = "通过媒体名称查询是否有媒体记录", module = "媒体管理/通过媒体名称查询是否有媒体记录")
//    @Verify(code = "/mediaInfo/isDuplicateForName", action = "通过媒体名称查询是否有媒体记录", module = "媒体管理/通过媒体名称查询是否有媒体记录")
    public ResponseData isDuplicateForName(@ApiParam("媒体板块类型") int mType, @ApiParam("媒体名称") String mediaName) {
        boolean flag = mediaInfoService.getByName(mType, mediaName);
        if (flag) {
            return ResponseData.customerError(1001, "媒体名称已存在!");
        }
        return ResponseData.ok();
    }


    /**
     * 审核驳回
     *
     * @param id
     * @return
     */
    @GetMapping("reject/{id}")
    @ResponseBody
    @Log(opType = OperateType.UPDATE, note = "审核驳回", module = "媒体管理/媒体审核/审核通过")
//    @Verify(code = "/mediaInfo/reject/{id}", action = "审核驳回", module = "媒体管理/媒体审核/审核驳回")
    public ResponseData reject(@PathVariable("id") Integer id) {
//        Integer userId = AppUtil.getUser().getId();
        Map<String, Object> map = new HashMap<>();
        mediaInfoService.reject(id);
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
    @Log(opType = OperateType.UPDATE, note = "审核通过", module = "媒体管理/媒体审核/审核通过")
//    @Verify(code = "/mediaInfo/pass/{id}", action = "审核通过", module = "媒体管理/媒体审核/审核通过")
    public ResponseData pass(@PathVariable("id") Integer id) {
//        Map<String, Object> map = new HashMap<>();
        mediaInfoService.pass(id);
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
    @Log(opType = OperateType.DELETE, note = "审核删除", module = "媒体管理/媒体审核/审核删除")
//    @Verify(code = "/mediaInfo/del/{id}", action = "审核删除", module = "媒体管理/媒体审核/审核删除")
    public ResponseData del(@PathVariable("id") Integer id) {
//        Map<String, Object> map = new HashMap<>();
        mediaInfoService.del(id);
        return ResponseData.ok();
    }

    @GetMapping("/audit/{id}/{taskId}")
    @ResponseBody
    @ApiOperation(value = "分页查询媒体列表", notes = "分页查询媒体列表", response = ResponseData.class)
    @Log(opType = OperateType.QUERY, note = "分页查询媒体列表", module = "媒体管理/分页查询媒体列表")
//    @Verify(code = "/mediaInfo/audit/{id}/{taskId}", action = "分页查询媒体列表", module = "媒体管理/分页查询媒体列表")
    public ModelAndView get(@PathVariable("id") Integer id, @PathVariable("taskId") String taskId, ModelAndView mv) {
        MediaInfo mediaInfo = mediaInfoService.getById(id);
        mv.addObject("mediaInfo", mediaInfo);
        mv.addObject("taskId", taskId);
        mv.setViewName("/mediaInfo/auditMedia");
        return mv;
    }

}
