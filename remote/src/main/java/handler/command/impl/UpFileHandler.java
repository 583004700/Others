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

    private boolean checkFile(){
        boolean b = true;
        try {
            filePath = getCommand();
            if(filePath.split(">").length > 1){
                filePath = filePath.split(">")[0];
            }
            inputStream = new FileInputStream(new File(filePath));
        } catch (FileNotFoundException e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    private boolean connection(){
        if(!checkFile()){
            System.out.println("文件上传失败");
            getPrintWriter().println("对方文件上传失败");
            getPrintWriter().flush();
            return false;
        }
        getPrintWriter().println(getCompleteCommand());
        getPrintWriter().flush();
        try {
            fileSocket = new Socket(PropertiesConst.server,PropertiesConst.port);
            PrintWriter pw = IOUtil.wrapPrintWriter(fileSocket.getOutputStream());
            System.out.println("UpFileHandler:"+getCompleteCommand()+":"+key+":"+ Handler.UPFILE);
            pw.println(getCompleteCommand()+":"+key+":"+Handler.UPFILE);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
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
