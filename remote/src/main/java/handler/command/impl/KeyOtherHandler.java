package handler.command.impl;

import executor.BaseExecutor;
import handler.Handler;
import handler.command.OtherCommandHandler;
import thread.ThreadManager;

import java.awt.*;
import java.awt.event.KeyEvent;

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

    @Override
    public void run() {
        String prefix = getPrefix();
        String command = getCommand();
        int k = Integer.parseInt(command);
        if(Handler.keyPress.equals(prefix)){
            rebot.keyPress(k);
        }else if(Handler.keyRelease.equals(prefix)){
            rebot.keyRelease(k);
        }
    }

    @Override
    public Object handler() {
        ThreadManager.getExecutorService().execute(this);
        return null;
    }
}
