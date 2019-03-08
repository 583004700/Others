package util;

import command.PropertiesConst;

import java.io.File;
import java.io.IOException;

public class CmdUtil {
    /**
     * 执行命令之后关闭窗口
     * @param cmdStr
     * @return
     * @throws Exception
     */
    public static Process execClose(String... cmdStr) throws Exception {
        String[] pre = new String[3];
        pre[0] = "cmd.exe";
        pre[1] = "/c";
        if(OSUtil.isLinux()){
            pre[0] = "/bin/sh";
            pre[1] = "-c";
        }
        String cmdS = cmdStr[0];
        for(int i=1;i<cmdStr.length;i++){
            cmdS += " & "+cmdStr[i];
        }
        pre[2] = cmdS;
        return Runtime.getRuntime().exec(pre);
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
            str = IOUtil.readStr(process.getInputStream(), PropertiesConst.cmdEncoding);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static Process getProcess(){
        Process process = null;
        try {
            if(OSUtil.isLinux()){
                try {
                    process = Runtime.getRuntime().exec("superuser");
                }catch (Exception e){
                    try {
                        process = Runtime.getRuntime().exec("su");
                    }catch (Exception e1){
                        ProcessBuilder pb = new ProcessBuilder("/system/bin/sh");
                        pb.directory(new File("/system/bin"));// 设置shell的当前目录。
                        process = pb.start();
                    }
                }
            }else{
                process = Runtime.getRuntime().exec("cmd");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return process;
    }
}


