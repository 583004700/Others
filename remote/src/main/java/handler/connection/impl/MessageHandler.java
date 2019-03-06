package handler.connection.impl;

import command.PropertiesConst;
import command.SocketServer;
import handler.connection.ConnectionHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.IOException;

class OtherMessageHandler extends ConnectionHandler implements Runnable{

    public OtherMessageHandler(SocketServer socketServer,String completeCommand) {
        super(socketServer,completeCommand);
    }

    @Override
    public void run() {
        handler();
        System.out.println(getOtherSocket()+":OtherMessageHandler线程结束");
    }

    @Override
    public Object handler() {
        new MessageHandler(getSocketServer(),getCompleteCommand()).setOperatorSocket(getOperatorSocket()).setOtherSocket(getOtherSocket()).handler();
        return null;
    }
}

public class MessageHandler extends ConnectionHandler implements Runnable{
    public MessageHandler(SocketServer socketServer,String completeCommand) {
        super(socketServer,completeCommand);
    }

    public void run() {
        OtherMessageHandler otherMessageHandler = (OtherMessageHandler)new OtherMessageHandler(getSocketServer(),getCompleteCommand()).setOperatorSocket(getOtherSocket()).setOtherSocket(getOperatorSocket());
        ThreadManager.getExecutorService().execute(otherMessageHandler);
        handler();
        System.out.println(getOtherKey()+":MessageHandler线程结束");
    }

    @Override
    public Object handler() {
        System.out.println(getOtherKey()+"MessageHandler");
        try {
            IOUtil.readStrToOutputStream(getOperatorSocket().getInputStream(), PropertiesConst.appEncoding,getOtherSocket().getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                getOtherSocket().close();
                System.out.println(getOtherKey()+"服务端线程关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
