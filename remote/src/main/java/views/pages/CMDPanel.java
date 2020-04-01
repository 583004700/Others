package views.pages;

import command.PropertiesConst;
import command.entity.Operator;
import handler.Handler;
import handler.resultHandler.ScreenPrintUpHandler;
import thread.ThreadManager;
import util.IOUtil;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CMDPanel extends Operator implements Runnable{
    //内容输入区
    private JTextArea contentInput;

    private List<String> inputs;

    private CMDFrame cmdFrame;

    private String currentConnectKey = "";

    public static Map<String,String> ylj = new ConcurrentHashMap<String, String>();

    public CMDPanel(CMDFrame cmdFrame){
        this.cmdFrame = cmdFrame;
        this.setLayout(new BorderLayout());
        contentInput.setForeground(Color.BLACK);
        contentInput.setFont(new Font("宋体", Font.PLAIN,16));
        JScrollPane jspSrc = new JScrollPane(contentInput);
        this.add(jspSrc);
    }


    /**
     * 追加内容
     * @param content
     */
    public void appendContent(String content){
        if(content == null){
            content = "";
        }
        contentInput.append(content);
        contentInput.setCaretPosition(contentInput.getText().length());
    }

    /**
     * 追加内容并换行
     */
    public void appendContentLn(String content){
        content = content+"\n";
        appendContent(content);
    }

    /**
     * 得到最后一条输入的内容
     * @return
     */
    public String getLastRowContent(){
        return inputs.get(inputs.size()-1);
    }

    public JTextArea getContentInput() {
        return contentInput;
    }

    public void setContentInput(JTextArea contentInput) {
        this.contentInput = contentInput;
    }

    public List<String> getInputs() {
        return inputs;
    }

    public void setInputs(List<String> inputs) {
        this.inputs = inputs;
    }

    /**
     * 连接相关的内容
     */
    private boolean cmdIng = false;

    public void connect(){
        super.connect();

        String key = null;
        try {
            ThreadManager.getExecutorService().execute(this);
            Thread.sleep(100);

            //submitCommand(Handler.LIST+Handler.separator);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 这个给父类的构造方法第一行调用，所以在对象创建之前执行
     */
    public void init(){
        contentInput = new JTextArea();
        inputs = new ArrayList<String>();

        contentInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String text = contentInput.getText();
                    if(text.endsWith("\n")){
                        inputs.add("");
                    }else{
                        String[] arrStr = text.split("\n");
                        inputs.add(arrStr[arrStr.length - 1]);
                    }
                }
            }
        });

        contentInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String readStr = getLastRowContent();
                    if(!cmdIng){
                        submitCommand(readStr);
                    }else{
                        waitReading();
                    }

                    if(readStr.equals(Handler.CMDBEGIN+Handler.separator)){
                        cmdIng = true;
                    }else if(readStr.equals(Handler.CMDEND+Handler.separator)){
                        cmdIng = false;
                        appendContentLn("cmd已退出");
                    }
                }
                if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_ALT){
                    closeConnection();
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
        String readStr = this.getLastRowContent();
        if(readStr.equals(Handler.CMDBEGIN+Handler.separator)){
            return;
        }
        getPrintWriter().println(readStr);
        getPrintWriter().flush();
    }

    @Override
    public void printMessage(String message) {
        this.appendContentLn(message);
    }

    public void run() {
        BufferedReader br = null;
        br = IOUtil.wrapBufferedReader(getInputStream(), PropertiesConst.appEncoding);
        while(true){
            String result = null;
            try {
                result = br.readLine();
                this.appendContentLn(result);
                if(result != null) {
                    if (result.contains(Handler.screenPrintUp)) {
                        //如果是screenPrintUp方法，还需要上传图片到本机
                        ScreenPrintUpHandler printUpHandler = new ScreenPrintUpHandler(this, result);
                        ThreadManager.getExecutorService().execute(printUpHandler);
                    } else if (result.contains(Handler.receiveSuccess)) {
                        //如果成功接收到文件
                    } else if (result.contains("已连接:")) {
                        this.setConnected(true);
                        currentConnectKey = result.replaceAll("已连接:", "");
                        ylj.put(currentConnectKey, currentConnectKey);
                        this.setName(result);
                        changeCurrentTabTitle(result);
                    } else if (result.startsWith(Handler.returnList)) {
                        OpenSessionFrame openSessionFrame = new OpenSessionFrame(this, result.replaceAll(Handler.returnList, ""));
                    }
                }
            }catch (SocketTimeoutException s){
                result = "";
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(result == null){
                this.setConnected(false);
                this.setName("未连接");
                changeThisTabTitle("未连接");
                this.appendContentLn("连接已断开，请重新连接");
                ylj.remove(currentConnectKey);
                currentConnectKey = "";
                reConnect();
                break;
            }
        }
    }

    public void changeThisTabTitle(String title){
        for(int i=0;i<cmdFrame.getjTabbedPane().getComponentCount();i++) {
            CMDPanel t = (CMDPanel) cmdFrame.getjTabbedPane().getComponentAt(i);
            if(t == this){
                cmdFrame.getjTabbedPane().setTitleAt(i,title);
            }
        }
    }

    /**
     * 修改当前选中的选项卡标题
     * @param title
     */
    public void changeCurrentTabTitle(String title){
        cmdFrame.getjTabbedPane().setTitleAt(cmdFrame.getjTabbedPane().getSelectedIndex(),title);
    }

    public String getCurrentConnectKey() {
        return currentConnectKey;
    }

    public void setCurrentConnectKey(String currentConnectKey) {
        this.currentConnectKey = currentConnectKey;
    }

    public CMDFrame getCmdFrame() {
        return cmdFrame;
    }
}
