package executor;

import command.SocketServer;
import handler.Handler;
import handler.connection.impl.FileHandler;
import handler.connection.impl.MessageHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.InputStream;
import java.net.Socket;

public class ServerExecutor extends BaseExecutor {
    private String completeCommand;
    private SocketServer socketServer;
    private String otherKey = "";

    public Handler getHandler(){
        Handler handler = null;
        String prefix = getPrefix(completeCommand);
        otherKey = getCommand(completeCommand);
        if(Handler.REGISTER.equals(prefix)){
            System.out.println("添加"+getCompleteCommand());
            socketServer.registerSocket(otherKey, socketServer.getSocket());
        }else if(Handler.OPERATE.equals(prefix)){
            Socket otherSocket = socketServer.getRegisterSocket(otherKey);
            MessageHandler messageHandler = (MessageHandler) new MessageHandler(socketServer).setOperatorSocket(socketServer.getSocket()).setOtherSocket(otherSocket);
            messageHandler.setOtherKey(otherKey);
            ThreadManager.getExecutorService().execute(messageHandler);
        }else if(Handler.DOWNFILE.equals(prefix)){
            String te = getCommand(getCompleteCommand());
            System.out.println("te:"+te);
            if(getCommand(getCompleteCommand()).contains(":other")){
                System.out.println("添加文件socket:"+getCompleteCommand());
                socketServer.addFileSocket(getCompleteCommand(),socketServer.getSocket());
            }else {
                FileHandler fileHandler = (FileHandler) new FileHandler(socketServer).setOperatorSocket(socketServer.getSocket());
                fileHandler.setOtherKey(getCommand(getCompleteCommand()));
                fileHandler.setCompleteCommand(getCompleteCommand());
                fileHandler.handler();
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

    public String getCompleteCommand() {
        return completeCommand;
    }

    public ServerExecutor setCompleteCommand(String completeCommand) {
        this.completeCommand = completeCommand;
        return this;
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
