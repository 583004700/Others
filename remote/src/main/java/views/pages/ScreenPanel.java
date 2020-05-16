package views.pages;

import command.entity.Operator;
import handler.Handler;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

public class ScreenPanel extends Operator {
    private boolean kz;

    private JLabel jlbImg;

    private String key;
    private ScreenFrame screenFrame;

    private InputStream tranInputStream;

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private PrintWriter downSocketWrite;

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
                        @Override
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
            this.setFocusable(true);
            this.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    //submitCommand(Handler.keyPress+Handler.separator+keyCode);
                    sendMessage(Handler.keyPress+Handler.separator+keyCode);
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    //submitCommand(Handler.keyRelease+Handler.separator+keyCode);
                    sendMessage(Handler.keyRelease+Handler.separator+keyCode);
                }
            });
            this.addMouseListener(new MouseAdapter() {
                MouseMotionListener mouseMotionListener = null;
                @Override
                public void mousePressed(MouseEvent e) {
                    int button = e.getButton();
                    //submitCommand(Handler.mousePress+Handler.separator+button);
                    sendMessage(Handler.mousePress+Handler.separator+button);
                    mouseMotionListener = new MouseMotionAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            if(ScreenPanel.this.image != null) {
                                int x = e.getX();
                                int y = e.getY();
                                int imageWidth = ScreenPanel.this.getWidth();
                                int imageHeight = ScreenPanel.this.getHeight();
                                BigDecimal decimal1 = new BigDecimal(x);
                                BigDecimal decimal2 = new BigDecimal(imageWidth);
                                BigDecimal decimal3 = new BigDecimal(y);
                                BigDecimal decimal4 = new BigDecimal(imageHeight);
                                double leftBfb = decimal1.divide(decimal2, 20, RoundingMode.HALF_DOWN).doubleValue();
                                double bottomBfb = decimal3.divide(decimal4, 20,RoundingMode.HALF_DOWN).doubleValue();
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e1) {
                                    e1.printStackTrace();
                                }
                                //submitCommand(Handler.mouseMove + Handler.separator + leftBfb + "," + bottomBfb);
                                sendMessage(Handler.mouseMove + Handler.separator + leftBfb + "," + bottomBfb);
                            }
                        }
                    };
                    ScreenPanel.this.addMouseMotionListener(mouseMotionListener);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    ScreenPanel.this.removeMouseMotionListener(mouseMotionListener);
                    int button = e.getButton();
                    //submitCommand(Handler.mouseRelease+Handler.separator+button);
                    sendMessage(Handler.mouseRelease+Handler.separator+button);
                }
            });

            this.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    if(ScreenPanel.this.image != null) {
                        int x = e.getX();
                        int y = e.getY();
                        int imageWidth = ScreenPanel.this.getWidth();
                        int imageHeight = ScreenPanel.this.getHeight();
                        BigDecimal decimal1 = new BigDecimal(x);
                        BigDecimal decimal2 = new BigDecimal(imageWidth);
                        BigDecimal decimal3 = new BigDecimal(y);
                        BigDecimal decimal4 = new BigDecimal(imageHeight);
                        double leftBfb = decimal1.divide(decimal2, 100, RoundingMode.HALF_DOWN).doubleValue();
                        double bottomBfb = decimal3.divide(decimal4, 100,RoundingMode.HALF_DOWN).doubleValue();
//                        try {
//                            Thread.sleep(10);
//                        } catch (InterruptedException e1) {
//                            e1.printStackTrace();
//                        }
                        //submitCommand(Handler.mouseMove + Handler.separator + leftBfb + "," + bottomBfb);
                        sendMessage(Handler.mouseMove + Handler.separator + leftBfb + "," + bottomBfb);
                    }
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
        this.downSocketWrite = downSocketWrite;
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
