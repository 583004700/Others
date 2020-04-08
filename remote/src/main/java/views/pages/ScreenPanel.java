package views.pages;

import command.PropertiesConst;
import command.entity.Operator;
import handler.Handler;
import thread.ThreadManager;
import util.IOUtil;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ScreenPanel extends Operator implements Runnable {

    private JLabel jlbImg;

    private String key;
    private ScreenFrame screenFrame;

    private InputStream tranInputStream;

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private volatile boolean transportationed;

    private volatile boolean started;

    public ScreenPanel(String key, ScreenFrame screenFrame) {
        this.jlbImg = new JLabel();
        this.key = key.intern();
        this.add(jlbImg);
        this.screenFrame = screenFrame;
        this.setSize(screenSize.width, screenSize.height);
        runWhile();
    }

    public void connect() {
        super.connect();
        try {
            ThreadManager.getExecutorService().execute(this);
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submitScrrentIn() {
        submitCommand(Handler.OPERATE + Handler.separator + this.key + "SC:");
        String uuid = UUID.randomUUID().toString();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        screenIn(this, Handler.SCREENIN + Handler.separator + uuid + ">" + uuid);
    }

    public void setImage(InputStream inputStream,PrintWriter downSocketWrite) {
        this.screenFrame.setTitle("已连接：" + this.key + "   正在获取屏幕...");
        this.tranInputStream = inputStream;
        try {
            byte[] b = new byte[1024];
            int len = 0;
            byte[] l = new byte[4];

            while (true) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                //数据原始长度
                //System.out.println("将读取dataLength");
                int d = inputStream.read(l);
                int dataLength = d < 4 ? 0 : BitUtils.bytesToInt(l, 0);
                //System.out.println("已读取dataLength："+dataLength);
                if (dataLength <= 0) {
                    System.out.println("读取dataLength失败");
                    break;
                }
                //已经读取的长度
                int readLength = 0;
                while (dataLength > readLength && (len = inputStream.read(b)) != -1) {
                    byteArrayOutputStream.write(b, 0, len);
                    readLength += len;
                    //System.out.println("readLength:"+readLength);
                }
                ThreadManager.getExecutorService().submit(new SetImageThread(jlbImg).setByteArrayOutputStream(byteArrayOutputStream));
                downSocketWrite.println("f");
                downSocketWrite.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.screenFrame.setTitle("未连接");
            stop();
            System.out.println("setImage方法退出");
        }
    }

    @Override
    public void init() {
        started = true;
    }

    public void reConnection() {
        closeConnection();
        connect();
    }

    public void reSelect() {
        submitScrrentIn();
    }

    @Override
    public void run() {
        runMessage();
    }

    public void runWhile() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (ScreenPanel.this.started) {
                    try {
                        if (!getTransportationed()) {
                            setTransportationed(true);
                            if(!getConnected()) {
                                reConnection();
                                Thread.sleep(5000);
                            }
                            reSelect();
                        }
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        ThreadManager.getExecutorService().submit(r1);
    }

    public void runMessage() {
        BufferedReader br = null;
        br = IOUtil.wrapBufferedReader(getInputStream(), PropertiesConst.appEncoding);
        while (started) {
            String result = null;
            try {
                result = br.readLine();
                System.out.println("result:" + result);
                if (result != null) {
                    if (result.contains("已连接:")) {
                        this.setConnected(true);
                        System.out.println("已连接到服务器");
                    } else if (result.contains("选择连接失败")) {
                        setTransportationed(false);
                    }
                }
            } catch (SocketTimeoutException s) {
                result = "";
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (result == null) {
                setTransportationed(false);
                this.setConnected(false);
                break;
            }
        }
    }

    public void stop() {
        try {
            setTransportationed(false);
            if (tranInputStream != null) {
                this.tranInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exitT() {
        started = false;
        stop();
    }

    public JLabel getJlbImg() {
        return jlbImg;
    }

    public void setJlbImg(JLabel jlbImg) {
        this.jlbImg = jlbImg;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ScreenFrame getScreenFrame() {
        return screenFrame;
    }

    public void setScreenFrame(ScreenFrame screenFrame) {
        this.screenFrame = screenFrame;
    }

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(Dimension screenSize) {
        ScreenPanel.screenSize = screenSize;
    }

    public boolean getTransportationed() {
        return transportationed;
    }

    public void setTransportationed(boolean transportationed) {
        this.transportationed = transportationed;
    }

    public String getKey() {
        return key;
    }
}
