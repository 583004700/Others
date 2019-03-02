package handler.command;

import handler.BaseHandler;

import java.io.PrintWriter;

public abstract class OperatorCommandHandler extends BaseHandler {
    private String otherKey;
    private String completeCommand;
    //需要通知的printWrite
    private PrintWriter printWriter;

    public OperatorCommandHandler(String otherKey, String completeCommand, PrintWriter printWriter) {
        this.otherKey = otherKey;
        this.completeCommand = completeCommand;
        this.printWriter = printWriter;
    }

    public String getOtherKey() {
        return otherKey;
    }

    public void setOtherKey(String otherKey) {
        this.otherKey = otherKey;
    }

    public String getCompleteCommand() {
        return completeCommand;
    }

    public void setCompleteCommand(String completeCommand) {
        this.completeCommand = completeCommand;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }
}
