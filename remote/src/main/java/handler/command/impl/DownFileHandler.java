package handler.command.impl;

import command.PropertiesConst;
import command.entity.OtherComputer;
import handler.Handler;
import handler.command.OperatorCommandHandler;
import thread.ThreadManager;
import util.IOUtil;
import util.OSUtil;

import java.io.*;
import java.net.Socket;

public class DownFileHandler extends OperatorCommandHandler implements Runnable{
    public DownFileHandler(String otherKey, String completeCommand, PrintWriter printWriter) {
        super(otherKey, completeCommand, printWriter);
        if(OSUtil.isLinux()){
            defaultDownPath = "/weblogic/remotefile";
        }

        String downPath = defaultDownPath;
        fileName = new File(getCommand()).getName();
        if(fileName.contains("\\") || fileName.contains("/")){
            int last = fileName.lastIndexOf("\\");
            int last2 = fileName.lastIndexOf("/");
            int maxLast = Math.max(last,last2);
            fileName = fileName.substring(maxLast+1,fileName.length());
        }
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
        fullDownPath = downPathFile.toString().intern();
    }

    private Socket fileSocket;
    private String defaultDownPath = "d:/remotefile/";
    private String fileName;
    private FileOutputStream fileOutputStream;
    private File downPathFile;
    private volatile String fullDownPath;

    private boolean checkFile(){
        boolean b = true;
        try{
            fileOutputStream = new FileOutputStream(downPathFile,true);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("目录为:"+downPathFile);
            b = false;
        }
        return b;
    }

    public boolean connection(){
        boolean success = true;
        PrintWriter pw = null;
        getPrintWriter().println(getCompleteCommand());
        getPrintWriter().flush();
        try {
            fileSocket = new Socket(PropertiesConst.server,PropertiesConst.port);
            pw = IOUtil.wrapPrintWriter(fileSocket.getOutputStream(),PropertiesConst.appEncoding);
            pw.println(getCompleteCommand()+":"+getOtherKey());
            pw.flush();
            if(!checkFile()){
                success = false;
            }
        } catch (IOException e) {
            success = false;
            e.printStackTrace();
        }

        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        long length = downPathFile.exists() ? downPathFile.length() : 0;
        if(success){
            //告诉服务器下载较验成功
            pw.println(Handler.DOWNFILESUCCESS+":"+length);
            pw.flush();
            System.out.println("DownFileHandler:发送length给服务器"+Handler.DOWNFILESUCCESS+":"+length);
        }else{
            System.out.println("本机较验：文件下载失败，可能是不能创建目录");
            pw.println("downFail:"+length);
            pw.flush();
        }
        try {
            String otherStr = IOUtil.readLinStr(fileSocket.getInputStream(),PropertiesConst.appEncoding);
            if(!Handler.UPFILESUCCESS.equals(otherStr)){
                success = false;
                System.out.println("对方较验：文件上传失败，可能是找不到文件");
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
        System.out.println("fullDownPath为"+fullDownPath);
        synchronized (fullDownPath) {
            System.out.println("线程：" + Thread.currentThread().getName());
            boolean b = connection();
            if (!b) {
                System.out.println("文件传输取消，线程结束");
                return;
            }
            System.out.println(fileName + "文件下载开始DownFileHandler");
            try {
                InputStream inputStream = fileSocket.getInputStream();
                IOUtil.inputToOutput(inputStream, fileOutputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            OtherComputer.resetStartTime();
            System.out.println(fileName + "文件下载结束DownFileHandler");
        }
    }
}
