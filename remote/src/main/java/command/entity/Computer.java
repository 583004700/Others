package command.entity;

import util.CmdUtil;

public class Computer {
    public String getKey(){
        String key = CmdUtil.execCloseReturnStr("echo %username%")+CmdUtil.execCloseReturnStr("hostname");
        return key;
    }
}
