package com.sxt.t008.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    final static String ADDRESS = "127.0.0.1";
    final static int PORT = 8765;
    public static void main(String[] args) throws Exception{
        Socket socket = null;
        socket = new Socket(ADDRESS,PORT);
        final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String response;
                try {
                    while ((response = in.readLine()) != null) {
                        System.out.println("来自服务器: " + response);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String response;
                try {
                    while ((response = in.readLine()) != null) {
                        out.println(response);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
