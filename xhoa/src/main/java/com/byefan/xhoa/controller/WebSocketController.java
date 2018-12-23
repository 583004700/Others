package com.byefan.xhoa.controller;

import com.byefan.core.ResponseData;
import com.byefan.core.config.websocket.IMServer;
import com.byefan.core.config.websocket.WebSocketServer;
import com.byefan.core.entity.WSMessage;
import org.springframework.web.bind.annotation.*;

/**
 * WebSocket服务器端推送消息示例Controller
 *
 * @author gzw
 */
@RestController
@RequestMapping("/api/ws")
public class WebSocketController {

    /**
     * 群发消息内容
     *
     * @param message
     * @return
     */
    @GetMapping(value = "/sendAll")
    String sendAllMessage(@RequestParam(required = true) WSMessage message) {
        WebSocketServer.broadCastInfo(message);
        return "ok";
    }


    /**
     * 指定会话ID发消息
     *
     * @param message 消息内容
     *                //     * @param userName 连接会话ID
     * @return
     */
    @RequestMapping("/send")
    public ResponseData sendOneMessage(WSMessage message) {
        WebSocketServer.sendMessage(message);
        return ResponseData.ok();
    }

    /**
     * 指定会话ID发消息
     *
     * @param message 消息内容
     *                //     * @param userName 连接会话ID
     * @return
     */
    @RequestMapping("/imSend")
    public ResponseData imSend(WSMessage message) {
        IMServer.sendMessage(message);
        return ResponseData.ok();
    }
}