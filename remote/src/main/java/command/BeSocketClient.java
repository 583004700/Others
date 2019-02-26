package command;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class BeSocketClient {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;


    public void connect(){
        try {
            Thread.sleep(1000);
            socket = new Socket("127.0.0.1",8867);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        }catch (ConnectException e){
            if(socket == null){
                connect();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String message){
        try {
            outputStream.write(message.getBytes());
        }catch (Exception e){
            e.printStackTrace();
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
}
