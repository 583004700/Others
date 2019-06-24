package handler.command.impl;

import command.PropertiesConst;
import command.entity.OtherComputer;
import handler.Handler;
import handler.command.OtherCommandHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.*;
import java.net.Socket;

public class UpFileHandler extends OtherCommandHandler implements Runnable{
    private String key;
    public UpFileHandler(String completeCommand, PrintWriter printWriter, String key) {
        super(completeCommand, printWriter);
        this.key = key;
    }

    private Socket fileSocket;
    private String filePath;
    private FileInputStream inputStream;
    private File upFile;

    private boolean checkFile(){
        boolean b = true;
        try {
            filePath = getCommand();
            if(filePath.split(">").length > 1){
                filePath = filePath.split(">")[0];
            }
            upFile = new File(filePath);
            inputStream = new FileInputStream(upFile);
        } catch (FileNotFoundException e) {
            b = false;
            e.printStackTrace();
            System.out.println("未找到文件:"+filePath);
        }
        return b;
    }

    private boolean connection(){
        boolean success = true;
        PrintWriter pw = null;
        getPrintWriter().println(getCompleteCommand());
        getPrintWriter().flush();
        try {
            fileSocket = new Socket(PropertiesConst.server,PropertiesConst.port);
            pw = IOUtil.wrapPrintWriter(fileSocket.getOutputStream(),PropertiesConst.appEncoding);
            System.out.println("UpFileHandler:"+getCompleteCommand()+":"+key+":"+ Handler.UPFILE);
            pw.println(getCompleteCommand()+":"+key+":"+Handler.UPFILE);
            pw.flush();
            if(!checkFile()){
                success = false;
            }
        } catch (IOException e) {
            success = false;
            e.printStackTrace();
        }
        if(success){
            //告诉服务器上传较验成功
            pw.println(Handler.UPFILESUCCESS);
            pw.flush();
        }else{
            System.out.println("本机较验：文件上传失败，可能是找不到文件");
            pw.println("upFail");
            pw.flush();
        }
        try {
            String otherStr = IOUtil.readLinStr(fileSocket.getInputStream(),PropertiesConst.appEncoding);
            long length = Long.parseLong(otherStr.split(":")[1]);
            otherStr = otherStr.split(":")[0];
            if(!Handler.DOWNFILESUCCESS.equals(otherStr)){
                success = false;
                System.out.println("对方较验：文件下载失败，可能不能创建目录");
            }else{
                inputStream.skip(length);
                System.out.println("UpFileHandler:接收到length"+length+"关跳转");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public Object handler() {
        ThreadManager.getExecutorService().execute(this);
        return null;
    }

    @Override
    public void run() {
        boolean b = connection();
        if(!b){
            System.out.println("文件传输取消，线程结束");
            return;
        }
        System.out.println(filePath+"文件上传开始UpFileHandler");
        try {
            Thread.sleep(1000);
            OutputStream outputStream = fileSocket.getOutputStream();
            IOUtil.inputToOutput(inputStream,outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        OtherComputer.resetStartTime();
        System.out.println(filePath+"文件上传结束UpFileHandler");
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
