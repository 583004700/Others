package handler.connection.impl;

import command.PropertiesConst;
import command.SocketServer;
import handler.Handler;
import handler.connection.ConnectionHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class FileHandler extends ConnectionHandler implements Runnable{

    private InputStream upInStream = null;
    private OutputStream downOutStream = null;
    private volatile String upStr;
    private volatile String downStr;

    private OutputStream upOutStream;
    private InputStream downInStream;

    public FileHandler(SocketServer socketServer,String completeCommand) {
        super(socketServer,completeCommand);
    }

    @Override
    public Object handler() {

        ThreadManager.getExecutorService().execute(this);
        return null;
    }

    class UpCheck implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("开始接收upStr"+new Date().getTime());
                upStr = IOUtil.readLinStr(upInStream, PropertiesConst.appEncoding);
                System.out.println("接收到upStr");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    class DownCheck implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("开始接收downStr"+new Date().getTime());
                downStr = IOUtil.readLinStr(downInStream, PropertiesConst.appEncoding);
                System.out.println("接收到downStr");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        System.out.println("服务器文件传输开始");
        Socket otherSocket = null;
        boolean b = true;

        try {
            System.out.println("查找文件"+getCompleteCommand() + ":" + Handler.UPFILE);
            while(otherSocket == null) {
                otherSocket = getSocketServer().getFileSocket(getCompleteCommand() + ":" + Handler.UPFILE);
            }
            System.out.println("服务器找到文件");
            getSocketServer().removeFileSocket(getCompleteCommand() + ":" + Handler.UPFILE);
            upInStream = otherSocket.getInputStream();
            upOutStream = otherSocket.getOutputStream();
            downInStream = getOperatorSocket().getInputStream();
            downOutStream = getOperatorSocket().getOutputStream();
            ThreadManager.getExecutorService().execute(this.new UpCheck());
            ThreadManager.getExecutorService().execute(this.new DownCheck());

            while(upStr == null || downStr == null){}
            System.out.println("接收到upStr和downStr");

            long length = Long.parseLong(downStr.split(":")[1]);
            downStr = downStr.split(":")[0];

            PrintWriter downPw = IOUtil.wrapPrintWriter(downOutStream,PropertiesConst.appEncoding);
            PrintWriter upPw = IOUtil.wrapPrintWriter(upOutStream,PropertiesConst.appEncoding);
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
                upPw.println(Handler.DOWNFILESUCCESS+":"+length);
                upPw.flush();
                System.out.println("FileHandler:服务器接收到length"+length+"并发送给上传方");
            }else{
                b = false;
                upPw.println("downFail:"+length);
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
        System.out.println("服务器文件传输线程结束");
        try {
            downOutStream.close();
            getOperatorSocket().close();
            upInStream.close();
            otherSocket.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
