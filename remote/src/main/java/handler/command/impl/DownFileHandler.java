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
        fileName = new File(getCommand()).getName();
        boolean b = true;
        File downPathFile = null;
        try{
            downPathFile = new File(downPath,fileName);
            String[] comArr = getCommand().split(">");
            if(comArr.length > 1){
                fileName = new File(comArr[0]).getName();
                downPath = comArr[1];
                downPathFile = new File(downPath);
                if(downPathFile.isDirectory()){
                    downPathFile = new File(downPath,fileName);
                }else{
                    if(!downPathFile.getParentFile().exists()){
                        downPathFile.getParentFile().mkdirs();
                    }
                }
            }
            fileOutputStream = new FileOutputStream(downPathFile);
        }catch (Exception e){
            e.printStackTrace();
            b = false;
        }
        return b;
    }

    public boolean connection(){
        if(!checkFile()){
            System.out.println("文件下载失败");
            getPrintWriter().println("对方文件下载失败");
            getPrintWriter().flush();
            return false;
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
