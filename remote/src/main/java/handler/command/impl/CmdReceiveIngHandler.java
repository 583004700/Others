package handler.command.impl;

import handler.Handler;
import handler.command.OtherCommandHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.*;

public class CmdReceiveIngHandler extends OtherCommandHandler{
    private BufferedReader bufferedReader;

    public CmdReceiveIngHandler(String completeCommand, BufferedReader bufferedReader, PrintWriter printWriter) {
        super(completeCommand, printWriter);
        this.bufferedReader = bufferedReader;
    }

    @Override
    public Object handler() {
        System.out.println("进入CmdReceiveIngHandler");
        try {
            Process process = Runtime.getRuntime().exec("cmd");
            InputStream inputStream = process.getInputStream();
            OutputStream outputStream = process.getOutputStream();
            PrintWriter printWriter = IOUtil.wrapPrintWriter(outputStream,"GBK");

            ResultReceiveIngThread resultReceiveThread = new ResultReceiveIngThread(IOUtil.wrapBufferedReader(inputStream,"GBK"),getPrintWriter());
            ThreadManager.getExecutorService().execute(resultReceiveThread);

            String readStr = "";
            while ((readStr = bufferedReader.readLine()) != null){
                System.out.println("进入CmdReceiveIngHandler while");
                System.out.println("向cmd中输入命令"+readStr);
                printWriter.println(readStr);
                printWriter.flush();
                //先输入到cmd中告诉控制台要退出
                if(Handler.CMDEND.equals(readStr)){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Handler.CMDEND+"CmdReceiveIngHandler结束");
        return null;
    }
}


class ResultReceiveIngThread implements Runnable{
    //命令行的输入流
    BufferedReader bufferedReader;
    //打印结果的流
    PrintWriter printWriter;

    public ResultReceiveIngThread(BufferedReader bufferedReader, PrintWriter printWriter) {
        this.bufferedReader = bufferedReader;
        this.printWriter = printWriter;
    }

    @Override
    public void run() {
        try {
            String readStr = "";
            while((readStr = bufferedReader.readLine()) != null){
                System.out.println("从命令行中读取数据"+readStr);
                if(readStr != null && readStr.endsWith(Handler.CMDEND)){
                    break;
                }
                printWriter.println(readStr);
                printWriter.flush();
            }
            System.out.println("ResultReceiveIngThread线程结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
