package command.entity;

import command.PropertiesConst;
import executor.OtherExecutor;
import handler.Handler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Date;

class TimeoutRunnable implements Runnable {
    private OtherComputer otherComputer;

    public TimeoutRunnable(OtherComputer otherComputer) {
        this.otherComputer = otherComputer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
                long currentTime = new Date().getTime();
                if (currentTime - otherComputer.getStartTime() >= otherComputer.getTimeOut()) {
                    otherComputer.getMessageSocket().getInputStream().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class OtherComputer extends Computer {
    private String server = PropertiesConst.server;
    private int port = PropertiesConst.port;

    private Socket messageSocket;
    private BufferedReader messageReader;
    private PrintWriter messageWriter;
    private static volatile long startTime;
    private static volatile long timeOut = 1000 * 60 * 30;

    public OtherComputer() {
        TimeoutRunnable timeoutRunnable = new TimeoutRunnable(this);
        ThreadManager.getExecutorService().execute(timeoutRunnable);
    }

    /**
     * 重置计时
     */
    public static void resetStartTime(){
        startTime = new Date().getTime();
    }


    public static void main(String[] args) {
        OtherComputer otherComputer = new OtherComputer();
        try {
            otherComputer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void connect() {
        while (messageSocket == null) {
            try {
                connectServer();
            } catch (ConnectException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void connectServer() throws Exception {
        messageSocket = new Socket(getServer(), getPort());
        messageReader = IOUtil.wrapBufferedReader(messageSocket.getInputStream(),PropertiesConst.appEncoding);
        messageWriter = IOUtil.wrapPrintWriter(messageSocket.getOutputStream(),PropertiesConst.appEncoding);
        String key = getKey();
        sendMessage(Handler.REGISTER +":"+key);
        System.out.println("连接成功");
    }

    public void message() {
        while (true) {
            String command = null;
            boolean success = true;
            try {
                System.out.println("command before");
                resetStartTime();
                command = messageReader.readLine();
                System.out.print("command after");
            } catch (IOException e) {
                success = false;
                e.printStackTrace();
            } finally {
                if (command == null || !success) {
                    System.out.println("closed");
                    start();
                } else {
                    OtherExecutor otherExecutor = new OtherExecutor(command, messageWriter, messageReader);
                    otherExecutor.setOtherKey(getKey());
                    otherExecutor.execute();
                }
            }
        }
    }



    public void start() {
        messageSocket = null;
        connect();
        message();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        try {
            System.out.print("message" + message);
            messageWriter.println(message);
            messageWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Socket getMessageSocket() {
        return messageSocket;
    }

    public void setMessageSocket(Socket messageSocket) {
        this.messageSocket = messageSocket;
    }

    public BufferedReader getMessageReader() {
        return messageReader;
    }

    public void setMessageReader(BufferedReader messageReader) {
        this.messageReader = messageReader;
    }

    public PrintWriter getMessageWriter() {
        return messageWriter;
    }

    public void setMessageWriter(PrintWriter messageWriter) {
        this.messageWriter = messageWriter;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public static void setTimeOut(long timeOut) {
        OtherComputer.timeOut = timeOut;
    }
}
