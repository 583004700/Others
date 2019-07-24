package executor;

import command.PropertiesConst;
import command.SocketServer;
import handler.Handler;
import handler.connection.impl.FileHandler;
import handler.connection.impl.MessageHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.PrintWriter;
import java.net.Socket;

public class ServerExecutor extends BaseExecutor {
    private SocketServer socketServer;
    private String otherKey = "";
    private PrintWriter operatorPrintWriter;

    public ServerExecutor(String completeCommand, SocketServer socketServer) {
        super(completeCommand);
        this.socketServer = socketServer;
        try {
            this.operatorPrintWriter = IOUtil.wrapPrintWriter(socketServer.getSocket().getOutputStream(), PropertiesConst.appEncoding);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Handler getHandler(){
        Handler handler = null;
        String prefix = getPrefix();
        otherKey = getCommand();
        if(Handler.REGISTER.equals(prefix)){
            System.out.println("添加OtherComputer:"+getCommand());
            socketServer.registerSocket(otherKey, socketServer.getSocket());
        }else if(Handler.OPERATE.equals(prefix)){
            Socket otherSocket = socketServer.getRegisterSocket(otherKey);
            MessageHandler messageHandler = (MessageHandler) new MessageHandler(socketServer,getCompleteCommand()).setOperatorSocket(socketServer.getSocket()).setOtherSocket(otherSocket);
            messageHandler.setOtherKey(otherKey);
            ThreadManager.getExecutorService().execute(messageHandler);
            operatorPrintWriter.println("选择连接成功");
            operatorPrintWriter.flush();
        }else if(Handler.DOWNFILE.equals(prefix) || Handler.UPFILE.equals(prefix)){
            if(getCommand().contains(":"+Handler.UPFILE)){
                System.out.println("添加文件socket:"+getCompleteCommand());
                socketServer.addFileSocket(getCompleteCommand(),socketServer.getSocket());
            }else {
                FileHandler fileHandler = (FileHandler) new FileHandler(socketServer,getCompleteCommand()).setOperatorSocket(socketServer.getSocket());
                fileHandler.setOtherKey(getCommand());
                fileHandler.handler();
            }
        }else if(Handler.LIST.equals(prefix)){
            String list = socketServer.getRegisterSocketList();
            try {
                operatorPrintWriter.println(list);
                operatorPrintWriter.flush();
                String str = IOUtil.readLinStr(socketServer.getSocket().getInputStream(), PropertiesConst.appEncoding);
                this.setCompleteCommand(str);
                this.execute();
            }catch (Exception e){
                e.printStackTrace();
            }
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
