package handler.command.impl;

import executor.BaseExecutor;
import handler.Handler;
import handler.command.OtherCommandHandler;
import thread.ThreadManager;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;

public class KeyOtherHandler extends OtherCommandHandler implements Runnable{
    
    private static Robot rebot = null;

    static {
        try {
            rebot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public KeyOtherHandler(String completeCommand, BaseExecutor executor){
        super(completeCommand,executor);
    }

    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screensize.getWidth();
    int height = (int)screensize.getHeight();

    @Override
    public void run() {
        synchronized (rebot) {
            String prefix = getPrefix();
            String command = getCommand();
            if (Handler.keyPress.equals(prefix)) {
                int k = Integer.parseInt(command);
                rebot.keyPress(k);
            } else if (Handler.keyRelease.equals(prefix)) {
                int k = Integer.parseInt(command);
                rebot.keyRelease(k);
            }else if(Handler.mousePress.equals(prefix)){
                int k = getCode(Integer.parseInt(command));
                rebot.mousePress(k);
            }else if(Handler.mouseRelease.equals(prefix)){
                int k = getCode(Integer.parseInt(command));
                rebot.mouseRelease(k);
            }else if(Handler.mouseWheelMove.equals(prefix)){

            }else if(Handler.mouseMove.equals(prefix)){
                String [] xy = command.split(",");
                double x = Double.parseDouble(xy[0]);
                double y = Double.parseDouble(xy[1]);
                int xx = (int)(width * x);
                int yy = (int)(height * y);
                rebot.mouseMove(xx,yy);
            }
        }
    }

    public int getCode(int code){
        if(code == 1) {
            return InputEvent.BUTTON1_MASK;
        }else if(code == 2){
            return InputEvent.BUTTON2_MASK;
        }else if(code == 3){
            return InputEvent.BUTTON3_MASK;
        }else{
            return 1;
        }
    }

    @Override
    public Object handler() {
        ThreadManager.getExecutorService().execute(this);
        return null;
    }
}
