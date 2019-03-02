package handler.command.impl;

import util.CmdUtil;
import handler.command.OtherCommandHandler;
import thread.ThreadManager;

import java.io.PrintWriter;

/**
 * cmd命令处理
 */
public class OtherCmdHandler extends OtherCommandHandler implements Runnable{

    public OtherCmdHandler(String completeCommand, PrintWriter printWriter){
        super(completeCommand,printWriter);
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
        String after = "CMD命令执行完毕："+command+"\n";
        //因为执行时是多线程，但打印时保持执行结果为一个整体。
        pw.println(before+result+after);
        pw.flush();
    }

}
