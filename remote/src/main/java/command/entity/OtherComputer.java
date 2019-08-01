package command.entity;

import command.PropertiesConst;
import executor.OtherExecutor;
import handler.Handler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class OtherComputer extends Computer {
    /**
     * 检测心跳和长时间没操作的线程
     */
    class TimeoutRunnable implements Runnable {
        OtherComputer otherComputer = OtherComputer.this;
        @Override
        public void run() {
            try {
                long currentTime = System.currentTimeMillis();
                if (currentTime - otherComputer.getStartTime() >= otherComputer.getTimeOut()
                        || currentTime - otherComputer.getHeartTime() >= otherComputer.getHeartTimeOut() + 5) {
                    otherComputer.getMessageSocket().getInputStream().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    {
        TimeoutRunnable timeoutRunnable = new TimeoutRunnable();
        ThreadManager.getScheduledExecutorService().scheduleWithFixedDelay(timeoutRunnable,30,30, TimeUnit.SECONDS);
    }

    private String key = getKey();
    private String server = PropertiesConst.server;
    private int port = PropertiesConst.port;

    private Socket messageSocket;
    private BufferedReader messageReader;
    private PrintWriter messageWriter;
    private volatile long startTime = System.currentTimeMillis();
    private volatile long timeOut = PropertiesConst.timeOut;

    private volatile long heartTime = System.currentTimeMillis();
    private volatile long heartTimeOut = PropertiesConst.heartTimeOut;

    private Set<OtherExecutor> otherExecutors = Collections.newSetFromMap(new ConcurrentHashMap<OtherExecutor, Boolean>());
    /**
     * 重置计时
     */
    public void resetStartTime(){
        startTime = System.currentTimeMillis();
    }

    public void resetHeartTime(){
        heartTime = System.currentTimeMillis();
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
        messageSocket = new Socket();
        //messageSocket.bind(new InetSocketAddress(PropertiesConst.operatorPort));//绑定本地端口
        messageSocket.connect(new InetSocketAddress(getServer(), getPort()));//绑定服务器端口
        messageReader = IOUtil.wrapBufferedReader(messageSocket.getInputStream(),PropertiesConst.appEncoding);
        messageWriter = IOUtil.wrapPrintWriter(messageSocket.getOutputStream(),PropertiesConst.appEncoding);
        sendMessage(Handler.REGISTER +":"+key);
        System.out.println("连接成功");
    }


    public void message() {
        while (true) {
            String command = null;
            boolean success = true;
            try {
                resetHeartTime();
                resetStartTime();
                command = messageReader.readLine();
            } catch (IOException e) {
                success = false;
                e.printStackTrace();
            } finally {
                if (command == null || !success) {
                    System.out.println("closed");
                    try {
                        cancelOtherExecutors();
                        Thread.sleep(10000);
                        start();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if(command.equals(Handler.HEART+Handler.separator)){

                } else{
                    OtherExecutor otherExecutor = new OtherExecutor(this,command);
                    otherExecutors.add(otherExecutor);
                    otherExecutor.setOtherKey(key);
                    if((Handler.CMDBEGIN+Handler.separator).equals(command)) {
                        System.out.println("OtherComputer:执行cmdbegin");
                        otherExecutor.execute();
                    }else{
                        ThreadManager.getExecutorService().execute(otherExecutor);
                    }
                }
            }
        }
    }

    public void cancelOtherExecutors(){
        for(OtherExecutor o : otherExecutors){
            o.cancel();
            otherExecutors.remove(o);
            System.out.println("取消："+o.getCompleteCommand());
        }
    }

    public void start() {
        messageSocket = null;
        connect();
        message();
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

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public long getHeartTime() {
        return heartTime;
    }

    public void setHeartTime(long heartTime) {
        this.heartTime = heartTime;
    }

    public long getHeartTimeOut() {
        return heartTimeOut;
    }

    public void setHeartTimeOut(long heartTimeOut) {
        this.heartTimeOut = heartTimeOut;
    }
}


