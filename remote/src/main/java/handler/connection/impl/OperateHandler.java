package handler.connection.impl;

import command.PropertiesConst;
import command.SocketServer;
import executor.ServerExecutor;
import handler.connection.ConnectionHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.PrintWriter;
import java.net.Socket;

public class OperateHandler extends ConnectionHandler implements Runnable {

    private PrintWriter operatorPrintWriter;
    private ServerExecutor serverExecutor;

    public OperateHandler(SocketServer socketServer, String completeCommand){
        super(socketServer,completeCommand);
        try {
            this.operatorPrintWriter = IOUtil.wrapPrintWriter(socketServer.getSocket().getOutputStream(), PropertiesConst.appEncoding);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public OperateHandler setServerExecutor(ServerExecutor serverExecutor) {
        this.serverExecutor = serverExecutor;
        return this;
    }

    @Override
    public Object handler() {
        ThreadManager.getExecutorService().execute(this);
        return null;
    }

    @Override
    public void run() {
        SocketServer socketServer = getSocketServer();
        String otherKey = serverExecutor.getOtherKey();
        Socket otherSocket = socketServer.getRegisterSocket(otherKey);
        if(otherSocket != null){
            operatorPrintWriter.println("选择连接成功");
            operatorPrintWriter.flush();
            MessageHandler messageHandler = (MessageHandler) new MessageHandler(socketServer,getCompleteCommand()).setOperatorSocket(socketServer.getSocket()).setOtherSocket(otherSocket);
            messageHandler.setOtherKey(otherKey);
            ThreadManager.getExecutorService().execute(messageHandler);
        }else{
            try {
                operatorPrintWriter.println("选择连接失败");
                operatorPrintWriter.flush();
                String str = IOUtil.readLinStr(getSocketServer().getSocket().getInputStream(), PropertiesConst.appEncoding);
                serverExecutor.setCompleteCommand(str);
                serverExecutor.execute();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
