package command.entity;

import executor.OtherExecutor;
import handler.Handler;
import thread.ThreadManager;

import javax.imageio.ImageIO;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

public class OtherScreenComputer extends OtherComputer implements Runnable {

    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Rectangle rect = new Rectangle(screenSize);
    private Robot robot;

    public OtherScreenComputer() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printMessage(String message) {
        super.printMessage(message);
    }

    class WriteRunnable implements Runnable {
        @Override
        public void run() {
            try {
                OutputStream outputStream = OtherScreenComputer.this.getOutputStream();
                BufferedImage img = robot.createScreenCapture(rect);
                ImageIO.write(img, "png", outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void message() {
        while (true) {
            String command = null;
            boolean success = true;
            try {
                resetHeartTime();
                resetStartTime();
                command = getMessageReader().readLine();
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
                } else if (command.equals(Handler.HEART + Handler.separator)) {

                } else if (command.equals(Handler.SCREENIN + Handler.separator)) {
                    ThreadManager.getExecutorService().submit(new WriteRunnable());
                } else {
                    OtherExecutor otherExecutor = new OtherExecutor(this, command);
                    getOtherExecutors().add(otherExecutor);
                    otherExecutor.setOtherKey(getKey());
                    if ((Handler.CMDBEGIN + Handler.separator).equals(command)) {
                        System.out.println("OtherComputer:执行cmdbegin");
                        otherExecutor.execute();
                    } else {
                        ThreadManager.getExecutorService().execute(otherExecutor);
                    }
                }
            }
        }
    }
}


