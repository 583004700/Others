package handler.connection.impl;

import command.SocketServer;
import handler.Handler;
import handler.connection.ConnectionHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class FileHandler extends ConnectionHandler implements Runnable{

    public FileHandler(SocketServer socketServer,String completeCommand) {
        super(socketServer,completeCommand);
    }

    @Override
    public Object handler() {

        ThreadManager.getExecutorService().execute(this);
        return null;
    }

    @Override
    public void run() {
        System.out.println("服务器文件传输开始");
        Socket otherSocket = null;
        boolean b = true;
        InputStream upInStream = null;
        OutputStream downOutStream = null;
        try {
            while(otherSocket == null) {
                otherSocket = getSocketServer().getFileSocket(getCompleteCommand() + ":" + Handler.UPFILE);
            }
            getSocketServer().removeFileSocket(getCompleteCommand() + ":" + Handler.UPFILE);
            upInStream = otherSocket.getInputStream();
            OutputStream upOutStream = otherSocket.getOutputStream();
            InputStream downInStream = getOperatorSocket().getInputStream();
            downOutStream = getOperatorSocket().getOutputStream();

            String upStr = IOUtil.readLinStr(upInStream,"UTF-8");
            String downStr = IOUtil.readLinStr(downInStream,"UTF-8");

            PrintWriter downPw = IOUtil.wrapPrintWriter(downOutStream);
            PrintWriter upPw = IOUtil.wrapPrintWriter(upOutStream);
            if(Handler.UPFILESUCCESS.equals(upStr)){
                //上传较验成功，通知下载流可以下载了
                downPw.println(Handler.UPFILESUCCESS);
                downPw.flush();
            }else{
                b = false;
                downPw.println("upFail");
                downPw.flush();
            }
            if(Handler.DOWNFILESUCCESS.equals(downStr)){
                //下载较验成功，通知上传流可以上传了
                upPw.println(Handler.DOWNFILESUCCESS);
                upPw.flush();
            }else{
                b = false;
                upPw.println("downFail");
                upPw.flush();
            }
        } catch (Exception e) {
            b = false;
            e.printStackTrace();
        }
        if(b){
            System.out.println("服务器文件正在传输...");
            IOUtil.inputToOutput(upInStream, downOutStream);
        }else{
            System.out.println("文件较验失败，服务器取消传输");
        }
        System.out.println("服务器文件传输结束");
    }

}
