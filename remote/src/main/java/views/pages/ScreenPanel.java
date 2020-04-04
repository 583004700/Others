package views.pages;

import command.PropertiesConst;
import command.entity.Operator;
import handler.Handler;
import thread.ThreadManager;
import util.IOUtil;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class ScreenPanel extends Operator implements Runnable {

    private JLabel jlbImg;

    private String key;
    private ScreenFrame screenFrame;

    private volatile boolean started;
    private int imgWidth;
    private int imgHeight;

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public ScreenPanel(String key, ScreenFrame screenFrame) {
        this.key = key;
        this.operateKey();
        this.screenFrame = screenFrame;
        this.add(jlbImg);
        this.setSize((int)(screenSize.width*0.8),(int)(screenSize.height*0.8));
        imgWidth = this.getWidth();
        imgHeight = this.getHeight()-32;
    }

    @Override
    public void init() {
        this.jlbImg = new JLabel();
        started = true;
    }

    public void reConnect() {
        closeConnection();
        connect();
        operateKey();
    }

    public void operateKey(){
        submitCommand(Handler.OPERATE + Handler.separator + this.key + "SC:");
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

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void stop(){
        started = false;
        closeConnection();
    }

    public void changeCurrentTabTitle(String title){
        this.screenFrame.setTitle(title);
    }

    public void run() {
        BufferedReader br = null;
        br = IOUtil.wrapBufferedReader(getInputStream(), PropertiesConst.appEncoding);
        String result = null;
        try {
            result = br.readLine();
            if (result.contains("已连接:")) {
                this.setConnected(true);
                this.setName(result);
                changeCurrentTabTitle(result);
            }else if("选择连接失败".equals(result)){
                result = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //while (started) {
            try {

                sendMessage(Handler.SCREENIN+Handler.separator);
                //File file = new File("d:/remotefile/2019081717340485.png");
                //InputStream inputStream = new FileInputStream(file);
                InputStream inputStream = getInputStream();
                byte[] b = new byte[1024];
                int length = inputStream.read(b);
                ImageIcon icon = new ImageIcon(b) ;//里面的参数为一个Byte数组
                icon.setImage(icon.getImage().getScaledInstance(this.imgWidth,this.imgHeight, Image.SCALE_DEFAULT));

                this.jlbImg.setIcon(icon);

            }/* catch (SocketTimeoutException s) {
                result = "";
            } */catch (Exception e) {
                e.printStackTrace();
            }
            if (result == null) {
                this.setConnected(false);
                this.setName("未连接");
                changeCurrentTabTitle("未连接");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reConnect();
                //break;
            }
        //}
    }
}
