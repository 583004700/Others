package executor;

import command.SocketServer;
import handler.Handler;
import handler.connection.impl.MessageHandler;
import thread.ThreadManager;

import java.net.Socket;

public class ServerExecutor extends BaseExecutor {
    private String completeCommand;
    private SocketServer socketServer;
    private String otherKey = "";

    public Handler getHandler(){
        Handler handler = null;
        String prefix = getPrefix(completeCommand);
        String key = getCommand(completeCommand);
        if(Handler.REGISTER.equals(prefix)){
            System.out.println("添加"+getCompleteCommand());
            socketServer.registerSocket(key, socketServer.getSocket());
        }else if(Handler.OPERATE.equals(prefix)){
            Socket otherSocket = socketServer.getRegisterSocket(key);
            MessageHandler messageHandler = (MessageHandler) new MessageHandler(socketServer).setOperatorSocket(socketServer.getSocket()).setOtherSocket(otherSocket);
            messageHandler.setOtherKey(key);
            ThreadManager.getExecutorService().execute(messageHandler);
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
