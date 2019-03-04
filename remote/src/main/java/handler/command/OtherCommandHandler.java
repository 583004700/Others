package handler.command;

import java.io.PrintWriter;

public abstract class OtherCommandHandler extends CommandHandler {
    private Object[] param;

    public OtherCommandHandler(String completeCommand, PrintWriter printWriter) {
        super(completeCommand,printWriter);
    }

    public Object[] getParam() {
        return param;
    }

    public void setParam(Object[] param) {
        this.param = param;
    }

}
