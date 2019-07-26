package executor;

import handler.Handler;
import handler.command.impl.CmdSendIngHandler;
import handler.command.impl.DownFileHandler;
import handler.command.impl.UpFileHandler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class OperatorExecutor extends BaseExecutor{
    private PrintWriter printWriter;
    private static String otherKey;
    private BufferedReader bufferedReader;
    private static Set<String> ignoreKeys;

    public OperatorExecutor(String completeCommand, PrintWriter printWriter, BufferedReader bufferedReader) {
        super(completeCommand);
        this.printWriter = printWriter;
        this.bufferedReader = bufferedReader;
        ignoreKeys = new HashSet<String>();
        ignoreKeys.add(Handler.LIST);
        ignoreKeys.add(Handler.OPERATE);
    }

    public Handler getHandler(){
        Handler handler = null;
        String prefix = getPrefix();
        if(!ignoreKeys.contains(getPrefix()) && getOtherKey() == null){
            System.out.println("请先选择连接");
            return null;
        }
        if(Handler.CMD.equals(prefix) || Handler.JAVA.equals(prefix) || Handler.OPERATE.equals(prefix) || Handler.LIST.equals(prefix)){
            if(Handler.OPERATE.equals(getPrefix())){
                this.setOtherKey(getCommand());
            }
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
