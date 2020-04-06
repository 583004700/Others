package util;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class NetUtil {
    public static boolean isConnection(String server, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(server, port));
        } catch (IOException e) {
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
