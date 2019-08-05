package handler.command;

import executor.BaseExecutor;

import java.io.PrintWriter;

public abstract class OperatorCommandHandler extends CommandHandler {
    private String otherKey;

    public OperatorCommandHandler(String otherKey, String completeCommand, BaseExecutor executor) {
        super(completeCommand,executor);
        this.otherKey = otherKey;
    }

    public String getOtherKey() {
        return otherKey;
    }

    public void setOtherKey(String otherKey) {
        this.otherKey = otherKey;
    }
}
