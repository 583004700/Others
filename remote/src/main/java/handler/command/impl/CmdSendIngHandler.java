package handler.command.impl;

import executor.OperatorExecutor;
import handler.command.OperatorCommandHandler;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class CmdSendIngHandler extends OperatorCommandHandler {
    private OperatorExecutor operatorExecutor;

    public CmdSendIngHandler(OperatorExecutor operatorExecutor,String otherKey, String completeCommand, PrintWriter printWriter,BufferedReader bufferedReader) {
        super(otherKey, completeCommand, printWriter);
        this.operatorExecutor = operatorExecutor;
    }

    @Override
    public Object handler() {
        getPrintWriter().println(getCompleteCommand());
        getPrintWriter().flush();
        
        operatorExecutor.getOperator().waitReading();

        return null;
    }


}

