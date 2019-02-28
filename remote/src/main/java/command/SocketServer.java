package command;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class SocketServer {
    private static ConcurrentHashMap<String, Socket> beSockets = new ConcurrentHashMap<String, Socket>();

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8867);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                String inetAddressStr = socket.getInetAddress().toString();
                System.out.println(inetAddressStr);
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                String str = IOUtil.readLinStr(in, "UTF-8");
                System.out.println("SocketServer:"+str);
                if (str.split(";").length > 1) {
                    if ("op:start".equals(str.split(";")[0])) {
                        String ip = str.split(";")[1];
                        Socket beSocket = beSockets.get(ip);
                        SocketHandler socketHandler = new SocketHandler().setSocket(socket).setBeSocket(beSocket);
                        Thread t = new Thread(socketHandler);
                        t.start();
                    }
                } else {
                    System.out.println("添加"+str);
                    beSockets.put(str, socket);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
