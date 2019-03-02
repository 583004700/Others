package command.entity;

import util.CmdUtil;

public class Computer {
    public String getKey(){
        String key = CmdUtil.execCloseReturnStr("echo %username%")+CmdUtil.execCloseReturnStr("hostname");
        key = key.replaceAll("\n","").replaceAll("\r\n","");
        return key;
    }
}
