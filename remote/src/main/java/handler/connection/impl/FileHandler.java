package handler.connection.impl;

import command.SocketServer;
import handler.Handler;
import handler.connection.ConnectionHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.InputStream;
import java.net.Socket;

public class FileHandler extends ConnectionHandler implements Runnable{
    public FileHandler(SocketServer socketServer) {
        super(socketServer);
    }

    private String completeCommand;

    @Override
    public Object handler() {

        ThreadManager.getExecutorService().execute(this);
        return null;
    }

    @Override
    public void run() {
        System.out.println("服务器文件下载开始");
        Socket otherSocket = null;
        try {
            while(otherSocket == null) {
                otherSocket = getSocketServer().getFileSocket(getCompleteCommand() + ":" + Handler.UPFILE);
            }
            getSocketServer().removeFileSocket(getCompleteCommand() + ":" + Handler.UPFILE);
            InputStream inputStream = otherSocket.getInputStream();
            IOUtil.inputToOutput(inputStream, getOperatorSocket().getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("服务器文件下载结束");
    }

    public String getCompleteCommand() {
        return completeCommand;
    }

    public void setCompleteCommand(String completeCommand) {
        this.completeCommand = completeCommand;
    }
}
