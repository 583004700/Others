package command;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient implements Runnable{
    static Socket socket;
    static InputStream inputStream;
    static OutputStream outputStream;
    public static void main(String[] args) {
        try {
            socket = new Socket("127.0.0.1",8867);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(outputStream));
            pw.println("op:start;/127.0.0.1");
            pw.flush();

            new Thread(new SocketClient()).start();
            while(true){
                Scanner scanner = new Scanner(System.in);
                String input = scanner.next();
                pw.println(input);
                pw.flush();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while(true){
            String result = null;
            try {
                result = IOUtil.readLinStr(inputStream,"UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }
    }
}
