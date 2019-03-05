package util;

public class CmdUtil {
    /**
     * 执行命令之后关闭窗口
     * @param cmdStr
     * @return
     * @throws Exception
     */
    public static Process execClose(String... cmdStr) throws Exception {
        String cmdS = "cmd.exe /c "+cmdStr[0];
        for(int i=1;i<cmdStr.length;i++){
            cmdS += " & "+cmdStr[i];
        }
        return Runtime.getRuntime().exec(cmdS);
    }

    /**
     * 执行后关闭窗口，返回执行结果Str
     * @param cmdStr
     * @return
     * @throws Exception
     */
    public static String execCloseReturnStr(String... cmdStr) {
        Process process = null;
        String str = null;
        try {
            process = execClose(cmdStr);
            str = IOUtil.readStr(process.getInputStream(),"GBK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}


