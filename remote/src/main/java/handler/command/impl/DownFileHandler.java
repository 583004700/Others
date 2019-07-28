package handler.command.impl;

import command.PropertiesConst;
import command.entity.OtherComputer;
import handler.Handler;
import handler.command.OperatorCommandHandler;
import thread.ThreadManager;
import util.FileUtil;
import util.IOUtil;
import util.OSUtil;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class DownFileHandler extends OperatorCommandHandler implements Callable<Object> {
    private volatile boolean success = true;
    private volatile boolean finish = false;
    private volatile Future future;
    private long timeOut = 18000000;

    public boolean cancel(){
        System.out.println(this+"===========cancelFuture"+future);
        return future.cancel(true);
    }

    public DownFileHandler(String otherKey, String completeCommand, PrintWriter printWriter) {
        super(otherKey, completeCommand, printWriter);
        if(OSUtil.isLinux()){
            defaultDownPath = "/remotefile/";
        }
        String downPath = defaultDownPath;
        String[] comArr = getCommand().split(">");
        fileName = FileUtil.getName(comArr[0]);
        if(comArr.length > 1){
            String newFileName = FileUtil.getName(comArr[1]);
            if("".equals(newFileName)){
                newFileName = fileName;
            }
            fileName = newFileName;
            String newDownPath = FileUtil.getPath(comArr[1]);
            if("".equals(newDownPath)){
                newDownPath = downPath;
            }
            if(new File(comArr[1]).isDirectory()){
                newDownPath = comArr[1];
            }
            downPath = newDownPath;
        }
        fileName = fileName.replaceAll(" ","空格");
        downPath = downPath.replaceAll(" ","空格");
        downPathFile = new File(downPath);
        if(!downPathFile.exists()){
            downPathFile.mkdirs();
        }
        downPathFile = new File(downPathFile,fileName);
        fullDownPath = downPathFile.getAbsolutePath().intern();
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

    public void connection(){

        PrintWriter pw = null;
        getPrintWriter().println(getCompleteCommand());
        getPrintWriter().flush();
        try {
            fileSocket = new Socket(PropertiesConst.server,PropertiesConst.port);

            ThreadManager.getExecutorService().execute(this.new Check());

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
            Thread.sleep(8000);
        }catch (Exception e){
            e.printStackTrace();
        }

        long length = downPathFile.exists() ? downPathFile.length() : 0;
        if(success){
            //告诉服务器下载较验成功
            pw.println(Handler.DOWNFILESUCCESS+":"+length);
            pw.flush();
            System.out.println("DownFileHandler:发送length给服务器"+new Date().getTime()+":"+Handler.DOWNFILESUCCESS+":"+length);
        }else{
            System.out.println("本机较验：文件下载失败，可能是不能创建目录");
            pw.println("downFail:"+length);
            pw.flush();
        }

    }

    class Check implements Runnable{
        private void checkDf(){
            try {
                String otherStr = IOUtil.readLinStr(fileSocket.getInputStream(),PropertiesConst.appEncoding);
                if(!Handler.UPFILESUCCESS.equals(otherStr)){
                    success = false;
                    System.out.println("对方较验：文件上传失败，可能是找不到文件");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finish = true;
        }

        @Override
        public void run() {
            checkDf();
        }
    }


    @Override
    public Object handler() {
        future = ThreadManager.getExecutorService().submit(this);
        System.out.println(this+"==============future:"+future);
        return null;
    }

    @Override
    public Object call() {
        System.out.println("fullDownPath为"+fullDownPath);
        synchronized (fullDownPath) {
            System.out.println("线程：" + Thread.currentThread().getName());
            connection();
            long startTime = new Date().getTime();
            while(!finish){
                if (new Date().getTime() - startTime > timeOut) {
                    closeFileOutputStream();
                    deleteFile();
                    System.out.println("下载文件等待超时");
                    return null;
                }
            }
            if (!success) {
                closeFileOutputStream();
                deleteFile();
                System.out.println("文件传输取消，线程结束");
                return null;
            }
            long downStartTime = new Date().getTime();
            System.out.println(fileName + "文件下载开始DownFileHandler");
            try {
                InputStream inputStream = fileSocket.getInputStream();
                IOUtil.inputToOutput(inputStream, fileOutputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            OtherComputer.resetStartTime();
            System.out.println(fileName + "文件下载结束DownFileHandler,所用时间为："+(new Date().getTime() - downStartTime));
        }
        return null;
    }

    private void closeFileOutputStream(){
        if(fileOutputStream != null){
            try {
                fileOutputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void deleteFile(){
        if(downPathFile.exists() && downPathFile.length() == 0){
            downPathFile.delete();
        }
    }
}
