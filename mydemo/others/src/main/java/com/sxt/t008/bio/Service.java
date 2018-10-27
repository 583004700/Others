package com.sxt.t008.bio;

import java.net.ServerSocket;
import java.net.Socket;

public class Service {
    final static int PORT = 8765;
    public static void main(String[] args) throws Exception{
        ServerSocket server = null;
        server = new ServerSocket(PORT);
        while(true) {
            Socket socket = server.accept();
            new Thread(new ServerHandler(socket)).start();
        }
    }
}
