package executor;

import handler.Handler;
import handler.command.impl.DownFileHandler;
import handler.command.impl.OtherCmdHandler;
import handler.command.impl.UpFileHandler;

import java.io.PrintWriter;

public class OtherExecutor extends BaseExecutor{
    private PrintWriter printWriter;
    private String otherKey;

    public OtherExecutor(String completeCommand, PrintWriter printWriter) {
        super(completeCommand);
        this.printWriter = printWriter;
    }

    public Handler getHandler(){
        Handler handler = null;
        String prefix = getPrefix();
        if(Handler.CMD.equals(prefix)){
            handler = new OtherCmdHandler(getCompleteCommand(),printWriter);
        }else if(Handler.DOWNFILE.equals(prefix)){
            handler = new UpFileHandler(getCompleteCommand(),printWriter, otherKey);
        }else if(Handler.UPFILE.equals(prefix)){
            handler = new DownFileHandler(otherKey,getCompleteCommand(),printWriter);
        }
        return handler;
    }

    public void execute(){
        Handler handler = getHandler();
        if(handler != null){
            handler.handler();
        }
    }

    public String getOtherKey() {
        return otherKey;
    }

    public void setOtherKey(String otherKey) {
        this.otherKey = otherKey;
    }
}
