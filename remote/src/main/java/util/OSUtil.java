package util;

public class OSUtil {
    /**
     * 判断当前系统是否是linux
     * @return
     */
    public static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0;
    }
}
