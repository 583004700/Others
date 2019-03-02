package executor;

import handler.Handler;
import handler.command.impl.OtherCmdHandler;
import handler.command.impl.OtherFileHandler;

import java.io.PrintWriter;

public class OtherExecutor extends BaseExecutor{
    private String completeCommand;
    private PrintWriter printWriter;
    private String key;

    public OtherExecutor(String completeCommand, PrintWriter printWriter) {
        this.completeCommand = completeCommand;
        this.printWriter = printWriter;
    }

    public Handler getHandler(){
        Handler handler = null;
        String prefix = getPrefix(completeCommand);
        if(Handler.CMD.equals(prefix)){
            handler = new OtherCmdHandler(completeCommand,printWriter);
        }else if(Handler.DOWNFILE.equals(prefix)){
            handler = new OtherFileHandler(completeCommand,printWriter,key);
        }
        return handler;
    }

    public void execute(){
        Handler handler = getHandler();
        if(handler != null){
            handler.handler();
        }
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
