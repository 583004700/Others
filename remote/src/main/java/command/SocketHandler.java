package command;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketHandler implements Runnable {
    private Socket socket;
    private Socket beSocket;

    public void run() {
        System.out.println("handler");
        while (true) {
            String command = null;
            boolean success = true;
            try {
                command = IOUtil.readLinStr(socket.getInputStream(), "UTF-8");
                System.out.println(command);
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(beSocket.getOutputStream()));
                pw.println(command);
                pw.flush();

            } catch (Exception e) {
                try {
                    success = false;
                    beSocket.close();
                    System.out.println("服务端线程关闭");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            } finally {
                if (command == null || success == false) {
                    break;
                }
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public SocketHandler setSocket(Socket socket) {
        this.socket = socket;
        return this;
    }

    public Socket getBeSocket() {
        return beSocket;
    }

    public SocketHandler setBeSocket(Socket beSocket) {
        this.beSocket = beSocket;
        return this;
    }
}
