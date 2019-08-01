package handler.command.impl;

import handler.Handler;
import handler.command.OperatorCommandHandler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class CmdSendIngHandler extends OperatorCommandHandler {

    public CmdSendIngHandler(String otherKey, String completeCommand, PrintWriter printWriter,BufferedReader bufferedReader) {
        super(otherKey, completeCommand, printWriter);

    }

    @Override
    public Object handler() {
        getPrintWriter().println(getCompleteCommand());
        getPrintWriter().flush();
        String readStr = "";
        while(true){
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            readStr = scanner.next();
            getPrintWriter().println(readStr);
            getPrintWriter().flush();
            //先告诉对方关闭cmd控制台再退出
            if(Handler.CMDEND.equals(readStr)){
                break;
            }
        }
        System.out.println("cmd命令已退出");
        return null;
    }
}

