package com.demo;

import org.java_websocket.WebSocket;

import java.util.HashMap;
import java.util.Map;

public class Chart {
    //已注册用户
    private static Map<String,User> users = new HashMap<String, User>();
    //当前登录的用户
    private static Map<User,WebSocket> onlineUsers = new HashMap<User,WebSocket>();
}
