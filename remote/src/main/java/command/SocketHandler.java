package command;

import java.io.IOException;
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
        socketHandler.handler();
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
        handler();
        System.out.println("SocketHandler线程结束");
    }

    public void handler() {
        System.out.println("SocketHandler");
        try {
            IOUtil.readStrToOutputStream(socket.getInputStream(),"UTF-8",beSocket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                beSocket.close();
                System.out.println("服务端线程关闭");
            } catch (IOException e) {
                e.printStackTrace();
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
