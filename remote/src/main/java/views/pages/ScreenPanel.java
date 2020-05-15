package views.pages;

import command.entity.Operator;
import handler.Handler;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

public class ScreenPanel extends Operator {
    private boolean kz;

    private JLabel jlbImg;

    private String key;
    private ScreenFrame screenFrame;

    private InputStream tranInputStream;

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private Image image;
    private static final int MOD_MASK = MouseEvent.CTRL_MASK
            | MouseEvent.SHIFT_MASK | MouseEvent.ALT_MASK
            | MouseEvent.META_MASK | MouseEvent.ALT_GRAPH_MASK;
    private volatile boolean imageSize = true;

    public ScreenPanel(boolean kz,String key, ScreenFrame screenFrame) {
        this.kz = kz;
        this.screenFrame = screenFrame;
        this.setSize(screenFrame.getSize());
        this.jlbImg = new JLabel();
        this.key = key.intern();
        this.add(jlbImg);
        super.connect();
        setConnected(true);
        submitScrrentIn();

        if(!this.kz) {
            this.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if ((e.getModifiers() & MOD_MASK) == e.CTRL_MASK) {
                        ScreenPanel.this.imageSize = !ScreenPanel.this.imageSize;
                        ScreenPanel.this.x = 0;
                        ScreenPanel.this.y = 0;
                        ScreenPanel.this.repaint();
                    }
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
                            ScreenPanel.this.x += rightMove;
                            ScreenPanel.this.y += bottomMove;
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
        }else{
            imageSize = false;
            this.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    submitCommand(Handler.keyPress+Handler.separator+keyCode);
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    submitCommand(Handler.keyRelease+Handler.separator+keyCode);
                }
            });
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
        if(image != null) {
            g.clearRect(0, 0, this.getWidth(), this.getHeight());
            int imageWidth = image.getWidth(this);
            int imageHeight = image.getHeight(this);
            int panelWidth = this.getWidth();
            int panelHeight = this.getHeight();
            if(this.x > 0){
                this.x = 0;
            }
            if(this.y > 0){
                this.y = 0;
            }
            int width = 0;
            int height = 0;
            if(imageSize){
                width = imageWidth;
                height = imageHeight;
            }else{
                width = panelWidth;
                height = panelHeight;
            }
            if(this.x < panelWidth - width){
                this.x = panelWidth - width;
            }
            if(this.y < panelHeight - height){
                this.y = panelHeight - height;
            }
            g.drawImage(image, x, y,width , height, null);
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
