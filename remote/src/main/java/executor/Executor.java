package executor;

import handler.Handler;
import handler.impl.CmdHandler;

import java.io.PrintWriter;

public class Executor extends BaseExecutor{
    private String completeCommand;
    private PrintWriter printWriter;

    public Executor(String completeCommand, PrintWriter printWriter) {
        this.completeCommand = completeCommand;
        this.printWriter = printWriter;
    }

    public Handler getHandler(){
        Handler handler = null;
        String prefix = getPrefix(completeCommand);
        if(Handler.CMD.equals(prefix)){
            handler = new CmdHandler(new Object[]{completeCommand,printWriter});
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
