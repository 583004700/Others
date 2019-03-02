package executor;

import handler.Handler;
import handler.command.impl.OperatorFileHandler;

import java.io.PrintWriter;

public class OperatorExecutor extends BaseExecutor{
    private String completeCommand;
    private PrintWriter printWriter;
    private String otherKey;

    public OperatorExecutor(String completeCommand, PrintWriter printWriter,String otherKey) {
        this.completeCommand = completeCommand;
        this.printWriter = printWriter;
        this.otherKey = otherKey;
    }

    public Handler getHandler(){
        Handler handler = null;
        String prefix = getPrefix(completeCommand);
        if(Handler.CMD.equals(prefix)){
            printWriter.println(completeCommand);
            printWriter.flush();
        }else if(Handler.DOWNFILE.equals(prefix)){
            handler = new OperatorFileHandler(otherKey,completeCommand,printWriter);
        }
        return handler;
    }

    public void execute(){
        Handler handler = getHandler();
        if(handler != null){
            handler.handler();
        }
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

    public String getOtherKey() {
        return otherKey;
    }

    public void setOtherKey(String otherKey) {
        this.otherKey = otherKey;
    }
}
