package handler.command.impl;

import command.PropertiesConst;
import command.entity.OtherComputer;
import executor.BaseExecutor;
import handler.command.OtherCommandHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.*;
import java.net.Socket;

public class OtherFileHandler extends OtherCommandHandler implements Runnable{
    private String key;
    public OtherFileHandler(String completeCommand, PrintWriter printWriter,String key) {
        super(completeCommand, printWriter);
        this.key = key;
    }

    private Socket fileSocket;

    @Override
    public Object handler() {
        getPrintWriter().println(getCompleteCommand());
        getPrintWriter().flush();
        try {
            fileSocket = new Socket(PropertiesConst.server,PropertiesConst.port);
            PrintWriter pw = IOUtil.wrapPrintWriter(fileSocket.getOutputStream());
            System.out.println("otherFileHandler:"+getCompleteCommand()+":"+key+":other");
            pw.println(getCompleteCommand()+":"+key+":other");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ThreadManager.getExecutorService().execute(this);
        return null;
    }

    @Override
    public void run() {
        String filePath = BaseExecutor.getCommand(getCompleteCommand());
        System.out.println(filePath+"文件下载开始OtherFileHandler");
        try {
            Thread.sleep(1000);
            OutputStream outputStream = fileSocket.getOutputStream();
            FileInputStream inputStream = new FileInputStream(new File(filePath));
            IOUtil.inputToOutput(inputStream,outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        OtherComputer.resetStartTime();
        System.out.println(filePath+"文件下载结束OtherFileHandler");
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
