package command.entity;

import command.PropertiesConst;
import executor.OperatorExecutor;
import handler.Handler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

/**
 * cmd常用命令
 * dir 展示目录
 * del d:a.txt 删除文件
 * msg %username% /time:10 "要显示的内容" 弹出窗口
 * shutdown /s 关机，有30秒提示
 * shutdown /s /t 300 300秒后
 * shutdown /s /t 300 /c "注释"
 */

//java:command.entity.JavaMethod.createFile()
//java:command.entity.JavaMethod.deleteFile()
public class OperatorComputer extends Computer implements Runnable{
    static Socket socket;
    static InputStream inputStream;
    static OutputStream outputStream;
    public static void main(String[] args) {
        //String key = "AdministratorPC-20181117FCPZ";  //邓声根
        //String key = "zhuwbDESKTOP-DQ7BJCL"; //公司电脑
        //String key = "zhuwbDESKTOP-IHHLP8T"; //自己电脑
        String key = System.getProperty("key");
        if(key == null || key.equals("")){
            key = "nullnullnull";
        }
        try {
            socket = new Socket(PropertiesConst.server,PropertiesConst.port);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            BufferedReader bufferedReader = IOUtil.wrapBufferedReader(inputStream,PropertiesConst.appEncoding);
            PrintWriter pw = IOUtil.wrapPrintWriter(outputStream,PropertiesConst.appEncoding);
            System.out.println(socket.getInetAddress().toString());
            pw.println(Handler.OPERATE+":"+key);
            pw.flush();

            ThreadManager.getExecutorService().execute(new OperatorComputer());
            while(true){
                Scanner scanner = new Scanner(System.in,PropertiesConst.consoleEncoding);
                scanner.useDelimiter("\n");
                String readStr = scanner.next();
                OperatorExecutor operatorExecutor = new OperatorExecutor(readStr,pw,key,bufferedReader);
                operatorExecutor.execute();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        BufferedReader br = null;
        br = IOUtil.wrapBufferedReader(inputStream,PropertiesConst.appEncoding);
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
