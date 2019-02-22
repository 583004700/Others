package com.chart.chartWebsocket;

import com.alibaba.fastjson.JSONObject;
import com.common.util.JsonUtil;
import com.scriptManager.entity.User;
import com.scriptManager.mapper.UserMapper;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@ServerEndpoint(value="/chartWebsocket/{id}")
@Component
public class WebSocketServer {
    //上线
    private static final String ON_LINE = "onLine";
    //下线
    private static final String OUT_LINE = "outLine";

    //刷新在线用户列表
    private static final String FLUSH_USERS = "flushUsers";
    //发送普通消息
    private static final String SEND_MESSAGE = "sendMessage";

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
        try {
            onLine();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose() {
        outLine();
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        JSONObject messageObject = JSONObject.parseObject(message);
        if(messageObject.get(FLUSH_USERS) != null){
            flushUsers();
        }
        if(messageObject.get(SEND_MESSAGE) != null){
            JSONObject chartRecord = messageObject.getJSONObject(SEND_MESSAGE);
            sendMessage(chartRecord.getString("chartTo"),messageObject.toJSONString());
        }
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
    public void sendMessage(String id,String message){

        WebSocketServer webSocketServer = null;
        try {
            webSocketServer = onLineUsers.get(id);
            webSocketServer.session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("消息发送失败-用户id"+id+"内容"+message);
        }
    }

    /**
     * 给所有在线用户发送消息
     * @param message
     */
    public void sendMessageToAllUser(String message){
        List<User> onLineUsers = getOnLineUsers();
        for (int i = 0; i < onLineUsers.size(); i++) {
            sendMessage(onLineUsers.get(i).getId(),message);
        }
    }

    /**
     * 用户上线,通知其它用户添加当前用户
     */
    public void onLine(){
        if(onLineUsers.containsKey(id)){
            //如果已经在线，则让之前用户下线
            onLineUsers.get(id).outLine();
        }
        onLineUsers.put(id,this);
        String onLineMessage = "{\""+ON_LINE+"\":"+JsonUtil.ObjectToJsonString(user)+"}";
        sendMessageToAllUser(onLineMessage);
    }

    /**
     * 用户下线，通知其它用户删除当前用户
     */
    public void outLine(){
        try {
            this.session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        onLineUsers.remove(id);
        String onLineMessage = "{\""+OUT_LINE+"\":"+JsonUtil.ObjectToJsonString(user)+"}";
        sendMessageToAllUser(onLineMessage);
    }

    /**
     * 申请用户列表
     */
    public void flushUsers(){
        String flushMessage = "{\""+FLUSH_USERS+"\":"+JsonUtil.ObjectToJsonString(getOnLineUsers())+"}";
        sendMessage(this.user.getId(),flushMessage);
    }

    /**
     * 获取在线用户
     * @return
     */
    private List<User> getOnLineUsers(){
        List<User> users = new ArrayList<User>();
        for(Map.Entry<String,WebSocketServer> entry : onLineUsers.entrySet()){
            if(!entry.getValue().user.getId().equals(this.user.getId())){
                users.add(entry.getValue().user);
            }
        }
        return users;
    }

}