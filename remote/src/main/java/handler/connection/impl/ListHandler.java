package handler.connection.impl;

import command.PropertiesConst;
import command.SocketServer;
import executor.ServerExecutor;
import handler.Handler;
import handler.connection.ConnectionHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.PrintWriter;

public class ListHandler extends ConnectionHandler implements Runnable {

    private PrintWriter operatorPrintWriter;
    private ServerExecutor serverExecutor;

    public ListHandler(SocketServer socketServer, String completeCommand){
        super(socketServer,completeCommand);
        try {
            this.operatorPrintWriter = IOUtil.wrapPrintWriter(socketServer.getSocket().getOutputStream(), PropertiesConst.appEncoding);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ListHandler setServerExecutor(ServerExecutor serverExecutor) {
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
        String list = getSocketServer().getRegisterSocketList();
        try {
            operatorPrintWriter.println(Handler.returnList + list);
            operatorPrintWriter.flush();
            String str = IOUtil.readLinStr(getSocketServer().getSocket().getInputStream(), PropertiesConst.appEncoding);
            serverExecutor.setCompleteCommand(str);
            serverExecutor.execute();
            System.out.println("ListHandler结束");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
