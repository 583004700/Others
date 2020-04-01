package executor;

import command.PropertiesConst;
import command.SocketServer;
import handler.Handler;
import handler.connection.impl.FileHandler;
import handler.connection.impl.ListHandler;
import handler.connection.impl.OperateHandler;
import util.IOUtil;

import java.io.PrintWriter;

public class ServerExecutor extends BaseExecutor implements Runnable{
    private SocketServer socketServer;
    private String otherKey = "";
    private PrintWriter operatorPrintWriter;
    private String fileKey;

    public ServerExecutor(String completeCommand, SocketServer socketServer) {
        super(completeCommand,null);
        this.socketServer = socketServer;
        try {
            this.operatorPrintWriter = IOUtil.wrapPrintWriter(socketServer.getSocket().getOutputStream(), PropertiesConst.appEncoding);
        }catch (Exception e){
            e.printStackTrace();
        }
        fileKey = getCompleteCommand().intern();
    }

    @Override
    public void run() {
        //System.out.println(Thread.currentThread()+"ServerExecutor执行开始:"+this.getCompleteCommand());
        execute();
        //System.out.println(Thread.currentThread()+"ServerExecutor执行结束:"+this.getCompleteCommand());
    }

    public Handler getHandler(){
        Handler handler = null;
        String prefix = getPrefix();
        otherKey = getCommand();
        if(Handler.REGISTER.equals(prefix)){
            System.out.println("添加OtherComputer:"+getCommand());
            socketServer.registerSocket(otherKey, socketServer.getSocket());
        }else if(Handler.OPERATE.equals(prefix)){
            OperateHandler operateHandler = new OperateHandler(socketServer,getCompleteCommand()).setServerExecutor(this);
            operateHandler.handler();
        }else if(Handler.DOWNFILE.equals(prefix) || Handler.UPFILE.equals(prefix)){
            FileHandler fileHandler = (FileHandler) new FileHandler(socketServer,getCompleteCommand()).setOperatorSocket(socketServer.getSocket());
            fileHandler.setOtherKey(getCommand());
            fileHandler.handler();
        }else if(Handler.LIST.equals(prefix)){
            ListHandler listHandler = new ListHandler(socketServer,getCompleteCommand()).setServerExecutor(this);
            listHandler.handler();
        }
        return handler;
    }

    public void execute(){
        Handler handler = getHandler();
        if(handler != null){
            handler.handler();
        }
    }

    public SocketServer getSocketServer() {
        return socketServer;
    }

    public ServerExecutor setSocketServer(SocketServer socketServer) {
        this.socketServer = socketServer;
        return this;
    }

    public String getOtherKey() {
        return otherKey;
    }

    public ServerExecutor setOtherKey(String otherKey) {
        this.otherKey = otherKey;
        return this;
    }
}
