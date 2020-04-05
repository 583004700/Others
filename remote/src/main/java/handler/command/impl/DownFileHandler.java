package handler.command.impl;

import command.PropertiesConst;
import command.entity.Computer;
import executor.BaseExecutor;
import handler.Handler;
import handler.command.OperatorCommandHandler;
import thread.ThreadManager;
import util.FileUtil;
import util.IOUtil;
import util.OSUtil;
import views.pages.ScreenPanel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class DownFileHandler extends OperatorCommandHandler implements Callable<Object> {
    private volatile boolean success = true;
    private volatile boolean finish = false;
    private volatile Future future;
    private long timeOut = 180000;
    private Computer computer;
    private ScreenPanel screenPanel;
    private boolean screenIn;

    public boolean cancel(){
        computer.printMessage(this+"===========cancelFuture"+future);
        return future.cancel(true);
    }

    public DownFileHandler(String otherKey, String completeCommand, BaseExecutor executor, ScreenPanel screenPanel) {
        super(otherKey, completeCommand, executor);
        this.screenPanel = screenPanel;
        if(screenPanel != null){
            screenIn = true;
        }
        computer = this.getExecutor().getComputer();

        if(!screenIn) {
            if (OSUtil.isLinux()) {
                defaultDownPath = "/remotefile/";
            }
            String downPath = defaultDownPath;
            String[] comArr = getCommand().split(">");
            fileName = FileUtil.getName(comArr[0]);
            if (comArr.length > 1) {
                String newFileName = FileUtil.getName(comArr[1]);
                if ("".equals(newFileName)) {
                    newFileName = fileName;
                }
                fileName = newFileName;
                String newDownPath = FileUtil.getPath(comArr[1]);
                if ("".equals(newDownPath)) {
                    newDownPath = downPath;
                }
                if (new File(comArr[1]).isDirectory()) {
                    newDownPath = comArr[1];
                }
                downPath = newDownPath;
            }
            fileName = fileName.replaceAll(" ", "空格");
            downPathFile = new File(downPath);
            if (!downPathFile.exists()) {
                downPathFile.mkdirs();
            }
            downPathFile = new File(downPathFile, fileName);
            fullDownPath = downPathFile.getAbsolutePath().intern();
        }else{
            fullDownPath = getCommand();
        }
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
            if(!screenIn) {
                fileOutputStream = new FileOutputStream(downPathFile, true);
            }
        }catch (Exception e){
            e.printStackTrace();
            computer.printMessage("目录为:"+downPathFile);
            b = false;
        }
        return b;
    }

    public void connection(){

        PrintWriter pw = null;
        getPrintWriter().println(getCompleteCommand());
        getPrintWriter().flush();
        try {
            if(screenPanel != null){
                screenPanel.getScreenFrame().setTitle("正在尝试连接："+screenPanel.getKey());
            }
            fileSocket = new Socket(PropertiesConst.server,PropertiesConst.port);

            ThreadManager.getExecutorService().execute(this.new Check());

            pw = IOUtil.wrapPrintWriter(fileSocket.getOutputStream(),PropertiesConst.appEncoding);
            System.out.println("down将要发送1");
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

        long length = 0;

        if(!screenIn) {
            length = downPathFile.exists() ? downPathFile.length() : 0;
        }
        if(success){
            //告诉服务器下载较验成功
            System.out.println("down将要发送2");
            pw.println(Handler.DOWNFILESUCCESS+":"+length);
            pw.flush();
            computer.printMessage("DownFileHandler:发送length给服务器"+System.currentTimeMillis()+":"+Handler.DOWNFILESUCCESS+":"+length);
        }else{
            computer.printMessage("文件下载失败，可能是不能创建目录");
            pw.println("downFail:"+length);
            pw.flush();
        }

    }

    class Check implements Runnable{
        private void checkDf(){
            try {
                System.out.println("down将要read");
                String otherStr = IOUtil.readLinStr(fileSocket.getInputStream(),PropertiesConst.appEncoding);
                System.out.println("down read到数据");
                if(!Handler.UPFILESUCCESS.equals(otherStr)){
                    success = false;
                    computer.printMessage("下载较验：文件上传失败，可能是找不到文件");
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
        computer.printMessage(this+"==============future:"+future);
        return null;
    }

    @Override
    public Object call() {
        computer.printMessage("下载文件call开始");
        computer.printMessage("fullDownPath为"+fullDownPath);
        synchronized (fullDownPath) {
            computer.printMessage("线程：" + Thread.currentThread().getName());
            connection();
            long startTime = System.currentTimeMillis();
            while(!finish){
                if (System.currentTimeMillis() - startTime > timeOut) {
                    closeFileOutputStream();
                    deleteFile();
                    computer.printMessage("下载文件等待超时");
                    return null;
                }
            }
            if (!success) {
                closeFileOutputStream();
                deleteFile();
                computer.printMessage("文件传输取消，线程结束");
                return null;
            }
            long downStartTime = System.currentTimeMillis();
            computer.printMessage(fileName + "文件下载开始DownFileHandler");
            try {
                InputStream inputStream = fileSocket.getInputStream();
                if(!screenIn) {
                    IOUtil.inputToOutput(inputStream, fileOutputStream);
                }else{
                    //inputStream = new FileInputStream("d:/remotefile/2019081717340485.png");
                    screenPanel.setImage(inputStream);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //文件接收成功，告诉对方文件接收成功了
            //getPrintWriter().println(fullDownPath+Handler.separator+Handler.receiveSuccess);
            //getPrintWriter().flush();
            computer.printMessage(fullDownPath + "文件下载结束,所用时间为："+(System.currentTimeMillis() - downStartTime));
        }
        computer.printMessage("下载文件call结束");
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
