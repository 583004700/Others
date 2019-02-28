package command;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient implements Runnable{
    static Socket socket;
    static InputStream inputStream;
    static OutputStream outputStream;
    public static void main(String[] args) {
        //copy "d:\Documents\Tencent Files\810645125\FileRecv\remote-1.0-SNAPSHOT.jar" "%appdata%/Microsoft/Windows/Start Menu/Programs/Startup/"
        //copy "d:\Documents\Tencent Files\810645125\FileRecv\startremote.bat" "%appdata%/Microsoft/Windows/Start Menu/Programs/Startup/"
        //String key = "AdministratorPC-20181117FCPZ";
        String key = "zhuwbDESKTOP-IHHLP8T";
        try {
            socket = new Socket(PropertiesConst.server,PropertiesConst.port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(outputStream));
            System.out.println(socket.getInetAddress().toString());
            pw.println("op:start;"+key+";中文");
            pw.flush();

            new Thread(new SocketClient()).start();
            while(true){
                Scanner scanner = new Scanner(System.in);
                scanner.useDelimiter("\n");
                String input = scanner.next();
                pw.println(input);
                pw.flush();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        while(true){
            String result = null;
            try {
                result = br.readLine();
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(result == null){
                break;
            }
        }
    }
}
