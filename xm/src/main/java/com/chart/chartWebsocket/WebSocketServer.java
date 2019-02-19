package com.chart.chartWebsocket;

import com.common.util.JsonUtil;
import com.scriptManager.entity.User;
import com.scriptManager.mapper.UserMapper;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;


@ServerEndpoint(value="/chartWebsocket/{id}")
@Component
public class WebSocketServer {

    public static UserMapper userMapper;

    private Session session;
    private String id;
    private User user;
    private static ConcurrentHashMap<String,WebSocketServer> onLineUsers = new ConcurrentHashMap<String,WebSocketServer>();

    @OnOpen
    public void onOpen(Session session,@PathParam("id") String id) {
        this.session = session;
        this.id = id;
        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("id",id);
        this.user = userMapper.queryOne(hashMap);
        onLineUsers.put(id,this);
        try {
            String openMessage = "{\"onOpen\":"+JsonUtil.ObjectToJsonString(user)+"}";
            System.out.println(openMessage);
            sendMessage(id, openMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose() {
        onLineUsers.remove(id);
        System.out.println("关闭了:"+this);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("收到消息："+message+":"+this);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        //error.printStackTrace();
    }

    /**
     * 给某个用户发送消息
     * @param id
     * @param message
     * @throws IOException
     */
    public void sendMessage(String id,String message) throws IOException {
        WebSocketServer webSocketServer = onLineUsers.get(id);
        webSocketServer.session.getBasicRemote().sendText(message);
    }

}