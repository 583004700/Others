package command;

import executor.ServerExecutor;
import util.IOUtil;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class SocketServer {
    private static ConcurrentHashMap<String, Socket> registerSockets = new ConcurrentHashMap<String, Socket>();
    private static ConcurrentHashMap<String, Socket> filesSockets = new ConcurrentHashMap<String, Socket>();
    private Socket socket;

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8867);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                String inetAddressStr = socket.getInetAddress().toString();
                System.out.println(inetAddressStr);
                InputStream in = socket.getInputStream();
                String str = IOUtil.readLinStr(in, "UTF-8");
                if(str == null){
                    System.out.println("null");
                }else {
                    System.out.println("SocketServer:" + str);

                    SocketServer socketServer = new SocketServer();
                    socketServer.setSocket(socket);

                    ServerExecutor serverExecutor = new ServerExecutor();
                    serverExecutor.setCompleteCommand(str);
                    serverExecutor.setSocketServer(socketServer);
                    serverExecutor.execute();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void registerSocket(String key,Socket value){
        registerSockets.put(key,value);
    }

    public Socket getFileSocket(String key){
        return filesSockets.get(key);
    }

    public void addFileSocket(String key,Socket value){
        filesSockets.put(key,value);
    }

    public void removeFileSocket(String key){
        filesSockets.remove(key);
    }

    public Socket getRegisterSocket(String key){
        return registerSockets.get(key);
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
