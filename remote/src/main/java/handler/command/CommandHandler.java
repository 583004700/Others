package handler.command;

import handler.BaseHandler;

import java.io.PrintWriter;

public abstract class CommandHandler extends BaseHandler {
    private PrintWriter printWriter;

    public CommandHandler(String completeCommand, PrintWriter printWriter) {
        super(completeCommand);
        this.printWriter = printWriter;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }
}
