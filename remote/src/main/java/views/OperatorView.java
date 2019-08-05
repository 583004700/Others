package views;

import command.PropertiesConst;
import command.entity.Operator;
import handler.Handler;
import handler.resultHandler.ScreenPrintUpHandler;
import thread.ThreadManager;
import util.IOUtil;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.net.SocketTimeoutException;

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

public class OperatorView extends Operator implements Runnable{
    private boolean cmdIng = false;

    private CMDFrame cmdFrame;

    public void connect(){
        super.connect();

        String key = null;
        try {
            ThreadManager.getExecutorService().execute(this);
            Thread.sleep(100);

            submitCommand(Handler.LIST+Handler.separator);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(){
        cmdFrame = new CMDFrame();
        cmdFrame.addActionListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String readStr = cmdFrame.getLastRowContent();
                    if(!cmdIng){
                        submitCommand(readStr);
                    }else{
                        waitReading();
                    }

                    if(readStr.equals(Handler.CMDBEGIN+Handler.separator)){
                        cmdIng = true;
                    }else if(readStr.equals(Handler.CMDEND+Handler.separator)){
                        cmdIng = false;
                        cmdFrame.appendContentLn("cmd已退出");
                    }
                }
                if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_ALT){
                    reConnect();
                }
            }
        });
    }

    /**
     * 重新连接
     */
    public void reConnect(){
        cmdIng = false;
        closeConnection();
        connect();
    }

    @Override
    public void waitReading() {
        String readStr = cmdFrame.getLastRowContent();
        if(readStr.equals(Handler.CMDBEGIN+Handler.separator)){
            return;
        }
        getPrintWriter().println(readStr);
        getPrintWriter().flush();
    }

    @Override
    public void printMessage(String message) {
        cmdFrame.appendContentLn(message);
    }

    public static void main(String[] args) {
        OperatorView operatorComputer = new OperatorView();
    }

    public void run() {
        BufferedReader br = null;
        br = IOUtil.wrapBufferedReader(getInputStream(),PropertiesConst.appEncoding);
        while(true){
            String result = null;
            try {
                result = br.readLine();
                cmdFrame.appendContentLn(result);
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
                cmdFrame.setTitle("未连接");
                cmdFrame.appendContentLn("连接已断开，请重新连接");
                break;
            }
        }
    }

    public CMDFrame getCmdFrame() {
        return cmdFrame;
    }

    public void setCmdFrame(CMDFrame cmdFrame) {
        this.cmdFrame = cmdFrame;
    }
}
