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

public class Operator extends Computer{
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;

    public Operator(){
        init();
        connect();
    }

    public void connect(){
        try {
            socket = new Socket();
            //socket.bind(new InetSocketAddress(PropertiesConst.otherPort));//绑定本地端口
            socket.connect(new InetSocketAddress(PropertiesConst.server, PropertiesConst.port));//绑定服务器端口
            System.out.println("连接服务器成功!!!\nlist:连接列表\noperate:key 选择连接");
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            bufferedReader = IOUtil.wrapBufferedReader(inputStream, PropertiesConst.appEncoding);
            printWriter = IOUtil.wrapPrintWriter(outputStream, PropertiesConst.appEncoding);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void init(){}

    public void closeConnection(){
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (socket != null) {
                socket.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void waitReading(){}

    public void submitCommand(String completeCommand){
        OperatorExecutor operatorExecutor = new OperatorExecutor(this,completeCommand);
        if((Handler.CMDBEGIN+Handler.separator).equals(completeCommand)){
            operatorExecutor.execute();
        }else {
            ThreadManager.getExecutorService().execute(operatorExecutor);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }
}
