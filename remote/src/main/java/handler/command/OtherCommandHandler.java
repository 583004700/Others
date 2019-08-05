package handler.command;

import executor.BaseExecutor;

import java.io.PrintWriter;

public abstract class OtherCommandHandler extends CommandHandler {
    private Object[] param;

    public OtherCommandHandler(String completeCommand, BaseExecutor executor) {
        super(completeCommand,executor);
    }

    public Object[] getParam() {
        return param;
    }

    public void setParam(Object[] param) {
        this.param = param;
    }

}
