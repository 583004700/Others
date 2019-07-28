package command.entity;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Map;

public class Computer {
    public static String getKey() {
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        String computerName = map.get("COMPUTERNAME");// 获取计算机名
        String userDomain = map.get("USERDOMAIN");// 获取计算机域名

        String key = null;
        key = userName + computerName + userDomain;
        key = key.replaceAll("\n", "").replaceAll("\r\n", "");
        String mac = "";
        try {
            mac = getMACAddress();
        }catch (Exception e){
            e.printStackTrace();
        }
        key = key + mac;
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
}
