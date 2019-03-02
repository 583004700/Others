package handler;

import executor.BaseExecutor;

import java.io.PrintWriter;

public abstract class CommandHandler extends BaseHandler{
    private Object[] param;
    //完整的命令
    private String completeCommand;
    //执行结果需要通知的printWrite
    private PrintWriter printWriter;
    public CommandHandler(Object... param){
        this.param = param;
        this.completeCommand = (String)param[0];
        this.printWriter = (PrintWriter)param[1];
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
