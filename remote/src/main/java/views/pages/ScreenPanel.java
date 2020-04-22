package views.pages;

import command.entity.Operator;
import handler.Handler;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.ByteArrayInputStream;
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

    private Image image;

    public ScreenPanel(String key, ScreenFrame screenFrame) {
        this.screenFrame = screenFrame;
        this.setSize(screenFrame.getSize());
        this.jlbImg = new JLabel();
        this.key = key.intern();
        this.add(jlbImg);
        super.connect();
        setConnected(true);
        submitScrrentIn();

        this.addMouseListener(new MouseListener() {


            @Override
            public void mouseClicked(MouseEvent e) {

            }

            MouseMotionListener mouseMotionListener = null;

            @Override
            public void mousePressed(final MouseEvent e1) {
                mouseMotionListener = new MouseMotionAdapter() {
                    int oldX = e1.getX();
                    int oldY = e1.getY();
                    public void mouseDragged(MouseEvent e) {
                        int rightMove = e.getX() - oldX;
                        int bottomMove = e.getY() - oldY;
                        ScreenPanel.this.x+=rightMove;
                        ScreenPanel.this.y+=bottomMove;
                        ScreenPanel.this.repaint();
                        oldX = e.getX();
                        oldY = e.getY();
                    }
                };
                ScreenPanel.this.addMouseMotionListener(mouseMotionListener);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                ScreenPanel.this.removeMouseMotionListener(mouseMotionListener);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
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
                //ThreadManager.getExecutorService().submit(new SetImageThread(this,jlbImg).setByteArrayOutputStream(byteArrayOutputStream));
                image = ImageIO.read(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                this.repaint();
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

    private volatile int x = 0;
    private volatile int y = 0;

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, this.getWidth(),this.getHeight());
        g.drawImage(image, x, y, image.getWidth(this),image.getHeight(this), null);
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
