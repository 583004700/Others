package command;

import executor.ServerExecutor;
import util.IOUtil;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class SocketServer {
    private static ConcurrentHashMap<String, Socket> registerSockets = new ConcurrentHashMap<String, Socket>();
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
                System.out.println("SocketServer:"+str);

                SocketServer socketServer = new SocketServer();
                socketServer.setSocket(socket);

                ServerExecutor serverExecutor = new ServerExecutor();
                serverExecutor.setCompleteCommand(str);
                serverExecutor.setSocketServer(socketServer);
                serverExecutor.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void registerSocket(String key,Socket value){
        registerSockets.put(key,value);
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
