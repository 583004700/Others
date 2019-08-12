package handler.command.impl;

import command.PropertiesConst;
import command.entity.Computer;
import executor.BaseExecutor;
import handler.Handler;
import handler.command.OtherCommandHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.*;
import java.net.Socket;

public class UpFileHandler extends OtherCommandHandler implements Runnable{
    private volatile boolean success = true;
    private volatile boolean finish = false;
    private long timeOut = 18000000;
    private Computer computer;

    private String key;
    public UpFileHandler(String completeCommand, BaseExecutor executor, String key) {
        super(completeCommand, executor);
        computer = this.getExecutor().getComputer();
        this.key = key;
        filePath = getCommand();
        if(filePath.split(">").length > 1){
            filePath = filePath.split(">")[0];
        }
        filePath = filePath.intern();
    }

    private Socket fileSocket;
    private String filePath;
    private FileInputStream inputStream;
    private File upFile;

    private boolean checkFile(){
        boolean b = true;
        try {
            upFile = new File(filePath);
            inputStream = new FileInputStream(upFile);
        } catch (FileNotFoundException e) {
            b = false;
            e.printStackTrace();
            computer.printMessage("未找到文件:"+filePath);
        }
        return b;
    }

    private void connection(){
        PrintWriter pw = null;
        getPrintWriter().println(getCompleteCommand());
        getPrintWriter().flush();
        try {
            fileSocket = new Socket(PropertiesConst.server,PropertiesConst.port);

            ThreadManager.getExecutorService().execute(this.new Check());

            pw = IOUtil.wrapPrintWriter(fileSocket.getOutputStream(),PropertiesConst.appEncoding);
            computer.printMessage("UpFileHandler:"+getCompleteCommand()+":"+key+":"+ Handler.UPFILE);
            pw.println(getCompleteCommand()+":"+key+":"+Handler.UPFILE);
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

        if(success){
            computer.printMessage("上传检验成功"+System.currentTimeMillis());
            //告诉服务器上传较验成功
            pw.println(Handler.UPFILESUCCESS);
            pw.flush();
        }else{
            computer.printMessage("上传较验：文件上传失败，可能是找不到文件");
            pw.println("upFail");
            pw.flush();
        }
    }

    class Check implements Runnable{
        private void checkDf(){
            try {
                String otherStr = IOUtil.readLinStr(fileSocket.getInputStream(),PropertiesConst.appEncoding);
                long length = Long.parseLong(otherStr.split(":")[1]);
                otherStr = otherStr.split(":")[0];
                if(!Handler.DOWNFILESUCCESS.equals(otherStr)){
                    success = false;
                    computer.printMessage("上传较验：文件下载失败，可能不能创建目录");
                }else{
                    inputStream.skip(length);
                    computer.printMessage("UpFileHandler:接收到length"+length+"关跳转");
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
        ThreadManager.getExecutorService().execute(this);
        return null;
    }

    @Override
    public void run() {
        synchronized (filePath) {
            connection();
            long startTime = System.currentTimeMillis();
            while (!finish) {
                if (System.currentTimeMillis() - startTime > timeOut) {
                    closeInputStream();
                    computer.printMessage("上传文件等待超时");
                    return;
                }
            }
            if (!success) {
                computer.printMessage("文件传输取消，线程结束");
                closeInputStream();
                return;
            }
            computer.printMessage(filePath + "文件上传开始UpFileHandler");
            try {
                Thread.sleep(1000);
                OutputStream outputStream = fileSocket.getOutputStream();
                IOUtil.inputToOutput(inputStream, outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            computer.printMessage(filePath + "文件上传结束UpFileHandler");
        }
    }

    private void closeInputStream(){
        if(inputStream != null){
            try {
                inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
