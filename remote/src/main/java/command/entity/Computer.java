package command.entity;

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
        return key;
    }

}
