package handler.connection.impl;

import command.SocketServer;
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
                //downfile:pom.xml:zhuwbDESKTOP-IHHLP8T:other
                //System.out.println("获取文件socket:"+getCompleteCommand() + ":other");
                otherSocket = getSocketServer().getFileSocket(getCompleteCommand() + ":other");
            }
            getSocketServer().removeFileSocket(getCompleteCommand() + ":other");
            InputStream inputStream = otherSocket.getInputStream();
            IOUtil.inputToOutput(inputStream, getOperatorSocket().getOutputStream());
            //FileOutputStream fileOutputStream = new FileOutputStream("d:/remotefile/pom1.xml");
            //IOUtil.inputToOutput(inputStream,fileOutputStream);
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
