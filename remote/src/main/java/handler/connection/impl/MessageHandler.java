package handler.connection.impl;

import command.PropertiesConst;
import command.SocketServer;
import handler.Handler;
import handler.connection.ConnectionHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.*;

class OtherMessageHandler extends ConnectionHandler implements Runnable{

    public OtherMessageHandler(SocketServer socketServer,String completeCommand) {
        super(socketServer,completeCommand);
    }

    @Override
    public void run() {
        handler();
        System.out.println(getOtherSocket()+":OtherMessageHandler线程结束");
    }

    @Override
    public Object handler() {
        try {
            OutputStream outputStream = getOperatorSocket().getOutputStream();
            InputStream inputStream = getOtherSocket().getInputStream();
            PrintWriter printWriter = IOUtil.wrapPrintWriter(outputStream, PropertiesConst.appEncoding);
            BufferedReader br = IOUtil.wrapBufferedReader(inputStream,PropertiesConst.appEncoding);
            String line = null;
            while((line = br.readLine()) != null){
                printWriter.println(line);
                printWriter.flush();
                System.out.println(outputStream.toString()+inputStream+":"+line);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                getOperatorSocket().close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}

public class MessageHandler extends ConnectionHandler implements Runnable{
    public MessageHandler(SocketServer socketServer,String completeCommand) {
        super(socketServer,completeCommand);
    }

    public void run() {
        OtherMessageHandler otherMessageHandler = (OtherMessageHandler)new OtherMessageHandler(getSocketServer(),getCompleteCommand()).setOperatorSocket(getOperatorSocket()).setOtherSocket(getOtherSocket());
        ThreadManager.getExecutorService().execute(otherMessageHandler);
        handler();
        System.out.println(getOtherKey()+":MessageHandler线程结束");
    }

    @Override
    public Object handler() {
        System.out.println(getOtherKey()+"MessageHandler");
        try {
            OutputStream outputStream = getOtherSocket().getOutputStream();
            InputStream inputStream = getOperatorSocket().getInputStream();
            BufferedReader br = IOUtil.wrapBufferedReader(inputStream,PropertiesConst.appEncoding);
            PrintWriter printWriter = IOUtil.wrapPrintWriter(outputStream, PropertiesConst.appEncoding);

            PrintWriter operatorPrintWriter = IOUtil.wrapPrintWriter(getOperatorSocket().getOutputStream(),PropertiesConst.appEncoding);

            String line = null;
            while((line = br.readLine()) != null){
                if(line.equals(Handler.LIST+Handler.separator)){
                    operatorPrintWriter.println(Handler.returnList+getSocketServer().getRegisterSocketList());
                    operatorPrintWriter.flush();
                    continue;
                }
                printWriter.println(line);
                printWriter.flush();
                System.out.println(outputStream.toString()+inputStream+":"+line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                getOtherSocket().close();
                System.out.println(getOtherKey()+"服务端线程关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
