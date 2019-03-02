package command.entity;

import command.CmdUtil;

public class Computer {
    public String getKey(){
        String key = CmdUtil.execCloseReturnStr("echo %username%")+CmdUtil.execCloseReturnStr("hostname");
        return key;
    }
}
