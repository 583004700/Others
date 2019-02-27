package command;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

class BeSocketHandler implements Runnable {
    private Socket socket;
    private Socket beSocket;

    public BeSocketHandler(Socket socket, Socket beSocket) {
        this.socket = socket;
        this.beSocket = beSocket;
    }

    public void run() {
        SocketHandler socketHandler = new SocketHandler().setSocket(beSocket).setBeSocket(socket);
        socketHandler.handler(false);
        System.out.println("BeSocketHandler线程结束");
    }
}


public class SocketHandler implements Runnable {
    private Socket socket;
    private Socket beSocket;
    Thread beSocketThread = null;

    public void run() {
        BeSocketHandler beSocketHandler = new BeSocketHandler(socket, beSocket);
        beSocketThread = new Thread(beSocketHandler);
        beSocketThread.setDaemon(true);
        beSocketThread.start();
        handler(true);
        System.out.println("SocketHandler线程结束");
    }

    public void handler(boolean b) {
        System.out.println("SocketHandler");
        while (true) {
            String command = null;
            boolean success = true;
            try {
//                if(b) {
//                    command = IOUtil.readLinStr(socket.getInputStream(), "UTF-8");
//                }else{
//                    command = IOUtil.readStr(socket.getInputStream(),"UTF-8");
//                }
//                System.out.print(command);
//                PrintWriter pw = new PrintWriter(new OutputStreamWriter(beSocket.getOutputStream()));
//                pw.println(command);
//                pw.flush();

                IOUtil.readStrToOutputStream(socket.getInputStream(),"UTF-8",beSocket.getOutputStream());

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
