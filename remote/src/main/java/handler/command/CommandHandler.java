package handler.command;

import executor.BaseExecutor;
import handler.BaseHandler;

import java.io.PrintWriter;

public abstract class CommandHandler extends BaseHandler {
    private BaseExecutor executor;
    private PrintWriter printWriter;

    public CommandHandler(String completeCommand, BaseExecutor executor) {
        super(completeCommand);
        if(executor != null) {
            this.executor = executor;
            this.printWriter = getExecutor().getComputer().getPrintWriter();
        }
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public BaseExecutor getExecutor() {
        return executor;
    }

    public void setExecutor(BaseExecutor executor) {
        this.executor = executor;
    }
}
