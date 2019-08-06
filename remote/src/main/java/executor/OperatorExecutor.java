package executor;

import command.entity.Operator;
import handler.Handler;
import handler.command.impl.CmdSendIngHandler;
import handler.command.impl.DownFileHandler;
import handler.command.impl.UpFileHandler;

import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class OperatorExecutor extends BaseExecutor implements Runnable{
    private Operator operator;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private static String otherKey;
    private static Set<String> ignoreKeys;

    public OperatorExecutor(Operator operator, String completeCommand) {
        super(completeCommand,operator);
        this.operator = operator;
        this.bufferedReader = operator.getBufferedReader();
        this.printWriter = operator.getPrintWriter();
        ignoreKeys = new HashSet<String>();
        ignoreKeys.add(Handler.LIST);
        ignoreKeys.add(Handler.OPERATE);
    }

    public Handler getHandler(){
        Handler handler = null;
        String prefix = getPrefix();
        if(!ignoreKeys.contains(getPrefix()) && getOtherKey() == null){
            getOperator().printMessage("请先选择连接");
            return null;
        }
        if(Handler.CMD.equals(prefix) || Handler.JAVA.equals(prefix) || Handler.OPERATE.equals(prefix) || Handler.LIST.equals(prefix)){
            if(Handler.OPERATE.equals(getPrefix())){
                this.setOtherKey(getCommand());
            }
            printWriter.println(getCompleteCommand());
            printWriter.flush();
        }else if(Handler.DOWNFILE.equals(prefix)){
            handler = new DownFileHandler(otherKey,getCompleteCommand(),this);
        }else if(Handler.UPFILE.equals(prefix)){
            handler = new UpFileHandler(getCompleteCommand(),this,getOtherKey());
        }else if(Handler.CMDBEGIN.equals(prefix)){
            handler = new CmdSendIngHandler(this,getOtherKey(),getCompleteCommand());
        }
        return handler;
    }

    @Override
    public void run() {
        execute();
    }

    public void execute(){
        Handler handler = getHandler();
        if(handler != null){
            handler.handler();
        }
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public static String getOtherKey() {
        return otherKey;
    }

    public static void setOtherKey(String otherKey) {
        OperatorExecutor.otherKey = otherKey;
    }

    public static Set<String> getIgnoreKeys() {
        return ignoreKeys;
    }

    public static void setIgnoreKeys(Set<String> ignoreKeys) {
        OperatorExecutor.ignoreKeys = ignoreKeys;
    }
}
