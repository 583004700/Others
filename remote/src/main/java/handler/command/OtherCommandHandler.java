package handler.command;

import executor.BaseExecutor;
import handler.BaseHandler;

import java.io.PrintWriter;

public abstract class OtherCommandHandler extends BaseHandler {
    private Object[] param;
    //完整的命令
    private String completeCommand;
    //执行结果需要通知的printWrite
    private PrintWriter printWriter;

    public OtherCommandHandler(String completeCommand, PrintWriter printWriter) {
        this.completeCommand = completeCommand;
        this.printWriter = printWriter;
    }

    public String getCommand(){
        String completeCommand = getCompleteCommand();
        return BaseExecutor.getCommand(completeCommand);
    }

    public Object[] getParam() {
        return param;
    }

    public void setParam(Object[] param) {
        this.param = param;
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
