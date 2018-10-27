package com.demo;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class WsServer extends WebSocketServer {
    static boolean b = false;

    public WsServer(int port) {
        super(new InetSocketAddress(port));
    }

    public WsServer(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        // ws连接的时候触发的代码，onOpen中我们不做任何操作
        System.out.println("onOpen");
        System.out.println("getLocalSocketAddress========="+conn.getLocalSocketAddress());
        System.out.println("getRemoteSocketAddress========="+conn.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        //断开连接时候触发代码
        System.out.println("onclose------");
    }

    @Override
    public void onMessage(final WebSocket conn, String message) {
        conn.send("您好，已收到消息"+message);
        System.out.println("您好，已收到消息"+message+"来自于socket"+conn+"=============this"+this);
        int count = 0;
//        while(!"close".equals(message)){
//            count++;
//            synchronized (this) {
//                if (count >= 60 && !b) {
//                    b = true;
//                    break;
//                }
//            }
//            System.out.println("来自于socket"+conn+"=============this=========="+this+"===========CurrentThread============"+Thread.currentThread());
//            conn.send(new Date().toString());
//            try {
//                Thread.sleep(1000);
//            }catch (Exception e){}
//        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        //错误时候触发的代码
        System.out.println("on error");
        ex.printStackTrace();
    }

    @Override
    public void onStart() {

    }
}
