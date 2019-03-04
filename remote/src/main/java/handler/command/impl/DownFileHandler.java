package handler.command.impl;

import command.PropertiesConst;
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

    @Override
    public Object handler() {
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
        String fileName = getCommand();
        System.out.println(fileName+"文件下载开始DownFileHandler");
        try {
            InputStream inputStream = fileSocket.getInputStream();
            File file = new File("d:/remotefile/");
            if(!file.exists()){
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file,new File(fileName).getName()));
            IOUtil.inputToOutput(inputStream,fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(fileName+"文件下载结束DownFileHandler");
    }
}
