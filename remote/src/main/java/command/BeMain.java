package command;

public class BeMain {
    public static void main(String[] args) throws Exception{

        BeSocketClient aSocketClient = new BeSocketClient();
        aSocketClient.connect();
        aSocketClient.start();
    }
}
