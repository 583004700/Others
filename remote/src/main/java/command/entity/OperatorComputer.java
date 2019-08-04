package command.entity;

import command.PropertiesConst;
import handler.Handler;
import handler.resultHandler.ScreenPrintUpHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.io.BufferedReader;
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

public class OperatorComputer extends Operator implements Runnable{

    @Override
    public void connect() {
        super.connect();
        String key = null;
        try {
            ThreadManager.getExecutorService().execute(this);
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

    public void waitReading(){
        String readStr = "";
        while(true){
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\n");
            readStr = scanner.next();
            getPrintWriter().println(readStr);
            getPrintWriter().flush();
            //先告诉对方关闭cmd控制台再退出
            if((Handler.CMDEND+Handler.separator).equals(readStr)){
                break;
            }
        }
        System.out.println("cmd命令已退出");
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        OperatorComputer operatorComputer = new OperatorComputer();
    }

    public void run() {
        BufferedReader br = null;
        br = IOUtil.wrapBufferedReader(getInputStream(),PropertiesConst.appEncoding);
        while(true){
            String result = null;
            try {
                result = br.readLine();
                System.out.println(result);
                if(result!=null && result.contains(Handler.screenPrintUp)){
                    //如果是screenPrintUp方法，还需要上传图片到本机
                    ScreenPrintUpHandler printUpHandler = new ScreenPrintUpHandler(this,result);
                    ThreadManager.getExecutorService().execute(printUpHandler);
                }else if(result!=null && result.contains(Handler.receiveSuccess)){
                    //如果成功接收到文件
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
