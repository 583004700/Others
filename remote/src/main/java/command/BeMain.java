package command;

public class BeMain {
    public static void main(String[] args) throws Exception{
        //在启动时指定虚拟机参数 java -jar -Dfile.encoding=UTF-8
        System.out.println("编码"+System.getProperty("file.encoding"));
        BeSocketClient aSocketClient = new BeSocketClient();
        aSocketClient.connect();
        aSocketClient.start();
    }
}
