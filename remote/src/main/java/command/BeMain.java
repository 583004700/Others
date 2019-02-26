package command;

public class BeMain {
    public static void main(String[] args) throws Exception{

        BeSocketClient aSocketClient = new BeSocketClient();
        aSocketClient.connect();
        aSocketClient.sendMessage("\n");
        System.out.println("连接成功");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
