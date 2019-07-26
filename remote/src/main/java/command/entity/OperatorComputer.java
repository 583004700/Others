package command.entity;

import command.PropertiesConst;
import executor.OperatorExecutor;
import handler.Handler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
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

//C:\Users\pan\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup
//C:\ProgramData\Microsoft\Windows\Start Menu\Programs\Startup

public class OperatorComputer extends Computer implements Runnable{
    static Socket socket;
    static InputStream inputStream;
    static OutputStream outputStream;
    public static void main(String[] args) {
        String key = null;
        try {
            socket = new Socket();
            //socket.bind(new InetSocketAddress(PropertiesConst.otherPort));//绑定本地端口
            socket.connect(new InetSocketAddress(PropertiesConst.server,PropertiesConst.port));//绑定服务器端口
            System.out.println("连接服务器成功!!!\nlist:连接列表\noperate:key 选择连接");
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            BufferedReader bufferedReader = IOUtil.wrapBufferedReader(inputStream,PropertiesConst.appEncoding);
            PrintWriter pw = IOUtil.wrapPrintWriter(outputStream,PropertiesConst.appEncoding);

            ThreadManager.getExecutorService().execute(new OperatorComputer());
            Thread.sleep(100);
            pw.println(Handler.LIST+":");
            pw.flush();

            while(true){
                Scanner scanner = new Scanner(System.in,PropertiesConst.consoleEncoding);
                scanner.useDelimiter("\n");
                String readStr = scanner.next();
                OperatorExecutor operatorExecutor = new OperatorExecutor(readStr,pw,bufferedReader);
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
