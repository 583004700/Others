package command;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class SocketServer {
    private static ConcurrentHashMap<String, Socket> beSockets = new ConcurrentHashMap<String, Socket>();
    private static ConcurrentHashMap<String, Socket> sockets = new ConcurrentHashMap<String, Socket>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8867);
            while(true) {
                Socket socket = serverSocket.accept();
                String inetAddressStr = socket.getInetAddress().toString();
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                if("op:start".equals(IOUtil.readLinStr(in,"UTF-8"))){
                    sockets.put(inetAddressStr,socket);
                }else {
                    beSockets.put(inetAddressStr, socket);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
