package handler.command.impl;

import command.PropertiesConst;
import command.entity.OtherComputer;
import handler.command.OperatorCommandHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.*;
import java.net.Socket;

public class DownFileHandler extends OperatorCommandHandler implements Runnable{
    public DownFileHandler(String otherKey, String completeCommand, PrintWriter printWriter) {
        super(otherKey, completeCommand, printWriter);
    }

    private Socket fileSocket;
    private String defaultDownPath = "d:/remotefile/";
    private String fileName;
    private FileOutputStream fileOutputStream;

    private boolean checkFile(){
        String downPath = defaultDownPath;
        fileName = getCommand();
        boolean b = true;
        try{
            String[] comArr = getCommand().split(">");
            if(comArr.length > 1){
                downPath = comArr[1];
                File downPathFile = new File(downPath);
                if(downPathFile.isDirectory()){
                    fileName = comArr[0];
                }else{
                    fileName = downPath;
                    downPath = "";
                }
            }
            fileOutputStream = new FileOutputStream(new File(downPath,fileName));
        }catch (Exception e){
            e.printStackTrace();
            b = false;
        }
        return b;
    }

    @Override
    public Object handler() {
        if(!checkFile()){
            System.out.println("文件下载失败，目录不正确");
            return null;
        }
        getPrintWriter().println(getCompleteCommand());
        getPrintWriter().flush();
        try {
            fileSocket = new Socket(PropertiesConst.server,PropertiesConst.port);
            PrintWriter pw = IOUtil.wrapPrintWriter(fileSocket.getOutputStream());
            pw.println(getCompleteCommand()+":"+getOtherKey());
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ThreadManager.getExecutorService().execute(this);
        return null;
    }

    @Override
    public void run() {
        System.out.println(fileName+"文件下载开始DownFileHandler");
        try {
            InputStream inputStream = fileSocket.getInputStream();
            IOUtil.inputToOutput(inputStream,fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        OtherComputer.resetStartTime();
        System.out.println(fileName+"文件下载结束DownFileHandler");
    }
}
