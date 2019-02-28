package command;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesConst {
    public static String server;
    public static int port;

    static{
        Properties properties = null;
        try {
            InputStream inputStream = PropertiesConst.class.getClassLoader().getResourceAsStream("config.properties");
            properties = new Properties();
            properties.load(inputStream);
            server = (String)properties.get("server");
            port = Integer.valueOf((String)properties.get("port"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
