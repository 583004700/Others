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

//reg query HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run
//reg add HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Policies\Explorer\Run /v baidujingyan /t REG_SZ /d c:\windows\system32\notepad.exe /f
//reg delete HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run /v baidujingyan /f
//1、HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Run
//2、HKEY_LOCAL_MACHINE\Software\Microsoft\Windows\CurrentVersion\Run
//3、HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Policies\Explorer\Run
//4、HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows\CurrentVersion\Policies\Explorer\Run

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
            key = "panDESKTOP-GPRFEQ9DESKTOP-GPRFEQ9";
            key = "zhuwbDESKTOP-DQ7BJCLDESKTOP-DQ7BJCL";
            key = "with youDESKTOP-7ABGFO2DESKTOP-7ABGFO2";
        }
        try {
            socket = new Socket();
            //socket.bind(new InetSocketAddress(PropertiesConst.otherPort));//绑定本地端口
            socket.connect(new InetSocketAddress(PropertiesConst.server,PropertiesConst.port));//绑定服务器端口
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
