package executor;

import command.entity.OtherComputer;
import handler.Handler;
import handler.command.impl.*;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class OtherExecutor extends BaseExecutor implements Runnable{
    private PrintWriter printWriter;
    private String otherKey;
    private BufferedReader bufferedReader;
    public Handler handler;
    private OtherComputer otherComputer;

    public OtherExecutor(OtherComputer otherComputer, String completeCommand) {
        super(completeCommand);
        this.otherComputer = otherComputer;
        this.printWriter = otherComputer.getMessageWriter();
        this.bufferedReader = otherComputer.getMessageReader();
    }

    public Handler getHandler(){
        String prefix = getPrefix();
        if(Handler.CMD.equals(prefix)){
            handler = new OtherCmdHandler(getCompleteCommand(),printWriter);
        }else if(Handler.DOWNFILE.equals(prefix)){
            handler = new UpFileHandler(getCompleteCommand(),printWriter, otherKey);
        }else if(Handler.UPFILE.equals(prefix)){
            handler = new DownFileHandler(otherKey,getCompleteCommand(),printWriter);
        }else if(Handler.CMDBEGIN.equals(prefix)){
            handler = new CmdReceiveIngHandler(this,getCompleteCommand(),bufferedReader,printWriter);
        }else if(Handler.JAVA.equals(prefix)){
            handler = new JavaMethodHandler(getCompleteCommand(),printWriter);
        }
        return handler;
    }

    @Override
    public void run() {
        execute();
    }

    public void execute(){
        handler = getHandler();
        if(handler != null){
            handler.handler();
        }
    }

    public void cancel(){
        if(handler instanceof DownFileHandler){
            ((DownFileHandler)handler).cancel();
        }
    }

    public String getOtherKey() {
        return otherKey;
    }

    public void setOtherKey(String otherKey) {
        this.otherKey = otherKey;
    }

    public OtherComputer getOtherComputer() {
        return otherComputer;
    }

    public void setOtherComputer(OtherComputer otherComputer) {
        this.otherComputer = otherComputer;
    }
}
