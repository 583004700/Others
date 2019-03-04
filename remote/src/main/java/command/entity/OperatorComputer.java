package command.entity;

import command.PropertiesConst;
import executor.OperatorExecutor;
import handler.Handler;
import thread.ThreadManager;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class OperatorComputer extends Computer implements Runnable{
    static Socket socket;
    static InputStream inputStream;
    static OutputStream outputStream;
    public static void main(String[] args) {
        //String key = "AdministratorPC-20181117FCPZ";  //邓声根
        String key = "zhuwbDESKTOP-DQ7BJCL"; //公司电脑
        //copy startremote.bat "%appdata%/Microsoft/Windows/Start Menu/Programs/Startup/"
        //copy "remote-1.0-SNAPSHOT.jar" "%appdata%/Microsoft/Windows/Start Menu/Programs/Startup/"
        //String key = "zhuwbDESKTOP-IHHLP8T";
        try {
            socket = new Socket(PropertiesConst.server,PropertiesConst.port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(outputStream));
            System.out.println(socket.getInetAddress().toString());
            pw.println(Handler.OPERATE+":"+key);
            pw.flush();

            ThreadManager.getExecutorService().execute(new OperatorComputer());
            while(true){
                Scanner scanner = new Scanner(System.in);
                scanner.useDelimiter("\n");
                String input = scanner.next();
                OperatorExecutor operatorExecutor = new OperatorExecutor(input,pw,key);
                operatorExecutor.execute();
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
            }catch (SocketTimeoutException s){
                result = "";
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(result == null){
                break;
            }
        }
    }
}
