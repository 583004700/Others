package handler.command.impl;

import command.PropertiesConst;
import executor.OtherExecutor;
import handler.Handler;
import handler.command.OtherCommandHandler;
import thread.ThreadManager;
import util.CmdUtil;
import util.IOUtil;

import java.io.*;

public class CmdReceiveIngHandler extends OtherCommandHandler{
    private OtherExecutor otherExecutor;
    private BufferedReader bufferedReader;

    public CmdReceiveIngHandler(OtherExecutor otherExecutor,String completeCommand) {
        super(completeCommand, otherExecutor);
        this.bufferedReader = getExecutor().getComputer().getBufferedReader();
        this.otherExecutor = otherExecutor;
    }

    @Override
    public Object handler() {
        System.out.println("进入CmdReceiveIngHandler");
        try {
            Process process = CmdUtil.getProcess();
            InputStream inputStream = process.getInputStream();
            InputStream errorStream = process.getErrorStream();
            OutputStream outputStream = process.getOutputStream();
            PrintWriter printWriter = IOUtil.wrapPrintWriter(outputStream, PropertiesConst.cmdEncoding);

            ResultReceiveIngThread resultReceiveThread = new ResultReceiveIngThread(IOUtil.wrapBufferedReader(inputStream,PropertiesConst.cmdEncoding),getPrintWriter());
            ThreadManager.getExecutorService().execute(resultReceiveThread);

            ResultReceiveIngThread errorReceiveThread = new ResultReceiveIngThread(IOUtil.wrapBufferedReader(errorStream,PropertiesConst.cmdEncoding),getPrintWriter());
            ThreadManager.getExecutorService().execute(errorReceiveThread);

            String readStr = "";
            while ((readStr = bufferedReader.readLine()) != null){
                if(readStr.equals(Handler.HEART+Handler.separator)){
                    otherExecutor.getOtherComputer().resetHeartTime();
                }else {
                    System.out.println("进入CmdReceiveIngHandler while");
                    if ((Handler.CMDEND+Handler.separator).equals(readStr)) {
                        printWriter.close();
                        outputStream.close();
                        break;
                    }
                    System.out.println("向cmd中输入命令" + readStr);
                    printWriter.println(readStr);
                    printWriter.flush();
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
                if(readStr != null && readStr.equals(Handler.CMDEND+Handler.separator)){
                    break;
                }
                printWriter.println(readStr);
                printWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("ResultReceiveIngThread线程结束");
        }
    }
}
