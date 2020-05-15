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
        super(completeCommand,otherComputer);
        this.otherComputer = otherComputer;
        this.printWriter = otherComputer.getMessageWriter();
        this.bufferedReader = otherComputer.getMessageReader();
    }

    public Handler getHandler(){
        String prefix = getPrefix();
        if(Handler.CMD.equals(prefix)){
            handler = new OtherCmdHandler(getCompleteCommand(),this);
        }else if(Handler.SCREENIN.equals(prefix)){
            handler = new UpFileHandler(getCompleteCommand(),this, otherKey,true);
        }else if(Handler.DOWNFILE.equals(prefix)){
            handler = new UpFileHandler(getCompleteCommand(),this, otherKey,false);
        }else if(Handler.UPFILE.equals(prefix)){
            handler = new DownFileHandler(otherKey,getCompleteCommand(),this,null);
        }else if(Handler.CMDBEGIN.equals(prefix)){
            handler = new CmdReceiveIngHandler(this,getCompleteCommand());
        }else if(Handler.JAVA.equals(prefix)){
            handler = new JavaMethodHandler(getCompleteCommand(),this);
        }else if(Handler.keyPress.equals(prefix)
                || Handler.keyRelease.equals(prefix) || Handler.mousePress.equals(prefix)
                || Handler.mouseRelease.equals(prefix) || Handler.mouseMove.equals(prefix)
                ||Handler.mouseWheelMove.equals(prefix)){
            handler = new KeyOtherHandler(getCompleteCommand(),this);
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
