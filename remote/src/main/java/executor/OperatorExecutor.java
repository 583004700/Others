package executor;

import handler.Handler;
import handler.command.impl.CmdSendIngHandler;
import handler.command.impl.DownFileHandler;
import handler.command.impl.UpFileHandler;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class OperatorExecutor extends BaseExecutor{
    private PrintWriter printWriter;
    private String otherKey;
    private BufferedReader bufferedReader;

    public OperatorExecutor(String completeCommand, PrintWriter printWriter, String otherKey, BufferedReader bufferedReader) {
        super(completeCommand);
        this.printWriter = printWriter;
        this.otherKey = otherKey;
        this.bufferedReader = bufferedReader;
    }

    public Handler getHandler(){
        Handler handler = null;
        String prefix = getPrefix();
        if(Handler.CMD.equals(prefix) || Handler.JAVA.equals(prefix)){
            printWriter.println(getCompleteCommand());
            printWriter.flush();
        }else if(Handler.DOWNFILE.equals(prefix)){
            handler = new DownFileHandler(otherKey,getCompleteCommand(),printWriter);
        }else if(Handler.UPFILE.equals(prefix)){
            handler = new UpFileHandler(getCompleteCommand(),printWriter,getOtherKey());
        }else if(Handler.CMDBEGIN.equals(prefix)){
            handler = new CmdSendIngHandler(getOtherKey(),getCompleteCommand(),printWriter,bufferedReader);
        }
        return handler;
    }

    public void execute(){
        Handler handler = getHandler();
        if(handler != null){
            handler.handler();
        }
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
