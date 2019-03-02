package executor;

import handler.Handler;
import handler.command.impl.OtherCmdHandler;

import java.io.PrintWriter;

public class OtherExecutor extends BaseExecutor{
    private String completeCommand;
    private PrintWriter printWriter;

    public OtherExecutor(String completeCommand, PrintWriter printWriter) {
        this.completeCommand = completeCommand;
        this.printWriter = printWriter;
    }

    public Handler getHandler(){
        Handler handler = null;
        String prefix = getPrefix(completeCommand);
        if(Handler.CMD.equals(prefix)){
            handler = new OtherCmdHandler(completeCommand,printWriter);
        }
        return handler;
    }

    public void execute(){
        Handler handler = getHandler();
        if(handler != null){
            handler.handler();
        }
    }
}
