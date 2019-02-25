package command;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

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
    public static String execCloseReturnStr(String... cmdStr) throws Exception {
        Process process = execClose(cmdStr);
        StringBuffer b = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("GBK")));
            String line = null;
            while ((line = br.readLine()) != null) {
                b.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b.toString();
    }

    public static void main(String[] args) throws Exception {
        String result = execCloseReturnStr("d:","dir");
        System.out.println(result);
    }
}
