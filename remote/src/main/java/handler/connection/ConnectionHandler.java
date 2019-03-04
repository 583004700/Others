package handler.connection;

import command.SocketServer;
import handler.BaseHandler;

import java.net.Socket;

public abstract class ConnectionHandler extends BaseHandler {
    private SocketServer socketServer;
    private Socket operatorSocket;
    private Socket otherSocket;
    private String otherKey = "";

    public ConnectionHandler(SocketServer socketServer,String completeCommand){
        super(completeCommand);
        this.socketServer = socketServer;
    }

    public SocketServer getSocketServer() {
        return socketServer;
    }

    public ConnectionHandler setSocketServer(SocketServer socketServer) {
        this.socketServer = socketServer;
        return this;
    }

    public Socket getOperatorSocket() {
        return operatorSocket;
    }

    public ConnectionHandler setOperatorSocket(Socket operatorSocket) {
        this.operatorSocket = operatorSocket;
        return this;
    }

    public Socket getOtherSocket() {
        return otherSocket;
    }

    public ConnectionHandler setOtherSocket(Socket otherSocket) {
        this.otherSocket = otherSocket;
        return this;
    }

    public String getOtherKey() {
        return otherKey;
    }

    public ConnectionHandler setOtherKey(String otherKey) {
        this.otherKey = otherKey;
        return this;
    }
}
