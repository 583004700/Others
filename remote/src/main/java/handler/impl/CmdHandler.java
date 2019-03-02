package handler.impl;

import command.CmdUtil;
import handler.CommandHandler;
import thread.ThreadManager;

import java.io.PrintWriter;

/**
 * cmd命令处理
 */
public class CmdHandler extends CommandHandler implements Runnable{

    public CmdHandler(Object[] param){
        super(param);
    }

    @Override
    public Object handler() {
        ThreadManager.getExecutorService().execute(this);
        return null;
    }

    @Override
    public void run() {
        String command = getCommand();
        PrintWriter pw = getPrintWriter();
        String before = "CMD命令执行开始："+command+"\n";
        String result = CmdUtil.execCloseReturnStr(command.split("&"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String after = "CMD命令执行完毕："+command+"\n";
        //因为执行时是多线程，但打印时保持执行结果为一个整体。
        pw.println(before+result+after);
        pw.flush();
    }

}
