package command.entity;

import command.PropertiesConst;
import executor.OperatorExecutor;
import handler.Handler;
import handler.resultHandler.ScreenPrintUpHandler;
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
    static PrintWriter pw;
    static BufferedReader bufferedReader;
    public static void main(String[] args) {
        String key = null;
        try {
            socket = new Socket();
            //socket.bind(new InetSocketAddress(PropertiesConst.otherPort));//绑定本地端口
            socket.connect(new InetSocketAddress(PropertiesConst.server,PropertiesConst.port));//绑定服务器端口
            System.out.println("连接服务器成功!!!\nlist:连接列表\noperate:key 选择连接");
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            bufferedReader = IOUtil.wrapBufferedReader(inputStream,PropertiesConst.appEncoding);
            pw = IOUtil.wrapPrintWriter(outputStream,PropertiesConst.appEncoding);

            ThreadManager.getExecutorService().execute(new OperatorComputer());
            Thread.sleep(100);

            submitCommand(Handler.LIST+":");

            while(true){
                Scanner scanner = new Scanner(System.in,PropertiesConst.consoleEncoding);
                scanner.useDelimiter("\n");
                String readStr = scanner.next();
                submitCommand(readStr);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void submitCommand(String completeCommand){
        OperatorExecutor operatorExecutor = new OperatorExecutor(completeCommand,pw,bufferedReader);
        if((Handler.CMDBEGIN+Handler.separator).equals(completeCommand)){
            operatorExecutor.execute();
        }else {
            ThreadManager.getExecutorService().execute(operatorExecutor);
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
                //如果是screenPrintUp方法，还需要上传图片到本机，如果业务多的话要
                if(result!=null && result.contains("screenPrintUp")){
                    ScreenPrintUpHandler printUpHandler = new ScreenPrintUpHandler(result).setPw(pw);
                    ThreadManager.getExecutorService().execute(printUpHandler);
                }
            }catch (SocketTimeoutException s){
                result = "";
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(result == null){
                System.out.println("连接已退出");
                break;
            }
        }
    }
}
