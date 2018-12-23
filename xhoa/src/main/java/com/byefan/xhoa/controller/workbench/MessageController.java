package com.byefan.xhoa.controller.workbench;

import com.byefan.core.ResponseData;
import com.byefan.xhoa.entity.workbench.Message;
import com.byefan.xhoa.service.workbench.IMessageService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    IMessageService messageService;

    /**
     * 查询消息列表
     * @param params
     * @param pageable
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public PageInfo<Map> list(@RequestParam Map params, @PageableDefault(size = 200) Pageable pageable){
        return messageService.list(params,pageable);
    }

    @ResponseBody
    @RequestMapping("/readMessage")
    public ResponseData readMessage(Message message){
        try{
            boolean readStatus = messageService.readMessage(message);
            ResponseData responseData = ResponseData.ok();
            return responseData;
        }catch (Exception e){
            log.error("消息读取失败",e);
            ResponseData responseData = ResponseData.customerError(1001,e.getMessage());
            return responseData;
        }
    }
}
