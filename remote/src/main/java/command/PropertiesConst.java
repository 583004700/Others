package command;

import util.OSUtil;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesConst {
    public static String server;
    public static int port = 25558;
    public static String appEncoding;
    public static String cmdEncoding;
    public static String consoleEncoding;
    public static long timeOut = 1000;
//    public static int otherPort = 9999;
//    public static int operatorPort = 9998;
    public static int serverLocalPort = 8867;

    static {
        Properties properties = null;
        try {
            InputStream inputStream = PropertiesConst.class.getClassLoader().getResourceAsStream("config.properties");
            properties = new Properties();
            properties.load(inputStream);
            server = (String) properties.get("server");
            port = Integer.valueOf((String) properties.get("port"));
            appEncoding = (String) properties.get("appencoding");
            cmdEncoding = (String) properties.get("cmdencoding");
            if(OSUtil.isLinux()){
                cmdEncoding = "UTF-8";
            }
            consoleEncoding = (String) properties.get("consoleencoding");
            timeOut = Long.valueOf((String)properties.get("timeOut"));
//            otherPort = Integer.valueOf((String)properties.get("otherPort"));
//            operatorPort = Integer.valueOf((String)properties.get("operatorPort"));
            serverLocalPort = Integer.valueOf((String)properties.get("serverLocalPort"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
