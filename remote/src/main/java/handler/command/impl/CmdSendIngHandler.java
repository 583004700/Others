package handler.command.impl;

import executor.OperatorExecutor;
import handler.command.OperatorCommandHandler;

public class CmdSendIngHandler extends OperatorCommandHandler {
    private OperatorExecutor operatorExecutor;

    public CmdSendIngHandler(OperatorExecutor operatorExecutor, String otherKey, String completeCommand) {
        super(otherKey, completeCommand, operatorExecutor);
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

