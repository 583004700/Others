package command.entity;

import command.PropertiesConst;

import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;

public class Computer extends JPanel {
    private String server = PropertiesConst.server;
    private int port = PropertiesConst.port;

    public void printMessage(String message){
        System.out.println(message);
    }


    public static String genterateKey() {
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        String computerName = map.get("COMPUTERNAME");// 获取计算机名
        String userDomain = map.get("USERDOMAIN");// 获取计算机域名
        String uuid = UUID.randomUUID().toString();

        String key = null;
        key = userName + computerName + userDomain;
        key = key.replaceAll("\n", "").replaceAll("\r\n", "");
        String mac = "";
        try {
            mac = getMACAddress();
        }catch (Exception e){
            e.printStackTrace();
        }
        key = key + mac + uuid;
        return key;
    }


    private static String getMACAddress()throws Exception{
        InetAddress ia = InetAddress.getLocalHost();
        //获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();

        //下面代码是把mac地址拼装成String
        StringBuffer sb = new StringBuffer();

        for(int i=0;i<mac.length;i++){
            if(i!=0){
                sb.append("-");
            }
            //mac[i] & 0xFF 是为了把byte转化为正整数
            String s = Integer.toHexString(mac[i] & 0xFF);
            sb.append(s.length()==1?0+s:s);
        }

        //把字符串所有小写字母改为大写成为正规的mac地址并返回
        return sb.toString().toUpperCase();
    }

    public Socket getSocket() {
        return null;
    }


    public InputStream getInputStream() {
        return null;
    }


    public OutputStream getOutputStream() {
        return null;
    }


    public PrintWriter getPrintWriter() {
        return null;
    }


    public BufferedReader getBufferedReader() {
        return null;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
