package views.pages;

import command.entity.Operator;
import handler.Handler;
import thread.ThreadManager;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

public class ScreenPanel extends Operator {

    private JLabel jlbImg;

    private String key;
    private ScreenFrame screenFrame;

    private InputStream tranInputStream;

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public ScreenPanel(String key, ScreenFrame screenFrame) {
        this.jlbImg = new ScreeningImageLabel();
        this.key = key.intern();
        this.add(jlbImg);
        this.screenFrame = screenFrame;
        this.setSize(screenSize.width, screenSize.height);

        super.connect();
        setConnected(true);
        submitScrrentIn();
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

    public void stop() {
        try {
            if (tranInputStream != null) {
                this.tranInputStream.close();
            }
            closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exitT() {
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

    public String getKey() {
        return key;
    }
}
